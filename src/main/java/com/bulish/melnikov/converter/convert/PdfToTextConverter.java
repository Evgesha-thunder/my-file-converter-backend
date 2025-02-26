package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PdfToTextConverter extends PdfConverter {
    public PdfToTextConverter() {
        super("txt");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
