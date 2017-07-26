package dissertation;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import skipBigram.SkipBigramModel;
import skipTrigram.SkipTrigramModel;

public class TidyUpData {

	public TidyUpData(){}
	
	ArrayList <String> unwantedWords = new ArrayList();
	
	public void	collectUnwantedWords() {	
		this.unwantedWords.add("a");
		this.unwantedWords.add("the");
		this.unwantedWords.add("to");
		this.unwantedWords.add("is");
		this.unwantedWords.add("am");
		this.unwantedWords.add("and");
		this.unwantedWords.add("he");
		this.unwantedWords.add("was");
		this.unwantedWords.add("not");
		this.unwantedWords.add("with");
		this.unwantedWords.add("we");
		this.unwantedWords.add("can");
		this.unwantedWords.add("could");
		this.unwantedWords.add("would");
		this.unwantedWords.add("-");
		}
	

	
	public String[] removeStopWords(String theSentence){		
		ArrayList <String> shortSentenceList = new ArrayList<String>();
		String[] arrayOfWords = theSentence.split(" ");	
		for(int loop=0; loop<arrayOfWords.length; loop++){
			if(!unwantedWords.contains(arrayOfWords[loop].toLowerCase())){	
				shortSentenceList.add(arrayOfWords[loop].toLowerCase());
			}
		}
		String[] shortSentenceArray = new String[shortSentenceList.size()];
		for (int loop=0; loop<shortSentenceList.size(); loop++){
			shortSentenceArray[loop]=shortSentenceList.get(loop);
		}
		return shortSentenceArray;
	}
	
	public String[] removeNonAlphaNumericChars (String [] shortSentenceArray){
		ArrayList<String> shortSentenceListTidiedUp= new ArrayList<String>();
		for (int loop = 0; loop<shortSentenceArray.length; loop ++) {	
			String tidiedWord= shortSentenceArray[loop].replaceAll("[^A-Za-z0-9]", "");
			if(!shortSentenceArray[loop].isEmpty()){
			shortSentenceListTidiedUp.add(tidiedWord);
			}
		}
		String [] shortSentenceArrayTidiedUp = shortSentenceListTidiedUp.toArray(new String[shortSentenceListTidiedUp.size()]);
		return shortSentenceArrayTidiedUp;
	}

