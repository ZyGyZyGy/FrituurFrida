<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang="nl">
<head>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="Sauzen"></c:param>
</c:import>
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp"></c:import>
	 <form method='post' action="<c:url value="/sauzen/verwijderen.htm"/>"> 
		<ul class="saus">
			<c:forEach var="saus" items="${sauzen}">
				<li>
				<label>
				<input type="checkbox" name="id" value="${saus.nummer}">
				</label>
				<img src=" <c:url value='images/${saus.naam}.png' /> " alt="${saus.naam}"><strong>${saus.naam}:</strong> 
					<c:forEach var="ingredient" items="${saus.ingredienten}" varStatus="status">${ingredient}  
 						<c:if test="${!status.last}">, </c:if>
					</c:forEach>
				</li>
			</c:forEach>
		</ul>
		<label>
			<input type="submit" value="Aangevinkte sauzen verwijderen" id="verwijderKnop">
		</label>
	</form>
</body>
</html>


