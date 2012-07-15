package httpextractor;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ExtractorServer {

	public static void main(String[] args) throws Exception
    {
		Server server = new Server(8080);
		 
//        WebAppContext webapp = new WebAppContext();
//        webapp.setDescriptor("/WEB-INF/web.xml");
//        webapp.setResourceBase("../httpextractor/src/main/webapp");
//        webapp.setContextPath("/");
//        webapp.setParentLoaderPriority(true);
 
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        
        ServletHolder holder = new ServletHolder(new FrontServlet());
        holder.setInitParameter("routes", "app.ApplicationRoutes");
        context.addServlet(holder, "/*");
 
        //ContextHandlerCollection contexts = new ContextHandlerCollection();
        //contexts.setHandlers(new Handler[] { context, webapp });
 
        server.setHandler(context);
 
        server.start();
        server.join();
    }

}
