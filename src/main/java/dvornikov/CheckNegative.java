package dvornikov;

public class CheckNegative extends CalculatorInputHandler{

    CheckNegative(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException {
        if(operand.charAt(0) == '-') throw new CalculatorException(CalculatorExceptions.NEGATIVEORNULLNUMBER);
        if(!successor.equals(null))
            successor.currentCheckOrDoing(operand);
    }

}
