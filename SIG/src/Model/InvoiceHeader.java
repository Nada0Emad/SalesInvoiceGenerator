/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.Date;


public class InvoiceHeader {
  // Fields
  private int invoiceNum;
  private Date invoiceDate;
  private String customerName;
  private ArrayList<InvoiceLine> invoiceLines;

  // Constructor
  public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName, ArrayList<InvoiceLine> invoiceLines) {
    this.invoiceNum = invoiceNum;
    this.invoiceDate = invoiceDate;
    this.customerName = customerName;
    this.invoiceLines = invoiceLines;
  }
   public InvoiceHeader(int invoiceNum, Date invoiceDate, String customerName) {
    this.invoiceNum = invoiceNum;
    this.invoiceDate = invoiceDate;
    this.customerName = customerName;
  }

  

  // Getters and setters
  public int getInvoiceNum() {
    return invoiceNum;
  }

  public void setInvoiceNum(int invoiceNum) {
    this.invoiceNum = invoiceNum;
  }

  public Date getInvoiceDate() {
    return invoiceDate;
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = invoiceDate;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public ArrayList<InvoiceLine> getInvoiceLines() {
    return invoiceLines;
  }

  public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
    this.invoiceLines = invoiceLines;
  }

}

