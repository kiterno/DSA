package design.pattern.systemdesign.carRentals.repository;


import design.pattern.systemdesign.carRentals.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public static Map<String, User> userMap = new HashMap<>();
}
