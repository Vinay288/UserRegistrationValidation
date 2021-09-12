package UserRegistrationWithValidationTest;

public class PasswordValidationException extends RuntimeException {
	enum PasswordExceptionType {
		PASSWORD_NULL, PASSWORD_EMPTY,PASSWORD_INVALID
	}

	PasswordExceptionType type;

	public PasswordValidationException(PasswordExceptionType type, String message) {
		super(message);
		this.type=type;
	}

}
