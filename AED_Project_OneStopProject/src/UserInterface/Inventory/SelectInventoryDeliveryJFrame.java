/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Inventory;

import UserInterface.RestaurantSupervisor.*;
import Model.DB4OUtil.DB4OUtil;
import Model.Business.EcoSystem;
import Model.Enterprise.Delivery.ShipmentCompany;
import Model.Enterprise.Outlet;
import Model.Network.Network;
import Model.WorkQueue.InventoryDeliveryRequest;
import Model.WorkQueue.ShipmentRequest;
import Model.WorkQueue.InventoryItemRequest;
import Model.WorkQueue.OrderRequest;
import Model.WorkQueue.WorkRequest;
import UserInterface.MartSupervisor.MartSupervisorMainJPanel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rutu
 */
public class SelectInventoryDeliveryJFrame extends javax.swing.JFrame {

    private EcoSystem system;
    private JPanel panel;
    private Network net;
    private InventoryItemRequest request;
    private Outlet outlet;

    /**
     * Creates new form SelectDeliveryJFrame
     */
    public SelectInventoryDeliveryJFrame(EcoSystem system, JPanel panel, Network net,
           Outlet outlet, InventoryItemRequest request) {
        initComponents();
        this.system = system;
        this.net = net;
        this.request = request;
        this.panel = panel;
        this.outlet = outlet;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) ShipmentDeliveryList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<ShipmentCompany> model = new DefaultListModel<>();
        for (ShipmentCompany del : net.getDeliveryCompanyList()) {
            model.addElement(del);
        }
        ShipmentDeliveryList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShipmentDeliveryList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Delivery Company");

        ShipmentDeliveryList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        ShipmentDeliveryList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ShipmentDeliveryListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ShipmentDeliveryList);

        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShipmentDeliveryListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ShipmentDeliveryListValueChanged

    }//GEN-LAST:event_ShipmentDeliveryListValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ShipmentDeliveryList.getSelectedValue() != null) {
            ShipmentCompany de = (ShipmentCompany) ShipmentDeliveryList.getSelectedValue();
            request.setCompany(de);
            request.setStatus(WorkRequest.StatusEnum.Ready);
            InventoryDeliveryRequest dr = new InventoryDeliveryRequest(outlet, null, request);
            dr.setStatus(WorkRequest.StatusEnum.Ready);
            de.getWorkQueue().getWorkRequestDirectory().add(dr);
            DB4OUtil.getInstance().storeSystem(system);
            if (panel instanceof InventoryManagerMainJPanel) {
                InventoryManagerMainJPanel p = (InventoryManagerMainJPanel) panel;
                p.populateRequestTable();
                p.populateDetailTable(request);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a delivery company");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
//            java.util.logging.Logger.getLogger(SelectDeliveryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SelectDeliveryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SelectDeliveryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SelectDeliveryJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SelectDeliveryJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ShipmentCompany> ShipmentDeliveryList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
