
package UserRegistrationWithValidationTest;

import org.junit.Test;

import UserRegistrationWithValidationTest.PasswordValidationException.PasswordExceptionType;

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
		boolean result = validator.emailValidation("abc.xyz@bl.co.in");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_abc_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("vin.xyz@bl.co.in");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_bl_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abc.xyz@vi.co.in");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMissedMandatoryPart_co_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abc.xyz@vi.abc.in");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMissedOpionalPart_xyz_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abc@bl.co.in");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMissedOpionalPart_in_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abc@bl.co");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenEmail_WhenMisplaced_Symbol_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abcbl.co@.co");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenEmail_WhenMisplaced_dot_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.emailValidation("abc.xyz@vico.in.");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.phoneValidation("91 9110473394");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPhoneNumber_WhenNoSpace_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.phoneValidation("919110473394");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenPhoneNumber_WhenLengthIsMore_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.phoneValidation("91 911047339454");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue() throws PasswordValidationException {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("A1@abcdefgh");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenPassword_WhenNoCapitalLetter_ShouldThrowInvalidException() throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("1@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoNumberLetter_ShouldThrowInvalidException() throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("A@abcdefgh");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_INVALID, e.type);
		}
	}

	@Test
	public void givenPassword_WhenNoSpecialLetter_ShouldThrowInvalidException() throws PasswordValidationException {
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
	public void givenPassword_WhenNull_ShouldThrowException() throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation(null);
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_NULL, e.type);
		}
	}

	@Test
	public void givenPassword_WhenEmpty_ShouldThrowException() throws PasswordValidationException {
		try {
			UserRegistrationValidator validator = new UserRegistrationValidator();
			boolean result = validator.passwordValidation("");
		} catch (PasswordValidationException e) {
			Assert.assertEquals(PasswordExceptionType.PASSWORD_EMPTY, e.type);
		}
	}

}
