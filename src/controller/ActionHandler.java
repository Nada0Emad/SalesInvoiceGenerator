/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.InvoiceHeader;
import model.InvoiceLine;
import model.InvoiceLineTableModel;
import view.DesignPreview;
import view.InvoiceHeaderData;
import view.InvoiceLineData;

/**
 *
 * @author NADA
 */
public class ActionHandler implements ListSelectionListener, ActionListener {

    DesignPreview frame = new DesignPreview();
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

    public ActionHandler(DesignPreview frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int rowSelected = frame.getHeaderTable().getSelectedRow();

        if (rowSelected >= 0) {
            InvoiceHeader header = frame.getHeaderTableModel().getHeaderData().get(rowSelected);
            //populate labels
            frame.getInvoiceNumberLBl().setText("" + header.getInvoiceNumber());
            frame.getCustomerNameLBl().setText("" + header.getCustomerName());
            frame.getInvoiceDateLBl().setText(df.format(header.getInvoiceDate()));
            frame.getTotalInvoiceLBl().setText("" + header.getInvoiceTotal());

            ArrayList<InvoiceLine> invoiceLine = header.getInvoieLines();
            frame.setInvoiceLineTableModel(new InvoiceLineTableModel(invoiceLine));
            frame.getLineTable().setModel(frame.getInvoiceLineTableModel());
            frame.getInvoiceLineTableModel().fireTableDataChanged();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
             case "createNewInvoice":
                createNewInvoice();
                break;
            case "addInvoiceApproved":
                addInvoiceApproved();
                break;
            case "InvoiceCancelled":
                InvoiceCancelled();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "Add Item":
                addItem();
                break;
            case "addItemApproved":
                addItemApproved();
                break;
            case "addItemCancelled":
                addItemCancelled();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "Load file":
                loadFile();
                break;
            case "Save file":
                saveFile();
                break;

    }
    }

    private void loadFile() {
        try {
            JFileChooser filechooser = new JFileChooser();
            int choice = filechooser.showOpenDialog(frame);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File headerFile = filechooser.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerFileLines = Files.lines(headerPath).collect(Collectors.toList());
                ArrayList<InvoiceHeader> loadedHeaderList = new ArrayList();
                for (String line : headerFileLines) {
                    InvoiceHeader HeaderObj;
                    String[] splitedHeader = line.split(",");
                    if (splitedHeader.length != 0) {

                        int invoiceNumber = Integer.parseInt(splitedHeader[0]);
                        Date invoiceDate = new Date();
                        invoiceDate = df.parse(splitedHeader[1]);
                        HeaderObj = new InvoiceHeader(invoiceNumber, invoiceDate, splitedHeader[2]);
                        loadedHeaderList.add(HeaderObj);

                    }
                }

                choice = filechooser.showOpenDialog(frame);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File detailFile = filechooser.getSelectedFile();
                    Path detailPath = Paths.get(detailFile.getAbsolutePath());
                    List<String> detailFileLines = Files.lines(detailPath).collect(Collectors.toList());
                    for (String line : detailFileLines) {
                        InvoiceLine lineObj;
                        String[] splitedDetail = line.split(",");
                        if (splitedDetail.length != 0) {

                            int invoiceNo = Integer.parseInt(splitedDetail[0]);
                            InvoiceHeader header = getInvoiceHeaderByNum(loadedHeaderList, invoiceNo);
                            double price = Double.parseDouble(splitedDetail[2]);
                            int count = Integer.parseInt(splitedDetail[3]);

                            lineObj = new InvoiceLine(header, splitedDetail[1], price, count);
                            header.getInvoiceLine().add(lineObj);
                        }
                    }
                    frame.setLoadedHeaderList(loadedHeaderList);
                    printInvoices();
                }

            }
            //Error & Exception handling
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Wrong Date Format Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "File Not Found Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "File Read Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        String headers = "";
        String lines = "";
        try {
            for (InvoiceHeader header : frame.getLoadedHeaderList()) {
                headers += header.getHeaderAsCSV() + "\n";
                for (InvoiceLine line : header.getInvoiceLine()) {
                    lines += line.getLineAsCSV() + "\n";
                }
            }
            //Save InvoiceHeaders
            JOptionPane.showMessageDialog(frame, "Select file to save InvoiceHeader data!", "Save file", JOptionPane.WARNING_MESSAGE);
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File headerFile = fileChooser.getSelectedFile();
                try {
                    FileWriter headerFW = new FileWriter(headerFile);
                    headerFW.write(headers);
                    headerFW.flush();
                    headerFW.close();
                    //Save InvoiceDetails
                    JOptionPane.showMessageDialog(frame, "Select file to save InvoiceDetails data!", "Save file", JOptionPane.WARNING_MESSAGE);

                    if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                        File detailsFile = fileChooser.getSelectedFile();
                        FileWriter detailFW = new FileWriter(detailsFile);
                        detailFW.write(lines);
                        detailFW.flush();
                        detailFW.close();
                    }
                    JOptionPane.showMessageDialog(frame, "Files are saved successfully!");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(frame, "Invoices are empty cannot be saved. Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private InvoiceHeader getInvoiceHeaderByNum(ArrayList<InvoiceHeader> loadedHeaderList, int invoiceNumber) {//for searching header by invNo
        for (InvoiceHeader header : loadedHeaderList) {
            if (invoiceNumber == header.getInvoiceNumber()) {
                return header;
            }
        }
        return null;
    }

    private int getNewInvoiceNumber() {
        int max = 0;
        for (InvoiceHeader header : frame.getLoadedHeaderList()) {
            if (header.getInvoiceNumber() > max) {
                max = header.getInvoiceNumber();
            }
        }
        return max + 1;
    }

    private void printInvoices() {
        for (InvoiceHeader header : frame.getLoadedHeaderList()) {
            System.out.println(header);
        }
    }

    private void createNewInvoice() {
        frame.setInvoiceHeaderData(new InvoiceHeaderData(frame));
        frame.getInvoiceHeaderData().setVisible(true);
    }

    private void addInvoiceApproved() {
        String customerName = frame.getInvoiceHeaderData().getCustomerNameTxt().getText();
        String invoiceDate = frame.getInvoiceHeaderData().getInvoiceDateTxt().getText();
        hideInvoiceHeaderData();

        try {
            Date invoiceDate1 = df.parse(invoiceDate);
            int invoiceNumber = getNewInvoiceNumber();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invoiceNumber, invoiceDate1, customerName);
            frame.getLoadedHeaderList().add(invoiceHeader);
            frame.getHeaderTableModel().fireTableDataChanged();
            printInvoices();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date Format, use this format (dd-MM-yyyy) ", "Error:" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);

        }
    }

