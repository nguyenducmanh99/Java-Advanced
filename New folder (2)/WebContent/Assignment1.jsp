<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment1</title>
</head>
<body>
<%@ page errorPage="error.jsp" %>
<h1>Xin Chao: Nguyenducmanh</h1>
<%-- Today is: <%=new Date() %> --%>
  <form action="header.jsp">
  <input type="text" name="username">
  <input type="submit" value="enter"> 
 </form> 
 
 <!-- Form login
 <div style="border:1px solid #D0D0D0;width:400px;padding:10px;">
 
    <form method = "GET" action="formProcessing.jsp">
        User Name: <input type="text" name="userName" value="">
        <br>
        Password : <input type="password" name="password" value=""> 
 -->

</body>
</html>