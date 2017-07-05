package jdev.tracker.core.utils;

public class PointUtil {

    private static final double PI = Math.PI;
    private static final double R = 6372795;
    private static double x,y;

    public static double calculateAzimuth(double llat1, double llat2, double llong1, double llong2) {

        double lat1 = llat1*PI/180;
        double lat2 = llat2*PI/180;
        double long1 = llong1*PI/180;
        double long2 = llong2*PI/180;

        double cl1 = Math.cos(lat1);
        double cl2 = Math.cos(lat2);
        double sl1 = Math.sin(lat1);
        double sl2 = Math.sin(lat2);
        double delta = long2 - long1;
        double cdelta = Math.cos(delta);
        double sdelta = Math.sin(delta);

        calculateDistance(cl1, cl2, sl1, sl2, cdelta, sdelta);

        x = (cl1*sl2) - (sl1*cl2*cdelta);
        y = sdelta*cl2;
        double z = Math.toDegrees(Math.atan(-y/x));

        if (x < 0) {
            z = z + 180;
        }

        double z2 = (z + 180.) % 360. - 180;
        z2 = -Math.toRadians(z2);
        double anglerad2 = z2 - ((2 * PI) * Math.floor((z2 / (2 * PI))));
        double angledeg = (anglerad2 * 180.) / PI;
        return angledeg;
    }

    private static double calculateDistance(double cl1, double cl2, double sl1, double sl2, double cdelta, double sdelta) {

        y = Math.sqrt(Math.pow(cl2*sdelta,2)+Math.pow(cl1*sl2-sl1*cl2*cdelta,2));
        x = sl1*sl2+cl1*cl2*cdelta;
        double ad = Math.atan2(y,x);
        return ad*R;
    }
}
