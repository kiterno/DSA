package design.pattern.strategy;

public class App {
    public static void main(String[] args) {
        OperationManager manager = new OperationManager();

        manager.setStrategy(new Multiplication());
        manager.execute(10, 20);
    }
}
