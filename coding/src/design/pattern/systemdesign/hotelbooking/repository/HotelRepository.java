package design.pattern.systemdesign.hotelbooking.repository;

import design.pattern.systemdesign.hotelbooking.model.Hotel;

import java.util.HashMap;
import java.util.Map;

public class HotelRepository {
    public static Map<String, Hotel> hotelMap = new HashMap<>();
}
