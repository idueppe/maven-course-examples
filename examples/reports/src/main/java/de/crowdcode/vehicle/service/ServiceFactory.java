package de.crowdcode.vehicle.service;

import de.crowdcode.vehicle.service.spi.VehicleServiceBean;

public class ServiceFactory {

	private ServiceFactory() {
		// hide constructor to avoid instantiation
	}

	public static VehicleService getVehicleService() {
		return new VehicleServiceBean();
	}

}
