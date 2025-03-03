package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.convert.Converter;
import com.bulish.melnikov.converter.model.ConversionTask;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class ConverterTaskQueueManagerServiceImpl implements ConverterTaskQueueManagerService {

    private final BlockingQueue<ConversionTask> taskQueue = new LinkedBlockingQueue<>();

    public ConverterTaskQueueManagerServiceImpl() {
        new Thread(this::processQueue).start();
    }

    public void addToTaskQueue(ConversionTask task) {
        taskQueue.add(task);
    }

    private void processQueue() {
        while (true) {
            try {
                ConversionTask task = taskQueue.take();
                Converter converter = task.getConverter();

                converter.convert(task.getFilePath());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                throw new RuntimeException("Error processing task", e);
            }
        }
    }
}
