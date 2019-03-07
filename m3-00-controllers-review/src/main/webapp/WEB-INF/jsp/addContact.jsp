<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
    <c:param name="pageTitle" value="Add Contact" />
</c:import>

<H1>Add Contact</H1>
<c:url var="addContactUrl" value="/addContact" />
<form action="${addContactUrl}" method="POST">
	<label for="firstName">First Name:</label>
	<input type="text" name="firstName" id="firstName"/>
	<br />
	<label for="lastName">Last Name:</label>
	<input type="text" name="lastName" id="lastName"/>
	<input type="submit" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />