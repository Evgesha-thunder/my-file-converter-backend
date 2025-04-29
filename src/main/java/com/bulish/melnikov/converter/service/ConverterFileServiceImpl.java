package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequestMsgDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConverterFileServiceImpl implements ConverterFileService {

    private final ConverterRequestQueueManagerServiceImpl queueService;

    @Override
    public void requestToConvert(ConvertRequestMsgDTO convertRequest) {
        queueService.addRequestToQueue(convertRequest);
    }
}
