package dao;

import java.sql.*;
import java.util.*;
import model.Employee;

public class EmployeeDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/student_management";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    private static final String INSERT_EMPLOYEE = "INSERT INTO employee (regno, fname, lname, email, phone) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM employee";
    private static final String SELECT_BY_ID = "SELECT * FROM employee WHERE id=?";
    private static final String UPDATE_EMPLOYEE = "UPDATE employee SET regno=?, fname=?, lname=?, email=?, phone=? WHERE id=?";
    private static final String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // CHECK EXISTING RECORD REGNO
    public boolean isRegNoExists(String regno) {
        String query = "SELECT COUNT(*) FROM employee WHERE regno = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, regno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // CHECK EXISTING RECORD Email
    public boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) FROM employee WHERE email = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // CHECK EXISTING RECORD Phone Number
    public boolean isPhoneExists(String phone) {
        String query = "SELECT COUNT(*) FROM employee WHERE phone = ?";
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean insertEmployee(Employee emp) {
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, emp.getRegno());
            ps.setString(2, emp.getFname());
            ps.setString(3, emp.getLname());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getPhone());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                return false;
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    emp.setId(generatedKeys.getInt(1));
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Employee> selectAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_ALL);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                employees.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("regno"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("email"),
                        rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee selectEmployee(int id) {
        Employee emp = null;
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Employee(
                        rs.getInt("id"),
                        rs.getString("regno"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("email"),
                        rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }

    public boolean updateEmployee(Employee emp) {
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEE)) {

            ps.setString(1, emp.getRegno());
            ps.setString(2, emp.getFname());
            ps.setString(3, emp.getLname());
            ps.setString(4, emp.getEmail());
            ps.setString(5, emp.getPhone());
            ps.setInt(6, emp.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployee(int id) {
        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}