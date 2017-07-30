package dissertation;

import java.awt.peer.SystemTrayPeer;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;

import skipBigram.SkipBigramModel;
import skipTrigram.SkipTrigramModel;

public class TidyUpData {
	ArrayList <String> unwantedWords = new ArrayList();
	public TidyUpData(){
		
		String [] unwantedWordsArray = {"the","i","you","and","a","to","it","of","that","in","yeah","was","he","on","no","oh","is","have","well","its","for","what","she","one","but","they","do","not","we","there","be","so","with","had","dont","at","this","thats","all","as","mm","like","her","go","if","just","up","get","then","are","can","his","yes","right","me","think","them","out","er","or","two","were","your","now","about","when","erm","see","im","did","been","by","from","my","him","would","want","mean","going","cos","here","some","come","an","put","how","could","ive","really","ill","very","three","look","hes","didnt","back","will","which","only","youre","say","theres","more","cant","off","who","where","gonna","five","four","why","over","bit","something","any","because","theyre","alright","other","has","youve","way","much","their","shes","into","went","these","ah","isnt","whats","done","doing","might","thing","than","last","before","first","too","havent","six","should","quite","sort","hundred","never","need","still","does","though","those","round","after","us","long","new","lot","doesnt","must","another","weve","away","twenty","even","half","make", "give","wouldnt","seven","okay","probably","eight","n","through", "always","things","ten","our","actually"};
		
		unwantedWords.addAll(Arrays.asList(unwantedWordsArray));
		/*this.unwantedWords.add("a");
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
		this.unwantedWords.add("—");
		this.unwantedWords.add(":");*/
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
			shortSentenceListTidiedUp.add(tidiedWord.toLowerCase());
			}
		}
		String [] shortSentenceArrayTidiedUp = shortSentenceListTidiedUp.toArray(new String[shortSentenceListTidiedUp.size()]);
		return shortSentenceArrayTidiedUp;
	}

	/*public void splitSentenceIntoTwo(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length1, length2;
		ArrayList<String>wordList = addAllWordsToList(shortSentenceArrayTidiedUp);
		if(shortSentenceArrayTidiedUp.length % 2==0){
			////System.out.println("even");
			length1 =shortSentenceArrayTidiedUp.length/2;		
			String[] firstHalfOfSentence =createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstHalfOfSentence);  
			String[] secondHalfOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
	
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstHalfOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondHalfOfSentence, skipBigram.skipBigramCounts);
		} else {
			////System.out.println("odd");
			length1 =shortSentenceArrayTidiedUp.length/2;
			length2=(shortSentenceArrayTidiedUp.length/2)+1;
			String[] firstHalfOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstHalfOfSentence);
			String[] secondHalfOfSentence =  createArray(shortSentenceArrayTidiedUp, length2, wordList);

			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstHalfOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondHalfOfSentence, skipBigram.skipBigramCounts);
		}
	}
	
	public void splitSentenceIntoThree(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length1, length2;
		String[] firstThirdOfSentence;
		String[] secondThirdOfSentence;
		String[] lastThirdOfSentence;
		ArrayList<String>wordList = addAllWordsToList(shortSentenceArrayTidiedUp);
		if(shortSentenceArrayTidiedUp.length % 3==0){						
			length1 =shortSentenceArrayTidiedUp.length/3;	
			firstThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstThirdOfSentence);
			secondThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondThirdOfSentence);
			lastThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);

			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(lastThirdOfSentence, skipBigram.skipBigramCounts);
		} else if (shortSentenceArrayTidiedUp.length % 3==1) {
			////System.out.println("odd");
			length1 = shortSentenceArrayTidiedUp.length/3;
			length2 = shortSentenceArrayTidiedUp.length/3+1;
			firstThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstThirdOfSentence);
			secondThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondThirdOfSentence);
			lastThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length2, wordList);
	
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(lastThirdOfSentence, skipBigram.skipBigramCounts);
		
	}else if(shortSentenceArrayTidiedUp.length % 3==2) {
			////System.out.println("odd");
			length1 = shortSentenceArrayTidiedUp.length/3;
			length2 = shortSentenceArrayTidiedUp.length/3+2;
			firstThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstThirdOfSentence);
			secondThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondThirdOfSentence);
			lastThirdOfSentence = createArray(shortSentenceArrayTidiedUp, length2, wordList);
			////System.out.println(Arrays.toString(firstHalfOfSentence));
			////System.out.println(Arrays.toString(secondHalfOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstThirdOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondThirdOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(lastThirdOfSentence, skipBigram.skipBigramCounts);
		}
	}
	
	public void splitSentenceIntoFour(String[] shortSentenceArrayTidiedUp, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){
		int length1, length2;
		String[] firstQOfSentence;
		String[] secondQOfSentence;
		String[] thirdQOfSentence;
		String[] fourthQOfSentence;
		ArrayList<String>wordList = new ArrayList<>();
		addAllWordsToList(shortSentenceArrayTidiedUp);
		if(shortSentenceArrayTidiedUp.length % 4==0){						
			length1 =shortSentenceArrayTidiedUp.length/4;	
			firstQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstQOfSentence);
			secondQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondQOfSentence);
			thirdQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, thirdQOfSentence);
			fourthQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(fourthQOfSentence, skipBigram.skipBigramCounts);
			
		} else if (shortSentenceArrayTidiedUp.length % 4==1) {
			length1 =shortSentenceArrayTidiedUp.length/4;	
			length2 = shortSentenceArrayTidiedUp.length/4+1;
			firstQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstQOfSentence);
			secondQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondQOfSentence);
			thirdQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, thirdQOfSentence);
			fourthQOfSentence = createArray(shortSentenceArrayTidiedUp, length2, wordList);
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(fourthQOfSentence, skipBigram.skipBigramCounts);
			
	}else if(shortSentenceArrayTidiedUp.length % 4==2) {
		
		length1 =shortSentenceArrayTidiedUp.length/4;	
		length2 = shortSentenceArrayTidiedUp.length/4+2;
		firstQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
		removeAddedWordsFromList(wordList, firstQOfSentence);
		secondQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
		removeAddedWordsFromList(wordList, secondQOfSentence);
		thirdQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
		removeAddedWordsFromList(wordList, thirdQOfSentence);
		fourthQOfSentence = createArray(shortSentenceArrayTidiedUp, length2, wordList);
		//System.out.println("here");
		//System.out.println(Arrays.toString(firstQOfSentence));
		//System.out.println(Arrays.toString(fourthQOfSentence));
		//System.out.println("here");
		//get skip-trigram counts
		skipTrigram.getSkipTrigramCountsTest(firstQOfSentence, skipBigram.skipBigramCounts);	
		skipTrigram.getSkipTrigramCountsTest(secondQOfSentence, skipBigram.skipBigramCounts);
		skipTrigram.getSkipTrigramCountsTest(thirdQOfSentence, skipBigram.skipBigramCounts);
		skipTrigram.getSkipTrigramCountsTest(fourthQOfSentence, skipBigram.skipBigramCounts);
		
		} else if(shortSentenceArrayTidiedUp.length % 4==3) {
			
			length1 =shortSentenceArrayTidiedUp.length/4;	
			length2 = shortSentenceArrayTidiedUp.length/4+3;
			firstQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, firstQOfSentence);
			secondQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, secondQOfSentence);
			thirdQOfSentence = createArray(shortSentenceArrayTidiedUp, length1, wordList);
			removeAddedWordsFromList(wordList, thirdQOfSentence);
			fourthQOfSentence = createArray(shortSentenceArrayTidiedUp, length2, wordList);
			//System.out.println(Arrays.toString(firstQOfSentence));
			//System.out.println(Arrays.toString(fourthQOfSentence));
			//get skip-trigram counts
			skipTrigram.getSkipTrigramCountsTest(firstQOfSentence, skipBigram.skipBigramCounts);	
			skipTrigram.getSkipTrigramCountsTest(secondQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(thirdQOfSentence, skipBigram.skipBigramCounts);
			skipTrigram.getSkipTrigramCountsTest(fourthQOfSentence, skipBigram.skipBigramCounts);
			
			}
	}
	*/
	
	public void splitSentenceIntoSections(String[] shortSentenceArrayTidiedUp, int numberOfArrays, SkipTrigramModel skipTrigram, SkipBigramModel skipBigram){

		LinkedList <String> wordList = addAllWordsToList(shortSentenceArrayTidiedUp);
		int remainder=getModulo(shortSentenceArrayTidiedUp, numberOfArrays);
		int length=shortSentenceArrayTidiedUp.length/numberOfArrays;
		String[] splitArray;
		for(int loop = 0 ; loop<numberOfArrays; loop++){		 
			//determine the size of the last array if not same length
			if (loop==(numberOfArrays-1)){
				splitArray = createArray(shortSentenceArrayTidiedUp, (length+remainder), wordList);
				skipTrigram.getSkipTrigramCountsTest(splitArray, skipBigram.skipBigramCounts);
			} else {
				splitArray= createArray(shortSentenceArrayTidiedUp, length, wordList);
				wordList=removeAddedWordsFromList(wordList, splitArray);
				skipTrigram.getSkipTrigramCountsTest(splitArray, skipBigram.skipBigramCounts);
			}
			
		}
	}
	
	
	private String[] createArray(String[] shortSentenceArrayTidiedUp, int length, LinkedList<String> wordList){
		String[] splitArray = new String[length];
		for (int loop=0; loop<length; loop++){
			splitArray[loop]=wordList.get(loop);
		}
		return splitArray;
	}
	
	private LinkedList<String> addAllWordsToList (String[] shortSentenceArrayTidiedUp){
		LinkedList<String> wordList = new LinkedList<>();
		for (int loop=0; loop<shortSentenceArrayTidiedUp.length; loop++){
			wordList.addLast(shortSentenceArrayTidiedUp[loop]);
		}
		return wordList;
	}
	
	private LinkedList<String> removeAddedWordsFromList (LinkedList<String> wordList,String[] arrayOfWords){
		for (int loop=0; loop<arrayOfWords.length; loop++){
			wordList.removeFirst();
		}	
		return wordList;
	}
	
	private int getModulo(String[] shortSentenceArrayTidiedUp, int numberOfSections){
		return shortSentenceArrayTidiedUp.length % numberOfSections;
	}
}
