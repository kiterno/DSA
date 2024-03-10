package design.pattern.singleton;

public class  DatabaseConnector {
    private static DatabaseConnector INSTANCE;

    public static DatabaseConnector getInstance() {
        if (INSTANCE == null){
            // 100x slower
            synchronized (DatabaseConnector.class) {
                INSTANCE = new DatabaseConnector();
            }
        }
        return INSTANCE;
    }

    private DatabaseConnector() {

    }
    public void connect() {
        System.out.println("Connecting to database...");
    }

    public void disconnect() {
        System.out.println("Disconnecting from database...");
    }
}
