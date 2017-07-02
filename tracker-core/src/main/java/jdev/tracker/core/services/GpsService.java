package jdev.tracker.core.services;

import jdev.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GpsService {
    private int i = 0;

    @Autowired
    private TrackService trackService;

    @PostConstruct
    @Scheduled(cron = "*/1 * * * * *")
    public Point getCoordinates() {
        return trackService.getPoints().get(i++);
    }
}
