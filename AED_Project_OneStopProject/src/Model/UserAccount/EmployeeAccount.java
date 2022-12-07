/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.UserAccount;

import Model.Employee.Employee;
import Model.Enterprise.Enterprise;
import Model.Role.Role;

/**
 *
 * @author sohamdeshpande
 */
public class EmployeeAccount extends UserAccount {
    
    private Employee employee;

    public EmployeeAccount(String username, String password, Role role, Employee employee) {
        super(username, password, role);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee em) {
        this.employee = em;
    }
}
