package uk.co.heeltap.climbing;

import uk.co.heeltap.web.TableFormatter;

public class RouteFormatter extends TableFormatter{

	public static String format(Route route) {
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		sb.append("<th>").append(route.getName()).append("</th>");
		sb.append("<th>").append(route.getStars()).append("</th>");
		sb.append("<th>").append(route.getGrade()).append("</th>");
		sb.append("</tr><tr>");
		sb.append("<td colspan=\"3\">").append(route.getTopo()).append("</td>");
		sb.append("</tr>");
		return sb.toString();
	}
}
