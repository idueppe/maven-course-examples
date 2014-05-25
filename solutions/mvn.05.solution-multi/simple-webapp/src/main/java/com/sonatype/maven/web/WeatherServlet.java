package com.sonatype.maven.web;

import com.sonatype.maven.weather.WeatherService;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 7043513519069899179L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String zip = request.getParameter("zip");
		WeatherService weatherService = new WeatherService();
		PrintWriter out = response.getWriter();
		try {
			out.println(weatherService.retrieveForecast(zip));
		} catch (Exception e) {
			out.println("Error Retrieving Forecast: " + e.getMessage());
		}
		out.flush();
		out.close();
	}
}