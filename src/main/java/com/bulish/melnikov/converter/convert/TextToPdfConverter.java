package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TextToPdfConverter extends TextConverter {
    public TextToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(File file) {
       return null;
    }
}
