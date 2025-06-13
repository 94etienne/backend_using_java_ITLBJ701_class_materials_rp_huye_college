import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/Welcome"})
public class HttpSessionWelcome extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String user = (String)session.getAttribute("user");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome Page</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<style>");
            out.println(".welcome-container {");
            out.println("    max-width: 600px;");
            out.println("    margin-top: 100px;");
            out.println("}");
            out.println(".welcome-card {");
            out.println("    box-shadow: 0 4px 8px rgba(0,0,0,0.1);");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body class=\"bg-light\">");
            out.println("<div class=\"container welcome-container\">");
            out.println("<div class=\"card welcome-card\">");
            out.println("<div class=\"card-header bg-success text-white\">");
            out.println("<h2 class=\"card-title text-center\">Welcome!</h2>");
            out.println("</div>");
            out.println("<div class=\"card-body text-center\">");
            out.println("<h3 class=\"mb-4\">Hello, " + (user != null ? user : "Guest") + "!</h3>");
            out.println("<p class=\"card-text\">You have successfully logged in to our system.</p>");
            out.println("<a href=\"httpSession.html\" class=\"btn btn-primary mt-3\">Logout</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
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
        return "Welcome page that displays user information from session";
    }
}