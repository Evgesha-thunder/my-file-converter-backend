package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class PdfToHtmlConverter extends PdfConverter {
    public PdfToHtmlConverter() {
        super("html");
    }

    @Override
    public byte[] convert(String filePath) {
        return new byte[0];
    }
}
