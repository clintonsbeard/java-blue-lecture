<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" >
	<c:param name="pageTitle" value="Planet Detail" />
</c:import>

	
	<h1>Welcome <c:out value="${param.user}" /></h1>
	
	<c:forEach var="planet" items="${planets}">
		<c:set var="currentPlanet" value="${planet}" scope="request" />
		<c:import url="/WEB-INF/jsp/singlePlanet.jsp" />
	</c:forEach>
	

<c:import url="/WEB-INF/jsp/footer.jsp">
</c:import>