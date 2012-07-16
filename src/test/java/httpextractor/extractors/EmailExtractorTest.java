package httpextractor.extractors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import httpextractor.Request;
import httpextractor.domain.Email;
import httpextractor.extractors.result.Validity;

import org.junit.*;
import org.mockito.*;

public class EmailExtractorTest {
	private static final String PARAMETER_NAME = "email";
	private static final String VALID_EMAIL_ADDRESS = "name@domain.com";
	private static final String INVALID_EMAIL_ADDRESS = "namedomaincom";
	
	@Mock
	private Request req;

	@Before
	public void beforeEachTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void extractAbsentIfTheEmailDoesNotExist() {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(null);

		Validity<Email> email = RequestExtractors.emailParam(PARAMETER_NAME, req);
		assertThat(email.isPresent(), not(true));
	}

	@Test
	public void extractValidIfTheEmailIsValid() {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(VALID_EMAIL_ADDRESS);
		
		Validity<Email> email = RequestExtractors.emailParam(PARAMETER_NAME, req);
		assertTrue(email.isPresent());
		assertTrue(email.isValid());
		assertThat(email.get().toString(), equalTo("name@domain.com"));
	}
	
	@Test
	public void extractInvalidIfTheEmailIsInvalid() {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(INVALID_EMAIL_ADDRESS);
		
		Validity<Email> email = RequestExtractors.emailParam(PARAMETER_NAME, req);
		assertTrue(email.isPresent());
		assertFalse(email.isValid());
		assertThat(email.getInvalid(), equalTo("namedomaincom"));
	}
}
