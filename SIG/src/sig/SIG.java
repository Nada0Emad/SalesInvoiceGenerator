/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sig;

import Model.InvoiceHeader;
import Model.InvoiceLine;
import java.util.Date;


public class SIG {

    
    public static void main(String[] args) {
        // Create an invoice header
  InvoiceHeader invoiceHeader = new InvoiceHeader(1001, new Date(), "John Doe");

  // Create invoice lines
  InvoiceLine line1 = new InvoiceLine(1001, "Product 1", 10.00, 2);
  InvoiceLine line2 = new InvoiceLine(1001, "Product 2", 5.00, 3);

  // Print invoice details
  System.out.println("Invoice Number: " + invoiceHeader.getInvoiceNum());
  System.out.println("Invoice Date: " + invoiceHeader.getInvoiceDate());
  System.out.println("Customer Name: " + invoiceHeader.getCustomerName());
  System.out.println("Invoice Lines:");
  System.out.println(line1.getItemName() + " - " + line1.getItemPrice() + " x " + line1.getCount());
  System.out.println(line2.getItemName() + " - " + line2.getItemPrice() + " x " + line2.getCount());
}
    }
    

