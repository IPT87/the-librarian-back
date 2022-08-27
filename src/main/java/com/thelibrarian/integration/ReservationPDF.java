package com.thelibrarian.integration;

import com.lowagie.text.DocumentException;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.thelibrarian.data.entity.ReservationEntity;
import com.lowagie.text.Font;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


public class ReservationPDF {


    private List<ReservationEntity> reserves;


    public ReservationPDF(List<ReservationEntity> reserves) {
        this.reserves = reserves;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);


        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);


        cell.setPhrase(new Phrase("User Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Title", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Reserved", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (ReservationEntity reserve : reserves) {

            table.addCell(String.valueOf(reserve.getId()));
            table.addCell(String.valueOf(reserve.getUsuario().getNombre()));
            table.addCell(reserve.getUsuario().getCorreo());
            table.addCell(String.valueOf(reserve.getBook().getTitle()));
            table.addCell(String.valueOf(reserve.getIs_reservado()));


        }
    }


    public void exportUser(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Reserves", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 1.5f, 1.5f, 1.5f,1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }

}
