package com.afflorezc.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import javax.swing.JTable;

public class PDFManagement {

    public static void createPDF(String textTitle, String body, Image logo){
        
        try{
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("post.pdf"));
            doc.open();
        
            Font titleFont = FontFactory.getFont(BaseFont.TIMES_BOLD, 21, BaseColor.BLACK);
            Font bodyFont = FontFactory.getFont(BaseFont.HELVETICA, 12, BaseColor.BLACK);
        
            Paragraph title = new Paragraph(textTitle, titleFont);
            Paragraph textBody = new Paragraph(body, bodyFont);
        
            doc.add(title);
            doc.add(textBody);
            doc.add(logo);
            doc.close();
        
        }catch(DocumentException | java.io.FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    public static void crearTabla(JTable swTable){
        try{
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("tabla.pdf"));
            doc.open();
            PdfPTable tabla = new PdfPTable(swTable.getColumnCount());
            for(int i = 0; i < swTable.getColumnCount(); i++)
            {
                tabla.addCell(swTable.getColumnName(i));
            }
            for(int x = 0; x < swTable.getRowCount(); x++)
            {
                for(int y = 0; y < swTable.getColumnCount(); y++)
                {
                    String valor = (swTable.getValueAt(x, y) != null) ? swTable.getValueAt(x, y).toString() : "";
                    tabla.addCell(valor);
                }
            }
            doc.add(tabla);
            doc.close();

        
        }catch(DocumentException | java.io.FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
