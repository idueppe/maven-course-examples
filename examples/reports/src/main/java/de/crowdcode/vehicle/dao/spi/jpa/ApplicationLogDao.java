package de.crowdcode.vehicle.dao.spi.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import de.crowdcode.vehicle.domain.ApplicationLog;

@Repository
public class ApplicationLogDao implements de.crowdcode.vehicle.dao.ApplicationLogDao {

    @PersistenceContext(name = "vehicle-foundation")
    private EntityManager em;

    @Override
    public void log( ApplicationLog logEntry ) {
        em.persist( logEntry );
    }

    @Override
    public List<ApplicationLog> findAll() {
        TypedQuery<ApplicationLog> query = em.createNamedQuery( "ApplicationLog.LOAD_ALL", ApplicationLog.class );
        return query.getResultList();
    }

}