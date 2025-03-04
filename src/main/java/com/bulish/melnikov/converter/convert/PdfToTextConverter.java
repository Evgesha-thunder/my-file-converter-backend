package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfToTextConverter extends PdfConverter {
    public PdfToTextConverter() {
        super("txt");
    }

    @Override
    public File convert(File file) {
        return null;
    }
}
