<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SAML Source Site Application Welcome Page</title>
</head>
<body style="background-color:#f4d2c9">
<h2>Welcome <%=request.getRemoteUser()%>!</h2>
<p>
    You have been successfully authenticated with application appA.
</p>
<p>
	Following are the applications on trusted domains that are pariticipating in Single Sign-On
</p>
<ul>
   <li>
    <a href="http://localhost:7003/appB/admin/services.jsp" >Application - appB on domainB</a>
   </li>
   <li> 
    <a href="#" >Some Other application on trusted domain</a>
    </li>
</ul>
</p>
</body>
</html>