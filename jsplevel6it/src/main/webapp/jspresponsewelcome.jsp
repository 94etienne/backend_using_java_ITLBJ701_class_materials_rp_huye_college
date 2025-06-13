<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap 5 CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap Icons -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
        <style>
            .welcome-container {
                max-width: 600px;
                margin: 0 auto;
                padding: 2rem;
                border-radius: 10px;
                box-shadow: 0 0 20px rgba(0,0,0,0.1);
                background-color: white;
            }
            body {
                background-color: #f8f9fa;
                padding-top: 5rem;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8 col-lg-6">
                    <div class="welcome-container text-center">
                        <%
                            String username = request.getParameter("uname");
                            if(username != null && !username.isEmpty()) {
                        %>
                        <div class="display-4 text-primary mb-3">
                            <i class="bi bi-check-circle-fill"></i>
                        </div>
                        <h2 class="mb-4">Welcome, <%= username %>!</h2>
                        <p class="lead mb-4">You will be redirected to Google shortly...</p>
                        <div class="spinner-border text-primary" role="status">
                            <span class="visually-hidden">Loading...</span>
                        </div>
                        <%
                            // Redirect after 3 seconds
                            response.setHeader("Refresh", "3;url=https://www.google.com");
                            } else {
                        %>
                        <div class="display-4 text-danger mb-3">
                            <i class="bi bi-exclamation-triangle-fill"></i>
                        </div>
                        <h2 class="mb-4">No username provided!</h2>
                        <a href="jsp_response.html" class="btn btn-primary mt-3">
                            <i class="bi bi-arrow-left"></i> Go Back
                        </a>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap 5 JS Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>