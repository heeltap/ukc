package uk.co.heeltap.climbing;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import uk.co.heeltap.web.Scraper;

public class UKCScraper implements Scraper<Route> {

	@Override
	public String getNextLink(Document document) {
		Elements links = document.select("a[href]");
		for (Element link : links) {
			Elements linkChildren = link.select("i.icon-chevron-right");
			if (!linkChildren.isEmpty()) {
				return link.attr("abs:href");				
			}
		}
		
		return null;
	}

	@Override
	public Route getObject(Document document) {
		return new Route(getName(document), getNumStars(document), getGrade(document), getTopo(document));
	}

	private String getName(Document document) {
		Elements headers = document.select("h1");
		Element header = headers.get(1);
		List<Node> children = header.childNodes();
		Node[] nodes = children.toArray(new Node[children.size()]);
		return nodes[0].toString();
	}
	
	private String getTopo(Document document) {
		Element overview = document.getElementById("overview");
		return overview.text();
	}

	private int getNumStars(Document document) {
		Elements headers = document.select("h1");
		Element header = headers.get(1);
		List<Node> children = header.childNodes();
		Node[] nodes = children.toArray(new Node[children.size()]);
		return StringUtils.countMatches(nodes[1].toString(), "<i class=\"icon-star\"></i>");
	}
	
	private String getGrade(Document document) {
		Elements headers = document.select("h1");
		Element header = headers.get(1);
		List<Node> children = header.childNodes();
		Node[] nodes = children.toArray(new Node[children.size()]);
		String str1 = nodes[1].toString().substring(0, nodes[1].toString().lastIndexOf("</small>"));
		String str2 = str1.substring(str1.lastIndexOf(">")+1).trim();
		return str2;
	}
	
}
