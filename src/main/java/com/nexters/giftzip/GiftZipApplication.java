package com.nexters.giftzip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:aws.properties")
public class GiftZipApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiftZipApplication.class, args);
    }
}
