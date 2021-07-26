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
if(request.getParameter("type").equals("0"))
	out.println("Enter Admin name and password");
%>

<form action ="login">
<input type ="text" name ="admin" placeholder="enter admin Name"/> <p>
<input type= "password" name="pwd" placeholder="enter pwd"/>
<p><input type ="submit"  value="login"/>
<% 
out.println("<p>If Admin Is New Then");
%>
</form>
</body>
  <a href="pages/signup.jsp">SignUp</a>Here;
</html>