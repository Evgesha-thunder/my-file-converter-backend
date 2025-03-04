package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.mapper.ConvertRequestToConvertResponseMapper;
import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.model.ConvertResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class ConverterFileServiceImpl implements ConverterFileService {

    private final ConvertRequestService convertRequestService;
    private final ConverterRequestQueueManagerServiceImpl queueService;
    private final ConvertRequestToConvertResponseMapper requestToConvertResponseMapper;
    private final FileService fileService;

    private final String dirUpload = "temp/files/";

    @Override
    public ConvertResponse requestToConvert(MultipartFile fileToConvert, String formatTo) {
        String formatFrom = fileService.getFileExtension(fileToConvert.getOriginalFilename());

        //TODO FORMATS VALIDATION

        String filePath = null;
        try {
            filePath = fileService.saveMultipartFile(fileToConvert);
        } catch (IOException e) {
            log.error("Error uploading Multipart File", e);
            throw new RuntimeException(e);
        }

        if (filePath == null) {
          throw new RuntimeException("Error uploading file");
        }

        ConvertRequest convertRequest = new ConvertRequest(filePath, formatFrom, formatTo);
        convertRequestService.save(convertRequest);

        queueService.addToTaskQueue(convertRequest);

        return requestToConvertResponseMapper.convertRequestToConvertResponse(convertRequest);
    }
}
