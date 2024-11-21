package predictive;

import java.util.Set;

public interface Dictionary {
	
	public Set<String> signatureToWords(String signature);

	String wordToSignature(String word);

	int size();
}
