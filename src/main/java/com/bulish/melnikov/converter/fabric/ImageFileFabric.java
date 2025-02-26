package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.ImageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImageFileFabric extends FileFabric {

    @Autowired
    public ImageFileFabric(List<ImageConverter> converters) {
        super("image");
        for (ImageConverter converter : converters) {
            this.converters.put(converter.getFormat(), converter);
        }
    }
}

