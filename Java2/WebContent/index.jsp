<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NDM</title>
</head>
<body>
<%@ page errorPage="error.jsp" %>
<h1>Nguyen Duc Manh</h1>
 	<form action="login" method="post">
 	Nhap ten cua ban:<input type="text" name="name">
 	<br>
 	Nhap pass cua ban:<input type="password" name="password">
 	<br>
 	<input type="submit" value="login">
 </form>
</body>
</html>