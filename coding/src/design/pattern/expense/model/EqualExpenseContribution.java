package design.pattern.expense.model;

import java.util.List;
import java.util.Map;

public class EqualExpenseContribution implements ExpenseContribution {
    public Contribution splitExpense(List<User> involvedUsers, User paidUser, Double amount) {
        Contribution contribution = new Contribution();

        int totalUsers = involvedUsers.size();
        Double eachShare = amount/totalUsers;

        for (User user: involvedUsers) {
            if(user.getId().equalsIgnoreCase(paidUser.getId())) {
                contribution.getContributionMap().put(paidUser.getId(), eachShare-amount);
            } else {
                contribution.getContributionMap().put(user.getId(), eachShare);
            }
        }

        return contribution;
    }

}
