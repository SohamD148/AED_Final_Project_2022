/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Role.InventoryManagerRole;
import Model.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author risha
 */
public class InventoryManagerOrganization extends Organization
{

    public InventoryManagerOrganization() {
        super(Organization.Type.InventoryManager.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InventoryManagerRole());
        return roles;
    }
}
