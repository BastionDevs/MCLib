package net.bastionsg.dev.fortressapi.errors;

public class IncorrectKeyException extends Exception {
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
