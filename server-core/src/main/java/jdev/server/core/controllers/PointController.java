package jdev.server.core.controllers;

import jdev.dto.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping(path = "/point")
public class PointController {

    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    @RequestMapping(path = "/", method = RequestMethod.POST)
    boolean receive(@RequestBody Point point) {
        log.info(String.valueOf(point));

        try(FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(String.valueOf(point));
            writer.flush();
        }
        catch(IOException ex) {
            log.info(ex.getMessage());
        }
        return true;
    }
}
