package com.afflorezc.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PDFBill {

    public static void main(String[] args) {

    }
    public void generatePDFBill(Bill bill){
        try{
            Document pdfDocument = new Document();

            PdfWriter.getInstance(pdfDocument , new FileOutputStream("factura.pdf"));

            pdfDocument.open();

            Image logo = Image.getInstance("cuento\\files\\img\\logo.jpg"); //creando la imagen del logo
            logo.scaleAbsolute(30,30);

            PdfPTable header = new PdfPTable(2); // creando el header

            PdfPCell imageCell = new PdfPCell(logo); // añadiendo la imagen a un celda
            imageCell.setBorder(0);

            PdfPTable headerInfo = new PdfPTable(2); // creando el contenedor del texto del header

            String dataBillString = "Fecha de facturación: " + LocalDateTime.now() + "\n Numero de factura" + bill.getBillNumber();
            String dataCompanyString = "Compañia: " + bill.getCompanyName()+ "\n" + "Email: " + bill.getCompanyAddress() + "\n" + "Nit: " +  bill.getCompanyNIT() + "\n" + "Teléfono: " + bill.getBillNumber();

            PdfPCell dataBillcell = new PdfPCell(new Phrase(dataBillString));
            PdfPCell dataCompany = new PdfPCell(new Phrase(dataCompanyString));

            headerInfo.addCell(dataCompany); // añadiendo el texto al contenedor del header
            headerInfo.addCell(dataBillcell);

            header.addCell(logo); //añadiendo los elementos al header
            header.addCell(headerInfo);

            PdfPTable billTable = createBillTable(bill.getItems()); //creando la tabla de factura

            Font totalFont = FontFactory.getFont(BaseFont.HELVETICA_BOLD);
            Paragraph totalTitle = new Paragraph("TOTAL", totalFont);

            PdfPTable totalTable = createTotalTable(bill.getBasePrice(), bill.getIvaValue(), bill.getPrice());

            pdfDocument.add(header);
            pdfDocument.add(billTable);
            pdfDocument.add(totalTitle);
            pdfDocument.add(totalTable);

            pdfDocument.close();


        }catch (DocumentException | java.io.FileNotFoundException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static PdfPTable createBillTable(ArrayList<Item> items){
        PdfPTable billTable = new PdfPTable(6);

        PdfPCell cellID = new PdfPCell(new Phrase("id"));
        PdfPCell nameItem = new PdfPCell(new Phrase("Nombre"));
        PdfPCell basePrice = new PdfPCell(new Phrase("Precio base"));
        PdfPCell iva = new PdfPCell(new Phrase("Iva"));
        PdfPCell price = new PdfPCell(new Phrase("Precio"));
        PdfPCell total = new PdfPCell(new Phrase("total"));

        cellID.setBorder(0);
        cellID.setBackgroundColor(new BaseColor(180,180,180));

        nameItem.setBorder(0);

        basePrice.setBorder(0);
        basePrice.setBackgroundColor(new BaseColor(180,180,180));

        iva.setBorder(0);

        price.setBorder(0);
        price.setBackgroundColor(new BaseColor(180,180,180));

        total.setBorder(0);

        billTable.addCell(cellID);
        billTable.addCell(nameItem);
        billTable.addCell(basePrice);
        billTable.addCell(iva);
        billTable.addCell(price);
        billTable.addCell(total);


        float totalAcumulated = 0f;

        for (int i = 0; i< items.size(); i++){
            totalAcumulated += items.get(i).getPrice();

            PdfPCell auxCellID = new PdfPCell(new Phrase(items.get(i).getId()));
            PdfPCell auxNameItem = new PdfPCell(new Phrase(items.get(i).getItemName()));
            PdfPCell auxBasePrice = new PdfPCell(new Phrase(""+items.get(i).getBasePrice()));
            PdfPCell auxIva = new PdfPCell(new Phrase(""+items.get(i).getIva()));
            PdfPCell auxPrice = new PdfPCell(new Phrase(""+items.get(i).getPrice()));
            PdfPCell auxTotal = new PdfPCell(new Phrase(""+totalAcumulated));

            auxCellID.setBorder(0);
            auxCellID.setBackgroundColor(new BaseColor(180,180,180));

            auxNameItem.setBorder(0);

            auxBasePrice.setBorder(0);
            auxBasePrice.setBackgroundColor(new BaseColor(180,180,180));

            auxIva.setBorder(0);

            auxPrice.setBorder(0);
            auxPrice.setBackgroundColor(new BaseColor(180,180,180));

            auxTotal.setBorder(0);

            billTable.addCell(auxCellID);
            billTable.addCell(auxNameItem);
            billTable.addCell(auxBasePrice);
            billTable.addCell(auxIva);
            billTable.addCell(auxPrice);
            billTable.addCell(auxTotal);

        }

        return billTable;
    }


    public PdfPTable createTotalTable(float baseTotal, float iva, float total){
        PdfPTable totalTable = new PdfPTable(6); // creando tabla del total

        PdfPCell voidCell = new PdfPCell();
        voidCell.setBorder(0);

        totalTable.addCell(voidCell);
        totalTable.addCell(voidCell);
        totalTable.addCell(voidCell);

        PdfPCell baseTotalCell = new PdfPCell(new Phrase("Precio base"));
        PdfPCell ivaCell = new PdfPCell(new Phrase("Iva"));
        PdfPCell totalCell = new PdfPCell(new Phrase("total"));

        baseTotalCell.setBorder(0);
        baseTotalCell.setBackgroundColor(new BaseColor(180,180,180));

        ivaCell.setBorder(0);

        totalCell.setBorder(0);
        totalCell.setBackgroundColor(new BaseColor(180,180,180));

        totalTable.addCell(baseTotalCell);
        totalTable.addCell(ivaCell);
        totalTable.addCell(totalCell);

        totalTable.addCell(voidCell);
        totalTable.addCell(voidCell);
        totalTable.addCell(voidCell);

        PdfPCell valueBaseTotalCell = new PdfPCell(new Phrase(""+baseTotal));
        PdfPCell valueIvaCell = new PdfPCell(new Phrase(""+iva));
        PdfPCell valueTotalCell = new PdfPCell(new Phrase(""+total));

        valueBaseTotalCell.setBorder(0);
        valueBaseTotalCell.setBackgroundColor(new BaseColor(180,180,180));

        valueIvaCell.setBorder(0);

        valueTotalCell.setBorder(0);
        valueTotalCell.setBackgroundColor(new BaseColor(180,180,180));

        totalTable.addCell(valueBaseTotalCell);
        totalTable.addCell(valueIvaCell);
        totalTable.addCell(valueTotalCell);

        return totalTable;
    }

}
