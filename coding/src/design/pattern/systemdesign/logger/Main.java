package design.pattern.systemdesign.logger;

public class Main {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));


        logProcessor.log(LogProcessor.ERROR, "exception handler");
        logProcessor.log(LogProcessor.INFO, "exception handler");
        logProcessor.log(LogProcessor.ERROR, "exception handler");
    }
}
