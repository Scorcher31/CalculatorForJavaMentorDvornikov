package dvornikov;

public class CheckTheValueOfOperands extends CalculatorInputHandler {
    CheckTheValueOfOperands(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException {
        int a = Integer.parseInt(operand);
        if(a > 10 || a < 1)
            throw new CalculatorException(CalculatorExceptions.TOOBIGINTEGER);
        if(!successor.equals(null))
            successor.currentCheckOrDoing(operand);
    }
}
