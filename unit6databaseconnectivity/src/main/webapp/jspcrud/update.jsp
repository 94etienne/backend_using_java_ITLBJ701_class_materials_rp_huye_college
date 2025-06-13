<%-- 
    Document   : update
    Created on : Jun 11, 2025, 7:14:28 PM
    Author     : user
--%>

<%@include file="db.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String regno = request.getParameter("regno");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    
    try {
        PreparedStatement ps = con.prepareStatement("UPDATE students SET regno=?, fname=?, lname=?, email=?, phone=? WHERE id=?");
        ps.setString(1, regno);
        ps.setString(2, fname);
        ps.setString(3, lname);
        ps.setString(4, email);
        ps.setString(5, phone);
        ps.setInt(6, id);
        ps.executeUpdate();
        response.sendRedirect("index.jsp");
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>