package app;

import static matchers.RequestMatchers.*;

import httpextractor.handlers.RequestHandler;
import httpextractor.routes.*;

public class ApplicationRoutes implements Routes {

	public void declare(Router router) {
		RequestHandler indexHandler = new IndexHandler();
		router
			.bind(indexHandler, GET, path("/"))
			.bind(indexHandler, GET, path("/index"))
			.bind(new LoginHandler(), POST, path("/login"));
	}
}
