package skipTrigram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


import dissertation.TidyUpData;
import dissertation.UnigramModel;
import skipBigram.SkipBigramModel;

public class DemoSkipTrigram {

	public static void main(String[] args) {
		System.out.println("Building the trigram model, please be patient ...");
		long startTime;
		long endTime;
	
		startTime = System.nanoTime();
			
		SkipBigramModel skipBigram = new SkipBigramModel();
		
		SkipTrigramModel skipTrigram = new SkipTrigramModel();
		UnigramModel unigram = new UnigramModel();	
		TidyUpData tidyUpData= new TidyUpData();
		
		File file = new File("largeData.txt");
		FileInputStream fis = null;
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.UK);
		BufferedReader br=null;
		
		tidyUpData.collectUnwantedWords();
		int noOfSentences=0;	
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
					//System.out.println("before removing non alpha num: " + theSentence);
					theSentence= theSentence.replaceAll("[^A-Za-z0-9\\s]", "");
					theSentence= theSentence.replaceAll("�", "");
					//System.out.println("after removing non alpha num: " + theSentence);
					theSentence = theSentence.replaceAll("\\s+", " ");
					//System.out.println("after removing spaces: " + theSentence);
					//System.out.println("Dealing with: " +theSentence);
					//break sentence into an array of words
					String[] shortSentenceArray=tidyUpData.removeStopWords(theSentence);	
					//remove all non-alphanumerical characters and convert to lower case
					String[] shortSentenceArrayTidiedUp=tidyUpData.removeNonAlphaNumericChars(shortSentenceArray);	
					
					//System.out.println(Arrays.toString(shortSentenceArrayTidiedUp));
					//get unigram counts
					unigram.countEachWord(shortSentenceArrayTidiedUp);
					//get skip-bigram counts
					skipBigram.getSkipBigramCounts(shortSentenceArrayTidiedUp);	
					//skipTrigram.getSkipTrigramCounts(shortSentenceArrayTidiedUp, skipBigram.skipBigramCounts);
					if(shortSentenceArrayTidiedUp.length<7){
						skipTrigram.getSkipTrigramCountsMethod3(shortSentenceArrayTidiedUp, skipBigram.skipBigramCounts);
					}else if (shortSentenceArrayTidiedUp.length>6 && shortSentenceArrayTidiedUp.length<13){
						tidyUpData.splitSentenceIntoTwo(shortSentenceArrayTidiedUp, skipTrigram, skipBigram);				
					} else if (shortSentenceArrayTidiedUp.length>12 && shortSentenceArrayTidiedUp.length<19) {
					
						tidyUpData.splitSentenceIntoThree(shortSentenceArrayTidiedUp, skipTrigram, skipBigram);		
					}else {
						
						tidyUpData.splitSentenceIntoFour(shortSentenceArrayTidiedUp, skipTrigram, skipBigram);	
					}	
					//skipTrigram.getSkipTrigramCounts(shortSentenceArrayTidiedUp, skipBigram.skipBigramCounts);
					//System.out.println("\nall skiptrigrams at the end of the method: "+skipTrigram.skipTrigrams);
					noOfSentences++;
					//System.out.println("heree");
				}
			}
			//calculate probabilities
			//System.out.println("here");
			
			skipBigram.computeFrequencyOfFrequencyCounts(unigram);
			skipTrigram.computeFrequencyOfFrequencyCounts(unigram);
			skipBigram.calculateProbabilityOfUnseenWords(unigram);
			skipTrigram.calculateProbabilityOfUnseenWords(unigram);
			skipTrigram.calculateProbability(skipBigram.skipBigramCounts);
			skipBigram.calculateProbability(unigram);
			System.out.println(skipBigram.skipBigramProbability.keySet().size());
			System.out.println(skipTrigram.skipTrigramProbability.keySet().size());
		

			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				endTime = System.nanoTime();
				double duration = (endTime - startTime) / 1000000000.0;
				System.out.println("I have built the model in " +duration +" seconds \n");
				// Get current size of heap in bytes
				long heapSize = Runtime.getRuntime().totalMemory();
				System.out.println("heapsize: " + heapSize);
				// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
				// Any attempt will result in an OutOfMemoryException.
				long heapMaxSize = Runtime.getRuntime().maxMemory();
				System.out.println("heap maz size: " + heapMaxSize);
				// Get amount of free memory within the heap in bytes. This size will increase
				// after garbage collection and decrease as new objects are created.
				long heapFreeSize = Runtime.getRuntime().freeMemory();
				System.out.println("heap free size: " +heapFreeSize);
				System.out.println("No of sentences: " + noOfSentences);
				System.out.println("No of keys in bigram count: "+ skipBigram.skipBigramCounts.keySet().size());
				System.out.println("No of entries in tri count: "+ skipTrigram.skipTrigramCounts.keySet().size());
				
				System.out.println(unigram.getTotalWordCount() +" word count \n\n");
				
				//System.out.println("first key:" +skipBigram.skipBigramCounts.firstKey());
				//System.out.println("last key: " +skipBigram.skipBigramCounts.lastKey());
				//System.out.println("counts: "+skipBigram.skipBigramCounts);
				//System.out.println("probabilities: "+skipBigram.skipBigramProbability);
				System.out.println("Bigram outcomes: \n");
				/*skipBigram.perplexityOf("Jeremy Corbyn", unigram);
				skipBigram.perplexityOf("Jeremy Corbin", unigram);
				skipBigram.perplexityOf("The man walked", unigram);
				skipBigram.perplexityOf("The man walked to the pub", unigram);
				skipBigram.perplexityOf("To the pub walked the man", unigram);
				skipBigram.perplexityOf("walked the man to the pub", unigram);
				skipBigram.perplexityOf("A politician walked to the office", unigram);
				skipBigram.perplexityOf("Jeremy Corbyn is the new Labour party leader", unigram);
				skipBigram.perplexityOf("bananas and cream", unigram);
				skipBigram.perplexityOf("bananas and cream bananas and cream", unigram);*/
				
				//System.out.println("\n\nTrigram outcomes: \n");	
				skipTrigram.perplexityOf("The man walked to the pub", unigram);
				//skipBigram.perplexityOf("A child walked to the pub", unigram);		
				skipTrigram.perplexityOf("A politician walked to the office", unigram);
				skipTrigram.perplexityOf("Jeremy Corbyn is the new Labour party leader", unigram);	
				skipTrigram.perplexityOf("Jeremy Corbyn decided to immigrate to the USA", unigram);	
				skipTrigram.perplexityOf("bananas and cream bananas and cream", unigram);
				//skipTrigram.perplexityOf("Woman walked to a pub", unigram);
				skipTrigram.findSuitableWord("W", "Start wood for money", unigram);
				if (br !=null){
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
