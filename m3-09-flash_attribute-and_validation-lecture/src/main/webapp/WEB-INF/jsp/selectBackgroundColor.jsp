<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="common/header.jspf"%>

<c:url var="changeBackgroundUrl" value="/changeBackground" />

<form action="${changeBackgroundUrl}" method="POST">
	<label for="bgColor">Select Background Color:</label>
	<select name="bgColor">
		<option value="red">Red</option>
		<option value="BurlyWood">Burly Wood</option>
		<option value="CornflowerBlue">Cornflower Blue</option>
		<option value="DarkSeaGreen">Dark Sea Green</option> 
		<option value="white">White</option>
	</select>
	<input type="submit" value="Apply" />
		
</form>
<%@include file="common/footer.jspf"%>