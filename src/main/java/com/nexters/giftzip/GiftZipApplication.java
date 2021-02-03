package com.nexters.giftzip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@Slf4j
@PropertySource("classpath:aws.properties")
public class GiftZipApplication {
    @Value("${spring.profiles.active}")
    private static String activeProfile;

    public static void main(String[] args) {
        SpringApplication.run(GiftZipApplication.class, args);
        log.info("ACTIVE PROFILE :: {}", activeProfile);
    }
}
