package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.Manufacturer;

public interface ManufacturerService {
    
    List<Manufacturer> findAll();
    
    void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException;
    
    Manufacturer byName(String manufacturerName);

    boolean doesManufacturerExists(String manufacturerName);
    
}
