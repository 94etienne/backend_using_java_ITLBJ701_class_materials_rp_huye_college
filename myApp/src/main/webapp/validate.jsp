<!DOCTYPE html>
<html>
    <head>
        <title>Login Form</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            * {
                box-sizing: border-box;
                font-family: Arial, sans-serif;
            }
            
            body {
                margin: 0;
                padding: 0;
                background-color: #f5f5f5;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }
            
            .form-container {
                background-color: white;
                padding: 2rem;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }
            
            .form-title {
                text-align: center;
                margin-bottom: 1.5rem;
                color: #333;
            }
            
            .form-group {
                margin-bottom: 1.5rem;
            }
            
            .error-message {
                color: #dc3545;
                font-weight: bold;
                margin-bottom: 1rem;
                text-align: center;
            }
            
            label {
                display: block;
                margin-bottom: 0.5rem;
                font-weight: 600;
                color: #555;
            }
            
            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 0.75rem;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 1rem;
                transition: border-color 0.3s;
            }
            
            input[type="text"]:focus,
            input[type="password"]:focus {
                border-color: #4CAF50;
                outline: none;
                box-shadow: 0 0 0 2px rgba(76, 175, 80, 0.2);
            }
            
            input[type="submit"] {
                width: 100%;
                padding: 0.75rem;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                font-size: 1rem;
                font-weight: 600;
                cursor: pointer;
                transition: background-color 0.3s;
            }
            
            input[type="submit"]:hover {
                background-color: #45a049;
            }
            
            @media (max-width: 480px) {
                .form-container {
                    padding: 1.5rem;
                    margin: 0 1rem;
                }
                
                .form-title {
                    font-size: 1.5rem;
                }
            }
        </style>
    </head>
    <body>
        <div class="form-container">
            <h1 class="form-title">Login</h1>
            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message"><%= request.getAttribute("error") %></div>
            <% } %>
            <form method="post" action="ValidateServlet">
                <div class="form-group">
                    <label for="user">Name:</label>
                    <input type="text" id="user" name="user" placeholder="Enter your name" required>
                </div>
                <div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="password" id="pass" name="pass" placeholder="Enter your password (l6y2)" required>
                </div>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>