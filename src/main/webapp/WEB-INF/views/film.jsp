<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${film.name}</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.2/jquery.validate.min.js"></script>
<script>
	$(function() {
		$("#submitComment").click(function() {
			var data = new FormData($("#commentForm")[0]);
			var id = data.get("id");
			var username = data.get("username");
			var content = data.get("content");
			var score = data.get("score");
			var url = "/catalog/films/film/comment?id=" + id + "&username=" + username + "&content=" + content + "&score=" + score;
			$.ajax({
				url : url,
				success : function(result) {
					$("#comments").html(result);
				},
			});
		});
	});
</script>
<style>
input[type=submit], button {
	background-color: orange;
	color: white;
	padding: 10px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	width: 300px;
}

input[type=submit]:hover {
	background-color: #FFCC33;
}

#comment, button {
	margin: 0 auto;
}

#showComments ul {
	list-style-type: none;
}

.whiteOverlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 900px;
	background-color: white;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 88);
}

#showComments {
	display: none;
	position: absolute;
	top: 50%;
	left: 33%;
	width: 55%;
	height: 60%;
	padding: 20px;
	border: 1px solid grey;
	border-radius: 10px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
	box-shadow: 3px 3px 3px grey;
	margin: 0 auto;
	word-wrap: break-word;
	word-break: break-all;
}

#close {
	width: 200px;
	position: relative;
	left: 28%;
}

#content p {
	text-align: center;
}
</style>
</head>

<body style="font-family: verdana;">

	<div id="content" style="height: 450px;">
		<p>
			<b>Name: </b>${film.name}</p>
		<p>
			<b>Category: </b>${film.type.category.name}</p>
		<p>
			<b>Year: </b>${film.type.year}</p>
		<p>
			<b>Origin: </b>${film.type.origin}</p>
		<p>
			<b>Score: </b>
			<fmt:formatNumber type="number" value="${film.score}" maxFractionDigits="2" />
		</p>


		<div id="comment" style="border-radius: 15px; border: orange solid 2px; width: 420px;">
			<form id="commentForm" method="post">
				<input name="id" type="hidden" value="${film.id}">
				<p>
					<label for="username">username:</label>
					<input id="username" name="username" type="text" placeholder="Your Username.."
						style="border: 1px solid #ccc; border-radius: 4px; width: 245px;">
				</p>
				<p>
					<textarea id="content" name="content" rows="5" cols="55" style="border: 1px solid #ccc; border-radius: 4px;"
						placeholder="Your Comment.."></textarea>
				</p>
				<p>
					Score: 5
					<input name="score" type="radio" value="5" checked>
					4
					<input name="score" type="radio" value="4">
					3
					<input name="score" type="radio" value="3">
					2
					<input name="score" type="radio" value="2">
					1
					<input name="score" type="radio" value="1">
				</p>

			</form>
			<p>
				<button id="submitComment"
					onclick="document.getElementById('showComments').style.display='block';document.getElementById('fade').style.display='block'">
					Comment</button>
			</p>
		</div>

		<div id="showComments" style="height: 450px; width: 450px;">
			<div id="comments"></div>
			<button id="close"
				onclick="document.getElementById('showComments').style.display='none';document.getElementById('fade').style.display='none'">Close</button>
		</div>

		<div id="fade" class="whiteOverlay"></div>
	</div>

</body>
</html>