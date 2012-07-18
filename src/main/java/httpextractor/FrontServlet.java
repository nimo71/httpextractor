package httpextractor;

import httpextractor.handlers.RequestHandler;
import httpextractor.routes.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class FrontServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private Router router; 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String routesClassName = config.getInitParameter("routes");
		router = RouteFactory.loadRoutes(routesClassName); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Request request = new Request(req);
		Responder responder = new Responder(res);
		
		RequestHandler handler = router.route(request);
		Response response = handler.handle(request);
		responder.apply(response);
	}

}
