<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../common/header.jspf"%>

<section id="main-content"  class="centeredPanel">
	<h2>Thank You for signing up, <c:out value="${signup.name}" /></h2>
	<p>You email ${signup.email} has been added to our mailing list!</p>
</section>

<%@include file="../common/footer.jspf"%>