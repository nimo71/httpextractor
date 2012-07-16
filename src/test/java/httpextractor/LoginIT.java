package httpextractor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.*;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

public class LoginIT {

	@Test
	public void invalidEmailInLoginShowsError() throws ClientProtocolException, IOException {
		String indexPage = Request.Post("http://localhost:8080/login")
				.bodyForm(Form.form().add("email", "invalidEmail").add("password", "secret").build())
				.execute()
				.returnContent()
				.asString();
		
		assertThat(indexPage, containsString("<span class=\"error\">Invalid Email</span>"));
	}
	@Test
	public void indexPageDoesNotShowErrors() throws ClientProtocolException, IOException {
		String indexPage = Request.Get("http://localhost:8080/index").execute().returnContent().asString();		
		assertThat(indexPage, not(containsString("<span class=\"error\">Invalid Email</span>")));
	}

}
