import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/First")
public class UrlWelcome extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user_name");
        
        if (user == null || user.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Username parameter is missing");
            return;
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Welcome Page</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<style>");
            out.println(".custom-container { max-width: 500px; }"); // Reduced width
            out.println("</style>");
            out.println("</head><body class=\"bg-light\">");
            out.println("<div class=\"container custom-container mt-5\">"); // Added custom class
            out.println("<div class=\"card\">");
            out.println("<div class=\"card-header bg-primary text-white\">");
            out.println("<h2>Welcome Page</h2></div>");
            out.println("<div class=\"card-body\">");
            out.println("<h3 class=\"text-success\">Welcome " + escapeHtml(user) + "!</h3>");
            out.println("<p class=\"mt-3\">You have successfully logged in.</p>");
            out.println("<a href=\"url.html\" class=\"btn btn-primary\">Logout</a>");
            out.println("</div></div></div></body></html>");
        }
    }
    
    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }
}