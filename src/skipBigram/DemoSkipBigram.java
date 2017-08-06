package skipBigram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Locale;

import bigram.BigramModel;
import dissertation.TidyUpData;
import dissertation.UnigramModel;
public class DemoSkipBigram {

	public static void main(String[] args) {
		System.out.println("Building the bigram model, please be patient ...\n");
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		
	
		
		SkipBigramModel skipBigram = new SkipBigramModel();
		BigramModel bigram = new BigramModel();
		//SkipTrigramModel skipTrigram = new SkipTrigramModel();
		UnigramModel unigram = new UnigramModel();	
		TidyUpData tidyUpData= new TidyUpData();
		
		File file = new File("largeData.txt");
		FileInputStream fis = null;
		BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.UK);
		BufferedReader br=null;
		
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
					theSentence= theSentence.replaceAll("–", "");
					//System.out.println("after removing non alpha num: " + theSentence);
					theSentence = theSentence.replaceAll("\\s+", " ");
					//System.out.println("after removing spaces: " + theSentence);
					//System.out.println("\nDealing with: " +theSentence);
					//break sentence into an array of words
					String[] shortSentenceArray=tidyUpData.removeStopWords(theSentence);	
					//remove all non-alphanumerical characters and convert to lower case
					String[] shortSentenceArrayTidiedUp=tidyUpData.removeNonAlphaNumericChars(shortSentenceArray);	
					
					//System.out.println("After tidying up the sentence: "+Arrays.toString(shortSentenceArrayTidiedUp));
					//get unigram counts
					unigram.countEachWord(shortSentenceArrayTidiedUp);
					//get skip-bigram counts
					skipBigram.getSkipBigramCounts(shortSentenceArrayTidiedUp);	
					//System.out.println("All skip-bigrams: "+skipBigram.skipBigramCounts);
					noOfSentences++;
				}
			}
			//calculate probabilities
			skipBigram.computeFrequencyOfFrequencyCounts(unigram);
			skipBigram.calculateProbabilityOfUnseenWords(unigram);
			skipBigram.calculateProbability(unigram);
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				endTime = System.nanoTime();
				double duration = (endTime - startTime) / 1000000000.0;
				System.out.println("\n\nI have built the model in " +duration +" seconds");
				System.out.println("No of sentences: " + noOfSentences);
				System.out.println("Word count: "+ unigram.getTotalWordCount());
			/*	System.out.println("\nBigram outcomes: \n");
				skipBigram.perplexityOf("Jeremy Corbyn", unigram);
				skipBigram.perplexityOf("Jeremy Corbin", unigram);
				skipBigram.perplexityOf("The man walked", unigram);
				skipBigram.perplexityOf("The man walked to the pub", unigram);
				skipBigram.perplexityOf("To the pub walked the man", unigram);
				skipBigram.perplexityOf("walked the man to the pub", unigram);
				//skipBigram.perplexityOf("A politician walked to the office", unigram);
				skipBigram.perplexityOf("Jeremy Corbyn is the new Labour party leader", unigram);
				skipBigram.perplexityOf("bananas and cream", unigram);
				skipBigram.perplexityOf("bananas and cream bananas and cream", unigram);
				skipBigram.perplexityOf("Jeremy Corbyn decided to immigrate to the USA", unigram);*/
				System.out.println("\n\n --------------\n\n");
				
				skipBigram.perplexityOf("Project leader is not pleased with gifts", unigram);
				skipBigram.perplexityOf("Party leader is not pleased with gifts", unigram);
				//skipBigram.perplexityOf("Poets start drinking in pubs", unigram);
				/*skipBigram.findSuitableWord('c',"Start chopping wood for money", "Start wood for money", unigram, bigram);
				skipBigram.findSuitableWord('c',"Cobbler initially records footwear", "initially records footwear", unigram, bigram);
				skipBigram.findSuitableWord('d',"Poets start drinking in pubs", "poets start in pubs", unigram, bigram);
				skipBigram.findSuitableWord('d',"Might death start to appear unnatural", "Might start to appear unnatural", unigram, bigram);
				skipBigram.findSuitableWord('d',"Cut out tax before start of December", "Cut out tax before start of ", unigram, bigram);	
				skipBigram.findSuitableWord('e',"Thin boxes were empty initially", "Thin boxes initially", unigram, bigram);	
				skipBigram.findSuitableWord('g', "Row about head of ginger cat", "Row about head of cat", unigram, bigram);
				skipBigram.findSuitableWord('g', "Geoff’s beginning to wander in a small wood", "beginning to wander in a small wood", unigram, bigram);
				skipBigram.findSuitableWord('g', "Sovereign the family start grabbing", "Sovereign the family start", unigram, bigram);
				skipBigram.findSuitableWord('l', "A labour leader taking many shares out", "A leader taking many shares out", unigram, bigram);
				skipBigram.findSuitableWord('l', "Family with first of loaves in oven", "Family with first of in oven", unigram, bigram);
				skipBigram.findSuitableWord('p', "Clothing was initially provided by social workers", "Clothing initially by social workers", unigram, bigram);
				skipBigram.findSuitableWord('p', "Party leader is not pleased with gifts", "leader is not pleased with gifts", unigram, bigram);
				skipBigram.findSuitableWord('p', "Start pulling strings for situations", "Start strings for situations", unigram, bigram);
				skipBigram.findSuitableWord('r', "Singer producing sick note before start of recital", "Singer producing sick note before start of", unigram, bigram);
				skipBigram.findSuitableWord('r', "Artificial people start running with kinky boots", "Artificial people start with kinky boots", unigram, bigram);
				skipBigram.findSuitableWord('s', "Scottish leader with horse problem", "leader with horse problem", unigram, bigram);
				skipBigram.findSuitableWord('s', "Talk with Spanish leader at summit", "Talk with leader at summit", unigram, bigram);
				skipBigram.findSuitableWord('y', "Airbourne youth leader gets cast out", "Airbourne leader gets cast out", unigram, bigram);
				skipBigram.findSuitableWord('y', "Tin containing first of yellow colour", "Tin containing first of colour", unigram, bigram);
				skipBigram.findSuitableWord('t', "Check the accounts of German car trader first", "Check the accounts of German car first", unigram, bigram);
				skipBigram.findSuitableWord('t', "Concealed lid on top of tin", "Concealed lid on top of", unigram, bigram);
				skipBigram.findSuitableWord('a', "American leader getting cheeky again", "leader getting cheeky again", unigram, bigram);
				skipBigram.findSuitableWord('b', "Splendid bottle opener splendid", "Splendid opener splendid", unigram, bigram);
				*/
				
				//System.out.println("\n\nTrigram outcomes: \n");		
				//skipTrigram.perplexityOf("The man walked to the pub", unigram);
				//skipBigram.perplexityOf("A child walked to the pub", unigram);		
				//skipTrigram.perplexityOf("A politician walked to the office", unigram);
				//skipTrigram.perplexityOf("Jeremy Corbyn is the new Labour party leader", unigram);	
				//skipTrigram.perplexityOf("Jeremy Corbyn decided to immigrate to the USA", unigram);	
				//skipTrigram.perplexityOf("bananas and cream", unigram);
				//skipTrigram.perplexityOf("Woman walked to a pub", unigram);
				
				if (br !=null){
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
