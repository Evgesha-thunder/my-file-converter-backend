package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.convert.Converter;
import com.bulish.melnikov.converter.exception.IncorrectFormatExtensionException;
import com.bulish.melnikov.converter.fabric.ConverterFactory;
import com.bulish.melnikov.converter.fabric.FileFabric;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class FileConversionServiceImpl implements FileConversionService {

    private final ConverterFactory converterFactory;

    @Override
    public byte[] performConversion(MultipartFile file, String toFormat) {
        FileFabric fileFabric = converterFactory.getFactory(file.getContentType());

        if (fileFabric == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format fromFormat");
        }
        Converter converter = fileFabric.getConverter(toFormat);

        if (converter == null) {
            throw new IncorrectFormatExtensionException("Unsupported file format toFormat");
        }

        return converter.convert(file);
    }
}
