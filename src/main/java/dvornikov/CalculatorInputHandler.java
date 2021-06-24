package dvornikov;

public abstract class CalculatorInputHandler {
    CalculatorInputHandler successor;
    String operand;

    public String getOperand() {
        return operand;
    }

    CalculatorInputHandler(CalculatorInputHandler successor) {
        this.successor = successor;
    }

    public abstract void currentCheckOrDoing(String operand) throws CalculatorException;
}
