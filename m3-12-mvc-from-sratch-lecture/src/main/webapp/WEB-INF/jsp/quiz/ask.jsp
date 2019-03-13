<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<body>
		<H1><c:out value="${question.text}" /></H1>

		<c:url var="answerUrl" value="/ask" />
		<form action="${answerUrl}" method="POST">
			<label for="answer">Your Answer:</label>
			<input type="text" name="answer" id="answer" />
			<input type="submit" value="Submit Answer" />
		</form>

	</body>
</html>
