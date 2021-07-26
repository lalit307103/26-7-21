<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 

if(session.getAttribute("login") == null)
   response.sendRedirect("signin.jsp?type=0");

%>
<h1> <font color="turquoise"> welcome to home page for further navigation </font></h1>
<p>  <a  href="pages/youtube.jsp">youtube</a>
<p>  <a  href="pages/html.jsp">HTML</a>
<p>  <a  href="pages/facebook.jsp">Facebook</a>

</body>
</html>