package jdev.tracker.core.services;

import jdev.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GpsService {
    private int currentLet = 0;
    private int currentLon = 0;
    private int currentAzimuth = 0;
    private int currentSpeed = 0;

    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "*/1 * * * * *")
    public void getCoordinates() {
        Point point = new Point();
        point.setLat(currentLet++);
        point.setLon(currentLon++);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        point.setAzimuth(currentAzimuth++);
        point.setSpeed(currentSpeed++);
    }
}
