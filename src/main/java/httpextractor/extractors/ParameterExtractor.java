package httpextractor.extractors;

import httpextractor.Request;
import httpextractor.extractors.result.*;

public class ParameterExtractor implements RequestExtractor<String> {
	private final String name;
	
	public ParameterExtractor(String name) {
		this.name = name;
	}

	public Optional<String> extract(Request req) {
		String value = req.param(name);
		return ResultFactory.fromNullable(value);
	}
}