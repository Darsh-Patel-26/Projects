package a;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;

class ID {

    Document doc = null;
    String path1 = "C:\\Users\\DARSH PATEL\\Desktop\\";
    String path3 = ".pdf";

    ID(String name, int roll, int room, String course) {

        String path = path1 + name + path3;

        try {
            doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();

            Image img = Image.getInstance("E:\\Submit\\Project\\src\\a\\sign.png");

            String head = "                     Samras Boys Hostel Vadodara\n\n\n";

            String template = "\t     - Name : " + name + "\n\n\t     - Roll No: " + roll + "\n\n\t     - Romm NO : " + room + "\n\n\t     - Course : " + course;

            Paragraph par = new Paragraph(template);

            doc.add(new Paragraph(head, FontFactory.getFont(FontFactory.TIMES_ROMAN, 24, Font.BOLD)));
            doc.add(par);
            doc.add(new Paragraph("\nSign Of Authority"));
            doc.add(img);
        } catch (Exception e1) {
        } finally {
            try {
                doc.close();
            } catch (Exception e2) {
            }
        }
    }

}

class IDWorker {

    Document doc = null;
    String path1 = "C:\\Users\\DARSH PATEL\\Desktops";
    String path3 = ".pdf";

    IDWorker(String name, int id, String work) {
        String path = path1 + name + path3;

        try {
            doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();

            Image img = Image.getInstance("E:\\Submit\\Project\\src\\a\\sign.png");

            String head = "                     Samras Boys Hostel Vadodara\n\n\n";

            String template = "\t     - Name : " + name + "\n\n\t     - Employee ID : " + id + "\n\n\t     - Work Type : " + work;

            Paragraph par = new Paragraph(template);

            doc.add(new Paragraph(head, FontFactory.getFont(FontFactory.TIMES_ROMAN, 24, Font.BOLD)));
            doc.add(par);
            doc.add(new Paragraph("\nSign Of Authority"));
            doc.add(img);
        } catch (Exception e1) {
        } finally {
            try {
                doc.close();
            } catch (Exception e2) {
            }
        }

    }
}
