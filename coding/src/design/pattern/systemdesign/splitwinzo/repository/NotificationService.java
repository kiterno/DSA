package design.pattern.systemdesign.splitwinzo.repository;

import design.pattern.systemdesign.splitwinzo.model.Expense;
import design.pattern.systemdesign.splitwinzo.model.User;

public interface NotificationService {
    public void notifyUser(User user, Expense expense);
}
