/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.modified.inventory.control.system;

import java.awt.print.PrinterException;
import javax.swing.table.TableModel;

/**
 *
 * @author 4U
 */
public class invoice extends javax.swing.JPanel {

    /**
     * Creates new form invoice
     */
    public invoice() {
        initComponents();
    }
    String linv;
    String ltot;
    String lpay;
    String lbal;
    
    public invoice( String inv,String tot,String pay,String bal,TableModel tableModel) throws PrinterException {
        initComponents();
        
        this.linv= inv;
        this.ltot= tot;
        this.ltot= pay;
        this.ltot= pay;
        
        txtprint.setText(txtprint.getText()+"*******************************************\n");
         txtprint.setText(txtprint.getText()+"*A MODIFIED INVENTORY CONTROL SYSTEM*");
         txtprint.setText(txtprint.getText()+"\n");
         txtprint.setText(txtprint.getText()+"\n");
         txtprint.setText(txtprint.getText()+"\n");
         txtprint.setText(txtprint.getText()+"invoice No:" + inv+ "\n");
         
         txtprint.setText(txtprint.getText()+"product" + "\t" +"price" + "\t" + "total" + "\n");
         
            for(int i=0; i<tableModel.getRowCount();i++)
            {
            String product=(String) tableModel.getValueAt(i,1);
            String price=(String) tableModel.getValueAt(i,2);
            String total =(String) tableModel.getValueAt(i,4);
            txtprint.setText(txtprint.getText()+product + "\t" + price + "\t" + total + "\n");
            
            }
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"\n");
        
        txtprint.setText(txtprint.getText()+"          "     + "total     " + tot+    "\n");
        txtprint.setText(txtprint.getText()+"          "     + "paid     " + pay+    "\n");
        txtprint.setText(txtprint.getText()+"          "     + "balance    " + bal+    "\n");
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"\n");
        txtprint.setText(txtprint.getText()+"*****************************************************\n");
        txtprint.setText(txtprint.getText()+"*****************************************************\n");
        txtprint.setText(txtprint.getText()+                    "**THANK YOU**\n"                     );
        
        txtprint.print();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(322, 312));

        txtprint.setEditable(false);
        txtprint.setColumns(20);
        txtprint.setRows(5);
        jScrollPane1.setViewportView(txtprint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtprint;
    // End of variables declaration//GEN-END:variables
}
