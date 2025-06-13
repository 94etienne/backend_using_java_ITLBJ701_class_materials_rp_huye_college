<%-- 
    Document   : add-employee
    Created on : Jun 13, 2025, 2:36:35 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Add New Employee</h1>
        <form action="SaveEmployeeServlet" method="post">
            <table>
                <tr>
                    <td>Registration No:</td>
                    <td><input type="text" name="regno" required></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="fname" required></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="lname" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" required></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save Employee">
                    </td>
                </tr>
            </table>
        </form>
        <a href="ListEmployeeServlet">Back to List</a>
    </div>
</body>
</html>
