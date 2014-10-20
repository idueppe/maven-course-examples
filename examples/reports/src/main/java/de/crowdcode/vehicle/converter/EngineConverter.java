package de.crowdcode.vehicle.converter;

import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.dto.EngineDto;

/**
 * @author idueppe
 */
@Service("engineConverter")
public class EngineConverter extends
		AbstractDefaultConverter<Engine, EngineDto> {

	@Override
	protected EngineDto newTargetInstance() {
		return new EngineDto();
	}

	@Override
	protected void copyProperties(final Engine source, final EngineDto target) {
		target.setEngineId(source.getId());
		target.setEngineType(source.getType());
	}

}
