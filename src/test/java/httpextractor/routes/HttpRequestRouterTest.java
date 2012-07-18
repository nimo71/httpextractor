package httpextractor.routes;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import httpextractor.*;
import httpextractor.handlers.RequestHandler;

import javax.servlet.http.HttpServletRequest;

import org.hamcrest.Matchers;
import org.junit.*;
import org.mockito.Mock;

public class HttpRequestRouterTest implements Routes {

	@Mock
	private HttpServletRequest servletRequest;
	private Request request;
	private HttpRequestRouter router;
	
	@Before
    public void beforeEachTest() {
		request = new Request(servletRequest);
		router = new HttpRequestRouter(this);
	}
	
	@Test
	public void requestingAnUnknownRoute() {
		RequestHandler handler = router.route(request);
		assertThat(handler, Matchers.is(HttpRequestRouter.UNKNOWN_ROUTE_HANDLER));
	}
	
	@Test 
	public void unknownRoutHandlerReturnsAnUnknownResponse() {
		Response response = HttpRequestRouter.UNKNOWN_ROUTE_HANDLER.handle(request);
		assertThat(response, is(instanceOf(NotFoundResponse.class)));
	}

	@Override
	public void declare(Router router) {
		// no routes declared
	}

}
