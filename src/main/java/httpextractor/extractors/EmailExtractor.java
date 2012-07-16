package httpextractor.extractors;

import com.google.common.base.Function;

import httpextractor.Request;
import httpextractor.domain.Email;
import httpextractor.extractors.result.Invalid;
import httpextractor.extractors.result.Optional;
import httpextractor.extractors.result.Valid;
import httpextractor.extractors.result.Validity;
import httpextractor.extractors.result.ValidityFactory;

public class EmailExtractor implements RequestValidityExtractor<Email> {

	private String parameterName;

	public EmailExtractor(String parameterName) {
		this.parameterName = parameterName;
	}

	@SuppressWarnings("unchecked")
	public Validity<Email> extract(Request req) {
		Optional<String> value = RequestExtractors.param(parameterName, req);
		
		if (!value.isPresent()) return (Validity<Email>) ValidityFactory.<Email>absent();
		
		if (isValid(value.get())) return new Valid<Email>(new Email(value.get()));
		
		return new Invalid<Email>(value.get());
	}

	public Boolean isValid(String value) {
		return true;
	}

}
