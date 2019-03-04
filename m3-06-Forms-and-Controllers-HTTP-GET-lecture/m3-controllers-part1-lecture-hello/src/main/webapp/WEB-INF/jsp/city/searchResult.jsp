<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>City Search Result</title>
	</head>
	<body>
		<h1>Results for Country Code</h1>
		
		<ul>
			<c:forEach var="city" items="${cities}">
				<li><c:out value="${city.name}" /></li>
			</c:forEach>
		</ul>
	</body>
</html>