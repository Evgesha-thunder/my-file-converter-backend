package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class ConverterRequestQueueManagerServiceImpl implements ConverterRequestQueueManagerService {

    private final BlockingQueue<ConvertRequest> taskQueue = new LinkedBlockingQueue<>();

    @Autowired
    private  ConverterService converterService;

    public ConverterRequestQueueManagerServiceImpl() {
        new Thread(this::processQueue).start();
    }

    public void addToTaskQueue(ConvertRequest request) {
        taskQueue.add(request);
    }

    private void processQueue() {
        while (true) {
            try {
                converterService.convert(taskQueue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                throw new RuntimeException("Error processing task", e);
            }
        }
    }
}
