package com.bulish.melnikov.converter.convert;

import org.springframework.web.multipart.MultipartFile;

public class PdfToImageConverter implements Converter {
    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
