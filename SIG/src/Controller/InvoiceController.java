/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.InvoiceHeader;
import View.InvoiceView;

/**
 *
 * @author NADA
 */
public class InvoiceController {
  private InvoiceHeader invoice;
  private InvoiceView view;

  public InvoiceController(InvoiceHeader invoice, InvoiceView view) {
    this.invoice = invoice;
    this.view = view;
  }

  public void updateView() {
    view.printInvoice(invoice);
  }
}
