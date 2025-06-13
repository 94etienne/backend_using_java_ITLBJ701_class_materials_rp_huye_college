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
@WebServlet(urlPatterns = {"/sal"})
public class SalaryServlet extends HttpServlet {

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
            try {
                int basic = Integer.parseInt(request.getParameter("num1"));
                int daPercent = Integer.parseInt(request.getParameter("num2"));
                int hraPercent = Integer.parseInt(request.getParameter("num3"));
                
                int da = (daPercent * basic) / 100;
                int hra = (hraPercent * basic) / 100;
                int gross = basic + da + hra;
                
                out.println("<!DOCTYPE html>");
                out.println("<html lang='en'>");
                out.println("<head>");
                out.println("<title>Salary Calculation</title>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<style>");
                out.println("  * { box-sizing: border-box; font-family: Arial, sans-serif; }");
                out.println("  body { margin: 0; padding: 20px; background-color: #f5f5f5; }");
                out.println("  .container { max-width: 600px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
                out.println("  h2 { color: #2c3e50; text-align: center; margin-bottom: 20px; }");
                out.println("  .result-item { display: flex; justify-content: space-between; padding: 10px 0; border-bottom: 1px solid #eee; }");
                out.println("  .result-item:last-child { border-bottom: none; font-weight: bold; font-size: 1.1em; }");
                out.println("  .label { color: #7f8c8d; }");
                out.println("  .value { color: #2c3e50; }");
                out.println("  .gross { color: #27ae60; font-size: 1.2em; }");
                out.println("  @media (max-width: 480px) {");
                out.println("    .container { padding: 15px; }");
                out.println("    h2 { font-size: 1.3em; }");
                out.println("    .result-item { flex-direction: column; }");
                out.println("    .value { margin-top: 5px; }");
                out.println("  }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h2>Salary Calculation Result</h2>");
                
                out.println("<div class='result-item'>");
                out.println("<span class='label'>Basic Salary:</span>");
                out.println("<span class='value'>₹" + basic + "</span>");
                out.println("</div>");
                
                out.println("<div class='result-item'>");
                out.println("<span class='label'>DA (" + daPercent + "%):</span>");
                out.println("<span class='value'>₹" + da + "</span>");
                out.println("</div>");
                
                out.println("<div class='result-item'>");
                out.println("<span class='label'>HRA (" + hraPercent + "%):</span>");
                out.println("<span class='value'>₹" + hra + "</span>");
                out.println("</div>");
                
                out.println("<div class='result-item'>");
                out.println("<span class='label'>Gross Salary:</span>");
                out.println("<span class='value gross'>₹" + gross + "</span>");
                out.println("</div>");
                
                out.println("</div>"); // close container
                out.println("</body>");
                out.println("</html>");
            } catch (NumberFormatException e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                out.println("<style>");
                out.println("  body { font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5; }");
                out.println("  .error { max-width: 600px; margin: 50px auto; padding: 20px; background: #ffecec; border: 1px solid #ffb3b3; border-radius: 5px; color: #c0392b; text-align: center; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='error'>");
                out.println("<h2>Error</h2>");
                out.println("<p>Please enter valid numbers for all fields</p>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
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
        return "Calculates gross salary from basic, DA%, and HRA%";
    }
}