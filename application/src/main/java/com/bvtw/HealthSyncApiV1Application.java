package com.bvtw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthSyncApiV1Application {

    private static final Logger logger = LoggerFactory.getLogger(HealthSyncApiV1Application.class);


    public static void main(String[] args) {
        SpringApplication.run(HealthSyncApiV1Application.class, args);
        logger.info("HealthSyncApi V1 Application Started........");
    }

}
