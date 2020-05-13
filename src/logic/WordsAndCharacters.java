package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public abstract class WordsAndCharacters {
    public static final String[] POLISH_ALPHABET = {"a", "ą", "b", "c", "ć", "d", "e", "ę",
                                                    "f", "g", "h", "i", "j", "k", "l", "ł",
                                                    "m", "n", "ń", "o", "ó", "p", "r", "s",
                                                    "ś", "t", "u", "w", "y", "z", "ź", "ż"};
    public static void countCharactersAndShowDiagram(String content){
        int[] counters = countCharactersInString(content);
        for(int i=0; i<POLISH_ALPHABET.length;i++){
            System.out.printf("\n" + POLISH_ALPHABET[i] + " - " + counters[i] + "\t");
            for(int j=0; j<counters[i]; j++){
                if(j==50) break; // wyswietl maksymalnie 50 gwiazdek
                System.out.printf("*");
            }
        }
    }

    public static int[] countCharactersInString(String content) {
        int[] counters = new int[POLISH_ALPHABET.length];
        ArrayList<String> characters = new ArrayList<>();
        //zbuduj listę z wszystkimi literami z podanego ciągu znaków
        for(int i=0; i<content.length();i++){
            String c = String.valueOf(content.charAt(i)).toLowerCase();
            characters.add(c);
        }
        for(int i=0; i<POLISH_ALPHABET.length;i++){
            counters[i] = Collections.frequency(characters, POLISH_ALPHABET[i]);
        }
        return counters;
    }

    public static void countWordsInString(String content){
        String[] words = content.split("[ .,!\\n]+");
        TreeSet<Integer> allWordsLengths = new TreeSet<>();
        for(String word: words){
            allWordsLengths.add(word.length());
        }
        int[] wordsCounters = new int[allWordsLengths.size()];
        for(String word: words){
            int iterator=-1;
            for(int wordLenght: allWordsLengths){
                iterator++;
                if(word.length() == wordLenght) wordsCounters[iterator]++;
            }
        }
        System.out.println("\nLicznik słów w tekście");
        int iterator=-1;
        for(int wordLenght: allWordsLengths){
            iterator++;
            System.out.println("Słowo z długością:\t" + wordLenght +
                                ",\twystępuje w tekście:\t" + wordsCounters[iterator] + "x");
        }
    }
}
