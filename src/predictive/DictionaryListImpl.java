package predictive;

import java.io.*;
import java.util.*;

/**
 * Dictionary implementation using an ArrayList to store words.
 */
public class DictionaryListImpl implements Dictionary {
    private final List<String> dictionary = new ArrayList<>();

    public DictionaryListImpl(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String word;
            while ((word = br.readLine()) != null) {
                if (PredictivePrototype.isValidWord(word)) {
                    dictionary.add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        Set<String> result = new HashSet<>();
        for (String word : dictionary) {
            if (PredictivePrototype.wordToSignature(word).equals(signature)) {
                result.add(word);
            }
        }
        return result;
    }
}
