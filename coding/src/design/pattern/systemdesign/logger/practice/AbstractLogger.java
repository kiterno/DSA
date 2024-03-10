package design.pattern.systemdesign.logger.practice;

public abstract class AbstractLogger {

    int level;
    private AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message, LogSubject logSubject) {
        if (this.level == level) {
            display(message, logSubject);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message, logSubject);
        }
    }

    protected abstract void display(String message, LogSubject logSubject);

}
