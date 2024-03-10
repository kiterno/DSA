package design.pattern.systemdesign.splitwinzo.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Expense {
    private String id;
    private String userId;
    private String title;
    private String description;
    private LocalDateTime expenseDate;
    private ExpenseStatus expenseStatus;
    private double expenseAmount;
    private String expenseGroupId;

    private Map<String, UserShare> userContributions;

    public Map<String, UserShare> getUserContributions() {
        return userContributions;
    }

    public void setUserContributions(Map<String, UserShare> userContributions) {
        this.userContributions = userContributions;
    }

    public Expense() {
        this.userContributions = new HashMap<>();
    }

    public Expense(String id, String userId, String title, String description, LocalDateTime expenseDate, ExpenseStatus expenseStatus, double expenseAmount, String expenseGroupId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.expenseDate = expenseDate;
        this.expenseStatus = expenseStatus;
        this.expenseAmount = expenseAmount;
        this.expenseGroupId = expenseGroupId;
        this.userContributions = new HashMap<>();
    }

    public Expense(Builder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.title = builder.title;
        this.description = builder.description;
        this.expenseDate = builder.expenseDate;
        this.expenseStatus = builder.expenseStatus;
        this.expenseAmount = builder.expenseAmount;
        this.expenseGroupId = builder.expenseGroupId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    public ExpenseStatus getExpenseStatus() {
        return expenseStatus;
    }

    public void setExpenseStatus(ExpenseStatus expenseStatus) {
        this.expenseStatus = expenseStatus;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseGroupId() {
        return expenseGroupId;
    }

    public void setExpenseGroupId(String expenseGroupId) {
        this.expenseGroupId = expenseGroupId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String userId;
        private String title;
        private String description;
        private LocalDateTime expenseDate;
        private ExpenseStatus expenseStatus;
        private double expenseAmount;
        private String expenseGroupId;

        public Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder expenseDate(LocalDateTime expenseDate) {
            this.expenseDate = expenseDate;
            return this;
        }

        public Builder expenseStatus(ExpenseStatus expenseStatus) {
            this.expenseStatus = expenseStatus;
            return this;
        }

        public Builder expenseAmount(double expenseAmount) {
            this.expenseAmount = expenseAmount;
            return this;
        }

        public Builder expenseGroup(String expenseGroupId) {
            this.expenseGroupId = expenseGroupId;
            return this;
        }

        public Expense build() {
            return new Expense(this);
        }
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", expenseDate=" + expenseDate +
                ", expenseStatus=" + expenseStatus +
                ", expenseAmount=" + expenseAmount +
                ", expenseGroup=" + expenseGroupId +
                '}';
    }
}
