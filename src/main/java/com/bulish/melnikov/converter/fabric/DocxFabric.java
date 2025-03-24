package com.bulish.melnikov.converter.fabric;


import com.bulish.melnikov.converter.convert.DocxConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DocxFabric extends Fabric {

    @Autowired
    public DocxFabric(List<DocxConverter> converters) {
        super("docx");

        for (DocxConverter converter : converters) {
            this.converters.put(converter.getFormat(), converter);
        }
    }
}
