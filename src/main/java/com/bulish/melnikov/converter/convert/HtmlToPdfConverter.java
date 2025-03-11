package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class HtmlToPdfConverter extends HtmlConverter {

    public HtmlToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(File file) {
        return null;
    }
}
