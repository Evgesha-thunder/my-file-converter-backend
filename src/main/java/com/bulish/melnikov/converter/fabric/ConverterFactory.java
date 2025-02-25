package com.bulish.melnikov.converter.fabric;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ConverterFactory {
    private final Map<String, FileFabric> fabrics = new HashMap<>();

    public ConverterFactory() {
        fabrics.put("pdf", new PdfFileFabric());
        fabrics.put("docx", new DocxFileFabric());
        fabrics.put("html", new HtmlFileFabric());
        fabrics.put("txt", new TextFileFabric());
        fabrics.put("jpg", new ImageFileFabric());
    }

    public FileFabric getFactory(String fromFormat) {
        return fabrics.get(fromFormat);
    }
}
