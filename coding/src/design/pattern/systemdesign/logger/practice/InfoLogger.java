package design.pattern.systemdesign.logger.practice;

import static design.pattern.systemdesign.logger.practice.LogManager.INFO;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String message, LogSubject logSubject) {
        logSubject.notifyAllObservers(INFO,"INFO: " + message);
    }
}
