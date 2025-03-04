package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class PdfToHtmlConverter extends PdfConverter {
    public PdfToHtmlConverter() {
        super("html");
    }

    @Override
    public File convert(File file) {
        return null;
    }
}
