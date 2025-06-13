package model;

public class Employee {
    private int id;
    private String regno;
    private String fname;
    private String lname;
    private String email;
    private String phone;

    public Employee() {}

    public Employee(int id, String regno, String fname, String lname, String email, String phone) {
        this.id = id;
        this.regno = regno;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getId() { return id; }
    public String getRegno() { return regno; }
    public String getFname() { return fname; }
    public String getLname() { return lname; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setRegno(String regno) { this.regno = regno; }
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
}