import predictive.PredictivePrototype;

public class Main {
    public static void main(String[] args) {
        // Test with a known signature "43556" for the word "hello"
        System.out.println("Testing SignatureToWords with 43556:");
        System.out.println(PredictivePrototype.signatureToWords("43556")); // Expected output: hello

        // Test with another signature
        System.out.println("Testing WordsToSignature with world:");
        System.out.println(PredictivePrototype.wordToSignature("world"));
    }
}
