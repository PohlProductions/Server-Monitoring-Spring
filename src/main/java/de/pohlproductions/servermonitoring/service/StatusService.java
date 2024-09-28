package de.pohlproductions.servermonitoring.service;

import de.pohlproductions.servermonitoring.model.Status;
import de.pohlproductions.servermonitoring.repository.StatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetAddress;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    @Value("${monitoring.server.url}")
    private String url;

    @Scheduled(fixedRateString = "${monitoring.interval}")
    public void checkStatus() throws IOException {
        boolean reachable = InetAddress.getByName(url).isReachable(5000);
        log.debug("Server is reachable: {}", reachable);
        Status status = new Status(url, reachable);
        statusRepository.save(status);
    }

}
