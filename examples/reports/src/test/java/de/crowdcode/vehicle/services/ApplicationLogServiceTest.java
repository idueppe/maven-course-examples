package de.crowdcode.vehicle.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import de.crowdcode.vehicle.doa.jpa.DBFixture;
import de.crowdcode.vehicle.service.ApplicationLogService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ApplicationLogServiceTest {

    @Autowired
    private ApplicationLogService service;
    
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
        assertNotNull(service);
    }
    
    @Test
    public void testFindAllLogs() {
        assertEquals("There should be no logs in the database", 0, service.logEntries().size());
    }
    
    @Test
    public void testAddLog() {
        service.log("JUNIT TEST ADD LOG");
        assertEquals("JUNIT TEST ADD LOG", service.logEntries().get(0).getMessage());
    }
    
}
