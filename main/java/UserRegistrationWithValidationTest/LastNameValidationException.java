package UserRegistrationWithValidationTest;

public class LastNameValidationException extends Exception{

	enum LastNameExceptionType {
		LASTNAME_NULL, LASTNAME_EMPTY,LASTNAME_INVALID
	}

	LastNameExceptionType type;

	public LastNameValidationException(LastNameExceptionType type, String message) {
		super(message);
		this.type=type;
	}
}
