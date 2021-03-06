package UserRegistrationWithValidationTest;

public class FirstNameValidationException extends RuntimeException {

	enum FirstNameExceptionType {
		FIRSTNAME_NULL, FIRSTNAME_EMPTY,FIRSTNAME_INVALID
	}

	FirstNameExceptionType type;

	public FirstNameValidationException(FirstNameExceptionType type ,String message) {
		super(message);
		this.type=type;
	}

}