	public void splitSentenceIntoTwo(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length;
		if(shortSentenceArrayTidiedUp.length % 2==0){
			////System.out.println("even");
			length =shortSentenceArrayTidiedUp.length/2;
			String[] firstHalfOfSentence = new String[length];
			
			for (int firstLoop=0; firstLoop<length; firstLoop++){
				firstHalfOfSentence[firstLoop]=shortSentenceArrayTidiedUp[firstLoop];
			}
			int deduct=0;
			String[] secondHalfOfSentence = new String[length];
			for (int secondLoop=length-1; secondLoop>-1; secondLoop--){	
				secondHalfOfSentence[secondLoop]=shortSentenceArrayTidiedUp[shortSentenceArrayTidiedUp.length-1-deduct];
				deduct++;
			}
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstHalfOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondHalfOfSentence, skipBigram.skipBigramCounts);
		} else {
			////System.out.println("odd");
			int length1, length2;
			length1 =shortSentenceArrayTidiedUp.length/2;
			length2=(shortSentenceArrayTidiedUp.length/2)+1;
			String[] firstHalfOfSentence = new String[length1];
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstHalfOfSentence[firstLoop]=shortSentenceArrayTidiedUp[firstLoop];
			}
			int deduct=0;
			String[] secondHalfOfSentence = new String[length2];
			for (int secondLoop=length2-1; secondLoop>-1; secondLoop--){	
				secondHalfOfSentence[secondLoop]=shortSentenceArrayTidiedUp[shortSentenceArrayTidiedUp.length-1-deduct];
				deduct++;
			}
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstHalfOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondHalfOfSentence, skipBigram.skipBigramCounts);
		}
	}
	
	public void splitSentenceIntoThree(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length1, length2;
		String[] firstThirdOfSentence;
		String[] secondThirdOfSentence;
		String[] lastThirdOfSentence;
		ArrayList<String>wordList = new ArrayList<>();
		for (int loop=0; loop<shortSentenceArrayTidiedUp.length; loop++){
			wordList.add(shortSentenceArrayTidiedUp[loop]);
		}
		if(shortSentenceArrayTidiedUp.length % 3==0){						
			length1 =shortSentenceArrayTidiedUp.length/3;	
			firstThirdOfSentence = new String[length1];
			secondThirdOfSentence = new String[length1];
			lastThirdOfSentence = new String[length1];
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				lastThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(lastThirdOfSentence, skipBigram.skipBigramCounts);
		} else if (shortSentenceArrayTidiedUp.length % 3==1) {
			////System.out.println("odd");
			length1 = shortSentenceArrayTidiedUp.length/3;
			length2 = shortSentenceArrayTidiedUp.length/3+1;
			firstThirdOfSentence = new String[length1];
			secondThirdOfSentence = new String[length1];
			lastThirdOfSentence = new String[length2];
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length2; firstLoop++){
				lastThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(lastThirdOfSentence, skipBigram.skipBigramCounts);
		
	}else if(shortSentenceArrayTidiedUp.length % 3==2) {
			////System.out.println("odd");
			length1 = shortSentenceArrayTidiedUp.length/3;
			length2 = shortSentenceArrayTidiedUp.length/3+2;
			firstThirdOfSentence = new String[length1];
			secondThirdOfSentence = new String[length1];
			lastThirdOfSentence = new String[length2];
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length2; firstLoop++){
				lastThirdOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(lastThirdOfSentence, skipBigram.skipBigramCounts);
		}
	}
	
	public void splitSentenceIntoFour(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length1, length2;
		String[] firstQOfSentence;
		String[] secondQOfSentence;
		String[] thirdQOfSentence;
		String[] fourthQOfSentence;
		ArrayList<String>wordList = new ArrayList<>();
		for (int loop=0; loop<shortSentenceArrayTidiedUp.length; loop++){
			wordList.add(shortSentenceArrayTidiedUp[loop]);
			//System.out.println(shortSentenceArrayTidiedUp[loop]);
		}
		
		if(shortSentenceArrayTidiedUp.length % 4==0){						
			length1 =shortSentenceArrayTidiedUp.length/4;	
			firstQOfSentence = new String[length1];
			secondQOfSentence = new String[length1];
			thirdQOfSentence = new String[length1];
			fourthQOfSentence = new String[length1];
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				thirdQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				fourthQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(fourthQOfSentence, skipBigram.skipBigramCounts);
			
		} else if (shortSentenceArrayTidiedUp.length % 4==1) {
			length1 =shortSentenceArrayTidiedUp.length/4;	
			length2 = shortSentenceArrayTidiedUp.length/4+1;
			firstQOfSentence = new String[length1];
			secondQOfSentence = new String[length1];
			thirdQOfSentence = new String[length1];
			fourthQOfSentence = new String[length2];
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				thirdQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length2; firstLoop++){
				fourthQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(fourthQOfSentence, skipBigram.skipBigramCounts);
			
	}else if(shortSentenceArrayTidiedUp.length % 4==2) {
		
		length1 =shortSentenceArrayTidiedUp.length/4;	
		length2 = shortSentenceArrayTidiedUp.length/4+2;
		firstQOfSentence = new String[length1];
		secondQOfSentence = new String[length1];
		thirdQOfSentence = new String[length1];
		fourthQOfSentence = new String[length2];
		
		for (int firstLoop=0; firstLoop<length1; firstLoop++){
			//System.out.println("loop 1 pos 0: "+wordList.get(0));
			firstQOfSentence[firstLoop]=wordList.get(0);
			wordList.remove(0);				
		}
		
		for (int firstLoop=0; firstLoop<length1; firstLoop++){
			//System.out.println("\nloop 2pos 0: "+wordList.get(0));
			secondQOfSentence[firstLoop]=wordList.get(0);
			wordList.remove(0);			
		}
		for (int firstLoop=0; firstLoop<length1; firstLoop++){
			//System.out.println("loop 3 pos 0: "+wordList.get(0));
			thirdQOfSentence[firstLoop]=wordList.get(0);
			wordList.remove(0);				
		}
		for (int firstLoop=0; firstLoop<length2; firstLoop++){
			fourthQOfSentence[firstLoop]=wordList.get(0);
			wordList.remove(0);
			//System.out.println("\nloop 4 pos 0: "+ fourthQOfSentence[firstLoop]);			
		}
		
		//System.out.println("here");
		//System.out.println(Arrays.toString(firstQOfSentence));
		//System.out.println(Arrays.toString(fourthQOfSentence));
		//System.out.println("here");
		//get skip-trigram counts
		skipTrigram.getSkipTrigramCountsMethod3(firstQOfSentence, skipBigram.skipBigramCounts);	
		skipTrigram.getSkipTrigramCountsMethod3(secondQOfSentence, skipBigram.skipBigramCounts);
		skipTrigram.getSkipTrigramCountsMethod3(thirdQOfSentence, skipBigram.skipBigramCounts);
		skipTrigram.getSkipTrigramCountsMethod3(fourthQOfSentence, skipBigram.skipBigramCounts);
		
		} else if(shortSentenceArrayTidiedUp.length % 4==3) {
			
			length1 =shortSentenceArrayTidiedUp.length/4;	
			length2 = shortSentenceArrayTidiedUp.length/4+3;
			firstQOfSentence = new String[length1];
			secondQOfSentence = new String[length1];
			thirdQOfSentence = new String[length1];
			fourthQOfSentence = new String[length2];
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				firstQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				secondQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length1; firstLoop++){
				thirdQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			for (int firstLoop=0; firstLoop<length2; firstLoop++){
				fourthQOfSentence[firstLoop]=wordList.get(0);
				wordList.remove(0);				
			}
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsMethod3(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsMethod3(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsMethod3(fourthQOfSentence, skipBigram.skipBigramCounts);
			
			}
	}
}
