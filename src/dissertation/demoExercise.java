package dissertation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Locale;

import dissertation.SkipBigramModel;

public class demoExercise {

	public static void main(String[] args) {
		SkipBigramModel skipBigram = new SkipBigramModel();
		SkipTrigramModel skipTrigram = new SkipTrigramModel();
		UnigramModel unigram = new UnigramModel();	
		TidyUpData tidyUpData= new TidyUpData();
		
		File file = new File("data.txt");
		FileInputStream fis = null;
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.UK);
		BufferedReader br=null;
		
		tidyUpData.collectUnwantedWords();
			
		try {
			String line= ""; 
			fis = new FileInputStream(file);
			br = new BufferedReader( new InputStreamReader(fis));
			
			while ((line = br.readLine()) !=null){
				iterator.setText(line);
				int start = iterator.first();
			
				//break text into sentences
				for (int end = iterator.next(); end != BreakIterator.DONE; start = end, end = iterator.next()) {
					String theSentence= line.substring(start,end);
					//remove multiple spaces
					theSentence = theSentence.replaceAll("\\s+", " ");
					System.out.println("Dealing with: " +theSentence);
					//break sentence into an array of words
					String[] shortSentenceArray=tidyUpData.removeStopWords(theSentence);	
					//remove all non-alphanumerical characters and convert to lower case
					String[] shortSentenceArrayTidiedUp=tidyUpData.removeNonAlphaNumericChars(shortSentenceArray);	
					System.out.println(Arrays.toString(shortSentenceArrayTidiedUp));
					//get unigram counts
					unigram.countEachWord(shortSentenceArrayTidiedUp);
					//get skip-bigram counts
					skipBigram.getSkipBigramCounts(shortSentenceArrayTidiedUp);	
					//get skip-trigram counts
					skipTrigram.getSkipTrigramCounts(shortSentenceArrayTidiedUp, skipBigram.skipBigramCounts);			
				}
			}
			//calculate probabilities
			skipBigram.calculateProbability(unigram);
			skipTrigram.calculateProbability(skipBigram.skipBigramCounts);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (br !=null){
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
