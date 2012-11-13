package de.crowdcode.vehicle.doa.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.crowdcode.vehicle.dao.VehicleDao;
import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.domain.Vehicle;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"/testContext.xml","/applicationContext.xml"})
@ContextConfiguration(locations={"/applicationContext.xml"})
public class VehicleJpaDaoTest {

    @Autowired()
    private VehicleDao dao;
    
    @Autowired
    private DBFixture dbFixture;
    
    @Before
    public void setUp() {
        dbFixture.createDefaultDataInDatabase();
    }
    
    @After
    public void tearDown() {
        dbFixture.removeAll();
    }
    
    @Test
    public void testDependencyInjectionConfiguration() {
        assertNotNull(dao);
    }
    
    @Test
    public void testFindAllVehicles() {
        List<Vehicle> allVehicles = dao.findAll();
        assertEquals("There should be 3 Vehicles in the database", 3, allVehicles.size());
    }
    
    @Test
    public void testFindCheapestVehilce() {
        Vehicle vehicle = dao.findCheapestVehicle();
        assertNotNull("There should be an cheapest vehicle", vehicle);
        assertEquals("The price should be 999.000", 999_000.00, vehicle.getNettoPrice(), 0.0001);
    }
    
    @Test
    public void testFindByEngineTypeDiesel() {
        List<Vehicle> vehicles = dao.findVehiclesByEngineType(EngineType.DIESEL);
        assertNotNull("vehicles should never be null", vehicles);
        assertFalse("Find Vehicles by Engine shouldn't return an empty list", vehicles.isEmpty());
        for (Vehicle vehicle : vehicles) {
            assertEquals("Each vehicle should have an diesel engine", EngineType.DIESEL, vehicle.getEngine().getType());
        }
    }

}
