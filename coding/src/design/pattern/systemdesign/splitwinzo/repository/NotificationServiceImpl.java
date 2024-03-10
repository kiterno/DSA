package design.pattern.systemdesign.splitwinzo.repository;

import design.pattern.systemdesign.splitwinzo.model.Expense;
import design.pattern.systemdesign.splitwinzo.model.User;

public class NotificationServiceImpl implements NotificationService{
    @Override
    public void notifyUser(User user, Expense expense) {
        System.out.println(user.getName()+" here is your design.pattern.expense="+expense);
    }
}
