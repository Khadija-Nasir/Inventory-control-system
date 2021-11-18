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
public class product extends javax.swing.JPanel {
PreparedStatement st;
DefaultTableModel dtm;
    
    public product() {
        initComponents();
        tableupdate();
        category();
        brand();

    }
    //function to insert data into the table
    private void tableupdate(){
        int count;
        try {
                dtm =  (DefaultTableModel)jTable1.getModel();
        dtm.setRowCount(0);
            PreparedStatement pst = myconnection.getConnection().prepareStatement("select p.id,p.barcode,p.pname,p.pcostprice,p.pretailprice,p.qty,b.brand,c.category from product p,brand b,category c where p.pcategory_id = c.id and p.pbrand_id = b.id ");
        ResultSet rs = pst.executeQuery();
        
        ResultSetMetaData rsmd = rs.getMetaData();
        count = rsmd.getColumnCount();
        
     
        
        while(rs.next()){
            Vector v = new Vector();
            
            //for (int i=1; i<=count; i++){
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(8));
                v.add(rs.getString(7));
                
               
            //}
            dtm.addRow(v);
        }
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public class categoryItem{
        int id;
        String category;
       
        public categoryItem(int id,String category){
            this.id = id;
            this.category = category;
         }
    public String toString(){
        return category;
    }

        
    }
    
     public class brandItem{
        int id;
        String brand;
       
        public brandItem(int id,String brand){
            this.id = id;
            this.brand = brand;
      
         }
        @Override
    public String toString(){
        return brand;
    }

       
    }
    private void category(){
           
        try {
            st = myconnection.getConnection().prepareStatement("select * from category");
       ResultSet rs = st.executeQuery();
       jComboBox1.removeAllItems();
       
       while(rs.next()){
          jComboBox1.addItem(new categoryItem(rs.getInt(1),rs.getString(2))); 
       }
       
           
           } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     private void brand(){
           
        try {
            st = myconnection.getConnection().prepareStatement("select * from brand");
       ResultSet rs = st.executeQuery();
       jComboBox2.removeAllItems();
       
       while(rs.next()){
          jComboBox2.addItem(new brandItem(rs.getInt(1),rs.getString(2))); 
       }
       
           
           } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//function to check if the category already exist in the db
    public boolean checkProduct(String barcode){
        PreparedStatement pst;
        
        ResultSet rs;
        boolean barcode_exist = false;
        //qty = qty+1;
        String query = "SELECT * FROM `product` WHERE `barcode` = ?";
       // String query1 = "UPDATE `product` SET `qty` = '?' WHERE `product`.`barcode` = ?";

         try {
             
            pst = myconnection.getConnection().prepareStatement(query);
            pst.setString(1, barcode);
            //st.setString(2,qty);
            rs = pst.executeQuery(); 

      if(rs.next()){
         barcode_exist = true;
         //qty = qty+1;
      }
         }
      catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

    return barcode_exist;
    }
    
   
//create function to verify the empty fields
    public boolean verifyfields(){
        
        String barcode = jTextField1.getText();
        String pname = jTextField4.getText();
        String pcostprice = jTextField2.getText();
        String pretailprice = jTextField6.getText();
        String qty = jTextField7.getText();
        categoryItem catitem = (categoryItem)jComboBox1.getSelectedItem();
        brandItem britem = (brandItem)jComboBox2.getSelectedItem();
         //check empty fields
        if (barcode.trim().equals("") || pname.trim().equals("") || pcostprice.trim().equals("") || pretailprice.trim().equals("") || qty.trim().equals("") || catitem.equals("") || britem.equals("") ){
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
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButtonAdd = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Barcode:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Name:");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Cost price:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Retail price:");

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Qty:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Category:");

        jComboBox1.setToolTipText("");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Brand:");

        jButtonAdd.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/add.png"))); // NOI18N
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
        jButtonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/delete.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField4))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
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
                "Id", "Barcode", "Name", "Cost Price", "Retail Price", "Qty", "Category", "Brand"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        jLabel15.setText("search");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(searchField, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // allow only numbers
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // allow only numbers
       // if (!Character.isLetter(evt.getKeyChar())){
            //evt.consume();
       // }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // allow only numbers
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // allow only numbers
        if (!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked

    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed

        PreparedStatement pst;

        String barcode = jTextField1.getText();
        String pname = jTextField4.getText();
        String pcostprice = jTextField2.getText();
        String pretailprice = jTextField6.getText();
        String qty = jTextField7.getText();
        categoryItem catitem = (categoryItem)jComboBox1.getSelectedItem();
        brandItem britem = (brandItem)jComboBox2.getSelectedItem();
        if(verifyfields()){
            if(!checkProduct(barcode)){

                //if(!checkProduct(barcode)){
                    try {
                        tableupdate();
                        pst = myconnection.getConnection().prepareStatement("INSERT INTO `product`(`barcode`, `pname`, `pcostprice`, `pretailprice`, `qty`,`pbrand_id`, `pcategory_id`) values(?,?,?,?,?,?,?);");
                        pst.setString(1, barcode);
                        pst.setString(2, pname);
                        pst.setString(3, pcostprice);
                        pst.setString(4, pretailprice);
                        pst.setString(5, qty);
                        pst.setInt(6, britem.id);
                        pst.setInt(7, catitem.id);
                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, "product added");
                        tableupdate();
                        //clear the fields
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jComboBox1.setSelectedIndex(-1);
                        jComboBox2.setSelectedIndex(-1);
                        jTextField4.setText("");
                        jTextField6.setText("");
                        //request the focus of the cursor
                        jTextField1.requestFocus();

                        // TODO add your handling code here:
                    } catch (SQLException ex) {
                        Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddActionPerformed
     }
    }
    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        if (verifyfields()){
            PreparedStatement pst;
            dtm = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            //parse id of the selected row to id
            int id = Integer.parseInt(dtm.getValueAt(selectIndex, 0).toString());

            String barcode = jTextField1.getText();
            String pname = jTextField4.getText();
            String pcostprice = jTextField2.getText();
            String pretailprice = jTextField6.getText();
            String qty = jTextField7.getText();
            categoryItem catitem = (categoryItem)jComboBox1.getSelectedItem();
            brandItem britem = (brandItem)jComboBox2.getSelectedItem();
            try {
                pst = myconnection.getConnection().prepareStatement("update product set barcode=?,pname=?,pcostprice=?,pretailprice=?,qty=?,pbrand_id=?,pcategory_id=? where id =?");

                pst.setString(1, barcode);
                pst.setString(2, pname);
                pst.setString(3, pcostprice);
                pst.setString(4, pretailprice);
                pst.setString(5, qty);
                pst.setInt(6, britem.id);
                pst.setInt(7, catitem.id);
                pst.setInt(8,id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "product updated");
                tableupdate();
                //clear the fields
                jTextField1.setText("");
                jTextField2.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jTextField4.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                //request the focus of the cursor
                jTextField1.requestFocus();

            } catch (SQLException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }
            // TODO add your handling code here:

    }//GEN-LAST:event_jButtonUpdateActionPerformed
    }
    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        if (verifyfields()){
            PreparedStatement pst;
            DefaultTableModel dt = (DefaultTableModel)jTable1.getModel();
            int selectIndex = jTable1.getSelectedRow();
            int id = Integer.parseInt(dt.getValueAt(selectIndex, 0).toString());
            int dialogresult = JOptionPane.showConfirmDialog(null,"do you want to delete the selected product?","warning",JOptionPane.YES_NO_OPTION);
            if(dialogresult == JOptionPane.YES_OPTION){
                try {
                    pst = myconnection.getConnection().prepareStatement("delete from product where id=?");
                    pst.setInt(1,id);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "product deleted");
                    tableupdate();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jComboBox1.setSelectedIndex(-1);
                    jComboBox2.setSelectedIndex(-1);
                    jTextField4.setText("");
                    jTextField6.setText("");
                    jTextField7.setText("");
                    //request the focus of the cursor
                    jTextField1.requestFocus();
                }
                catch (SQLException ex) {
                    Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                }

            }        // TODO add your handling code here:
            // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel dtm1 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        jTextField1.setText(dtm1.getValueAt(selectIndex,1).toString());
        jTextField4.setText(dtm1.getValueAt(selectIndex, 2).toString());
        jTextField2.setText(dtm1.getValueAt(selectIndex, 3).toString());
        jTextField6.setText(dtm1.getValueAt(selectIndex, 4).toString());
        jTextField7.setText(dtm1.getValueAt(selectIndex, 5).toString());
        //jComboBox1.setSelectedItem(dtm1.getValueAt(selectIndex, 6).toString());
        //jComboBox2.setSelectedItem(dtm1.getValueAt(selectIndex, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldKeyTyped

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
      
        String barcode = searchField.getText();
        try{  
        
      DefaultTableModel  dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
     PreparedStatement    s = myconnection.getConnection().prepareStatement(" SELECT * from product WHERE barcode LIKE'%"+barcode+"%' ");
         ResultSet rs = s.executeQuery();
         
         while(rs.next()){
         Vector v = new Vector();
        
         v.add(rs.getString(1));
         v.add(rs.getString(2));
         v.add(rs.getString(3));
         v.add(rs.getString(4));
         v.add(rs.getString(5));
         v.add(rs.getString(6));
         v.add(rs.getString(7));
         v.add(rs.getString(8));
         
         dt.addRow(v);
         }
      
      
      }
      catch(SQLException e)
              {
      tableupdate();
      }
        
        
    }//GEN-LAST:event_searchFieldKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
