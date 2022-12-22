/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author NADA
 */
public class InvoiceLine {
    private InvoiceHeader InvoiceHeader;
    private int InvoiceNumber;
    private String ItemName;
    private double ItemPrice;
    private int  ItemCount;

    public InvoiceLine(InvoiceHeader header, String string, double price, int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public InvoiceHeader getInvoiceHeader() {
        return InvoiceHeader;
    }

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }
   
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double ItemPrice) {
        this.ItemPrice = ItemPrice;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int ItemCount) {
        this.ItemCount = ItemCount;
    }

    public double getItemTotal() {
        return getItemCount()*getItemPrice();
    }

    public String getLineAsCSV() {
        return "" + getInvoiceHeader().getInvoiceNumber()+ "," + getItemName() + "," + getItemPrice()+ "," + getItemCount();
    }
    @Override
    public String toString() {
        return "InvoiceDetail{" + "Item Name=" + ItemName + ", Item Price=" + ItemPrice + ", count=" + ItemCount + ", Item Total=" + getItemTotal() + '}';
    }
    
    
    
    
}
    
