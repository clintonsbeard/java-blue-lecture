<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle" value="Mortgage Calculator" />
</c:import>

<h2>Mortgage Calculator</h2>
<c:url var="formAction" value="/mortgageCalculatorResult" />
<form method="GET" action="${formAction}">
	<div class="formInputGroup">
		<label for="loanAmount">Loan Amount:</label> 
		<input type="text" name="loanAmount" id="loanAmount" />
	</div>
	<div class="formInputGroup">
		<label for="loanTerm">Loan Term:</label> 
		<select name="loanTerm"	id="loanTerm">
			<option value="10">10 Years</option>
			<option value="15">15 Years</option>
			<option value="30">30 Years</option>
		</select>
	</div>
	<div class="formInputGroup">
		<label for="rate">Interest Rate:</label> 
		<input type="text" name="rate" id="rate" />
	</div>
	<input class="formSubmitButton" type="submit" value="Calculate Payment" />
</form>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />