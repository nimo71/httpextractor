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
		return new HtmlResponse(IndexHandler.indexHtml(email));
	}
}
