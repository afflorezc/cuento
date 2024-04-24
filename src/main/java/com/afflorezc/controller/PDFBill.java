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
        Bill bill = new Bill("motos", "34636357", "empresaDeMotos@gmail.com","355 68332224");
        Item item1 = new Item("1","moto1",33333);
        Item item2 = new Item("2","moto2",122343);
        Item item3 = new Item("3","moto3",66789);
        Item item4 = new Item("4","moto4",234865);
        Item item5 = new Item("5","moto5",99876);
        Item item6 = new Item("6","moto6",397486);
        Item item7 = new Item("7","moto7",9557657);

        bill.addItem(item1);
        bill.addItem(item2);
        bill.addItem(item3);
        bill.addItem(item4);
        bill.addItem(item5);
        bill.addItem(item6);
        bill.addItem(item7);

        bill.calculateIVA();
        bill.calculateBasePrice();

        generatePDFBill(bill);

    }
    public static void generatePDFBill(Bill bill){
        try{
            Document pdfDocument = new Document();

            PdfWriter.getInstance(pdfDocument , new FileOutputStream("cuento\\factura.pdf"));

            pdfDocument.open();

            Image logo = Image.getInstance("cuento\\files\\img\\logo4.jpg"); //creando la imagen del logo
            logo.scaleAbsolute(50,50);

            PdfPTable header = new PdfPTable(2); // creando el header

            String dataBillString = "Fecha de facturación: " + LocalDateTime.now() + "\n Numero de factura" + bill.getBillNumber();
            String dataCompanyString = "Compañia: " + bill.getCompanyName()+ "\n" + "Email: " + bill.getCompanyAddress() + "\n" + "Nit: " +  bill.getCompanyNIT() + "\n" + "Teléfono: " + bill.getBillNumber();

            PdfPCell dataCompany = new PdfPCell(new Phrase(dataCompanyString));
            PdfPCell dataBillcell = new PdfPCell(new Phrase(dataBillString));

            dataBillcell.setBorder(0);
            dataCompany.setBorder(0);

            header.addCell(dataCompany);
            header.addCell(dataBillcell); //añadiendo los elementos al header


            PdfPTable billTable = createBillTable(bill.getItems()); //creando la tabla de factura

            Font totalFont = FontFactory.getFont(BaseFont.HELVETICA_BOLD);
            Paragraph totalTitle = new Paragraph("TOTAL", totalFont);
            totalTitle.setSpacingAfter(5);
            totalTitle.setAlignment(1);

            PdfPTable totalTable = createTotalTable(bill.getBasePrice(), bill.getIvaValue(), bill.getBasePrice()+bill.getIvaValue());

            header.setWidthPercentage(100f);
            billTable.setWidthPercentage(100f);
            totalTable.setWidthPercentage(100f);

            pdfDocument.add(logo);
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


        Float totalAcumulated = 0f;

        for (int i = 0; i < items.size(); i++){
            totalAcumulated += items.get(i).getIva() + items.get(i).getBasePrice();

            PdfPCell auxCellID = new PdfPCell(new Phrase(items.get(i).getId()));
            PdfPCell auxNameItem = new PdfPCell(new Phrase(items.get(i).getItemName()));
            PdfPCell auxBasePrice = new PdfPCell(new Phrase(""+items.get(i).getBasePrice()));
            PdfPCell auxIva = new PdfPCell(new Phrase(""+items.get(i).getIva()));
            PdfPCell auxPrice = new PdfPCell(new Phrase(""+(items.get(i).getIva() + items.get(i).getBasePrice())));
            PdfPCell auxTotal = new PdfPCell(new Phrase(""+totalAcumulated.toString()));

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


    public static PdfPTable createTotalTable(float baseTotal, float iva, float total){
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
