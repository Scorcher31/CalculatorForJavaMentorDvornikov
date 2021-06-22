package dvornikov;

public class ConsoleInput extends InputInformation {
    private final String[] data;
    public ConsoleInput(String[] data) {
        this.data = data;
    }

    @Override
    public void getInformationFromInputData() throws CalculatorException {
        this.a = Integer.parseInt(data[0]);
        this.b = Integer.parseInt(data[2]);
        char operand = data[1].charAt(0);

        switch (operand) {
            case '+':
                this.operand = Operands.ADD;
                break;
            case '-':
                this.operand = Operands.SUBTRACT;
                break;
            case '*':
                this.operand = Operands.MULTIPLY;
                break;
            case '/':
                this.operand = Operands.DIVIDE;
                break;
            default:
                throw new CalculatorException(CalculatorExceptions.INPUTCONTAINSNOOPERATION);
        }
    }

    private boolean containsRomanNumerals(String argument) {
        return true;
    }
}