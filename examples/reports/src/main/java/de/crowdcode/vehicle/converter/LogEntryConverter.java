package de.crowdcode.vehicle.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import de.crowdcode.vehicle.domain.ApplicationLog;
import de.crowdcode.vehicle.dto.LogEntry;

@Service("logEntryConverter")
public class LogEntryConverter extends AbstractDefaultConverter<ApplicationLog, LogEntry>{

    @Autowired
    private EngineConverter engineConverter;
    
    @Override
    protected LogEntry newTargetInstance() {
        return new LogEntry();
    }

    @Override
    protected void copyProperties(ApplicationLog source, LogEntry target) {
        target.setMessage(source.getMessage());
        target.setTimeStamp(source.getTimestamp());
    }

}
