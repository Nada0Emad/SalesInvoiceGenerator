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
public class InvoiceLineData  extends JFrame{
    private JLabel itemNameLBl;
    private JTextField itemNameTxt;    
    private JLabel itemCountLBl;
    private JTextField itemCountTxt;    
    private JLabel itemPriceLBl;
    private JTextField itemPriceTxt;
    private JButton saveBtn;
    private JButton cancelBtn;
    
    
    public InvoiceLineData(DesignPreview f){
        itemNameTxt = new JTextField(25);
        itemNameLBl = new JLabel("Item Name");
        
        itemCountTxt = new JTextField(25);
        itemCountLBl = new JLabel("Item Count");
        
        itemPriceTxt = new JTextField(25);
        itemPriceLBl = new JLabel("Item Price");
        
        saveBtn = new JButton("Save");
        cancelBtn = new JButton("Cancel");
        
        saveBtn.setActionCommand("ItemSaved");
        cancelBtn.setActionCommand("ItemCancelled");
        
        saveBtn.addActionListener(f.getHandler());
        cancelBtn.addActionListener(f.getHandler());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLBl);
        add(itemNameTxt);
        add(itemCountLBl);
        add(itemCountTxt);
        add(itemPriceLBl);
        add(itemPriceTxt);
        add(saveBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getItemNameTxt() {
        return itemNameTxt;
    }

    public JTextField getItemCountTxt() {
        return itemCountTxt;
    }

    public JTextField getItemPriceTxt() {
        return itemPriceTxt;
    }


    
}
