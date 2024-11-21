package predictive;

import java.util.List;

public class Sigs2WordsTree {
    public static void main(String[] args) {
        DictionaryTreeImpl dictionary = new DictionaryTreeImpl();
        
        for (String signature : args) {
            List<String> words = dictionary.signatureToWords(signature);
            System.out.println(signature + " : " + words);
        }
    }
}
