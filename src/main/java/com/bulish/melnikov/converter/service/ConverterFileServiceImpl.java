package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.convert.Converter;
import com.bulish.melnikov.converter.exception.IncorrectFormatExtensionException;
import com.bulish.melnikov.converter.fabric.ConverterFactory;
import com.bulish.melnikov.converter.fabric.FileFabric;
import com.bulish.melnikov.converter.mapper.ConvertRequestToConvertResponseMapper;
import com.bulish.melnikov.converter.model.ConversionTask;
import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.model.ConvertResponse;
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
    private final ConverterTaskQueueManagerServiceImpl queueService;
    private final ConvertRequestToConvertResponseMapper requestToConvertResponseMapper;

    private final String dirUpload = "temp/files/";

    @Override
    public ConvertResponse requestToConvert(MultipartFile fileToConvert, String toFormat) {
        String extension = getFileExtension(fileToConvert.getOriginalFilename());
        FileFabric fileFabric = converterFactory.getFactory(extension);

        if (fileFabric == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format fromFormat");
        }

        Converter converter = fileFabric.getConverter(toFormat);

        if (converter == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format toFormat");
        }

        String filePath = uploadFileToLocalSystem(fileToConvert);

        if (filePath == null) {
          throw new RuntimeException("Error uploading file");
        }

        ConvertRequest convertRequest = new ConvertRequest(filePath);
        convertRequestService.save(convertRequest);

        queueService.addToTaskQueue(new ConversionTask(filePath, converter));

        return requestToConvertResponseMapper.convertRequestToConvertResponse(convertRequest);
    }

    public String uploadFileToLocalSystem(MultipartFile file) {
        String filePath = null;
        String originalFileName = file.getOriginalFilename();
        Path path = Paths.get(dirUpload + originalFileName);
        String newFileName = originalFileName;
        int fileCount = 0;
        String fileNameWithoutExt = getFileNameWithoutExtension(originalFileName);
        String fileExtension = getFileExtension(originalFileName);
        fileExtension = fileExtension.isEmpty() ? "" : "." + fileExtension;

        while (Files.exists(path)) {
            fileCount++;
            newFileName = String.format("%s(%d)%s", fileNameWithoutExt, fileCount, fileExtension);
            path = Paths.get(dirUpload + newFileName);
        }

        try {
            Files.createDirectories(Paths.get(dirUpload));
            file.transferTo(path);
            filePath = path.toString();
        } catch (IOException e) {
            log.error("Error uploading file", e);
        }

        return filePath;
    }

    private String getFileExtension(String fileName) {
        int lastIndexOfDot = fileName.lastIndexOf('.');
        if (lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1) {

            return fileName.substring(lastIndexOfDot + 1);
        }

        return "";
    }

    private String getFileNameWithoutExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return fileName;
        } else {
            return fileName.substring(0, lastDotIndex);
        }
    }
}
