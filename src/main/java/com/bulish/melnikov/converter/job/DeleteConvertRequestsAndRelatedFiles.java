package com.bulish.melnikov.converter.job;

import com.bulish.melnikov.converter.service.ConvertRequestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@Component
public class DeleteConvertRequestsAndRelatedFiles {

    private final ConvertRequestServiceImpl convertRequestService;

    @Scheduled(fixedRate = 2, timeUnit = TimeUnit.HOURS)
    public void delete() {
        convertRequestService.deleteOldConvertRequestWithFiles();
    }
}