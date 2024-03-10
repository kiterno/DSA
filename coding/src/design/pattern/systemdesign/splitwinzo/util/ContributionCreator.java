package design.pattern.systemdesign.splitwinzo.util;

import design.pattern.systemdesign.splitwinzo.model.User;
import design.pattern.systemdesign.splitwinzo.model.UserShare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContributionCreator {
    public Map<String, UserShare> create(List<User> paidUser, List<User> usersInvolved, List<Double> amountPaid, double expenseAmount) {
        double average = expenseAmount/usersInvolved.size();

        Map<String, UserShare> userShareMap = new HashMap<>();
        paidUsersShares(paidUser, amountPaid, average, userShareMap);
        remainingUserShares(usersInvolved, average, userShareMap);

        return userShareMap;
    }

    private void remainingUserShares(List<User> usersInvolved, double average, Map<String, UserShare> userShareMap) {
        for(User user: usersInvolved) {
            if (!userShareMap.containsKey(user.getEmailId())) {
                UserShare userShare = new UserShare( user.getEmailId(), -average);
                userShareMap.put(user.getEmailId(), userShare);
            }
        }
    }

    private static void paidUsersShares(List<User> paidUser, List<Double> amountPaid, double average, Map<String, UserShare> userShareMap) {
        for (int i = 0; i < paidUser.size(); i++) {
            String userId = paidUser.get(i).getEmailId();

            UserShare userShare = new UserShare( userId, amountPaid.get(i)- average);

            userShareMap.put(userId, userShare);
        }
    }
}
