package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.EngineDto;

public interface EngineController {

    List<EngineDto> byManufacturerName(String manufacturerName);
    
    void addEngine(EngineDto engine);
    
    void deleteEngine(EngineDto engine);
    
}
