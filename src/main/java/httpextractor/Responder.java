package httpextractor;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

public class Responder {

	private final HttpServletResponse servletResponse;
	private final PrintWriter writer;

	public Responder(HttpServletResponse res) throws IOException {
		this.servletResponse = res;
		writer = this.servletResponse.getWriter();
	}
	
	public void body(String content) {
		servletResponse.setStatus(HttpServletResponse.SC_OK);
		writer.print(content);
	}

	public void redirect(String toUrl) {
		try {
			servletResponse.sendRedirect(toUrl);
		} 
		catch (IOException e) {
			throw new ResponseException("Problem redirecting to " + toUrl, e);
		}
	} 
	
	public void notFound() {
		servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

	public void apply(Response response) {
		this.servletResponse.setContentType(response.contentType());
		response.apply(this);
	}

}
