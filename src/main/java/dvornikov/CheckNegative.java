package dvornikov;

public class CheckNegative extends CalculatorInputHandler{

    CheckNegative(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException {
        this.operand = operand;
        if(operand.charAt(0) == '-') throw new CalculatorException(CalculatorExceptions.NEGATIVEORNULLNUMBER);
        if(successor != null)
            successor.currentCheckOrDoing(operand);
        return;
    }

}
