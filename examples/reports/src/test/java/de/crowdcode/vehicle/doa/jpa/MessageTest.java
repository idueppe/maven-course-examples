package de.crowdcode.vehicle.doa.jpa;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.crowdcode.vehicle.domain.Message;

public class MessageTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("vehicle-foundation");
    }
    
    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }
    
    @Before
    public void setUp() {
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }

    @Test
    public void testCreateAndFindMessage() {                                
        Message msg = new Message();

        msg.setText("Hallo JPA");
        msg.setDate(new Date());
       
        em.getTransaction().begin();
        em.persist(msg);
        msg.setSubject("My new subject");
        em.getTransaction().commit();

        em.clear();
        
        Message found = em.find(Message.class, msg.getId());
        assertNotNull("Should find message object.", found);
        em.getTransaction().begin();
        found.setSubject("Very new subject");
        em.getTransaction().commit();
        
        em.close();
        em = emf.createEntityManager();
        
        found.setText("Changed in detached mode");
        
        em.getTransaction().begin();
        Message merged = em.merge(found);
        merged.setSubject("Merged");
        em.getTransaction().commit();
        
//        em.refresh(found);
        assertNotNull("Message should be found.", found);
    }
    

}
