package design.pattern.systemdesign.hotelbooking.service;

import design.pattern.systemdesign.hotelbooking.model.Booking;
import design.pattern.systemdesign.hotelbooking.model.BookingStatus;

import java.util.Date;
import java.util.List;

public interface BookingService {
    public Booking createBooking(String userId, String hotelId, String roomId, Date checkOutDate, List<String> guests);
    public Booking cancelBooking(String bookingId);
    public boolean updateBookingStatus(BookingStatus bookingStatus, String booingId);
}
