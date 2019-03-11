<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle" value="Mortgage Calculator" />
</c:import>

<h2>Your Calculated Mortgage Payment</h2>

<table id="loanPaymentCalculationResults">
	<tr>
		<th>Loan Amount:</th>
		<td>$<c:out value="${param.loanAmount}" /></td>
	</tr>
	<tr>
		<th>Loan Term:</th>
		<td><c:out value="${param.loanTerm}" /> years</td>
	</tr>
	<tr>
		<th>Interest Rate:</th>
		<td><c:out value="${param.rate}" />%</td>
	</tr>
	<tr>
		<th>Monthly Payment:</th>
		<td><c:out value="${estimate.monthlyPayment}" /></td>
	</tr>
</table>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />