package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.Booking;
import design.pattern.systemdesign.carRentals.model.User;

public class NotificationServiceImpl implements NotificationService {
    @Override
    public void notifyUser(User user, Booking booking) {
        System.out.println(String.format("Dear, %s you have an upcoming booking on %s.", user.getFirstName(), booking.getBookingDate()));
    }
}
