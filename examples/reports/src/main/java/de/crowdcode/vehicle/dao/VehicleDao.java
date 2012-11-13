package de.crowdcode.vehicle.dao;

import java.util.List;

import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;

public interface VehicleDao extends EntityDao<Vehicle> {

    public List<Vehicle> findVehicleByManufacturer(String name);

    public Vehicle findCheapestVehicle();
    
    public List<Vehicle> findVehiclesByEngineType(EngineType engineType);

}
