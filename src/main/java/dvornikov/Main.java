package dvornikov;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String inputString;

        if (args.length == 1) {
            try {
                Path path = Paths.get(args[0]);
                Scanner fileScanner = new Scanner(path);
                inputString = fileScanner.nextLine();
            } catch (IOException ex) {
                System.out.println("Одиночный аргумент командной строки предполагает запись туда пути до файла с корректными данными.");
                System.exit(1);
            }
        }

        if(args.length == 3) {
            SeparateArgumentsFormat in = new SeparateArgumentsFormat(args);
            try {
                in.getInformationFromInputData();
            } catch(CalculatorException cex) {
                System.out.println(cex.getMessage());
            }
            Calculate calculator = new Calculate(in.getA(), in.getB(), in.getOperator(), in.isArabic);
            String res = calculator.getResult();
            System.out.println(res);
        }
    }
}
