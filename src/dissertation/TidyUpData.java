package dissertation;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

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

}
