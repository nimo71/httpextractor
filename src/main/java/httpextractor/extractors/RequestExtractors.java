package httpextractor.extractors;

import com.google.common.base.Optional;

import httpextractor.Request;
import httpextractor.domain.Email;

public class RequestExtractors {
	
	public static Optional<String> param(final String name, final Request request) {
		RequestExtractor<String> stringExtractor = new ParameterExtractor(name);
		return stringExtractor.extract(request);
	}
	
	public static Optional<Email> emailParam(final String name, final Request request) {
		RequestExtractor<Email> emailExtractor = new EmailExtractor(name);
		return emailExtractor.extract(request);
	}
}