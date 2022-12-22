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
public class InvoiceLineTableModel extends AbstractTableModel{
    private ArrayList<InvoiceLine> InvoiceLineData;
    private String[] columns = {"No.", "Item Name", "Item price", "Count", "Item Total"};

    public InvoiceLineTableModel(ArrayList<InvoiceLine> InvoiceLine) {
        this.InvoiceLineData = InvoiceLine;
    }
    
    public ArrayList<InvoiceLine> getInvoiceLine() {
        return InvoiceLineData;
    }

    @Override
    public int getRowCount() {
        return InvoiceLineData.size();
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
        InvoiceLine data = InvoiceLineData.get(rowIndex);
        switch (columnIndex){
            case 0:
                return data.getItemName();
            case 1:
                return data.getItemPrice();
            case 2:
                return data.getItemCount();
            case 3:
                return data.getItemTotal();
        }
        return null;
    }
    
    
}
