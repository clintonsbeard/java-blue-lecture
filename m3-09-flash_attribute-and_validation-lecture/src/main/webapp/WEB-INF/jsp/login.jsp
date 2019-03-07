<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="loginUrl" value="/login" />

<h2>Please Login</h2>

<h2 class="error">${error}</h2>

<form action="${login}" method="POST">
	<label for="name">UserName:</label>
	<input type="text" name="username" /><br />
	<label for="password">Password:</label>
	<input type="password" name="password" /><br />
	<input type="submit" value="Login" />

</form>


<%@include file="common/footer.jspf"%>