package jdev.tracker.core.services;

import jdev.dto.Point;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService {

    private BlockingDeque<Point> queue =  new LinkedBlockingDeque<>(10000);

    void put(Point point) throws InterruptedException {
        queue.put(point);
    }

    Point get() throws InterruptedException {
        return  queue.take();
    }
}