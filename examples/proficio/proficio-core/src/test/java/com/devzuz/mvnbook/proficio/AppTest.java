package com.devzuz.mvnbook.proficio;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    private DefaultProficio proficio;

    public void setUp()
    {
        proficio = new DefaultProficio();
    }

    public void testApp()
    {
        proficio.testMethod1();
        proficio.testMethod2();
    }
}
