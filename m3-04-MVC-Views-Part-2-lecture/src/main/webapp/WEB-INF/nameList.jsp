<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Name List Example</title>
	</head>
	<body>
		<div>
			<h1>A List of Strings</h1>
			<ol>
				<c:forEach var="name" items="${requestScope.nameList}">
					<li>${name}</li>
				</c:forEach>
			</ol>
		</div>
		<div>
			<h1>A single value from a Map using the key</h1>
			A group of Lions is called a <b>${herds.Lion}</b>
		</div>
		<div>
			<h1>Looping through the keys and values of a Map</h1>
			<p>When looping through a Map the JSTL variable is populated with an keyValue object.<br />
			In EL the key can be accessed using <b>var.key</b> and the value using <b>var.value</b></p>
			<ol>
				<c:forEach var="entry" items="${herds}">
					A group of <b>${entry.key}</b> is called a <b>${entry.value}</b><br />
				</c:forEach>
			</ol>
		</div>
	</body>
</html>