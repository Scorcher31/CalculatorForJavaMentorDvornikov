package dvornikov;

public abstract class InputInformation {
    String a;
    String b;
    Operators operator;

    public abstract void getInformationFromInputData() throws CalculatorException;

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public Operators getOperator() {
        return operator;
    }
}
