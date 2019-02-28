<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	<head>
		<title>JSP Expression Language Lecture Notes</title>
		<style>
			b {
				color: red;
				font-weight: normal;
			}
			
			td {
				border: 1px solid black;
				padding: .5em;
			}
			
			th {
				border: 1px solid black;
				padding: .5em;
			}
		</style>
	</head>
	<body>
		
		<h2>Identifiers and Scope</h2>
		<p>Every JSP EL variable is stored in one of four scopes: page, request, session, or application.
		     We will only use the first three.</p>
		
		<c:set var="myPageVar" value="Larry" scope="page" />
		<c:set var="myRequestVar" value="Curly" scope="request" />
		<c:set var="mySessionVar" value="Moe" scope="session" />
		
		<ul>
			<li>Value of <em>pageScope.myPageVar</em> is: <b>${pageScope.myPageVar}</b></li>
			<li>Value of <em>requestScope.myRequestVar</em> is: <b>${requestScope.myRequestVar}</b></li>
			<li>Value of <em>sessionScope.mySessionVar</em> is: <b>${sessionScope.mySessionVar}</b></li>
		</ul>
		
		<p>Identifiers can also be used within JSP EL expressions without specifying a scope.  In this case, all of the scopes
		are searched for the identifier</p>
		
		<ul>
			<li>Value of <em>myPageVar</em> is: <b>${myPageVar}</b></li>
			<li>Value of <em>myRequestVar</em> is: <b>${myRequestVar}</b></li>
			<li>Value of <em>mySessionVar</em> is: <b>${mySessionVar}</b></li>
		</ul>
		
		<p>When searching the various scopes for an identifier, they are searched in the following order:</p>
		<ol>
			<li>pageScope</li>
			<li>requestScope</li>
			<li>sessionScope</li>
		</ol>
		
		<c:set var="ambiguousReference" value="ambiguousReference is in session scope" scope="session" />
		<c:set var="ambiguousReference" value="ambiguousReference is in request scope" scope="request" />
		
		<p>So, for instance, if an identifier appears in both requestScope and sessionScope, the requestScope identifier 
		   takes precedence when the identifier is referenced without a scope qualifier</p>
		   
		<ul>
			<li>Value of <em>requestScope.ambiguousReference</em> is: <b>${requestScope.ambiguousReference}</b></li>
			<li>Value of <em>sessionScope.ambiguousReference</em> is: <b>${sessionScope.ambiguousReference}</b></li>
			<li>Value of <em>ambiguousReference</em> is: <b>${ambiguousReference}</b></li>
		</ul>
		
		<h2>Arrays, Lists, and Maps</h2>
		<c:set var="stringList" value="${['Three', 'Blind', 'Mice']}" />

		<p>Array elements are referenced in JSP EL in the same way as Java.  However, one difference
		   is that Lists can also be referenced using the same syntax as arrays</p>
		<ul>
			<li><em>stringList[2]</em> is <b>${stringList[2]}</b></li>
		</ul> 
		
		<p>Map elements can be accessed using the same syntax as JavaBeans object attributes.  The key name
	       is used after the dot operator in the same way a property name is used with a JavaBean. </p>
	    
	    <jsp:useBean id="model2Manufacturer" class="java.util.HashMap"/>
	    <c:set target="${model2Manufacturer}" property="Mustang" value="Ford" />
	    <c:set target="${model2Manufacturer}" property="Focus" value="Ford" />
	    <c:set target="${model2Manufacturer}" property="Accord" value="Honda" />
	    <c:set target="${model2Manufacturer}" property="Camry" value="Toyota" />

	    <p>The Mustang is made by <b>${model2Manufacturer.Mustang}</b>.</p>
	    <p>The Camry is made by <b>${model2Manufacturer.Camry}</b>.</p>
	       
	</body>
</html>