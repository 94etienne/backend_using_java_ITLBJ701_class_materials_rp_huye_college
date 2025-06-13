import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet(urlPatterns = {"/CookiesDemo2Servlet"})
public class CookiesDemo2Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cookie Data</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body class=\"container mt-5\">");
            out.println("<div class=\"card shadow\">");
            out.println("<div class=\"card-body\">");
            
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                out.println("<h2 class=\"card-title\">Cookie Information</h2>");
                out.println("<table class=\"table\">");
                out.println("<thead><tr><th>Cookie Name</th><th>Cookie Value</th></tr></thead>");
                out.println("<tbody>");
                for (Cookie cookie : cookies) {
                    out.println("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
                }
                out.println("</tbody></table>");
            } else {
                out.println("<h2 class=\"card-title\">No Cookies Found</h2>");
                out.println("<p class=\"card-text\">Please login first to set cookies.</p>");
            }
            
            out.println("<a href='cookiesDemo.html' class='btn btn-primary mt-3'>Back to Login</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that displays cookie information";
    }
}