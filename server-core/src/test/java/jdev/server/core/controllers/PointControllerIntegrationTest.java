package jdev.server.core.controllers;

import jdev.dto.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PointControllerIntegrationTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    PointController pointController;

    private Point[] points;

    @Before
    public void setUp() throws Exception {
        Point point = new Point();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(1502511617361L);
        point.setAzimuth(30);
        point.setSpeed(60);
        points = new Point[1];
        points[0] = point;
    }

    @Test
    public void receive() throws Exception {

        Point[] result = new PointController(new RestTemplate()).receive(points);
        assertNotNull(result);
        for(Point point : result) {
            System.out.println("DATA: " + point.getLat());
        }
        assertEquals(result[0].getLat(), 56, 0);
        assertEquals(result[0].getLon(), 74, 0);
        assertEquals(result[0].getAutoId(), "o567gfd");
        assertEquals(result[0].getTime(), 1502511617361L);
        assertEquals(result[0].getAzimuth(), 30, 0);
        assertEquals(result[0].getSpeed(), 60, 0);
    }

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }
    }
}