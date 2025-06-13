import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/validate")
public class UrlServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if (name == null || pass == null || name.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid credentials");
            return;
        }
        
        if(pass.equals("1234")) {
            response.sendRedirect("First?user_name=" + java.net.URLEncoder.encode(name, "UTF-8"));
        } else {
            showLoginError(response);
        }
    }
    
    private void showLoginError(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Login Failed</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head><body class=\"bg-light\">");
            out.println("<div class=\"container mt-5\">");
            out.println("<div class=\"alert alert-danger\">");
            out.println("<h2>Login Failed</h2>");
            out.println("<p>Invalid password. Please try again.</p>");
            out.println("<a href=\"url.html\" class=\"btn btn-primary\">Return to Login</a>");
            out.println("</div></div></body></html>");
        }
    }
}