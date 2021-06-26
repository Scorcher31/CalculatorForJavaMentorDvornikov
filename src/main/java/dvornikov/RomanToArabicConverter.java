package dvornikov;

public class RomanToArabicConverter {
    private static String romanNumerals = "MDCLXVI";

    public static boolean isRomanNumber(String operand) {
        operand = operand.toUpperCase();
        return operand.matches("^[MDCLXVI]*$");
    }

    public static boolean isArabicNumber(String operand) {
        return operand.matches("^[0-9]+$");
    }

    public static String RomanToArabic(String operand) throws CalculatorException {
        int sum = 0;
        int curSym = 0;
        RomanNumerals[] rn = RomanNumerals.getContainedValues();

        operand = operand.trim().toUpperCase();
        while(curSym < rn.length) {
            RomanNumerals symbol = rn[curSym];
            if(operand.startsWith(symbol.name())) {
                sum += symbol.getValue();
                operand = operand.substring(symbol.name().length());
            } else {
                curSym++;
            }
        }

        if(operand.length() > 0)
            throw new CalculatorException(CalculatorExceptions.NOTANUMBER);
        return Integer.toString(sum);
    }

    public static String arabicToRoman(int number) {
        RomanNumerals[] rn = RomanNumerals.getContainedValues();
        int curSym = 0;
        StringBuilder sb = new StringBuilder();
        if(number == 0)
            return("N");

        if(number < 0) {
            sb.append('-');
            number *= -1;
        }
        while ((number > 0) && (curSym < rn.length)) {
            RomanNumerals symbol = rn[curSym];
            if(symbol.getValue() <= number) {
                sb.append(symbol.name());
                number -= symbol.getValue();
            } else {
                curSym++;
            }
        }
        return  sb.toString();
    }
}
