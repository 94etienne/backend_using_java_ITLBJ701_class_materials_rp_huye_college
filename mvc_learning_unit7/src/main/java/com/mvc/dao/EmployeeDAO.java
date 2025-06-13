package com.mvc.dao;

import com.mvc.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employee (regno, fname, lname, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, employee.getRegno());
            ps.setString(2, employee.getFname());
            ps.setString(3, employee.getLname());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPhone());
            ps.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employee";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setRegno(rs.getInt("regno"));
                employee.setFname(rs.getString("fname"));
                employee.setLname(rs.getString("lname"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employees.add(employee);
            }
        }
        return employees;
    }

    public Employee getEmployee(int regno) throws SQLException {
        String query = "SELECT * FROM employee WHERE regno = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, regno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setRegno(rs.getInt("regno"));
                    employee.setFname(rs.getString("fname"));
                    employee.setLname(rs.getString("lname"));
                    employee.setEmail(rs.getString("email"));
                    employee.setPhone(rs.getString("phone"));
                    return employee;
                }
            }
        }
        return null;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employee SET fname = ?, lname = ?, email = ?, phone = ? WHERE regno = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, employee.getFname());
            ps.setString(2, employee.getLname());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getPhone());
            ps.setInt(5, employee.getRegno());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(int regno) throws SQLException {
        String query = "DELETE FROM employee WHERE regno = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, regno);
            ps.executeUpdate();
        }
    }
}
