<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments Of ${film.name}</title>
<style>
</style>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
#content ul {
	list-style-type: none;
}
</style>

<body style="font-family: verdana; height: 450px;">

	<div id="content" class="content">
		<h3 style="text-align: center">${film.name}</h3>
		<hr>
		<c:forEach items="${film.comments}" var="comment">
			<ul>
				<li>
					<b>${comment.username}</b>
				</li>
				<li>
					<b>Score:</b>${comment.score}
				</li>
				<li>
					<b>Says:</b>${comment.content}
				</li>
				<li>	
			</ul>
			<hr>
		</c:forEach>
	</div>
</body>
</html>