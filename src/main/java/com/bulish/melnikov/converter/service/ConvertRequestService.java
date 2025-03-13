package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;

import java.util.List;

public interface ConvertRequestService {

    ConvertRequest save(ConvertRequest convertRequest);

    ConvertRequest get(String convertRequestId);

    ConvertRequest update(ConvertRequest convertRequest);

    void delete(String convertRequestId);

    List<ConvertRequest> getOldConvertRequests();

    void deleteOldConvertRequestWithFiles();
}
