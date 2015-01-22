package de.crowdcode.vehicle.dao;

import de.crowdcode.vehicle.domain.Manufacturer;

public interface ManufacturerDao extends EntityDao<Manufacturer> {
    
    Manufacturer findManufacturerByName(String name);

}
