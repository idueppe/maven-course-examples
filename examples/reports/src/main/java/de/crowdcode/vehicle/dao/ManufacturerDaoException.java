package de.crowdcode.vehicle.dao;

public class ManufacturerDaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ManufacturerDaoException() {
        super();
    }

    public ManufacturerDaoException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause); //, enableSuppression, writableStackTrace);
    }

    public ManufacturerDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManufacturerDaoException(String message) {
        super(message);
    }

    public ManufacturerDaoException(Throwable cause) {
        super(cause);
    }
    
}
