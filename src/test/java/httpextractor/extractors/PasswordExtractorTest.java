package httpextractor.extractors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import httpextractor.Request;
import httpextractor.domain.Password;
import httpextractor.extractors.result.Validity;

import org.junit.*;
import org.mockito.*;

public class PasswordExtractorTest {

	private static final String PARAMETER_NAME = "password";

	private static final String VALID_PASSWORD = "validPassword";

	private static final String PASSWORD_WITH_SPACE = "invalid password";

	private static final String PASSWORD_TOO_LONG = "123456789012345678901";

	private static final String PASSWORD_TOO_SHORT = "12345";
	
	@Mock
	private Request req;

	@Before
	public void beforeEachTest() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void extractAbsentIfThePasswordDoesNotExist() {
		Validity<Password> password = extractPasswordValidity(null);
		assertFalse(password.isPresent());
	}
	
	@Test
	public void extractValidIfThePasswordIsValid() {
		assertPresentAndValid(VALID_PASSWORD);
	}
	
	@Test
	public void extractInvalidIfThePasswordContainsSpace() {
		assertPresentAndInvalid(PASSWORD_WITH_SPACE);
	}
	
	@Test
	public void extractInvalidIfThePasswordLengthGreaterThan20() {
		assertPresentAndInvalid(PASSWORD_TOO_LONG);
	}

	@Test
	public void extractInvalidIfThePasswordLengthLessThan6() {
		assertPresentAndInvalid(PASSWORD_TOO_SHORT);
	}

	private void assertPresentAndInvalid(String passwordValue) {
		Validity<Password> password = assertPresent(passwordValue);
		assertFalse(password.isValid());
	}
	
	private void assertPresentAndValid(String passwordValue) {
		Validity<Password> password = assertPresent(passwordValue);
		assertTrue(password.isValid());
	}

	private Validity<Password> assertPresent(String passwordValue) {
		Validity<Password> password = extractPasswordValidity(passwordValue);
		assertTrue(password.isPresent());
		assertThat(password.toString(), equalTo(passwordValue));
		return password;
	}

	private Validity<Password> extractPasswordValidity(String passwordValue) {
		when(req.param(eq(PARAMETER_NAME))).thenReturn(passwordValue);
		return RequestExtractors.passwordParam(PARAMETER_NAME, req);
	}
	
}
