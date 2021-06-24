package dvornikov;

public class RomanNumeralsChecker extends CalculatorInputHandler {
    private boolean isInituallyArabic = true;

    public boolean isInituallyArabic() {
        return isInituallyArabic;
    }

    RomanNumeralsChecker(CalculatorInputHandler successor) {
        super(successor);
    }

    @Override
    public void currentCheckOrDoing(String operand) throws CalculatorException {
        this.operand = operand;
        if(RomanToArabicConverter.isRomanNumber(operand)) {
            isInituallyArabic = false;
            operand = RomanToArabicConverter.RomanToArabic(operand);
        }
        else if(RomanToArabicConverter.isArabicNumber(operand)) {
            isInituallyArabic = true;
        } else {
            throw new CalculatorException(CalculatorExceptions.NOTANUMBER);
        }
        if(!successor.equals(null))
            successor.currentCheckOrDoing(operand);
        return;
    }
}
