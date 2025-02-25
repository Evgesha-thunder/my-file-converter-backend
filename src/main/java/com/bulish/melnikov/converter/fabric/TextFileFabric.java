package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.TextToPdfConverter;

public class TextFileFabric extends FileFabric {
    public TextFileFabric() {
        converters.put("pdf", new TextToPdfConverter());
    }
}
