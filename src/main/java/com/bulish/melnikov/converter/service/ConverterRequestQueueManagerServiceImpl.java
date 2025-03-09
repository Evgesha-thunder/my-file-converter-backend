package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
@Slf4j
public class ConverterRequestQueueManagerServiceImpl implements ConverterRequestQueueManagerService {

    private final BlockingQueue<ConvertRequest> taskQueue = new LinkedBlockingQueue<>();

    private final ConverterService converterService;
    private volatile boolean running = true;

    public ConverterRequestQueueManagerServiceImpl(ConverterService converterService) {
        this.converterService = converterService;
        new Thread(this::processQueue).start();
    }

    public void addRequestToQueue(ConvertRequest request) {
        taskQueue.add(request);
    }

    private void processQueue() {
        while (running) {
            try {
                ConvertRequest request = taskQueue.take();
                try {
                    converterService.convert(request);
                } catch (Exception e) {
                    log.error("Error converting file", e);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }
}
