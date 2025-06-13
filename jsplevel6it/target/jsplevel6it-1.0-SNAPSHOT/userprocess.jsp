<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Successful</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6 col-lg-5">
                <div class="card shadow">
                    <div class="card-header bg-success text-white">
                        <h3 class="text-center mb-0">Registration Successful</h3>
                    </div>
                    <div class="card-body">
                        <jsp:useBean id="u" class="org.sssit.User" scope="session"></jsp:useBean>
                        <jsp:setProperty property="*" name="u"/>
                        
                        <h4 class="mb-3">Your Details:</h4>
                        <div class="mb-3">
                            <label class="form-label">Name:</label>
                            <div class="form-control bg-light"><jsp:getProperty property="name" name="u"/></div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password:</label>
                            <div class="form-control bg-light"><jsp:getProperty property="password" name="u"/></div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Email:</label>
                            <div class="form-control bg-light"><jsp:getProperty property="email" name="u"/></div>
                        </div>
                        
                        <div class="d-grid">
                            <a href="user.html" class="btn btn-primary">Register Another User</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap 5 JS Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>