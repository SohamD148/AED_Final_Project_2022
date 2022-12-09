/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import Model.Business.EcoSystem;
import Model.Enterprise.Delivery.ShipmentCompany;
import Model.Enterprise.Enterprise;
import Model.Enterprise.Restaurant.Restaurant;
import Model.Enterprise.Mart.Mart;
import Model.Network.Network;
import Model.Role.SystemAdminRole;
import Model.UserAccount.ConsumerAccount;
import Model.UserAccount.EmployeeAccount;
import Model.UserAccount.UserAccount;
import UserInterface.Consumer.ConsumerProfileJPanel;
import UserInterface.ShipmentCompany.Supervisor.ShipmentCompanySupervisorMainJPanel;
import UserInterface.RestaurantSupervisor.RestaurantSupervisorMainJPanel;
import UserInterface.MartSupervisor.MartSupervisorMainJPanel;
import java.awt.CardLayout;

/**
 *
 * @author rutu
 */
public class SystemAdminMainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form SystemManagerMainJFrame
     */

    public SystemAdminMainJFrame(EcoSystem system, Network selectedNetwork, Enterprise selectedEnterprise, 
            String selectedCategory, EmployeeAccount employeeAccount, UserAccount customerAccount, 
            SystemAdminMainJPanel panel) {
        initComponents();
        this.setSize(1000, 1000);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (selectedEnterprise instanceof Restaurant) {
            RestaurantSupervisorMainJPanel cp = new RestaurantSupervisorMainJPanel(system, this.jPanel1,
                    selectedNetwork, selectedEnterprise, employeeAccount, this,new SystemAdminRole());
            this.jPanel1.add(cp);
        }
        if (selectedEnterprise instanceof ShipmentCompany) {
            ShipmentCompanySupervisorMainJPanel cp = new ShipmentCompanySupervisorMainJPanel(system, this.jPanel1,
                    selectedNetwork, selectedEnterprise, employeeAccount, this, new SystemAdminRole());
            this.jPanel1.add(cp);
        }
        if (selectedEnterprise instanceof Mart) {
            MartSupervisorMainJPanel cp = new MartSupervisorMainJPanel(system, this.jPanel1,
                    selectedNetwork, selectedEnterprise, employeeAccount, this, new SystemAdminRole());
            this.jPanel1.add(cp);
        }
        if (selectedEnterprise == null) {
            ConsumerProfileJPanel cp = new ConsumerProfileJPanel(system, panel, 
                    (ConsumerAccount) customerAccount, this, new SystemAdminRole());
            this.jPanel1.add(cp);
        }
        CardLayout layout = (CardLayout) this.jPanel1.getLayout();
        layout.next(this.jPanel1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SystemAdminMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SystemAdminMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SystemAdminMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SystemAdminMainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SystemAdminMainJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}