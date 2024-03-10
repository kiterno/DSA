package design.pattern.systemdesign.hotelbooking.repository;

import design.pattern.systemdesign.hotelbooking.model.Booking;

import java.util.HashMap;
import java.util.Map;

public class BookingRepository {
    public static Map<String, Booking> bookingMap = new HashMap<>();
}
