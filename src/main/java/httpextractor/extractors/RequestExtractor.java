package httpextractor.extractors;

import com.google.common.base.Optional;

import httpextractor.Request;

public interface RequestExtractor<T> {
	public Optional<T> extract(Request req);
}
