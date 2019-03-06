<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>
		Fly By Night Bank 
	  	<c:if test="${param.subTitle != null}"> - <c:out value="${param.subTitle}"/></c:if>
	</title>
	<c:url var="stylesheetHref" value="/css/flybynight.css" />
	<link rel="stylesheet" href="${stylesheetHref}">
</head>
<body>
	<header>
		<c:url var="logoImgSrc" value="/img/fbn/flybynightlogo.png" />
		<img src="${logoImgSrc}" alt="Fly By Night Bank">
		<p class="motto">At Fly By Night, we treat your money as if it's our own.</p>
	</header>
	<nav>
		<ul>
			<c:url var="homePageHref" value="/" />
			<li><a href="${homePageHref}">Home</a></li>
			<li><a href="#">Log In or Enroll</a></li>
			<li><a href="#">Why Fly By Night</a></li>
			<c:url var="stocksHref" value="/fbn/stocks" />
			<li><a href="${stocksHref}">Stocks</a></li>
		</ul>
	</nav>
	<div id="container" class="wrapper">
