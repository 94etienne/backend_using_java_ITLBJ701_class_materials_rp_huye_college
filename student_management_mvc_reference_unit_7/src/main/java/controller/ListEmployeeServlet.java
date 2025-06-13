package controller;

import dao.EmployeeDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/ListEmployeeServlet")
public class ListEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> list = EmployeeDAO.getAllEmployees();
        request.setAttribute("employeeList", list);
        RequestDispatcher view = request.getRequestDispatcher("list-employee.jsp");
        view.forward(request, response);
    }
}