/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NADA
 */
public class InvoiceHeaderTableModel extends AbstractTableModel{
    
    private ArrayList<InvoiceHeader> InvoiceHeaderData;    
    private String[] columns = {"No", "Date", "Customer", "Total"};

    public InvoiceHeaderTableModel(ArrayList<InvoiceHeader> InvoiceHeaderData) {
        this.InvoiceHeaderData = InvoiceHeaderData;
    }
    
    public ArrayList<InvoiceHeader> getHeaderData() {
        return InvoiceHeaderData;
    }

    @Override
    public int getRowCount() {
        return InvoiceHeaderData.size();
        }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    public String getColumnName(int column) {
        return columns[column]; 
    }

    
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader header = InvoiceHeaderData.get(rowIndex);
        switch (columnIndex){
            case 0:
                return header.getInvoiceNumber();
            case 1:
                return header.getInvoiceDate();
            case 2:
                return header.getCustomerName();
            case 3:
                return header.getInvoiceTotal();
        }
        return null;
    }
    
    
}
