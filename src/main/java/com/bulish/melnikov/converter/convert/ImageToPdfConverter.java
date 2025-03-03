package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;

@Component
public class ImageToPdfConverter extends ImageConverter {
    public ImageToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(String filePath) {
        return new byte[0];
    }
}
