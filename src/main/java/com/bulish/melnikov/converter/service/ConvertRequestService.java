package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.repository.ConverterRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface ConvertRequestService {

    public ConvertRequest save(ConvertRequest convertRequest);

    public ConvertRequest get(String convertRequestId);

    public ConvertRequest update(String convertRequestId, ConvertRequest convertRequest);

    public void delete(String convertRequestId);
}
