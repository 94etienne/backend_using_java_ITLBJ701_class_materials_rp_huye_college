<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management CRUD</title>
</head>
<body>
    <h1>Welcome to Student Management System</h1>
    <a href="EmployeeServlet">Go to Employee List</a>
</body>
</html> -->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Employee" %>
<%
    // Automatically fetch employee list when page loads
    List<Employee> employees = (List<Employee>) request.getAttribute("listEmployee");
    if (employees == null) {
        // If not already in request, forward to servlet
        RequestDispatcher rd = request.getRequestDispatcher("EmployeeServlet?action=list");
        rd.include(request, response);
        employees = (List<Employee>) request.getAttribute("listEmployee");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Management System</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 1200px;
            margin-top: 20px;
        }
        .table-responsive {
            margin-top: 20px;
        }
        .action-btns .btn {
            margin-right: 5px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4">Welcome to Employee Management System</h1>
        
        <a href="EmployeeServlet?action=new" class="btn btn-primary mb-3">
            Add New Employee
        </a>
        
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Reg No</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% if (employees != null && !employees.isEmpty()) { 
                        for (Employee emp : employees) { %>
                        <tr>
                            <td><%= emp.getId() %></td>
                            <td><%= emp.getRegno() %></td>
                            <td><%= emp.getFname() + " " + emp.getLname() %></td>
                            <td><%= emp.getEmail() %></td>
                            <td><%= emp.getPhone() %></td>
                            <td class="action-btns">
                                <a href="EmployeeServlet?action=edit&id=<%= emp.getId() %>" 
                                   class="btn btn-sm btn-warning">Edit</a>
                                <a href="EmployeeServlet?action=delete&id=<%= emp.getId() %>" 
                                   class="btn btn-sm btn-danger"
                                   onclick="return confirm('Delete this employee?')">Delete</a>
                            </td>
                        </tr>
                    <% } 
                    } else { %>
                        <tr>
                            <td colspan="6" class="text-center">No employees found</td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap 5 JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>