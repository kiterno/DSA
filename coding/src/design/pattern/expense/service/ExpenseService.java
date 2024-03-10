package design.pattern.expense.service;

import design.pattern.expense.model.Expense;
import design.pattern.expense.model.ExpenseType;
import design.pattern.expense.model.User;

import java.util.List;
import java.util.Map;

public class ExpenseService {
//    public Expense createExpense(String expenseId, User paidUser, Double amount, ExpenseType type, Map<String, Integer> shareDetails) {
//
//    }
}

/*

a -> b
b -> c
a -> c


a b c d
a - 500 - d
b, c -- 200 - d

[a, b, c, d]
[500, 200, 200, -900]

 i - 0
b = arr[i+1] + arr[i];
a = arr[i] = 0;


a = 500 -> b
b -> 700
b -> 700 -> c
c --> 900
c --> 900 --> d

d = 0;


 */