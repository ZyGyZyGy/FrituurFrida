<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>  
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Saus raden" />
</c:import>
</head>
<body>
	<vdab:menu/>
	<h1>Saus raden</h1>
	<c:choose>
		<c:when test="${sausRadenSpel.verloren}">
			U hebt verloren, de saus was ${sausRadenSpel.saus}.
		</c:when>
		<c:when test="${sausRadenSpel.gewonnen}">
			U hebt gewonnen, de saus was ${sausRadenSpel.saus}.
		</c:when>
		<c:otherwise> 
        Te raden saus: ${sausRadenSpel.sausMetPuntjes} 
        <form method='post' id='radenform'>
				<label>letter: 
					<input name='letter' size='1' maxlength='1' autofocus required>
				</label> 
				<input type='submit' value='Raden' id='radenknop'>
			</form>
			<script>
				document.getElementById('radenform').onsubmit = function() {
					document.getElementById('radenknop').disabled = true;
				};
			</script>
		</c:otherwise>
	</c:choose>
	<c:url value='' var='nieuwSpelURL'>
		<c:param name='nieuwSpel' value='true' />
	</c:url>
	<form method='post' action='${nieuwSpelURL}'>
		<input type='submit' value='Nieuw spel'>
	</form>
	<img
		src="<c:url value='/images/${sausRadenSpel.verkeerdeBeurten}.png'/>"
		alt='${sausRadenSpel.verkeerdeBeurten} verkeerde beurten'
	>
</body>
</html>
