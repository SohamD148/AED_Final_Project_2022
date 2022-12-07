/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;

import Model.Business.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.Organization.Organization.Type;
import Model.UserAccount.UserAccount;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rutu
 */
public abstract class Role {
    private RoleType type;
    
    public enum RoleType{
        Boss("Boss"),
        Supervisor("Manager"),
        Consumer("Consumer"),
        Courier("Delivery Man"),
        SystemAdmin("System Manager");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        public Type getOrganizationType() {
            if (this.value.equals(Supervisor.getValue())) {
                return Type.Supervisor;
            }
            if (this.value.equals(Courier.getValue())) {
                return Type.Courier;
            }
            else {
                return null;
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public Role(RoleType type) {
        this.type = type;
    }
    
    public RoleType getRoleType() {
        return this.type;
    }
    
    @Override
    public abstract String toString();
    
    public abstract void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame);
}