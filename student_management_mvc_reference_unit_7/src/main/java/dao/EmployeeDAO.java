package dao;

import model.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static int save(Employee e) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                "INSERT INTO employee(regno, fname, lname, email, phone) VALUES (?,?,?,?,?)");
            ps.setString(1, e.getRegno());
            ps.setString(2, e.getFname());
            ps.setString(3, e.getLname());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhone());
            
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }
    
    public static int update(Employee e) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(
                "UPDATE employee SET regno=?, fname=?, lname=?, email=?, phone=? WHERE id=?");
            ps.setString(1, e.getRegno());
            ps.setString(2, e.getFname());
            ps.setString(3, e.getLname());
            ps.setString(4, e.getEmail());
            ps.setString(5, e.getPhone());
            ps.setInt(6, e.getId());
            
            status = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }
    
    public static int delete(int id) {
        int status = 0;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return status;
    }
    
    public static Employee getEmployeeById(int id) {
        Employee e = new Employee();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE id=?");
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setRegno(rs.getString(2));
                e.setFname(rs.getString(3));
                e.setLname(rs.getString(4));
                e.setEmail(rs.getString(5));
                e.setPhone(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return e;
    }
    
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement("SELECT * FROM employee");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setRegno(rs.getString(2));
                e.setFname(rs.getString(3));
                e.setLname(rs.getString(4));
                e.setEmail(rs.getString(5));
                e.setPhone(rs.getString(6));
                list.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }
}