package jdev.server.core.controllers;

import jdev.dto.Point;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;


import static org.junit.Assert.*;
public class PointControllerTest {
    private TestRestTemplate restTemplate;

    private Point[] points;

    @Before
    public void setUp() throws Exception {
        restTemplate = new TestRestTemplate();
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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<Object>(points,headers);

        ResponseEntity<Point[]> responseEntity =
                restTemplate.exchange("http://localhost:9000/point/", HttpMethod.POST, requestEntity,
                        new ParameterizedTypeReference<Point[]>() {});
        Point resultPoint = responseEntity.getBody()[0];
        assertNotNull(resultPoint);
        assertEquals(56.0, resultPoint.getLat(), 0);
        assertEquals(74.0,resultPoint.getLon(), 0);
        assertEquals("o567gfd",resultPoint.getAutoId());
        assertEquals(1502511617361L,resultPoint.getTime());
        assertEquals(30.0,resultPoint.getAzimuth(),0);
        assertEquals(60.0,resultPoint.getSpeed(), 0);
    }

    @TestConfiguration
    static class Config {
        @Bean
        public RestTemplateBuilder restTemplateBuilder() {
            return new RestTemplateBuilder();
        }
    }
}