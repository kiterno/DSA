package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.*;
import design.pattern.systemdesign.carRentals.repository.BookingRepository;
import design.pattern.systemdesign.carRentals.repository.InventoryRepository;

import java.util.Date;
import java.util.Map;

public class BookingServiceImpl implements BookingService {

    @Override
    public Booking createBooking(User user, VehicleType type, Date bookingDate, GeoLocation location) {
        Vehicle vehicle = getVehicle(type);
        if (vehicle == null) throw new RuntimeException("No Vehicle of type " + type + " is available");
        Booking booking = new Booking(user, vehicle, bookingDate, location, getCostAsPerType(type), Status.BOOKED);

        vehicle.setAvailable(false);
        BookingRepository.bookingMap.put(booking.toString(), booking);
        return booking;
    }

    private Double getCostAsPerType(VehicleType type) {
        switch (type) {
            case SUV -> {
                return  1000d;
            }
            case VAN -> {
                return 250d;
            }
            case BICYCLE -> {
                return 50d;
            }
            case HATCHBACK -> {
                return 5000d;
            }
            case MOTORCYCLE -> {
                return 200d;
            }
            case SEDAN -> {
                return 2500d;
            }
            case TRUCK -> {
                return 10000d;
            }
            default -> {
                return 250.4d;
            }
        }
    }

    private Vehicle getVehicle(VehicleType type) {
        for(Map.Entry<String, Vehicle> vehicleEntry: InventoryRepository.inventory.entrySet()) {
            if (type.equals(vehicleEntry.getValue().getVehicleType())) {
                if (vehicleEntry.getValue().getAvailable()) {
                    return vehicleEntry.getValue();
                }
            }
        }

        return null;
    }

    @Override
    public Boolean cancelBooking(String bookingId) {
        Booking booking = BookingRepository.bookingMap.get(bookingId);
        booking.setBookingStatus(Status.CANCELLED);
        return true;
    }
}
