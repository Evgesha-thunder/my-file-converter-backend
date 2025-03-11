package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ConvertRequest;

public interface ConvertRequestService {

    public ConvertRequest save(ConvertRequest convertRequest);

    public ConvertRequest get(String convertRequestId);

    public ConvertRequest update(ConvertRequest convertRequest);

    public void delete(String convertRequestId);
}
