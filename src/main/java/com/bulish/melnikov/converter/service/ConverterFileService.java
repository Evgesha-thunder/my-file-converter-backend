package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ConverterFileService {
    ConvertRequest requestToConvert(MultipartFile file, String toFormat) throws IOException;
}
