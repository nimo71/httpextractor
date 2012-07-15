package httpextractor.extractors;

import httpextractor.Request;

public interface RequestValidityExtractor<T> {

	public Validity<T> extract(Request req);
	
	public Boolean isValid(String value);
	
}
