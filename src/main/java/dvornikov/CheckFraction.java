package dvornikov;

public class CheckFraction extends CalculatorInputHandler{
    CheckFraction(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException{
        for(int i = 0; i < operand.length(); i++) {
            if(operand.charAt(i) == '.' || operand.charAt(i) == ',')
                throw new CalculatorException(CalculatorExceptions.NOTINTEGEROPERAND);
        }
        if(!successor.equals(null))
            successor.currentCheckOrDoing(operand);
    }
}
