package predictive;

import java.io.*;
import java.util.*;

/**
 * Dictionary implementation using a HashMap for efficient lookup.
 */
public class DictionaryMapImpl implements Dictionary {
    private final Map<String, Set<String>> dictionary = new HashMap<>();

    public DictionaryMapImpl(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String word;
            while ((word = br.readLine()) != null) {
                if (PredictivePrototype.isValidWord(word)) {
                    String signature = PredictivePrototype.wordToSignature(word.toLowerCase());
                    dictionary.computeIfAbsent(signature, k -> new HashSet<>()).add(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        return dictionary.getOrDefault(signature, Collections.emptySet());
    }
}
