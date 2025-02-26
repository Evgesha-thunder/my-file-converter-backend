package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PdfToDocxConverter extends PdfConverter {
    public PdfToDocxConverter() {
        super("docx");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
