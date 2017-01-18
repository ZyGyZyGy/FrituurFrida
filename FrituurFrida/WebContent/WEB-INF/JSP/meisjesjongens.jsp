<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp" />
</head>
<body class="${cookie.geslacht.value}">
	<c:import url="/WEB-INF/JSP/menu.jsp">
		<c:param name="title" value="Meisjes jongens" />
	</c:import>
	<h1>Meisjes jongens</h1>
	<form method="post">
		<input type="submit" name="meisjesjongens" value="meisjes"> <input
			type="submit" name="meisjesjongens" value="jongens">
	</form>
	<p>
		U hebt op <b>${geslacht}</b> geklikt
	</p>
</body>
</html>
