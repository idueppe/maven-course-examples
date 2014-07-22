package de.crowdcode.vehicle.dao.spi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import de.crowdcode.vehicle.dao.EngineDao;
import de.crowdcode.vehicle.domain.Engine;

@Repository
public class EngineJpaDao implements EngineDao {

    @PersistenceContext(name="vehicle-foundation")
    private EntityManager em;

    public EngineJpaDao() {
    }
    
    @Override
    public List<Engine> findAll() {
        TypedQuery<Engine> query = em.createQuery("SELECT e FROM Engine e", Engine.class);
        return query.getResultList();
    }

    @Override
    public Engine find(Long id) {
        return em.find(Engine.class, id);
    }

    @Override
    public void create(Engine entity) {
        em.persist(entity);
    }

    @Override
    public void delete(Engine entity) {
        em.remove(entity);
    }

    @Override
    public Engine update(Engine entity) {
        return em.merge(entity);
    }

}
