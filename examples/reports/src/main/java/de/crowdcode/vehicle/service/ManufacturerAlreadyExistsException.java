package de.crowdcode.vehicle.service;


public class ManufacturerAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public ManufacturerAlreadyExistsException(String manufacturerName) {
        super("Manufacturer " + manufacturerName + " already exists!");
    }

}
