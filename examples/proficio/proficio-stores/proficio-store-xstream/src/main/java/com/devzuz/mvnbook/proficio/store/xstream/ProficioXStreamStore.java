package com.devzuz.mvnbook.proficio.store.xstream;

import com.devzuz.mvnbook.proficio.store.memory.ProficioMemoryStore;
import com.devzuz.mvnbook.proficio.model.FaqEntry;
import com.thoughtworks.xstream.XStream;

/**
 * A Proficio store backed by a XStream.
 *
 * @author Jason van Zyl
 */
public class ProficioXStreamStore
    extends ProficioMemoryStore
{
    private XStream xstream;

    public ProficioXStreamStore()
    {
        xstream = new XStream();
    }

    public String addFaqEntry( FaqEntry entry )
    {
        String id = super.addFaqEntry( entry );

        xstream.toXML( entry ); // This would usually be saved somewhere, of course

        return id;
    }

    public String updateFaqEntry( FaqEntry entry )
    {
        String id = super.updateFaqEntry( entry );

        xstream.toXML( entry ); // This would usually be saved somewhere, of course

        return id;
    }
}
