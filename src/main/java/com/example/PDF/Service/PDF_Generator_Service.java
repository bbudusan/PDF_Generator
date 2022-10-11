package com.example.PDF.Service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.swing.text.StyleConstants.*;

@Service
public class PDF_Generator_Service {
    public void Export(HttpServletResponse response) throws IOException {
        Document document=new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());

        document.open();

        Font fontTitle= FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph=new Paragraph("COLEGIUL MEDICILOR MARAMURES",fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph=FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontParagraph.setSize(10);

        Paragraph paragraph2=new Paragraph("This is a paragraph.",fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph);
        document.add(paragraph2);
        document.add(new Paragraph(" "));

        //Add image
        document.add(Image.getInstance("poza.jpg"));


        //Add backgound
        document.add(new Paragraph(" "));


        //Add Table
        PdfPTable table = new PdfPTable(3);
        PdfPCell c1 = new PdfPCell(new Phrase("Heading 1"));
        table.addCell(c1);

        c1=new PdfPCell(new Phrase("Heading 2"));
        table.addCell(c1);

        c1=new PdfPCell(new Phrase("Heading 3"));
        table.addCell(c1);
        table.setHeaderRows(1);

        table.addCell("1.1");
        table.addCell("1.2");
        table.addCell("1.3");
        table.addCell("2.1");
        table.addCell("2.2");
        table.addCell("2.3");


        document.add(table);
        document.close();
    }
}
