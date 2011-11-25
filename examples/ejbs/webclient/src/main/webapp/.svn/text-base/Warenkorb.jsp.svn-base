<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="course.common.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>

	<h2>Warenkorb</h2>
	<ol>
	<c:forEach items="${warenkorb.inhalt}" var="item">
		<li>
			<c:out value="${item.key}"/>: 
			<c:out value="${item.value}"/>
		</li>
	</c:forEach>
	</ol>
	<form action="WarenkorbServlet.html">
		Produkt <input type="text" name="produkt" value="USB-Stick"><br>
		Anzahl <input type="text" name="anzahl" value="1"><br>
		<input type="submit"><br>
	</form>
	<p>
	<c:url value="/WarenkorbServlet.html" var="url">
		<c:param name="logout">true</c:param>
	</c:url>
	<a href="${url}">Abmelden</a>
</body>
</html>