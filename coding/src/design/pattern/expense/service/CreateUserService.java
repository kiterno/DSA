package design.pattern.expense.service;

import design.pattern.expense.model.User;
import design.pattern.expense.repository.UserRepository;

public class CreateUserService {
    public void createUser(User user) {
        UserRepository.userMap.put(user.getId(), user);
    }
}
