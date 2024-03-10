package design.pattern.systemdesign.splitwinzo.service;

import design.pattern.systemdesign.splitwinzo.exceptions.ExpenseDoesNotExistsException;
import design.pattern.systemdesign.splitwinzo.model.*;
import design.pattern.systemdesign.splitwinzo.repository.ExpenseRepository;
import design.pattern.systemdesign.splitwinzo.repository.NotificationService;
import design.pattern.systemdesign.splitwinzo.repository.NotificationServiceImpl;
import design.pattern.systemdesign.splitwinzo.repository.UserInGroupRepository;
import design.pattern.systemdesign.splitwinzo.util.ContributionCreator;

import java.time.LocalDateTime;
import java.util.*;

public class ExpenseService {
    private final NotificationService notificationService = new NotificationServiceImpl();
    private final ContributionCreator contributionCreator = new ContributionCreator();

    public Expense createExpense(String title, String description, LocalDateTime expenseDate, double expenseAmount,
                                 String userId, String groupId) {
        Expense expense = Expense.builder()
                .id(UUID.randomUUID().toString())
                .title(title)
                .description(description)
                .expenseDate(expenseDate)
                .expenseAmount(expenseAmount)
                .userId(userId)
                .expenseStatus(ExpenseStatus.CREATED)
                .expenseGroup(groupId)
                .build();

        Set<Expense> expenseSet = ExpenseRepository.expenseMap.getOrDefault(groupId, new HashSet<>());
        expenseSet.add(expense);
        ExpenseRepository.expenseMap.put(groupId, expenseSet);

        return expense;
    }

    public void addUserToExpense(List<User> paidUser, List<User> usersInvolved, List<Double> amountPaid, Expense expense) {
        try {
            if (!ExpenseRepository.expenseMap.containsKey(expense.getExpenseGroupId())) {
                throw new ExpenseDoesNotExistsException("Better create design.pattern.expense and come here....");
            }
            Map<String, UserShare> userShareMap = contributionCreator.create(paidUser, usersInvolved, amountPaid, expense.getExpenseAmount());
            expense.setUserContributions(userShareMap);
        } catch (ExpenseDoesNotExistsException e) {
            System.out.println(e.getMessage());

        }
    }

    public void setExpenseStatus(String groupId, String expenseId, ExpenseStatus expenseStatus) {
        for (Expense expense: ExpenseRepository.expenseMap.get(groupId)) {
            if (expense.getId().equals(expenseId))
                expense.setExpenseStatus(expenseStatus);
        }
    }

    public void settleAllExperimentInGroup(Group group) {
        Set<Expense> allUnsettledExpenses = ExpenseRepository.expenseMap.get(group.getGroupId());

        Set<User> usersInGroup = UserInGroupRepository.userInGroup.get(group.getGroupId());
        Map<String, Double> amountUserMap = new HashMap<>();
        for (User user: usersInGroup) {
            amountUserMap.put(user.getEmailId(), 0.0);
        }

        for (Expense expense: allUnsettledExpenses) {
            for(Map.Entry<String, UserShare> share: expense.getUserContributions().entrySet()) {
                amountUserMap.put(share.getKey(), amountUserMap.get(share.getKey()) + share.getValue().getShare());
            }
            expense.setExpenseStatus(ExpenseStatus.SETTLED);

            if (ExpenseRepository.settledExpenseMap.containsKey(group.getGroupId())) {
                ExpenseRepository.settledExpenseMap.get(group.getGroupId()).add(expense);
            } else {
                Set<Expense> set = new HashSet<>();
                set.add(expense);
                ExpenseRepository.settledExpenseMap.put(group.getGroupId(), set);
            }
        }

        for (Expense expense: ExpenseRepository.settledExpenseMap.get(group.getGroupId())) {
            ExpenseRepository.expenseMap.get(group.getGroupId()).remove(expense);
        }

        double amount = 0;
        String email = "";
        System.out.println(amountUserMap);
        for (Map.Entry<String, Double> entry: amountUserMap.entrySet()) {
            if (email.isEmpty()) {
                email = entry.getKey();
                amount = entry.getValue();
            }
            else {
                System.out.println();
                if (amount>entry.getValue()) {
                    System.out.println(entry.getKey() + " should pay " + email + " amount = " + Math.abs(entry.getValue()));
                    amount += entry.getValue();
                } else {
                    System.out.println(email + " should pay " + entry.getKey() + " amount = " + Math.abs(amount));
                    amount += entry.getValue();
                    email = entry.getKey();
                }
            }
        }
    }
}
