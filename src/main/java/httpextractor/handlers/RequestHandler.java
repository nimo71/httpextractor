package httpextractor.handlers;

import httpextractor.Request;
import httpextractor.Response;

public interface RequestHandler {
	public Response handle(Request req);
}
