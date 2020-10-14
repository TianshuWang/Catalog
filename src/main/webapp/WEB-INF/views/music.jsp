<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${music.name}</title>

<style>
input[type=submit] {
	width: 80%;
	background-color: orange;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #FFCC33;
}

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
		<h1 style="margin-bottom: 0;">${music.name}</h1>
	</div>

	<div id="navegation" style="font-weight:600;">
		<ul>
			<li><a href="/catalog" style="color: black;">Index</a></li>
			<li><a href="/catalog/series" style="color: black;">Serie</a></li>
			<li><a href="/catalog/musics" style="color: black;">Music</a></li>
			<li><a href="/catalog/films" style="color: black;">Film</a></li>
		</ul>
	</div>

	<div id="content" style="height: 450px;text-align: center;">	
		<br><p style="width: 280px;margin:0 auto"><b>Artist: </b>${music.type.artist}</p>
		<p><b>Score: </b><fmt:formatNumber type="number" value="${music.score}"	maxFractionDigits="2" /></p>
		<div id="comment"
			style="border-radius: 10px; border: orange solid 2px; width: 280px;margin:0 auto">
			<form method="POST" action="music/comment">
				<p>
					<label for="fname">username:</label> <input name="username"
						type="text" placeholder="Your name.."
						style="border: 1px solid #ccc; border-radius: 4px;" required>
				<p>
					<textarea name="content" rows="5" cols="28"
						style="border: 1px solid #ccc; border-radius: 4px;"
						placeholder="Comment.." required></textarea>
				</p>
				<input name="id" type="hidden" value="${music.id}">
				<p>Score:
					5<input name="score" type="radio" value="5" checked> 4<input
						name="score" type="radio" value="4"> 3<input name="score"
						type="radio" value="3"> 2<input name="score" type="radio"
						value="2"> 1<input name="score" type="radio" value="1">
				</p>
				<p>
					<input type="submit" value="Comment">
				</p>
			</form>
		</div>
	</div>

	<div id="footer"
		style="background-color: orange; color: white; clear: both; padding: 5px;text-align: center">
		Copyright@TianshuWang</div>
</body>

</html>