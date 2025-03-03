package com.bulish.melnikov.converter.mapper;

import com.bulish.melnikov.converter.model.ConvertRequest;
import com.bulish.melnikov.converter.model.ConvertResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConvertRequestToConvertResponseMapper {

    ConvertResponse convertRequestToConvertResponse(ConvertRequest request);

    @Mapping(ignore = true, target = "filePath")
    ConvertRequest gameInfoToGameInfoResponse(ConvertResponse response);
}
