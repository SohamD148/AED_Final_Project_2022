
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
