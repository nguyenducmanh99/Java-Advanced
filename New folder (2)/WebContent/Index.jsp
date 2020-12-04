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

 <!-- <form action="header.jsp">
  <input type="text" name="username">
  <input type="submit" value="enter"> 
 </form> -->
 
 <!-- Form login -->
 <!-- <div style="border:1px solid #D0D0D0;width:400px;padding:10px;">
 
    <form method = "GET" action="formProcessing.jsp">
        User Name: <input type="text" name="userName" value="">
        <br>
        Password : <input type="password" name="password" value=""> -->

 <!-- 	</form> -->
	<form name="myform">
		So thu 1 <input type="text" name="so1"><br>
		So thu 2 <input type="text" name="so2"><br><br>
		<input type="button" name="" value="+" onclick="add()">
		<input type="button" name="" value="-" onclick="subtract()">
		<input type="button" name="" value="*" onclick="multiply()">
		<input type="button" name="" value="/" onclick="divide()"><br>
		<br> <input type="text" name="result">
		
		
	</form>

	<script type="text/javascript">
		function add() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 + so2;
			myform.result.value = result;
		}
		function subtract() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 - so2;
			myform.result.value = result;
		}
		function multiply() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 * so2;
			myform.result.value = result;
		}
		function divide() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 / so2;
			myform.result.value = result;
		}
	</script>
 
</body>
</html>