/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Employee;

/**
 *
 * @author risha
 */
public class Employee {
    private int empid;
    private String firstname;
    private String lastname;
    private String fullname;
    private String mobile_no;
    private String email_id;
    private static int empidcounter = 0;

    public Employee(String firstname, String lastname, String mobile_no, String email_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile_no = mobile_no;
        this.email_id = email_id;
        this.empid = empidcounter;
        this.fullname = firstname + " " + lastname;
        empidcounter++;
    }

    
    
    
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    @Override
    public String toString() {
        return this.fullname; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
