<%-- 
    Document   : header.jsp
    Created on : Jun 11, 2025, 10:55:11 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Your Application</title>
        <!-- Bootstrap 5 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom CSS -->
        <style>
            .navbar-brand img {
                height: 50px;
            }
            .nav-link {
                font-weight: 500;
            }
            .navbar {
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            }
        </style>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container">
                    <!-- Brand/logo -->
                    <a class="navbar-brand" href="includewelcome.jsp">
                        <img src="img/logo_rp_huye.png" alt="Company Logo" class="img-fluid">
                    </a>
                    
                    <!-- Toggle button for mobile -->
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    
                    <!-- Navbar links -->
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav me-auto">
                            <li class="nav-item">
                                <a class="nav-link <%= request.getRequestURI().endsWith("includewelcome.jsp") ? "active" : "" %>" href="index.jsp">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <%= request.getRequestURI().endsWith("about.jsp") ? "active" : "" %>" href="about.jsp">About</a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="servicesDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    Services
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="servicesDropdown">
                                    <li><a class="dropdown-item" href="service1.jsp">Service 1</a></li>
                                    <li><a class="dropdown-item" href="service2.jsp">Service 2</a></li>
                                    <li><hr class="dropdown-divider"></li>
                                    <li><a class="dropdown-item" href="services.jsp">All Services</a></li>
                                </ul>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link <%= request.getRequestURI().endsWith("contact.jsp") ? "active" : "" %>" href="contact.jsp">Contact</a>
                            </li>
                        </ul>
                        
                        <!-- Right-aligned items -->
                        <div class="d-flex">
                            <a href="login.jsp" class="btn btn-outline-primary me-2 <%= request.getRequestURI().endsWith("login.jsp") ? "active" : "" %>">Login</a>
                            <a href="register.jsp" class="btn btn-primary <%= request.getRequestURI().endsWith("register.jsp") ? "active" : "" %>">Register</a>
                        </div>
                    </div>
                </div>
            </nav>
        </header>
        
        <!-- Bootstrap 5 JS Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>