import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CookiesServlet"})
public class CookiesServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body class=\"container mt-5\">");
            out.println("<div class=\"card shadow\">");
            out.println("<div class=\"card-body\">");
            out.println("<h1 class=\"card-title\">Login</h1>");
            
            out.println("<form method=\"post\" action=\"CookiesServlet\" class=\"mt-4\">");
            out.println("<div class=\"mb-3\">");
            out.println("<label for=\"user\" class=\"form-label\">Username</label>");
            out.println("<input type=\"text\" class=\"form-control\" id=\"user\" name=\"user\" required>");
            out.println("</div>");
            out.println("<div class=\"mb-3\">");
            out.println("<label for=\"pass\" class=\"form-label\">Password</label>");
            out.println("<input type=\"password\" class=\"form-control\" id=\"pass\" name=\"pass\" required>");
            out.println("</div>");
            out.println("<button type=\"submit\" class=\"btn btn-primary\">Login</button>");
            out.println("</form>");
            
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
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if (pass != null && pass.equals("1234")) {
            Cookie ck = new Cookie("username", name);
            ck.setMaxAge(30*60);
            response.addCookie(ck);
            response.sendRedirect("CookiesWelcomeServlet");
        } else {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Failed</title>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body class=\"container mt-5\">");
                out.println("<div class=\"alert alert-danger\">Invalid password. Please try again.</div>");
                processRequest(request, response);
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}