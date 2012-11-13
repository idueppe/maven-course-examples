package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.Manufacturer;

public interface ManufacturerService {
    
    public List<Manufacturer> findAll();
    
    public void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException;
    
    public Manufacturer byName(String manufacturerName);

    public boolean doesManufacturerExists(String manufacturerName);
    
}
