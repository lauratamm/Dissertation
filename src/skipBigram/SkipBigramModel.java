package skipBigram;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.HashMap;
import bigram.*;
import dissertation.Dictionary;
import dissertation.TidyUpData;
import dissertation.UnigramModel;

public class SkipBigramModel {
	public SkipBigramModel() {}
	TidyUpData tidyUpData = new TidyUpData();
	public HashMap <String, HashMap <String, Double>> skipBigramCounts = new HashMap <String, HashMap <String, Double>> ();	
	public HashMap <String, HashMap <String, Double>> skipBigramProbability;
	private HashMap <Integer, Integer> frequencyOfFrequencyCounts = new HashMap <Integer, Integer> (); 
	private double probabilityOfUnseenWord;
	private int numberOfCommonlyUsedWordsInEnglish = 1000;

	
	public void getSkipBigramCounts(String[] shortSentenceArray) {
		HashMap <String, Double> existingEntries=null;
		//pick the key word
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-1; outerLoop++){
			//skip over each word in the sentence
			for (int innerLoop=outerLoop; innerLoop<shortSentenceArray.length-1; innerLoop++){	
				//flag for finding an existing trigram
				boolean skipgramFound=false;

				String key= null;
				String secondWord=null;
				
				
				//System.out.println("1st word: " +shortSentenceArray[outerLoop]);
				//System.out.println("2nd word: " + shortSentenceArray[innerLoop+1]);	
				
				//if first word exists as a key
				if (skipBigramCounts.containsKey(shortSentenceArray[outerLoop])) {
					
					//record the key word for future use in case an exact match is not found
					key=shortSentenceArray[outerLoop];
					secondWord=shortSentenceArray[innerLoop+1];
					
					//get the map of existing entries for the keyword
					existingEntries = skipBigramCounts.get(shortSentenceArray[outerLoop]);
					
					//if key and value exist increment count
					if(existingEntries.containsKey(shortSentenceArray[innerLoop+1])){ 		
						incrementCount(existingEntries, shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);		
						skipgramFound=true;
					}
				}	
				//if key does not exist reverse first and second word
				if(skipgramFound==false && skipBigramCounts.containsKey(shortSentenceArray[innerLoop+1])) {
					
					//record the key word for future use in case an exact match is not found
					key=shortSentenceArray[innerLoop+1];
					secondWord= shortSentenceArray[outerLoop];
					
					//get the map of existing entries for the keyword
					existingEntries = skipBigramCounts.get(shortSentenceArray[innerLoop+1]);
					
					//if key and value exist increment count
					if(existingEntries.containsKey(shortSentenceArray[outerLoop])) {
						incrementCount(existingEntries,shortSentenceArray[innerLoop+1], shortSentenceArray[outerLoop]);	
						skipgramFound=true;
					}
							
				}
				
				//if only a key word was found add a new value to it
				if (skipgramFound==false && key!=null && secondWord!=null) {
					addNewValue(existingEntries, key, secondWord);
				}	
				
				//if key does not exist create a new entry
				else if(skipgramFound==false & key==null) {	
					existingEntries = skipBigramCounts.get(shortSentenceArray[outerLoop]);
					//create new key-value pair using original order of words
					addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);								
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

	private void addNewEntry(String key, String occursWithKey) {
		HashMap<String, Double> newEntry = new HashMap<String, Double>();
		newEntry.put(occursWithKey, 1.0);
		skipBigramCounts.put(key, newEntry);
		//System.out.println("New key '"+key+"' added with value '" +occursWithKey+"' \n");
	}

	public void addNewValue (HashMap<String, Double> existingEntries, String key, String occursWithKey){
		existingEntries.put(occursWithKey, 1.0);
		skipBigramCounts.put(key, existingEntries);
		//System.out.println("New value '" +occursWithKey+"' added for key '"+ key+"'\n");
	}
	
	public void incrementCount(HashMap <String, Double> existingEntries, String key, String occursWithKey ){
		existingEntries.put(occursWithKey, (existingEntries.get(occursWithKey)+1.0));
		//System.out.println("Incremented count for: "+key +" "+ occursWithKey+"\n");
		skipBigramCounts.put(key, existingEntries);
	}
	
	public void calculateProbability(UnigramModel unigram) {
		System.out.println("About to calculate bigram probabilities");
		//System.out.println("first key: " + skipBigramCounts.get((skipBigramCounts.keySet().toArray())[0]));
		//System.out.println("first key: " + skipBigramCounts.get((skipBigramCounts.keySet().toArray())[1]));
		//System.out.println("first key: " + skipBigramCounts.get((skipBigramCounts.keySet().toArray())[2]));
		//System.out.println("first key:" +skipBigramCounts.firstKey());
		//System.out.println("last key: " +skipBigramCounts.lastKey());
		//copy the bigram count
		this.skipBigramProbability = this.skipBigramCounts;
		//System.out.println("probabilities inside calc prob: " +skipBigramProbability);
		double wordsTogetherCount;
		int wordCountOuter;
		int wordCountInner;
		double probability;
		boolean display = true;
		
		for(String outerWord : this.skipBigramProbability.keySet()) {
			for(String innerWord : this.skipBigramProbability.get(outerWord).keySet()) {
				if(display) {
					//System.out.println("Testing " +outerWord +" and " +innerWord);	
				}
				wordsTogetherCount = this.skipBigramProbability.get(outerWord).get(innerWord);
				if(display) {
					//System.out.println("Word together count " +wordsTogetherCount);	
				}
				wordCountOuter = unigram.unigramCounts.get(outerWord);
				wordCountInner = unigram.unigramCounts.get(innerWord);
				if(display) {
					//System.out.println("Word count for " + outerWord + " : " +wordCountOuter);	
					//System.out.println("Word count for " + innerWord + " : " +wordCountInner);	
				}
			
				
				if(wordsTogetherCount == 0) {
					//System.out.println("Found a zero");
				}
				
				probability = (double) (wordsTogetherCount/ wordCountOuter + wordsTogetherCount/wordCountInner)/2;

				if(display) {
					//System.out.println(outerWord + " " +innerWord +" = " + probability);	
				}
				//if(decimal) {
					//the code below leaves the probabilities in decimal - use only for inspecting probability file
					this.skipBigramProbability.get(outerWord).put(innerWord, probability);					
				//} else {
					//Use log(prob)
				//	this.skipBigramProbability.get(outerWord).put(innerWord, Math.log10(probability));	
				//}
				
			}
		}
	//	if(this.printToFile) {
	//		printProbability();
	//	}
		//System.err.println(skipBigramCounts + " skipgramcounts");
		//System.err.println(skipBigramProbability + " skipgramprobability");
		//System.out.println("probabilities inside calc prob after: " +skipBigramProbability);
	}
	
	public double perplexityOf(String clue, UnigramModel unigram) {
		HashMap <String, Double> existingEntries;
		//System.out.println("About to calculate skip-bigram perplexity");
		//System.out.println("first key:" +skipBigramProbability.firstKey());
		//System.out.println(skipBigramProbability);
		double theProbability = 0;
		double thePerplexity;
		boolean firstBigram = true;
		String [] words;
		double bigramProbability;
		int bigramCount=0;
		//convert to an array of words and tidy
		words=tidyUpData.removeStopWords(clue);	
		words=tidyUpData.removeNonAlphaNumericChars(words);
		//System.out.println(Arrays.toString(words));
		
		
		//iterate across the array of words
		for(int outerLoop = 0; outerLoop < words.length-1; outerLoop++) {
			for (int innerLoop=outerLoop; innerLoop < words.length-1; innerLoop++ ){
				bigramCount++;
				boolean foundProbability = false;
				//System.out.println(words[outerLoop]);
				//System.out.println(skipBigramProbability.get(words[outerLoop]));
				//System.out.println(words[innerLoop+1]);
				//if the  word is listed in the probability table
				if(this.skipBigramProbability.containsKey(words[outerLoop])) {
					existingEntries = this.skipBigramProbability.get(words[outerLoop]);
					//System.out.println("existing entries for jeremy " + existingEntries);
					if(existingEntries.containsKey(words[innerLoop+1])) {
						//word i is found and so the bigram is found
						//System.out.println("Word i found " +words[loop]);
						//if(this.decimal) {
							//calculate the probability in decimal
							if(firstBigram) {
								theProbability = existingEntries.get(words[innerLoop+1]);
								foundProbability=true;
								firstBigram=false;
								System.out.println(words[outerLoop] + " " + words[innerLoop+1] + " probability" + " " + theProbability);
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
								theProbability= theProbability * existingEntries.get(words[innerLoop+1]);
								foundProbability=true;
								System.out.println(words[outerLoop] + " " + words[innerLoop+1] + " probability for" + " " + existingEntries.get(words[innerLoop+1]));
								//System.out.println(words[outerLoop] + " " + words[innerLoop+1] + " probability sum" + " " + theProbability);
							}
					}
				}
					
				//if probability not found, reverse key and value
				if (foundProbability==false && this.skipBigramProbability.containsKey(words[innerLoop+1])){
					existingEntries = this.skipBigramProbability.get(words[innerLoop+1]);
					//System.out.println(words[innerLoop+1]);
					//System.out.println(existingEntries);
					if(existingEntries.containsKey(words[outerLoop])){
						if (firstBigram){
						theProbability=existingEntries.get(words[outerLoop]);
						System.out.println(words[innerLoop+1] + " " + words[outerLoop] + " probability " + " " + existingEntries.get(words[outerLoop]));
						foundProbability=true;
						firstBigram=false;
						} else {
							theProbability= theProbability * existingEntries.get(words[outerLoop]);
							foundProbability=true;
							System.out.println(words[innerLoop+1] + " " + words[outerLoop] + " probability for" + " " + existingEntries.get(words[outerLoop]));
							//System.out.println(words[innerLoop+1] + " " + words[outerLoop] + " probability sum" + " " + theProbability);
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
					System.out.println("skipgram not found");
					//backoff 
	
					//if(this.perplexityLogFile) {
					//	this.perplexityDetails += " Bigram " +words[outerLoop -1] +" " +words[outerLoop] +" not found \n";
					//}
					bigramProbability = calculateProbabilityOf(words[outerLoop], words[innerLoop+1], unigram);
					//if(this.decimal) {
						//calculate the probability in decimal
						if(firstBigram) {
							theProbability = bigramProbability;
							//System.out.println("probability for " + words[outerLoop] + " " + words[innerLoop+1] + theProbability);
						/*	if(this.perplexityLogFile) {
								this.perplexityDetails += words[outerLoop - 1] + "  "  +words[outerLoop] +" " +theProbability +"\n";
							}*/
							firstBigram = false;
						} else {
						/*	if(this.perplexityLogFile) {
								this.perplexityDetails += "Multiplying " + theProbability +" * " +wordProbability + " to get ";
							}*/
							theProbability = theProbability * bigramProbability;
							//System.out.println("probability for " + words[outerLoop] + " " + words[innerLoop+1] + bigramProbability);
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
		
		
		//calculate the perplexity
		//if(this.decimal) {
			thePerplexity = Math.pow(theProbability, (-1.0/(bigramCount+1)));
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

	
		return thePerplexity;
	}


	public double calculateProbabilityOf(String word1, String word2, UnigramModel unigram) {
		int numberOfTimesSeen;
		double newCounts;
		double probabilityWord1;
		double probabilityWord2;
		double probability;
		double absoluteDiscount = 0.75;
		
		//if(this.perplexityLogFile) {
		//	this.perplexityDetails += "Calculating the probability of " +word +"\n";
		//}
		if(!unigram.unigramCounts.containsKey(word1)) {
			//if(this.perplexityLogFile) {
			//	this.perplexityDetails += "I have never seen this word before - probability = " +this.probabilityOfUnseenWord +"\n";
			//}
			probabilityWord1= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word1);
			
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
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
			probabilityWord2= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word2);
			
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
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
				newCounts = numberOfTimesSeen - absoluteDiscount;
				probabilityWord2 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
					this.perplexityDetails += "New counts is " +newCounts +"\n";
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/
			}
			
		}
		System.out.println("probability of "+word1 +": "+probabilityWord1);
		System.out.println("probability of "+word2 +": "+probabilityWord2);
		probability=(probabilityWord1 + probabilityWord2)/2;
		System.out.println("probability for bigram: "+probability);
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
	//System.out.println(" unseen words:"+ frequencyOfFrequencyCounts);
	this.probabilityOfUnseenWord = this.frequencyOfFrequencyCounts.get(1);
	this.probabilityOfUnseenWord=this.probabilityOfUnseenWord/unigram.getTotalWordCount();
	this.probabilityOfUnseenWord=this.probabilityOfUnseenWord/ this.numberOfCommonlyUsedWordsInEnglish;
	//System.out.println("Prob of unseen words is " +probabilityOfUnseenWord);
}

	public void getSkipgramCountsMethod2(String[] shortSentenceArray){
		HashMap <String, Double> existingEntries;
		int length = shortSentenceArray.length;
		int index1 = 0;
		int index2=1;
		boolean skipgramFound=false;
		String key, secondWord;
		
	
			findBigram(shortSentenceArray[index1], shortSentenceArray[index2]);
			index2++;
	
			
		
	}
	
	private boolean findBigram(String word1, String word2){
		String key, secondWord;
		HashMap <String, Double> existingEntries;
		boolean skipgramFound=false;
		if (skipBigramCounts.containsKey(word1)){
			key=word1;
			secondWord=word2;
			existingEntries=skipBigramCounts.get(key);
			if (existingEntries.containsKey(secondWord)){
				incrementCount(existingEntries, key, secondWord);		
				skipgramFound=true;
				return skipgramFound;
			}
		}
		
		if (skipgramFound==false && skipBigramCounts.containsKey(word2)) {
			key=word2;
			secondWord=word1;
			existingEntries=skipBigramCounts.get(key);
			if (existingEntries.containsKey(secondWord)){
				incrementCount(existingEntries, key, secondWord);		
				skipgramFound=true;
				return skipgramFound;
			}
		}
		return false;
	}
	
	public void findSuitableWord (char firstLetter, String originalClue, String givenWords, UnigramModel unigram, BigramModel bigram) {		
		System.out.println("\n\nClue: " + originalClue+"\n");
		TreeMap<Double, ArrayList<String>> allPerplexitiesForClues;
		TreeMap<Double, ArrayList<String>> bestCluesFoundBySkipgram;
		
		
		//ArrayList<String> wordsStartingWithChosenLetter = unigram.getAllWordsStartingWith(firstLetter);		
		ArrayList<String> wordsStartingWithChosenLetter = loadDictionaryWords(firstLetter);
		System.out.println("Number of words being tested: "+wordsStartingWithChosenLetter.size());
		
		allPerplexitiesForClues=addPerplexitiesOfCluesToMap(wordsStartingWithChosenLetter, givenWords, unigram);
		bestCluesFoundBySkipgram=getLowPerplexityClues(allPerplexitiesForClues);
		
		getBigramPerplexitiesForBestClues(givenWords, originalClue, bestCluesFoundBySkipgram, bigram, unigram);
	}

	private TreeMap<Double, ArrayList<String>> addPerplexitiesOfCluesToMap(ArrayList<String> wordsStartingWithChosenLetter, String givenWords, UnigramModel unigram) {
		TreeMap<Double, ArrayList<String>> allPerplexitiesForClues = new TreeMap<Double, ArrayList<String>>();
		ArrayList<String> words = new ArrayList<>();
		
		for (String word : wordsStartingWithChosenLetter) {
			if (!tidyUpData.unwantedWords.contains(word)){
				String completeClue = givenWords+ " " + word;	
				double perplexity = perplexityOf(completeClue, unigram);
				if (allPerplexitiesForClues.containsKey(perplexity)){
					//System.out.println("perp exists");
					words=allPerplexitiesForClues.get(perplexity);
					words.add(word);
					allPerplexitiesForClues.put(perplexity, words);
				}
				else {
					//System.out.println("perp doesnt exist");
					words=new ArrayList<>();
					words.add(word);
					allPerplexitiesForClues.put(perplexityOf(completeClue, unigram), words);
				}
			}
		}
		
		return allPerplexitiesForClues;
	}
	
	
	private void getBigramPerplexitiesForBestClues(String givenWords, String originalClue, TreeMap< Double, ArrayList<String>> wordsFoundBySkipgram, BigramModel bigram, UnigramModel unigram) {
		
		String[] shortGivenWordArray=givenWords.toLowerCase().split(" ");
		ArrayList<String> givenWordList = new ArrayList<String> (Arrays.asList(shortGivenWordArray));
		givenWordList.add("");
		String[] givenWordArray = new String[shortGivenWordArray.length+1];
		givenWordList.toArray(givenWordArray);
		String[] originalClueArray = originalClue.toLowerCase().split(" ");
		TreeMap <Double, ArrayList<String>> bigramPerplexities = new TreeMap<>();
		ArrayList <String> words;
		int count = 0 ; 
		
		//get the position of the missing word in the clue as it is important for traditional n-grams
		int position=getPositionOfMissingWord(givenWordArray, originalClueArray);
		
		String[] newClueArray= getNewArrayWithABlankForTheMissingWord(givenWordArray, originalClueArray, position);
		
		
		for (Double skipgramPerplexity: wordsFoundBySkipgram.keySet()){
			
			for (String word : wordsFoundBySkipgram.get(skipgramPerplexity)){
				newClueArray[position]=word;
			
				String completeClue="";
				boolean firstWord=true;
				double bigramPerplexity;
				
				for (int loop=0; loop<newClueArray.length; loop++){
					//System.out.println(newClueArray[loop]);
					if (firstWord){
						completeClue=newClueArray[loop];
						firstWord=false;
					}
					else{
						completeClue=completeClue+" "+newClueArray[loop];
					}
				}
					
				bigramPerplexity = bigram.perplexityOf(completeClue);
				if (bigramPerplexities.containsKey(bigramPerplexity)){
					//System.out.println("perp exists");
					words=bigramPerplexities.get(bigramPerplexity);
					words.add(word);
					bigramPerplexities.put(bigramPerplexity, words);
				}
				else {
					//System.out.println("perp doesnt exist");
					words=new ArrayList<>();
					words.add(word);
					bigramPerplexities.put(bigramPerplexity, words);
				}
			
			}
		}
		
		System.out.println("\n\nUsing bigram to filter results: \n");
		for(Double perplexity : bigramPerplexities.keySet()){
			words = bigramPerplexities.get(perplexity);
			if (count<15){
			for (String word : words){
				count = count + 1;
				System.out.println(count + ". "+word+ ": "+ perplexity  );
				}	
			}
			else break;
		}
	}
	
	private int getPositionOfMissingWord(String[] givenWordArray, String[] originalClueArray) {
		int position=99;
		//get the position of the missing word in the clue
		for (int loop=0; loop<originalClueArray.length; loop++){
			System.out.println(originalClueArray[loop]);
			System.out.println(givenWordArray[loop]);
			if (!originalClueArray[loop].equals(givenWordArray[loop])){
				position = loop;
				break;
			}
		}
		System.out.println(position + " position");
		return position;
	}

	private TreeMap<Double, ArrayList<String>> getLowPerplexityClues(TreeMap<Double, ArrayList<String>> allPerplexitiesForClues) {
		TreeMap<Double, ArrayList<String>> bestCluesFoundBySkipgram= new TreeMap<>();
		ArrayList<String> words;
		int count=0;
		System.out.println("\nTop 50 results for skip-bigram using corpus vocabulary: \n");
		for (Double perplexity: allPerplexitiesForClues.keySet()){
			words = allPerplexitiesForClues.get(perplexity);
			if (count<50){
				bestCluesFoundBySkipgram.put(perplexity, allPerplexitiesForClues.get(perplexity));
				for (String word : words){
					count = count+1;
					System.out.println(count+ ". "+ word + ": " + perplexity);
				}
				
			}
			else break;
			
		}
		return bestCluesFoundBySkipgram;
	}

	
	private String[] getNewArrayWithABlankForTheMissingWord(String[] givenWordArray, String[] originalClueArray, int position) {	
		String[] newClueArray= new String[originalClueArray.length];
		
		for (int loop=0; loop<originalClueArray.length; loop++){		
			if (loop!=position){		
				newClueArray[loop]=originalClueArray[loop];
			} else {
				newClueArray[loop]="";
			}
		}
		System.out.println(Arrays.toString(newClueArray));
		return newClueArray;

	}

	private ArrayList<String> loadDictionaryWords(char letter){
		System.out.println("letter " + letter);
		ArrayList<String> wordsStartingWithChosenLetter;
		Dictionary dictionary = new Dictionary();
		switch (letter) {
		case 'a': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadAWords().keySet());		
			return wordsStartingWithChosenLetter;
		case 'b': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadBWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'c': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadCWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'd': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadDWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'e': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadEWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'g': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadGWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'l': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadLWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'p': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadPWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'r': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadRWords().keySet());
			return wordsStartingWithChosenLetter;
		case 's': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadSWords().keySet());
			return wordsStartingWithChosenLetter;		
		case 't': wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadTWords().keySet());
			return wordsStartingWithChosenLetter;
		case 'y':  wordsStartingWithChosenLetter= new ArrayList<>(dictionary.loadYWords().keySet());
			return wordsStartingWithChosenLetter;
		}
		return null;
		
		}
		
}
