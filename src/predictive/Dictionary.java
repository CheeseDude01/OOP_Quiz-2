package predictive;

import java.util.List;

public interface Dictionary {
    String wordToSignature(String word);

    List<String> signatureToWords(String signature); // Tetap List<String>

    int size();
}
