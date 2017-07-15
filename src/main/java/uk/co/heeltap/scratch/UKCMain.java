package uk.co.heeltap.scratch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uk.co.heeltap.climbing.Route;
import uk.co.heeltap.climbing.RouteFormatter;
import uk.co.heeltap.climbing.UKCScraper;
import uk.co.heeltap.web.Crawler;

public class UKCMain {
	public static void main(String[] args) {
		Crawler<Route> scr = new Crawler<>(new UKCScraper());
		try {
			List<Route> routes = new ArrayList<>();
			scr.getPage("https://www.ukclimbing.com/logbook/c.php?i=404650", routes);
			StringBuffer sb = new StringBuffer();
			sb.append(RouteFormatter.getHeader());
			for(Route route : routes) {
				sb.append(RouteFormatter.format(route));
			}
			sb.append(RouteFormatter.getFooter());
			System.out.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
