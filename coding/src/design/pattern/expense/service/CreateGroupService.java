package design.pattern.expense.service;

import design.pattern.expense.exception.GroupDoesNotExistException;
import design.pattern.expense.model.Expense;
import design.pattern.expense.model.Group;
import design.pattern.expense.model.User;
import design.pattern.expense.repository.GroupRepository;

import java.util.List;

public class CreateGroupService {

    public Group createGroup(User user, String groupId, String description) {
        Group group = new Group(groupId, description, user);
        GroupRepository.groupMap.put(groupId, group);
        return group;
    }

    public boolean addUserToGroup(String groupId, User user) throws GroupDoesNotExistException {
        if (!GroupRepository.groupMap.containsKey(groupId)) {
            throw new GroupDoesNotExistException("Group does not exist");
        }

        Group group = GroupRepository.groupMap.get(groupId);
        group.addUserInGroup(user);
        return true;
    }

    public boolean recordExpense(String groupId, Expense expense) throws GroupDoesNotExistException {
        if (!GroupRepository.groupMap.containsKey(groupId)) {
            throw new GroupDoesNotExistException("Group does not exist");
        }

        Group group = GroupRepository.groupMap.get(groupId);
        group.addExpenseInGroup(expense);
        return true;
    }
}
