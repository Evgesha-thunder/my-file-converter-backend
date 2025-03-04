package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DocxToPdfConverter extends DocxConverter {

    public DocxToPdfConverter() {
        super("pdf");
    }

    @Override
    public File convert(File file) {
        return null;
    }
}
