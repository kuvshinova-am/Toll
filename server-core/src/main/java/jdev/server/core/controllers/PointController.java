package jdev.server.core.controllers;

import jdev.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class PointController {

    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    private final RestTemplate restTemplate;

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
}
