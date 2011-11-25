package com.devzuz.mvnbook.proficio;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.devzuz.mvnbook.proficio.model.FaqEntry;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * The default implementation of Proficio.
 * @todo fill in the gaps
 */
public class DefaultProficio
    implements Proficio
{    
    /** Number of times to loop in test. */
    private static final int COUNT = 10;

    /** Test variable. */
    private String unused;

    private ProficioStore store;

    /**
     * Add a FAQ entry.
     *  @param entry an entry
     */
    public void addFaqEntry( FaqEntry entry )
    {
        // Trigger PMD
        int i;

        store.addFaqEntry( entry );

    }

    /**
     * Update a FAQ entry.
     *  @param entry an entry
     */
    public void updateFaqEntry( FaqEntry entry )
    {
        int j;

        store.updateFaqEntry( entry );
    }

    /**
     * Remove a FAQ entry.
     *  @param entry an entry
     */
    public void removeFaqEntry( FaqEntry entry )
    {
        store.removeFaqEntry( entry.getId() );
    }

    /**
     * Test.
     */
    private void testMethod()
    {
    }

    /**
     * Test.
     */
    public void testMethod1()
    {
        // This copy and pasted code is intended to be detected by PMD's CPD report
        PrintWriter out = new PrintWriter( new StringWriter() );

        int i;
        for ( i = 0; i < COUNT; i ++ )
        {
            out.println( "i = " + i );
            int j;
            for ( j = 0; j < COUNT; j ++ )
            {
                out.println( "j = " + j );
                int k;
                for ( k = 0; k < COUNT; k ++ )
                {
                    out.println( "k = " + k );
                }
            }
        }
        for ( i = 0; i < COUNT; i ++ )
        {
            out.println( "i = " + i );
            int j;
            for ( j = 0; j < COUNT; j ++ )
            {
                out.println( "j = " + j );
                int k;
                for ( k = 0; k < COUNT; k ++ )
                {
                    out.println( "k = " + k );
                }
            }
        }
    }

    /**
     * Test.
     */
    public void testMethod2()
    {
        // This copy and pasted code is intended to be detected by PMD's CPD report
        PrintWriter out = new PrintWriter( new StringWriter() );

        int i;
        for ( i = 0; i < COUNT; i ++ )
        {
            out.println( "i = " + i );
            int j;
            for ( j = 0; j < COUNT; j ++ )
            {
                out.println( "j = " + j );
                int k;
                for ( k = 0; k < COUNT; k ++ )
                {
                    out.println( "k = " + k );
                }
            }
        }
        for ( i = 0; i < COUNT; i ++ )
        {
            out.println( "i = " + i );
            int j;
            for ( j = 0; j < COUNT; j ++ )
            {
                out.println( "j = " + j );
                int k;
                for ( k = 0; k < COUNT; k ++ )
                {
                    out.println( "k = " + k );
                }
            }
        }
    }
}
