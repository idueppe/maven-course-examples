package de.crowdcode.vehicle.service.spi;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.dao.ManufacturerDao;
import de.crowdcode.vehicle.dao.VehicleDao;
import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.service.VehicleService;

@Service
public class VehicleServiceBean implements VehicleService {
    
    @Autowired
    private VehicleDao vehicleDao;
    
    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public Vehicle getCheapestVehicle() {
        return vehicleDao.findCheapestVehicle();
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public List<Vehicle> getVehicleByManufacture(String name) {
        return vehicleDao.findVehicleByManufacturer(name);
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
    public List<Vehicle> getVehiclesByEngineType(EngineType... engineType) {
        List<Vehicle> vehicles = new LinkedList<Vehicle>();
        for (EngineType type : engineType) {
            vehicles.addAll(vehicleDao.findVehiclesByEngineType(type));
        }
        
        return vehicles;
    }

    @Override
    @Transactional
    public Vehicle registerVehicle(Vehicle vehicle) {
        vehicleDao.create(vehicle);
        return vehicle;
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
	public Vehicle addVehicleToManufacturer(final String manufacturerName,
			final Vehicle vehicle) {
		Vehicle updatedVehicle = vehicle;
        Manufacturer manufacturer = manufacturerDao.findManufacturerByName(manufacturerName);
        if (vehicle.getId() != null) {
			updatedVehicle = vehicleDao.update(vehicle);
        }
        manufacturer.addVehicle(vehicle);
		return updatedVehicle;
    }

    @Override
    @Transactional(propagation=Propagation.SUPPORTS)
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleDao.find(vehicleId);
    }

}
