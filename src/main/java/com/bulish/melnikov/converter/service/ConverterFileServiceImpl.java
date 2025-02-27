package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.convert.Converter;
import com.bulish.melnikov.converter.exception.IncorrectFormatExtensionException;
import com.bulish.melnikov.converter.fabric.ConverterFactory;
import com.bulish.melnikov.converter.fabric.FileFabric;
import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.model.State;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@AllArgsConstructor
@Slf4j
public class ConverterFileServiceImpl implements ConverterFileService {

    private final ConverterFactory converterFactory;
    private final ConvertRequestService convertRequestService;

    private final String dirUpload = "temp/files/";

    @Override
    public ConvertRequest requestToConvert(MultipartFile fileToConvert, String toFormat) {
        String extension = getFileExtension(fileToConvert.getOriginalFilename());
        FileFabric fileFabric = converterFactory.getFactory(extension);

        if (fileFabric == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format fromFormat");
        }

        Converter converter = fileFabric.getConverter(toFormat);

        if (converter == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format toFormat");
        }

        boolean isUploaded = uploadFileToLocalSystem(fileToConvert);

        if (!isUploaded) {
          throw new RuntimeException("Error uploading file");
        }

        ConvertRequest convertRequest = new ConvertRequest(State.INIT);
        convertRequestService.save(convertRequest);

        return convertRequest;
    }

    public boolean uploadFileToLocalSystem(MultipartFile file) {
        try {
            Files.createDirectories(Paths.get(dirUpload));
            Path filePath = Paths.get(dirUpload + file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            log.error("Error uploading file", e);

            return false;
        }

        return true;
    }

    private String getFileExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf('.');
        if (lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1) {

            return fileName.substring(lastIndexOfDot + 1);
        }

        return "";
    }
}
