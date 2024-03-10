package design.pattern.template.excercise;

public abstract class Games {
    protected abstract void initialize();
    protected abstract void playing();
    protected abstract void showResults();

    public final void play(){
        initialize();
        playing();
        showResults();
    }
}
