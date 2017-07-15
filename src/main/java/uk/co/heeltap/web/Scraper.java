package uk.co.heeltap.web;

import org.jsoup.nodes.Document;

public interface Scraper<T> {
	
	String getNextLink(Document document);
	T getObject(Document document);

}
