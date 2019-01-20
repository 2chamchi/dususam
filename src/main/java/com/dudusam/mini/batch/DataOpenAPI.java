package com.dudusam.mini.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DataOpenAPI {

    Logger logger = LoggerFactory.getLogger(DataOpenAPI.class);

    // *분(0-59) *시간(0-23) *일(1-31) *월(1-12) *요일(0-7)
    @Scheduled(cron = "*/10 * * * * *")
    public void test(){

        logger.trace("trace: hello, world");
        logger.debug("debug: hello, world");
        logger.info("info: hello, world");
        logger.warn("warn: hello, world");
        logger.error("error: hello, world");
    }
}

