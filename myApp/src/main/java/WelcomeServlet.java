import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get the username from the request attribute
            String username = (String) request.getAttribute("user");
            if (username == null || username.trim().isEmpty()) {
                username = "Guest";
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome Page</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: 'Arial', sans-serif;");
            out.println("    margin: 0;");
            out.println("    padding: 0;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    min-height: 100vh;");
            out.println("    background-color: #f5f5f5;");
            out.println("}");
            out.println(".welcome-container {");
            out.println("    background-color: white;");
            out.println("    padding: 2rem;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);");
            out.println("    text-align: center;");
            out.println("    max-width: 500px;");
            out.println("    width: 90%;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #2e7d32;");
            out.println("    margin-bottom: 1rem;");
            out.println("}");
            out.println(".welcome-message {");
            out.println("    font-size: 1.2rem;");
            out.println("    margin-bottom: 1.5rem;");
            out.println("}");
            out.println(".username {");
            out.println("    font-weight: bold;");
            out.println("    color: #1b5e20;");
            out.println("}");
            out.println(".logout-btn {");
            out.println("    display: inline-block;");
            out.println("    padding: 0.75rem 1.5rem;");
            out.println("    background-color: #2e7d32;");
            out.println("    color: white;");
            out.println("    text-decoration: none;");
            out.println("    border-radius: 4px;");
            out.println("    font-weight: bold;");
            out.println("    transition: background-color 0.3s;");
            out.println("}");
            out.println(".logout-btn:hover {");
            out.println("    background-color: #1b5e20;");
            out.println("}");
            out.println("@media (max-width: 600px) {");
            out.println("    .welcome-container {");
            out.println("        padding: 1.5rem;");
            out.println("    }");
            out.println("    h1 {");
            out.println("        font-size: 1.5rem;");
            out.println("    }");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"welcome-container\">");
            out.println("<h1>Welcome to Our System</h1>");
            out.println("<div class=\"welcome-message\">Hello, <span class=\"username\">" + username + "</span>!</div>");
            out.println("<p>You have successfully logged in.</p>");
            out.println("<a href=\"validate.html\" class=\"logout-btn\">Logout</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Displays welcome page after successful login";
    }
}