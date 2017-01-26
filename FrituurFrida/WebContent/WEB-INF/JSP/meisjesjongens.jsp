<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%> 
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Meisjes jongens" />
</c:import>
</head>
<body class="${cookie.geslacht.value}">
	<vdab:menu/>
	<h1>Meisjes jongens</h1>
	<form method="post">
		<input type="submit" name="meisjesjongens" value="meisjes"> <input
			type="submit" name="meisjesjongens" value="jongens">
	</form>
</body>
</html>
