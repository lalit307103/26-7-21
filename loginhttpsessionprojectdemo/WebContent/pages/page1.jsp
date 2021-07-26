<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String target;
if(Math.random() < 0.5)
            target ="page2.jsp";

else
            target = "page2.jsp";
	
%>
<h1> i m first jsp file</h1>
<jsp:forward page="<%= target%>"/>
</body>
</html>