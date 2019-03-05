<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
>>>>>>> df11023a85b367f60437ca11d555bab051c02019

<!DOCTYPE html>
<html>
	<head>
		<title>City Search Result</title>
	</head>
	<body>
<<<<<<< HEAD
		<h1>Results for Country Code</h1>
		
		<ul>
			<c:forEach var="city" items="${cities}">
=======
		<h1>Results for Country Code </h1>
		
		<ul>
			<c:forEach var="city" items="${cities}" >
>>>>>>> df11023a85b367f60437ca11d555bab051c02019
				<li><c:out value="${city.name}" /></li>
			</c:forEach>
		</ul>
	</body>
</html>