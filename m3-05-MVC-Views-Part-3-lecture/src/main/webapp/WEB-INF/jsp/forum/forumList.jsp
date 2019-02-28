<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp">
    <c:param name="pageTitle" value="The Solar System Geek Forum" />
</c:import>

<ul>
	<c:forEach var="topic" items="${topicList}">
		<c:url var="forumPostHref" value="/forum/forumDetail">
			<c:param name="forumId">${topic.id}</c:param>
		</c:url>
		<li><a href="${forumPostHref}">${topic.title}</li>
	</c:forEach>
</ul>

<c:import url="/WEB-INF/jsp/footer.jsp" />