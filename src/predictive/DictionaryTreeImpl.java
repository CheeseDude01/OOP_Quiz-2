package predictive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Dictionary implementation using a tree-like structure for compact storage.
 */
public class DictionaryTreeImpl implements Dictionary {
    private final Node root = new Node();

    public DictionaryTreeImpl() {
        try (BufferedReader br = new BufferedReader(new FileReader("words"))) {
            String word;
            while ((word = br.readLine()) != null) {
                if (PredictivePrototype.isValidWord(word)) {
                    addWord(word.toLowerCase());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addWord(String word) {
        String signature = PredictivePrototype.wordToSignature(word);
        Node current = root;
        for (char c : signature.toCharArray()) {
            current.children.putIfAbsent(c, new Node());
            current = current.children.get(c);
        }
        current.words.add(word);
    }

    @Override
    public Set<String> signatureToWords(String signature) {
        Node current = root;
        for (char c : signature.toCharArray()) {
            current = current.children.get(c);
            if (current == null) {
                return Collections.emptySet();
            }
        }
        return current.words;
    }

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private final Set<String> words = new HashSet<>();
    }
}
