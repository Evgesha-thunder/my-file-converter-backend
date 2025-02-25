package com.bulish.melnikov.converter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileConversionService {
    byte [] performConversion(MultipartFile file, String toFormat) throws IOException;
}
