package predictive;

import java.io.FileNotFoundException;
import java.util.Set;
public class Sigs2WordsProto {

	public static void main(String[] args) throws FileNotFoundException{
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i]);
			Set<String> words = PredictivePrototype.signatureToWords(args[i]);
			System.out.println(" : " + words );
		}

	}

}