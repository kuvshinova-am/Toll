package jdev.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1489900897458}";
    private String autoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        Point point = new Point();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

    @Test
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        Point dto = null;
        try {
            dto = mapper.readValue(expected, Point.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1489900897458L, dto.getTime());
        return null;
    }
}