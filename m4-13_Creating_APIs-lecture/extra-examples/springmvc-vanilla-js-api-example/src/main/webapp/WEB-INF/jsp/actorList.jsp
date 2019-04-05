<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>


<form class="form-inline" method="GET" action="<c:url value="/actorSearch" />">
	
    <input class="form-control" name="search" placeholder="Search">
    <input class="btn btn-default" name="submit" value="Submit" type="submit"/>
</form>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${actors}" var="actor">
<tr>
<td><c:out value="${actor.firstName}"/> <c:out value="${actor.lastName}"/></td>
</tr>
</c:forEach>
</table>
<%@include file="common/footer.jspf"%>