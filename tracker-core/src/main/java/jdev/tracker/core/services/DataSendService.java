package jdev.tracker.core.services;

import jdev.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.*;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.concurrent.BlockingDeque;

@Service
public class DataSendService {

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    @Autowired
    private DataPeekService dataPeekService;
    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "*/60 * * * * *")
    public void sendToServer() throws InterruptedException {
        BlockingDeque<Point> queue = dataPeekService.getAll();
        Point[] points = new Point[queue.size()];

        int i = 0;
        for(Point point : queue) {
            points[i++] = point;
            dataPeekService.getAll().remove(point);
        }

        restTemplate.postForObject("http://localhost:9000/point/", points, Point[].class);
    }


}
