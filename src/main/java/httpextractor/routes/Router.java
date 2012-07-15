package httpextractor.routes;

import com.google.common.base.Optional;

import matchers.RequestMatcher;
import httpextractor.Request;
import httpextractor.handlers.RequestHandler;

public interface Router
{
	Router bind(RequestHandler handler, RequestMatcher... matchers);

	Optional<RequestHandler> route(Request req);
}
