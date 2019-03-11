<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
<<<<<<< HEAD
<c:param name="pageTitle" value="Contact List" />
</c:import>

<H1>Contact List</H1>
<div>
	<c:url var="searchContactsUrl" value="/searchContacts"/>
	<form action="${searchContactsUrl}" method="GET">
		<input type="text" id="" name="searchTerm"/>
		<input type="submit" value="Retrieve Ass"/>
	</form>
</div>
=======
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


>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Date Added</th>
	</tr>
<<<<<<< HEAD
	<c:forEach var="contact" items="${contacts}">
		<tr>
			<td><c:out value="${contact.firstName}"/></td>
			<td><c:out value="${contact.lastName}"/></td>
			<td><c:out value="${contact.dateAdded}"/></td>
=======
	<c:forEach var="contact" items="${contacts}" >
		<tr>
			<td><c:out value="${contact.firstName}" /></td>
			<td><c:out value="${contact.lastName}" /></td>
			<td><c:out value="${contact.dateAdded}" /></td>
>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
		</tr>
	</c:forEach>
</table>

<div>
<<<<<<< HEAD
	<c:url var="addContactUrl" value="/addContact"/>
=======
	<c:url var="addContactUrl" value="/addContact" />
>>>>>>> 050f82aa23d1823b39ea0a0d0f7e771f4310128e
	<a href="${addContactUrl}">Add Contact</a>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />