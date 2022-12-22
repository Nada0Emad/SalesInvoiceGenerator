/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NADA
 */
public class InvoiceHeader {
     private int InvoiceNumber;
     private Date InvoiceDate;
     private String CustomerName;
     ArrayList<InvoiceLine> InvoiceLine;
     
     public InvoiceHeader(int InvoiceNumber, Date InvoiceDate, String CustomerName) {
        this.InvoiceNumber = InvoiceNumber;
        this.InvoiceDate = InvoiceDate;
        this.CustomerName = CustomerName;
    }

    public ArrayList<InvoiceLine> getInvoieLines() {
        if (InvoiceLine == null)
            InvoiceLine = new ArrayList<>();
        return InvoiceLine;
    }
     

    public int getInvoiceNumber() {
        return InvoiceNumber;
    }

    public void setInvoiceNumber(int InvoiceNumber) {
        this.InvoiceNumber = InvoiceNumber;
    }

    public Date getInvoiceDate() {
        return InvoiceDate;
    }

    public void setInvoiceDate(Date InvoiceDate) {
        this.InvoiceDate = InvoiceDate;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public ArrayList<InvoiceLine> getInvoiceLine() {
        return InvoiceLine;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> InvoiceLine) {
        this.InvoiceLine = InvoiceLine;
    }
    
    public double getInvoiceTotal() {
        double total = 0;
        for (InvoiceLine line : getInvoiceLine())
            total +=line.getItemTotal();
        return total;
    }
    
    public void getInvoiceLine(InvoiceLine line) {
        getInvoiceLine().add(line);
    }
    
    public String getHeaderAsCSV() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvoiceNumber() + "," + dateFormat.format(getInvoiceDate()) + "," + getCustomerName();
    }

    @Override
    public String toString() {
        String str= "InvoiceHeader{" + "invoiceNo=" + InvoiceNumber + ", invoiceDate=" + InvoiceDate + ", customerName=" + CustomerName + '}';
        for (InvoiceLine line : getInvoiceLine()) {
            str += "\n\t" + line;
        }
        return str;
}
     
}
