package dvornikov;

public abstract class CalculatorInputHandler {
    CalculatorInputHandler successor;

    CalculatorInputHandler(CalculatorInputHandler successor) {
        this.successor = successor;
    }

    public abstract void currentCheckOrDoing(String operand) throws CalculatorException;
}
