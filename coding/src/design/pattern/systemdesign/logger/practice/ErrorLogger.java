package design.pattern.systemdesign.logger.practice;

import static design.pattern.systemdesign.logger.practice.LogManager.ERROR;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        logSubject.notifyAllObservers(ERROR,"ERROR: " + message);
    }
}
