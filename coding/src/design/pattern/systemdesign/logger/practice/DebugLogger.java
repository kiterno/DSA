package design.pattern.systemdesign.logger.practice;

import static design.pattern.systemdesign.logger.practice.LogManager.DEBUG;

public class DebugLogger extends AbstractLogger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        logSubject.notifyAllObservers(DEBUG,"DEBUG: " + message);
    }
}
