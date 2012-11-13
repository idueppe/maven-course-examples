package de.crowdcode.vehicle.converter;

public class ConversionException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ConversionException() {
        super();
    }

    public ConversionException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConversionException(String message) {
        super(message);
    }

    public ConversionException(Throwable cause) {
        super(cause);
    }
}
