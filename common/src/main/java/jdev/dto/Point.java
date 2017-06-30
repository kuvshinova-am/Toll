package jdev.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Point {
    private double lat;
    private double lon;
    private String autoId;
    private long time;
    private double azimuth;
    private int speed;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }


    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(double azimuth) {
        this.azimuth = azimuth;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", autoId='" + autoId + '\'' +
                ", time=" + time +
                ", azimuth=" + azimuth +
                ", speed=" + speed +
                '}';
    }
}
