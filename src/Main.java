import logic.WordsAndCharacters;
import logic.ScannerReader;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        //Wczytaj zawartość pliku
        String contentOfBook = "Blank";
        try {
            contentOfBook = ScannerReader.readTextContent("ksiega.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Wyświetl zawartość pliku
        System.out.println(contentOfBook);
        //Policz ilość wystąpień liter polskiego aflabetu i wyświetl prosty diagram
        WordsAndCharacters.countCharactersAndShowDiagram(contentOfBook);
        //Policz ilość wystąpień słów w tekście o określonej długości
        WordsAndCharacters.countWordsInString(contentOfBook);
    }
}
