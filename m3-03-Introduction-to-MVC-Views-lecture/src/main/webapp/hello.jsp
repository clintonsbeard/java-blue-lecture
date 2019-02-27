<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>MVC Views Part 1 - Example: Hello, Internet!</title>
		<style>
			.red {
				color: red;
			}
			.blue {
				color: blue;
			}
		</style>
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
	
		<c:forEach begin="1" end="${param.number}" var="num">
			<c:choose>
				<c:when test="${num % 2 == 0}">
					<c:set var="cssClass" value="red" />
				</c:when>
				<c:when test="${num % 3 == 0}">
					<c:set var="cssClass" value="blue" />
				</c:when>
				<c:otherwise>
					<c:set var="cssClass" value="" />
				</c:otherwise>
			</c:choose>
			
			<h1 class="${cssClass}">Hello, ${name}! : ${num}</h1>
		</c:forEach>
		
		
	</body>
</html>