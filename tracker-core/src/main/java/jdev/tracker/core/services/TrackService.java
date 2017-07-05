package jdev.tracker.core.services;

import de.micromata.opengis.kml.v_2_2_0.*;
import jdev.dto.Point;
import jdev.tracker.core.utils.PointUtil;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {

    private ArrayList<Point> points = new ArrayList<>();
    private long time = 1498998207587L;
    @PostConstruct
    public void loadTrack() throws FileNotFoundException {
        final Kml kml = Kml.unmarshal(new File(getClass().getClassLoader().getResource("17741.kml").getFile()));
        Feature feature = kml.getFeature();
        parseFeature(feature);
    }

    private void parseFeature(Feature feature) {
        if (feature != null) {
            if (feature instanceof Folder) {
                Folder folder = (Folder) feature;
                List<Feature> featureList = folder.getFeature();
                for (Feature documentFeature : featureList) {
                    Placemark placemark = (Placemark) documentFeature;
                    LineString lineString = (LineString) placemark.getGeometry();
                    List <Coordinate> coordinates = lineString.getCoordinates();
                    for (int i = 1; i < coordinates.size(); i++) {
                        jdev.dto.Point point = new Point();
                        point.setLat(coordinates.get(i-1).getLatitude());
                        point.setLon(coordinates.get(i-1).getLongitude());
                        point.setAutoId("o567gfd");
                        time += (30000 + (Math.random() * 600000));
                        point.setTime(time);
                        point.setAzimuth(
                                PointUtil.calculateAzimuth(
                                        coordinates.get(i-1).getLatitude(),
                                        coordinates.get(i).getLatitude(),
                                        coordinates.get(i-1).getLongitude(),
                                        coordinates.get(i).getLongitude()
                                )
                        );
                        point.setSpeed(10 + (Math.random() * 175));
                        points.add(point);
                    }
                }
            }
        }
    }

    public ArrayList<Point> getPoints() {
        return points;
    }
}