package predictive;

import java.util.List;
import java.util.Set;

public class Sigs2WordsMap {
    public static void main(String[] args) {
        Dictionary dictionary = new DictionaryMapImpl("words");

        for (String signature : args) {
            Set<String> words = dictionary.signatureToWords(signature);
            System.out.println(signature + " : " + words);
        }
    }
}
