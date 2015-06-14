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
public class ModuloTest {

	@Parameters 
	public static Collection<Object[]> data() {
		Collection<Object[]> parameters = new ArrayList<Object[]>(); 
		
		parameters.add(new Object[]{1l,1,0});
		parameters.add(new Object[]{2l,1,0});
		parameters.add(new Object[]{4l,2,0});
		parameters.add(new Object[]{5l,2,1});
		parameters.add(new Object[]{6l,3,0});
		parameters.add(new Object[]{7l,2,1});
		parameters.add(new Object[]{7l,3,1});
		parameters.add(new Object[]{9l,3,0});
		parameters.add(new Object[]{10l,3,1});
		parameters.add(new Object[]{11l,2,1});
		parameters.add(new Object[]{11l,3,2});
		parameters.add(new Object[]{11l,4,3});
		parameters.add(new Object[]{11l,5,1});
		parameters.add(new Object[]{11,6,5});
		
		parameters.add(new Object[]{7l,3,1});
		parameters.add(new Object[]{2l,3,2});
		parameters.add(new Object[]{3l,3,0});
		return parameters;
	}
	
	
	private int modulo;
	private long value;
	private int expectedRemains;

	public ModuloTest(long value, int modulo, int expectedRemains) {
		this.modulo = modulo;
		this.value = value;
		this.expectedRemains = expectedRemains;
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testModulo() {
		assertEquals(expectedRemains,MathUtils.modulo(value, modulo));
	}

}
