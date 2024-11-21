package predictive;

import java.util.Set;
import java.util.Collections;

public class Sigs2WordsList {

    public static void main(String[] args) {
        // Check if any arguments are provided
        if (args.length == 0) {
            System.out.println("No signatures provided!");
            return;
        }

        // Create an instance of DictionaryListImpl
        DictionaryListImpl dictionary = new DictionaryListImpl("words");

        // Add words from the file to the dictionary
        // You can use dictionary.addWord(word) to add words
        // For example, dictionary.addWord("hello"); to add the word and its signature

        // Record the start time of execution
        long startTime = System.nanoTime();

        // Loop through each signature provided as an argument
        for (String signature : args) {
            // Get the list of words that match the signature
            Set<String> words = dictionary.signatureToWords(signature);

            // Print the results
            System.out.print(signature + " : ");
            if (words.isEmpty()) {
                System.out.println("No matching words");
            } else {
                System.out.println(String.join(" ", words));
            }
        }

        // Record the end time of execution
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Print the execution duration in seconds
        System.out.println("Execution time: " + duration / 1_000_000.0 + " seconds");
    }
}
