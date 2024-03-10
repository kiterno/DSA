package design.pattern.systemdesign.logger.practice;

import static design.pattern.systemdesign.logger.practice.LogManager.*;

public class Logger {

    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LogSubject logSubject;


    private Logger () {
        if (logger != null)
            throw new IllegalStateException("Object already created");
    }

    public static Logger getInstance() {
        if (logger == null) {
            synchronized (Logger.class) {
                logger = new Logger();
                chainOfLogger = buildChainOfLogger();
                logSubject = buildSubject();
            }

        }

        return logger;
    }


    public void info(String message) {
        createLog(INFO, message);
    }

    public void debug(String message) {
        createLog(DEBUG, message);
    }

    public void error(String message) {
        createLog(ERROR, message);
    }

    private void createLog (int level, String message) {
        chainOfLogger.logMessage(level, message, logSubject);
    }
}
