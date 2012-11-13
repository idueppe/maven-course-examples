package de.crowdcode.vehicle.controller.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import de.crowdcode.vehicle.controller.VehicleController;
import de.crowdcode.vehicle.converter.VehicleConverter;
import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.dto.VehicleDto;
import de.crowdcode.vehicle.service.ApplicationLogService;
import de.crowdcode.vehicle.service.VehicleService;

@Service
public class VehicleControllerBean implements VehicleController {

    @Autowired
    private VehicleService vehicleService;
    
    @Autowired
    private VehicleConverter vehicleConverter;
    
    @Autowired
    private ApplicationLogService log;
    
    @Override
    @Transactional
    public List<VehicleDto> findVehicleByManufacturer(String manufacturerName) {
        List<Vehicle> vehicles = vehicleService.getVehicleByManufacture(manufacturerName);
        return vehicleConverter.convert(vehicles);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public void saveOrUpdateVehicle(VehicleDto vehicleDto) {
        log.log("saving or updating a vehicle...");
        if (vehicleDto.getId() != null) {
            updateExistingVehicle(vehicleDto);
        } else {
            createNewVehicle(vehicleDto);
        }
    }

    private void createNewVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle;
        vehicle = new Vehicle();
        vehicle.setConstructionDate(vehicleDto.getConstructionDate());
        vehicle.setModel(vehicleDto.getModelName());
        
        Engine engine = new Engine();
        engine.setType(vehicleDto.getEngine().getEngineType());
        vehicle.setEngine(engine);
        
        vehicleService.registerVehicle(vehicle);
        vehicleService.addVehicleToManufacturer(vehicleDto.getManufacturerName(), vehicle);
    }

    private void updateExistingVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleDto.getId());
        vehicle.setConstructionDate(vehicleDto.getConstructionDate());
        vehicle.setModel(vehicleDto.getModelName());
    }

    @Override
    public void deleteVehicle(VehicleDto vehicle) {
        // TODO Bitte implementiert diese Methode
    }

}
