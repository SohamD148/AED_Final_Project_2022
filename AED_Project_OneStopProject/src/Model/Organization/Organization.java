/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Employee.EmployeeDirectory;
import Model.Role.Role;
import Model.UserAccount.UserAccountDirectory;
import Model.WorkQueue.WorkQueue;
import java.util.ArrayList;


/**
 *
 * @author risha
 */
public abstract class Organization {
    
    private int orgId;
    private String org_name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccounts;
    private static int counter;
    
    public enum Type {

        Supervisor("Manager Organization"),
        Courier("Delivery Man Organization"),
        Chef("Chef Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        counter++;
        this.orgId = counter;
        this.org_name = name;
        this.workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccounts = new UserAccountDirectory();
    }

    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return orgId;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccounts;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
}
