package predictivegui;

import java.util.*;

import predictive.Dictionary;
import predictive.DictionaryTreeImpl;

// Model class that controls access and updates of data
public class Model extends Observable {
    // Attributes needed
    private String text;
    private String currentSignature = "";
    private String currentText = "";
    private Dictionary dict = new DictionaryTreeImpl("words");
    private List<String> signatures = new ArrayList<String>();
    private List<String> currentWordList;
    private int currentWordListIndex = 0;
    
    // Text is initially empty
    public Model() {
        text = "";
    }
    
    public void doTyping(String signature) {
        currentSignature = currentSignature + signature;
        currentWordList = new ArrayList<String>(dict.signatureToWords(currentSignature));
        if (currentWordList.isEmpty()) {
            currentSignature = currentSignature.substring(0, currentSignature.length() - 1);
        } else {
            text = currentText + currentWordList.get(0);
        }
        extracted();
        notifyObservers(text);
    }

    public void cycleWords() {
        if (currentWordList == null || currentWordList.isEmpty()) {
            return;
        }
        currentWordListIndex = (currentWordListIndex + 1 < currentWordList.size()) ? currentWordListIndex + 1 : 0;
        text = currentText + currentWordList.get(currentWordListIndex);
        extracted();
        notifyObservers(text);
    }

    public void completeWord() {
        signatures.add(currentSignature);
        currentText = text + " ";
        text = currentText;
        currentSignature = "";
        currentWordList = null;
        currentWordListIndex = 0;
        extracted();
        notifyObservers(text);
    }

    // Function to handle backspace
    public void doBackspace() {
        if (text.isEmpty()) return;
        
        if (currentSignature.length() == 0) {
            currentSignature = signatures.get(signatures.size() - 1);
            signatures.remove(signatures.size() - 1);
            currentText = currentText.substring(0, currentText.length() - currentSignature.length() - 1);
        } else {
            text = currentText + text.substring(0, text.length() - 1);
            currentSignature = currentSignature.substring(0, currentSignature.length() - 1);
        }
        
        currentWordListIndex = 0;
        currentWordList = new ArrayList<String>(dict.signatureToWords(currentSignature));
        
        if (currentWordList.isEmpty()) {
            text = currentText;
        } else {
            text = currentText + currentWordList.get(0);
        }
        extracted();
        notifyObservers(text);
    }

    private void extracted() {
        setChanged();
    }
}
