package httpextractor.routes;

import httpextractor.Request;
import httpextractor.extractors.result.*;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

import java.util.*;

public class HttpRequestRouter implements Router {

	private List<Route> routes = new ArrayList<Route>(); 
	
	public HttpRequestRouter(Routes routes) {
		routes.declare(this);
	}

	public Router bind(RequestHandler handler, RequestMatcher... matchers) {
		routes.add(new Route(handler, matchers));
		return this;
	}
	
	public Optional<RequestHandler> route(Request req) {
		for (Route route : routes) {
			if (route.match(req)) return ResultFactory.present(route.handler());
		}
		return ResultFactory.<RequestHandler>absent();
	}

}
