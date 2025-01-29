
import java.lang.Math;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        GeoLocation someLocation = new GeoLocation();
        GeoLocation vilnius = new GeoLocation(54.683333, 25.283333);
        GeoLocation kaunas = new GeoLocation(54.897222, 23.886111);
        GeoLocation nearVilnius = new GeoLocation(vilnius);

        someLocation.print();
        vilnius.print();
        nearVilnius.print();

        System.out.println("Number of locations: " + GeoLocation.getNumLocations());

        System.out.println("From Vilnius to Kaunas: " + GeoLocation.distance(vilnius, kaunas));
        System.out.println("From Vilnius to random location: " + GeoLocation.distance(vilnius, someLocation));
        System.out.println("From Vilnius to random neighbour: " + GeoLocation.distance(vilnius, nearVilnius));


    }


}

class GeoLocation {
    private static final double EARTH_RADIUS = 6371; //haversino formulei
    Random random = new Random();

    double start = -90;
    double end = 90;

    double start1 = -0.1;
    double end1 = 0.1;

    private double lat, lon;
    private static int numLocations = 0;

    GeoLocation() {

        double randomLat = start + (random.nextDouble() * (end - start));
        double randomLon = start + (random.nextDouble() * (end - start));

        lat = Math.round(randomLat * 1e6) / 1e6; //suapvalinam iki 6
        lon = Math.round(randomLon * 1e6) / 1e6;

        numLocations++;

    }

    GeoLocation(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
        numLocations++;
    }

    GeoLocation(GeoLocation location) {
        double randomLat2 = start1 + (random.nextDouble() * (end1 - start1));
        double randomLon2 = start1 + (random.nextDouble() * (end1 - start1));

        double addedUpLat = location.lat + randomLat2;
        double addedUpLon = location.lon + randomLon2;

        lat = Math.round(addedUpLat * 1e6) / 1e6;
        lon = Math.round(addedUpLon * 1e6) / 1e6;

        numLocations++;
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    public static int getNumLocations() {
        return numLocations;
    }

    public void print(){
        System.out.println("Lat: " + lat);
        System.out.println("Lon: " + lon);
    }

    public static double distance(GeoLocation location1, GeoLocation location2) {

        double lat1 = Math.toRadians(location1.lat);
        double lon1 = Math.toRadians(location1.lon);
        double lat2 = Math.toRadians(location2.lat);
        double lon2 = Math.toRadians(location2.lon);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = EARTH_RADIUS * c;
        double roundedDistance = Math.round(distance * 10) / 10.0;

        return roundedDistance;
    }
}