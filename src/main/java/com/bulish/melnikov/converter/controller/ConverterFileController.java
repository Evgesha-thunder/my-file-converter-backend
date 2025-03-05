package com.bulish.melnikov.converter.controller;

import com.bulish.melnikov.converter.model.ConvertResponse;
import com.bulish.melnikov.converter.service.ConverterFileService;
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
public class ConverterFileController {

    private final ConverterFileService converterFileService;

    @PostMapping("/convert")
    @ResponseStatus(HttpStatus.OK)
    public ConvertResponse convert(@RequestParam("file") MultipartFile file, @RequestParam("toFormat") String toFormat) throws IOException {
        return converterFileService.requestToConvert(file, toFormat);
    }
}
