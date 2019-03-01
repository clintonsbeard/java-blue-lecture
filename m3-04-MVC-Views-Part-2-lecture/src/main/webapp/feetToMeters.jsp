<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>  

<!DOCTYPE html>
<html>
	<head>
		<title>MVC Views Part 1 - Example: Metric Conversions</title>
		
		<style>
			
			tr {
				background-color: #DDDDDD;
			}
			
			td, th {
				padding: .25em;
			}
		
			tr.marker {
				background-color: #C8C8C8;
				font-weight: bold;
			}
			
			tr.freezing {
				background-color: #BEEBFA;
			}
			
			tr.boiling {
				background-color: #FAD7D2;
			}
			
		</style>
	</head>
	<body>		
		<h2>Feet to Meters</h2>
		<table>
			<tr>
				<th>feet</th>
				<th>meters</th>
			</tr>
			 
			<c:forEach begin="1" end="50" var="feet">

				<c:set var="rowClassAttribute" value="" />
				
				<c:if test="${feet % 10 == 0}">
					<c:set var='rowClassAttribute' value='marker' />
				</c:if>
				<tr class="${rowClassAttribute}">
					<td>${feet}</td> 
					<td>${feet * .3048}</td>
				</tr>	
			</c:forEach>
		</table>
		
	</body>
</html>