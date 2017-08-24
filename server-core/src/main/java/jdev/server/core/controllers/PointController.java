package jdev.server.core.controllers;

import jdev.dto.Point;
import jdev.server.core.dao.repo.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class PointController {

    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    private final RestTemplate restTemplate;

    @Autowired
    PointRepository pointRepository;

    public PointController(@Autowired RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/point/", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public Point[] receive(@RequestBody Point[] points) {
        for(int i = 0; i < points.length; i++) {
            log.info(String.valueOf(points[i]));

            try(FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write(String.valueOf(points[i]));
                writer.flush();
            }
            catch(IOException ex) {
                log.info(ex.getMessage());
            }
        }
        return points;
    }

    @RequestMapping(value = "/points/", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Point[] getByTime(@RequestParam("auto-id") String autoId, @RequestParam long hours) {
        long millis = TimeUnit.HOURS.toMillis(hours);
        List<jdev.server.core.dao.Point> allPoints = (List<jdev.server.core.dao.Point>) pointRepository.filterByTime(
                autoId,
                millis,
                System.currentTimeMillis()
        );

        int i = 0;
        Point[] points = new Point[allPoints.size()];
        for(jdev.server.core.dao.Point entityPoint : allPoints) {
            Point point = new Point();
            point.setLat(entityPoint.getLat());
            point.setLon(entityPoint.getLon());
            point.setAzimuth(entityPoint.getAzimuth());
            point.setSpeed(entityPoint.getSpeed());
            point.setTime(entityPoint.getTime());
            point.setAutoId(entityPoint.getAuto().getIdAuto());

            points[i++] = point;
        }

        return points;
    }
}
