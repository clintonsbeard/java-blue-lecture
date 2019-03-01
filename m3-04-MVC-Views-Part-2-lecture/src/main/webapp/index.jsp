<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>MVC Views Part 2</title>
		
		<style>
			* {
				font-size: 14pt;
			}
		
			td {
				border: 1px solid black;
				padding: .5em;
			}
			
			code {
				color: red;
			}
		</style>
	</head>
	<body>
		<h1>MVC Views Part 2</h1>
		<table>
			<tr>
				<td><a href="nameList">Name List</a></td>
				<td>
					Check out <code>NameServlet.java</code> and <code>nameList.jsp</code> 
					for a simple example of using "request attributes" to pass data between 
					a controller (i.e. Servlet) and a view (i.e. JSP).
				</td>
			</tr>
			<tr>
				<td><a href="personList">Person List</a></td>
				<td>
					Check out <code>PersonServlet.java</code> and <code>personList.jsp</code> 
					for an example of how the EL dot operator can be used to access JavaBeans
					properties.
				</td>
			</tr>
			<tr>
				<td><a href="scriptlets.jsp">Scriptlets</a></td>
				<td>
					Check out <code>scriptlets.jsp</code> for an example of using scriptlets 
					in a JSP page. <strong>Note that this is legacy technology and should be 
					avoided</strong>.
				</td>
			</tr>
			<tr>
				<td><a href="expressionLanguage.jsp">Expression Language</a></td>
				<td>
					Checkout <code>expressionLanguage.jsp</code> to assorted examples of 
					JSP EL syntax for Maps and Lists as well as examples of different 
					JSP variable scopes.
				</td>
			</tr>
				
		</table>
	</body>
</html>