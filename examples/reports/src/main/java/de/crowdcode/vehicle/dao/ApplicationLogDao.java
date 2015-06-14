package de.crowdcode.vehicle.dao;

import java.util.List;

import de.crowdcode.vehicle.domain.ApplicationLog;

public interface ApplicationLogDao {

    void log(ApplicationLog logEntry);
    
    List<ApplicationLog> findAll();
}
