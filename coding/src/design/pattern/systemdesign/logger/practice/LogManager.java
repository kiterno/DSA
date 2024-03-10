package design.pattern.systemdesign.logger.practice;

public class LogManager {
    protected static final int INFO = 1;
    protected static final int DEBUG = 2;
    protected static final int ERROR = 3;
    protected static AbstractLogger buildChainOfLogger() {
        AbstractLogger infoLogger = new InfoLogger(INFO);
        AbstractLogger debugLogger = new DebugLogger(DEBUG);
        AbstractLogger errorLogger = new ErrorLogger(ERROR);


        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        return infoLogger;
    }

    protected static LogSubject buildSubject() {
        LogSubject logSubject = new LogSubject();

        ConsoleLogger consoleLogger = new ConsoleLogger();
        FileLogger fileLogger = new FileLogger();

        logSubject.addObserver(INFO, consoleLogger);
        logSubject.addObserver(DEBUG, fileLogger);
        logSubject.addObserver(ERROR, consoleLogger);
        logSubject.addObserver(ERROR, fileLogger);

        return logSubject;
    }
}
