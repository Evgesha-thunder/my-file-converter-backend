package com.bulish.melnikov.converter.convert;

import org.springframework.web.multipart.MultipartFile;

public abstract class Converter {

    private String format;

    public Converter(String format) {
        this.format = format;
    }

    public abstract byte [] convert(String filePath);
    public String getFormat() {
        return format;
    }
}
