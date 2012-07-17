package httpextractor;

import httpextractor.extractors.result.Optional;
import httpextractor.handlers.RequestHandler;
import httpextractor.routes.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.commons.logging.*;

public class FrontServlet extends HttpServlet 
{
	private final static Log log = LogFactory.getLog(FrontServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private Router router; 
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		if (log.isInfoEnabled()) log.info("init()");
		String routesClassName = config.getInitParameter("routes");
		router = RouteFactory.loadRoutes(routesClassName); 
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (log.isInfoEnabled()) log.info("service()");
		
		Request request = new Request(req);
		Optional<RequestHandler> handler = router.route(request);
		
		Responder responder = new Responder(res);

		if (handler.isPresent()) {
			Response response = handler.get().handle(request);
			responder.success(response);
		}
		else {
			responder.notFound();
		}
	}

}
