<%-- 
    Document   : includewelcome
    Created on : Jun 11, 2025, 11:03:57 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Welcome Page</title>
        <!-- Bootstrap 5 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .welcome-container {
                max-width: 600px;
                margin: 3rem auto;
                padding: 2rem;
                border-radius: 10px;
                box-shadow: 0 0 15px rgba(0,0,0,0.1);
            }
            .data-item {
                margin-bottom: 1rem;
                padding-bottom: 1rem;
                border-bottom: 1px solid #eee;
            }
        </style>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <div class="container">
            <div class="welcome-container bg-white">
                <h2 class="text-center mb-4">Welcome!</h2>
                <p class="text-center">Here's the information you submitted:</p>
                
                <div class="data-results">
                    <%-- Display all parameters sent to the page --%>
                    <%
                        java.util.Enumeration<String> params = request.getParameterNames();
                        while(params.hasMoreElements()) {
                            String paramName = params.nextElement();
                            String paramValue = request.getParameter(paramName);
                            if(!paramValue.isEmpty()) {
                    %>
                        <div class="data-item">
                            <strong><%= paramName %>:</strong> <%= paramValue %>
                        </div>
                    <%
                            }
                        }
                    %>
                </div>
                
                <div class="text-center mt-4">
                    <a href="header.jsp" class="btn btn-primary">Return Home</a>
                </div>
            </div>
        </div>
        
        <!-- Bootstrap 5 JS Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>