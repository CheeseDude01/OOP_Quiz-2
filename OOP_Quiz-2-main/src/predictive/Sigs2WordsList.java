package predictive;

import java.util.List;
import java.util.Set;
import java.util.Collections;

public class Sigs2WordsList {

    public static void main(String[] args) {
        // Mengecek apakah ada argumen yang diberikan
        if (args.length == 0) {
            System.out.println("No signatures provided!");
            return;
        }

        // Membuat instance dari DictionaryListImpl
        DictionaryListImpl dictionary = new DictionaryListImpl("../src/words");


        // Menambahkan kata-kata dari file ke dictionary
        // Kamu bisa menggunakan dictionary.addWord(word) untuk menambahkan kata
        // Misalnya, dictionary.addWord("hello"); untuk menambahkan kata dan signature-nya

        // Menghitung waktu mulai eksekusi
        long startTime = System.nanoTime();

        // Loop untuk setiap signature yang diberikan melalui argumen
        for (String signature : args) {
            // Mendapatkan daftar kata yang cocok dengan signature
            Set<String> words = dictionary.signatureToWords(signature);

            // Mencetak hasil
            System.out.print(signature + " : ");
            if (words.isEmpty()) {
                System.out.println("No matching words");
            } else {
                System.out.println(String.join(" ", words));
            }
        }

        // Menghitung waktu akhir eksekusi
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Mencetak durasi eksekusi dalam detik
        System.out.println("Execution time: " + duration / 1_000_000.0 + " seconds");
    }
}



