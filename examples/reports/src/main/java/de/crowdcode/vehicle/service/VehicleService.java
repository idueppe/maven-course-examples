package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;

public interface VehicleService {

	Vehicle getCheapestVehicle();
	
	List<Vehicle> getVehicleByManufacture(String name);
	
	List<Vehicle> getVehiclesByEngineType(EngineType... engineType);
	
	Vehicle getVehicleById(Long vehicleId);
	
	Vehicle registerVehicle(Vehicle vehicle);

    Vehicle addVehicleToManufacturer(String string, Vehicle vehicle);
    
}
