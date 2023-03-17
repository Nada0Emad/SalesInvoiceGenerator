/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.InvoiceHeader;
import Model.InvoiceLine;

/**
 *
 * @author NADA
 */
public class InvoiceView {
  public void printInvoice(InvoiceHeader invoice) {
    // Print invoice details
    System.out.println("Invoice Number: " + invoice.getInvoiceNum());
    System.out.println("Invoice Date: " + invoice.getInvoiceDate());
    System.out.println("Customer Name: " + invoice.getCustomerName());
    System.out.println("Invoice Lines:");
    for (InvoiceLine line : invoice.getInvoiceLines()) {
      System.out.println(line.getItemName() + " - " + line.getItemPrice() + " x " + line.getCount());
    }
  }

  
}