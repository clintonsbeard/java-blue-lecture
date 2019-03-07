<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="All Actors List"/>

<%@include file="../common/header.jspf"%>

<section id="main-content"  class="centeredPanel">

<c:url value="/mailingList/submit" var="mailingListSignUpUrl" />

<form:form action="${mailingListSignUpUrl}" method="POST" modelAttribute="signup">
		
	
        <div>
        		<label for="name">Name</label>
        		<form:input path="name"/>
        		<form:errors path="name" cssClass="error"/>

        		
        </div>
        <div>
            <label for="email">Email</label>
			<form:input path="email" />            
        		<form:errors path="email" cssClass="error"/>
        		<form:errors path="emailMatching" cssClass="error"/>

            
            
        </div>
        <div>
            <label for="verifyEmail">Verify Email</label>
            <form:input path="verifyEmail" />
                    		<form:errors path="verifyEmail" cssClass="error"/>
            
        </div>
        <div>
            <label for="phone">Phone Number (XXX)XXX-XXXX</label>
            <form:input path="phone" />
                    		<form:errors path="phone" cssClass="error"/>
            
        </div>
        <div>
            <label for="occupation">Occupation</label>
           <form:input path="occupation" />
                   		<form:errors path="occupation" cssClass="error"/>
           
        </div>
        <div>
            <label for="age">Age</label>
            <form:input path="age" />
                    		<form:errors path="age" cssClass="error"/>
            
        </div>
        <div>
            <input type="submit" value="Sign Me Up!"/>
        </div>
        
     
</form:form>
</section>
<%@include file="../common/footer.jspf"%>