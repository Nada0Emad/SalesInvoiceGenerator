/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author NADA
 */
public class InvoiceHeaderData extends JFrame {
    private JTextField customerNameTxt;
    private JTextField invoiceDateTxt;
    private JLabel customerNameLbl;
    private JLabel dateLbl;
    private JButton createInvoiceBtn;
    private JButton deleteBtn;

    public InvoiceHeaderData(DesignPreview f) {

        customerNameLbl = new JLabel("Customer Name:");
        customerNameTxt = new JTextField(25);
        dateLbl = new JLabel("Invoice Date dd-MM-yyyy:");
        invoiceDateTxt = new JTextField(25);
        createInvoiceBtn = new JButton("Create New Invoice");
        deleteBtn = new JButton("Delete Invoice");
 
        createInvoiceBtn.setActionCommand("createNewInvoice");
        deleteBtn.setActionCommand("InvoiceDeleted");
        createInvoiceBtn.addActionListener(f.getHandler());
        deleteBtn.addActionListener(f.getHandler());
        setLayout(new GridLayout(4, 2));
        
        add(dateLbl);
        add(invoiceDateTxt);
        add(customerNameLbl);
        add(customerNameTxt);
        add(createInvoiceBtn);
        add(deleteBtn);
        pack();
        
    }

  

    public JTextField getCustomerNameTxt() {
        return customerNameTxt;
    }

    public JTextField getInvoiceDateTxt() {
        return invoiceDateTxt;
    }

    
    
}
