package design.pattern.systemdesign.splitwinzo.repository;

import design.pattern.systemdesign.splitwinzo.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserInGroupRepository {
    // group id is the key
    public static Map<String, Set<User>> userInGroup = new HashMap<>();
}
