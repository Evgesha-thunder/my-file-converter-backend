package com.bulish.melnikov.converter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface FileService {

     String saveMultipartFile(MultipartFile file) throws IOException;

     String getFileExtension(String fileName);

     String getFileNameWithoutExtension(String fileName);

     File getFile(String filePath);

     String saveFile(File file) throws IOException;

     void deleteFile(String filePath) throws IOException;
}
