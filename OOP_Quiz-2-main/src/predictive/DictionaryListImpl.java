package predictive;

import java.io.*;
import java.util.*;

public class DictionaryListImpl {
    private static ArrayList<WordSig> dictionary;

    public DictionaryListImpl(String path) {
        dictionary = new ArrayList<WordSig>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String word;
            while ((word = br.readLine()) != null) {
                word = word.toLowerCase();
                if (PredictivePrototype.isValidWord(word)) {
                    dictionary.add(new WordSig(word, PredictivePrototype.wordToSignature(word)));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(dictionary); // Urutkan berdasarkan signature
    }

    public Set<String> signatureToWords(String signature) {
        Set<String> wordSet = new HashSet<String>();

        // Debugging output
        System.out.println("Searching for signature: " + signature);

        // Binary search untuk menemukan posisi pertama dari signature
        int indexBelow = Collections.binarySearch(dictionary, new WordSig(null, signature));
        
        // Debugging output
        System.out.println("Binary search returned index: " + indexBelow);

        // Jika signature tidak ditemukan
        if (indexBelow < 0) {
            System.out.println("Signature not found.");
            return wordSet;
        }

        // Menyusuri ke atas dan bawah untuk menemukan semua kata yang cocok
        int indexAbove = indexBelow;
        
        // Menyusuri ke bawah dari indexBelow
        while (indexBelow >= 0 && dictionary.get(indexBelow).getSignature().equals(signature)) {
            wordSet.add(dictionary.get(indexBelow).getWord());
            indexBelow--;
        }

        // Menyusuri ke atas dari indexAbove
        indexAbove++; // karena indexBelow sudah selesai
        while (indexAbove < dictionary.size() && dictionary.get(indexAbove).getSignature().equals(signature)) {
            wordSet.add(dictionary.get(indexAbove).getWord());
            indexAbove++;
        }

        System.out.println("Words found: " + wordSet); // Output hasil pencarian
        return wordSet;
    }
}
