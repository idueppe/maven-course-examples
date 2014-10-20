package de.crowdcode.vehicle.converter;

import java.util.Collection;
import java.util.List;

/**
 * @author idueppe
 */
public abstract class AbstractDefaultConverter<SOURCE, TARGET> extends
                AbstractConverter<SOURCE, TARGET> {

    @Override
    public List<TARGET> convert(Collection<? extends SOURCE> source) throws ConversionException {
        List<TARGET> targetList = super.convert(source);
        sort(targetList);

        return targetList;
    }

    /**
     * Override this method to sort a converted list of target objects
     */
	protected void sort(List<TARGET> targetList) {
	}

    public TARGET convert(SOURCE source) throws ConversionException {
        try {
            final TARGET target = newTargetInstance();
            if (source != null) {
                copyProperties(source, target);
            }
            return target;
        } catch (Exception e) {
            throw new ConversionException(buildMessage(retrieveContextName(source)), e);
        }
    }

    protected String retrieveContextName(SOURCE source) {
        return (source != null) ? source.getClass().getName() : this.getClass().getName();
    }

    protected abstract TARGET newTargetInstance();

    protected abstract void copyProperties(final SOURCE source, final TARGET target);

}
