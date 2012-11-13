package de.crowdcode.vehicle.dto;

import java.util.Date;

public class LogEntry {

    private String message;
    private Date timeStamp;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStampe) {
        this.timeStamp = timeStampe;
    }
    
}
