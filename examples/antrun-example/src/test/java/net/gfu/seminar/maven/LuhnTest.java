package net.gfu.seminar.maven;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LuhnTest {

	@Parameters 
	public static Collection<Object[]> data() {
		Collection<Object[]> parameters = new ArrayList<Object[]>(); 
		parameters.add(new Object[]{true, "4111111111111111" } );
		parameters.add(new Object[]{true, "5500000000000004" } );
		parameters.add(new Object[]{true, "340000000000009" } );
		parameters.add(new Object[]{true, "30000000000004" });
		parameters.add(new Object[]{true, "6011000000000004" } );
		parameters.add(new Object[]{true, "201400000000009" });
		parameters.add(new Object[]{true, "3088000000000009" } );
		parameters.add(new Object[]{false, "9238475098787444" } );
	    
		return parameters;
	}
	
	
	private boolean isValid;


	private String digitsAsString;

	public LuhnTest(boolean isValid, String digitsAsString) {
		super();
		this.isValid = isValid;
		this.digitsAsString = digitsAsString;
	}
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckLuhn() {
		assertEquals(isValid,MathUtils.checkLuhn(digitsAsString));
	}
	
	@Test public void testCheckLuhnAlgorithm() {
		assertEquals(luhnTest(digitsAsString), MathUtils.checkLuhn(digitsAsString));
	}
	
	static boolean luhnTest( String s )
	  {
	    int len = s.length();

	    int digits[] = new int[len];

	    for ( int i = 0; i < len; i++ )
	    {
	      try {
	        digits[i] = Integer.parseInt( s.substring(i,i+1) );
	      }
	      catch ( NumberFormatException e ) {
	        System.err.println( e );
	        return false;
	      }
	    }

	    int sum=0;

	    while ( len > 0 )
	    {
	      sum += digits[len-1];
	      len--;

	      if ( len > 0 )
	      {
	        int digit = 2*digits[len-1];
	        sum += ( digit>9) ? digit-9 : digit;

	        len--;
	      }
	    }

	    return ( sum%10 == 0 );
	  }


	  static boolean isVisa( String s )
	  {
	    if ( ( (s.length() == 16) || (s.length() == 13) ) &&
	          (s.charAt(0) == '4') )
	      return luhnTest( s );

	    return false;
	  }

	  public static void main( String args[] )
	  {
	    System.out.println( luhnTest( "4111111111111111" ) );
	    System.out.println( luhnTest( "5500000000000004" ) );
	    System.out.println( luhnTest( "340000000000009" ) );
	    System.out.println( luhnTest( "30000000000004" ) );
	    System.out.println( luhnTest( "6011000000000004" ) );
	    System.out.println( luhnTest( "201400000000009" ) );
	    System.out.println( luhnTest( "3088000000000009" ) );
	    System.out.println( luhnTest( "9238475098787444" ) );

	    System.out.println( isVisa( "4111111111111111" ) );
	    System.out.println( isVisa( "5500000000000004" ) );


	    // Bšse: Visa-Nummer generieren

	    char c[] = "4123456789123456".toCharArray();

	    while ( !isVisa(new String(c)) )
	      c[(int)(Math.random()*c.length-1)+1] = (char)('0'+Math.random()*9.9);

	    System.out.println( c );
	  }

}
