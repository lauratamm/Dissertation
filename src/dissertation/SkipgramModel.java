package dissertation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.TreeMap;

public class SkipgramModel {
	TreeMap <String, TreeMap <String, Double>> skipgramCounts = new TreeMap <String, TreeMap <String, Double>> ();
	public SkipgramModel() {}
	ArrayList <String> unwantedWords = new ArrayList();
	TreeMap <String, Double> existingEntries;
	boolean setValues = true;

	public String[] removeStopWords(String theSentence){		
		ArrayList <String> shortSentenceList = new ArrayList<String>();
		String[] arrayOfWords = theSentence.split(" ");	
		for(int loop=0; loop<arrayOfWords.length; loop++){
			if(!unwantedWords.contains(arrayOfWords[loop])){	
				shortSentenceList.add(arrayOfWords[loop]);
			}
		}
		String[] shortSentenceArray = new String[shortSentenceList.size()];
		for (int loop=0; loop<shortSentenceList.size(); loop++){
			shortSentenceArray[loop]=shortSentenceList.get(loop);
		}
		return shortSentenceArray;
	}

	public void findCooccurrences(String[] shortSentenceArray) {

		//pick the key word
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-1; outerLoop++){
			//skip over each word in the sentence
			for (int innerLoop=outerLoop; innerLoop<shortSentenceArray.length-1; innerLoop++){	
				//get the map of existing entries for the keyword
				existingEntries = skipgramCounts.get(shortSentenceArray[outerLoop]);
				//if key exist
				if (skipgramCounts.containsKey(shortSentenceArray[outerLoop])) {
					//and value exists
					if(existingEntries.containsKey(shortSentenceArray[innerLoop+1])){ 		
						incrementCount(existingEntries, shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);		
					}

					else {		
						//reverse key and value
						if (skipgramCounts.containsKey(shortSentenceArray[innerLoop+1]) && existingEntries.containsKey(shortSentenceArray[outerLoop])){
							existingEntries = skipgramCounts.get(shortSentenceArray[innerLoop+1]);
							incrementCount(existingEntries,shortSentenceArray[innerLoop+1], shortSentenceArray[outerLoop]);
						}
						else {
							addNewValue(existingEntries, shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);
						}		
					}
				}

				//if key does not exist create a new entry
				else {	
					existingEntries = skipgramCounts.get(shortSentenceArray[outerLoop]);
					//create new key-value pair using original order of words
					addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);								
				}
			}
		}
	}


	private void addNewEntry(String key, String occursWithKey) {
		TreeMap<String, Double> newEntry = new TreeMap<String, Double>();
		newEntry.put(occursWithKey, 1.0);
		skipgramCounts.put(key, newEntry);
		System.out.println(skipgramCounts + " all skipgrams after adding new entry");
	}

	public void addNewValue (TreeMap<String, Double> existingEntries, String key, String occursWithKey){
		existingEntries.put(occursWithKey, 1.0);
		skipgramCounts.put(key, existingEntries);
		System.out.println(skipgramCounts + " all skipgrams after adding new value");
	}
	
	public void incrementCount(TreeMap <String, Double> existingEntries, String key, String occursWithKey ){
		existingEntries.put(occursWithKey, (existingEntries.get(occursWithKey)+1.0));
		System.out.println(skipgramCounts + " all skipgrams after incrementing");
		skipgramCounts.put(key, existingEntries);
	}

}
