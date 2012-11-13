package de.crowdcode.vehicle.doa.jpa;

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
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.dao.ManufacturerDao;
import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.domain.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Transactional
public class ManufacturerJpaDaoTest {
    
    @Autowired
    private ManufacturerDao dao;
    
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
    public void testCreate() {
        Manufacturer manufacturer = buildSingleManufacturer();

        dao.create(manufacturer);
        
        assertNotNull("Entity should must have an id after persisting.", manufacturer.getId());
    }
    
    @Test
    public void testCreateAndFind() {
        Manufacturer manufacturer = createManufacturer();
        
        Manufacturer found = dao.find(manufacturer.getId());
        Manufacturer found2 = dao.find(manufacturer.getId());
         
        assertTrue(found == found2);
       
        assertEquals("The Entities should be equals", manufacturer, found);
    }
    
    @Test
    public void testFindAll() {
        List<Manufacturer> findAll = dao.findAll();
        assertNotNull("Find All should never be null!", findAll);
    }
    
    @Test
    public void testCreateFindAndDelete() {
        Manufacturer manufacturer = createManufacturer();

        Manufacturer found = dao.find(manufacturer.getId());
        assertEquals("The Entities should be equals", manufacturer, found);
        
        dao.delete(found);
    }

//    @Test(expected=Exception.class)
//    public void testForConcurrentUpdateException() throws Exception {
//        Manufacturer manufacturer = createManufacturerCommitAndClear();
//        
//        manufacturer.setName("Changed in UnitTest");
//        
//        Query createNativeQuery = em.createNativeQuery("UPDATE manufacturer SET version = version + 1");
//        createNativeQuery.executeUpdate();
//        dao.update(manufacturer);
//    }
    
    @Test
    public void testCreateAndUpdate() {
        Manufacturer manufacturer = createManufacturer();
        
        manufacturer.setName("Changed in UnitTest");
        
        dao.update(manufacturer);
        
        Manufacturer found = dao.find(manufacturer.getId());
        
        assertEquals("The entity names should be equal", manufacturer.getName(), found.getName());
    }
    
    @Test
    public void testCreateManufacturerAndVehicle() {
        Manufacturer manufacturer = buildSingleManufacturer();
        Vehicle vehicle = addSingleVehicleToManufacturer(manufacturer);
        
        dao.create(manufacturer);
        
        assertNotNull("Manufacturer should have an id", manufacturer.getId());
        assertNotNull("Vehicle should have an id", vehicle.getId());
        
        Manufacturer found = dao.find(manufacturer.getId());
        assertEquals("Veyron Supper Sports",found.getVehicles().get(0).getModel());
    }

    private Manufacturer createManufacturer() {
        Manufacturer manufacturer = buildSingleManufacturer();
    
        dao.create(manufacturer);
        return manufacturer;
    }

    private Manufacturer buildSingleManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Bugatti");
        return manufacturer;
    }
    
    private Vehicle addSingleVehicleToManufacturer(Manufacturer manufacturer) {
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Veyron Supper Sports");
        
        manufacturer.getVehicles().add(vehicle);
        vehicle.setManufacturer(manufacturer);
        return vehicle;
    }

}
