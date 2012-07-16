package app;

import static httpextractor.extractors.RequestExtractors.emailParam;
import httpextractor.*;
import httpextractor.domain.Email;
import httpextractor.extractors.result.Validity;
import httpextractor.handlers.RequestHandler;

public class LoginHandler implements RequestHandler {

	@Override
	public Response handle(Request req) {
		Validity<Email> email = emailParam("email", req); 
		String emailStr = getEmail(email);
		return new HtmlResponse(IndexHandler.indexHtml(emailStr));
	}

	private String getEmail(Validity<Email> email) {
		if (email.isPresent()) {
			if (email.isValid()) 
				return email.get().toString();
			else 
				return email.getInvalid();
		}
		return "";
	}

}
