package jdev.tracker.core.dao;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="point")
public class Point {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID")
    int id;

    @Column(name = "LAT", nullable = false)
    Double lat;

    @Column(name = "LON", nullable = false)
    Double lon;

    @Column(name = "AUTOID", length = 8, nullable = false)
    String autoId;

    @Column(name = "TIME", nullable = false)
    Long time;

    @Column(name = "AZIMUTH", nullable = false)
    Double azimuth;

    @Column(name = "SPEED", nullable = false)
    Double speed;


    public String toString() {
        return "Point{ id=" + id + ", lat=" + lat + ", lon=" + lon + ", autoId=" + autoId + ", time=" + time + ", " +
                "azimuth=" + azimuth + ", speed=" + speed + " }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
