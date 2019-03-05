<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="addCityUrl" value="/addCity" />
<c:url var="addCityWithBindingUrl" value="/addCityWithBinding" />
<c:url var="addCityWithRequestParamsUrl" value="/addCityWithRequestParams" />
<c:url var="addCityWithPostWithModelMap" value="/addCityWithPostWithModelMap" />
<c:url var="addCityWithPostAndRedirectUrl" value="/addCityWithPostAndRedirect" />


<!-- form action="${addCityUrl}" method="GET"-->
<!-- form action="${addCityUrl}" method="POST" -->
<!-- form action="${addCityWithRequestParamsUrl}" method="POST" -->
<!-- form action="${addCityWithBindingUrl}" method="POST"-->
<!-- form action="${addCityWithPostWithModelMap}" method="POST" -->
<!-- form action="${addCityWithPostAndRedirectUrl}" method="POST" -->


<form action="${addCityWithPostAndRedirectUrl}" method="POST">
	<label for="name">Name:</label>
	<input type="text" name="name" /><br />
	<label for="district">District:</label>
	<input type="text" name="district" /><br />
	<label for="population">Population:</label>
	<input type="text" name="population" /><br />
	<input type="submit" value="Search" />

</form>
<table class="table">
<tr>
<th>Name</th>
<th>District</th>
<th>Population</th>
</tr>
<c:forEach items="${cities}" var="city">
<tr>
	<td><c:out value="${city.name}" /></td>
	<td><c:out value="${city.district}" /></td>
	<td><c:out value="${city.population}" /></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>

