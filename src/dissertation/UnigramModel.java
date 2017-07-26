package dissertation;

import java.util.ArrayList;
import java.util.TreeMap;

public class UnigramModel {
	public UnigramModel(){};
	public TreeMap<String, Integer> unigramCounts = new TreeMap<String, Integer>();
	int numberOfWords;
	public ArrayList <String> allCWords = new ArrayList<String>();
	public ArrayList <String> allGWords = new ArrayList<String>();
	
	public void countEachWord(String[] sentenceArray) {
		
		for (int loop=0; loop < sentenceArray.length; loop++){
			if(unigramCounts.containsKey(sentenceArray[loop])) {
				unigramCounts.put(sentenceArray[loop], (unigramCounts.get(sentenceArray[loop]) + 1));
			}
			else {
				unigramCounts.put(sentenceArray[loop], 1);
			
			}
			
			char[] letters = sentenceArray[loop].toCharArray();
			if (letters[0]==('c') && !allCWords.contains(sentenceArray[loop])){
				allCWords.add(sentenceArray[loop]);
			}
			//increase word count
			numberOfWords++;
			
		}
		//System.out.println(unigramCounts + "  unigram");
	}
	
	public int getTotalWordCount() {
		return this.numberOfWords;
	}
}