    private void InvoiceCancelled() {
        hideInvoiceHeaderData();

    }

    private void hideInvoiceHeaderData() {
        frame.getInvoiceHeaderData().setVisible(false);
        frame.getInvoiceHeaderData().dispose();
        frame.setInvoiceHeaderData(null);

    }

    private void deleteInvoice() {

        int rowSelected = frame.getHeaderTable().getSelectedRow();
        if (rowSelected >= 0) {
            frame.getHeaderTableModel().getHeaderData().remove(rowSelected);
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.setInvoiceLineTableModel(new InvoiceLineTableModel(new ArrayList<>()));
            frame.getLineTable().setModel(frame.getInvoiceLineTableModel());
            frame.getInvoiceLineTableModel().fireTableDataChanged();
            frame.getCustomerNameLBl().setText("");
            frame.getInvoiceDateLBl().setText("");
            frame.getInvoiceNumberLBl().setText("");
            frame.getTotalInvoiceLBl().setText("");
            printInvoices();

            JOptionPane.showMessageDialog(null, "Done: Invoice is deleted successfully!");
        } else {
            JOptionPane.showMessageDialog(frame, "Error: Please select the invoice before deletion", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void addItem() {
        frame.setInvoiceLineData(new InvoiceLineData(frame));
        frame.getInvoiceLineData().setVisible(true);
    }

    private void addItemApproved() {
        try {
            String itemName = frame.getInvoiceLineData().getItemNameTxt().getText();
            String itemPriceStr = frame.getInvoiceLineData().getItemPriceTxt().getText();
            String itemCountStr = frame.getInvoiceLineData().getItemCountTxt().getText();
            hideInvoiceLineData();

            double itemPrice = Double.parseDouble(itemPriceStr);
            int itemCount = Integer.parseInt(itemCountStr);
            int rowSelected = frame.getHeaderTable().getSelectedRow();
            if (rowSelected >= 0) {
                InvoiceHeader header = frame.getHeaderTableModel().getHeaderData().get(rowSelected);

                header.getInvoiceLine(new InvoiceLine(header, itemName, itemPrice, itemCount));
          //      frame.getInvoiceLineData().fireTableDataChanged();
                frame.getHeaderTableModel().fireTableDataChanged();
                frame.getTotalInvoiceLBl().setText("" + header.getInvoiceTotal());

                printInvoices();
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Please select the invoice before adding a new item", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Error: Number format, Format:(Name: String, Qty:Integer , Price:Double)\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addItemCancelled() {
        hideInvoiceLineData();
    }

    private void hideInvoiceLineData() {
        frame.getInvoiceLineData().setVisible(false);
        frame.getInvoiceLineData().dispose();
        frame.setInvoiceLineData(null);

    }

    private void deleteItem() {
        int rowSelected = frame.getInvoiceLineTableModel().getSelectedRow();
        if (rowSelected >= 0) {
            InvoiceLine line = frame.getInvoiceLineTableModel().getInvoiceLine().get(rowSelected);
            frame.getInvoiceLineTableModel().getInvoiceLine().remove(rowSelected);
            frame.getInvoiceLineTableModel().fireTableDataChanged();
            frame.getHeaderTableModel().fireTableDataChanged();
            frame.getTotalInvoiceLBl().setText("" + line.getInvoiceHeader().getInvoiceTotal());
            JOptionPane.showMessageDialog(null, "Done: Item is deleted successfully!");
            printInvoices();
        } else {
            JOptionPane.showMessageDialog(frame, "Error: Please select the item before deletion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
