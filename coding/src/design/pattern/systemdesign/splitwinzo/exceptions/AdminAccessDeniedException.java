package design.pattern.systemdesign.splitwinzo.exceptions;

public class AdminAccessDeniedException extends Exception {
    public AdminAccessDeniedException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
