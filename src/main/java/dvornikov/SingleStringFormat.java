package dvornikov;

public class SingleStringFormat extends InputInformation {
    private String data;

    public SingleStringFormat(String data){ this.data = data; }

    @Override
    public void getInformationFromInputData() throws CalculatorException {
        String[] expression = separateStrings();
        if(expression.length != 3)
            throw new CalculatorException(CalculatorExceptions.WRONGFORMATOFSTRING);

        checkOperator(expression[1].charAt(0));
        this.a = expression[0];
        this.b = expression[2];
        char operator = expression[1].charAt(0);

        checkOperator(operator);
        CalculatorInputHandler check10 = new CheckTheValueOfOperands(null);
        CalculatorInputHandler checkRoman = new RomanNumeralsChecker(check10);
        CalculatorInputHandler dotCheck = new CheckFraction(checkRoman);
        CalculatorInputHandler negativeCheck = new CheckNegative(dotCheck);
        negativeCheck.currentCheckOrDoing(a);
        a = check10.getOperand();
        boolean aIsArabic = ((RomanNumeralsChecker)checkRoman).isInituallyArabic();
        negativeCheck.currentCheckOrDoing(b);
        b = check10.getOperand();
        boolean bIsArabic = ((RomanNumeralsChecker)checkRoman).isInituallyArabic();
        if(aIsArabic != bIsArabic)
            throw new CalculatorException(CalculatorExceptions.INAPPROPRIATECOMBINATIONOFOPERANDS);
    }

    private String[] separateStrings() {
        data = data.trim();
        data = data.replaceAll("\\s+", " ");
        return data.split(" ");
    }

    private void checkOperator(char operator) throws CalculatorException{
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
