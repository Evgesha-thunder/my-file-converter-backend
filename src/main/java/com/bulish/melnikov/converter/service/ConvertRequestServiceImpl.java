package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.repository.ConverterRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConvertRequestServiceImpl implements ConvertRequestService {

    private final ConverterRequestRepository requestRepo;

    @Override
    public ConvertRequest save(ConvertRequest convertRequest){
        return requestRepo.save(convertRequest);
    }

    @Override
    public ConvertRequest get(String convertRequestId){
        return requestRepo.findById(convertRequestId).orElseThrow(()
                -> new RuntimeException("File not found"));
    }

    @Override
    public ConvertRequest update(ConvertRequest convertRequest){
        ConvertRequest convertRequestFromRedis = get(convertRequest.getId());

        convertRequestFromRedis.setState(convertRequest.getState());
        convertRequest.setConvertedFilePath(convertRequest.getConvertedFilePath());

        requestRepo.save(convertRequestFromRedis);

        return convertRequestFromRedis;
    }

    @Override
    public void delete(String convertRequestId){
        requestRepo.deleteById(convertRequestId);
    }
}
