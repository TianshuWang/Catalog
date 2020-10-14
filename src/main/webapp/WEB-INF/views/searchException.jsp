<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Did Not Found The Film</title>

</head>

<body style="font-family: verdana;">
	<%
		String name = request.getParameter("name");
		String content = request.getParameter("content");
	%>
	
	<div id="content" style="height: 450px">
		<table border='0' cellspacing="10" cellpadding="10">
			<td>
				<span>
					Didn't Found Films By
					<%=name%>
					<%=content%></span>
			</td>
		</table>
	</div>

</body>
</html>