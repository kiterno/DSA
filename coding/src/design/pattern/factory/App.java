package design.pattern.factory;

public class App {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(AnimalType.DOG);
        assert animal != null;
        animal.eat();
    }
}
