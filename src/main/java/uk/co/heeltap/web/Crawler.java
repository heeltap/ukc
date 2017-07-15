package uk.co.heeltap.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import uk.co.heeltap.climbing.Route;
import uk.co.heeltap.climbing.RouteFormatter;
import uk.co.heeltap.climbing.UKCScraper;

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
