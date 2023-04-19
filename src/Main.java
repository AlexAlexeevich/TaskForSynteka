import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/input.txt");
        Scanner scanner = new Scanner(inputFile);

        int quantityFirstData = scanner.nextInt();
        scanner.nextLine();
        List<String[]> listInputLinesFirstData = new ArrayList<>();
        readLines(scanner, listInputLinesFirstData, quantityFirstData);

        int quantitySecondData = scanner.nextInt();
        scanner.nextLine();
        List<String[]> listInputLinesSecondData = new ArrayList<>();
        readLines(scanner, listInputLinesSecondData, quantitySecondData);

        scanner.close();

        List<String> result = LinesComparison.linesComparison(listInputLinesFirstData, listInputLinesSecondData);

        File outputFile = new File("src/output.txt");
        PrintWriter printWriter = new PrintWriter(outputFile);
        for (String s : result) {
            printWriter.println(s);
        }
        printWriter.close();
    }

    private static void readLines(Scanner scanner, List<String[]> listInputLines, int quantity) {
        for (int i = 0; i < quantity; i++) {
            listInputLines.add(scanner.nextLine().split(" "));
        }
    }
}