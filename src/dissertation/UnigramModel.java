package dissertation;

import java.util.TreeMap;

public class UnigramModel {
	public UnigramModel(){};
	TreeMap<String, Integer> unigramCounts = new TreeMap<String, Integer>();
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
		System.out.println(unigramCounts + "  unigram");
	}
	
	public int getTotalWordCount() {
		return this.numberOfWords;
	}
}
