package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.ManufacturerDto;

public interface ManufacturerController {

    public ManufacturerDto byName(String manufacturerName);
    
    public List<ManufacturerDto> allManufactures();
    
    public void addManufacturer(String manufacturerName);
    
    public void deleteManufacturer(String manufacturerName);
    
}
