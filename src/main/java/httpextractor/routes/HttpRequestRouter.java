package httpextractor.routes;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Optional;

import matchers.RequestMatcher;
import httpextractor.Request;
import httpextractor.handlers.RequestHandler;
import httpextractor.routes.*;

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
			if (route.match(req)) return Optional.of(route.handler());
		}
		return Optional.<RequestHandler>absent();
	}

}
