package com.bulish.melnikov.converter.convert;

import org.springframework.web.multipart.MultipartFile;

public interface Converter {
    byte [] convert(MultipartFile file);
}
