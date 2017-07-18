package dissertation;

import java.awt.peer.SystemTrayPeer;
import java.util.TreeMap;

public class SkipTrigramModel {

	public SkipTrigramModel() {}

	TreeMap <String, TreeMap <String, TreeMap <String, Double>>> skipTrigramCounts = new TreeMap <String, TreeMap <String, TreeMap <String, Double>>> ();

	TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries;
	TreeMap <String, Double> existingThirdWordEntries;
	TreeMap <String, TreeMap <String, TreeMap <String, Double>>> skipTrigramProbability;

	public void getSkipTrigramCounts(String[] shortSentenceArray, TreeMap <String, TreeMap <String, Double>> skipBigramCounts) {

		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				for (int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					//flag for finding an existing trigram
					boolean skipgramFound=false;
					
					String key= null;
					String secondWord=null;
					String thirdWord=null;

					System.out.println("1st word: " + shortSentenceArray[outerLoop]);
					System.out.println("2nd word: " + shortSentenceArray[secondLoop+1]);
					System.out.println("3rd word: " + shortSentenceArray[thirdLoop+2]);

					//check if the first word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[outerLoop])) {
						//record the key word for future use in case an exact match is not found
						key=recordWord(key, shortSentenceArray[outerLoop]);
						
						//get the map of existing entries for the keyword
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
						
						//check if the second word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+1])){
							
							//check if the third word exists
							if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2], existingSecondWordEntries)){
								skipgramFound=true;
							}
							else{
								//record the words for future use in case an exact match is not found
								secondWord=recordWord(secondWord, shortSentenceArray[secondLoop+1]);
								thirdWord=recordWord(thirdWord, shortSentenceArray[thirdLoop+2]);
							}
						//if trigram is not found in inital word order
						//reverse second word and third word
						}else {					
							if(existingSecondWordEntries.containsKey(shortSentenceArray[thirdLoop+2])){
								if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[thirdLoop+2], shortSentenceArray[secondLoop+1], existingSecondWordEntries)){
									skipgramFound=true;
								}
								else{
									//record the words for future use in case an exact match is not found
									secondWord=recordWord(secondWord, shortSentenceArray[thirdLoop+2]);
									thirdWord=recordWord(thirdWord, shortSentenceArray[secondLoop+1]);
								}
							}
						}
					}


					//if skipgram not found, check if the second word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[secondLoop+1])){
						//record the key word for future use in case an exact match is not found
						key=recordWord(key, shortSentenceArray[secondLoop+1]);
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[secondLoop+1]);
						
						//check if the first word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[secondLoop+1], shortSentenceArray[outerLoop], 
								shortSentenceArray[thirdLoop+2], existingSecondWordEntries)){
								skipgramFound=true;
							}
							else{
								//record the two words for future use in case an exact match is not found
								secondWord=recordWord(secondWord, shortSentenceArray[outerLoop]);
								thirdWord=recordWord(thirdWord, shortSentenceArray[thirdLoop+2]);
							}
						}
						//if trigram is not found in inital word order
						//reverse second word and third word
						else {
							if(existingSecondWordEntries.containsKey(shortSentenceArray[thirdLoop+2])){
								//check if the whole trigram exists				
								if (checkIfThirdWordExists(shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2], 
									shortSentenceArray[outerLoop], existingSecondWordEntries)){
									skipgramFound=true;
								}
								else{
									//record the two words for future use in case an exact match is not found
									secondWord=recordWord(secondWord, shortSentenceArray[thirdLoop+2]);
									thirdWord=recordWord(thirdWord, shortSentenceArray[outerLoop]);
								}
							}
						}
					}
					
					
					//if skipgram not found, check if the third word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[thirdLoop+2])){
						//record the key word for future use in case an exact match is not found
						key=recordWord(key, shortSentenceArray[thirdLoop+2]);
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[thirdLoop+2]);
	
						//check if the first word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[thirdLoop+2], shortSentenceArray[outerLoop], 
								shortSentenceArray[secondLoop+1], existingSecondWordEntries)){
								skipgramFound=true;
							}
							else{
								//record the two words for future use in case an exact match is not found
								secondWord=recordWord(secondWord, shortSentenceArray[outerLoop]);
								thirdWord=recordWord(thirdWord, shortSentenceArray[secondLoop+1]);
							}
						}
						//if trigram is not found in inital word order
						//reverse second word and third word
						else {
							if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+1])){
								//check if the whole trigram exists				
								if (checkIfThirdWordExists(shortSentenceArray[thirdLoop+2], shortSentenceArray[secondLoop+1], 
									shortSentenceArray[outerLoop], existingSecondWordEntries)){
									skipgramFound=true;
								}
								else{
									//record the two words for future use in case an exact match is not found
									secondWord=recordWord(secondWord, shortSentenceArray[secondLoop+1]);
									thirdWord=recordWord(thirdWord, shortSentenceArray[outerLoop]);
								}
							}
						}
					}
					
					
					//if skipgram does not exist, but first and second word have been mapped, add the third word into the map
					if (skipgramFound==false && secondWord!=null && key !=null && thirdWord!=null){
						existingSecondWordEntries = skipTrigramCounts.get(key);
						addNewThirdWord(existingSecondWordEntries, key, secondWord, thirdWord);
					}
					
					//if only the key exists, add second and third words into the map
					else if (skipgramFound==false && key!=null ){
						System.out.println(key + " the key");
						if (key.equals(shortSentenceArray[outerLoop])){
							secondWord=shortSentenceArray[secondLoop+1];
							thirdWord=shortSentenceArray[thirdLoop+2];
						}
						if (key.equals(shortSentenceArray[secondLoop+1])){
							secondWord=shortSentenceArray[outerLoop];
							thirdWord=shortSentenceArray[thirdLoop+2];
						}
						if (key.equals(shortSentenceArray[thirdLoop+2])){
							secondWord=shortSentenceArray[outerLoop];
							thirdWord=shortSentenceArray[secondLoop+1];
						}
						
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
						addNewSecondValue(key, secondWord, thirdWord);		
					}
					
					//if none of the words exist in the map, record a new entry
					else if (skipgramFound==false && key==null ){
						addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2]);
					}
				}
			}
		}
	}


	private String recordWord(String word, String newValue) {
		if (word == null){
			word=newValue;	
		}		
		return word;
	}

	private void addNewEntry(String key, String secondWord, String thirdWord){
		TreeMap <String, TreeMap <String, Double>> newSecondWordEntry= new TreeMap<String, TreeMap<String,Double>>();
		TreeMap <String, Double> newThirdWordEntry= new TreeMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		newSecondWordEntry.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, newSecondWordEntry);
		System.out.println(skipTrigramCounts + " all skip-trigrams after adding new entry");
	}

	private void addNewSecondValue(String key, String secondWord, String thirdWord) {
		System.out.println(key);
		System.out.println(secondWord);
		System.out.println(thirdWord);

		existingSecondWordEntries = skipTrigramCounts.get(key);
		TreeMap <String, Double> newThirdWordEntry= new TreeMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		System.out.println(skipTrigramCounts + " all skip-trigrams after adding new second word");
	}

	public void addNewThirdWord (TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries, String key, String secondWord, String thirdWord){
		TreeMap <String, Double> newThirdWordEntry= existingSecondWordEntries.get(secondWord);
		newThirdWordEntry.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		System.out.println(skipTrigramCounts + " all skip trigrams after adding new third word");
	}

	public void incrementCount(TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries, TreeMap <String, Double> existingThirdWordEntries, String key, String secondWord, String thirdWord ){
		existingThirdWordEntries.put(thirdWord, (existingThirdWordEntries.get(thirdWord)+1.0));
		existingSecondWordEntries.put(secondWord, existingThirdWordEntries);		
		skipTrigramCounts.put(key, existingSecondWordEntries);
		System.out.println(skipTrigramCounts + " all skip trigrams after incrementing");
	}

	private boolean checkIfThirdWordExists(String keyWord, String secondWord, String thirdWord,TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries){

		//get the map of existing counts 
		existingThirdWordEntries=existingSecondWordEntries.get(secondWord);
		//check if third word exists as a key in the map
		if(existingThirdWordEntries.containsKey(thirdWord)){
			//if the skiptrigram exists, increment count
			incrementCount(existingSecondWordEntries, existingThirdWordEntries, keyWord, secondWord, thirdWord);	
			return true;
		}
		else
			//if skipgram was not found return false	
			System.out.println("existing skipgram not found for: " +keyWord + " " + secondWord+ " " + thirdWord);
		return false;
	}
	
	public void calculateProbability(TreeMap <String, TreeMap <String, Double>> skipBigramCounts) {
		System.out.println("About to calculate skipgram probabilities");
		//copy the trigram count
		this.skipTrigramProbability = this.skipTrigramCounts;
		double trigramCount;
		double bigramCountForWordsOneAndTwo;
		double bigramCountForWordsOneAndThree;
		double bigramCountForWordsTwoAndThree;
		double probability;
		boolean display = true;
		
		for(String word1 : this.skipTrigramProbability.keySet()) {
			for(String word2 : this.skipTrigramProbability.get(word1).keySet()) {
				for(String word3 : this.skipTrigramProbability.get(word1).get(word2).keySet()) {
					if(display) {
						System.out.println("Testing " +word1 +" and " +word2 +" and " +word3);	
					}
					trigramCount = this.skipTrigramProbability.get(word1).get(word2).get(word3);
					if(display) {
						System.out.println("Trigram count for \"" +word1 +" " +word2 +" " +word3 +"\" " +trigramCount);	
					}
					
					//get bigram counts for all word combinations
					if (skipBigramCounts.containsKey(word1) && skipBigramCounts.get(word1).containsKey(word2)) {
						bigramCountForWordsOneAndTwo = skipBigramCounts.get(word1).get(word2);
					}
					else {
						bigramCountForWordsOneAndTwo = skipBigramCounts.get(word2).get(word1);
					}
					
					if (skipBigramCounts.containsKey(word1) && skipBigramCounts.get(word1).containsKey(word3)) {
						bigramCountForWordsOneAndThree=skipBigramCounts.get(word1).get(word3);
					}
					else {
						bigramCountForWordsOneAndThree=skipBigramCounts.get(word3).get(word1);
					}
					
					if (skipBigramCounts.containsKey(word2) && skipBigramCounts.get(word2).containsKey(word3)){
						bigramCountForWordsTwoAndThree=skipBigramCounts.get(word2).get(word3);
					}
					else{
						bigramCountForWordsTwoAndThree=skipBigramCounts.get(word3).get(word2);
					}

					System.out.println("bigram count for " + word1 + " " +word2 + " : " + bigramCountForWordsOneAndTwo);
					System.out.println("bigram count for " + word1 + " " +word3 + " : " + bigramCountForWordsOneAndThree);
					System.out.println("bigram count for " + word2 + " " +word3 + " : " + bigramCountForWordsTwoAndThree);
				
					if(trigramCount == 0) {
							System.out.println("Found a zero");
					}
					probability = (double) (trigramCount / bigramCountForWordsOneAndTwo + trigramCount/bigramCountForWordsOneAndThree + trigramCount/bigramCountForWordsTwoAndThree)/3;	
					
					if(display) {
						System.out.println("Probability of " +word1 + " " +word2 +" " +word3 +" = " + probability +"\n");	
					}
				//	if(decimal) {
						//the code below leaves the probabilities in decimal - use only for inspecting probability file
				//		this.trigramProbability.get(word1).get(word2).put(word3, probability);					
				//	} else {
						//Use log(prob)
				//		this.trigramProbability.get(word1).get(word2).put(word3, Math.log10(probability));	
				//	}
				}
			}
		}
	//	if(this.printToFile) {
	//		printProbability();
	//	}
		
	}//end method

}
