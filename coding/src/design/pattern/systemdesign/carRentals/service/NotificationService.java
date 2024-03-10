package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.Booking;
import design.pattern.systemdesign.carRentals.model.User;

public interface NotificationService {
    public void notifyUser(User user, Booking booking);
}
