/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ActionHandler;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import model.InvoiceHeader;
import model.InvoiceHeaderTableModel;
import model.InvoiceLineTableModel;

/**
 *
 * @author NADA
 */
public class DesignPreview extends javax.swing.JFrame {

    /**
     * Creates new form DesignPreview
     */
    public DesignPreview() {
        handler = new ActionHandler(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeftSidePanel = new javax.swing.JPanel();
        InvoicesTableScrollPane = new javax.swing.JScrollPane();
        InvoicesTable = new javax.swing.JTable();
        InvoicesTableLBl = new javax.swing.JLabel();
        createNewInvoiceBtn = new javax.swing.JButton();
        DeleteNewInvoiceBtn = new javax.swing.JButton();
        RightSidePanel = new javax.swing.JPanel();
        InvoiceNumberLBl = new javax.swing.JLabel();
        InvoiceDateLBl = new javax.swing.JLabel();
        CustomerNameLBl = new javax.swing.JLabel();
        TotalInvoiceLBl = new javax.swing.JLabel();
        SaveBtn = new javax.swing.JButton();
        CancelBtn = new javax.swing.JButton();
        InvoicesItemsScrollPane = new javax.swing.JScrollPane();
        InvoiceItemsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        LoadFileMenuItem = new javax.swing.JMenuItem();
        SaveFileMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        InvoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        InvoicesTableScrollPane.setViewportView(InvoicesTable);

        InvoicesTableLBl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        InvoicesTableLBl.setText("Invoices Table");

        createNewInvoiceBtn.setText("Create New Invoice");

        DeleteNewInvoiceBtn.setText("Delete Invoice");
        DeleteNewInvoiceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNewInvoiceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftSidePanelLayout = new javax.swing.GroupLayout(LeftSidePanel);
        LeftSidePanel.setLayout(LeftSidePanelLayout);
        LeftSidePanelLayout.setHorizontalGroup(
            LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftSidePanelLayout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(InvoicesTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LeftSidePanelLayout.createSequentialGroup()
                        .addComponent(InvoicesTableLBl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftSidePanelLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(createNewInvoiceBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteNewInvoiceBtn)
                .addGap(121, 121, 121))
        );
        LeftSidePanelLayout.setVerticalGroup(
            LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoicesTableLBl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InvoicesTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(LeftSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteNewInvoiceBtn)
                    .addComponent(createNewInvoiceBtn))
                .addGap(65, 65, 65))
        );

        getContentPane().add(LeftSidePanel);

        InvoiceNumberLBl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InvoiceNumberLBl.setText("Invoice No:");

        InvoiceDateLBl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        InvoiceDateLBl.setText("Invoice Date");

        CustomerNameLBl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CustomerNameLBl.setText("Customer Name");

        TotalInvoiceLBl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TotalInvoiceLBl.setText("Total Invoice");

        SaveBtn.setText("Save");

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        InvoicesItemsScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Invoices Items", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        InvoiceItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));

        javax.swing.GroupLayout RightSidePanelLayout = new javax.swing.GroupLayout(RightSidePanel);
        RightSidePanel.setLayout(RightSidePanelLayout);
        RightSidePanelLayout.setHorizontalGroup(
            RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightSidePanelLayout.createSequentialGroup()
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoiceNumberLBl)
                            .addComponent(InvoiceDateLBl)
                            .addComponent(CustomerNameLBl)
                            .addComponent(TotalInvoiceLBl)))
                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(SaveBtn)
                        .addGap(99, 99, 99)
                        .addComponent(CancelBtn))
                    .addGroup(RightSidePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InvoicesItemsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightSidePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InvoiceItemsTable, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RightSidePanelLayout.setVerticalGroup(
            RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightSidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoiceNumberLBl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(InvoiceDateLBl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CustomerNameLBl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(TotalInvoiceLBl)
                .addGap(18, 18, 18)
                .addComponent(InvoicesItemsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveBtn)
                    .addComponent(CancelBtn))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(RightSidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightSidePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(InvoiceItemsTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(RightSidePanel);

        FileMenu.setText("File");

        LoadFileMenuItem.setMnemonic('L');
        LoadFileMenuItem.setText("Load File");
        LoadFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(LoadFileMenuItem);

        SaveFileMenuItem.setText("Save File");
        FileMenu.add(SaveFileMenuItem);

        jMenuBar1.add(FileMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelBtnActionPerformed

    private void LoadFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadFileMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoadFileMenuItemActionPerformed

    private void DeleteNewInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNewInvoiceBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteNewInvoiceBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesignPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesignPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesignPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesignPreview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesignPreview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelBtn;
    private javax.swing.JLabel CustomerNameLBl;
    private javax.swing.JButton DeleteNewInvoiceBtn;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JLabel InvoiceDateLBl;
    private javax.swing.JTable InvoiceItemsTable;
    private javax.swing.JLabel InvoiceNumberLBl;
    private javax.swing.JScrollPane InvoicesItemsScrollPane;
    private javax.swing.JTable InvoicesTable;
    private javax.swing.JLabel InvoicesTableLBl;
    private javax.swing.JScrollPane InvoicesTableScrollPane;
    private javax.swing.JPanel LeftSidePanel;
    private javax.swing.JMenuItem LoadFileMenuItem;
    private javax.swing.JPanel RightSidePanel;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JMenuItem SaveFileMenuItem;
    private javax.swing.JLabel TotalInvoiceLBl;
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    private ActionHandler handler;
    private ArrayList<InvoiceHeader> loadedHeaderList;
    private InvoiceHeaderTableModel HeaderTableModel;    
    private InvoiceLineTableModel LineTableModel;
    private InvoiceHeaderData invoiceHeaderData;
    private InvoiceLineData invoiceLineData;

    public ActionHandler getHandler() {
        return handler;
    }

    public ArrayList<InvoiceHeader> getLoadedHeaderList() {
        return loadedHeaderList;
    }

    public void setLoadedHeaderList(ArrayList<InvoiceHeader> loadedHeaderList) {
        this.loadedHeaderList = loadedHeaderList;
        HeaderTableModel = new InvoiceHeaderTableModel(loadedHeaderList);
        this.InvoicesTable.setModel(HeaderTableModel);
        
         }

    public JTable getLineTable() {
        return InvoiceItemsTable;
    }

    public JTable getHeaderTable() {
        return InvoicesTable;
    }

    public JLabel getCustomerNameLBl() {
        return CustomerNameLBl;
    }

    public JLabel getInvoiceDateLBl() {
        return InvoiceDateLBl;
    }

    public JLabel getInvoiceNumberLBl() {
        return InvoiceNumberLBl;
    }

    public JLabel getTotalInvoiceLBl() {
        return TotalInvoiceLBl;
    }

    public void setInvoiceHeaderData(InvoiceHeaderData invoiceHeaderData) {
        this.invoiceHeaderData = invoiceHeaderData;
    }

    public InvoiceHeaderData getInvoiceHeaderData() {
        return  invoiceHeaderData;
    }

    public InvoiceLineData getInvoiceLineData() {
        return invoiceLineData;
    }

    public void setInvoiceLineData(InvoiceLineData invoiceLineData) {
        this.invoiceLineData = invoiceLineData;
    }
    

    public InvoiceHeaderTableModel getHeaderTableModel() {
        return HeaderTableModel;
    }

    public void setInvoiceLineTableModel(InvoiceLineTableModel LineTableModel) {
        this.LineTableModel = LineTableModel;
    }

    public InvoiceLineTableModel getInvoiceLineTableModel() {
        return LineTableModel;
    }
}

