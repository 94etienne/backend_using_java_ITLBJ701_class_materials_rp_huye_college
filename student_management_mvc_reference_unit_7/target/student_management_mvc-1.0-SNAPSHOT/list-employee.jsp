<%-- 
    Document   : list-employee
    Created on : Jun 13, 2025, 2:37:22 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Employee"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        function confirmDelete(id) {
            if (confirm("Are you sure you want to delete this employee?")) {
                window.location.href = "DeleteEmployeeServlet?id=" + id;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <h1>Employee List</h1>
        <a href="add-employee.jsp">Add New Employee</a>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Reg No</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Action</th>
            </tr>
            <% List<Employee> list = (List<Employee>) request.getAttribute("employeeList");
               for (Employee e : list) { %>
            <tr>
                <td><%= e.getId() %></td>
                <td><%= e.getRegno() %></td>
                <td><%= e.getFname() %></td>
                <td><%= e.getLname() %></td>
                <td><%= e.getEmail() %></td>
                <td><%= e.getPhone() %></td>
                <td>
                    <a href="EditEmployeeServlet?id=<%= e.getId() %>">Edit</a>
                    <a href="javascript:confirmDelete(<%= e.getId() %>)">Delete</a>
                </td>
            </tr>
            <% } %>
        </table>
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>