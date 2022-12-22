/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileOperations{

    public static void readFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public static void readFile(JFileChooser myFileChooser, JFrame frame) {
        int result = myFileChooser.showOpenDialog(frame);
        String filePath = "";
        if (result == JFileChooser.APPROVE_OPTION) {
            Path path = myFileChooser.getSelectedFile().toPath();
            System.out.println(path.toString().substring(0, path.toString().lastIndexOf("\\")));
            if (path.toString().endsWith("csv")) {
                filePath = path.toString();
            } else {
                JOptionPane.showMessageDialog(frame, "Error File Extension Selection", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void writeFile(String path, ArrayList<InvoiceHeader> invoiceHeaders) {

        String headerLinePath = path.substring(0, path.lastIndexOf("\\") + 1) + "resources\\InvoiceLine.csv";
        ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();
        try (PrintWriter writer = new PrintWriter(path)) {

            StringBuilder sb = new StringBuilder();
            for(InvoiceHeader invoiceH: invoiceHeaders){
                sb.append(invoiceH.getInvoiceNumber());
                sb.append(",");
                sb.append(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
                sb.append(",");
                sb.append(invoiceH.getCustomerName());
                sb.append("\n");
                invoiceLines.addAll(invoiceH.getInvoiceLine());
            }
            
            saveToLineInv(headerLinePath,invoiceLines);
            writer.write(sb.toString());
          

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

   
    private void saveToLineInv(String headerLinePath,ArrayList<InvoiceLine> invoiceLines) {
          
        try (PrintWriter writer = new PrintWriter(headerLinePath)) {

            StringBuilder sb = new StringBuilder();
            for(InvoiceLine invoiceL: invoiceLines){
                sb.append(invoiceL.getInvoiceNumber());
                sb.append(",");
                sb.append(invoiceL.getItemName());
                sb.append(",");
                sb.append(invoiceL.getItemPrice());
                sb.append(",");
                sb.append(invoiceL.getItemCount());
                sb.append("\n");
            }
             writer.write(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
