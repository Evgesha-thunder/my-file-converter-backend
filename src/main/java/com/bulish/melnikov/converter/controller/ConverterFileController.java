package com.bulish.melnikov.converter.controller;

import com.bulish.melnikov.converter.model.ConvertResponse;
import com.bulish.melnikov.converter.service.ConverterFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class ConverterFileController {

    private final ConverterFileService converterFileService;

    @PostMapping("/convert")
    @ResponseStatus(HttpStatus.OK)
    public ConvertResponse convert(@RequestParam("file") MultipartFile file,
                                   @RequestParam("toFormat") String toFormat) throws IOException {
        return converterFileService.requestToConvert(file, toFormat);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConvertResponse requestStatus(@PathVariable("id") String id) {
        return converterFileService.getRequestStatusById(id);
    }

    @GetMapping("/{id}/download")
    @ResponseStatus(HttpStatus.OK)
    public byte[] download(@PathVariable("id") String id) {
        return converterFileService.downloadConvertedFile(id);
    }
}
