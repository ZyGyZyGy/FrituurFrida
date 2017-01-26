<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%> 
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Gastenboek" />
</c:import>
</head>
<body>
	<vdab:menu />
	<h1>Gastenboek</h1>
	<c:choose>
		<c:when test="${empty param.toevoegen}">
			<a href=" <c:url value='/gastenboek.htm?toevoegen=true'/> ">Toevoegen</a>
		</c:when>
		<c:otherwise>
			 <form method='post'> 
			      <label>Naam:<span>${fouten.naam}</span>
			      <input name='naam' autofocus required value='${param.naam}'>
			      </label> 
			      <label>Bericht:<span>${fouten.bericht}</span>
			      <textarea name='bericht' required rows='5' cols='80'>${param.bericht}</textarea>
			      </label> 
			      <input type='submit' value='Toevoegen' name='toevoegen'> 
    		</form> 
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty gastenboek}">
		<dl>
			<c:forEach var="entry" items="${gastenboek}">
				<fmt:parseDate value="${entry.datum}" pattern="yyyy-MM-dd" var="datumAlsDate" type="date"/>
				<dt>
					<fmt:formatDate value="${datumAlsDate}" type="date" dateStyle="short"/>&nbsp;${entry.naam}
				</dt>
				<dd>${entry.bericht}</dd>
			</c:forEach>
		</dl>
	</c:if>
</body>
</html>
