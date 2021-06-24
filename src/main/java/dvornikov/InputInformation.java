package dvornikov;

public abstract class InputInformation {
    String a;
    String b;
    boolean isArabic = false;

    Operators operator;

    public abstract void getInformationFromInputData() throws CalculatorException;

    public int getA() {
        return Integer.parseInt(a);
    }

    public int getB() {
        return Integer.parseInt(b);
    }

    public Operators getOperator() {
        return operator;
    }
}
