package UserRegistrationWithValidationTest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import UserRegistrationWithValidationTest.EmailValidationException.EmailValidationExceptionType;
import junit.framework.Assert;

@RunWith(Parameterized.class)
public class EmailValidationTest {
	private String givenEmail;
	private boolean expectedResult;
	private UserRegistrationValidator validator;

	public EmailValidationTest(String givenEmail, boolean expectedResult) {
		this.givenEmail = givenEmail;
		this.expectedResult = expectedResult;
	}

	@Before
	public void initialize() {
		validator = new UserRegistrationValidator();
	}

	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] { { "abc@yahoo.com", true }, { "abc-100@yahoo.com", true },
				{ "abc.100@yahoo.com", true }, { "abc111@abc.com", true }, { "abc-100@abc.net", true },
				{ "abc.100@abc.com.au", true }, { "abc@1.com", true }, { "abc@gmail.com.com", true },
				{ "abc+100@gmail.com", true }, { "abc", false }, { "abc@.com.my", false }, { "abc123@gmail.a", false },
				{ "abc123@.com", false }, { "abc123@.com.com", false }, { ".abc@abc.com", false },
				{ "abc()*@gmail.com", false }, { "abc@%*.com", false }, { "abc..2002@gmail.com", false },
				{ "abc.@gmail.com", false }, { "abc@abc@gmail.com", false }, { "abc@gmail.com.1a", false },
				{ "abc@gmail.com.aa.au", false } });
	}

	@Test
	public void test_WhenGivenEmailVariable_ValidateTrueOrFalse() {
		boolean result = false;
		try {
			result = validator.emailValidation(givenEmail);
		} catch (EmailValidationException e) {
			org.junit.Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
		org.junit.Assert.assertEquals(expectedResult, result);
	}
}
