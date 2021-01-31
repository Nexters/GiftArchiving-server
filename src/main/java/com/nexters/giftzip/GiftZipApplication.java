package com.nexters.giftzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
@PropertySource("classpath:aws.properties")
public class GiftZipApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiftZipApplication.class, args);
    }
}
