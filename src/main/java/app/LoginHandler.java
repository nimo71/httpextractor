package app;

import static httpextractor.extractors.RequestExtractors.*;

import httpextractor.*;
import httpextractor.handlers.RequestHandler;

public class LoginHandler implements RequestHandler {

	public Response handle(Request req) {
		String email = req.extract(param("email"));
		return new HtmlResponse(
				"<html><head></head>" +
						"<body>" +
							"<h1>Index</h1>" +
							"<form action=\"\\login\" method=\"post\">" +
								"<label>Email:</label>" +
								"<input type=\"text\" name=\"email\" value=\"" + email + "\"/>" +
								"<label>Password:</label>" +
								"<input type=\"password\" name=\"password\"/>" +
								"<input type=\"submit\" value=\"Login\"/>" +
							"</form>" +
						"</body>" +
				"</html>");
	}

}
