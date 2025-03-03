package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConversionTask;

public interface ConverterTaskQueueManagerService {

    void addToTaskQueue(ConversionTask task);
}
