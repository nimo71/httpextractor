package app;

import httpextractor.*;
import httpextractor.domain.Email;
import httpextractor.extractors.result.*;
import httpextractor.handlers.RequestHandler;

public class IndexHandler implements RequestHandler {

	@Override
	public Response handle(Request req) {
		return new HtmlResponse(
				IndexHandler.indexHtml((Validity<Email>) ResultFactory.<Email>absent()));
	}

	public static String indexHtml(Validity<Email> email) {
		return "<html><head></head>" +
				"<body>" +
					"<h1>Index</h1>" +
					"<form name=\"login\" action=\"\\login\" method=\"post\">" +
						"<label>Email:</label>" +
						"<input type=\"text\" name=\"email\" value=\"" + email.toString() + "\"/>" +
						errorMessageSnippet(email) +
						"<label>Password:</label>" +
						"<input type=\"password\" name=\"password\"/>" +
						"<input type=\"submit\" value=\"Login\"/>" +
					"</form>" +
				"</body>" +
		"</html>";
	}

	private static String errorMessageSnippet(Validity<Email> email) {
		return (email.isValid()) ? "" : "<span class=\"error\">Invalid Email</span>";
	}

}
