package design.pattern.systemdesign.splitwinzo.service;


import design.pattern.systemdesign.splitwinzo.exceptions.AdminAccessDeniedException;
import design.pattern.systemdesign.splitwinzo.exceptions.GroupNotFoundException;
import design.pattern.systemdesign.splitwinzo.model.Group;
import design.pattern.systemdesign.splitwinzo.model.User;
import design.pattern.systemdesign.splitwinzo.repository.UserInGroupRepository;
import design.pattern.systemdesign.splitwinzo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class UserService {
    public void createUser(String emailId, String name, String phoneNumber) {
        User user = new User(emailId, name, phoneNumber);
        UserRepository.userHashMap.putIfAbsent(emailId, user);
    }

    public Group createGroup(User user) {
        Group group = new Group();
        Set<User> set = new HashSet<>();
        set.add(user);
        UserInGroupRepository.userInGroup.put(group.getGroupId(), set);

        return group;
    }

    public void addUserToGroup(User admin, String groupId, User user) {
        try {
            if (!UserInGroupRepository.userInGroup.containsKey(groupId)) {
                throw new GroupNotFoundException("Unable to find group with id=" + groupId);
            }
            if (!UserInGroupRepository.userInGroup.get(groupId).contains(admin)) {
                throw new AdminAccessDeniedException("User=" + admin.getName() + " is not an admin of the group=" + groupId);
            }

            UserInGroupRepository.userInGroup.get(groupId).add(user);

        } catch (AdminAccessDeniedException e) {
            System.out.println(e.getMessage());
        } catch (GroupNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
