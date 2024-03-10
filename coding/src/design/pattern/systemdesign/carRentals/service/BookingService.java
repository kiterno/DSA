package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.Booking;
import design.pattern.systemdesign.carRentals.model.GeoLocation;
import design.pattern.systemdesign.carRentals.model.User;
import design.pattern.systemdesign.carRentals.model.VehicleType;

import java.util.Date;

public interface BookingService {
    public Booking createBooking(User user, VehicleType type, Date bookingDate, GeoLocation location);

    public Boolean cancelBooking(String bookingId);


}
