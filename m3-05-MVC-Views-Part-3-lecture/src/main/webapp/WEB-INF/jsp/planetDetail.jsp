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
	
<c:import url="/WEB-INF/jsp/footer.jsp">
</c:import>