package de.pohlproductions.servermonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ServerMonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerMonitoringApplication.class, args);
    }
}
