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
@WebServlet(urlPatterns = {"/mar"})
public class MarksServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get marks from request parameters
            int maths = Integer.parseInt(request.getParameter("num1"));
            int english = Integer.parseInt(request.getParameter("num2"));
            int hindi = Integer.parseInt(request.getParameter("num3"));
            int science = Integer.parseInt(request.getParameter("num4"));
            int socialScience = Integer.parseInt(request.getParameter("num5"));
            int it = Integer.parseInt(request.getParameter("num6"));
            
            // Calculate total and average
            int total = maths + english + hindi + science + socialScience + it;
            float avg = total / 6.0f;
            
            // Generate HTML response
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Marks Calculation Result</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
            out.println(".result-container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; }");
            out.println("h2 { color: #333; text-align: center; }");
            out.println(".subject { display: flex; justify-content: space-between; margin-bottom: 5px; }");
            out.println(".total { font-weight: bold; margin-top: 15px; padding-top: 10px; border-top: 1px solid #ddd; }");
            out.println(".average { font-weight: bold; color: #2a6496; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='result-container'>");
            out.println("<h2>Marks Calculation Result</h2>");
            
            // Display individual subject marks
            out.println("<div class='subject'><span>Maths:</span><span>" + maths + "</span></div>");
            out.println("<div class='subject'><span>English:</span><span>" + english + "</span></div>");
            out.println("<div class='subject'><span>Hindi:</span><span>" + hindi + "</span></div>");
            out.println("<div class='subject'><span>Science:</span><span>" + science + "</span></div>");
            out.println("<div class='subject'><span>Social Science:</span><span>" + socialScience + "</span></div>");
            out.println("<div class='subject'><span>IT:</span><span>" + it + "</span></div>");
            
            // Display total and average
            out.println("<div class='total'>Total Marks: " + total + "</div>");
            out.println("<div class='average'>Average: " + String.format("%.2f", avg) + "</div>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Calculates and displays student marks summary";
    }
}