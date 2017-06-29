package jdev.tracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GpsService {

    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "*/60 * * * * *")
    public void getCoordinates() {
    }
}
