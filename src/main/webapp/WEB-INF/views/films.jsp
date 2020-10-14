<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Film</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.14.1/dojo/dojo.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
<script>
	$(function() {
		$("#submitSearch").click(function() {
			var data = new FormData($("#searchForm")[0]);
			var name = data.get("name");
			var content = data.get("content");
			var url = "/catalog/films/search?name=" + name + "&content=" + content;
			$.ajax({
				url : url,
				success : function(result) {
					$("#content").html(result);
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
					$("#content").html(XmlHttpRequest.responseText);
				}
			});
		});
	});

	$(function() {
		$("#menu a").click(function() {
			var name = $(this).attr("name");
			var content = $(this).attr("content");
			var url = "/catalog/films/search?name=" + name + "&content=" + content;
			$.ajax({
				url : url,
				success : function(result) {
					$("#content").html(result);
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
					$("#content").html(XmlHttpRequest.responseText);
				}
			});
		});
	});

	$(function() {
		$("#content a").click(function() {
			var idFilm = $(this).attr("idFilm");
			var url = "/catalog/films/film?id=" + idFilm;
			$.ajax({
				url : url,
				success : function(result) {
					$("#content").html(result);
				},
			});

		});
	});

</script>

<style>
input[type=search] {
	width: 50%;
	padding: 10px 10px;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
	background-color: #FFFFFF;
}

.navegation ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #FFE4B5;
}

.navegation li {
	float: left;
}

.navegation li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.navegation li a:hover {
	background-color: #FFCC00;
}

#menu ul {
	list-style-type: none;
	margin: 0;
	padding: 10px 15px;
	overflow: hidden;
}

#menu li a {
	margin: 15px;
	text-decoration: none;
}

#menu li a:link {
	color: grey;
}

#menu li a:hover {
	color: orange;
}

#header a:visted {
	color: red;
}

#footer {
	text-algn: center;
	background-color: orange;
	color: white;
	clear: both;
	padding: 5px;
	text-align: center
}

#submitSearch {
	width: 80px;
	height: 35px;
	background-color: orange;
	color: white;
	position: relative; top : 6px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	top: 6px;
	display:inline;
}
</style>
</head>

<body style="font-family: verdana;">
	<div id="header" style="background-color: orange; color: white; padding: 20px; text-align: center;">
		<h1 style="margin-bottom: 0;">Film</h1>
	</div>

	<div id="navegation" class="navegation" style="font-weight: 600;">
		<ul>
			<li>
				<a href="/catalog" style="color: black;">Index</a>
			</li>
			<li>
				<a href="/catalog/series" style="color: black;">Serie</a>
			</li>
			<li>
				<a href="/catalog/musics" style="color: black;">Music</a>
			</li>
			<li>
				<a href="/catalog/films" style="color: black;">Film</a>
			</li>
			<li>
				<div>
					<form id="searchForm" method="post" style="float:left;">
						<input name="name" type="hidden" value="Name">
						<input name="content" type="search" placeholder="Search Film By Name.."
							style="position: relative; top: 7px; width: 400px; height: 35px">
					</form>
					<button id="submitSearch">Search</button>
				</div>
			</li>
		</ul>
	</div>

	<div id="menu" class="menu" style="font-size: 15px">
		<ul>
			<li>
				<span style="color: black">By Category</span>
				<span>
					<a name="All" content="All" href="javascript:void(0)">All</a>
				</span>
				<c:forEach items="${filmCategories}" var="c">
					<span>
						<a name="Category" content="${c.name}" href="javascript:void(0)">${c.name}</a>
					</span>
				</c:forEach>
				<hr />
			</li>

			<li>
				<span style="color: black">By Year</span>
				<span>
					<a name="All" content="All" href="javascript:void(0)">All</a>
				</span>
				<span>
					<a name="Year" content="2020" href="javascript:void(0)">2020</a>
				</span>
				<span>
					<a name="Year" content="2019" href="javascript:void(0)">2019</a>
				</span>
				<span>
					<a name="Year" content="2018" href="javascript:void(0)">2018</a>
				</span>
				<span>
					<a name="Year" content="2017" href="javascript:void(0)">2017</a>
				</span>
				<span>
					<a name="Year" content="2016" href="javascript:void(0)">2016</a>
				</span>
				<span>
					<a name="Year" content="2015" href="javascript:void(0)">2015</a>
				</span>
				<hr />
			</li>

			<li>
				<span style="color: black">By Origin</span>
				<span>
					<a name="All" content="All" href="javascript:void(0)">All</a>
				</span>
				<c:forEach items="${filmOrigins}" var="o">
					<span>
						<a name="Origin" content="${o}" href="javascript:void(0)">${o}</a>
					</span>
				</c:forEach>
				<hr />
			</li>

			<li>
				<span style="color: black">By Score</span>
				<span>
					<a name="All" content="All" href="javascript:void(0)">All</a>
				</span>
				<span>
					<a name="Score" content="1" href="javascript:void(0)">1</a>
				</span>
				<span>
					<a name="Score" content="2" href="javascript:void(0)">2</a>
				</span>
				<span>
					<a name="Score" content="3" href="javascript:void(0)">3</a>
				</span>
				<span>
					<a name="Score" content="4" href="javascript:void(0)">4</a>
				</span>
				<span>
					<a name="Score" content="5" href="javascript:void(0)">5</a>
				</span>
				<hr />
			</li>
		</ul>
	</div>

	<div id="content" style="height: 500px">
		<table border='0' cellspacing="10" cellpadding="10">
			<c:forEach items="${films}" var="film">
				<td>
					<a idFilm="${film.id}" href="javascript:void(0)" style="color: black;">${film.name}</a>
				</td>
			</c:forEach>
		</table>
	</div>

	<div id="footer">Copyright@TianshuWang</div>

</body>
</html>