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
@WebServlet(urlPatterns = {"/CheckVotingEligibility"})
public class CheckVotingEligibility extends HttpServlet {

    private static final int VOTING_AGE = 18;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get parameters from the form
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Voting Eligibility Result</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; margin: 40px; }");
            out.println(".result { max-width: 500px; margin: 0 auto; padding: 20px; border: 1px solid #ddd; border-radius: 5px; text-align: center; }");
            out.println(".eligible { color: green; }");
            out.println(".not-eligible { color: red; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='result'>");
            
            // Check voting eligibility
            if (age >= VOTING_AGE) {
                out.println("<h2 class='eligible'>Congratulations, " + name + "!</h2>");
                out.println("<p>You are <strong>eligible</strong> to vote as you are " + age + " years old.</p>");
            } else {
                out.println("<h2 class='not-eligible'>Sorry, " + name + "!</h2>");
                out.println("<p>You are <strong>not eligible</strong> to vote yet. You need to be at least " + VOTING_AGE + 
                           " years old, but you are only " + age + ".</p>");
                out.println("<p>You can vote in " + (VOTING_AGE - age) + " years.</p>");
            }
            
            out.println("<a href='voting.html'>Check another person</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect GET requests to POST handling
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that checks voting eligibility based on age";
    }
}