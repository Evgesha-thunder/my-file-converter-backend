package com.bulish.melnikov.converter;

import com.bulish.melnikov.converter.annotations.EnableConvertFunction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableConvertFunction
public class MyFileConverterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFileConverterBackendApplication.class, args);
	}
}
