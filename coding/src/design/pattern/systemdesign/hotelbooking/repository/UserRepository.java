package design.pattern.systemdesign.hotelbooking.repository;

import design.pattern.systemdesign.hotelbooking.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public static Map<String, User> userMap = new HashMap<>();
}
