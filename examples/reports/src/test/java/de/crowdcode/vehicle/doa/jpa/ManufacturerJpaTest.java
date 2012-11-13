package de.crowdcode.vehicle.doa.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.domain.Vehicle;

public class ManufacturerJpaTest {
    
    private static EntityManagerFactory emf;
    
    private EntityManager em;
    
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("vehicle-foundation");
    }
    
//    @AfterClass
//    public static void tearDownClass() {
//        Do not close EMF between to Spring Unit tests. 
//        It will remove the database schema according to hbm2ddl property.
//        But spring is not aware of it and fails in the next text.
//      emf.close();        
//    }
    
    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        if (em.isOpen()) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            em.close();
        }
    }
    
    @Test
    public void testManufacturerAndVehicle() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Bugatti");
        
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Veyron Supper Sports");
        
        manufacturer.getVehicles().add(vehicle);
        vehicle.setManufacturer(manufacturer);
        
        txBegin();
        
        em.persist(manufacturer);
//        em.persist(vehicle);
        
        txCommit();
        
        em.clear();
        
        assertNotNull("Manufacturer should have an id", manufacturer.getId());
        assertNotNull("Vehicle should have an id", vehicle.getId());
        
        Manufacturer found = em.find(Manufacturer.class, manufacturer.getId());
        assertEquals("Veyron Supper Sports",found.getVehicles().get(0).getModel());
    }

    private void txCommit() {
        em.getTransaction().commit();
    }

    private void txBegin() {
        em.getTransaction().begin();
    }

}
