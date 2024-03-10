package design.pattern.systemdesign.splitwinzo.repository;


import design.pattern.systemdesign.splitwinzo.model.Expense;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExpenseRepository {
    // Set of design.pattern.expense in a group
    public static Map<String, Set<Expense>> expenseMap = new HashMap<>();
    public static Map<String, Set<Expense>> settledExpenseMap = new HashMap<>();

}
