
package UserRegistrationWithValidationTest;

import org.junit.Test;

import org.junit.Assert;

public class UserRegistrationTest {
	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Vinay");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenFirstName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Vi");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenStartWithSpecialChars_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("$Vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenStartWithSmallLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenFirstName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Vinayshhshsh");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Hirem");
		Assert.assertEquals(true, result);
	}

	@Test
	public void givenLastName_WhenShort_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Hi");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenStartWithSpecialChars_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("$Vinay");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenStartWithSmallLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("hiremath");
		Assert.assertEquals(false, result);
	}

	@Test
	public void givenLastName_WhenLongAndStartWithCapital_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.validateName("Vinayshhshsh");
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
	public void givenPassword_WhenProper_ShouldReturnTrue() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("A1@abcdefgh");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPassword_WhenNoCapitalLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("1@abcdefgh");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoNumberLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("A@abcdefgh");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoSpecialLetter_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("1Aabcdefgh");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenLessThenEightCharacters_ShouldReturnFalse() {
		UserRegistrationValidator validator = new UserRegistrationValidator();
		boolean result = validator.passwordValidation("1A@ab");
		Assert.assertEquals(false, result);
	}

}
