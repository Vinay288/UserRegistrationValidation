package UserRegistrationWithValidationTest;

public class PhoneNumberValidationException extends RuntimeException {

	enum PhoneNumberExceptionType {
		PHONENUMBER_INVALID, PHONENUMBER_NULL, PHONENUMBER_EMPTY
	}

	PhoneNumberExceptionType type;

	public PhoneNumberValidationException(PhoneNumberExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}
