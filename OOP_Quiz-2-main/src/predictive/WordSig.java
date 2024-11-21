package predictive;

public class WordSig implements Comparable<WordSig> {
    private final String word;
    private final String signature;

    public WordSig(String word, String signature) {
        this.word = word;
        this.signature = signature;
    }

    public String getWord() {
        return word;
    }

    public String getSignature() {
        return signature;
    }

    @Override
    public int compareTo(WordSig other) {
        return this.signature.compareTo(other.signature);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WordSig other = (WordSig) obj;
        return signature.equals(other.signature);
    }

    @Override
    public int hashCode() {
        return signature.hashCode();
    }
}
