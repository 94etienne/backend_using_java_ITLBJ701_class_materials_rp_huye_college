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

@WebServlet("/EditData")
public class EditData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        
        try {
            Connection con = DatabaseConnection.initializeDatabase();
            PreparedStatement ps = con.prepareStatement("select * from demo where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang='en'>");
                out.println("<head>");
                out.println("<meta charset='UTF-8'>");
                out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                out.println("<title>Edit Record</title>");
                out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
                out.println("</head>");
                out.println("<body class='bg-light'>");
                out.println("<div class='container py-5'>");
                out.println("<div class='row justify-content-center'>");
                out.println("<div class='col-md-6 col-lg-4'>");
                out.println("<div class='card shadow'>");
                out.println("<div class='card-body p-4'>");
                out.println("<h2 class='card-title text-center mb-4'>Edit Record</h2>");
                out.println("<form action='UpdateData' method='post'>");
                out.println("<input type='hidden' name='id' value='" + rs.getInt("id") + "'>");
                out.println("<div class='mb-3'>");
                out.println("<label for='string' class='form-label'>String:</label>");
                out.println("<input type='text' class='form-control' id='string' name='string' value='" + rs.getString("string") + "' required>");
                out.println("</div>");
                out.println("<div class='d-grid gap-2'>");
                out.println("<button type='submit' class='btn btn-primary'>Update</button>");
                out.println("<a href='DisplayData' class='btn btn-outline-secondary'>Cancel</a>");
                out.println("</div>");
                out.println("</form>");
                out.println("</div></div></div></div></div>");
                out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
                out.println("</body></html>");
            }
            con.close();
        } catch (Exception e) {
            out.println("<div class='alert alert-danger'>Error: " + e.getMessage() + "</div>");
            e.printStackTrace();
        }
    }
}