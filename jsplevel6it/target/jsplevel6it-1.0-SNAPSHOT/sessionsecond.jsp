<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Get existing session (don't create new one)
    session = request.getSession(false);
    
    if (session == null || session.getAttribute("user") == null) {
        response.sendRedirect("session.html");
        return;
    }
    
    String name = (String) session.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Second Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .second-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        .second-header { color: #0d6efd; margin-bottom: 30px; }
    </style>
</head>
<body>
    <div class="container">
        <div class="second-container text-center">
            <h1 class="second-header">Second Page</h1>
            <div class='alert alert-info' role='alert'>Hello <%= name %></div>
            <a href="session.html" class="btn btn-primary mt-3">Return to Login</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>