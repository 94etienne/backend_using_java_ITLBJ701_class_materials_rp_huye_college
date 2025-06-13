package com.mvc.model;

public class Employee {
    private int regno;
    private String fname;
    private String lname;
    private String email;
    private String phone;

    public Employee() {}

    public Employee(int regno, String fname, String lname, String email, String phone) {
        this.regno = regno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public int getRegno() { return regno; }
    public void setRegno(int regno) { this.regno = regno; }
    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }
    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
