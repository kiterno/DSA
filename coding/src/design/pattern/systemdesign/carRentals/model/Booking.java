package design.pattern.systemdesign.carRentals.model;

import java.util.Date;

public class Booking {
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private GeoLocation location;
    private Double cost;

    private Status bookingStatus;

    public Booking(User user, Vehicle vehicle, Date bookingDate, GeoLocation location, Double cost, Status bookingStatus) {
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = bookingDate;
        this.location = location;
        this.cost = cost;
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Status getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Status bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
