package httpextractor.extractors;

import httpextractor.Request;
import httpextractor.extractors.result.Validity;

public interface RequestValidityExtractor<T> {

	public Validity<T> extract(Request req);
	
	public Boolean isValid(String value);
	
}
