package net.bastionsg.dev.fortressapi.errors;

public class IncorrectKeyException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3270966731964653032L;

	// Constructor that accepts a message
    public IncorrectKeyException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public IncorrectKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public IncorrectKeyException(Throwable cause) {
        super(cause);
    }
}
