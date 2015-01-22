package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.dto.LogEntry;

public interface ApplicationLogService {
    
    void log(String message);
    
    List<LogEntry> logEntries();

}
