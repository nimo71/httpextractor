package httpextractor.extractors;

import httpextractor.Request;

import com.google.common.base.Optional;

public class ParameterExtractor implements RequestExtractor<String> {
	private final String name;
	
	public ParameterExtractor(String name) {
		this.name = name;
	}

	public Optional<String> extract(Request req) {
		String value = req.param(name);
		return Optional.fromNullable(value);
	}
}