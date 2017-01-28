<%@ page contentType='text/html' pageEncoding='UTF-8'%> 
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%> 
<!doctype html> 
<html lang='nl'> 
<head> 
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Inloggen"/>
</c:import>
</head> 
<body> 
	<h1>Inloggen</h1>
	<form method="post">
		<label>Paswoord:<span>${fout}</span>
		<input name="paswoord" autofocus required type="password">
		</label>
		<input type="submit" value="Inloggen">
	</form>
</body> 
</html> 