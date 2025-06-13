<%-- 
    Document   : db
    Created on : Jun 11, 2025, 7:10:17 PM
    Author     : user
--%>

<%@page import="java.sql.*"%>
<%
    Connection con = null;
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management", "root", "");
    } catch(Exception e) {
        out.println("Database connection error: " + e.getMessage());
    }
%>
