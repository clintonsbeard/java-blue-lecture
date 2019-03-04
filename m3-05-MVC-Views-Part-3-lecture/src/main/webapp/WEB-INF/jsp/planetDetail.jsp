<<<<<<< HEAD
<%@ tablib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp">
	<c:param name="pageTitle" value="Planet Detail" />
</c:import>
	
	<div>
		<h2>Planet Name</h2>
		<img src="" />
		<p>
			<b>AU from Sun: </b> 1 <br />
			<b>Number of Moons:</b> 1 <br />
		</p>
	</div>
	
	<c:forEach var="planet" items="${planets}">
		$planet.name <br />
	</c:forEach>
	
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" >
	<c:param name="pageTitle" value="Planet Detail" />
</c:import>

	
	<h1>Welcome <c:out value="${param.user}" /></h1>
	
	<c:forEach var="planet" items="${planets}">
		<c:set var="currentPlanet" value="${planet}" scope="request" />
		<c:import url="/WEB-INF/jsp/singlePlanet.jsp" />
	</c:forEach>
	

>>>>>>> 5a023af1fd42bd07beb75007ad536a66b4ef3f05
<c:import url="/WEB-INF/jsp/footer.jsp">
</c:import>