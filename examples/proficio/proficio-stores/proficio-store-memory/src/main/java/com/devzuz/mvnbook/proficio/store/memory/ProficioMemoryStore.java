package com.devzuz.mvnbook.proficio.store.memory;

import com.devzuz.mvnbook.proficio.ProficioStore;
import com.devzuz.mvnbook.proficio.model.FaqEntry;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Proficio store backed by a simple Map.
 */
public class ProficioMemoryStore
    implements ProficioStore
{
    protected Map store;

    int id;

    public ProficioMemoryStore()
    {
        store = new TreeMap();

        id = 0;
    }

    public String addFaqEntry( FaqEntry entry )
    {
        id++;

        String sid = Integer.toString( id );

        entry.setId( sid );

        store.put( entry.getId(), entry );

        return sid;
    }

    public String updateFaqEntry( FaqEntry entry )
    {
        store.put( entry.getId(), entry );

        return entry.getId();
    }

    public void removeFaqEntry( String id )
    {
        store.remove( id );
    }

    public FaqEntry getFaqEntry( String id )
    {
        return (FaqEntry) store.get( id );
    }

    public Iterator getFaqEntries()
    {
        return store.values().iterator();
    }

    public int faqEntryCount()
    {
        return store.keySet().size();
    }
}
