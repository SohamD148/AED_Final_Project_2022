/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;

import Model.Role.Role.RoleType;

/**
 *
 * @author rutu
 */
public class RoleSelection {
    
    public static Role createRole(RoleType type) {
        if(type.equals(RoleType.Courier)) {
            return new DeliveryManRole();
        }
        if (type.equals(RoleType.Supervisor)) {
            return new SupervisorRole();
        }
        if(type.equals(RoleType.Boss)) {
            return new BossRole();
        }
        if(type.equals(RoleType.SystemAdmin)) {
            return new SystemAdminRole();
        }
        return null;
    }
}
