/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Consumer;

import Model.Consumer.CommodityOrder;
import Model.DB4OUtil.DB4OUtil;
import Model.Business.EcoSystem;
import Model.Network.Network;
import Model.UserAccount.ConsumerAccount;
import java.awt.CardLayout;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author risha
 */
public class BasketJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private ConsumerAccount consumeracc;
    private Network network;
    private JPanel panel;

    /**
     * Creates new form CartJPanel
     */
    public BasketJPanel(EcoSystem system, JPanel container, ConsumerAccount account, Network net) {
        initComponents();

        this.system = system;
        this.panel = container;
        this.consumeracc = account;
        this.network = net;

        deleteButton.setEnabled(false);
        modifyButton.setEnabled(false);

        if (!account.getBasket().getCommodityDirectory().isEmpty()) {
            restaurantLabel.setText(account.getBasket().getCommodityDirectory().get(0).getShopModel().getOrg_name());
        } else {
            checkoutButton.setEnabled(false);
        }
        
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        dtm.setRowCount(0);
        for (CommodityOrder order : consumeracc.getBasket().getCommodityDirectory()) {
            Object row[] = new Object[3];
            row[0] = order;
            row[1] = order.getQuantity();
            row[2] = order.getTotalPrice();
            dtm.addRow(row);
        }
        BigDecimal bd = new BigDecimal(this.consumeracc.getBasket().getTotalPrice());
        priceLabel.setText(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        checkoutButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        restaurantLabel = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Dash", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cartTable);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Total:");

        priceLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        priceLabel.setText("0.00");

        checkoutButton.setText("Checkout");
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        clearButton.setText("Clear Cart");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Modify Quantity");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shopping Cart");

        restaurantLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(restaurantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addGap(53, 53, 53)
                            .addComponent(priceLabel)
                            .addGap(54, 54, 54))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(deleteButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(clearButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(modifyButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(checkoutButton)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(restaurantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(516, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(priceLabel))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(checkoutButton)
                        .addComponent(deleteButton)
                        .addComponent(clearButton)
                        .addComponent(modifyButton))
                    .addContainerGap(13, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked
        deleteButton.setEnabled(true);
        modifyButton.setEnabled(true);
    }//GEN-LAST:event_cartTableMouseClicked

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        OrderJPanel panel = new OrderJPanel(this.system, this.panel, this.consumeracc, 
            consumeracc.getBasket().getCommodityDirectory().get(0).getShopModel(), network);
        this.panel.add(panel);
        CardLayout layout = (CardLayout) this.panel.getLayout();
        layout.next(this.panel);
    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = cartTable.getSelectedRow();

        if (selectedRow >= 0) {
            CommodityOrder order = (CommodityOrder) cartTable.getValueAt(selectedRow, 0);
            this.consumeracc.getBasket().getCommodityDirectory().remove(order);
        }
        DB4OUtil.getInstance().storeSystem(system);
        populateTable();
        deleteButton.setEnabled(false);
        modifyButton.setEnabled(false);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all the items in the shopping cart?",
                "Clear Shopping Cart", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            this.consumeracc.getBasket().clearBasket();
            DB4OUtil.getInstance().storeSystem(system);
            populateTable();
        }
    }//GEN-LAST:event_clearButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        int selectedRow = cartTable.getSelectedRow();

        if (selectedRow >= 0) {
            CommodityOrder order = (CommodityOrder) cartTable.getValueAt(selectedRow, 0);
            String input = JOptionPane.showInputDialog(null, "Please enter the quantity: ",
                    "Quantity Change", JOptionPane.PLAIN_MESSAGE);
            if (input != null) {
                try {
                    int newQuantity = Integer.parseInt(input);
                    if (newQuantity == 0) {
                        this.consumeracc.getBasket().getCommodityDirectory().remove(order);
                    } else {
                        order.setQuantity(newQuantity);
                    }
                    DB4OUtil.getInstance().storeSystem(system);
                    populateTable();
                    deleteButton.setEnabled(false);
                    modifyButton.setEnabled(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a number");
                }
            }
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cartTable;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel restaurantLabel;
    // End of variables declaration//GEN-END:variables
}
