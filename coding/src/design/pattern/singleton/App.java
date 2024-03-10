package design.pattern.singleton;

public class App {
    public static void main(String[] args) {
//        DatabaseConnector.getInstance().connect();

        Database.INSTANCE.connect();
    }
}
