package design.pattern.systemdesign.abstraction;

public class FloatAnswer extends Answer<Float>{
    public float floatValue;

    public float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
    }

    public static void main(String[] args) {
        FloatAnswer floatAnswer = new FloatAnswer();
        if (floatAnswer.getAnswerType() == AnswerType.FLOAT) {

        }
    }
}
