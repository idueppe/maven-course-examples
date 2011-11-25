package com.devzuz.mvnbook.proficio;

import com.devzuz.mvnbook.proficio.model.FaqEntry;

/**
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id: Proficio.java 8 2006-04-08 11:32:04Z bporter $
 */
public interface Proficio
{
    /**
     * @xfire
     */
    void addFaqEntry( FaqEntry entry );

    /**
     * @xfire
     */
    void updateFaqEntry( FaqEntry entry );

    /**
     * @xfire
     */
    void removeFaqEntry( FaqEntry entry );
}
