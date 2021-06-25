package dvornikov;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputString = "";
        int len = args.length;

        switch (args.length) {
            case 0:
                System.out.println("Введите, пожалуйста, строку вида: a+b или a-b:");
                Scanner in = new Scanner(System.in);
                inputString = in.nextLine();
                break;

            case 1:
                try {
                    Path path = Paths.get(args[0]);
                    Scanner fileScanner = new Scanner(path);
                    inputString = fileScanner.nextLine();
                } catch (IOException ex) {
                    inputString = args[0];
                }
                break;

            case 3:
                InputParser arg = InputParser.getInputParserForSeparateArguments(args);
                break;

            default:
                System.out.print("не работает с этим количеством аргументов.");
                System.exit(1);
        }

        InputParser arg = InputParser.getInputParserForSingleString(inputString);
        try {
            arg.getInformationFromInputData();
        } catch (CalculatorException cex) {
            System.err.println(cex.getMessage());
            System.exit(1);
        }

        Calculate calculator = new Calculate(arg.getA(), arg.getB(), arg.getOperator(), arg.isArabic);
        String res = calculator.getResult();
        System.out.println(res);
        System.exit(0);
    }
}
