package design.pattern.systemdesign.logger.practice;

public class FileLogger implements LogObserver {
    @Override
    public void log(String message) {
        System.out.println("FILE: " + message);
    }
}
