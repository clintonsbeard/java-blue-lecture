<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<H1>Results</H1>

		<c:forEach var="answers" items="${sessionQuiz.answeredQuestions}" >
			<div>
				<c:out value="${answers.text}" /> : <c:out value="${answers.answer}" />
			</div>
		</c:forEach>

	</body>
</html>