<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment1</title>
</head>
<body>
<h3>User Register</h3>
<div style="border:1px solid #D0D0D0;width:400px;padding:10px;">
 
    <form method = "GET" action="formProcessing.jsp">
        User Name: <input type="text" name="userName" value="">
        <br>
        Password : <input type="password" name="password" value="">
 
        <hr>
        First Name: <input type="text" name="firstName">
        <br>
        Last Name: <input type="text" name="lastName">
        <br>
        Gender: <input type="radio" name="gender" value ="M"> Male
                <input type="radio" name="gender" value="F"> Female
        <hr>
        Address:
        <br>
        <input type="text" name="address" size="50">
        <input type="text" name="address" size="50">
        <input type="text" name="address" size="50">      
        <hr>        
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>