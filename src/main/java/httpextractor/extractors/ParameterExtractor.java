package httpextractor.extractors;

import httpextractor.Request;

public class ParameterExtractor implements RequestExtractor<String> {
	private final String name;
	
	public ParameterExtractor(String name) {
		this.name = name;
	}

	public Optional<String> extract(Request req) {
		String value = req.param(name);
		return OptionalFactory.fromNullable(value);
	}
}