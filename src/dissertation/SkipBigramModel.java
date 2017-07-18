package dissertation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class SkipBigramModel {
	public SkipBigramModel() {}
	TreeMap <String, TreeMap <String, Double>> skipBigramCounts = new TreeMap <String, TreeMap <String, Double>> ();	
	TreeMap <String, Double> existingEntries;
	TreeMap <String, TreeMap <String, Double>> skipBigramProbability;
	TreeMap <Integer, Integer> frequencyOfFrequencyCounts = new TreeMap <Integer, Integer> (); 
	double probabilityOfUnseenWord;
	
	public void getSkipBigramCounts(String[] shortSentenceArray) {

		//pick the key word
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-1; outerLoop++){
			//skip over each word in the sentence
			for (int innerLoop=outerLoop; innerLoop<shortSentenceArray.length-1; innerLoop++){	
				//flag for finding an existing trigram
				boolean skipgramFound=false;

				String key= null;
				String secondWord=null;
				
				System.out.println("1st word: " +shortSentenceArray[outerLoop]);
				System.out.println("2nd word: " + shortSentenceArray[innerLoop+1]);	
				
				//if first word exists as a key
				if (skipBigramCounts.containsKey(shortSentenceArray[outerLoop])) {
					
					//record the key word for future use in case an exact match is not found
					key=recordWord(key, shortSentenceArray[outerLoop]);
					secondWord=recordWord(secondWord, shortSentenceArray[innerLoop+1]);
					
					//get the map of existing entries for the keyword
					existingEntries = skipBigramCounts.get(shortSentenceArray[outerLoop]);
					
					//if key and value exist increment count
					if(existingEntries.containsKey(shortSentenceArray[innerLoop+1])){ 		
						incrementCount(existingEntries, shortSentenceArray[outerLoop], shortSentenceArray[innerLoop+1]);		
						skipgramFound=true;
					}
					
				//if key does not exist reverse first and second word
				}else if(skipBigramCounts.containsKey(shortSentenceArray[innerLoop+1])) {
					
					//record the key word for future use in case an exact match is not found
					key=recordWord(key, shortSentenceArray[innerLoop+1]);
					secondWord=recordWord(secondWord, shortSentenceArray[outerLoop]);
					
					//get the map of existing entries for the keyword
					existingEntries = skipBigramCounts.get(shortSentenceArray[innerLoop+1]);
					
					//if key and value exist increment count
					if(existingEntries.containsKey(shortSentenceArray[outerLoop])) {
						incrementCount(existingEntries,shortSentenceArray[innerLoop+1], shortSentenceArray[outerLoop]);	
						skipgramFound=true;
					}
							
				}
				
				//if only a key word was found add a new value to it
				if (skipgramFound==false && key!=null) {
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
		TreeMap<String, Double> newEntry = new TreeMap<String, Double>();
		newEntry.put(occursWithKey, 1.0);
		skipBigramCounts.put(key, newEntry);
		System.out.println(skipBigramCounts + " all skipgrams after adding new entry");
	}

	public void addNewValue (TreeMap<String, Double> existingEntries, String key, String occursWithKey){
		existingEntries.put(occursWithKey, 1.0);
		skipBigramCounts.put(key, existingEntries);
		System.out.println(skipBigramCounts + " all skipgrams after adding new value");
	}
	
	public void incrementCount(TreeMap <String, Double> existingEntries, String key, String occursWithKey ){
		existingEntries.put(occursWithKey, (existingEntries.get(occursWithKey)+1.0));
		System.out.println(skipBigramCounts + " all skipgrams after incrementing");
		skipBigramCounts.put(key, existingEntries);
	}
	
	public void calculateProbability(UnigramModel unigram) {
		System.out.println("About to calculate bigram probabilities");
		//copy the bigram count
		this.skipBigramProbability = this.skipBigramCounts;
		double wordsTogetherCount;
		int wordCountOuter;
		int wordCountInner;
		double probability;
		boolean display = true;
		
		for(String outerWord : this.skipBigramProbability.keySet()) {
			for(String innerWord : this.skipBigramProbability.get(outerWord).keySet()) {
				if(display) {
					System.out.println("Testing " +outerWord +" and " +innerWord);	
				}
				wordsTogetherCount = this.skipBigramProbability.get(outerWord).get(innerWord);
				if(display) {
					System.out.println("Word together count " +wordsTogetherCount);	
				}
				wordCountOuter = unigram.unigramCounts.get(outerWord);
				wordCountInner = unigram.unigramCounts.get(innerWord);
				if(display) {
					System.out.println("Word count for " + outerWord + " : " +wordCountOuter);	
					System.out.println("Word count for " + innerWord + " : " +wordCountInner);	
				}
			
				
				if(wordsTogetherCount == 0) {
						System.out.println("Found a zero");
				}
				
				probability = (double) (wordsTogetherCount/ wordCountOuter + wordsTogetherCount/wordCountInner)/2;

				if(display) {
					System.out.println(outerWord + " " +innerWord +" = " + probability);	
				}
				//if(decimal) {
					//the code below leaves the probabilities in decimal - use only for inspecting probability file
				//	this.skipBigramProbability.get(outerWord).put(innerWord, probability);					
				//} else {
					//Use log(prob)
				//	this.skipBigramProbability.get(outerWord).put(innerWord, Math.log10(probability));	
				//}
				
			}
		}
	//	if(this.printToFile) {
	//		printProbability();
	//	}
		
	}
	
	public double perplexityOf(String clue, UnigramModel unigram) {
		//System.out.println("About to calculate perplexity");
		clue = clue.toLowerCase();
		double theProbability = 0;
		double thePerplexity;
		int length;
		boolean firstWord = true;
		String [] words;
		ArrayList <String> theWords;
		double wordProbability;
		
		//convert to an array of words
		words = clue.split(" ");
		
		//convert to an ArrayList
		//theWords = new ArrayList <String>(Arrays.asList(words));
		//theWords.add(0, "<s>");
		//theWords.add(theWords.size(), "</s>");
		//length = theWords.size();
		
		//convert back to an array
		//words = new String[theWords.size()];
		//words = theWords.toArray(words);
		
		boolean foundProbability = false;
		String key=null;
			
		//iterate across the array of words
		for(int outerLoop = 0; outerLoop < words.length; outerLoop++) {
			for (int innerLoop=outerLoop; innerLoop < words.length; innerLoop++ ){
				//if the  word is listed in the probability table
				if(this.skipBigramProbability.containsKey(words[outerLoop])) {				
					//word i-1 is found
					//System.out.println("word i-1 found " +words[loop - 1]);
					//System.out.println("word i " +words[loop]);
					//get a treemap of word/probability for the word we are dealing with (words[loop - 1])
					existingEntries = this.skipBigramProbability.get(words[outerLoop]);
					
					//test
					//System.out.println("FOR " +words[loop - 1]);
					//for(String tempWord : existingEntry.keySet()) {
						//System.out.println(tempWord);
					//}
					if(existingEntries.containsKey(words[innerLoop+1])) {
						//word i is found and so the bigram is found
						//System.out.println("Word i found " +words[loop]);
						//if(this.decimal) {
							//calculate the probability in decimal
							if(firstWord) {
								theProbability = existingEntries.get(words[innerLoop+1]);
								foundProbability=true;
								firstWord=false;
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
							}
				}
					
				//if probability not found, reverse key and value
				if (foundProbability==false && this.skipBigramProbability.containsKey(words[innerLoop+1])){
					existingEntries = this.skipBigramProbability.get(words[innerLoop+1]);
					
					if(existingEntries.containsKey(outerLoop)){
						if (firstWord){
						theProbability=existingEntries.get(outerLoop);
						foundProbability=true;
						firstWord=false;
						} else {
							theProbability= theProbability * existingEntries.get(outerLoop);
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
					//backoff 
	
					//if(this.perplexityLogFile) {
					//	this.perplexityDetails += " Bigram " +words[outerLoop -1] +" " +words[outerLoop] +" not found \n";
					//}
					wordProbability = calculateProbabilityOf(words[outerLoop], unigram);
					//if(this.decimal) {
						//calculate the probability in decimal
						if(firstWord) {
							theProbability = wordProbability;
						/*	if(this.perplexityLogFile) {
								this.perplexityDetails += words[outerLoop - 1] + "  "  +words[outerLoop] +" " +theProbability +"\n";
							}*/
							firstWord = false;
						} else {
						/*	if(this.perplexityLogFile) {
								this.perplexityDetails += "Multiplying " + theProbability +" * " +wordProbability + " to get ";
							}*/
							theProbability = theProbability * wordProbability;
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
					
				}
				
			} else {
				//Bi gram not found - lets use the unigram count
				//if(this.perplexityLogFile) {
					this.perplexityDetails += "Bigram " +words[loop -1] +" - " +words[loop] +" not found\n ";
				}
				wordProbability = calculateProbabilityOf(words[loop]);
				if(this.decimal) {
					//calculate the probability in decimal
					if(firstWord) {
						theProbability = wordProbability;
						if(this.perplexityLogFile) {
							this.perplexityDetails += words[loop - 1] + "  "  +words[loop] +" " +theProbability +"\n";
						}
						firstWord = false;
					} else {
						if(this.perplexityLogFile) {
							this.perplexityDetails += "Multiplying " + theProbability +" * " +wordProbability + " to get ";
						}
						theProbability = theProbability * wordProbability;
						if(this.perplexityLogFile) {
							this.perplexityDetails += theProbability +"\n";
						}
													
					}
				} else {
					//calculate the probability in logarithms
					wordProbability = Math.log10(wordProbability);
					if(this.perplexityLogFile) {
						this.perplexityDetails += "Adding " + theProbability +" + " +wordProbability + " to get ";
					}
					theProbability = theProbability + wordProbability;
					if(this.perplexityLogFile) {
						this.perplexityDetails += theProbability +"\n";
					}
				}
			}
		}
		
		//calculate the perplexity
		if(this.decimal) {
			thePerplexity = Math.pow(theProbability, (-1.0/length));
		} else {
			//convert back to decimal before calculating perplexity
			thePerplexity = Math.pow(Math.pow(10, theProbability), (-1.0/length));
		}
		
		//If using individual calls print details in console
		if(!this.bulkLoad) {
			//System.out.println(clue);
			//System.out.println("Probability = " +theProbability);
			//System.out.println("Perplexity = " +thePerplexity +"\n\n");	
		} 
		
		

		
		//Not happy with this here - but  will move when model is finalised
		if(this.perplexityLogFile  && !this.bulkLoad) {
			this.perplexityDetails += clue +"\n";
			this.perplexityDetails += "Probability " +theProbability +"\n";
			this.perplexityDetails += "Perplexity " +thePerplexity +"\n\n\n";
			
			printPerplexityDetails();
		}

		
		System.out.println(thePerplexity +"   " +clue);
		return thePerplexity;
	}
}

public double calculateProbabilityOf(String word, UnigramModel unigram) {
	double numberOfTimesSeen;
	double newCounts;
	double probability;
	double absoluteDiscount = 0.75;
	
	//if(this.perplexityLogFile) {
	//	this.perplexityDetails += "Calculating the probability of " +word +"\n";
	//}
	if(!unigram.unigramCounts.containsKey(word)) {
		//if(this.perplexityLogFile) {
		//	this.perplexityDetails += "I have never seen this word before - probability = " +this.probabilityOfUnseenWord +"\n";
		//}
		return this.probabilityOfUnseenWord;
		
	} else {
		numberOfTimesSeen = unigram.unigramCounts.get(word);
		
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
			probability = newCounts / unigram.getTotalWordCount();
			/*if(this.perplexityLogFile) {
				this.perplexityDetails += "Probability is " +probability +"\n";
			}*/
			return probability;
		} else {
			newCounts = numberOfTimesSeen - absoluteDiscount;
			probability = newCounts / unigram.getTotalWordCount();
			/*if(this.perplexityLogFile) {
				this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
				this.perplexityDetails += "New counts is " +newCounts +"\n";
				this.perplexityDetails += "Probability is " +probability +"\n";
			}*/
			
			return probability;
		}
		
	}

}

}
