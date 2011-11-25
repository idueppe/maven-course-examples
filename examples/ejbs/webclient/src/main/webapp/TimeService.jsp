<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="course.common.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
	<%
		TimeServiceLocal timeService = (TimeServiceLocal) request.getAttribute("timeService");
		out.println(timeService.getTime());
	%>
	<p>
	<c:out value= "${timeService.time}"/>
</body>
</html>