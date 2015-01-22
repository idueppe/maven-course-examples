package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.ManufacturerDto;

public interface ManufacturerController {

    ManufacturerDto byName(String manufacturerName);
    
    List<ManufacturerDto> allManufactures();
    
    void addManufacturer(String manufacturerName);
    
    void deleteManufacturer(String manufacturerName);
    
}
