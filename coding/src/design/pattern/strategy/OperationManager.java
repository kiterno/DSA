package design.pattern.strategy;

public class OperationManager {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute(int n1, int n2) {
        System.out.println(this.strategy.execute(n1, n2));
    }
}
