package com.bulish.melnikov.converter.convert;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HtmlToPdfConverter extends HtmlConverter {

    public HtmlToPdfConverter() {
        super("pdf");
    }

    @Override
    public byte[] convert(MultipartFile file) {
        return new byte[0];
    }
}
