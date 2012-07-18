package httpextractor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

public class NotFoundResponseTest {

	@Test
	public void httpContentType() {
		String contentType = new NotFoundResponse().contentType();
		assertThat(contentType, is(HtmlResponse.TEXT_HTML_CHARSET_UTF_8));
	}

}
