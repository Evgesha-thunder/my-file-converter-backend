package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class HtmlToPdfConverter extends HtmlConverter {

    public HtmlToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(String filePath) {
        return new byte[0];
    }
}
