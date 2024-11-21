package predictive;
import java.util.Arrays;

public class Words2SigProto {
    public static void main(String[] args) {
        // Check if there are any arguments passed to the program
        if (args.length == 0) {
            System.out.println("No words provided!");
            return;
        }

        // Print the input words
        System.out.println("input : " + Arrays.toString(args));

        // Loop through the words and convert each to its signature
        for (String word : args) {
            System.out.print(PredictivePrototype.wordToSignature(word) + " ");
        }
    }
}
