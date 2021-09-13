
package UserRegistrationWithValidationTest;

import org.junit.Test;

import UserRegistrationWithValidationTest.UserRegistrationValidator;
import UserRegistrationWithValidationTest.EmailValidationException.EmailValidationExceptionType;
import UserRegistrationWithValidationTest.FirstNameValidationException.FirstNameExceptionType;
import UserRegistrationWithValidationTest.LastNameValidationException.LastNameExceptionType;
import UserRegistrationWithValidationTest.PasswordValidationException.PasswordExceptionType;
import UserRegistrationWithValidationTest.PhoneNumberValidationException.PhoneNumberExceptionType;

import org.junit.Assert;

public class UserRegistrationTest {

	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateFirstName.apply("Vinay");
		} catch (FirstNameValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenFirstName_WhenNull_ShouldThrowNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateFirstName.apply(null);
		} catch (FirstNameValidationException e) {
			Assert.assertEquals(FirstNameExceptionType.FIRSTNAME_NULL, e.type);
		}
	}

	@Test
	public void givenFirstName_WhenEmpty_ShouldThrowEmptyException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateFirstName.apply("");
		} catch (FirstNameValidationException e) {
			Assert.assertEquals(FirstNameExceptionType.FIRSTNAME_EMPTY, e.type);
		}
	}

	@Test
	public void givenFirstName_WhenShort_ShouldInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateFirstName.apply("Vi");
		} catch (FirstNameValidationException e) {
			Assert.assertEquals(FirstNameExceptionType.FIRSTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenFirstName_WhenStartWithSpecialChars_ShouldInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateFirstName.apply("$Vinay");
		} catch (FirstNameValidationException e) {
			Assert.assertEquals(FirstNameExceptionType.FIRSTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenFirstName_WhenStartWithSmallLetter_ShouldInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateFirstName.apply("vinay");
		} catch (FirstNameValidationException e) {
			Assert.assertEquals(FirstNameExceptionType.FIRSTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenFirstName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateFirstName.apply("Vinayshhshsh");
		} catch (FirstNameValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateLastName.apply("Hirem");
		} catch (LastNameValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenNull_ShouldThrownNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateLastName.apply(null);
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_NULL, e.type);
		}
	}

	@Test
	public void givenLastName_WhenEmpty_ShouldThrownNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.validateLastName.apply("");
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_EMPTY, e.type);
		}
	}

	@Test
	public void givenLastName_WhenShort_ShouldInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateLastName.apply("Hi");
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenLastName_WhenStartWithSpecialChars_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateLastName.apply("$Vinay");
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenLastName_WhenStartWithSmallLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateLastName.apply("hiremath");
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenLastName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.validateLastName.apply("Vinayshhshsh");
		} catch (LastNameValidationException e) {
			Assert.assertEquals(LastNameExceptionType.LASTNAME_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation.apply("abc.xyz@bl.co.in");
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
			result = validator.emailValidation.apply(null);
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_NULL, e.type);
		}
	}

	@Test
	public void givenEmail_WhenNull_ShouldThrowEmptyException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation.apply("");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_EMPTY, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_abc_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation.apply("xyz@bl.co.in");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_bl_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation.apply("abc.xyz@co.in");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_co_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation.apply("abc.xyz@vi");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMissedOpionalPart_xyz_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.emailValidation.apply("abc@bl.co.in");
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
			result = validator.emailValidation.apply("abc@bl.co");
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
			result = validator.emailValidation.apply("abcbl.co@.co");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenEmail_WhenMisplaced_dot_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.emailValidation.apply("abc.xyz@vico.in.");
		} catch (EmailValidationException e) {
			Assert.assertEquals(EmailValidationExceptionType.EMAIL_INVALID, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.phoneNumberValidation.apply("91 9110473394");
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
			result = validator.phoneNumberValidation.apply(null);
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_NULL, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenEmpty_ShouldThrowNullException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.phoneNumberValidation.apply("");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_EMPTY, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenNoSpace_ShouldThrowInvalidException() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result;
		try {
			result = validator.phoneNumberValidation.apply("919110473394");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_INVALID, e.type);
		}
	}

	@Test
	public void givenPhoneNumber_WhenLengthIsMore_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.phoneNumberValidation.apply("91 911047339454");
		} catch (PhoneNumberValidationException e) {
			Assert.assertEquals(PhoneNumberExceptionType.PHONENUMBER_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = false;
		try {
			result = validator.passwordValidation.apply("A1@abcdefgh");

		} catch (PasswordValidationException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenNoCapitalLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply("1@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoNumberLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply("A@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoSpecialLetter_ShouldThrowInvalidException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply("1Aabcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenLessThenEightCharacters_ShouldThrowInvalidException()
			throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply("1A@ab");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}

	}

	@Test
	public void givenPassword_WhenNull_ShouldThrowException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply(null);
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_NULL, e.type);
		}
	}

	@Test
	public void givenPassword_WhenEmpty_ShouldThrowException() {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation.apply("");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_EMPTY, e.type);
		}
	}

}
