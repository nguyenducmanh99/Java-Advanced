<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Group Managerment</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <!-- Import CSS -->
<link rel="stylesheet" href="./css/CSS.css">
<link rel="stylesheet" href="./css/CSS.header.css">


<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="header">
    <jsp:include page="header.jsp"></jsp:include>
</div>

<div class="main">
   <jsp:include page="home.jsp"></jsp:include>
</div>

<div class="footer">
     <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
	<script>
	<jsp:include page="../js/js.js"></jsp:include>
	</script>
	
</html>