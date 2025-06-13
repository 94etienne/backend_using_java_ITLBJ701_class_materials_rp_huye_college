import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/CookiesDemoServlet"})
public class CookiesDemoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login Page</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body class=\"container mt-5\">");
            out.println("<div class=\"card shadow\">");
            out.println("<div class=\"card-body\">");
            out.println("<h1 class=\"card-title\">Please login first</h1>");
            out.println("<a href='index.html' class='btn btn-primary'>Go to Login</a>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String username = request.getParameter("val1");
            String password = request.getParameter("val2");
            
            // Validate password (must be "1234")
            if (username != null && !username.trim().isEmpty() && 
                password != null && password.equals("1234")) {
                
                // Create cookie
                Cookie ck = new Cookie("username", username);
                // Set cookie to expire in 30 minutes
                ck.setMaxAge(30*60);
                response.addCookie(ck);
                
                // Display welcome message
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Welcome</title>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body class=\"container mt-5\">");
                out.println("<div class=\"card shadow\">");
                out.println("<div class=\"card-body\">");
                out.println("<h2 class=\"card-title\">Welcome " + username + "!</h2>");
                out.println("<p class=\"card-text\">You have successfully logged in.</p>");
                
                // Form to navigate to next page
                out.println("<form action='CookiesDemo2Servlet' method='post' class='mt-3'>");
                out.println("<button type='submit' class='btn btn-primary'>View Cookie Data</button>");
                out.println("</form>");
                
                out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Invalid credentials - show error message
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Failed</title>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("</head>");
                out.println("<body class=\"container mt-5\">");
                out.println("<div class=\"card shadow\">");
                out.println("<div class=\"card-body\">");
                out.println("<h2 class=\"card-title text-danger\">Login Failed</h2>");
                out.println("<p class=\"card-text\">Incorrect username or password. The password must be '1234'.</p>");
                out.println("<a href='cookiesDemo.html' class='btn btn-primary'>Try Again</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that handles login and cookie creation";
    }
}