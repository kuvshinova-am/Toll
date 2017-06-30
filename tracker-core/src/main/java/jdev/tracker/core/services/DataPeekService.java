package jdev.tracker.core.services;

import jdev.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService {

    private BlockingDeque<Point> queue =  new LinkedBlockingDeque<>(10000);

    @Autowired
    private GpsService gpsService;

    @PostConstruct
    public void init() {
        gpsService.getCoordinates();
    }

    @Scheduled(cron = "*/1 * * * * *")
    void put() throws InterruptedException {
        queue.put(gpsService.getCoordinates());
    }

    Point get() throws InterruptedException {
        return  queue.take();
    }
}