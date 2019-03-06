<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="subTitle">Stocks</c:param>
</c:import>

<%-- TODO: Fill this is with live data --%>

<ul id="stockTicker">
	<c:url var="purchaseUrl" value="/stockPurchase"/>
	<c:forEach var="stock" items="${stocks}">
	<li class="stock">
		<c:choose>
			<c:when test="${stock.change < 0}">
				<c:set var="changeClass" value="down"/>
			</c:when>
			<c:otherwise>
				<c:set var="changeClass" value="up"/>
			</c:otherwise>
		</c:choose>
		
		<span class="name">${stock.ticker}</span>
		<span class="price">${stock.price}</span>
		<span class="change ${changeClass}">${stock.change}</span>
		<form action="${purchaseUrl}" method="GET">
			<input type="hidden" name="ticker" value="${stock.ticker}">
			<input type="submit" value="Buy">
		</form>
	</li>
	</c:forEach>
</ul>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />