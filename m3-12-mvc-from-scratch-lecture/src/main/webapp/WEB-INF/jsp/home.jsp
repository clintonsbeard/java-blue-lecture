<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<H1>Cities</H1>
		<ul>
			<c:forEach var="city" items="${cities}">
				<li>${city.name}</li>
			</c:forEach>
		</ul>
	</body>
</html>
