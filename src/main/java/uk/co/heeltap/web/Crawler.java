package uk.co.heeltap.web;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler<T> {
	
	private Scraper<T> scraper;
	
	public Crawler(Scraper<T> scraper) {
		this.scraper = scraper;
	}

	public void getPage(String url, List<T> objects) throws IOException {
		if (url == null) {
			return;
		}
		Document document = Jsoup.connect(url).get();
		objects.add(scraper.getObject(document));
		getPage(scraper.getNextLink(document), objects);
	}
}
