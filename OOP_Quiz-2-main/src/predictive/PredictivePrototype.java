package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * The PredictivePrototype class provides basic functionality for
 * a predictive text system using numeric signatures for words.
 */
public class PredictivePrototype {

    /**
     * Converts a word into its numeric signature based on the T9 keypad layout.
     * Non-alphabetic characters are replaced with a space (' ').
     *
     * @param word the word to convert into a numeric signature
     * @return the numeric signature of the word as a String
     */
    public static String wordToSignature(String word) {
        StringBuffer signature = new StringBuffer();
        String lowerCaseWord = word.toLowerCase();

        for (char c : lowerCaseWord.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("abc".indexOf(c) != -1) {
                    signature.append("2");
                } else if ("def".indexOf(c) != -1) {
                    signature.append("3");
                } else if ("ghi".indexOf(c) != -1) {
                    signature.append("4");
                } else if ("jkl".indexOf(c) != -1) {
                    signature.append("5");
                } else if ("mno".indexOf(c) != -1) {
                    signature.append("6");
                } else if ("pqrs".indexOf(c) != -1) {
                    signature.append("7");
                } else if ("tuv".indexOf(c) != -1) {
                    signature.append("8");
                } else if ("wxyz".indexOf(c) != -1) {
                    signature.append("9");
                }
            } else {
                signature.append(" ");
            }
        }

        return signature.toString();
    }

    /**
     * Finds all words in the dictionary that match the given numeric signature.
     *
     * @param signature the numeric signature to match
     * @return a set of words that match the given signature
     */
    private static final String DICTIONARY_FILE = "words";

    // Method to check if a word is valid (only alphabetic characters)
    static boolean isValidWord(String word) {
        return word != null && word.matches("[a-zA-Z]+"); // Match only alphabetic characters
    }

    // Method to convert a signature to words
    public static Set<String> signatureToWords(String signature) {
        Set<String> matchingWords = new HashSet<>();

        try (Scanner scanner = new Scanner(new File(DICTIONARY_FILE))) {
            while (scanner.hasNext()) {
                String word = scanner.nextLine().toLowerCase();
                if (isValidWord(word) && wordToSignature(word).equals(signature)) {
                    matchingWords.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found: " + DICTIONARY_FILE);
        }

        return matchingWords;
    }
}
