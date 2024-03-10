package design.pattern.systemdesign.logger.practice;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.info("This is a test message");
        logger.error("Generating error");
        logger.debug("debugging the code");
    }
}
