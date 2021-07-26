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
   response.sendRedirect("signup.jsp?type=0");

%>
 
 
 <h1 align ="center"><u>Admin SignUp</u></h1>
<form action ="signup" align = "center" method="get">
<input type= "text" name="admin_name" placeholder="Admin name" required/>
<p>
<input type= "text" name="admin_pwd" placeholder="Admin Password" required />
<p>
<p> <input type ="submit"  value="signup"/>                   
</form>
</body>
</html>