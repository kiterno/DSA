package design.pattern.singleton;

//Enums are compile time constants and thread safe
public enum Database {
    INSTANCE;

    public void connect() {
        System.out.println("Connecting to database...");
    }

    public void disconnect() {
        System.out.println("Disconnecting from database...");
    }
}
