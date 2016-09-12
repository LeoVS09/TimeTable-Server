package edu.bonch.leovs09;

/**
 * Created by LeoVS09 on 04.09.2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class TimeTableServer {
    private static final Logger log = LoggerFactory.getLogger(TimeTableServer.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TimeTableServer.class, args);

        log.info("Server started");

    }

}
