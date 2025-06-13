import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayData")
public class DisplayData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement ps = con.prepareStatement("select * from demo");
            ResultSet rs = ps.executeQuery();
            
            out.println("<!DOCTYPE html>");
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
            out.println("<title>View Records</title>");
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body class='bg-light'>");
            out.println("<div class='container py-5'>");
            out.println("<div class='row justify-content-center'>");
            out.println("<div class='col-lg-8'>");
            out.println("<div class='card shadow'>");
            out.println("<div class='card-header bg-primary text-white'>");
            out.println("<h3 class='mb-0'>All Records</h3>");
            out.println("</div>");
            out.println("<div class='card-body'>");
            
            out.println("<div class='table-responsive'>");
            out.println("<table class='table table-striped table-hover'>");
            out.println("<thead class='table-dark'>");
            out.println("<tr><th>ID</th><th>String</th><th>Actions</th></tr>");
            out.println("</thead>");
            out.println("<tbody>");
            
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("string") + "</td>");
                out.println("<td>");
                out.println("<a href='EditData?id=" + rs.getInt("id") + "' class='btn btn-sm btn-warning me-2'>Edit</a>");
                out.println("<a href='DeleteData?id=" + rs.getInt("id") + "' class='btn btn-sm btn-danger' onclick='return confirm(\"Are you sure you want to delete this record?\")'>Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }
            
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
            
            out.println("<div class='text-center mt-3'>");
            out.println("<a href='insert.html' class='btn btn-primary'>Add New Record</a>");
            out.println("</div>");
            
            out.println("</div></div></div></div></div>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
            out.println("</body></html>");
            
            con.close();
        } catch (Exception e) {
            out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
            e.printStackTrace();
        }
    }
}