import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CookiesWelcomeServlet"})
public class CookiesWelcomeServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body class=\"container mt-5\">");
            out.println("<div class=\"card shadow\">");
            out.println("<div class=\"card-body\">");
            out.println("<h1 class=\"card-title\">Welcome Page</h1>");
            
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                boolean found = false;
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")) {
                        out.println("<div class=\"alert alert-success mt-3\">");
                        out.println("<h3>Welcome " + cookie.getValue() + "!</h3>");
                        out.println("</div>");
                        out.println("<form action=\"LogoutServlet\" method=\"post\">");
                        out.println("<button type=\"submit\" class=\"btn btn-danger\">Logout</button>");
                        out.println("</form>");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    showNoCookieError(out);
                }
            } else {
                showNoCookieError(out);
            }
            
            out.println("</div>");
            out.println("</div>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void showNoCookieError(PrintWriter out) {
        out.println("<div class=\"alert alert-danger mt-3\">");
        out.println("<h3>No user cookie found. Please login first.</h3>");
        out.println("<a href=\"CookiesServlet\" class=\"btn btn-primary\">Go to Login</a>");
        out.println("</div>");
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
}