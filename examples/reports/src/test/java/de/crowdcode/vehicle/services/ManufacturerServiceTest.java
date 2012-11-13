package de.crowdcode.vehicle.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import de.crowdcode.vehicle.doa.jpa.DBFixture;
import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.service.ManufacturerAlreadyExistsException;
import de.crowdcode.vehicle.service.ManufacturerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ManufacturerServiceTest {
     

    @Autowired
    private ManufacturerService manufacturerService;
    
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
    public void testConfiguration() {
        assertNotNull(manufacturerService);
    }
    
    @Test
    public void testFindAllManufacturer() {
        List<Manufacturer> manufacturers = manufacturerService.findAll();
        assertNotNull("Result list should never be null.", manufacturers);
        assertEquals("There should be two manufacturers.", 2, manufacturers.size());
    }

    @Test
    public void testAddManufacturer() throws ManufacturerAlreadyExistsException {
        String name = "JUNIT MANUFACTURER";
        manufacturerService.addManufacturer(name);
        assertTrue("Manufacturer should exist.", manufacturerService.doesManufacturerExists(name));
    }
    
    @Test(expected=ManufacturerAlreadyExistsException.class)
    public void testAddExistingManufacturer() throws ManufacturerAlreadyExistsException {
        manufacturerService.addManufacturer("VW");
    }
    
    
}
