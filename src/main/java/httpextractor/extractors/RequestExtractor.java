package httpextractor.extractors;


import httpextractor.Request;

public interface RequestExtractor<T> {
	
	public Optional<T> extract(Request req);
	
}
