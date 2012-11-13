package de.crowdcode.vehicle.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import de.crowdcode.vehicle.controller.VehicleController;
import de.crowdcode.vehicle.converter.VehicleConverter;
import de.crowdcode.vehicle.doa.jpa.DBFixture;
import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.dto.EngineDto;
import de.crowdcode.vehicle.dto.VehicleDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class VehicleControllerTest {
     
    @Autowired
    private VehicleController vehicleController;
    
    @Autowired
    private DBFixture dbFixture;
    
    @Autowired
    private VehicleConverter vehicleConverter;
    
    @Before
    public void setUp() {
        dbFixture.createDefaultDataInDatabase();
    }
    
    @After
    public void tearDown() {
        dbFixture.removeAll();
    }

    @Test
    public void testConfiguration() {
        assertNotNull(vehicleController);
    }
    
    @Test
    public void testVehicleByManufacturer() {
        List<VehicleDto> vehicles = vehicleController.findVehicleByManufacturer("Buggati");
        assertNotNull("Result list should never be null.", vehicles);
        assertFalse("Vehicle should not be empty", vehicles.isEmpty());
    }
    
    @Test
    public void testUpdateVehicle() {
        Vehicle vehicle = dbFixture.getVehicles().get(0);
        vehicle.setModel("TEST");
        vehicleController.saveOrUpdateVehicle(vehicleConverter.convert(vehicle));
    }
    
    @Test
    public void testCreateNewVehicle() {
        VehicleDto vehicle = new VehicleDto();
        vehicle.setManufacturerName("Buggati");
        vehicle.setConstructionDate(new Date());
        vehicle.setModelName("VEYRON UNIT TEST");
        EngineDto engine = new EngineDto();
        engine.setEngineType(EngineType.DIESEL);
        vehicle.setEngine(engine);
        vehicleController.saveOrUpdateVehicle(vehicle);
        
    }
    
}
