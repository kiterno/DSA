package design.pattern.systemdesign.carRentals.repository;

import design.pattern.systemdesign.carRentals.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    public static Map<String, Booking> bookingMap = new HashMap<>();
}
