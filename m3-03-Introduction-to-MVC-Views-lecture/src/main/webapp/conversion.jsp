<%-- This is a JSP comment, it will not appear in the rendered HTML --%>

<%-- The next line is a taglib directive. It imports the tag library identified 
by the "uri" attribute and makes it available using the alias provided by
"prefix".  This particular taglib directive imports the JSTL "core" tags.
We can use whatever prefix we want, but it's common to use "c" for this
library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<h1>MVC Views Part 1 - Example: Metric Conversions</h1>
		
		<h2>Inches to Centimeters</h2>
		<table>
			<tr>
				<th>inches</th>
				<th>centimeters</th>
			</tr>
			 
			<%-- The forEach tag can be used to iterate over a range of numbers
		     or over a collection (like the "for each" loop from Java).  The 
		     loop below iterates over the numbers from 1-12 inclusive and 
		     assigns the next number to the scoped variable named "inches" 
		     with each iteration --%>
			<c:forEach begin="1" end="12" var="inches">
				<tr>
					<%-- These are JSP EL expressions.  Anything between the
				    curly braces will be evaluated as an EL expression
				    and the result will be included in the HTML generated
				    by this JSP --%>
					<td>${inches}</td> 
					<td>${inches * 2.54}</td>
				</tr>	
			</c:forEach>
		</table>
		
		<h2>Feet to Meters</h2>
		<table>
			<tr>
				<th>feet</th>
				<th>meters</th>
			</tr>
			 
			<c:forEach begin="1" end="50" var="feet">
				<%-- The "set" tag below allows us to set the value of a scoped
				variable. Here we are setting the value of a scoped variable
				named rowClassAttribute equal to empty string at the start 
				of each loop iteration 
				
				(Note that scoped variables are not "declared" in the same way 
				as Java variables. This variable has "page scope" meaning it 
				is accessible from anywhere in the page, not just within this 
				forEach loop) --%>
				<c:set var="rowClassAttribute" value="" />
				
				<%-- The "if" tag below is very similar to the if statement in
				Java.  If the value of the "test" attribute is true, the body
				of the tag is evaluated, otherwise it is skipped.
				
				One major difference between this tag and a Java if statement
				is that there is no equivalent to an "else" for the if tag.
				See the "choose" tag below for an example of how to do "if/else"
				logic --%>
				<c:if test="${feet % 10 == 0}">
					<c:set var='rowClassAttribute' value='marker' />
				</c:if>
				<tr class="${rowClassAttribute}">
					<td>${feet}</td> 
					<td>${feet * .3048}</td>
				</tr>	
			</c:forEach>
		</table>
		
		<h2>Fahrenheit to Celcius</h2>
		<table>
			<tr>
				<th>fahrenheit</th>
				<th>celcius</th>
			</tr>
			 
			<c:forEach begin="0" end="250" step="5" var="tempF">
				<%-- The "choose" tag below allows us to do "if/else"
				logic. Each of the "when" tags is evaluated in order, 
				if the "test" attribute is true, then the body of the 
				"when" tag is evaluated and then the "choose" tag is 
				exited.  If no "when" tag is executed, then the
				"otherwise" tag is evaluated. --%>				
				<c:choose>
					<c:when test="${tempF <= 32}">
						<c:set var="rowClassAttribute" value="freezing" />
					</c:when>
					<c:when test="${tempF >= 212}">
						<c:set var="rowClassAttribute" value="boiling" />
					</c:when>
					<c:otherwise>
						<c:set var="rowClassAttribute" value="" />
					</c:otherwise>
				</c:choose>
				<tr class="${rowClassAttribute}">
					<td>${tempF}</td> 
					<td>${(tempF - 32) / 1.8}</td>
				</tr>	
			</c:forEach>
		</table>
	</body>
</html>