package de.crowdcode.vehicle.service.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import de.crowdcode.vehicle.dao.ManufacturerDao;
import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.service.ManufacturerAlreadyExistsException;
import de.crowdcode.vehicle.service.ManufacturerService;

@Service
public class ManufacturerServiceBean implements ManufacturerService {

    @Autowired
    private ManufacturerDao manuDao;
    
    @Override
    public List<Manufacturer> findAll() {
        return manuDao.findAll();
    }

    @Override
    @Transactional
    public void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException {
        if (doesManufacturerExists(manufacturerName)) {
            throw new ManufacturerAlreadyExistsException(manufacturerName);
        }
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(manufacturerName);
        manuDao.create(manufacturer);
    }

    public boolean doesManufacturerExists(String manufacturerName) {
        return manuDao.findManufacturerByName(manufacturerName) != null;
    }

    @Override
    public Manufacturer byName(String manufacturerName) {
        return manuDao.findManufacturerByName(manufacturerName);
    }

}
