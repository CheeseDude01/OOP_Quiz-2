package predictive;

import java.util.*;

public class DictionaryMapImpl implements Dictionary {
    private Map<String, List<String>> dictionary; // Gunakan List

    public DictionaryMapImpl(String path) {
        dictionary = new HashMap<>();
        loadDictionary(path);
    }

    private void loadDictionary(String path) {
        try (Scanner scanner = new Scanner(new java.io.File(path))) {
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().toLowerCase();
                String signature = PredictivePrototype.wordToSignature(word);

                if (isValidWord(word)) {
                    dictionary.computeIfAbsent(signature, k -> new ArrayList<>()).add(word);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidWord(String word) {
        return word.matches("[a-zA-Z]+");
    }

    @Override
    public String wordToSignature(String word) {
        return PredictivePrototype.wordToSignature(word);
    }

    @Override
    public List<String> signatureToWords(String signature) {
        return dictionary.getOrDefault(signature, Collections.emptyList());
    }

    @Override
    public int size() {
        return dictionary.size();
    }
}
