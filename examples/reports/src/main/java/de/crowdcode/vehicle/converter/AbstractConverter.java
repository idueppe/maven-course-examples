package de.crowdcode.vehicle.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Default implementation of Converter
 * 
 * @author idueppe
 *
 * @param <SOURCE>
 * @param <TARGET>
 */
public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

    @Override
    public abstract TARGET convert(SOURCE source) throws ConversionException;

    @Override
    public List<TARGET> convert(Collection<? extends SOURCE> source) throws ConversionException {
        if (source == null || source.isEmpty()) {
            return new ArrayList<TARGET>(5);
        }
        List<TARGET> result = new ArrayList<TARGET>(source.size());
        for (SOURCE source2 : source) {
            TARGET t = convert(source2);
            if (t != null) {
                result.add(t);
            }
        }
        return result;
    }
    
    protected String buildMessage(String source) {
        return String.format("Failed to convert [%s]", source);
    }      

}
