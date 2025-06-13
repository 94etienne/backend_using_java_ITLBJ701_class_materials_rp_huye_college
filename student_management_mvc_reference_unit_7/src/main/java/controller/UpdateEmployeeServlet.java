package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String regno = request.getParameter("regno");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        
        Employee e = new Employee(regno, fname, lname, email, phone);
        e.setId(id);
        
        int status = EmployeeDAO.update(e);
        
        if (status > 0) {
            response.sendRedirect("ListEmployeeServlet");
        } else {
            response.sendRedirect("EditEmployeeServlet?id=" + id);
        }
    }
}