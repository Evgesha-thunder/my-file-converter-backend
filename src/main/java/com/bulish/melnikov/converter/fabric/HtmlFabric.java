package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HtmlFabric extends Fabric {

    @Autowired
    public HtmlFabric(List<HtmlConverter> converters) {
        super("html");

        for (HtmlConverter converter : converters) {
            this.converters.put(converter.getFormat(), converter);
        }
    }
}
