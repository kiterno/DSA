package design.pattern.systemdesign.hotelbooking.service;

import design.pattern.systemdesign.hotelbooking.model.Booking;
import design.pattern.systemdesign.hotelbooking.model.BookingStatus;
import design.pattern.systemdesign.hotelbooking.model.Room;
import design.pattern.systemdesign.hotelbooking.repository.RoomRepository;

import java.util.Date;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public Booking createBooking(String userId, String hotelId, String roomId, Date checkOutDate, List<String> guests) {
        Room room = RoomRepository.roomMap.get(roomId);
        Double amount = 10d;
        Booking booking = new Booking(userId, hotelId, roomId, amount, checkOutDate);
        return null;
    }

    @Override
    public Booking cancelBooking(String bookingId) {
        return null;
    }

    @Override
    public boolean updateBookingStatus(BookingStatus bookingStatus, String booingId) {
        return false;
    }
}
