<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Frituur Frida"></c:param>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	<h1>Vandaag zijn we ${openGesloten}</h1>
	<img src="images/${openGesloten}.png" alt="${openGesloten}" width="599"
		height="202"
	>
	<footer>
		<p>
			${adres.straat} ${adres.huisNr}<br> 
			${adres.gemeente.postCode} ${adres.gemeente.naam}
		</p>
		<p>
			Telefoonnummer helpdesk: <a href="${initParam.telNr}">${initParam.telNr}</a>
		</p>
	</footer>
</body>
</html>

