<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Enable session
    session = request.getSession(true);
    
    String name = request.getParameter("uname");
    if (name != null && !name.trim().isEmpty()) {
        session.setAttribute("user", name);
    } else {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { background-color: #f8f9fa; }
        .welcome-container {
            max-width: 600px;
            margin: 100px auto;
            padding: 30px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        .welcome-header { color: #0d6efd; margin-bottom: 30px; }
    </style>
</head>
<body>
    <div class="container">
        <div class="welcome-container text-center">
            <h1 class="welcome-header">Welcome Page</h1>
            <div class='alert alert-success' role='alert'>Welcome <%= name %></div>
            <a href="sessionsecond.jsp" class="btn btn-primary mt-3">Visit Second Page</a>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>