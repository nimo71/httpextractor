package httpextractor.extractors;

import httpextractor.Request;

public class RequestExtractors {
	
	public static RequestExtractor<String> param(final String name) {
		return new RequestExtractor<String>() {
			public String extract(Request req) {
				return req.param(name);
			}
		};
	}
}
