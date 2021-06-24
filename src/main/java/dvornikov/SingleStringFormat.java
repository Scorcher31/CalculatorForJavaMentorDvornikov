package dvornikov;

public class SingleStringFormat extends InputInformation {
    private final String[] data;
    public SingleStringFormat(String[] data) {
        this.data = data;
    }

    @Override
    public void getInformationFromInputData() throws CalculatorException {
        this.a = data[0];
        this.b = data[2];
        char operator = data[1].charAt(0);

        checkOperand(operator);
        CalculatorInputHandler check10 = new CheckTheValueOfOperands(null);
        CalculatorInputHandler checkRoman = new RomanNumeralsChecker(check10);
        CalculatorInputHandler dotCheck = new CheckFraction(checkRoman);
        CalculatorInputHandler negativeCheck = new CheckNegative(dotCheck);
        negativeCheck.currentCheckOrDoing(a);
        boolean aIsArabic = ((RomanNumeralsChecker)checkRoman).isInituallyArabic();
        negativeCheck.currentCheckOrDoing(b);
        boolean bIsArabic = ((RomanNumeralsChecker)checkRoman).isInituallyArabic();
        if(aIsArabic != bIsArabic)
            throw new CalculatorException(CalculatorExceptions.INAPPROPRIATECOMBINATIONOFOPERANDS);
    }

    private void checkOperand(char operator) throws CalculatorException{
        switch (operator) {
            case '+':
                this.operator = Operators.ADD;
                break;
            case '-':
                this.operator = Operators.SUBTRACT;
                break;
            case '*':
                this.operator = Operators.MULTIPLY;
                break;
            case '/':
                this.operator = Operators.DIVIDE;
                break;
            default:
                throw new CalculatorException(CalculatorExceptions.INPUTCONTAINSNOOPERATION);
        }
    }
}
