<%-- 
    Document   : count
    Created on : Jun 9, 2025, 4:13:16 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
int count = 0;
    %>
    <body>
        <h1>Hello World!</h1>
        Page Count is <% out.println(++count); %>
    </body>
</html>
