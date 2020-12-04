<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Parameter values:</h3>
  <%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");
    String[] addresses = request.getParameterValues("address");      
  
  %>
  
  User Name: <%=userName %> <br>
  Password: <%=password %> <br>
  First Name: <%=firstName %> <br>
  Last Name: <%=lastName %> <br>
  
  Gender: <%=gender %> <br>
  
  <% if (addresses!= null)  {
       for(String address: addresses)  {
      %>
 
     Address: <%=address %> <br>
  
  <% } } %>
</body>
</html>