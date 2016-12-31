<%@page import="java.time.DayOfWeek"%>
<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@page import='java.io.PrintWriter'%>
<%@page import='java.time.LocalDateTime'%>
<!doctype html>
<html lang="nl">
<head>
<title>Frituur Frida</title>
</head>
<body>
	<h1>
		<%
			DayOfWeek dag = LocalDateTime.now().getDayOfWeek();
			out.println(dag == DayOfWeek.MONDAY || dag == DayOfWeek.THURSDAY ? "Vandaag zijn we gesloten"
					: "Vandaag zijn we open");
		%>
	</h1>
</body>
</html>
