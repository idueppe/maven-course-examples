package de.crowdcode.vehicle.dao;

public class VehicleDaoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VehicleDaoException() {
    }

    public VehicleDaoException(String message) {
        super(message);
    }

    public VehicleDaoException(Throwable cause) {
        super(cause);
    }

    public VehicleDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleDaoException(String message, Throwable cause, boolean enableSuppression,  boolean writableStackTrace) {
        super(message, cause); //, enableSuppression, writableStackTrace);
    }

}
