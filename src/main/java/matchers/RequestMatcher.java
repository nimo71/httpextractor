package matchers;

import httpextractor.Request;

public interface RequestMatcher {
	public Boolean match(Request req);
}
