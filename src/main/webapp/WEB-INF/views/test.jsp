<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
<script src="//ajax.googleapis.com/ajax/libs/dojo/1.14.1/dojo/dojo.js"></script>
</head>
<script>
	require(["dojo/query", "dojo/on", "dojo/request", "dojo/dom","dojo/dom-attr","dojo/_base/array","dojo/domReady!"], function(query,on,request,dom,domAttr,arrayUtil) {
		var content = dom.byId("content");
		var links = query("#menu a");

		on(links,"click",function(){
			request.get("/catalog/films/testFilms",{
				handleAs: "json"
			}).then(
				function(data){
					var html="<h1>Films</h1>";
					arrayUtil.forEach(data.Films, function(film,i){
		                html += "<p><a href='/catalog/films/film?id=" + film.id +"'>" + film.name + 
		                		          		
		                		"</a></p>";
		                   
		            });
					content.innerHTML = html;
	            },	            
	            function(error){
                	content.innerHTML = error;
            	}
         	);
		});
	});
</script>
<body>
	<div id="menu">
		<a  href="javascript:void(0)">Get Films</a>
	</div>

	
	<div id="content">
		
	</div>
</body>
</html>