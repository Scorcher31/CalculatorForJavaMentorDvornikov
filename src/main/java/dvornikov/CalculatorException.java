package dvornikov;

public class CalculatorException extends Exception {
    CalculatorException(CalculatorExceptions type) {
        super(type.getText());
    }
}
