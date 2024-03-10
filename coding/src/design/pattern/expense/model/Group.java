package design.pattern.expense.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupId;
    private String description;

    private List<User> users;
    private List<Expense> expenseList;

    public Group(String groupId, String description, User adminUser) {
        this.groupId = groupId;
        this.description = description;
        users = new ArrayList<>();
        expenseList = new ArrayList<>();
        users.add(adminUser);
    }


    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public void addUserInGroup(User user) {
        users.add(user);
    }

    public void addExpenseInGroup(Expense expense) {
        expenseList.add(expense);
    }
}
