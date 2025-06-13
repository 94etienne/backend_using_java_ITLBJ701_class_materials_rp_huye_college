<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, model.Employee" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Employee Management System</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- Cross-browser compatibility CSS -->
    <style>
        /* Ensure consistent table behavior across browsers */
        .table-responsive {
            -webkit-overflow-scrolling: touch; /* Smooth scrolling on iOS */
            -ms-overflow-style: -ms-autohiding-scrollbar; /* Edge scrollbar behavior */
        }
        
        /* Fix for Firefox table border rendering */
        .table {
            border-collapse: separate;
            border-spacing: 0;
        }
        
        /* Action buttons styling that works everywhere */
        .btn-action {
            white-space: nowrap;
            margin: 2px;
        }
        
        /* IE11 specific fixes */
        @media all and (-ms-high-contrast: none), (-ms-high-contrast: active) {
            .table-responsive {
                overflow: auto;
            }
            .d-flex {
                display: flex !important;
            }
        }
        
        /* Safari specific fixes */
        @media not all and (min-resolution:.001dpcm) { 
            @supports (-webkit-appearance:none) {
                .table {
                    width: 100%;
                }
            }
        }
    </style>
</head>
<body class="bg-light">
    <div class="container py-4">
        <div class="card shadow-sm">
            <div class="card-header bg-primary text-white">
                <div class="d-flex justify-content-between align-items-center">
                    <h2 class="h5 mb-0">Employee List</h2>
                    <a href="EmployeeServlet?action=new" class="btn btn-success btn-sm">
                        <i class="bi bi-plus-circle"></i> Add New
                    </a>
                </div>
            </div>
            
            <div class="card-body">
                <%
                    List<Employee> employees = (List<Employee>) request.getAttribute("listEmployee");
                    if (employees != null && !employees.isEmpty()) {
                %>
                <div class="table-responsive">
                    <table class="table table-striped table-hover table-bordered mb-0">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Reg No</th>
                                <th scope="col">Name</th>
                                <th scope="col">Email</th>
                                <th scope="col">Phone</th>
                                <th scope="col" class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Employee emp : employees) {
                            %>
                            <tr>
                                <td><%= emp.getId() %></td>
                                <td><%= emp.getRegno() %></td>
                                <td><%= emp.getFname() + " " + emp.getLname() %></td>
                                <td><a href="mailto:<%= emp.getEmail() %>"><%= emp.getEmail() %></a></td>
                                <td><%= emp.getPhone() %></td>
                                <td class="text-center">
                                    <div class="d-flex justify-content-center flex-wrap">
                                        <a href="EmployeeServlet?action=edit&id=<%= emp.getId() %>" 
                                           class="btn btn-primary btn-sm btn-action">
                                            <i class="bi bi-pencil-square"></i> Edit
                                        </a>
                                        <a href="EmployeeServlet?action=delete&id=<%= emp.getId() %>" 
                                           class="btn btn-danger btn-sm btn-action"
                                           onclick="return confirm('Are you sure you want to delete this employee?')">
                                            <i class="bi bi-trash"></i> Delete
                                        </a>
                                    </div>
                                </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
                <%
                    } else {
                %>
                <div class="alert alert-info mb-0">
                    <i class="bi bi-info-circle"></i> No employees found.
                </div>
                <%
                    }
                %>
            </div>
            
            <div class="card-footer text-muted text-end">
                <small>Total: <%= employees != null ? employees.size() : 0 %> employees</small>
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS Bundle with Popper (for components that need JS) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Polyfills for older browsers -->
    <script>
        // ClassList polyfill for IE9
        if (!("classList" in document.documentElement)) {
            Object.defineProperty(HTMLElement.prototype, 'classList', {
                get: function() {
                    var self = this;
                    function update(fn) {
                        return function(value) {
                            var classes = self.className.split(/\s+/),
                                index = classes.indexOf(value);
                            fn(classes, index, value);
                            self.className = classes.join(" ");
                        }
                    }
                    return {
                        add: update(function(classes, index, value) {
                            ~index || classes.push(value);
                        }),
                        remove: update(function(classes, index) {
                            ~index && classes.splice(index, 1);
                        }),
                        toggle: update(function(classes, index, value) {
                            ~index ? classes.splice(index, 1) : classes.push(value);
                        }),
                        contains: function(value) {
                            return !!~self.className.split(/\s+/).indexOf(value);
                        },
                        item: function(i) {
                            return self.className.split(/\s+/)[i] || null;
                        }
                    };
                }
            });
        }
    </script>
</body>
</html>