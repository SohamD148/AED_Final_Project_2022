/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Role;

import Model.Business.EcoSystem;
import Model.Enterprise.Delivery.ShipmentCompany;
import Model.Enterprise.Enterprise;
import Model.Enterprise.Restaurant.Restaurant;
import Model.Enterprise.Mart.Mart;
import Model.Network.Network;
import Model.Role.Role.RoleType;
import Model.UserAccount.UserAccount;
import UserInterface.ShipmentCompany.Supervisor.ShipmentCompanySupervisorMainJPanel;
import UserInterface.RestaurantSupervisor.RestaurantSupervisorMainJPanel;
import UserInterface.MartSupervisor.MartSupervisorMainJPanel;

import UserInterface.ShipmentCompany.Supervisor.ShipmentCompanySupervisorMainJPanel;
import UserInterface.RestaurantSupervisor.RestaurantSupervisorMainJPanel;
import UserInterface.MartSupervisor.MartSupervisorMainJPanel;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rutu
 */
public class BossRole extends Role {
    
    public BossRole() {
        super(RoleType.Boss);
    }

    @Override
    public void createWorkArea(EcoSystem system, JPanel container, UserAccount userAccount, Network net, Enterprise en, JFrame frame) {

        if (en instanceof Restaurant) {
            RestaurantSupervisorMainJPanel cp = new RestaurantSupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof ShipmentCompany) {
            ShipmentCompanySupervisorMainJPanel cp = new ShipmentCompanySupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof Mart) {
            MartSupervisorMainJPanel cp = new MartSupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        CardLayout layout = (CardLayout) container.getLayout();
        layout.next(container);

        if (en instanceof Restaurant) {
            RestaurantSupervisorMainJPanel cp = new RestaurantSupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof ShipmentCompany) {
            ShipmentCompanySupervisorMainJPanel cp = new ShipmentCompanySupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }
        if (en instanceof Mart) {
            MartSupervisorMainJPanel cp = new MartSupervisorMainJPanel(system, container, net, en, userAccount, frame, this);
            container.add(cp);
        }

    }

    @Override
    public String toString() {
        return RoleType.Boss.getValue();
    }
}
