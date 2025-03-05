package com.bulish.melnikov.converter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RedisHash("Customer")
public class ConvertRequest {

    @Id
    private String id;

    private State state;

    private String filePath;

    private String convertedFilePath;

    private String formatTo;

    private String formatFrom;

    private Date convertionDate;

    public ConvertRequest(String filePath, String formatTo, String formatFrom) {
        this.formatTo = formatTo;
        this.formatFrom = formatFrom;
        this.filePath = filePath;
        this.state = State.INIT;
        this.id = UUID.randomUUID().toString();
        this.convertionDate = new Date();
    }
}
