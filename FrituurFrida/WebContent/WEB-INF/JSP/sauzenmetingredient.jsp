<%@page contentType='text/html' pageEncoding='UTF-8' session='false'
	trimDirectiveWhitespaces='true'
%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Sauzen met ingredi&euml;nt"></c:param>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>Sauzen met ingredi&euml;nt</h1>
	<form>
		<label>Ingredi&euml;nt<span>${fouten.ingredient}</span> 
			<input name="ingredient" value="${param.ingredient}" type="text" placeholder="Typ een ingredi&euml;nt in" required autofocus>
		</label> <input type="submit" value="Zoeken">
	</form>
	<c:if test="${not empty sauzen}">
		<ul class="saus">
			<c:forEach var="saus" items="${sauzen}">
				<li><img src=" <c:url value='/images/${saus.naam}.png'/> " alt="${saus.naam}"><strong>${saus.naam}:</strong>
					<c:forEach var="ingredient" items="${saus.ingredienten}"
						varStatus="status"
					>${ingredient}  
 					<c:if test="${!status.last}">, </c:if>
					</c:forEach></li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${not empty param and empty fouten and empty sauzen}">
		<div class="fout">Geen sauzen gevonden</div>
	</c:if>
</body>
</html>
