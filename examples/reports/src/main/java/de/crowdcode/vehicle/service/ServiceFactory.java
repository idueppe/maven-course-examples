package de.crowdcode.vehicle.service;

import de.crowdcode.vehicle.service.spi.VehicleServiceBean;

public class ServiceFactory {
	
	public static VehicleService getVehicleService() {
		return new VehicleServiceBean();
	}
	
}
