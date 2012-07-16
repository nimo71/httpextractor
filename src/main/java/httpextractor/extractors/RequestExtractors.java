package httpextractor.extractors;

import httpextractor.Request;
import httpextractor.domain.Email;
import httpextractor.extractors.result.*;

public class RequestExtractors {
	
	public static Optional<String> param(final String name, final Request request) {
		RequestExtractor<String> stringExtractor = new ParameterExtractor(name);
		return stringExtractor.extract(request);
	}
	
	public static Validity<Email> emailParam(final String name, final Request request) {
		RequestValidityExtractor<Email> emailExtractor = new EmailExtractor(name);
		return emailExtractor.extract(request);
	}
}