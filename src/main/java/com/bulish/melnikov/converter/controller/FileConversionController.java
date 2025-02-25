package com.bulish.melnikov.converter.controller;

import com.bulish.melnikov.converter.fabric.ConverterFactory;
import com.bulish.melnikov.converter.service.FileConversionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class FileConversionController {

    private final FileConversionService fileConversionService;
    private  final ConverterFactory converterFactory;


    @PostMapping("/convert")
    @ResponseStatus(HttpStatus.OK)
    public byte [] convert(@RequestParam("file") MultipartFile file, @RequestParam("toFormat") String toFormat) throws IOException {
        return fileConversionService.performConversion(file, toFormat);
    }
}
