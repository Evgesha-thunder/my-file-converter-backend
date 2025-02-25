package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class FileFabric {
    @Autowired
    protected final Map<String, Converter> converters = new HashMap<>();

    public Converter getConverter(String toFormat) {
        return converters.get(toFormat);
    }
}
