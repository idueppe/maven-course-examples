package de.crowdcode.vehicle.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "ApplicationLog.LOAD_ALL", query = "SELECT o FROM ApplicationLog o")
public class ApplicationLog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotNull
	private String message;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public ApplicationLog() {
	}

	public ApplicationLog(String message) {
		this.message = message;
	}

	@PrePersist
	public void prePersist() {
		timestamp = new Date();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

}
