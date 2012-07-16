package httpextractor.extractors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import httpextractor.*;
import httpextractor.domain.Email;
import httpextractor.extractors.result.Validity;

import org.junit.*;
import org.mockito.*;

import com.google.common.base.Optional;

public class EmailExtractorTest {
	private static final String PARAMETER_NAME = "email";
	private static final String VALID_EMAIL_ADDRESS = "name@domain.com";
	
	@Mock
	private Request req;

	@Before
	public void beforeEachTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldExtractAbsentIfTheEmailDoesNotExist() {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(null);

		Validity<Email> email = RequestExtractors.emailParam(PARAMETER_NAME, req);
		assertThat(email.isPresent(), not(true));
	}

	@Test
	public void shouldExtractValidIfTheEmailIsValid() {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(VALID_EMAIL_ADDRESS);
		
		Validity<Email> email = RequestExtractors.emailParam(PARAMETER_NAME, req);
		assertThat(email.get().toString(), equalTo("name@domain.com"));
	}
}
