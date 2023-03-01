<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.User" %>
<!doctype html>
<html>
<head>
<title>First JSP</title>
</head>
<body>
<h1>Hello  JSP</h1>
<%
response.getWriter().write("First message");
out.print("right here, after header");
%>
<br/>
<%= request.getRequestURI() %>
<br/>
<%= LocalDateTime.now() %>
<hr/>
<%
List<User> users = (List) request.getAttribute("users");
%>
<% User aUser = users.get(0);
%>
<%= aUser.getName() %>
<%= aUser.getCountry() %>
<%= aUser.getAge() %>
<body>
</html>

