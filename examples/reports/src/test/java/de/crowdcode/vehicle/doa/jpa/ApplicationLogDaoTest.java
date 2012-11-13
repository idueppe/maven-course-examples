package de.crowdcode.vehicle.doa.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.dao.ApplicationLogDao;
import de.crowdcode.vehicle.domain.ApplicationLog;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
public class ApplicationLogDaoTest {

    @Autowired()
    private ApplicationLogDao dao;
    
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
    public void testFindAllLogs() {
        assertEquals("There should be no logs in the database", 0, dao.findAll().size());
    }
    
    @Test
    @Transactional
    public void testAddLog() {
        dao.log(new ApplicationLog("JUNIT TEST ADD LOG"));
    }
    
}
