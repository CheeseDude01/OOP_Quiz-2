package predictive;

import java.util.*;
import java.util.Set;

public class DictionaryTreeImpl implements Dictionary {
    private DictionaryTreeImpl[] children; // Cabang untuk setiap digit
    private Set<String> words; // Kata pada node ini

    public DictionaryTreeImpl(String string) {
        children = new HashMap<>();
        words = new HashSet<>();
    }

	@Override
    public String wordToSignature(String word) {
        return PredictivePrototype.wordToSignature(word);
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        Set<String> resultSet = findWords(signature, 0);
        return new ArrayList<>(resultSet);
    }

    public int size() {
        return words.size();
    }

    public void addWord(String word) {
        String signature = wordToSignature(word);
        DictionaryTreeImpl current = this;

        for (char digit : signature.toCharArray()) {
            current.children.putIfAbsent(digit, new DictionaryTreeImpl());
            current = current.children.get(digit);
        }

        current.words.add(word);
    }

    private Set<String> findWords(String signature, int index) {
        if (index == signature.length()) {
            return words;
        }

        char digit = signature.charAt(index);
        DictionaryTreeImpl child = children.get(digit);

        if (child == null) {
            return Collections.emptySet();
        }

        return child.findWords(signature, index + 1);
    }
}