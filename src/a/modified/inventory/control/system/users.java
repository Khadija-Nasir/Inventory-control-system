/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.modified.inventory.control.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 4U
 */
public class users extends javax.swing.JPanel {
PreparedStatement st;
    
    public users() {
        initComponents();
        tableupdate();
        

    }
    //function to insert data into the table
    public void tableupdate(){
        int count;
        try {
               DefaultTableModel dtm =  (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
            PreparedStatement st = myconnection.getConnection().prepareStatement("select * from users_admins  ");
        ResultSet rs = st.executeQuery();
        
        ResultSetMetaData rsmd = rs.getMetaData();
        count = rsmd.getColumnCount();
        
     
        
        while(rs.next()){
            Vector v = new Vector();
            
            
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                 v.add(rs.getString(4));
                 v.add(rs.getString(5));
                
                dtm.addRow(v);
        }
        } catch (SQLException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   //function to check if the category already exist in the db
   /* public boolean checkUser(String username, String password){
        PreparedStatement st;
        
        ResultSet rs;
        boolean user_exist = false;
        //qty = qty+1;
        String query = "SELECT * FROM `users_admins` WHERE `name` = ?,`username` = ?, `password` = ?,`status` = ?";
       // String query1 = "UPDATE `product` SET `qty` = '?' WHERE `product`.`barcode` = ?"
;

         try {
             
            st = myconnection.getConnection().prepareStatement(query);
            st.setString(1, username);
            st.setString(2, password);
            //st.setString(2,qty);
            rs = st.executeQuery(); 

      if(rs.next()){
         user_exist = true;
         //qty = qty+1;
      }
         }
      catch (SQLException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        }

    return user_exist;
    }
    */
    //create a function to cheeck if the entered username already exists in the database
    public boolean checkUser(String name){
        PreparedStatement st;
        ResultSet rs;
        boolean username_exist = false;
        String query = "SELECT * FROM `users_admins` WHERE `name` = ?";
         try {
            st = myconnection.getConnection().prepareStatement(query);
            st.setString(1, name);
            rs = st.executeQuery(); 

      if(rs.next()){
          username_exist = true;
          JOptionPane.showMessageDialog(null, "this username already exist,choose another one" ,"username failed",2);
      }
         }
      catch (SQLException ex) {
            Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
        }

    return username_exist;
    }
   
//create function to verify the empty fields
    public boolean verifyfields(){
        
        String Name = jTextField1.getText();
        String username = jTextField5.getText();
        String password = jTextField4.getText();
        
         //check empty fields
        if (Name.trim().equals("") || username.trim().equals("") || password.trim().equals("") ){
        JOptionPane.showMessageDialog(null, "one or more fields cannot be empty","empty fields",1);
            return false;
        }
        else{
            return true;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Username");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Password");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Confirm password");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/user_add.png"))); // NOI18N
        jButtonAdd.setText("Add ");
        jButtonAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/update.png"))); // NOI18N
        jButtonUpdate.setText("update");
        jButtonUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/user_delete.png"))); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Name");

        txtstatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Status");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))))
                .addGap(59, 59, 59))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "username", "paswsord", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEditingColumn(0);
        jTable1.setEditingRow(0);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchFieldKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/search.png"))); // NOI18N
        jLabel15.setText("Name");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
         
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked

    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        PreparedStatement st;

        String name = jTextField1.getText();
        String username = jTextField5.getText();
        String password = jTextField4.getText();
        String status = txtstatus.getSelectedItem().toString();
                if(verifyfields()){
            if(!checkUser(name)){

                //if(!checkProduct(barcode)){
                    try {
                        tableupdate();
                        st = myconnection.getConnection().prepareStatement("INSERT INTO `users_admins`(`name`, `username`, `password`,`status`) values(?,?,?,?);");
                        st.setString(1, name);
                        st.setString(2, username);
                        st.setString(3, password);
                        st.setString(4, status);
                        st.executeUpdate();

                        JOptionPane.showMessageDialog(null, "user added");
                        tableupdate();
                        //clear the fields
                        jTextField1.setText("");
                        jTextField5.setText("");
                        jTextField4.setText("");
                        jTextField2.setText("");
                                               //request the focus of the cursor
                        jTextField1.requestFocus();

                        // TODO add your handling code here:
                    } catch (SQLException ex) {
                        Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // TODO add your handling code here:
                    // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed
     }
    }
    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        if (verifyfields()){
            PreparedStatement st;
            DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            //parse id of the selected row to id
            int id = Integer.parseInt(dtm1.getValueAt(selectIndex, 0).toString());

            String name = jTextField1.getText();
            String username = jTextField5.getText();
            String password = jTextField4.getText();
             String status = txtstatus.getSelectedItem().toString();
           
            try {
                st = myconnection.getConnection().prepareStatement("update users_admins set name=?,username=?,password=?,status=? where id =?");

                st.setString(1, name);
                st.setString(2, username);
                st.setString(3, password);
                st.setString(4, status);
                st.setInt(5,id);
                st.executeUpdate();

                JOptionPane.showMessageDialog(null, "user updated");
                tableupdate();
                //clear the fields
                jTextField1.setText("");
                jTextField5.setText("");
                jTextField4.setText("");
                jTextField2.setText("");
                
               
                //request the focus of the cursor
                jTextField1.requestFocus();

            } catch (SQLException ex) {
                Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
            }
            // TODO add your handling code here:
            // TODO add your handling code here:

    }//GEN-LAST:event_jButtonUpdateActionPerformed
    }
    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (verifyfields()){
            PreparedStatement st;
            DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            int id = Integer.parseInt(dtm1.getValueAt(selectIndex, 0).toString());
            int dialogresult = JOptionPane.showConfirmDialog(null,"do you want to delete the selected product?","warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_OPTION){
                try {
                    st = myconnection.getConnection().prepareStatement("delete from users_admins where id=?");
                    st.setInt(1,id);
                    st.executeUpdate();

                    JOptionPane.showMessageDialog(null, "user deleted");
                    tableupdate();
                    jTextField1.setText("");
                    jTextField5.setText("");
                    jTextField4.setText("");
                    jTextField2.setText("");


                    //request the focus of the cursor
                    jTextField1.requestFocus();
                }
                catch (SQLException ex) {
                    Logger.getLogger(users.class.getName()).log(Level.SEVERE, null, ex);
                }

            }        // TODO add your handling code here:
            // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        jTextField1.setText(dtm1.getValueAt(selectIndex,1).toString());
        jTextField5.setText(dtm1.getValueAt(selectIndex, 2).toString());
        jTextField4.setText(dtm1.getValueAt(selectIndex, 3).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldKeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
         if (!Character.isAlphabetic(evt.getKeyChar())){
            evt.consume();
       }        
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
   
         String name = searchField.getText();
        try{  
        
      DefaultTableModel  dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
     PreparedStatement    s = myconnection.getConnection().prepareStatement(" SELECT * from users_admins WHERE Name LIKE'%"+name+"%' ");
         ResultSet rs = s.executeQuery();
         
         while(rs.next()){
         Vector v = new Vector();
        
         v.add(rs.getString(1));
         v.add(rs.getString(2));
         v.add(rs.getString(3));
         v.add(rs.getString(4));
         v.add(rs.getString(5));
         
         dt.addRow(v);
         }
      
      
      }
      catch(Exception e)
              {
      tableupdate();
      }

    }//GEN-LAST:event_searchFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> txtstatus;
    // End of variables declaration//GEN-END:variables
}
