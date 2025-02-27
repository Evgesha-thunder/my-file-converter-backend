package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.repository.ConverterRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConvertRequestService {

    private final ConverterRequestRepository fileRepo;
    public ConvertRequest save(ConvertRequest convertRequestId){
        return fileRepo.save(convertRequestId);
    }

    public ConvertRequest get(String convertRequestId){
        return fileRepo.findById(convertRequestId).orElseThrow(()
                -> new RuntimeException("File not found"));
    }

    public ConvertRequest update(String convertRequestId, ConvertRequest convertRequest){
        ConvertRequest convertRequestFromRedis = get(convertRequestId);

        convertRequestFromRedis.setState(convertRequest.getState());

        delete(convertRequestId);
        fileRepo.save(convertRequestFromRedis);

        return convertRequestFromRedis;
    }

    public void delete(String convertRequestId){
        fileRepo.deleteById(convertRequestId);
    }
}
