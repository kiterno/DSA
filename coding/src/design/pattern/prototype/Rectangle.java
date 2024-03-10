package design.pattern.prototype;

public class Rectangle extends Shape {
    public Rectangle(int width, int height) {
        super(width, height);
    }

    @Override
    public void draw() {
        System.out.println("Rectangle with width = " + width + " height " + height);
    }

    @Override
    public Shape cloneObject() {
        return new Rectangle(width, height);
    }
}
