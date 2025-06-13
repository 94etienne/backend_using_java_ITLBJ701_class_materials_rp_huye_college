import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
            
            // Create SQL query
            PreparedStatement st = con.prepareStatement(
                "insert into demo values(?, ?)");
            
            // Set parameters
            st.setInt(1, Integer.parseInt(request.getParameter("id")));
            st.setString(2, request.getParameter("string"));
            
            // Execute query
            st.executeUpdate();
            
            // Close connections
            st.close();
            con.close();
            
            // Send success response with proper Bootstrap structure
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<title>Insert Result</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("<div class='row justify-content-center'>");
            out.println("<div class='col-md-6'>");
            out.println("<div class='card'>");
            out.println("<div class='card-body text-center'>");
            out.println("<div class='alert alert-success mb-4'>Successfully Inserted Data</div>");
            out.println("<a href='insert.html' class='btn btn-primary'>Back to Form</a>");
            out.println("</div></div></div></div></div>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</body></html>");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<title>Error</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container mt-5'>");
            out.println("<div class='row justify-content-center'>");
            out.println("<div class='col-md-6'>");
            out.println("<div class='card'>");
            out.println("<div class='card-body text-center'>");
            out.println("<div class='alert alert-danger mb-4'>Error: " + e.getMessage() + "</div>");
            out.println("<a href='insert.html' class='btn btn-primary'>Back to Form</a>");
            out.println("</div></div></div></div></div>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</body></html>");
        }
    }
}