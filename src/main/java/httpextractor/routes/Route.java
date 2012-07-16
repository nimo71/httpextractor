package httpextractor.routes;

import httpextractor.Request;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

public class Route {
	private final RequestHandler handler; 
	private final RequestMatcher[] matchers;
	
	public Route(RequestHandler handler, RequestMatcher... matchers) {
		this.handler = handler; 
		this.matchers = matchers;
	} 
	
	public Boolean match(Request request) {
		for (RequestMatcher matcher : matchers) {
			if (!request.match(matcher)) return false;
		}
		return true;
	}

	public RequestHandler handler() {
		return handler;
	}
}