<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<H1>User Date</H1>
		<c:url var="pageOnePostUrl" value="/pageOne" />
		<form action="${pageOnePostUrl}" method="POST">
			Name: <input type="text" name="name" />
			Email: <input type="text" name="email" />
			<input type="submit" />
		</form>
	</body>
</html>
