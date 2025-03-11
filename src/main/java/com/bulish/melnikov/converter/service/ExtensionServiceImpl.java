package com.bulish.melnikov.converter.service;

import com.bulish.melnikov.converter.model.ExtensionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtensionServiceImpl implements ExtensionService {

    private static final List<ExtensionDto> extensions;

    static {
        extensions = List.of(
                new ExtensionDto("pdf", List.of("html", "text", "docx"), 10),
                new ExtensionDto("hml", List.of("pdf"), 10),
                new ExtensionDto("docx", List.of("pdf"), 10),
                new ExtensionDto("text", List.of("pdf"), 10)
                );
    }
    @Override
    public List<ExtensionDto> getAllowedExtensions() {
        return extensions;
    }
}
