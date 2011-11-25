package com.devzuz.mvnbook.proficio.store.xstream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.devzuz.mvnbook.proficio.model.FaqEntry;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        ProficioXStreamStore store = new ProficioXStreamStore();
        FaqEntry faqEntry = new FaqEntry();
        faqEntry.setId( "id" );
        store.addFaqEntry( faqEntry );
        store.updateFaqEntry( faqEntry );
        store.removeFaqEntry( faqEntry.getId() );
    }
}
