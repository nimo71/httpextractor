package httpextractor.routes;


import httpextractor.Request;
import httpextractor.extractors.result.Optional;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

public interface Router
{
	Router bind(RequestHandler handler, RequestMatcher... matchers);

	Optional<RequestHandler> route(Request req);
}
