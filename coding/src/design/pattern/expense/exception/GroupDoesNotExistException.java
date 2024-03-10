package design.pattern.expense.exception;

public class GroupDoesNotExistException extends Exception {
    public GroupDoesNotExistException(String message) {
        super(message);
    }
}
