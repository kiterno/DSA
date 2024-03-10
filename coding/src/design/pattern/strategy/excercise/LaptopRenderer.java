package design.pattern.strategy.excercise;

public class LaptopRenderer implements Renderer {
    @Override
    public void showImage() {
        System.out.println("Showing an image on laptop...");
    }
}
