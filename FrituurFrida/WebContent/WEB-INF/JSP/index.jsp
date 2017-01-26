<%@page contentType='text/html' pageEncoding='UTF-8' trimDirectiveWhitespaces ='true'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>  
<fmt:setBundle basename='resourceBundles.teksten'/> 
<!doctype html>
<html lang="nl">
<head>
<fmt:message key="frituurFrida" var="title"/>
<c:import url="/WEB-INF/JSP/head.jsp">
	<c:param name="title" value="${title}"/>
</c:import>
</head>
<body>
	<vdab:menu/>
	<h1><fmt:message key="vandaagZijnWe${openGesloten}"/></h1>
	<fmt:message key="afbeelding${openGesloten}" var="afbeelding"/>
	 <img src='<c:url value="/images/${afbeelding}"/>' alt="<fmt:message key='${openGesloten}'/>"> 
	<footer>
	<h3><fmt:message key="adres"/></h3>
		<p>
			${adres.straat}&nbsp;${adres.huisNr}<br> 
			${adres.gemeente.postCode}&nbsp;${adres.gemeente.naam}
		</p>
		<p>
			Telefoonnummer helpdesk: <a href="${initParam.telNr}">${initParam.telNr}</a>
		</p>
	</footer>
</body>
</html>

