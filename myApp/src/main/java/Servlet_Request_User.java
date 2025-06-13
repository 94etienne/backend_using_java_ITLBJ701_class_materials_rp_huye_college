import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Servlet_Request_User"})
public class Servlet_Request_User extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Get the submitted name
        String userName = request.getParameter("user");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome Page</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("    display: flex;");
            out.println("    justify-content: center;");
            out.println("    align-items: center;");
            out.println("    min-height: 100vh;");
            out.println("    background-color: #f5f5f5;");
            out.println("}");
            out.println(".container {");
            out.println("    background-color: white;");
            out.println("    padding: 30px;");
            out.println("    border-radius: 8px;");
            out.println("    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);");
            out.println("    width: 100%;");
            out.println("    max-width: 500px;");
            out.println("    text-align: center;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #4CAF50;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println(".welcome-message {");
            out.println("    font-size: 18px;");
            out.println("    margin-bottom: 20px;");
            out.println("}");
            out.println(".user-name {");
            out.println("    font-weight: bold;");
            out.println("    color: #333;");
            out.println("}");
            out.println("@media (max-width: 600px) {");
            out.println("    .container {");
            out.println("        padding: 20px;");
            out.println("    }");
            out.println("    h1 {");
            out.println("        font-size: 24px;");
            out.println("    }");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<h1>Welcome!</h1>");
            out.println("<div class=\"welcome-message\">Hello, <span class=\"user-name\">" + userName + "</span></div>");
            out.println("<p>Thank you for submitting your name.</p>");
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
        return "Handles name submission and displays welcome message";
    }
}