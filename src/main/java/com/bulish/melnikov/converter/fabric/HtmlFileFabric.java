package com.bulish.melnikov.converter.fabric;


import com.bulish.melnikov.converter.convert.HtmlToPdfConverter;

public class HtmlFileFabric extends FileFabric {
    public HtmlFileFabric() {
        converters.put("pdf", new HtmlToPdfConverter());
    }
}
