package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class TextToPdfConverter extends TextConverter {
    public TextToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(byte[] file) {
       return null;
    }
}
