package de.crowdcode.vehicle.controller.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.controller.ManufacturerController;
import de.crowdcode.vehicle.converter.ManufacturerConverter;
import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.dto.ManufacturerDto;
import de.crowdcode.vehicle.service.ManufacturerService;

@Service
public class ManufacturerControllerBean implements ManufacturerController {
    
    @Autowired
    private ManufacturerService manufacturerService;
    
    @Autowired
    private ManufacturerConverter manufacturerConverter;

    @Override
	public ManufacturerDto byName(final String manufacturerName) {
        Manufacturer manufacturer = manufacturerService.byName(manufacturerName);
        return manufacturerConverter.convert(manufacturer);
    }

    @Override
    public List<ManufacturerDto> allManufactures() {
        // TODO Bitte implementiert diese Methode.
        return null;
    }

    @Override
	public void addManufacturer(final String manufacturerName) {
        // TODO Bitte implementiert diese Methode.
    }

    @Override
	public void deleteManufacturer(final String manufacturerName) {
        // TODO Bitte implementiert diese Methode.
    }

}
