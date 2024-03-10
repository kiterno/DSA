package design.pattern.template.excercise;

public class Basketball extends Games {
    @Override
    protected void initialize() {
        System.out.println("Initializing Basketball game...");
    }

    @Override
    protected void playing() {
        System.out.println("Playing Basketball game...");
    }

    @Override
    protected void showResults() {

    }
}
