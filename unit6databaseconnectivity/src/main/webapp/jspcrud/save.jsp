<%-- 
    Document   : save
    Created on : Jun 11, 2025, 7:11:56 PM
    Author     : user
--%>

<%@include file="db.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String regno = request.getParameter("regno");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    
    try {
        PreparedStatement ps = con.prepareStatement("INSERT INTO students(regno, fname, lname, email, phone) VALUES(?,?,?,?,?)");
        ps.setString(1, regno);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, email);
        ps.setString(5, phone);
        ps.executeUpdate();
        response.sendRedirect("index.jsp");
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
