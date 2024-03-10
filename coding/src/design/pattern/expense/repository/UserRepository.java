package design.pattern.expense.repository;

import design.pattern.expense.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    public static Map<String, User> userMap = new HashMap<>();
}
