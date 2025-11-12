package exceptions;

public class PremiyaException extends Exception {
	public PremiyaException(String message) {
		super(message);
	}

	public PremiyaException(String message, Throwable cause) {
		super(message, cause);
	}
}


