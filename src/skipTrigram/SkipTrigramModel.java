package skipTrigram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

import dissertation.Dictionary;
import dissertation.TidyUpData;
import dissertation.UnigramModel;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collectors;
public class SkipTrigramModel {

	public SkipTrigramModel() {}
	TidyUpData tidyUpData= new TidyUpData();
	HashMap <String, HashMap <String, HashMap <String, Double>>> skipTrigramCounts = new HashMap <String, HashMap <String, HashMap <String, Double>>> ();
	HashMap <String, HashMap <String, HashMap <String, Double>>> skipTrigramProbability;
	HashMap <Integer, Integer> frequencyOfFrequencyCounts = new HashMap <Integer, Integer> ();
	double probabilityOfUnseenWord;
	double numberOfCommonlyUsedWordsInEnglish  =1000;
	String[] wordsToAddNewTrigram= new String[3];
	ArrayList <String> skipTrigrams = new ArrayList<String>();

	public void getSkipTrigramCounts(String[] shortSentenceArray, HashMap <String, HashMap <String, Double>> skipBigramCounts) {
		//System.out.println("Calculating trigram counts");
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries;
		
		int skips=0;
		
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				for (int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					//flag for finding an existing trigram
					skips++;
					boolean skipgramFound=false;
					final String outerloopFinal = new String(shortSentenceArray[outerLoop]);
					String key= null;
					String secondWord=null;
					String thirdWord=null;

					//System.out.println("1st word: " + shortSentenceArray[outerLoop]);
					//System.out.println("2nd word: " + shortSentenceArray[secondLoop+1]);
					//System.out.println("3rd word: " + shortSentenceArray[thirdLoop+2]);

					//check if the first word exists as a key in the skipTrigramCounts map
					if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[outerLoop])) {
	
						//record the key word for future use in case an exact match is not found
						key=recordKey(key, secondWord, shortSentenceArray[outerLoop]);
						//get the map of existing entries for the keyword
						existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
						/*existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
								.filter(map -> outerloopFinal.equals(map.getKey()))
								.map(map -> map.getValue()).findFirst().get();
						//System.out.println("stream: "+existingSecondWordEntries);*/
						//check if the second word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+1])){
							//System.out.println("First word exists and second word exists " + shortSentenceArray[outerLoop] + " " + shortSentenceArray[secondLoop+1]);
							//check if the third word exists
							if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2])){
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
								if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[thirdLoop+2], shortSentenceArray[secondLoop+1])){
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
						/*final String secondloopFinal = new String(shortSentenceArray[secondLoop+1]);
						existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
								.filter(map -> secondloopFinal.equals(map.getKey()))
								.map(map -> map.getValue()).findFirst().get();*/
						//check if the first word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
							//System.out.println("Second word exists as key and 1st word exists " + shortSentenceArray[secondLoop+1] + " " + shortSentenceArray[outerLoop]);
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[secondLoop+1], shortSentenceArray[outerLoop], 
								shortSentenceArray[thirdLoop+2])){
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
									shortSentenceArray[outerLoop])){
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
						/*final String thirdLoopFinal = new String(shortSentenceArray[thirdLoop+2]);
						existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
								.filter(map -> thirdLoopFinal.equals(map.getKey()))
								.map(map -> map.getValue()).findFirst().get();*/
						//check if the first word exists as a key in the existingSecondWordEntries map
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[thirdLoop+2], shortSentenceArray[outerLoop], 
								shortSentenceArray[secondLoop+1])){
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
									shortSentenceArray[outerLoop])){
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
						/*//System.out.println(key);
						//System.out.println(secondWord);
						//System.out.println(thirdWord);*/
						existingSecondWordEntries = skipTrigramCounts.get(key);
						addNewThirdWord(key, secondWord, thirdWord);
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
						addNewSecondAndThirdWord(key, secondWord, thirdWord);		
					}
					
					//if none of the words exist in the map, record a new entry
					else if (skipgramFound==false && key==null ){
						addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2]);
					}
				}
			}
		}
		//System.out.println(skips);
	}

	private boolean checkIfKeyExists(String key){
		if (skipTrigramCounts.containsKey(key)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean checkIfTrigramExistsForKeyWord(String key, String secondWord, String thirdWord){
		if(checkIfKeyExists(key)){
			if (checkIfSecondWordExists(key, secondWord)){
				if(checkIfThirdWordExists(key, secondWord, thirdWord)){
					return true;
				} else{
					//record the words for future use in case an exact match is not found
					recordValues(key, secondWord, thirdWord);
				}
			}	
				
			//swap second and third words
			if(checkIfSecondWordExists(key, thirdWord)){
				if(checkIfThirdWordExists(key, thirdWord, secondWord)){
					return true;
				}else{
					//record the words for future use in case an exact match is not found
					recordValues(key, thirdWord, secondWord);
				}
			}	
		}
		return false;
	}
	
	private boolean checkIfSecondWordExists(String key, String secondWord){	
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries=skipTrigramCounts.get(key);
		if (existingSecondWordEntries.containsKey(secondWord)){
			return true;
		} else{
		return false;
		}
	}
	
	private boolean checkIfTwoOfTheWordsHaveBeenMapped(){
		if (wordsToAddNewTrigram[0]!=null && wordsToAddNewTrigram[1] !=null){	
			//System.out.println(wordsToAddNewTrigram[0] + wordsToAddNewTrigram[1]+ " exist");
			return true;
		}
		else {
			return false;
		}
	}
	
	private String[] checkIfOneOfTheWordsHasBeenMapped(String key, String secondWord, String thirdWord){
		
		if (checkIfKeyExists(key)){
			String[] orderOfWordsToBeAdded= {key, secondWord, thirdWord};
			return orderOfWordsToBeAdded;
		} else if (checkIfKeyExists(secondWord)){
			String[] orderOfWordsToBeAdded= {secondWord, key, thirdWord};
			return orderOfWordsToBeAdded;
		} else if (checkIfKeyExists(thirdWord)){
			String[] orderOfWordsToBeAdded= {thirdWord, secondWord, key};
			return orderOfWordsToBeAdded;
		}
		else return null;
	}
	
	public void getSkipTrigramCountsTest(String[] shortSentenceArray, HashMap <String, HashMap <String, Double>> skipBigramCounts) {
		//retrieve three words
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				for (int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					//empty the array of words to be added
					wordsToAddNewTrigram[0]=null;
					wordsToAddNewTrigram[1]=null;
					wordsToAddNewTrigram[2]=null;
					
					//flag for finding an existing trigram				
					boolean skipgramFound=false;
					
					if(checkIfTrigramExistsForKeyWord(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2])){
						skipgramFound=true;
					}
					
					if(checkIfTrigramExistsForKeyWord(shortSentenceArray[secondLoop+1], shortSentenceArray[outerLoop], shortSentenceArray[thirdLoop+2])){
						skipgramFound=true;
					}
						
					if(checkIfTrigramExistsForKeyWord(shortSentenceArray[thirdLoop+2], shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1])){
						skipgramFound=true;
					}
										
					if (skipgramFound==false){
						//if skipgram does not exist, but two of the words have been mapped, add the third word into the map
						if (checkIfTwoOfTheWordsHaveBeenMapped()){
							addNewThirdWord(wordsToAddNewTrigram[0], wordsToAddNewTrigram[1], wordsToAddNewTrigram[2]);
						}
						//if one of the words exists as key, add the two words as its branches
						else if (checkIfOneOfTheWordsHasBeenMapped(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2])!=null){						
							String[] orderOfWordsToBeAdded=checkIfOneOfTheWordsHasBeenMapped(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2]);
							addNewSecondAndThirdWord(orderOfWordsToBeAdded[0], orderOfWordsToBeAdded[1], orderOfWordsToBeAdded[2]);
						}
						else {
						//if none of the words exist as key
							addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+1], shortSentenceArray[thirdLoop+2]);
						}
					}
				}
			}
		}
	}

	public void getSkipTrigramCountsMethod2 (String[] shortSentenceArray, HashMap <String, HashMap <String, Double>> skipBigramCounts) {
		
		skipTrigramCounts.entrySet().stream();
		
		//System.out.println("calculating trigram counts");
		int countAhead = 2;
		int currentPos = 0;
		HashMap<String, ArrayList<String>> tempMap = new HashMap<String, ArrayList<String>>();
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){
				for(int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					
					ArrayList<String> tempList = new ArrayList<String>();
					String firstWord=shortSentenceArray[outerLoop];
					String secondWord = shortSentenceArray[secondLoop+1];
					String thirdWord = shortSentenceArray[thirdLoop+2];
					String combination1 = firstWord +" "+ secondWord+ " "+ thirdWord;
					String combination2 = firstWord+" "+ thirdWord+" "+secondWord;
					String combination3 = secondWord+" "+ firstWord+" "+ thirdWord;
					String combination4 = secondWord+" "+ thirdWord+" "+ firstWord;
					String combination5 = thirdWord +" "+ firstWord+" "+ secondWord;
					String combination6 = thirdWord+" "+ secondWord+" "+ firstWord;
				
					tempList.add(combination1);
					tempList.add(combination2);
					tempList.add(combination3);
					tempList.add(combination4);
					tempList.add(combination5);
					tempList.add(combination6);
					
					
					tempMap.put(combination1, tempList);
				}
			}
		}
				        
		//System.out.println(tempMap.get("dog jumped over")+" values for [dog jumped over]");
	
		
		
		if (skipTrigrams.isEmpty()){
			//System.out.println(" adding first trigram "+ tempMap.firstKey());
			//addTrigram(tempMap.firstKey());
			//tempMap.keySet().remove(tempMap.firstKey());
			//System.out.println(skipTrigrams);
		} 
		
		if (!skipTrigrams.isEmpty()){		
			for(String entry : tempMap.keySet()){
				boolean trigramFound=false;
				outerloop:
				for(String value : tempMap.get(entry)){
					for (String trigram: skipTrigrams){	
						//System.out.println("trigram: "+ trigram);
						//System.out.println("value: "+value);
						if(findSkipTrigram(value, trigram)){
							//System.out.println(" found trigram");
							trigramFound=true;
							break outerloop;
						}				
					}		
				}
				if (trigramFound==false){
					//System.out.println(" adding trigram " + entry+ "\n");
					addTrigram(entry);
				}
			}	
		}
	
	}
	
	private void addTrigram(String value){
		skipTrigrams.add(value+" [1]");
	}
	private boolean findSkipTrigram(String value, String trigram){
		Pattern regex = Pattern.compile(value+" \\[(\\w).*\\]");
		Matcher m = regex.matcher(trigram);
		if (m.find()) {
			/*//System.out.println("\nvalue :"+ value);
			//System.out.println("trigram: "+ trigram);
			//System.out.println(m.group() + "found");*/
			String trigramWithCount = skipTrigrams.get(skipTrigrams.indexOf(trigram));
			//System.out.println(trigramWithCount+ " trigram we want");
			Pattern numberRegex = Pattern.compile("\\[(.*?)\\]");
			Matcher numberMatcher = numberRegex.matcher(trigramWithCount);
			if (numberMatcher.find()){
				//System.out.println(numberMatcher.group(1));
				skipTrigrams.remove(trigramWithCount);
				skipTrigrams.add(value+" ["+(Integer.parseInt(numberMatcher.group(1))+1)+"]");
				return true;
			}

		}
		return false;
	}

	public void getSkipTrigramCountsMethod3(String[] shortSentenceArray, HashMap <String, HashMap <String, Double>> skipBigramCounts){
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries;
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				boolean skipgramFound=false;
				String key= null;
				String secondWord=null;
				String thirdWord=null;
				
				/*existingSecondWordEntries= skipTrigramCounts.entrySet().stream()
						.filter(map -> (shortSentenceArray[outerLoop]).equals(map.getValue()))
						.map(map -> map.getValue()).collect();*/
				if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[outerLoop])) {
					//record the key word for future use in case an exact match is not found
					key=recordKey(key, secondWord, shortSentenceArray[outerLoop]);
					//System.out.println("First word exists " + shortSentenceArray[outerLoop]);
					//get the map of existing entries for the keyword
					existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
					/*existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
							.filter(map -> outerloopFinal.equals(map.getKey()))
							.map(map -> map.getValue()).findFirst().get();*/
					//System.out.println("stream: "+existingSecondWordEntries);
					//check if the second word exists as a key in the existingSecondWordEntries map
					if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop+1])){
						//System.out.println("First word exists and second word exists " + shortSentenceArray[outerLoop] + " " + shortSentenceArray[outerLoop+1]);
						//check if the third word exists
						if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[outerLoop+1], shortSentenceArray[secondLoop+2])){
							skipgramFound=true;
						}
						else{
							//record the words for future use in case an exact match is not found
							key=shortSentenceArray[outerLoop];
							secondWord=shortSentenceArray[outerLoop+1];
							thirdWord=shortSentenceArray[secondLoop+2];
						}
					//if trigram is not found in inital word order
					//reverse second word and third word
					}else {					
						if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+2])){
							//System.out.println("First word exists and second word exists " + shortSentenceArray[outerLoop] + " " + shortSentenceArray[secondLoop+2]);
							if(checkIfThirdWordExists(shortSentenceArray[outerLoop], shortSentenceArray[secondLoop+2], shortSentenceArray[outerLoop+1])){
								skipgramFound=true;
							}
							else{
								//record the words for future use in case an exact match is not found
								key=shortSentenceArray[outerLoop];
								secondWord=shortSentenceArray[secondLoop+2];
								thirdWord=shortSentenceArray[outerLoop+1];
							}
						}
					}
				}

				//if skipgram not found, check if the second word exists as a key in the skipTrigramCounts map
				if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[outerLoop+1])){
					key=recordKey(key, secondWord, shortSentenceArray[outerLoop+1]);
					existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop+1]);
					/*final String outerLoopFinal = new String(shortSentenceArray[outerLoop+1]);
					existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
							.filter(map -> outerLoopFinal.equals(map.getKey()))
							.map(map -> map.getValue()).findFirst().get();*/
					//check if the first word exists as a key in the existingSecondWordEntries map
					if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
						//System.out.println("Second word exists as key and 1st word exists " + shortSentenceArray[outerLoop+1] + " " + shortSentenceArray[outerLoop]);
						//check if the whole trigram exists				
						if (checkIfThirdWordExists(shortSentenceArray[outerLoop+1], shortSentenceArray[outerLoop], 
							shortSentenceArray[secondLoop+2])){
							skipgramFound=true;
						}
						else{
							//record the two words for future use in case an exact match is not found
							//record the key word for future use in case an exact match is not found
							key=shortSentenceArray[outerLoop+1];
							secondWord=shortSentenceArray[outerLoop];
							thirdWord=shortSentenceArray[secondLoop+2];
						}
					}
					//if trigram is not found in inital word order
					//reverse second word and third word
					else {
						if(existingSecondWordEntries.containsKey(shortSentenceArray[secondLoop+2])){
							//System.out.println("Second word exists as key and 1st word exists " + shortSentenceArray[outerLoop+1] + " " + shortSentenceArray[secondLoop+2]);
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[outerLoop+1], shortSentenceArray[secondLoop+2], 
								shortSentenceArray[outerLoop])){
								skipgramFound=true;
							}
							else{
								//record the two words for future use in case an exact match is not found'
								key=shortSentenceArray[outerLoop+1];
								secondWord=shortSentenceArray[secondLoop+2];
								thirdWord=shortSentenceArray[outerLoop];
							}
						}
					}
				}
				
				
				//if skipgram not found, check if the third word exists as a key in the skipTrigramCounts map
				if (skipgramFound==false && skipTrigramCounts.containsKey(shortSentenceArray[secondLoop+2])){
			
					//record the key word for future use in case an exact match is not found
					key=recordKey(key, secondWord, shortSentenceArray[secondLoop+2]);
					existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[secondLoop+2]);
					/*final String secondLoopFinal = new String(shortSentenceArray[secondLoop+2]);
					existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
							.filter(map -> secondLoopFinal.equals(map.getKey()))
							.map(map -> map.getValue()).findFirst().get();*/
					//check if the first word exists as a key in the existingSecondWordEntries map
					if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop])){
						//check if the whole trigram exists				
						if (checkIfThirdWordExists(shortSentenceArray[secondLoop+2], shortSentenceArray[outerLoop], 
							shortSentenceArray[outerLoop+1])){
							skipgramFound=true;
						}
						else{
							//record the two words for future use in case an exact match is not found
							key=shortSentenceArray[secondLoop+2];
							secondWord= shortSentenceArray[outerLoop];
							thirdWord=shortSentenceArray[outerLoop+1];
						}
					}
					//if trigram is not found in inital word order
					//reverse second word and third word
					else {
						if(existingSecondWordEntries.containsKey(shortSentenceArray[outerLoop+1])){
							//check if the whole trigram exists				
							if (checkIfThirdWordExists(shortSentenceArray[secondLoop+2], shortSentenceArray[outerLoop+1], 
								shortSentenceArray[outerLoop])){
								skipgramFound=true;
							}
							else{
								//record the two words for future use in case an exact match is not found
								key=shortSentenceArray[secondLoop+2];
								secondWord=shortSentenceArray[outerLoop+1];
								thirdWord=shortSentenceArray[outerLoop];
							}
						}
					}
				}
				
				
				//if skipgram does not exist, but first and second word have been mapped, add the third word into the map
				if (skipgramFound==false && secondWord!=null && key !=null && thirdWord!=null){
					/*//System.out.println(key);
					//System.out.println(secondWord);
					//System.out.println(thirdWord);*/
					existingSecondWordEntries = skipTrigramCounts.get(key);
					addNewThirdWord(key, secondWord, thirdWord);
				}
				
				//if only the key exists, add second and third words into the map
				else if (skipgramFound==false && key!=null ){
					//System.out.println(key + " the key");
					if (key.equals(shortSentenceArray[outerLoop])){
						secondWord=shortSentenceArray[outerLoop+1];
						thirdWord=shortSentenceArray[secondLoop+2];
					}
					if (key.equals(shortSentenceArray[outerLoop+1])){
						secondWord=shortSentenceArray[outerLoop];
						thirdWord=shortSentenceArray[secondLoop+2];
					}
					if (key.equals(shortSentenceArray[secondLoop+2])){
						secondWord=shortSentenceArray[outerLoop];
						thirdWord=shortSentenceArray[outerLoop+1];
					}
					
					existingSecondWordEntries = skipTrigramCounts.get(shortSentenceArray[outerLoop]);
					addNewSecondAndThirdWord(key, secondWord, thirdWord);		
				}
				
				//if none of the words exist in the map, record a new entry
				else if (skipgramFound==false && key==null ){
					addNewEntry(shortSentenceArray[outerLoop], shortSentenceArray[outerLoop+1], shortSentenceArray[secondLoop+2]);
				}
			
			}
		}
	}
	
	public void getSkipTrigramCountsMethod4(String[] shortSentenceArray, HashMap <String, HashMap <String, Double>> skipBigramCounts) {
		//System.out.println("Calculating trigram counts");
		HashMap<String, HashMap<String, Double>> existingSecondWordEntries;
			
		for (int outerLoop=0; outerLoop<shortSentenceArray.length-2; outerLoop++){
			for (int secondLoop=outerLoop; secondLoop<shortSentenceArray.length-2; secondLoop++){	
				for (int thirdLoop=secondLoop; thirdLoop<shortSentenceArray.length-2; thirdLoop++){
					//flag for finding an existing trigram
					boolean skipgramFound=false;
					final int outerLoop2=outerLoop;
					String key= null;
					String secondWord=null;
					String thirdWord=null;

					/*//System.out.println("1st word: " + shortSentenceArray[outerLoop]);
					//System.out.println("2nd word: " + shortSentenceArray[secondLoop+1]);
					//System.out.println("3rd word: " + shortSentenceArray[thirdLoop+2]);*/
					
					HashMap <String, Double>tempMap1= new HashMap<String, Double>();
					HashMap <String, HashMap<String, Double>> tempMap2= new HashMap<>();
					tempMap1.put("laura", 1.0);
				
					tempMap2.put("name", tempMap1);
					skipTrigramCounts.put("my", tempMap2);
					tempMap1.put("shane", 1.0);
					tempMap2.put("name", tempMap1);
					skipTrigramCounts.put("my", tempMap2);
					//System.out.println(skipTrigramCounts);
					/*//System.out.println("stream: "+skipTrigramCounts.entrySet().stream()
							.filter(map -> "my".equals(map.getKey()))
							.map(map -> map.getValue()).findFirst().get());
					existingSecondWordEntries = skipTrigramCounts.entrySet().stream()
							.filter(map -> "my".equals(map.getKey()))
							.map(map -> map.getValue()).findFirst().get();*/

					
				}
			}
		}
	}

	private String recordKey(String key, String secondWord, String newValue) {
		//do not record a new key if two of the three words have already been found to exist
		if(secondWord==null){
			key = newValue;
		}
		return key;
	}
	private void recordValues(String key, String secondWord, String thirdWord){
		if (wordsToAddNewTrigram[0]==null && wordsToAddNewTrigram[1]==null && wordsToAddNewTrigram[2]==null ){
			wordsToAddNewTrigram[0]=key;
			wordsToAddNewTrigram[1]=secondWord;
			wordsToAddNewTrigram[2]=thirdWord;
		}
	}
	private void addNewEntry(String key, String secondWord, String thirdWord){
		HashMap <String, HashMap <String, Double>> newSecondWordEntry= new HashMap<String, HashMap<String,Double>>();
		HashMap <String, Double> newThirdWordEntry= new HashMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		newSecondWordEntry.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, newSecondWordEntry);
		if(skipTrigramCounts.size() % 100 == 0) {
			//System.out.println(skipTrigramCounts.size() +" trigrams so far");
		}
		//System.out.println("New key '"+key+"' added with second word '" +secondWord+"' and third word '"+ thirdWord+"' \n");
	}

	private void addNewSecondAndThirdWord(String key, String secondWord, String thirdWord) {
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries=skipTrigramCounts.get(key);
		//System.out.println(existingSecondWordEntries);
		HashMap <String, Double> newThirdWordEntry= new HashMap<String, Double>();
		newThirdWordEntry.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, newThirdWordEntry);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println("New second level word '" +secondWord+"' with third word '"+thirdWord+ "' added for key '"+ key+"'\n");
	}

	public void addNewThirdWord (String key, String secondWord, String thirdWord){
		//System.out.println(key+ secondWord+thirdWord);
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries = skipTrigramCounts.get(key);
		HashMap <String, Double> existingThirdWordEntries= existingSecondWordEntries.get(secondWord);
		existingThirdWordEntries.put(thirdWord, 1.0);
		existingSecondWordEntries.put(secondWord, existingThirdWordEntries);
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println("New third word '" +thirdWord+"' added for key '"+ key+"' and second level word '" + secondWord+ "'\n");
	}

	public void incrementCount( String key, String secondWord, String thirdWord ){
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries=skipTrigramCounts.get(key);
		HashMap <String, Double> existingThirdWordEntries=existingSecondWordEntries.get(secondWord);
		existingThirdWordEntries.put(thirdWord, (existingThirdWordEntries.get(thirdWord)+1.0));
		existingSecondWordEntries.put(secondWord, existingThirdWordEntries);		
		skipTrigramCounts.put(key, existingSecondWordEntries);
		//System.out.println("Incremented count for: "+key +" "+ secondWord+ " "+ thirdWord+"\n");
	}

	private boolean checkIfThirdWordExists(String keyWord, String secondWord, String thirdWord){
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries=skipTrigramCounts.get(keyWord);
		HashMap <String, Double> existingThirdWordEntries=existingSecondWordEntries.get(secondWord);
		//check if third word exists as a key in the map
		if(existingThirdWordEntries.containsKey(thirdWord)){
			//if the skiptrigram exists, increment count
			incrementCount(keyWord, secondWord, thirdWord);	
			return true;
		}
		else
			//if skipgram was not found return false	
			//System.out.println("existing skipgram not found for: " +keyWord + " " + secondWord+ " " + thirdWord);
		return false;
	}
	
	public void calculateProbability(HashMap <String, HashMap <String, Double>> skipBigramCounts) {
		//System.out.println("skipbigram counts " + skipBigramCounts);
		System.out.println("About to calculate trigram probabilities");
		//copy the trigram count
		//System.out.println("first key:" + skipTrigramCounts.firstKey());
		//System.out.println("last key:" +skipTrigramCounts.lastKey());
		this.skipTrigramProbability = this.skipTrigramCounts;
		//System.out.println(skipTrigramProbability.firstKey());
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
						//System.out.println("Testing " +word1 +" and " +word2 +" and " +word3);	
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
						//System.out.println("bigram count for " + word1 + " " +word2 + " : " + bigramCountForWordsOneAndTwo);
						//System.out.println("bigram count for " + word1 + " " +word3 + " : " + bigramCountForWordsOneAndThree);
						//System.out.println("bigram count for " + word2 + " " +word3 + " : " + bigramCountForWordsTwoAndThree);
					}
					if(trigramCount == 0) {
							//System.out.println("Found a zero");
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
		HashMap <String, HashMap <String, Double>> existingSecondWordEntries;
		HashMap <String, Double> existingThirdWordEntries;
		//System.out.println("About to calculate skip-trigram perplexity");
		//System.out.println("first key:" +skipTrigramProbability.firstKey());
		//System.out.println("last key: " +skipTrigramProbability.lastKey());
		double theProbability = 0;
		double thePerplexity;
		boolean firstTrigram = true;
		String [] words;
		double trigramProbability;
		int trigramCount=0;
		

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
					/*//System.out.println(words[outerLoop]);
					//System.out.println(words[secondLoop+1]);
					//System.out.println(words[thirdLoop+2]);*/
					//System.out.println(skipTrigramProbability);
					//make first word key in probability map
					if(this.skipTrigramProbability.containsKey(words[outerLoop])) {
			
						existingSecondWordEntries = this.skipTrigramProbability.get(words[outerLoop]);
						//System.out.println(existingSecondWordEntries);
						if(existingSecondWordEntries.containsKey(words[secondLoop+1])) {
							//word i is found and so the bigram is found
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
	
			//System.out.println("Total probability of sentence: " + theProbability);
			//if (clue.equals("Start chopping wood for money")){
			System.out.println(thePerplexity +"   " +clue);
			//}
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
			//System.out.println("i have never seen this word before: " +word1);
			probabilityWord1= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word1);
			//System.out.println("I have seen " + word1 + " " + numberOfTimesSeen + " times");
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				//System.out.println("I have seen " + word1 + " " + numberOfTimesSeen + " times");
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
				//System.out.println("absolute disc " + word1);
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
			//System.out.println("i have never seen this word before: " +word2);
			probabilityWord2= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word2);
			
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				//System.out.println("I have seen " + word2 + " " + numberOfTimesSeen + " times");
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
				//System.out.println("absolute disc " + word2);
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
			//System.out.println("i have never seen this word before: " +word3);
			probabilityWord3= probabilityOfUnseenWord;
			
		} else {
			numberOfTimesSeen = unigram.unigramCounts.get(word3);
			//System.out.println("I have seen " + word3 + " " + numberOfTimesSeen + " times");
			if(this.frequencyOfFrequencyCounts.containsKey(numberOfTimesSeen + 1)) {
				//System.out.println("I have seen " + word3 + " " + numberOfTimesSeen + " times");
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
				//System.out.println("absolute disc " + word3);
				newCounts = numberOfTimesSeen - absoluteDiscount;
				probabilityWord3 = newCounts / unigram.getTotalWordCount();
				/*if(this.perplexityLogFile) {
					this.perplexityDetails += "I don't have Nc+1 ... using absolute discounting \n";
					this.perplexityDetails += "New counts is " +newCounts +"\n";
					this.perplexityDetails += "Probability is " +probability +"\n";
				}*/
			}
			
		}
		//System.out.println("prob for " + word1 + " : " + probabilityWord1);
		//System.out.println("prob for " + word2 + " : " + probabilityWord2);
		//System.out.println("prob for " + word3 + " : " + probabilityWord3);
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

	public void findSuitableWord (String firstLetter, String givenWords, UnigramModel unigram) {		
		Double perplexityOfClue=10000.00;
		Double lastPerplexity;
		HashMap<Double, String> mostProbableClues = new HashMap<Double, String>();
		HashMap<String, Double> wordsFoundBySkipgram = new HashMap<String,Double>();
		Dictionary dictionary = new Dictionary();
		boolean firstWord = true;
		int number=0;
		for (String word : unigram.allCWords) {
			String completeClue = givenWords+ " " + word;
			
			if (perplexityOf(completeClue, unigram)<perplexityOfClue) {
				number++;
				mostProbableClues.put(perplexityOf(completeClue, unigram), word);
			}		
		}
		
		int count=0;
		//System.out.println(number);
		//System.out.println(unigram.allCWords.size() + " all c words");
		//System.out.println(mostProbableClues.keySet().size());
		for (Double perplexity: mostProbableClues.keySet()){	
			if (count<=200){
				wordsFoundBySkipgram.put(mostProbableClues.get(perplexity), perplexity);
				//System.out.println(mostProbableClues.get(perplexity) + ": " + perplexity);
				count++;
			}
			else break;
		}
		
		
	}
}


