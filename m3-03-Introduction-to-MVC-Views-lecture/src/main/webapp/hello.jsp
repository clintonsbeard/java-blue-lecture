<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>MVC Views Part 1 - Example: Hello, Internet!</title>
	</head>
	<body>
		<c:choose>
			<%-- We can reference the values of request parameters
			(e.g. from the query string) by using the "param" map.
			
			Here we are testing to see whether a query string 
			parameter called "name" was provided, and if it wasn't
			(i.e. it's empty) we're defaulting the name to "Internet" --%>
			<c:when test="${empty param.name}">
				<c:set var="name" value="Internet" />
			</c:when>
			<c:otherwise>
				<c:set var="name" value="${param.name}" />
			</c:otherwise>
		</c:choose>
	
		<h1>Hello, ${name}!</h1>
	</body>
</html>