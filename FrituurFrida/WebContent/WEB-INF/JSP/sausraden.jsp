<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Saus raden" />
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<form method="post">
		Te raden saus is: 
		<c:forEach items="${sausRadenSpel.saus.tekens}" var="teken">
			.
		</c:forEach><br>
		letter:<br>
		<input type="text" maxlength="1" size="1" name="ingetypeTeken" autofocus required><br>
		<input type="submit" value="Raden"><br>
		<input type="submit" value="Nieuw spel">
	</form>
	
	<p>te raden saus is: ${sausRadenSpel.saus.naam}</p>
</body>
</html>
