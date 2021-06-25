package dvornikov;

public class InputParser {
    private String a;
    private String b;
    private String[] arguments;
    private String data;
    public boolean isArabic = false;
    private final boolean wasSeparateInput;
    private static InputParser in;
    private Operators operator;

    private InputParser(String data) {
        this.data = data;
        wasSeparateInput = false;
    }

    private InputParser(String[] arguments) {
        this.arguments = arguments;
        wasSeparateInput = true;
    }

    public static InputParser getInputParserForSingleString(String data) {
        if (in == null)
            in = new InputParser(data);
        return in;
    }

    public static InputParser getInputParserForSeparateArguments(String[] data) {
        if (in == null)
            in = new InputParser(data);
        return in;
    }

    public int getA() {
        return Integer.parseInt(a);
    }

    public int getB() {
        return Integer.parseInt(b);
    }

    public Operators getOperator() {
        return operator;
    }

    public void getInformationFromInputData() throws CalculatorException {
        if(!wasSeparateInput)
            separateStrings();

        this.a = arguments[0];
        this.b = arguments[2];
        char operator = arguments[1].charAt(0);

        if (arguments.length != 3)
            throw new CalculatorException(CalculatorExceptions.WRONGFORMATOFSTRING);

        checkOperator(operator);
        CalculatorInputHandler check10 = new CheckTheValueOfOperands(null);
        CalculatorInputHandler checkRoman = new RomanNumeralsChecker(check10);
        CalculatorInputHandler dotCheck = new CheckFraction(checkRoman);
        CalculatorInputHandler negativeCheck = new CheckNegative(dotCheck);
        negativeCheck.currentCheckOrDoing(a);
        a = check10.getOperand();
        boolean aIsArabic = ((RomanNumeralsChecker) checkRoman).isInituallyArabic();
        negativeCheck.currentCheckOrDoing(b);
        b = check10.getOperand();
        boolean bIsArabic = ((RomanNumeralsChecker) checkRoman).isInituallyArabic();

        if (aIsArabic != bIsArabic)
            throw new CalculatorException(CalculatorExceptions.INAPPROPRIATECOMBINATIONOFOPERANDS);

        if (aIsArabic)
            isArabic = true;
    }

    private void separateStrings() throws CalculatorException{
        data = data.trim();
        if (data.contains(" ")) {
            data = data.replaceAll("\\s+", " ");
            arguments = data.split(" ");
        } else {
            int pos = findOperator();
            if(pos < 0)
                throw new CalculatorException(CalculatorExceptions.INPUTCONTAINSNOOPERATION);
            arguments = new String[3];
            arguments[0] = data.substring(0, pos);
            arguments[1] = data.substring(pos, pos + 1);
            arguments[2] = data.substring(pos + 1);
        }
    }

    private int findOperator() {
        char[] operators = {'+', '-', '*', '/'};

        for(int i = 0; i < data.length(); i++) {
            for(char op: operators) {
                if(data.charAt(i) == op) return i;
            }
        }
        return -1;
    }

    private void checkOperator(char operator) throws CalculatorException {
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


