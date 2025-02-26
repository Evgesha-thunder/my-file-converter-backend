package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DocxToPdfConverter extends DocxConverter {

    public DocxToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
