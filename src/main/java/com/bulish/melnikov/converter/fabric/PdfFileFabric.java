package com.bulish.melnikov.converter.fabric;


import com.bulish.melnikov.converter.convert.PdfToDocxConverter;
import com.bulish.melnikov.converter.convert.PdfToHtmlConverter;
import com.bulish.melnikov.converter.convert.PdfToImageConverter;
import com.bulish.melnikov.converter.convert.PdfToTextConverter;

public class PdfFileFabric extends FileFabric {
    public PdfFileFabric() {
        converters.put("docx", new PdfToDocxConverter());
        converters.put("html", new PdfToHtmlConverter());
        converters.put("txt", new PdfToTextConverter());
        converters.put("image", new PdfToImageConverter());
    }
}
