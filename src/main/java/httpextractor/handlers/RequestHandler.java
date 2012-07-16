package httpextractor.handlers;

import httpextractor.*;

public interface RequestHandler {
	public Response handle(Request req);
}
