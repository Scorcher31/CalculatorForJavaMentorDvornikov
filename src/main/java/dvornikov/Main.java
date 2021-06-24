package dvornikov;
import java.nio.file.NoSuchFileException;
import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        boolean b = RomanToArabicConverter.isRomanNumber("xix");
        System.out.println(b);
        /*String inputString;
        InputInformation expression;

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
            //
        }*/
    }
}
