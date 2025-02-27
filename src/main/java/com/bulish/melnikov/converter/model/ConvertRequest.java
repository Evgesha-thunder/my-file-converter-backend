package com.bulish.melnikov.converter.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Getter
@Setter
@RedisHash("Customer")
@NoArgsConstructor
public class ConvertRequest {

    @Id
    private String id = UUID.randomUUID().toString();

    private State state;

    public ConvertRequest(State state) {
        this.state = state;
    }
}
