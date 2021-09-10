
package UserRegistrationWithValidationTest;

import org.junit.Test;

import UserRegistrationWithValidationTest.EmailValidationException.EmailValidationExceptionType;
import UserRegistrationWithValidationTest.PasswordValidationException.PasswordExceptionType;
import UserRegistrationWithValidationTest.PhoneNumberValidationException.PhoneNumberExceptionType;

import org.junit.Assert;

public class UserRegistrationTest {

	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Vinay");
		Assert.assertEquals(true, result);
	}

//
//	public void givenFirstName_WhenNull_ShouldThrowException() {
//		
//	}
	@Test
	public void givenFirstName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Vi");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenStartWithSpecialChars_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("$Vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenStartWithSmallLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Vinayshhshsh");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Hirem");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Hi");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenStartWithSpecialChars_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("$Vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenStartWithSmallLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("hiremath");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateFirstName("Vinayshhshsh");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation("abc.xyz@bl.co.in");
		} catch (EmailValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenNull_ShouldThrowNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation(null);
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_NULL, e.type);
		}
	}

	@Test
	public void givenEmail_WhenNull_ShouldThrowEmptyException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation("");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_EMPTY, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_abc_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation("xyz@bl.co.in");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_bl_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation("abc.xyz@co.in");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_co_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation("abc.xyz@vi");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedOpionalPart_xyz_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation("abc@bl.co.in");
		} catch (EmailValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMissedOpionalPart_in_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation("abc@bl.co");
		} catch (EmailValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMisplaced_Symbol_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation("abcbl.co@.co");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMisplaced_dot_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation("abc.xyz@vico.in.");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.phoneValidation("91 9110473394");
		} catch (PhoneNumberValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPhoneNumber_WhenNull_ShouldThrowNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.phoneValidation(null);
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_NULL, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenEmpty_ShouldThrowNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.phoneValidation("");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_EMPTY, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenNoSpace_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.phoneValidation("919110473394");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_INVALID, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenLengthIsMore_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.phoneValidation("91 911047339454");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.passwordValidation("A1@abcdefgh");

		} catch (PasswordValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenNoCapitalLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("1@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoNumberLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("A@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoSpecialLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("1Aabcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenLessThenEightCharacters_ShouldThrowInvalidException()
			throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("1A@ab");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}

	}

	@Test
	public void givenPassword_WhenNull_ShouldThrowException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation(null);
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_NULL, e.type);
		}
	}

	@Test
	public void givenPassword_WhenEmpty_ShouldThrowException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_EMPTY, e.type);
		}
	}

}
