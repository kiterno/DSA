package design.pattern.strategy;

public class Multiplication implements Strategy {
    @Override
    public int execute(int n1, int n2) {
        return n1 * n2;
    }
}
