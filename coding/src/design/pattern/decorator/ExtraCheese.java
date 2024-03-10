package design.pattern.decorator;

public class ExtraCheese extends ToppingsDecorator {

    BasePizza basePizza;
    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+50;
    }
}
