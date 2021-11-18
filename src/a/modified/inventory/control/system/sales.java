/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.modified.inventory.control.system;

import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 4U
 */
public class sales extends javax.swing.JPanel {
PreparedStatement st;
DefaultTableModel tblModel ;
//DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

    ResultSet rs;
    public sales() {
        initComponents();

        generateInvoiceNumber();
        txtbarcode.requestFocus();
  }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtbarcode = new javax.swing.JTextField();
        txtpname = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        txtprice = new javax.swing.JTextField();
        txtsubtotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttotal = new javax.swing.JTextField();
        txtpayment = new javax.swing.JTextField();
        pay_Invoice = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtbalance = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteAll = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        invoicenumber = new javax.swing.JTextField();

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtbarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbarcodeActionPerformed(evt);
            }
        });
        txtbarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbarcodeKeyPressed(evt);
            }
        });

        txtpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpnameActionPerformed(evt);
            }
        });

        txtqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtqtyActionPerformed(evt);
            }
        });

        txtsubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubtotalActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Barcode Number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Product");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText(" Subtotal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtpname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txttotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalActionPerformed(evt);
            }
        });

        pay_Invoice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        pay_Invoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/printer.png"))); // NOI18N
        pay_Invoice.setText("Print Invoice");
        pay_Invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_InvoiceActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Total");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Paid Amount");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Balance");

        txtbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(pay_Invoice)
                .addGap(122, 122, 122))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pay_Invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "code", "item", "amount", "quantity", "total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Invoice No:");

        deleteAll.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/delete.png"))); // NOI18N
        deleteAll.setText("Delete All");
        deleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAllActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/a/modified/inventory/control/system/icon/project icons/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        invoicenumber.setEditable(false);
        invoicenumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(invoicenumber, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(deleteAll)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(invoicenumber)
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteAll, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtbarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbarcodeActionPerformed

    }//GEN-LAST:event_txtbarcodeActionPerformed

    public boolean verifyfields(){
   try{ 
       String barcode = txtbarcode.getText();
       String pname=   txtpname.getText();
       String price=txtprice.getText();
       String qty =txtqty.getText();
       String subtotal =txtsubtotal.getText();
    
        if(txtbarcode.getText().equals("")||
                             txtpname.getText().equals("") ||
                             txtprice.getText().equals("") ||
                             txtqty.getText().equals("") ||
                             txtsubtotal.getText().equals(""))
                     {
                        JOptionPane.showMessageDialog(this, "one or more fields cannot be empty");
                        return false;
            }
        
        }
     catch(NumberFormatException e){
     }
        return true;
}

    public boolean checkTable()
    {
      if ( jTable1.getModel() != null)  
      {
          JOptionPane.showMessageDialog(this, "no row to delete");
      return jTable1.getModel().getRowCount()<=0;
      
      }
     // JOptionPane.showMessageDialog(this, "no row to delete");
        return false;
        
    }
    
    private void generateInvoiceNumber(){
    
        try{
            Statement stm = myconnection.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.setMaxRows(1);
            ResultSet rst;
            rst = stm.executeQuery("select invoice_no from  sales order by invoice_no desc");
             try{
            if (rst.next()){
           
                int lastNo = Integer.parseInt(rst.getString("invoice_no"));
            int newNo = lastNo + 000000001;
            invoicenumber.setText(String.valueOf(newNo));
            }
            else{
            int initialNo = 000000001; 
            invoicenumber.setText(String.valueOf(initialNo));
            }
        }  catch (NumberFormatException e){
            System.out.println(e);
        }
        }
        catch(SQLException e){
        JOptionPane.showMessageDialog(this,"there was an error while generating invoice no","Error!", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace(System.err);
        
        }
    
    
    }  
    
    
    
    
    private void txtbarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbarcodeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            String barcode = txtbarcode.getText();
            try {
                st = myconnection.getConnection().prepareStatement("select * from product where barcode= ?");
                st.setString(1,barcode);
                rs = st.executeQuery();

                if (rs.next() == false){
                    JOptionPane.showMessageDialog(this, "barcode not found");
                    txtbarcode.setText("");
            }
                else{

                    String productname = rs.getString("pname");
                    String price = rs.getString("pretailprice");
                    
                    txtpname.setText(productname.trim());
                    txtprice.setText(price.trim());
                    txtqty.setText("1");

                    try{ 
                        int qty = Integer.parseInt(txtqty.getText());
                        int price1 = Integer.parseInt(txtprice.getText());
                        int total = price1 * qty;

                        txtsubtotal.setText(String.valueOf(total));}
                    catch(NumberFormatException e){
                        System.out.println(e);
                        
            }

                    verifyfields();

                    //store entered data into string array --tableupdate--
                    String tableupdate[] = {txtbarcode.getText(),txtpname.getText(),txtprice.getText(),txtqty.getText(),txtsubtotal.getText()};
                    tblModel = (DefaultTableModel)jTable1.getModel();
                    // add string array data
                    tblModel.addRow(tableupdate);//row added
                    
                    
                  try{ 
                      int sum = 0;
                    for (int i=0; i<jTable1.getRowCount();i++){
                sum = sum+Integer.parseInt(jTable1.getValueAt(i,4).toString());
                }
                    txttotal.setText(Integer.toString(sum));
                  }
                  catch(NumberFormatException e){
                   System.out.println(e);
                  }
                    txtbarcode.setText("");
                    txtpname.setText("");
                    txtprice.setText("");
                    txtqty.setText("");
                    txtsubtotal.setText("");
                    txtpayment.requestFocus();
                }

            } catch (SQLException ex) {
                Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtbarcodeKeyPressed
}
    private void txtpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpnameActionPerformed

    private void txtqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtqtyActionPerformed

    private void deleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAllActionPerformed
       if(!checkTable()){
           //DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                   tblModel.setRowCount(0);
               }
    }//GEN-LAST:event_deleteAllActionPerformed

   private void sales()
   {
    
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String date = dtf.format(now);
    
    String total = txttotal.getText();
    String payment = txtpayment.getText();
    String balance = txtbalance.getText();
    String invoiceNo = invoicenumber.getText();
   int lastinsertId = 0;
    
    try {
        
        String query = "INSERT INTO `sales`(`invoice_no`,`date`, `subtotal`, `payment`, `balance`) values(?,?,?,?,?);";
        st = myconnection.getConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        
        st.setString(1, invoiceNo); 
        st.setString(2, date);
        st.setString(3, total);
        st.setString(4, payment);
        st.setString(5, balance);
        st.executeUpdate();
        ResultSet generatedKeyResult = st.getGeneratedKeys();
    
        if(generatedKeyResult.next()){
        lastinsertId = generatedKeyResult.getInt(1);
        }
       
        
        
        int rows = jTable1.getRowCount();
       
       String query1 = "INSERT INTO `sales_product`(`sales_id`, `product_id`, `sell_price`, `qty`,`total`) values(?,?,?,?,?);";
       st = myconnection.getConnection().prepareStatement(query1);
       
      String product_id; 
      String price;
      String qty;
      String tot;
       
       
       
       for (int i=0; i<jTable1.getRowCount(); i++)
       {
       
           product_id = (String)jTable1.getValueAt(i, 0);
           price = (String)jTable1.getValueAt(i, 2);
           qty= (String)jTable1.getValueAt(i, 3);
           tot = (String)jTable1.getValueAt(i, 4);
       
           st.setInt(1, lastinsertId);
           st.setString(2, product_id);
           st.setString(3, price);
           st.setString(4, qty);
           st.setString(5, tot);
           
           st.executeUpdate();
      
       }
       
       String query2 = "update product set qty = qty-? where barcode=?";
       st = myconnection.getConnection().prepareStatement(query2);
       
       
       for(int i=0; i<jTable1.getRowCount(); i++)
       {
       product_id = (String)jTable1.getValueAt(i, 0);
       qty = (String)jTable1.getValueAt(i, 3);
           
         st.setString(1, qty);
         st.setString(2, product_id);
         st.execute();
       
       }
       
  
        st.addBatch();
        //JOptionPane.showMessageDialog(this, "recorded");
        
    } catch (SQLException ex) {
        Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
    }
                       
    
    
    
    }
    
    
    public void invoice()
    {
        
    String tot = txttotal.getText();
    String pay = txtpayment.getText();
    String bal = txtbalance.getText();
    String inv = invoicenumber.getText();
 
    try {
        new invoice(inv,tot,pay,bal,jTable1.getModel()).setVisible(true);
    } catch (PrinterException ex) {
        Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    private void txtsubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubtotalActionPerformed

    private void pay_InvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_InvoiceActionPerformed
        if(txttotal.getText().isEmpty() || txtpayment.getText().isEmpty())
        {
        JOptionPane.showMessageDialog(null,"No invoice generated","null invoice",1);
        }
        else
        {
        int pay = Integer.parseInt(txtpayment.getText());
        int total = Integer.parseInt(txttotal.getText());
        
        int bal = total - pay ;
        
        txtbalance.setText(String.valueOf(bal));
        sales();
        invoice();
        
                    txttotal.setText("");
                    txtpayment.setText("");
                    txtbalance.setText("");
                      
                   tblModel.setRowCount(0);
                   
                    generateInvoiceNumber();
                    txtbarcode.requestFocus();
        
        
        }
    }//GEN-LAST:event_pay_InvoiceActionPerformed

    private void txtbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbalanceActionPerformed

    private void txttotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
   if(!checkTable()){
        tblModel.removeRow(jTable1.getSelectedRow());
       int sum = 0;
       for(int i=0; i<jTable1.getRowCount(); i++){
        sum = sum + Integer.parseInt(jTable1.getValueAt(i,4).toString());
       
      }
       txttotal.setText(Integer.toString(sum));
        
   }
        
        
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JButton deleteAll;
    private javax.swing.JTextField invoicenumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pay_Invoice;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtbarcode;
    private javax.swing.JTextField txtpayment;
    private javax.swing.JTextField txtpname;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtqty;
    private javax.swing.JTextField txtsubtotal;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
