package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;

public interface VehicleService {

	public Vehicle getCheapestVehicle();
	
	public List<Vehicle> getVehicleByManufacture(String name);
	
	public List<Vehicle> getVehiclesByEngineType(EngineType... engineType);
	
	public Vehicle getVehicleById(Long vehicleId);
	
	public Vehicle registerVehicle(Vehicle vehicle);

    public Vehicle addVehicleToManufacturer(String string, Vehicle vehicle);
    
}
