package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PdfToImageConverter extends PdfConverter {
    public PdfToImageConverter() {
        super("image");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
