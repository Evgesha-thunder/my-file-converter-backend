package com.bulish.melnikov.converter.convert;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Component
public class PdfToDocxConverter extends PdfConverter {
    public PdfToDocxConverter() {
        super("docx");
    }

    @Override
    public byte[] convert(File file) {
        byte [] converterFile = null;

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             PDDocument document = PDDocument.load(file);
             XWPFDocument docx = new XWPFDocument()) {

            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(document);

            XWPFParagraph paragraph = docx.createParagraph();
            paragraph.createRun().setText(text);

            docx.write(out);
            converterFile = out.toByteArray();

            } catch (IOException e) {
            e.printStackTrace();
        }

        return converterFile;
    }
}
