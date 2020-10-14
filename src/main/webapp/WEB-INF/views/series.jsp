<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Serie</title>

<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #FFE4B5;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #FFCC00;
}
</style>
</head>

<body style="font-family: verdana;">
	<div id="header"
		style="background-color: orange; color: white; padding: 20px; text-align: center;">
		<h1 style="margin-bottom: 0;">Serie</h1>
	</div>

	<div id="navegation" style="font-weight:600;">
		<ul>
			<li><a href="/catalog" style="color: black;">Index</a></li>
			<li><a href="/catalog/series" style="color: black;">Serie</a></li>
			<li><a href="/catalog/musics" style="color: black;">Music</a></li>
			<li><a href="/catalog/films" style="color: black;">Film</a></li>
		</ul>
	</div>
	
	<div id="content" style="height: 450px">
		<table border='0' cellspacing="10" cellpadding="10">
			<c:forEach items="${series}" var="serie">
				<td><a href="series/serie?id=${serie.id}" style="color: black">${serie.name}</a></td>
			</c:forEach>
		</table>
	</div>

	<div id="footer"
		style="background-color: orange; color: white; clear: both; padding: 5px; text-align: center">
		Copyright@TianshuWang</div>
</body>
</html>