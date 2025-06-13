<%-- 
    Document   : delete
    Created on : Jun 11, 2025, 7:15:00 PM
    Author     : user
--%>

<%@include file="db.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    
    try {
        PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        response.sendRedirect("index.jsp");
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
