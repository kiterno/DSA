package design.pattern.expense.model;

import java.util.List;
import java.util.Map;

public class ExactExpenseContribution implements ExpenseContribution {

    public Contribution splitExpense(List<User> involvedUsers, User paidUser, Double amount, Map<String, Double> shareDetails) {
        Contribution contribution = new Contribution();

        for (Map.Entry<String, Double> share: shareDetails.entrySet()) {
            contribution.getContributionMap().put(share.getKey(), share.getValue());
        }

        if (!contribution.getContributionMap().containsKey(paidUser.getId())) {
            contribution.getContributionMap().put(paidUser.getId(), -amount);
        }

        return contribution;
    }
}
