package com.devzuz.mvnbook.proficio;

import com.devzuz.mvnbook.proficio.model.FaqEntry;

import java.util.Iterator;

/**
 * Interface for a Proficio backend store.
 *
 * @author Jason van Zyl
 * @version $Revision:$
 */
public interface ProficioStore
{
    String addFaqEntry( FaqEntry entry );

    String  updateFaqEntry( FaqEntry entry );

    void removeFaqEntry( String id );

    FaqEntry getFaqEntry( String id );

    Iterator getFaqEntries();

    int faqEntryCount();
}
