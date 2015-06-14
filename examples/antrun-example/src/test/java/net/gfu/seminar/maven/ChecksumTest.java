package net.gfu.seminar.maven;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ChecksumTest {

	@Parameters 
	public static Collection<Object[]> data() {
		Collection<Object[]> parameters = new ArrayList<Object[]>(); 
		parameters.add(new Object[]{1l,1l});
		parameters.add(new Object[]{1l,100l});
		parameters.add(new Object[]{1l,1000l});
		parameters.add(new Object[]{2l,2l});
		parameters.add(new Object[]{2l,20l});
		parameters.add(new Object[]{2l,11l});
		parameters.add(new Object[]{3l,3l});
		parameters.add(new Object[]{3l,12l});
		parameters.add(new Object[]{3l,21l});
		parameters.add(new Object[]{5l,32l});
		parameters.add(new Object[]{5l,23l});
		parameters.add(new Object[]{6l,42l});
		parameters.add(new Object[]{18l,99l});
		parameters.add(new Object[]{45l,123456789l});
		parameters.add(new Object[]{45l,9876543210l});
		parameters.add(new Object[]{90l,9999999999l});
		
		return parameters;
	}

	private long checksum;
	private long value;

	public ChecksumTest(long checksum, long value) {
		this.checksum = checksum;
		this.value = value;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComputeChecksumParameterized() {
		long checksumActual = MathUtils.checksum(value);
		System.out.println("Assert " +checksum + "= "+checksumActual + " of " +value);
		assertEquals(checksum, checksumActual);
	}

}
