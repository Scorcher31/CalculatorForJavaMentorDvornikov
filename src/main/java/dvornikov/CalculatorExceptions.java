package dvornikov;

public enum CalculatorExceptions {
    NOSECONDOPERAND("В строке отсутствует второй операнд"),
    TOOBIGINTEGER("Вы ввели число больше 10.\nПрограмма работает только с натуральными числами меньшими или равными 10."),
    NOTINTEGEROPERAND("Одно из введёных чисел не целое. Программа работает только с целыми числами."),
    INAPPROPRIATECOMBINATIONOFOPERANDS("Программа не может работать одновременно с арабскими и римскими числами.\nНеправильно: VII - 2\nПравильно: 7 - 2 либо VII - II"),
    NEGATIVEORNULLNUMBER("Вы ввели нуль, либо отрицательное число. \nПрограмма работает только с натуральными числами меньшими или равными 10."),
    INPUTCONTAINSNOOPERATION("Введённая вами строка не содержит оператора арифметического действия."),
    NOTANUMBER("Один из введённых вами операндов не является числом.");

    private String text;

    private CalculatorExceptions(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
