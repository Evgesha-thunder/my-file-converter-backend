package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PdfToHtmlConverter extends PdfConverter {
    public PdfToHtmlConverter() {
        super("html");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
