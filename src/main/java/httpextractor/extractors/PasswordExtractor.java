package httpextractor.extractors;

import httpextractor.domain.Password;

public class PasswordExtractor 
	extends Extractor<Password> 
	implements RequestValidityExtractor<Password> {

	public PasswordExtractor(String paramName) {
		super(paramName);
	}

	@Override
	public Boolean isValid(String value) {
		return !value.contains(" ") 
				&& value.length() <= 20
				&& value.length() > 5;
	}

	@Override
	public Password parse(String value) {
		return new Password(value);
	}

}
