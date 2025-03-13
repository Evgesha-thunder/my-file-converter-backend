package com.bulish.melnikov.converter.job;

import com.bulish.melnikov.converter.service.ConvertRequestService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Component
public class DeleteConvertRequestsAndRelatedFiles {

    private final ConvertRequestService convertRequestService;

    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.MINUTES)
    public void delete() {
        convertRequestService.deleteOldConvertRequestWithFiles();
    }
}