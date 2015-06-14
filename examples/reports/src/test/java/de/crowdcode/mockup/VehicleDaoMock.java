package de.crowdcode.mockup;

import java.util.List;

import de.crowdcode.vehicle.dao.VehicleDao;
import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;

public class VehicleDaoMock implements VehicleDao {

    @Override
    public List<Vehicle> findAll() {
    	// FIXME returns null in all cases
    	// TODO Implement method
        return null;
    }

    @Override
    public Vehicle find(Long id) {
    	// FIXME returns null for all given IDs.
        return null;
    }

    @Override
    public void create(Vehicle entity) {
    	// XXX this mock does not support persistence
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void delete(Vehicle entity) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Vehicle update(Vehicle entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vehicle> findVehicleByManufacturer(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vehicle findCheapestVehicle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vehicle> findVehiclesByEngineType(EngineType engineType) {
        // TODO Auto-generated method stub
        return null;
    }

}
