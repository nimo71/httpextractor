package httpextractor.routes;

import httpextractor.*;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

import java.util.*;

public class HttpRequestRouter implements Router {

	public static final RequestHandler UNKNOWN_ROUTE_HANDLER = new RequestHandler() {
		@Override public Response handle(Request req) {
			return new NotFoundResponse();
		}
	};

	private final List<Route> routes = new ArrayList<Route>(); 
	
	public HttpRequestRouter(Routes routes) {
		routes.declare(this);
	}

	@Override
	public Router bind(RequestHandler handler, RequestMatcher... matchers) {
		routes.add(new Route(handler, matchers));
		return this;
	}
	
	@Override
	public RequestHandler route(Request req) {
		for (Route route : routes) {
			if (route.match(req)) return route.handler();
		}
		return UNKNOWN_ROUTE_HANDLER;
	}

}
