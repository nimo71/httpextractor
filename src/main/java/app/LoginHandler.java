package app;

import static httpextractor.extractors.RequestExtractors.*;

import com.google.common.base.Optional;

import httpextractor.*;
import httpextractor.domain.Email;
import httpextractor.extractors.result.Validity;
import httpextractor.handlers.RequestHandler;

public class LoginHandler implements RequestHandler {

	public Response handle(Request req) {
		Validity<Email> email = emailParam("email", req); 
		String emailStr = (email.isPresent()) ? email.get().toString() : "";
		return new HtmlResponse(
				"<html><head></head>" +
						"<body>" +
							"<h1>Index</h1>" +
							"<form action=\"\\login\" method=\"post\">" +
								"<label>Email:</label>" +
								"<input type=\"text\" name=\"email\" value=\"" + emailStr + "\"/>" +
								"<label>Password:</label>" +
								"<input type=\"password\" name=\"password\"/>" +
								"<input type=\"submit\" value=\"Login\"/>" +
							"</form>" +
						"</body>" +
				"</html>");
	}

}
