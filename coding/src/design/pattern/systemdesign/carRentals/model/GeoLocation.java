package design.pattern.systemdesign.carRentals.model;

public class GeoLocation {
    private int lattitude;
    private int longitude;

    public GeoLocation(int lattitude, int longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public int getLattitude() {
        return lattitude;
    }

    public void setLattitude(int lattitude) {
        this.lattitude = lattitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
}
