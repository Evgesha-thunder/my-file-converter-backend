package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfToImageConverter extends PdfConverter {
    public PdfToImageConverter() {
        super("image");
    }

    @Override
    public File convert(File filePath) {
        return null;
    }
}
