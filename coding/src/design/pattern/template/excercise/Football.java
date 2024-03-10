package design.pattern.template.excercise;

public class Football extends Games {
    @Override
    protected void initialize() {
        System.out.println("Initializing Football game...");
    }

    @Override
    protected void playing() {
        System.out.println("Playing Football game...");
    }

    @Override
    protected void showResults() {

    }
}
