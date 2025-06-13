<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome Page</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .welcome-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        .welcome-header {
            color: #0d6efd;
            margin-bottom: 30px;
        }
        .result-box {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-container">
            <h1 class="text-center welcome-header">Welcome Page</h1>
            
            <div class="result-box">
                <%
                    String username = request.getParameter("uname");
                    if (username != null && !username.trim().isEmpty()) {
                        out.print("<h4 class='text-success'>Welcome " + username + "</h4>");
                    } else {
                        out.print("<h4 class='text-danger'>Please enter your name</h4>");
                    }
                    
                    String driver = config.getInitParameter("dname");
                    out.print("<p class='mt-3'><strong>Driver name is:</strong> " + driver + "</p>");
                %>
            </div>
            
            <div class="d-grid gap-2">
                <a href="config.html" class="btn btn-primary">Go Back</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>