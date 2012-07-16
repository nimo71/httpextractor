package app;

import httpextractor.*;
import httpextractor.handlers.RequestHandler;

public class IndexHandler implements RequestHandler {

	public Response handle(Request req) {
		return new HtmlResponse(
				"<html><head></head>" +
					"<body>" +
						"<h1>Index</h1>" +
						"<form action=\"\\login\" method=\"post\">" +
							"<label>Email:</label>" +
							"<input type=\"text\" name=\"email\"/>" +
							"<label>Password:</label>" +
							"<input type=\"password\" name=\"password\"/>" +
							"<input type=\"submit\" value=\"Login\"/>" +
						"</form>" +
					"</body>" +
				"</html>");
	}

}
