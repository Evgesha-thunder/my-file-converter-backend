package com.bulish.melnikov.converter.convert;


import java.io.File;

public abstract class Converter {

    private String format;

    public Converter(String format) {
        this.format = format;
    }

    public abstract File convert(File filePath);
    public String getFormat() {
        return format;
    }
}
