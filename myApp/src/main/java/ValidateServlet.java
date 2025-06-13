import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet(urlPatterns = {"/ValidateServlet"})
public class ValidateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("user");
        String password = request.getParameter("pass");
        
        if(password != null && password.equals("l6y2")) {
            // Forward to WelcomeServlet with username
            RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
            request.setAttribute("user", name);
            rd.forward(request, response);
        }
        else {
            // Set error message and forward back to login page
            request.setAttribute("error", "You have entered incorrect password");
            RequestDispatcher rd = request.getRequestDispatcher("validate.jsp");
            rd.forward(request, response);
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
        return "Validates user login credentials";
    }
}