package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.VehicleDto;

public interface VehicleController {

    List<VehicleDto> findVehicleByManufacturer(String manufacturerName);
    
    void saveOrUpdateVehicle(VehicleDto vehicle);
    
    void deleteVehicle(VehicleDto vehicle);
    
}
