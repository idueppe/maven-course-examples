package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.dto.LogEntry;

public interface ApplicationLogService {
    
    public void log(String message);
    
    public List<LogEntry> logEntries();

}
