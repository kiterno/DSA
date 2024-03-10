package design.pattern.systemdesign.splitwinzo;

import design.pattern.systemdesign.splitwinzo.exceptions.*;
import design.pattern.systemdesign.splitwinzo.model.*;
import design.pattern.systemdesign.splitwinzo.repository.ExpenseRepository;
import design.pattern.systemdesign.splitwinzo.repository.UserRepository;
import design.pattern.systemdesign.splitwinzo.service.ExpenseService;
import design.pattern.systemdesign.splitwinzo.service.UserService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BillSharingMain {
    static UserService userService;
    static ExpenseService expenseService;

    public static void main(String[] args) throws ContributionExceededException, InvalidExpenseState,
            ExpenseSettledException {

        userService = new UserService();
        expenseService = new ExpenseService();
        createTestUsers();

        User bagesh = UserRepository.userHashMap.get("bagesh@gmail.com");
        User ajay = UserRepository.userHashMap.get("ajay@gmail.com");
        User amit = UserRepository.userHashMap.get("amit@gmail.com");
        User kamal = UserRepository.userHashMap.get("kamal@gmail.com");

        Group group = userService.createGroup(bagesh);

        userService.addUserToGroup(bagesh, group.getGroupId(), ajay);
        userService.addUserToGroup(bagesh, group.getGroupId(), amit);
        userService.addUserToGroup(bagesh, group.getGroupId(), kamal);

        Expense expense = createLunchExpense(ajay, group);

        List<User> paidUsers = new ArrayList<>();
        List<User> involvedUsers = new ArrayList<>();
        List<Double> amountPaid = new ArrayList<>();
        paidUsers.add(ajay);paidUsers.add(kamal);
        involvedUsers.add(amit);involvedUsers.add(ajay);involvedUsers.add(kamal);involvedUsers.add(bagesh);
        amountPaid.add(600d);
        amountPaid.add(400d);

        addUserToExpense(paidUsers, involvedUsers, amountPaid, expense);

        Expense dinnerExpense = createDinnerExpense(kamal, group);
        List<User> paidUser = new ArrayList<>();
        paidUser.add(kamal);paidUser.add(ajay);
        List<User> involvedUser = new ArrayList<>();
        involvedUser.add(bagesh); involvedUser.add(kamal); involvedUser.add(ajay);
        List<Double> amountPaid1 = new ArrayList<>();
        amountPaid1.add(1000d);amountPaid1.add(1000d);
        addUserToExpense(paidUser, involvedUser, amountPaid1, dinnerExpense);

//        System.out.println("\nUsers in Group = " + group.getGroupId());
//        System.out.println(UserInGroupRepository.userInGroup.get(group.getGroupId()));
//
//        System.out.println("\nUnsettled Expenses in Group = " + group.getGroupId());
//        System.out.println(ExpenseRepository.expenseMap.get(group.getGroupId()));
//
//        System.out.println("\n\n Users shares in an design.pattern.expense ");
//        System.out.println(design.pattern.expense.getUserContributions());
//        System.out.println(dinnerExpense.getUserContributions());
//
//        System.out.println("\nMark created expenses to sattled");

        expenseService.setExpenseStatus(expense.getExpenseGroupId(), expense.getId(), ExpenseStatus.PENDING);
        expenseService.setExpenseStatus(dinnerExpense.getExpenseGroupId(), dinnerExpense.getId(), ExpenseStatus.PENDING);

//        System.out.println("\nPENDING Expenses in Group = " + group.getGroupId());
//        System.out.println(ExpenseRepository.expenseMap.get(group.getGroupId()));
        
        displayAllExpensesInAGroup(group);

        expenseService.settleAllExperimentInGroup(group);

        System.out.println("\nBye......");
    }

    private static void displayAllExpensesInAGroup(Group group) {
        for (Expense expense: ExpenseRepository.expenseMap.get(group.getGroupId())) {
            System.out.println(expense.getUserContributions());
        }
    }

    private static void createTestUsers() {
        userService.createUser("bagesh@gmail.com", "bagesh", "3486199635");
        userService.createUser("ajay@gmail.com", "ajay", "6112482630");
        userService.createUser("amit@gmail.com", "amit", "2509699232");
        userService.createUser("kamal@gmail.com", "kamal", "5816355154");
        userService.createUser("neha@gmail.com", "neha", "7737316054");
        userService.createUser("kajal@gmail.com", "kajal", "4813053349");
        userService.createUser("jyothi@gmail.com", "jyothi", "3974178644");
        userService.createUser("subin@gmail.com", "subin", "4768463294");
        userService.createUser("deepak@gmail.com", "deepak", "4829338803");
        userService.createUser("vishnu@gmail.com", "vishnu", "3384071602");
        userService.createUser("mayank@gmail.com", "mayank", "2376951206");
        userService.createUser("anu@gmail.com", "anu", "8478577491");
        userService.createUser("kavya@gmail.com", "kavya", "7505888698");
        userService.createUser("divya@gmail.com", "divya", "9587030077");
        userService.createUser("prabhu@gmail.com", "prabhu", "3303167757");
        userService.createUser("sangeeth@gmail.com", "sangeeth", "7409081739");
        userService.createUser("rajesh@gmail.com", "rajesh", "2367659285");
        userService.createUser("alamelu@gmail.com", "alamelu", "8938025834");
        userService.createUser("aruna@gmail.com", "aruna", "8189506064");
        userService.createUser("palani@gmail.com", "palani", "2973733105");
    }

    public static Expense createLunchExpense(User creator, Group group) {
        return expenseService.createExpense("Team Lunch",
                "Friday 19Th June Lunch in Briyani zone"
                , LocalDateTime.of(2020, Month.JUNE, 19, 12, 0),
                1000.00, creator.getEmailId(), group.getGroupId());
    }

    public static Expense createDinnerExpense(User creator, Group group) {
        return expenseService.createExpense("Team Dinner",
                "Monday 25Th June Dinner at Gamla boys house restraunt"
                , LocalDateTime.of(2021, Month.DECEMBER, 19, 12, 0),
                2000.00, creator.getEmailId(), group.getGroupId());
    }

    private static void addUserToExpense(List<User> paidUser, List<User> usersInvolved, List<Double> amountPaid, Expense expense) {
        expenseService.addUserToExpense(paidUser, usersInvolved, amountPaid, expense);
    }
}
