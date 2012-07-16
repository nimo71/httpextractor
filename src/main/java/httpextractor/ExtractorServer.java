package httpextractor;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class ExtractorServer {

	public static void main(String[] args) throws Exception
    {
		Server server = new Server(8080);
		 
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        
        ServletHolder holder = new ServletHolder(new FrontServlet());
        holder.setInitParameter("routes", "app.ApplicationRoutes");
        context.addServlet(holder, "/*");
 
        server.setHandler(context);
 
        server.start();
        server.join();
    }

}
