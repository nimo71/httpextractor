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

	public void success(Response response) {
		servletResponse.setStatus(HttpServletResponse.SC_OK);
		this.servletResponse.setContentType(response.contentType());
		writer.print(response.body());
	}

	public void notFound() {
		servletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
	}

}
