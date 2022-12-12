/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Consumer;

import Model.Consumer.CommodityOrder;
import Model.DB4OUtil.DB4OUtil;
import Model.Business.EcoSystem;
import Model.Enterprise.Outlet;
import Model.Network.Network;
import Model.UserAccount.ConsumerAccount;
import Model.UserAccount.EmployeeAccount;
import Model.WorkQueue.InventoryItemRequest;
import Model.WorkQueue.OrderRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author risha
 */
public class PlaceInventoryOrderJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private ConsumerAccount customerAccount;
    private EmployeeAccount employeeAccount;
    private JPanel container;
    private Outlet shop;
    private Network net;

    /**
     * Creates new form PlaceOrderJPanel
     */

    
    public PlaceInventoryOrderJPanel(EcoSystem system, JPanel container, EmployeeAccount employeeAccount,
            Outlet shop, Network net) {
        initComponents();
        this.system = system;
        this.container = container;
        this.employeeAccount = employeeAccount;
        this.shop = shop;
        this.net = net;

        populateTable2();
        this.restaurantLabel.setText(this.shop.getOrg_name());
    }
    

//    private RestaurantAccount getAccountByRestaurant(Restaurant restaurant) {
//        for (UserAccount ua : en.getUserAccountDirectory().getUserAccountList()) {
//            if (ua.getRole().getRoleType().equals(RoleType.Restaurant)) {
//                RestaurantAccount ra = (RestaurantAccount) ua;
//                if (ra.getRestaurant().getId() == restaurant.getId()) {
//                    return ra;
//                }
//            }
//        }
//        return null;
//    }

    private void populateTable2() {
           DefaultTableModel dtm = (DefaultTableModel) cartTable.getModel();
        dtm.setRowCount(0);
        for (CommodityOrder order : employeeAccount.getBasket().getCommodityDirectory()) {
            Object row[] = new Object[3];
            row[0] = order;
            row[1] = order.getQuantity();
            row[2] = order.getTotalPrice();
            dtm.addRow(row);
        }
        BigDecimal bd = new BigDecimal(this.employeeAccount.getBasket().getTotalPrice());
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
        restaurantLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        addressTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        placeOrderButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 153, 153));

        cartTable.setEnabled(false);
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "items", "Quantity", "Price"
            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cartTable);

        restaurantLabel.setBackground(new java.awt.Color(255, 153, 153));
        restaurantLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Total:");

        priceLabel.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        priceLabel.setText("0.00");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Delivery Information");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("*Name: ");

        nameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        addressTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("*Address: ");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("*Phone:");

        phoneTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Comments:");

        commentTextArea.setColumns(20);
        commentTextArea.setRows(4);
        jScrollPane3.setViewportView(commentTextArea);

        placeOrderButton.setText("Place Order");
        placeOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOrderButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(priceLabel)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(placeOrderButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(134, 134, 134)))))
                        .addGap(31, 31, 31))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaurantLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restaurantLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(priceLabel))
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placeOrderButton)
                    .addComponent(cancelButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked

    }//GEN-LAST:event_cartTableMouseClicked

    private void placeOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOrderButtonActionPerformed
        if (this.nameTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Name can't be empty!");
            return;
        }
        if (this.addressTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Address can't be empty!");
            return;
        }
        if (this.phoneTextField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Phone Number can't be empty!");
            return;
        }
        if (employeeAccount instanceof EmployeeAccount)
        {
        InventoryItemRequest ir = new InventoryItemRequest(shop, employeeAccount,
        employeeAccount.getBasket().getCommodityDirectory());
        ir.setDeliveryAddress(this.addressTextField.getText());
        ir.setDeliveryName(this.nameTextField.getText());
        ir.setDeliveryPhone(this.phoneTextField.getText());
        ir.setMessage(this.commentTextArea.getText());
        ir.setStatus(WorkRequest.StatusEnum.Processing);
        BigDecimal bd = new BigDecimal(this.employeeAccount.getBasket().getTotalPrice());
        ir.setAmount(bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        
        
        employeeAccount.getBasket().clearBasket();
        employeeAccount.getWorkQueue().getWorkRequestDirectory().add(ir);
        shop.getWorkQueue().getWorkRequestDirectory().add(ir);
        DB4OUtil.getInstance().storeSystem(system);
        
        this.container.remove(this);
        OrderInventoryConfirmationJPanel panel = new OrderInventoryConfirmationJPanel(ir);
        this.container.add(panel);
        CardLayout layout = (CardLayout)this.container.getLayout();
        layout.next(this.container);
        }
    }//GEN-LAST:event_placeOrderButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.container.remove(this);
        CardLayout layout = (CardLayout) this.container.getLayout();

        for (Component com : this.container.getComponents()) {
            if (com instanceof BasketJPanel) {
                BasketJPanel panel = (BasketJPanel) com;
                panel.populateTable();
            }
        }
        layout.previous(this.container);
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable cartTable;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton placeOrderButton;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel restaurantLabel;
    // End of variables declaration//GEN-END:variables
}
