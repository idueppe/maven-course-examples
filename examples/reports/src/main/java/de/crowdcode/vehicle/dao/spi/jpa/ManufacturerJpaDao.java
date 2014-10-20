package de.crowdcode.vehicle.dao.spi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import de.crowdcode.vehicle.dao.ManufacturerDao;
import de.crowdcode.vehicle.domain.Manufacturer;

@Repository
public class ManufacturerJpaDao implements ManufacturerDao {
    
    @PersistenceContext(name="vehicle-foundation")
    private EntityManager em;
    
    @Override
    public List<Manufacturer> findAll() {
        TypedQuery<Manufacturer> query = em.createQuery("SELECT m FROM Manufacturer m", Manufacturer.class);
        return query.getResultList();
    }

    @Override
    public Manufacturer find(Long id) {
        return em.find(Manufacturer.class, id);
    }

    @Override
    public void create(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    @Override
    public void delete(Manufacturer manufacturer) {
        em.remove(manufacturer);
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return em.merge(manufacturer);
    }

    @Override
    public Manufacturer findManufacturerByName(String name) {
        TypedQuery<Manufacturer> query = em.createNamedQuery("findManufacturerByName", Manufacturer.class);
        query.setParameter("name", name);
        List<Manufacturer> manufacturers = query.getResultList();
		if (!manufacturers.isEmpty()) {
            return manufacturers.get(0);
        } else {
            return null;
        }
    }

}
