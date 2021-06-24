package dvornikov;

public class Calculate {
    private int a;
    private int b;
    private Operators operator;
    boolean isArabic = true;

    public Calculate() {}

    public Calculate(int a, int b, Operators operator, boolean isArabic) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.isArabic = isArabic;
    }

    public String getResult() {
        int result;
        if(operator != null) {
            switch (operator) {
                case ADD:
                    result = add(a, b);
                    break;
                case SUBTRACT:
                    result = subtract(a, b);
                    break;
                case MULTIPLY:
                    result = multiply(a, b);
                    break;
                case DIVIDE:
                    try {
                        result = divide(a, b);
                    } catch(ArithmeticException a) {
                        return "Деление на ноль";
                    }
                    break;
                default:
                    result = 0;
            }
            if(!isArabic) {
                return RomanToArabicConverter.arabicToRoman(result);
            }
            return Integer.toString(result);
        }
        return "результата нет, т.к. не задан оператор";
    }

    public int add(int a, int b)
    {
        return a + b;
    }

    public int subtract(int a, int b)
    {
        return a - b;
    }

    public int multiply(int a, int b)
    {
        return a * b;
    }

    public int divide(int a, int b) throws ArithmeticException
    {
        return a/b;
    }
}
