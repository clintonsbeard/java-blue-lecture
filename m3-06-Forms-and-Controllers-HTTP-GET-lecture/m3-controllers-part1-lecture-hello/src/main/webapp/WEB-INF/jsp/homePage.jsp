<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Hello Spring MVC</title>
	</head>
	<body>
		<c:url value="/greeting" var="formAction" />
		<form method="GET" action="${formAction}">
			<label for="name">Your Name: </label>
			<input type="text" id="name" name="name" />
			<input type="submit" value="Get Greeting" />
		</form>
	</body>
</html>