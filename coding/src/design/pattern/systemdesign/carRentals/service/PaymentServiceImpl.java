package design.pattern.systemdesign.carRentals.service;

import design.pattern.systemdesign.carRentals.model.User;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean pay(Double amount, User user) {
        System.out.println(String.format("Payment of %s has been made by user %s", amount, user.getFirstName()));
        return true;
    }
}
