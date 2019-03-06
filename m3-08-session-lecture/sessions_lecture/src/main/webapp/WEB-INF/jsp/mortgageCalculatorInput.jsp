<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle" value="Mortgage Calculator" />
</c:import>

<h2>Mortgage Calculator</h2>
<c:url var="formAction" value="/mortgageCalculatorResult" />
<form method="GET" action="${formAction}">
	<c:set var="className" value="" />
	<c:if test="${errors.loanAmount}">
		<c:set var="className" value="error"/>
	</c:if>
	<div class="formInputGroup">
		<label for="loanAmount">Loan Amount:</label> 
		<input class="${className}" type="text" name="loanAmount" id="loanAmount" value="${estimate.loanAmount}"/>
	</div>
	
	<c:set var="className" value="" />
	<c:if test="${errors.loanTerm}">
		<c:set var="className" value="error"/>
	</c:if>
	<div class="formInputGroup">
		<label for="loanTerm">Loan Term:</label> 
		<select class="${className}" name="loanTerm" id="loanTerm">
			<option value="10">10 Years</option>
			<option value="15">15 Years</option>
			<option value="30">30 Years</option>
		</select>
	</div>
	
	<c:set var="className" value="" />
	<c:if test="${errors.rate}">
		<c:set var="className" value="error"/>
	</c:if>
	<div class="formInputGroup">
		<label for="rate">Interest Rate:</label> 
		<input class="${className}" type="text" name="rate" id="rate" />
	</div>
	<input class="formSubmitButton" type="submit" value="Calculate Payment" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />