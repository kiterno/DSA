package design.pattern.expense.model;

import java.util.List;

public class Expense {
    private String expenseId;
    private List<User> involvedUsers;
    private User paidUser;
    private Double amount;
    private Contribution contribution;
    private ExpenseType type;

    public Expense(String expenseId, List<User> involvedUsers, User paidUser, Double amount, ExpenseType type) {
        this.expenseId = expenseId;
        this.involvedUsers = involvedUsers;
        this.paidUser = paidUser;
        this.amount = amount;
        this.type = type;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }
    public String getExpenseId() {
        return expenseId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public List<User> getInvolvedUsers() {
        return involvedUsers;
    }

    public void setInvolvedUsers(List<User> involvedUsers) {
        this.involvedUsers = involvedUsers;
    }

    public User getPaidUser() {
        return paidUser;
    }

    public void setPaidUser(User paidUser) {
        this.paidUser = paidUser;
    }

    public ExpenseType getType() {
        return type;
    }

    public void setType(ExpenseType type) {
        this.type = type;
    }
}
