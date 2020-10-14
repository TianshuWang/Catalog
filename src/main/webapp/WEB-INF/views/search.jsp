<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Films by ${criteria.name} ${criteria.content}</title>
<script>
$(function(){
	$("#content a").click(function(){
	var idFilm = $(this).attr("idFilm");
	var url = "/catalog/films/film?id="+idFilm;
		$.ajax({
			url:url,
			success: function(result) {  
				$("#content").html(result);
		      },  
		});
	});
});
</script>
</head>

<body style="font-family:verdana;">
	<div id="content" style="height: 450px">
		<table border='0' cellspacing="10" cellpadding="10">
			<c:forEach items="${films}" var="film">
				<td><a idFilm="${film.id}" href="javascript:void(0)" style="color: black;">${film.name}</a></td>
			</c:forEach>
		</table>
	</div>
		
</body>
</html>