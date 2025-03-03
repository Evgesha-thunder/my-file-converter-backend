package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class PdfToDocxConverter extends PdfConverter {
    public PdfToDocxConverter() {
        super("docx");
    }

    @Override
    public byte[] convert(String filePath) {
        return new byte[0];
    }
}
