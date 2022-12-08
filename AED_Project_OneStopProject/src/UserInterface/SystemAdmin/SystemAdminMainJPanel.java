/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UserInterface.SystemAdmin;


import Model.Employee.Employee;
import Model.Network.Network;
import Model.Enterprise.Enterprise;
import Model.Business.EcoSystem;
import Model.UserAccount.ConsumerAccount;
import Model.UserAccount.EmployeeAccount;
import Model.UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rutu
 */
public class SystemAdminMainJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminMainJPanel
     */
    
    
    private EcoSystem system;
    private EmployeeAccount employeeAccount;
    private Employee employee;
    private JFrame frame;
    private JPanel container;
    private Network selectedNetwork = null;
    private String selectedCategory = "";
    private Enterprise selectedEnterprise = null;

    public SystemAdminMainJPanel(EcoSystem system, JPanel container, UserAccount userAccount, JFrame frame) {
        initComponents();
        
        this.system = system;
        this.container = container;
        this.employeeAccount = (EmployeeAccount) userAccount;
        this.frame = frame;

        this.employee = this.employeeAccount.getEmployee();

        // Manage System Panel
        populateNetworkList();
        
        editNetworkBtn.setEnabled(false);
        createEnterpriseBtn.setEnabled(false);
        removeEnterpriseBtn.setEnabled(false);
        editEnterpriseBtn.setEnabled(false);

        // Profile panel
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        setProfileInfo();
        setProfileFieldsEditable(false);

        // customer panel
        populateTable(system.getUserAccountDirectory().getUserAccountDirectory());
  
    
    }
    public ArrayList<ConsumerAccount> toConsumerAccounts(ArrayList<UserAccount> list) {
        ArrayList<ConsumerAccount> result = new ArrayList<>();
        for (UserAccount UA : getAllConsumerAccounts(list)) {
            ConsumerAccount consumerAcc = (ConsumerAccount) UA;
            result.add(consumerAcc);
        }
        return result;
    }
    
    private ArrayList<UserAccount> getAllConsumerAccounts(ArrayList<UserAccount> list) {
        ArrayList<UserAccount> result = new ArrayList<>();
        for (UserAccount UA : list) {
            if (UA instanceof ConsumerAccount) {
                result.add(UA);
            }
        }
        return result;
    }
    
    public void populateTable(ArrayList<UserAccount> list) {
        DefaultTableModel dtm = (DefaultTableModel) customerTable.getModel();
        dtm.setRowCount(0);
        for (UserAccount UA : getAllConsumerAccounts(list)) {
            ConsumerAccount consumerAcc = (ConsumerAccount) UA;
            Object row[] = new Object[5];
            row[0] = consumerAcc;
            row[1] = consumerAcc.getConsumer().getFullname();
            row[2] = consumerAcc.getConsumer().getEmail();
            row[3] = consumerAcc.getConsumer().getMobile_no();
            row[4] = consumerAcc.getTotalPurchased();
            dtm.addRow(row);
        }
    }
    
    
    
    private void setProfileInfo() {
        txtRole.setText(this.employeeAccount.getRole().getRoleType().getValue());
        nameLabel.setText(employee.getFirstname());
        txtEmail.setText(employee.getEmail_id());
        txtFirstName.setText(employee.getFirstname());
        txtLastName.setText(employee.getLastname());
        txtPhone.setText(employee.getMobile_no());
        txtUserName.setText(employeeAccount.getUsername());
    }

    private void setProfileFieldsEditable(boolean b) {
        txtEmail.setEnabled(b);
        txtFirstName.setEnabled(b);
        txtLastName.setEnabled(b);
        txtPhone.setEnabled(b);
    }

    private void resetPasswordField() {
        txtNewPassword.setText("");
        txtConfirmPassword.setText("");
        txtOldPassword.setText("");
    }
    
    
     public void populateNetworkList() {
        //== networkList
        DefaultListCellRenderer renderer1 = (DefaultListCellRenderer) listNetwork.getCellRenderer();
        renderer1.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<String> networkModel = new DefaultListModel<>();
        for (Network net : system.getNetworkDirectory()) {
            networkModel.addElement(net.getCity());
        }
        listNetwork.setModel(networkModel);

        editNetworkBtn.setEnabled(false);
    }
     
     public void populateEnterpriseList() {
        //== Enterprise Category 
        if (typeList.getSelectedValue() != null) {
            selectedCategory = typeList.getSelectedValue();
            DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) listEnterprise.getCellRenderer();
            renderer3.setHorizontalAlignment(SwingConstants.CENTER);
            DefaultListModel<Enterprise> enterpriseModel = new DefaultListModel<>();

            if (selectedCategory.equalsIgnoreCase("Shipment Company")) {
                for (Enterprise enterprise : selectedNetwork.getDeliveryCompanyList()) {
                    enterpriseModel.addElement(enterprise);
                }
            }
            if (selectedCategory.equalsIgnoreCase("Restaurant")) {
                for (Enterprise enterprise : selectedNetwork.getRestaurantList()) {
                    enterpriseModel.addElement(enterprise);
                }
            }
            if (selectedCategory.equalsIgnoreCase("Store")) {
                for (Enterprise enterprise : selectedNetwork.getStoreList()) {
                    enterpriseModel.addElement(enterprise);
                }
            }
            listEnterprise.setModel(enterpriseModel);
        }

        createEnterpriseBtn.setEnabled(true);
        removeEnterpriseBtn.setEnabled(false);
        editEnterpriseBtn.setEnabled(false);
    }
     
     public void populateTypeList() {
        int index = listNetwork.getSelectedIndex();
        if (index >= 0) {
            DefaultListModel<Enterprise> enterpriseModel = new DefaultListModel<>();
            listEnterprise.setModel(enterpriseModel);

            String networkSelection = (String) listNetwork.getSelectedValue();
            selectedNetwork = system.getNetworkByCity(networkSelection);

            //== Enterprise Category 
            DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) typeList.getCellRenderer();
            renderer2.setHorizontalAlignment(SwingConstants.CENTER);
            DefaultListModel<String> categoryModel = new DefaultListModel<>();
            categoryModel.addElement("Shipment Company");
            categoryModel.addElement("Outlet");
            categoryModel.addElement("Restaurant");
            typeList.setModel(categoryModel);

            createEnterpriseBtn.setEnabled(false);
            removeEnterpriseBtn.setEnabled(false);
            editEnterpriseBtn.setEnabled(false);
        }
    }
      public void resetAllLists() {
        DefaultListModel<Enterprise> enterpriseModel = new DefaultListModel<>();
        listEnterprise.setModel(enterpriseModel);

        DefaultListModel<String> typeModel = new DefaultListModel<>();
        typeList.setModel(typeModel);

        populateNetworkList();
    }
      
      
     
      
      
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabSystemAdmin = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        networkPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listNetwork = new javax.swing.JList<>();
        createNetworkBtn = new javax.swing.JButton();
        editNetworkBtn = new javax.swing.JButton();
        removeNetworkBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        typeList = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        editEnterpriseBtn = new javax.swing.JButton();
        createEnterpriseBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listEnterprise = new javax.swing.JList<>();
        removeEnterpriseBtn = new javax.swing.JButton();
        createAccountBtn = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        viewDetailsBtn = new javax.swing.JButton();
        removeAccountBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        profilePanel = new javax.swing.JPanel();
        txtRole = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        passwordPanel = new javax.swing.JPanel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        txtOldPassword = new javax.swing.JPasswordField();
        cancelButton1 = new javax.swing.JButton();
        txtNewPassword = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel6.setText("Network");

        jScrollPane1.setViewportView(listNetwork);

        createNetworkBtn.setText("Add a new Network");
        createNetworkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNetworkBtnActionPerformed(evt);
            }
        });

        editNetworkBtn.setText("Edit existing network");

        removeNetworkBtn.setText("Remove existing network");

        javax.swing.GroupLayout networkPanelLayout = new javax.swing.GroupLayout(networkPanel);
        networkPanel.setLayout(networkPanelLayout);
        networkPanelLayout.setHorizontalGroup(
            networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkPanelLayout.createSequentialGroup()
                .addGroup(networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(networkPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(networkPanelLayout.createSequentialGroup()
                        .addGroup(networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editNetworkBtn)
                            .addGroup(networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(networkPanelLayout.createSequentialGroup()
                                    .addGap(92, 92, 92)
                                    .addComponent(jLabel6))
                                .addGroup(networkPanelLayout.createSequentialGroup()
                                    .addGap(58, 58, 58)
                                    .addComponent(createNetworkBtn))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(networkPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(removeNetworkBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        networkPanelLayout.setVerticalGroup(
            networkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(createNetworkBtn)
                .addGap(18, 18, 18)
                .addComponent(editNetworkBtn)
                .addGap(18, 18, 18)
                .addComponent(removeNetworkBtn)
                .addGap(25, 25, 25))
        );

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel17.setText("Enterprise Category");

        jScrollPane2.setViewportView(typeList);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel17))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel18.setText("Enterprise");

        editEnterpriseBtn.setText("Edit existing Enterprise");
        editEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEnterpriseBtnActionPerformed(evt);
            }
        });

        createEnterpriseBtn.setText("Add a new Enterprise");
        createEnterpriseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEnterpriseBtnActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listEnterprise);

        removeEnterpriseBtn.setText("Remove existing Enterprise");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(removeEnterpriseBtn)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(jLabel18))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(editEnterpriseBtn)
                                .addComponent(createEnterpriseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createEnterpriseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editEnterpriseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeEnterpriseBtn)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(networkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(networkPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        tabSystemAdmin.addTab("ManageNetwork", jPanel1);

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Name", "Email", "Phone", "Total Purchased"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(customerTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Search:");

        jButton2.setText("Search");

        jButton3.setText("All");

        jButton4.setText("create account");

        viewDetailsBtn.setText("View");

        removeAccountBtn.setText("Remove");

        javax.swing.GroupLayout createAccountBtnLayout = new javax.swing.GroupLayout(createAccountBtn);
        createAccountBtn.setLayout(createAccountBtnLayout);
        createAccountBtnLayout.setHorizontalGroup(
            createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAccountBtnLayout.createSequentialGroup()
                .addGroup(createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createAccountBtnLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 858, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(createAccountBtnLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(26, 26, 26)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))))
                    .addGroup(createAccountBtnLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jButton4)
                        .addGap(92, 92, 92)
                        .addComponent(viewDetailsBtn)
                        .addGap(92, 92, 92)
                        .addComponent(removeAccountBtn)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        createAccountBtnLayout.setVerticalGroup(
            createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createAccountBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(jButton3)))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(createAccountBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(viewDetailsBtn)
                    .addComponent(removeAccountBtn))
                .addContainerGap(144, Short.MAX_VALUE))
        );

        tabSystemAdmin.addTab("Manage Customer", createAccountBtn);

        txtRole.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Role:");

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel16.setText("Last Name: ");

        txtUserName.setEnabled(false);
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addContainerGap(287, Short.MAX_VALUE)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(354, 354, 354))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilePanelLayout.createSequentialGroup()
                        .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(profilePanelLayout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(285, 285, 285))))
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilePanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(profilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        tabSystemAdmin.addTab("My Profile", jPanel3);

        cancelButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton1.setText("Cancel");

        submitButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        submitButton.setText("Submit");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setText("Confirm Password:");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("New Password:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel13.setText("Old Password:");

        javax.swing.GroupLayout passwordPanelLayout = new javax.swing.GroupLayout(passwordPanel);
        passwordPanel.setLayout(passwordPanelLayout);
        passwordPanelLayout.setHorizontalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(passwordPanelLayout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(passwordPanelLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(passwordPanelLayout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(passwordPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        passwordPanelLayout.setVerticalGroup(
            passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(passwordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton1))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 969, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 665, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(passwordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabSystemAdmin.addTab("ChangePassword", jPanel4);

        logoutBtn.setText("Log out");

        nameLabel.setText("<name>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tabSystemAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addGap(38, 38, 38)
                .addComponent(logoutBtn)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutBtn)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabSystemAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createNetworkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNetworkBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createNetworkBtnActionPerformed

    private void editEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEnterpriseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editEnterpriseBtnActionPerformed

    private void createEnterpriseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEnterpriseBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createEnterpriseBtnActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JPanel createAccountBtn;
    private javax.swing.JButton createEnterpriseBtn;
    private javax.swing.JButton createNetworkBtn;
    private javax.swing.JTable customerTable;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editEnterpriseBtn;
    private javax.swing.JButton editNetworkBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<Enterprise> listEnterprise;
    private javax.swing.JList<String> listNetwork;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel networkPanel;
    private javax.swing.JPanel passwordPanel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton removeAccountBtn;
    private javax.swing.JButton removeEnterpriseBtn;
    private javax.swing.JButton removeNetworkBtn;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTabbedPane tabSystemAdmin;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtOldPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JList<String> typeList;
    private javax.swing.JButton viewDetailsBtn;
    // End of variables declaration//GEN-END:variables
}
