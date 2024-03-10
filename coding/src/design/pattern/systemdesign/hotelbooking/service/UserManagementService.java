package design.pattern.systemdesign.hotelbooking.service;

import design.pattern.systemdesign.hotelbooking.model.User;
import design.pattern.systemdesign.hotelbooking.repository.UserRepository;

public class UserManagementService {
    public void createUser(User user) {
        UserRepository.userMap.put(user.getUserId(), user);
    }
}
