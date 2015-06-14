package com.sonatype.maven.web;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.TestCase;

public class SimpleServletTest extends TestCase {

	private SimpleServlet mockServlet = new SimpleServlet();
	private HttpServletResponse mockResponse;
	private HttpServletRequest mockRequest;

	protected void setUp()  {
		mockRequest = createMock(HttpServletRequest.class);
		mockResponse = createMock(HttpServletResponse.class);
	}

	public void testDoGet() throws ServletException, IOException {
		StringWriter writer = new StringWriter();
		expect(mockResponse.getWriter()).andReturn(new PrintWriter(writer));
		replay(mockResponse);
		
		mockServlet.doGet(mockRequest, mockResponse);
		System.out.println(writer.toString());
		assertTrue(writer.toString().contains("SimpleServlet Executed"));
	}

	protected void tearDown() {
		verify(mockResponse);
	}

}
