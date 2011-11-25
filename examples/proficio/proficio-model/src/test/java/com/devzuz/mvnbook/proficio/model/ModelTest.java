package com.devzuz.mvnbook.proficio.model;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Test the model.
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 */
public class ModelTest
    extends TestCase
{
    private static final int ID = 123;

    public void testFaq()
    {
        Faq faq = new Faq();
        faq.setDescription( "description" );
        FaqEntry faqEntry = new FaqEntry();
        faqEntry.setAnswer( "answer" );
        faqEntry.setId( "id" );
        faqEntry.setQuestion( "question" );
        faq.addFaqEntry( faqEntry );
        faq.setId( ID );
        faq.setName( "name" );

        assertEquals( "name", faq.getName() );
        assertEquals( "description", faq.getDescription() );
        assertEquals( ID, faq.getId() );

        List faqEntries = faq.getFaqEntries();
        assertEquals( 1, faqEntries.size() );
        faqEntry = (FaqEntry) faqEntries.get( 0 );
        assertEquals( "id", faqEntry.getId() );
        assertEquals( "answer", faqEntry.getAnswer() );
        assertEquals( "question", faqEntry.getQuestion() );
    }

    public void testHashCode()
    {
        Faq faq = new Faq();
        faq.setId( ID );
        assertEquals( ID, faq.hashCode());
    }

    public void testEquals()
    {
        Faq faq = new Faq();
        faq.setId( ID );
        faq.setName( "name" );

        Faq otherFaq = new Faq();
        otherFaq.setId( ID );

        assertEquals( faq, otherFaq );
        assertEquals( faq, faq );
    }
}
