package de.crowdcode.vehicle.domain;

public enum EngineType {
	
	DIESEL, 
	PETROL,
	DIESEL_HYBRID, 
	PETROL_HYBRID;

	public String asString() {
		return name();
	}

	public EngineType asObject(String value) {
		return EngineType.valueOf(value);
	}

}