<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="addCityUrl" value="/addCity" />

<form action="${addCityUrl}" method="POST">
	<label for="name">Name:</label>
	<input type="text" name="name" /><br />
	<label for="district">District:</label>
	<input type="text" name="district" /><br />
	<label for="population">Population:</label>
	<input type="text" name="population" /><br /><br />
	<input type="submit" value="Add City" />

</form>

<%@include file="common/footer.jspf"%>

