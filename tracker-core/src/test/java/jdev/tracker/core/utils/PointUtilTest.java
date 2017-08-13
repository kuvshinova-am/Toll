package jdev.tracker.core.utils;

import jdev.dto.Point;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.Assert.*;

public class PointUtilTest {
    Point[] points;

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
        point2.setLat(58);
        point2.setLon(76);
        point2.setAutoId("o567gfd");
        point2.setTime(1502511617390L);
        point2.setAzimuth(35);
        point2.setSpeed(60);
        points = new Point[2];
        points[0] = point;
        points[1] = point2;
    }
    @Test
    public void calculateAzimuth() throws Exception {
        double result = PointUtil.calculateAzimuth(points[0].getLat(), points[0].getLon(), points[1].getLat(), points[1].getLon());
        assertEquals(14.89626706242848, result, 0);
    }

}