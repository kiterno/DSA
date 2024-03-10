package design.pattern.strategy.excercise;

public class TVRenderer implements Renderer {
    @Override
    public void showImage() {
        System.out.println("Showing an image on TV...");
    }
}
