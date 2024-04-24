package com.afflorezc.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

public class CrearFactura {

    public static void main(String[] args) {
        crearFactura();
    }
    static void crearFactura(){
        try {
            Document pdfDocument = new Document();

            PdfWriter.getInstance(pdfDocument , new FileOutputStream("factura.pdf"));

            pdfDocument.open();

            Image logo = Image.getInstance("files\\img\\logo3.jpg");
            logo.scaleAbsolute(50,50);

            Font bodyFont = FontFactory.getFont(BaseFont.HELVETICA, 12, BaseColor.BLACK);

            String texto = "header de la factura \n hola \n hola";
            Paragraph header = new Paragraph(texto, bodyFont);

            PdfPTable bill = new PdfPTable(4);

            bill.addCell("ID");
            bill.addCell("Item");
            bill.addCell("Fecha");
            bill.addCell("Precio");

            pdfDocument.add(logo);
            pdfDocument.add(header);
            pdfDocument.add(bill);

            pdfDocument.close();



        }catch (DocumentException | java.io.FileNotFoundException e){
            e.printStackTrace();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
