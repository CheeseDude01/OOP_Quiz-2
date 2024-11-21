package predictive;

import java.util.List;

public class Sigs2WordsMap {
    public static void main(String[] args) {
        Dictionary dictionary = new DictionaryMapImpl("words");

        for (String signature : args) {
            List<String> words = dictionary.signatureToWords(signature);
            System.out.println(signature + " : " + words);
        }
    }
}
