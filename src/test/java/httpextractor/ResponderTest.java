package httpextractor;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.junit.*;
import org.mockito.*;

public class ResponderTest {

	@Mock
	private HttpServletResponse servletResponse;
	
	@Mock
	private PrintWriter printWriter;

	private Responder responder;

	@Before
	public void beforeEachTest() throws IOException {
		MockitoAnnotations.initMocks(this);
		when(servletResponse.getWriter()).thenReturn(printWriter);
		responder = new Responder(servletResponse);
	}
	
	@Test
	public void htmlResponseWritesItsBodyToServletResponse() throws IOException {
		Response htmlResponse = new HtmlResponse("html body");
		responder.apply(htmlResponse);
		
		verify(printWriter).print(eq("html body"));
	}
	
	@Test
	public void redirectResponseRedirectsServletResponse() throws IOException {
		String toUrl = "url to redirect to";
		Response redirectResponse = new SendRedirectResponse(toUrl);
		responder.apply(redirectResponse);
		
		verify(servletResponse).sendRedirect(toUrl);
	}
	
	@Test
	public void notFoundResponseSetsCorrectStatusOnServletResponse() throws IOException {
		Response notFoundResponse = new NotFoundResponse();
		responder.apply(notFoundResponse);
		
		verify(servletResponse).setStatus(eq(HttpServletResponse.SC_NOT_FOUND));
	}

	@Test
	public void notFound() throws IOException {
		responder.notFound();
		verify(servletResponse).setStatus(HttpServletResponse.SC_NOT_FOUND);
	}
}
