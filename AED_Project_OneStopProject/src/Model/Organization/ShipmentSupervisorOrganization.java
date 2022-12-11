/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Organization;

import Model.Role.ShipmentSupervisorRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rutu
 */
public class ShipmentSupervisorOrganization extends Organization {

    public ShipmentSupervisorOrganization() {
        super(Organization.Type.ShipmentSupervisor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ShipmentSupervisorRole());
        return roles;
    }
}
