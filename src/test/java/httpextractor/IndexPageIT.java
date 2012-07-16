package httpextractor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

public class IndexPageIT {

	@Test
	public void test() throws ClientProtocolException, IOException {
		String indexPage = Request.Get("http://localhost:8080/index").execute().returnContent().asString();
		assertThat(indexPage, startsWith("<html><head>"));
		assertThat(indexPage, endsWith("</body></html>"));
		assertThat(indexPage, containsString("<h1>Index</h1>"));
	}

}
