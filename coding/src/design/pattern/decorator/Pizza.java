package design.pattern.decorator;

public class Pizza {

    public static void main(String[] args) {
        BasePizza basePizza = new MaxicanGreenWave();
        System.out.println(basePizza.cost());
        basePizza = new ExtraCheese(basePizza);
        System.out.println(basePizza.cost());

        basePizza = new Mushroom(basePizza);
        System.out.println(basePizza.cost());
        basePizza = new Mushroom(new ExtraCheese(basePizza));
        System.out.println(basePizza.cost());
    }
}
