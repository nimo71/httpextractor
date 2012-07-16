package app;

import httpextractor.*;
import httpextractor.handlers.RequestHandler;

public class IndexHandler implements RequestHandler {

	@Override
	public Response handle(Request req) {
		return new HtmlResponse(IndexHandler.indexHtml(""));
	}

	public static String indexHtml(String emailStr) {
		return "<html><head></head>" +
				"<body>" +
					"<h1>Index</h1>" +
					"<form name=\"login\" action=\"\\login\" method=\"post\">" +
						"<label>Email:</label>" +
						"<input type=\"text\" name=\"email\" value=\"" + emailStr + "\"/>" +
						"<span class=\"error\">Invalid Email</span>" +
						"<label>Password:</label>" +
						"<input type=\"password\" name=\"password\"/>" +
						"<input type=\"submit\" value=\"Login\"/>" +
					"</form>" +
				"</body>" +
		"</html>";
	}

}
