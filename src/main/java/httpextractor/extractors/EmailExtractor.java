package httpextractor.extractors;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import httpextractor.Request;
import httpextractor.domain.Email;

public class EmailExtractor implements RequestExtractor<Email> {

	private String parameterName;

	public EmailExtractor(String parameterName) {
		this.parameterName = parameterName;
	}

	public Optional<Email> extract(Request req) {
		Optional<String> value = RequestExtractors.param(parameterName, req);
		return value.transform(
				new Function<String, Email>() {
					public Email apply(String emailString) {
						return new Email(emailString);
					}
				});
	}

}
