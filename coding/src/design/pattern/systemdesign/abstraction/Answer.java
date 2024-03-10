package design.pattern.systemdesign.abstraction;


public abstract class Answer<T> {
    private T value;

    private AnswerType answerType;

    public AnswerType getAnswerType() {
        return answerType;
    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public String getAnswer() {

        if (this.answerType == AnswerType.FLOAT) {
            return "Akash";
        }
        return null;
    }


}
