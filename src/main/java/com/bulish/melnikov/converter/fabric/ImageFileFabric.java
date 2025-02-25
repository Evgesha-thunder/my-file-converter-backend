package com.bulish.melnikov.converter.fabric;

import com.bulish.melnikov.converter.convert.ImageToPdfConverter;

public class ImageFileFabric extends FileFabric {
    public ImageFileFabric() {
        converters.put("pdf", new ImageToPdfConverter());
    }
}
