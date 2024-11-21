package predictivegui;

import predictive.Dictionary;
import java.util.Set;
import java.util.TreeSet;

public class Model {
    private final Dictionary dictionary;
    private String currentSignature = "";
    private String currentText = "";
    private Set<String> currentWords = new TreeSet<>();
    private int currentIndex = 0;

    public Model(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String getCurrentText() {
        return currentText;
    }

    public void typeDigit(String digit) {
        currentSignature += digit;
        currentWords = dictionary.signatureToWords(currentSignature);
        currentIndex = 0;
        updateText();
    }

    public void cycleWord() {
        if (!currentWords.isEmpty()) {
            currentIndex = (currentIndex + 1) % currentWords.size();
            updateText();
        }
    }

    public void completeWord() {
        currentText += getCurrentWord() + " ";
        currentSignature = "";
        currentWords.clear();
        currentIndex = 0;
        updateText();
    }

    public void backspace() {
        if (currentSignature.isEmpty() && !currentText.isEmpty()) {
            currentText = currentText.substring(0, currentText.lastIndexOf(" ")).trim();
        } else if (!currentSignature.isEmpty()) {
            currentSignature = currentSignature.substring(0, currentSignature.length() - 1);
            currentWords = dictionary.signatureToWords(currentSignature);
            currentIndex = 0;
        }
        updateText();
    }

    private void updateText() {
        if (!currentWords.isEmpty()) {
            currentText = currentText.substring(0, currentText.lastIndexOf(" ")) + " " + getCurrentWord();
        }
    }

    private String getCurrentWord() {
        return currentWords.isEmpty() ? "" : (String) currentWords.toArray()[currentIndex];
    }
}
