package jdev.tracker.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GpsService {
    private int i = 0;

    @Autowired
    private TrackService trackService;

    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "*/1 * * * * *")
    public void getCoordinates() throws InterruptedException {
        dataPeekService.put(trackService.getPoints().get(i++));
    }
}
