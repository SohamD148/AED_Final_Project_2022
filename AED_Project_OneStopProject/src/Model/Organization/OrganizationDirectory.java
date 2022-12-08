/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Organization;

import Model.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author risha
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationDirectory;
    
    public OrganizationDirectory() {
        this.organizationDirectory = new ArrayList<>();
    }
    
    public ArrayList<Organization> getOrganizationDirectory() {
        return this.organizationDirectory;
    }
    
    public Organization getTypicalOrganization(Type type) {
        if (type.equals(Type.Courier)) {
            for (Organization or:this.organizationDirectory) {
                if (or.getOrg_name().equalsIgnoreCase(Type.Courier.getValue())) {
                    return or;
                }
            }
        }
        if (type.equals(Type.Supervisor)) {
            for (Organization or:this.organizationDirectory) {
                if (or.getOrg_name().equalsIgnoreCase(Type.Supervisor.getValue())) {
                    return or;
                }
            }
        }
        return null;
    }
}
