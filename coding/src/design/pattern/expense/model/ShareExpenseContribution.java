package design.pattern.expense.model;

import java.util.Map;

public class ShareExpenseContribution implements ExpenseContribution{
    public Contribution splitExpense(User paidUser, Double amount, Map<String, Integer> shareDetails) {
        Contribution contribution = new Contribution();

        int totalShare = 0;
        for (Integer i: shareDetails.values()) totalShare += i;

        if (totalShare == 0) {
            throw new RuntimeException("Total share value cannot be 0");
        }

        Double perShareAmount = amount/totalShare;
        for (Map.Entry<String, Integer> share: shareDetails.entrySet()) {

            if (share.getKey().equalsIgnoreCase(paidUser.getId())) {
                contribution.getContributionMap().put(share.getKey(), -amount + share.getValue()*perShareAmount);
            } else {
                contribution.getContributionMap().put(share.getKey(), share.getValue()*perShareAmount);
            }
        }

        if (!contribution.getContributionMap().containsKey(paidUser.getId())) {
            contribution.getContributionMap().put(paidUser.getId(), -amount);
        }

        return contribution;
    }
}
