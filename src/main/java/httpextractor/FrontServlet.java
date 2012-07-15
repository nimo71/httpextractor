package httpextractor;

import httpextractor.handlers.RequestHandler;
import httpextractor.routes.RouteFactory;
import httpextractor.routes.Router;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.base.Optional;

public class FrontServlet extends HttpServlet 
{
	private final static Log log = LogFactory.getLog(FrontServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private Router router; 
	
	@Override
	public void init(javax.servlet.ServletConfig config) throws ServletException {
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
