package predictive;

import java.util.Set;

public class Sigs2WordsTree {
    public static void main(String[] args) {
        DictionaryTreeImpl dictionary = new DictionaryTreeImpl();
        
        for (String signature : args) {
            Set<String> words = dictionary.signatureToWords(signature);
            System.out.println(signature + " : " + words);
        }
    }
}
