package httpextractor.routes;


import httpextractor.Request;
import httpextractor.handlers.RequestHandler;
import httpextractor.matchers.RequestMatcher;

public interface Router
{
	Router bind(RequestHandler handler, RequestMatcher... matchers);

	RequestHandler route(Request req);
}
