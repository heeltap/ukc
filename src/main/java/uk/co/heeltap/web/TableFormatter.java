package uk.co.heeltap.web;

public class TableFormatter {
	
	public static String getHeader() {
		return "<html><head><style>" + 
				"table, th, td {" + 
				"    border: 1px solid black;" + 
				"    border-collapse: collapse;" +
				"}" +
				"</style></head><body><table>";
	}
	
	public static String getFooter() {
		return "</table></body></html>";
	}

}
