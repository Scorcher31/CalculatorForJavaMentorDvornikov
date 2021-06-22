package dvornikov;

public abstract class InputInformation {
    int a;
    int b;
    Operands operand;

    public abstract void getInformationFromInputData() throws CalculatorException;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Operands getOperand() {
        return operand;
    }
}
