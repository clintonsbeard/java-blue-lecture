<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>City Search</title>
	</head>
	<body>
		<h1>City Search by Country Code</h1>
		<c:url var="citySearchUrl" value="/result" />
		<form action="citySearchUrl" method="GET">
			<label for="countryCode">Country Code</label>
			<input type="text" name="countryCode" />
			<input type="submit" value="Death is the only escape." />
		</form>
	</body>
</html>