package de.crowdcode.vehicle.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.crowdcode.vehicle.service.VehicleService;

public class ApplicationContextTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        
        VehicleService bean = (VehicleService) context.getBean("vehicleServiceBean");
        assertNotNull(bean);
    }

}
