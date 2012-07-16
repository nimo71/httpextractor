package httpextractor.extractors;

import httpextractor.domain.Email;

import java.util.regex.*;

public class EmailExtractor extends Extractor<Email> implements RequestValidityExtractor<Email> {
	
	private static final String EMAIL_REGEX = ".+@.+\\.[a-z]+";

	public EmailExtractor(String parameterName) {
		super(parameterName);
	}

	@Override
	public Email parse(String value) {
		return new Email(value);
	}

	@Override
	public Boolean isValid(String value) {
		Pattern p = Pattern.compile(EMAIL_REGEX);
		Matcher m = p.matcher(value);
		return m.matches();
	}

}
