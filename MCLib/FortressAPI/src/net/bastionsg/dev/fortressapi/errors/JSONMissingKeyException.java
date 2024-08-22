package net.bastionsg.dev.fortressapi.errors;

public class JSONMissingKeyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1215547952364632870L;

	// Constructor that accepts a message
    public JSONMissingKeyException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public JSONMissingKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts a cause
    public JSONMissingKeyException(Throwable cause) {
        super(cause);
    }
	
}
