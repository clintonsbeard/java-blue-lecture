<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<div>
			<h1>${greeting} <c:out value="${doug.firstName}" /> <c:out value="${doug.lastName}" /></h1>
			
			<p>
				${doug.address.street} <br />
				<c:out value="${doug.address.city}" />, ${doug.address.zipcode}
			</p>

		</div>
	
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
				<th>Adult</th>
			</tr>
			<c:forEach var="person" items="${personList}">
				<tr>
					<td>${person.firstName}</td>
					<td>${person.lastName}</td>
					<td>${person.age}</td>
					<td>${person.adult}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>