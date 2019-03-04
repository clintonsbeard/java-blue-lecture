<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<div>
		<h2><c:out value="${currentPlanet.name}" /></h2>
		<c:url var="imageLinkUrl" value="img/${currentPlanet.imageName}" />
		<img src="${imageLinkUrl}" style="width:200px;" />
		<p>
			<b>AU from Sun: </b> <c:out value="${currentPlanet.auFromSun}" /> <br />
			<b>Number of Moons:</b>  <c:out value="${currentPlanet.numberOfMoons}" /> <br /> 
		</p>
		
		<hr>
		
	</div>
	
