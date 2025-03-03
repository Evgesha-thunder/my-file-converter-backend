package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class PdfToImageConverter extends PdfConverter {
    public PdfToImageConverter() {
        super("image");
    }

    @Override
    public byte[] convert(String filePath) {
        return new byte[0];
    }
}
