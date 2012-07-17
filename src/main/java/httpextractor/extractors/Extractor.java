package httpextractor.extractors;

import httpextractor.Request;
import httpextractor.extractors.result.*;

public abstract class Extractor<T> implements RequestValidityExtractor<T> {

	private final String parameterName;
	
	public Extractor(String parameterName) {
		this.parameterName = parameterName;
	}
	
	@Override
	public final Validity<T> extract(Request req) {
		Optional<String> value = RequestExtractors.param(parameterName, req);
	
		if (!value.isPresent())
			return (Validity<T>) ResultFactory.<T>absent();
	
		if (isValid(value.get()))
			return ResultFactory.<T> valid(parse(value.get()));
	
		return new Invalid<T>(value.get());
	}
	
	public abstract T parse(String value);
	
	@Override
	public abstract Boolean isValid(String value);

}
