package de.crowdcode.vehicle.converter;

import java.util.Collection;
import java.util.List;

/**
 * @author idueppe
 *
 * @param <SOURCE>
 * @param <TARGET>
 */
public interface Converter<SOURCE, TARGET> {

    /**
     * Converts the source collection object, creating a new instance of the destination type
     * 
     * @param source
     *            the source object
     * @return the converted object
     * @throws ConversionException
     *             if an error occurs
     */
    List<TARGET> convert(Collection<? extends SOURCE> source) throws ConversionException;

    /**
     * Converts the source object, creating a new instance of the destination type
     * 
     * @param source
     *            the source object
     * @return the converted object
     * @throws ConversionException
     *             if an error occurs
     */
    TARGET convert(SOURCE source) throws ConversionException;
    
}
