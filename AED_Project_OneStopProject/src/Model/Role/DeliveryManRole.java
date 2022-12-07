/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;

import Model.Business.EcoSystem;
import Model.Enterprise.Enterprise;
import Model.Network.Network;
import Model.UserAccount.UserAccount;
//import UserInterface.UserAccount.UserAccount;
//import UserInterface.ShipmentCompany.Courier.CourierMainJPanel;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rutu
 */
public class DeliveryManRole extends Role {
    
    public DeliveryManRole() {
        super(Role.RoleType.Courier);
    }
    
    @Override
    public String toString() {
        return Role.RoleType.Courier.getValue();
    }

      @Override
      public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {
//        CourierMainJPanel cp = new CourierMainJPanel(system, container, en, userAccount, frame, this);
//        container.add(cp);
//        CardLayout layout = (CardLayout) container.getLayout();
//        layout.next(container);
//    }
      }
}
