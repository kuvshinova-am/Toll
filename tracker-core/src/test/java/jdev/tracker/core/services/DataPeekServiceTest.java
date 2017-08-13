package jdev.tracker.core.services;

import jdev.dto.Point;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.concurrent.BlockingDeque;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DataPeekServiceTest {

    @InjectMocks
    private DataPeekService service;

    @Before
    public void setUp() throws Exception {
        Point point = new Point();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(1502511617361L);
        point.setAzimuth(30);
        point.setSpeed(60);

        Point point2 = new Point();
        point2.setLat(106);
        point2.setLon(100);
        point2.setAutoId("o567gfd");
        point2.setTime(1502511617361L);
        point2.setAzimuth(30);
        point2.setSpeed(60);

        service.put(point);
        service.put(point2);
    }

    @Test
    public void get() throws Exception {
        Point resultPoint = service.get();
        assertNotNull(resultPoint);
        assertEquals(56, resultPoint.getLat(), 0);
        assertEquals(74, resultPoint.getLon(), 0);

        resultPoint = service.get();
        assertNotNull(resultPoint);
        assertEquals(106, resultPoint.getLat(), 0);
        assertEquals(100, resultPoint.getLon(), 0);
    }

    @Test
    public void getAll() throws Exception {
        assertNotNull(service.getAll());
    }
}