package com.bulish.melnikov.converter.convert;

import com.bulish.melnikov.converter.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@Slf4j
public class PdfToHtmlConverter extends PdfConverter {

    private final FileService fileService;
    public PdfToHtmlConverter(FileService fileService) {
        super("html");
        this.fileService = fileService;
    }

    @Override
    public byte[] convert(byte[] file) {

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(baos, "utf-8");
            PDDocument pdf = PDDocument.load(file)) {

            new PDFDomTree().writeText(pdf, writer);

            return baos.toByteArray();

        } catch (Exception e) {
            log.error("Error converting file", e);
            throw new RuntimeException("Error converting file", e);
        }
    }
}
