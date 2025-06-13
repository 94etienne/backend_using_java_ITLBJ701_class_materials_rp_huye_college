package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import dao.EmployeeDAO;
import model.Employee;

@WebServlet(name = "EmployeeServlet", value = "/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertEmployee(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                default:
                    listEmployees(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("listEmployee", employeeDAO.selectAllEmployees());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee-add.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.selectEmployee(id);
        request.setAttribute("employee", existingEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/employee-edit.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String regno = request.getParameter("regno");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        // Check if registration number already exists
        if (employeeDAO.isRegNoExists(regno)) {
            request.setAttribute("error", "Employee with registration number " + regno + " already exists");
            request.getRequestDispatcher("views/employee-add.jsp").forward(request, response);
            return;
        }

        // Check if email id already exists
        if (employeeDAO.isEmailExists(email)) {
            request.setAttribute("error", "Employee with Email id " + email + " already exists");
            request.getRequestDispatcher("views/employee-add.jsp").forward(request, response);
            return;
        }

        // Check if phone number already exists
        if (employeeDAO.isPhoneExists(phone)) {
            request.setAttribute("error", "Employee with Email id " + phone + " already exists");
            request.getRequestDispatcher("views/employee-add.jsp").forward(request, response);
            return;
        }

        Employee newEmployee = new Employee(0, regno, fname, lname, email, phone);

        if (employeeDAO.insertEmployee(newEmployee)) {
            response.sendRedirect("EmployeeServlet");
        } else {
            request.setAttribute("error", "Failed to add employee");
            request.getRequestDispatcher("views/employee-add.jsp").forward(request, response);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String regno = request.getParameter("regno");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Employee employee = new Employee(id, regno, fname, lname, email, phone);

        if (employeeDAO.updateEmployee(employee)) {
            response.sendRedirect("EmployeeServlet");
        } else {
            request.setAttribute("error", "Failed to update employee");
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("views/employee-edit.jsp").forward(request, response);
        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployee(id);
        response.sendRedirect("EmployeeServlet");
    }
}