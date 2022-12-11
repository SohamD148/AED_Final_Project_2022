/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Consumer;

import Model.Business.EcoSystem;
import Model.Enterprise.Outlet.OutletType;
import Model.Network.Network;
import Model.UserAccount.ConsumerAccount;
import Model.UserAccount.UserAccount;
import UserInterface.SignInJFrame;
import java.awt.CardLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author rutu
 */
public class ConsumerMainJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private ConsumerAccount consumerAccount;
    private JPanel jPanel;
    private JFrame frame;

    /**
     * Creates new form CustomerMainJPanel
     *
     * @param system
     * @param panel
     * @param userAccount
     * @param frame
     */
    public ConsumerMainJPanel(EcoSystem system, JPanel panel, UserAccount userAccount, JFrame frame) {
        initComponents();
        this.system = system;
        this.jPanel = panel;
        this.frame = frame;
        this.consumerAccount = (ConsumerAccount) userAccount;

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) networkList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Network net : this.system.getNetworkDirectory()) {
            model.addElement(net.getCity());
        }
        networkList.setModel(model);
        label.setText(consumerAccount.getConsumer().getFirstname());
        goButton.setEnabled(false);
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
        label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        networkList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        signoutButton = new javax.swing.JButton();
        viewprofileButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        enterpriseList = new javax.swing.JList<>();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Hello, ");

        label.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        label.setText("<Name>");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Please select your location: ");

        networkList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        networkList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                networkListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(networkList);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel5.setText("City");

        goButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        goButton.setText("GO!!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        signoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        signoutButton.setText("SignOut");
        signoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutButtonActionPerformed(evt);
            }
        });

        viewprofileButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        viewprofileButton.setText("View Profile");
        viewprofileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewprofileButtonActionPerformed(evt);
            }
        });

        enterpriseList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        enterpriseList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                enterpriseListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(enterpriseList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(567, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewprofileButton)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label)
                    .addComponent(signoutButton)
                    .addComponent(viewprofileButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goButton)
                        .addGap(250, 250, 250))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        if (networkList.getSelectedValue() != null) {
            Network net = system.getNetworkByCity((String) networkList.getSelectedValue());
            String city = (String) networkList.getSelectedValue();
            OutletType type = (OutletType) enterpriseList.getSelectedValue();

            OutletListJPanel panel = new OutletListJPanel(system, net, this.jPanel, this.consumerAccount, type, this.frame);
            this.jPanel.add(panel);
            CardLayout layout = (CardLayout) this.jPanel.getLayout();
            layout.next(this.jPanel);
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void networkListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_networkListValueChanged
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) enterpriseList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<OutletType> model = new DefaultListModel<>();
        for (OutletType type : OutletType.values()) {
            model.addElement(type);
        }
        enterpriseList.setModel(model);
        goButton.setEnabled(false);
    }//GEN-LAST:event_networkListValueChanged

    private void viewprofileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewprofileButtonActionPerformed
        //CustomerProfileJPanel jPanel = new CustomerProfileJPanel(this.system, this.jPanel, this.consumerAccount, this.frame, new CustomerRole());
        this.jPanel.add(jPanel);
        CardLayout layout = (CardLayout) this.jPanel.getLayout();
        layout.next(this.jPanel);
    }//GEN-LAST:event_viewprofileButtonActionPerformed

    private void signoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutButtonActionPerformed

        this.frame.dispose();
        System.out.println(system.getNetworkDirectory().size());

//        JOptionPane.showMessageDialog(null, "ksksksks");
        SignInJFrame lf = new SignInJFrame();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_signoutButtonActionPerformed

    private void enterpriseListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_enterpriseListValueChanged
        goButton.setEnabled(true);
    }//GEN-LAST:event_enterpriseListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<OutletType> enterpriseList;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label;
    private javax.swing.JList<String> networkList;
    private javax.swing.JButton signoutButton;
    private javax.swing.JButton viewprofileButton;
    // End of variables declaration//GEN-END:variables
}
