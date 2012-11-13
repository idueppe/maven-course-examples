package de.crowdcode.vehicle.dao;

import de.crowdcode.vehicle.domain.Manufacturer;

public interface ManufacturerDao extends EntityDao<Manufacturer> {
    
    public Manufacturer findManufacturerByName(String name);

}
