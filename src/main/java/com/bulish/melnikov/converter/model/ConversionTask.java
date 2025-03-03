package com.bulish.melnikov.converter.model;

import com.bulish.melnikov.converter.convert.Converter;
import lombok.Data;

@Data
public class ConversionTask {

    private String filePath;

    private Converter converter;

    public ConversionTask(String filePath, Converter converter) {
        this.converter = converter;
        this.filePath = filePath;
    }
}