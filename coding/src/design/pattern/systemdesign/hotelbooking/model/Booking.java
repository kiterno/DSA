package design.pattern.systemdesign.hotelbooking.model;

import java.util.Date;
import java.util.List;

public class Booking {
    private String bookingId;
    private String hotelId;
    private String userId;
    private String roomId;
    private Double amount;
    private Date checkInDate;
    private Date checkOutDate;
    private List<String> guestList;
    private BookingStatus bookingStatus;

    public Booking(String userId, String hotelId, String roomId, Double amount, Date checkOutDate) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.amount = amount;
        this.checkInDate = checkOutDate;
    }
}
