<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<H1>Thank you for adding a new city!</H1>

<h3>You added:</h3>

<table class="table">
<tr>
<th>Name</th>
<th>District</th>
<th>Population</th>
</tr>
<tr>
	<td><c:out value="${city.name}" /></td>
	<td><c:out value="${city.district}" /></td>
	<td><c:out value="${city.population}" /></td>
	<td><c:out value="${comment}" /></td>
</tr>
</table>

<%@include file="common/footer.jspf"%>