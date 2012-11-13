package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.VehicleDto;

public interface VehicleController {

    public List<VehicleDto> findVehicleByManufacturer(String manufacturerName);
    
    public void saveOrUpdateVehicle(VehicleDto vehicle);
    
    public void deleteVehicle(VehicleDto vehicle);
    
}
