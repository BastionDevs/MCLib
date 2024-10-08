package net.bastionsg.dev.fortressapi.errors;

public class ExpiredTokenException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7680712294890547412L;

	// Constructor that accepts a message
    public ExpiredTokenException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public ExpiredTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public ExpiredTokenException(Throwable cause) {
        super(cause);
    }
}
