package httpextractor.extractors;


import httpextractor.Request;
import httpextractor.extractors.result.Optional;

public interface RequestExtractor<T> {
	
	public Optional<T> extract(Request req);
	
}
