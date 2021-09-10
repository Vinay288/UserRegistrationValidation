package UserRegistrationWithValidationTest;

public class EmailValidationException extends Exception {
	enum EmailValidationExceptionType {
		EMAIL_INVALID, EMAIL_NULL, EMAIL_EMPTY
	}

	EmailValidationExceptionType type;

	public EmailValidationException(EmailValidationExceptionType type, String message) {
		super(message);
		this.type = type;
	}

}
