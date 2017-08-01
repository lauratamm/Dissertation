package dissertation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;

public class UnigramModel  {
	public UnigramModel(){};
	public TreeMap<String, Integer> unigramCounts = new TreeMap<String, Integer>();
	int numberOfWords;
	
	public void countEachWord(String[] sentenceArray) {
		
		for (int loop=0; loop < sentenceArray.length; loop++){
			if(unigramCounts.containsKey(sentenceArray[loop])) {
				unigramCounts.put(sentenceArray[loop], (unigramCounts.get(sentenceArray[loop]) + 1));
			}
			else {
				unigramCounts.put(sentenceArray[loop], 1);
			
			}
			
			//increase word count
			numberOfWords++;
			
		}
		//System.out.println(unigramCounts + "  unigram");
	}
	
	public int getTotalWordCount() {
		return this.numberOfWords;
	}

	public ArrayList <String> getAllWordsStartingWith (char letter){
		ArrayList <String> allWordsStartingWithChosenLetter = new ArrayList<String>();
		for (String word: unigramCounts.keySet()){
			char[] letters = word.toCharArray();
			if (letters[0]==(letter) && !allWordsStartingWithChosenLetter.contains(word)){
				allWordsStartingWithChosenLetter.add(word);
			}
		}		
		return allWordsStartingWithChosenLetter;
	}
	
}
