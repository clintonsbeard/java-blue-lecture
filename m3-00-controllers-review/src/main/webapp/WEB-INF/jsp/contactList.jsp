<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="pageTitle" value="Contact List" />
</c:import>

<h1>Contact List</h1>
<div>
	<c:url var="searchContactUrl" value="/searchContacts" />
	<form action="${searchContactUrl}" method="GET" >
		<input type="text" id="" name="searchTerm" />
		<input type="submit" /> 
	</form>

</div>


<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Date Added</th>
	</tr>
	<c:forEach var="contact" items="${contacts}" >
		<tr>
			<td><c:out value="${contact.firstName}" /></td>
			<td><c:out value="${contact.lastName}" /></td>
			<td><c:out value="${contact.dateAdded}" /></td>
		</tr>
	</c:forEach>
</table>

<div>
	<c:url var="addContactUrl" value="/addContact" />
	<a href="${addContactUrl}">Add Contact</a>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />