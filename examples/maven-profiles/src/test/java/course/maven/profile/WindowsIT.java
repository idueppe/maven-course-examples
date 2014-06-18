package course.maven.profile;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class WindowsIT 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WindowsIT( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WindowsIT.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testWindowsSystemProperty()
    {
        assertEquals( "Windows", System.getProperty("os.name") );
    }
}