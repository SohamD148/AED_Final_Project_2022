/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Role.SupervisorRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author risha
 */
public class SupervisorOrganization extends Organization {
    
    public SupervisorOrganization() {
        super(Organization.Type.Supervisor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SupervisorRole());
        return roles;
    }
}
