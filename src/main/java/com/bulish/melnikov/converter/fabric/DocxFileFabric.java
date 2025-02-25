package com.bulish.melnikov.converter.fabric;


import com.bulish.melnikov.converter.convert.DocxToPDFConverter;

public class DocxFileFabric extends FileFabric {
    public DocxFileFabric() {
        converters.put("pdf", new DocxToPDFConverter());
    }
}
