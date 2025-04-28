package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class PdfToTextConverter extends PdfConverter {
    public PdfToTextConverter() {
        super("txt");
    }

    @Override
    public byte[] convert(byte[] file) {
        return null;
    }
}
