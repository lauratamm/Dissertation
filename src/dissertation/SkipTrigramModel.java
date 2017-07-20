package dissertation;

import java.util.TreeMap;

public class SkipTrigramModel {

	public SkipTrigramModel() {}
	TidyUpData tidyUpData= new TidyUpData();
	TreeMap <String, TreeMap <String, TreeMap <String, Double>>> skipTrigramCounts = new TreeMap <String, TreeMap <String, TreeMap <String, Double>>> ();

	TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries;
	TreeMap <String, Double> existingThirdWordEntries;
	TreeMap <String, TreeMap <String, TreeMap <String, Double>>> skipTrigramProbability;
	TreeMap <Integer, Integer> frequencyOfFrequencyCounts = new TreeMap <Integer, Integer> ();
	double probabilityOfUnseenWord;
	double numberOfCommonlyUsedWordsInEnglish  =1000;
	
	
	public void getSkipTrigramCounts(String[] shortSentenceArray, TreeMap <String, TreeMap <String, Double>> skipBigramCounts) {
		
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				for (int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					//flag for finding an existing trigram
					boolean skipgramFound=false;
					
					String key= null;
					String secondWord=null;
					String thirdWord=null;

					/*System.out.println("1st word: " + shortSentenceArray[outerLoop]);
					System.out.println("2nd word: " + shortSentenceArray[secondLoop+1]);
					System.out.println("3rd word: " + shortSentenceArray[thirdLoop+2]);*/

					//check if the first word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[outerLoop])) {
						//record the key word for future use in case an exact match is not found
						key=recordKey(key, secondWord, shortSentenceArray[outerLoop]);
						//System.out.println("First word exists " + shortSentenceArray[outerLoop]);
						//get the map of existing entries for the keyword
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
						
						//check if the second word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+1])){
							//System.out.println("First word exists and second word exists " + shortSentenceArray[outerLoop] + " " + shortSentenceArray[secondLoop+1]);
							//check if the third word exists
							if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2], existingSecondWordEntries)){
								skipgramFound=true;
							}
							else{
								//record the words for future use in case an exact match is not found
								key=shortSentenceArray[outerLoop];
								secondWord=shortSentenceArray[secondLoop+1];
								thirdWord=shortSentenceArray[thirdLoop+2];
							}
						//if trigram is not found in inital word order
						//reverse second word and third word
						}else {					
							if(existingSecondWordEntries.containsKey(shortSentenceArray[thirdLoop+2])){
								//System.out.println("First word exists and second word exists " + shortSentenceArray[outerLoop] + " " + shortSentenceArray[thirdLoop+2]);
								if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[thirdLoop+2], shortSentenceArray[secondLoop+1], existingSecondWordEntries)){
									skipgramFound=true;
								}
								else{
									//record the words for future use in case an exact match is not found
									key=shortSentenceArray[outerLoop];
									secondWord=shortSentenceArray[thirdLoop+2];
									thirdWord=shortSentenceArray[secondLoop+1];
								}
							}
						}
					}


					//if skipgram not found, check if the second word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[secondLoop+1])){
						key=recordKey(key, secondWord, shortSentenceArray[secondLoop+1]);
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[secondLoop+1]);
						
						//check if the first word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
							//System.out.println("Second word exists as key and 1st word exists " + shortSentenceArray[secondLoop+1] + " " + shortSentenceArray[outerLoop]);
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[secondLoop+1], shortSentenceArray[outerLoop], 
								shortSentenceArray[thirdLoop+2], existingSecondWordEntries)){
								skipgramFound=true;
							}
							else{
								//record the two words for future use in case an exact match is not found
								//record the key word for future use in case an exact match is not found
								key=shortSentenceArray[secondLoop+1];
								secondWord=shortSentenceArray[outerLoop];
								thirdWord=shortSentenceArray[thirdLoop+2];
							}
						}
						//if trigram is not found in inital word order
						//reverse second word and third word
						else {
							if(existingSecondWordEntries.containsKey(shortSentenceArray[thirdLoop+2])){
								//System.out.println("Second word exists as key and 1st word exists " + shortSentenceArray[secondLoop+1] + " " + shortSentenceArray[thirdLoop+2]);
								//check if the whole trigram exists				
								if (checkIfThirdWordExists(shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2], 
									shortSentenceArray[outerLoop], existingSecondWordEntries)){
									skipgramFound=true;
								}
								else{
									//record the two words for future use in case an exact match is not found'
									key=shortSentenceArray[secondLoop+1];
									secondWord=shortSentenceArray[thirdLoop+2];
									thirdWord=shortSentenceArray[outerLoop];
								}
							}
						}
					}
					
					
					//if skipgram not found, check if the third word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[thirdLoop+2])){
				
						//record the key word for future use in case an exact match is not found
						key=recordKey(key, secondWord, shortSentenceArray[thirdLoop+2]);
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
								key=shortSentenceArray[thirdLoop+2];
								secondWord= shortSentenceArray[outerLoop];
								thirdWord=shortSentenceArray[secondLoop+1];
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
									key=shortSentenceArray[thirdLoop+2];
									secondWord=shortSentenceArray[secondLoop+1];
									thirdWord=shortSentenceArray[outerLoop];
								}
							}
						}
					}
					
					
					//if skipgram does not exist, but first and second word have been mapped, add the third word into the map
					if (skipgramFound==false && secondWord!=null && key !=null && thirdWord!=null){
						/*System.out.println(key);
						System.out.println(secondWord);
						System.out.println(thirdWord);*/
						existingSecondWordEntries = skipTrigramCounts.get(key);
						addNewThirdWord(existingSecondWordEntries, key, secondWord, thirdWord);
					}
					
					//if only the key exists, add second and third words into the map
					else if (skipgramFound==false && key!=null ){
						//System.out.println(key + " the key");
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

	private String recordKey(String key, String word2, String newValue) {
		//do not record a new key if two of the three words have already been found to exist
		if(word2==null){
			key=newValue;	
		}
		return key;
	}

	private void addNewEntry(String key, String secondWord, String thirdWord){
		TreeMap <String, TreeMap <String, Double>> newSecondWordEntry= new TreeMap<String, TreeMap<String,Double>>();
		TreeMap <String, Double> newThirdWordEntry= new TreeMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		newSecondWordEntry.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, newSecondWordEntry);
		//System.out.println(skipTrigramCounts + " all skip-trigrams after adding new entry");
	}

	private void addNewSecondValue(String key, String secondWord, String thirdWord) {
		/*System.out.println(key);
		System.out.println(secondWord);
		System.out.println(thirdWord);*/

		existingSecondWordEntries = skipTrigramCounts.get(key);
		TreeMap <String, Double> newThirdWordEntry= new TreeMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println(skipTrigramCounts + " all skip-trigrams after adding new second word");
	}

	public void addNewThirdWord (TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries, String key, String secondWord, String thirdWord){
		TreeMap <String, Double> newThirdWordEntry= existingSecondWordEntries.get(secondWord);
		newThirdWordEntry.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println(skipTrigramCounts + " all skip trigrams after adding new third word");
	}

	public void incrementCount(TreeMap <String, TreeMap <String, Double>> existingSecondWordEntries, TreeMap <String, Double> existingThirdWordEntries, String key, String secondWord, String thirdWord ){
		existingThirdWordEntries.put(thirdWord, (existingThirdWordEntries.get(thirdWord)+1.0));
		existingSecondWordEntries.put(secondWord, existingThirdWordEntries);		
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println(skipTrigramCounts + " all skip trigrams after incrementing");
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
			//System.out.println("existing skipgram not found for: " +keyWord + " " + secondWord+ " " + thirdWord);
		return false;
	}
	
	public void calculateProbability(TreeMap <String, TreeMap <String, Double>> skipBigramCounts) {
		//System.out.println("skipbigram counts " + skipBigramCounts);
		System.out.println("About to calculate trigram probabilities");
		//copy the trigram count
		System.out.println("first key:" + skipTrigramCounts.firstKey());
		System.out.println("last key:" +skipTrigramCounts.lastKey());
		this.skipTrigramProbability = this.skipTrigramCounts;
		System.out.println(skipTrigramProbability.firstKey());
		//System.out.println(skipTrigramProbability);
		//System.out.println(skipBigramCounts);
		double trigramCount;
		double bigramCountForWordsOneAndTwo;
		double bigramCountForWordsOneAndThree;
		double bigramCountForWordsTwoAndThree;
		double probability;
		boolean display = false;
		
		for(String word1 : this.skipTrigramProbability.keySet()) {
			for(String word2 : this.skipTrigramProbability.get(word1).keySet()) {
				for(String word3 : this.skipTrigramProbability.get(word1).get(word2).keySet()) {
					if(word1.equals("party") && word2.equals("leader") && word3.equals("labour")) {
						System.out.println("Testing " +word1 +" and " +word2 +" and " +word3);	
					}
					trigramCount = (double)this.skipTrigramProbability.get(word1).get(word2).get(word3);
					//if(word1.equals("party") && word2.equals("leader") && word3.equals("labour")) {
						//System.out.println("Trigram count for \"" +word1 +" " +word2 +" " +word3 +"\" " +trigramCount);	
					//}
					
					
					//get bigram counts for all word combinations
					if (skipBigramCounts.containsKey(word1) && skipBigramCounts.get(word1).containsKey(word2)) {
						bigramCountForWordsOneAndTwo = (double)skipBigramCounts.get(word1).get(word2);
					}
					else {
						bigramCountForWordsOneAndTwo = (double)skipBigramCounts.get(word2).get(word1);
					}
					
					if (skipBigramCounts.containsKey(word1) && skipBigramCounts.get(word1).containsKey(word3)) {
						bigramCountForWordsOneAndThree=(double)skipBigramCounts.get(word1).get(word3);
					}
					else {
						bigramCountForWordsOneAndThree=(double)skipBigramCounts.get(word3).get(word1);
					}
					
					if (skipBigramCounts.containsKey(word2) && skipBigramCounts.get(word2).containsKey(word3)){
						bigramCountForWordsTwoAndThree=(double)skipBigramCounts.get(word2).get(word3);
					}
					else{
						bigramCountForWordsTwoAndThree=(double)skipBigramCounts.get(word3).get(word2);
					}

					if (word1.equals("party") && word2.equals("leader") && word3.equals("labour")){
						System.out.println("bigram count for " + word1 + " " +word2 + " : " + bigramCountForWordsOneAndTwo);
						System.out.println("bigram count for " + word1 + " " +word3 + " : " + bigramCountForWordsOneAndThree);
						System.out.println("bigram count for " + word2 + " " +word3 + " : " + bigramCountForWordsTwoAndThree);
					}
					if(trigramCount == 0) {
							System.out.println("Found a zero");
					}
					
					probability = (double)((trigramCount / bigramCountForWordsOneAndTwo) + (trigramCount/bigramCountForWordsOneAndThree) + (trigramCount/bigramCountForWordsTwoAndThree))/3.0;
					
					//if(word1.equals("party") && word2.equals("leader") && word3.equals("labour")) {
						//System.out.println("Probability of " +word1 + " " +word2 +" " +word3 +" = " + probability +"\n");	
					//}
				//	if(decimal) {
						//the code below leaves the probabilities in decimal - use only for inspecting probability file
						this.skipTrigramProbability.get(word1).get(word2).put(word3, probability);		
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
		//System.out.println("finished trigram probabilities\n");
	}//end method

	public double perplexityOf(String clue, UnigramModel unigram) {
		//System.out.println("About to calculate skip-trigram perplexity");
		double theProbability = 0;
		double thePerplexity;
		boolean firstTrigram = true;
		String [] words;
		double trigramProbability;
		int trigramCount=0;
		
		tidyUpData.collectUnwantedWords();
		//convert to an array of words and tidy
		words=tidyUpData.removeStopWords(clue);	
		words=tidyUpData.removeNonAlphaNumericChars(words);
		//System.out.println(Arrays.toString(words));
		
		//iterate across the array of words
		for(int outerLoop = 0; outerLoop < words.length-2; outerLoop++) {
			for (int secondLoop=outerLoop; secondLoop < words.length-2; secondLoop++ ){
				for (int thirdLoop=secondLoop; thirdLoop < words.length-2; thirdLoop++ ){
					trigramCount++;
					boolean foundProbability = false;
					/*System.out.println(words[outerLoop]);
					System.out.println(words[secondLoop+1]);
					System.out.println(words[thirdLoop+2]);*/
					//System.out.println(skipTrigramProbability);
					//make first word key in probability map
					if(this.skipTrigramProbability.containsKey(words[outerLoop])) {
						existingSecondWordEntries = this.skipTrigramProbability.get(words[outerLoop]);
						//System.out.println(existingSecondWordEntries);
						if(existingSecondWordEntries.containsKey(words[secondLoop+1])) {
							//word i is found and so the bigram is found
							//System.out.println("Word i found " +words[loop]);
							//System.out.println(existingSecondWordEntries.get(key));
							existingThirdWordEntries=existingSecondWordEntries.get(words[secondLoop+1]);
							if (existingThirdWordEntries.containsKey(words[thirdLoop+2])){
							//if(this.decimal) {
								//calculate the probability in decimal
								if(firstTrigram) {
									theProbability = existingThirdWordEntries.get(words[thirdLoop+2]);
									foundProbability=true;
									firstTrigram=false;
									//System.out.println(words[outerLoop] + " " + words[secondLoop+1] + " " + words[thirdLoop+2] + " probability" + " " + theProbability);
									/*if(this.perplexityLogFile) {
										this.perplexityDetails += "Bigram found " +words[loop - 1] + "  "  +words[loop] +" " +theProbability +"\n";	
									}
									firstWord = false;*/
									/*} else {
									if(this.perplexityLogFile) {
										this.perplexityDetails +=  "Bigram found " +words[loop - 1] + "  "  +words[loop] +" " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) +"\n";
										this.perplexityDetails +=  "Multiplying " + theProbability +" * " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) + " to get ";								
									}
									theProbability = theProbability * this.biGramProbability.get(words[loop - 1]).get(words[loop]);
									if(this.perplexityLogFile) {
										this.perplexityDetails += theProbability  +"\n";
									}
																
								}*/
								} else {
									theProbability= theProbability * existingThirdWordEntries.get(words[thirdLoop+2]);
									foundProbability=true;
									//System.out.println(words[outerLoop] + " " + words[secondLoop+1] + " " + words[thirdLoop+2] +" probability for" + " " + existingThirdWordEntries.get(words[thirdLoop+2]));
									//System.out.println(" probability sum" + " " + theProbability);
								}
							}
						}
						//if skipgram not found, reverse second and third words
						else {
							if(existingSecondWordEntries.containsKey(words[thirdLoop+2])) {
								//word i is found and so the bigram is found
								//System.out.println("Word i found " +words[loop]);
								existingThirdWordEntries=existingSecondWordEntries.get(words[thirdLoop+2]);
								if (existingThirdWordEntries.containsKey(words[secondLoop+1])){
								//if(this.decimal) {
									//calculate the probability in decimal
									if(firstTrigram) {
										theProbability = existingThirdWordEntries.get(words[secondLoop+1]);
										foundProbability=true;
										firstTrigram=false;
										//System.out.println(words[outerLoop] + " " + words[secondLoop+1] + " " + words[thirdLoop+2] + " probability" + " " + theProbability);
										/*if(this.perplexityLogFile) {
											this.perplexityDetails += "Bigram found " +words[loop - 1] + "  "  +words[loop] +" " +theProbability +"\n";	
										}
										firstWord = false;*/
										/*} else {
										if(this.perplexityLogFile) {
											this.perplexityDetails +=  "Bigram found " +words[loop - 1] + "  "  +words[loop] +" " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) +"\n";
											this.perplexityDetails +=  "Multiplying " + theProbability +" * " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) + " to get ";								
										}
										theProbability = theProbability * this.biGramProbability.get(words[loop - 1]).get(words[loop]);
										if(this.perplexityLogFile) {
											this.perplexityDetails += theProbability  +"\n";
										}
																	
									}*/
									} else {
										theProbability= theProbability * existingThirdWordEntries.get(words[secondLoop+1]);
										foundProbability=true;
										//System.out.println(words[outerLoop] + " " + words[secondLoop+1] + " " + words[thirdLoop+2] +" probability for" + " " + existingThirdWordEntries.get(words[thirdLoop+2]));
										//System.out.println(" probability sum" + " " + theProbability);
									}
								}
							}
						}
					}
						
					//if probability not found, make second word key
					if (foundProbability==false && this.skipTrigramProbability.containsKey(words[secondLoop+1])){
						existingSecondWordEntries = this.skipTrigramProbability.get(words[secondLoop+1]);
						//System.out.println(words[secondLoop+1]);
						if(existingSecondWordEntries.containsKey(words[outerLoop])){
							existingThirdWordEntries=existingSecondWordEntries.get(words[outerLoop]);
							if (existingThirdWordEntries.containsKey(words[thirdLoop+2])){
								if (firstTrigram){
								theProbability=existingThirdWordEntries.get(words[thirdLoop+2]);
								//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability " + " " + existingThirdWordEntries.get(words[thirdLoop+2]));
								foundProbability=true;
								firstTrigram=false;
								} else {
									theProbability= theProbability * existingThirdWordEntries.get(words[thirdLoop+2]);
									foundProbability=true;
									//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability for" + " " + existingThirdWordEntries.get(words[thirdLoop+2]));
									//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability sum" + " " + theProbability);
								}
							}
						} else {
						//if skipgram not found, reverse second and third word
							if(existingSecondWordEntries.containsKey(words[thirdLoop+2])){
								existingThirdWordEntries=existingSecondWordEntries.get(words[thirdLoop+2]);
								if (existingThirdWordEntries.containsKey(words[outerLoop])){
									if (firstTrigram){
									theProbability=existingThirdWordEntries.get(words[outerLoop]);
									//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability " + " " + existingThirdWordEntries.get(words[outerLoop]));
									foundProbability=true;
									firstTrigram=false;
									} else {
										theProbability= theProbability * existingThirdWordEntries.get(words[outerLoop]);
										foundProbability=true;
										//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability for" + " " + existingThirdWordEntries.get(words[outerLoop]));
										//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability sum" + " " + theProbability);
									}
								}
							}
						}
					}
				
						//if probability not found, make third word key
						if (foundProbability==false && this.skipTrigramProbability.containsKey(words[thirdLoop+2])){
							existingSecondWordEntries = this.skipTrigramProbability.get(words[thirdLoop+2]);
							if(existingSecondWordEntries.containsKey(words[outerLoop])){
								existingThirdWordEntries=existingSecondWordEntries.get(words[outerLoop]);
								if (existingThirdWordEntries.containsKey(words[secondLoop+1])){
									if (firstTrigram){
									theProbability=existingThirdWordEntries.get(words[secondLoop+1]);
									//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability " + " " + existingThirdWordEntries.get(words[secondLoop+1]));
									foundProbability=true;
									firstTrigram=false;
									} else {
										theProbability= theProbability * existingThirdWordEntries.get(words[secondLoop+1]);
										foundProbability=true;
										//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability for" + " " + existingThirdWordEntries.get(words[secondLoop+1]));
										//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability sum" + " " + theProbability);
									}
								}
							} else {
							//if skipgram not found, reverse second and third word
								if(existingSecondWordEntries.containsKey(words[secondLoop+1])){
									existingThirdWordEntries=existingSecondWordEntries.get(words[secondLoop+1]);
									if (existingThirdWordEntries.containsKey(words[outerLoop])){
										if (firstTrigram){
										theProbability=existingThirdWordEntries.get(words[outerLoop]);
										//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability " + " " + existingThirdWordEntries.get(words[outerLoop]));
										foundProbability=true;
										firstTrigram=false;
										} else {
											theProbability= theProbability * existingThirdWordEntries.get(words[outerLoop]);
											foundProbability=true;
											//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability for" + " " + existingThirdWordEntries.get(words[outerLoop]));
											//System.out.println(words[secondLoop+1] + " " + words[outerLoop] + " probability sum" + " " + theProbability);
										}
									}
								}
							}
						}
					/*else {
							//calculate the probability in logarithms
							if(this.perplexityLogFile) {
								this.perplexityDetails += "Bigram found " +words[loop - 1] + "  "  +words[loop] +" " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) +"\n";
								this.perplexityDetails += "Adding " + theProbability +" + " +this.biGramProbability.get(words[loop - 1]).get(words[loop]) + " to get ";
							}
							theProbability = theProbability + this.biGramProbability.get(words[loop - 1]).get(words[loop]);
							if(this.perplexityLogFile) {
								this.perplexityDetails += theProbability +"\n";
							}
						}*/			
						
					//Bi gram not found  
					if (foundProbability==false){
						//System.out.println("skipgram not found");
						//backoff 
		
						//if(this.perplexityLogFile) {
						//	this.perplexityDetails += " Bigram " +words[outerLoop -1] +" " +words[outerLoop] +" not found \n";
						//}
						trigramProbability = calculateProbabilityOf(words[outerLoop], words[secondLoop+1], words[thirdLoop+2], unigram);
						//if(this.decimal) {
							//calculate the probability in decimal
							if(firstTrigram) {
								theProbability = trigramProbability;
								//System.out.println("probability for " + words[outerLoop]+ " " + words[secondLoop+1]+" "+  words[thirdLoop+2] + ": " + theProbability);
							/*	if(this.perplexityLogFile) {
									this.perplexityDetails += words[outerLoop - 1] + "  "  +words[outerLoop] +" " +theProbability +"\n";
								}*/
								firstTrigram = false;
							} else {
							/*	if(this.perplexityLogFile) {
									this.perplexityDetails += "Multiplying " + theProbability +" * " +wordProbability + " to get ";
								}*/
								theProbability = theProbability * trigramProbability;
							/*	if(this.perplexityLogFile) {
									this.perplexityDetails += theProbability +"\n";
								}*/
															
							}
						} /*else {
							//calculate the probability in logarithms
							wordProbability = Math.log10(wordProbability);
							if(this.perplexityLogFile) {
								this.perplexityDetails += "Adding " + theProbability +" + " +wordProbability + " to get ";
							}
							theProbability = theProbability + wordProbability;
							if(this.perplexityLogFile) {
								this.perplexityDetails += theProbability +"\n";
							}
						}*/
						
					/* else {
						//calculate the probability in logarithms
						wordProbability = Math.log10(wordProbability);
						if(this.perplexityLogFile) {
							this.perplexityDetails += "Adding " + theProbability +" + " +wordProbability + " to get ";
						}
						theProbability = theProbability + wordProbability;
						if(this.perplexityLogFile) {
							this.perplexityDetails += theProbability +"\n";
						}
					}*/
				}
			}
		}	
			
			//calculate the perplexity
			//if(this.decimal) {
				thePerplexity = Math.pow(theProbability, (-1.0/(trigramCount+2)));
			//} else {
				//convert back to decimal before calculating perplexity
				//thePerplexity = Math.pow(Math.pow(10, theProbability), (-1.0/length));
			//}
			
			//If using individual calls print details in console
			//if(!this.bulkLoad) {
				//System.out.println(clue);
				//System.out.println("Probability = " +theProbability);
				//System.out.println("Perplexity = " +thePerplexity +"\n\n");	
			//} 
				
			//Not happy with this here - but  will move when model is finalised
			/*if(this.perplexityLogFile  && !this.bulkLoad) {
				this.perplexityDetails += clue +"\n";
				this.perplexityDetails += "Probability " +theProbability +"\n";
				this.perplexityDetails += "Perplexity " +thePerplexity +"\n\n\n";
				
				printPerplexityDetails();
			}*/
	
			System.out.println("Total probability of sentence: " + theProbability);
			System.out.println(thePerplexity +"   " +clue);
			return thePerplexity;
	}
	
			
	public double calculateProbabilityOf(String word1, String word2, String word3, UnigramModel unigram) {
		
	int numberOfTimesSeen;
	double newCounts;
	double probabilityWord1;
	double probabilityWord2;
	double probabilityWord3;
	double probability;
	double absoluteDiscount = 0.75;
		
		//if(this.perplexityLogFile) {
		//	this.perplexityDetails += "Calculating the probability of " +word +"\n";
		//}
		if(!unigram.unigramCounts.containsKey(word1)) {
			//if(this.perplexityLogFile) {
			//	this.perplexityDetails += "I have never seen this word before - probability = " +this.probabilityOfUnseenWord +"\n";
			//}
			System.out.println("i have never seen this word before: " +word1);
			probabilityWord1= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word1);
			System.out.println("I have seen " + word1 + " " + numberOfTimesSeen + " times");
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				System.out.println("I have seen " + word1 + " " + numberOfTimesSeen + " times");
			/*	if(this.perplexityLogFile) {
					this.perplexityDetails += "I have Nc and Nc+1 \n";
					this.perplexityDetails += "C + 1 = " +(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N2 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N1 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen) +"\n";
					this.perplexityDetails += "N2/N1 = " +((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)) +"\n";
				}*/
				newCounts = ((numberOfTimesSeen + 1) * (((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1)) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)));
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "New counts is " +newCounts +"\n";
				}*/

				probabilityWord1 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/

			} else {
				System.out.println("absolute disc " + word1);
				newCounts = numberOfTimesSeen - absoluteDiscount;
				probabilityWord1 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
					this.perplexityDetails += "New counts is " +newCounts +"\n";
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/
			}
			
		}
		
		if(!unigram.unigramCounts.containsKey(word2)) {
			//if(this.perplexityLogFile) {
			//	this.perplexityDetails += "I have never seen this word before - probability = " +this.probabilityOfUnseenWord +"\n";
			//}
			System.out.println("i have never seen this word before: " +word2);
			probabilityWord2= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word2);
			
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				System.out.println("I have seen " + word2 + " " + numberOfTimesSeen + " times");
			/*	if(this.perplexityLogFile) {
					this.perplexityDetails += "I have Nc and Nc+1 \n";
					this.perplexityDetails += "C + 1 = " +(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N2 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N1 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen) +"\n";
					this.perplexityDetails += "N2/N1 = " +((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)) +"\n";
				}*/
				newCounts = ((numberOfTimesSeen + 1) * (((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1)) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)));
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "New counts is " +newCounts +"\n";
				}*/
				probabilityWord2 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/

			} else {
				System.out.println("absolute disc " + word2);
				newCounts = numberOfTimesSeen - absoluteDiscount;
				probabilityWord2 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
					this.perplexityDetails += "New counts is " +newCounts +"\n";
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/
			}
			
		}

		
		if(!unigram.unigramCounts.containsKey(word3)) {
			//if(this.perplexityLogFile) {
			//	this.perplexityDetails += "I have never seen this word before - probability = " +this.probabilityOfUnseenWord +"\n";
			//}
			System.out.println("i have never seen this word before: " +word3);
			probabilityWord3= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word3);
			System.out.println("I have seen " + word3 + " " + numberOfTimesSeen + " times");
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				System.out.println("I have seen " + word3 + " " + numberOfTimesSeen + " times");
			/*	if(this.perplexityLogFile) {
					this.perplexityDetails += "I have Nc and Nc+1 \n";
					this.perplexityDetails += "C + 1 = " +(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N2 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) +"\n";
					this.perplexityDetails += "N1 = " +this.frequencyOfFrequencyCounts.get(numberOfTimesSeen) +"\n";
					this.perplexityDetails += "N2/N1 = " +((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)) +"\n";
				}*/
				newCounts = ((numberOfTimesSeen + 1) * (((double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen + 1)) / (double) this.frequencyOfFrequencyCounts.get(numberOfTimesSeen)));
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "New counts is " +newCounts +"\n";
				}*/
				probabilityWord3 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/

			} else {
				System.out.println("absolute disc " + word3);
				newCounts = numberOfTimesSeen - absoluteDiscount;
				probabilityWord3 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
					this.perplexityDetails += "New counts is " +newCounts +"\n";
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/
			}
			
		}
		System.out.println("prob for " + word1 + " : " + probabilityWord1);
		System.out.println("prob for " + word2 + " : " + probabilityWord2);
		System.out.println("prob for " + word3 + " : " + probabilityWord3);
		probability=(probabilityWord1 + probabilityWord2 + probabilityWord3)/3;
		return probability;

	}

	public void computeFrequencyOfFrequencyCounts(UnigramModel unigram) {
		
		for(Integer aCount : unigram.unigramCounts.values()) {
			//System.out.println("Found value " +aCount);
			if(this.frequencyOfFrequencyCounts.keySet().contains(aCount)) {
				//key already exists - add one to value
				this.frequencyOfFrequencyCounts.put(aCount, (this.frequencyOfFrequencyCounts.get(aCount) + 1));
			} else {
				//key doesn't exist set up with a value of 1
				//System.out.println("Setting up " +aCount);
				this.frequencyOfFrequencyCounts.put(aCount, 1);
			}
		}
		//printFrequencyOfFrequencies();
	}
			
	public void calculateProbabilityOfUnseenWords(UnigramModel unigram) {
		//System.out.println(this.frequencyOfFrequencyCounts.get(1));
		this.probabilityOfUnseenWord = (this.frequencyOfFrequencyCounts.get(1));
		this.probabilityOfUnseenWord= this.probabilityOfUnseenWord/unigram.getTotalWordCount();		
		this.probabilityOfUnseenWord =this.probabilityOfUnseenWord		/ this.numberOfCommonlyUsedWordsInEnglish;
		//System.out.println("Prob of unseen words is " +probabilityOfUnseenWord);
	}
}
