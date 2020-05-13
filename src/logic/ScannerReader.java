package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReader {
    public static String readTextContent(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        String content = "";
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            content += line+"\n";
        }
        scan.close();
        return content;
    }
}
