package dvornikov;

public class CheckTheValueOfOperands extends CalculatorInputHandler {
    CheckTheValueOfOperands(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException {
        this.operand = operand;
        int a = Integer.parseInt(operand);
        if(a > 10 || a < 1)
            throw new CalculatorException(CalculatorExceptions.TOOBIGINTEGER);
        if(successor != null)
            successor.currentCheckOrDoing(operand);
        return;
    }
}
