package httpextractor.extractors;

import httpextractor.Request;

public interface RequestExtractor<T> {
	public T extract(Request req);
}
