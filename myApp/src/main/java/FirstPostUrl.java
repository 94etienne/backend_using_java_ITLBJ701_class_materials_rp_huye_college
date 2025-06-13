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

/**
 *
 * @author user
 */
@WebServlet(urlPatterns = {"/FirstPostUrl"})
public class FirstPostUrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Access Denied</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Please submit the form first</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            
            // Simple validation
            if (user == null || user.isEmpty() || pass == null || pass.isEmpty()) {
                out.println("Please fill all fields");
                return;
            }
            
            // Create hidden form for next step
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Confirm Submission</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("<div class='row justify-content-center'>");
            out.println("<div class='col-md-6'>");
            out.println("<div class='card shadow'>");
            out.println("<div class='card-body'>");
            out.println("<h2 class='card-title text-center mb-4'>Confirm Your Details</h2>");
            out.println("<form action='SecondPostUrl' method='post'>");
            out.println("<input type='hidden' name='user' value='"+user+"'>");
            out.println("<input type='hidden' name='pass' value='"+pass+"'>");
            out.println("<p class='text-center'>Click below to confirm your submission</p>");
            out.println("<div class='d-grid'>");
            out.println("<button type='submit' class='btn btn-primary'>Confirm</button>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}