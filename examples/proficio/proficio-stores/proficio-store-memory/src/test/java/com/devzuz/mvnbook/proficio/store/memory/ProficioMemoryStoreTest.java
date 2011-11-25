package com.devzuz.mvnbook.proficio.store.memory;

import junit.framework.TestCase;
import com.devzuz.mvnbook.proficio.store.memory.ProficioMemoryStore;
import com.devzuz.mvnbook.proficio.ProficioStore;
import com.devzuz.mvnbook.proficio.model.FaqEntry;

import java.util.Iterator;

/**
 * Proficio memory store test.
 */
public class ProficioMemoryStoreTest
    extends TestCase
{
    private ProficioStore store;

    protected void setUp()
        throws Exception
    {
        store = new ProficioMemoryStore();
    }

    public void testAddFaqEntry()
        throws Exception
    {
        String id = store.addFaqEntry( createEntry( "question", "answer" ) );

        assertEquals( 1, store.faqEntryCount() );

        FaqEntry entry = store.getFaqEntry( id );

        assertEquals( "question", entry.getQuestion() );

        assertEquals( "answer", entry.getAnswer() );
    }

    public void testUpdateFaqEntry()
        throws Exception
    {
        String id = store.addFaqEntry( createEntry( "question", "answer" ) );

        assertEquals( 1, store.faqEntryCount() );

        FaqEntry entry = store.getFaqEntry( id );

        assertEquals( "question", entry.getQuestion() );

        assertEquals( "answer", entry.getAnswer() );

        assertEquals( 1, store.faqEntryCount() );

        entry.setQuestion( "new question" );

        entry.setAnswer( "new answer" );

        id = store.updateFaqEntry( entry );

        entry = store.getFaqEntry( id );

        assertEquals( "new question", entry.getQuestion() );

        assertEquals( "new answer", entry.getAnswer() );

        assertEquals( 1, store.faqEntryCount() );
    }

    public void testRemoveFaqEntry()
        throws Exception
    {
        String id = store.addFaqEntry( createEntry( "question", "answer" ) );

        assertEquals( 1, store.faqEntryCount() );

        FaqEntry entry = store.getFaqEntry( id );

        store.removeFaqEntry( entry.getId() );

        assertEquals( 0, store.faqEntryCount() );
    }

    public void testGetFaqEntries()
        throws Exception
    {
        store.addFaqEntry( createEntry( "question1", "answer1" ) );

        store.addFaqEntry( createEntry( "question2", "answer2" ) );

        store.addFaqEntry( createEntry( "question3", "answer3" ) );

        assertEquals( 3, store.faqEntryCount() );

        Iterator faqEntries = store.getFaqEntries();

        FaqEntry entry;

        entry = (FaqEntry) faqEntries.next();

        assertEquals( "question1", entry.getQuestion() );

        entry = (FaqEntry) faqEntries.next();

        assertEquals( "question2", entry.getQuestion() );

        entry = (FaqEntry) faqEntries.next();

        assertEquals( "question3", entry.getQuestion() );
    }


    protected FaqEntry createEntry( String question, String answer )
    {
        FaqEntry entry = new FaqEntry();

        entry.setQuestion( question );

        entry.setAnswer( answer );

        return entry;
    }
}
