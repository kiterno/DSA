package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.User;

public interface PaymentService {
    public boolean pay(Double amount, User user);
}
