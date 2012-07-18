package httpextractor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class SendRedirectResponseTest {

	@Test(expected=ResponseException.class)
	public void cannotConstructWithANullUrl() {
		new SendRedirectResponse(null);
	}
	
	@Test
	public void httpContentType() {
		String contentType = new SendRedirectResponse("someUrl").contentType();
		assertThat(contentType, is(HtmlResponse.TEXT_HTML_CHARSET_UTF_8));
	}
	
}
