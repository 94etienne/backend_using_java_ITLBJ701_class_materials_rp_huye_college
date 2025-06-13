/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/Validate"})
public class HttpSessionServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HttpSessionServlet</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("</head>");
            out.println("<body class=\"bg-light\">");
            out.println("<div class=\"container mt-5\">");
            out.println("<div class=\"card shadow\">");
            out.println("<div class=\"card-header bg-primary text-white\">");
            out.println("<h1 class=\"card-title\">Servlet HttpSessionServlet</h1>");
            out.println("</div>");
            out.println("<div class=\"card-body\">");
            out.println("<p class=\"lead\">Context path: " + request.getContextPath() + "</p>");
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
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(pass.equals("1234")) {
            //creating a session
            HttpSession session = request.getSession();
            session.setAttribute("user", name);
            response.sendRedirect("Welcome");
        } else {
            // If password is wrong, show error message
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Login Failed</title>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("<style>");
                out.println("body { background-color: #f8f9fa; }");
                out.println(".error-container { max-width: 500px; margin: 100px auto; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container error-container\">");
                out.println("<div class=\"card shadow\">");
                out.println("<div class=\"card-header bg-danger text-white\">");
                out.println("<h2 class=\"card-title\">Login Failed</h2>");
                out.println("</div>");
                out.println("<div class=\"card-body text-center\">");
                out.println("<div class=\"alert alert-danger\" role=\"alert\">");
                out.println("<h4 class=\"alert-heading\">Invalid credentials!</h4>");
                out.println("<p>The password you entered is incorrect. Please try again.</p>");
                out.println("</div>");
                out.println("<a href='httpSession.html' class=\"btn btn-primary\">Try again</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js\"></script>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Handles user authentication and session creation";
    }
}