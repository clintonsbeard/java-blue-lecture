<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">New Checking Account Application</c:param>
</c:import>

<h2>New Checking Account Application</h2>
<h3>Summary</h3>

<table>
	<tr>
		<th>First Name:</th>
		<td><c:out value="${customerApplication.firstName}" /></td>
	</tr>
	<tr>
		<th>Last Name:</th>
		<td><c:out value="${customerApplication.lastName}" /></td>
	</tr>
	<tr>
		<th>Date of Birth:</th>
		<td><c:out value="${customerApplication.dateOfBirth}" /></td>
	</tr>
	<tr>
		<th>State of Birth:</th>
		<td><c:out value="${customerApplication.stateOfBirth}" /></td>
	</tr>
	<tr>
		<th>Email Address:</th>
		<td><c:out value="${customerApplication.emailAddress}" /></td>
	</tr>
	<tr>
		<th>Phone Number:</th>
		<td><c:out value="${customerApplication.phoneNumber}" /></td>
	</tr>
	<tr>
		<th>Street Address:</th>
		<td><c:out value="${customerApplication.addressStreet}" /></td>
	</tr>
	<tr>
		<th>Apartment:</th>
		<td><c:out value="${customerApplication.addressApartment}" /></td>
	</tr>
	<tr>
		<th>City:</th>
		<td><c:out value="${customerApplication.addressCity}" /></td>
	</tr>
	<tr>
		<th>State:</th>
		<td><c:out value="${customerApplication.addressState}" /></td>
	</tr>
	<tr>
		<th>ZIP:</th>
		<td><c:out value="${customerApplication.addressZip}" /></td>
	</tr>
</table>
<form method="POST" action="completeApplication">
	<input type="submit" value="Submit Application" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />