package de.crowdcode.vehicle.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import de.crowdcode.vehicle.controller.ManufacturerController;
import de.crowdcode.vehicle.doa.jpa.DBFixture;
import de.crowdcode.vehicle.dto.ManufacturerDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ManufacturerControllerTest {
     
    @Autowired
    private ManufacturerController manufacturerController;
    
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
        assertNotNull(manufacturerController);
    }
    
    @Test
    public void testByName() {
        ManufacturerDto dto = manufacturerController.byName("VW");
        assertEquals("There should be VW.","VW", dto.getName());
        assertEquals("There should be one Vehicle", 1, dto.getVehicles().size());
    }
    
}
