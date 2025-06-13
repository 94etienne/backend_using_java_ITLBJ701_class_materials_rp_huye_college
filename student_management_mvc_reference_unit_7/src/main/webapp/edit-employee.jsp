<%-- 
    Document   : edit-employee
    Created on : Jun 13, 2025, 2:36:58 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Employee</h1>
        <form action="UpdateEmployeeServlet" method="post">
            <input type="hidden" name="id" value="${employee.id}">
            <table>
                <tr>
                    <td>Registration No:</td>
                    <td><input type="text" name="regno" value="${employee.regno}" required></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="fname" value="${employee.fname}" required></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lname" value="${employee.lname}" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" value="${employee.email}" required></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" value="${employee.phone}" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Update Employee">
                    </td>
                </tr>
            </table>
        </form>
        <a href="ListEmployeeServlet">Back to List</a>
    </div>
</body>
</html>