package httpextractor.routes;

import com.google.common.base.Optional;

import httpextractor.Request;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

public interface Router
{
	Router bind(RequestHandler handler, RequestMatcher... matchers);

	Optional<RequestHandler> route(Request req);
}
