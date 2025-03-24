package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.TextConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TextFabric extends Fabric {

    @Autowired
    public TextFabric(List<TextConverter> converters) {
        super("txt");
        for (TextConverter converter : converters) {
            this.converters.put(converter.getFormat(), converter);
        }
    }
}

