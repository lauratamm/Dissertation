package dissertation;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

	/**
	 * Dictionary
	 * @author      John Owens <j.owens@napier.ac.uk>
	 * @version     1.1                 
	 * @since       2014-02-24          
	 */
	public class Dictionary {
		File file;

		private TreeMap <String, ArrayList<String>> theWords;
			
		public Dictionary() {
			initialiseStructure();
				//loadDictionaryFromFile();
				//printAll();
			//loadAWords();
			//loadBWords();
			//loadCWords();
			//loadDWords();
			//loadEWords();
			//loadFWords();
			//loadGWords();
			//loadHWords();
			//loadIWords();
			//loadJWords();
			//loadKWords();
			//loadLWords();
			//loadMWords();
			//loadNWords();
			//loadOWords();
			//loadPWords();
			//loadQWords();
			//loadRWords();
			//loadSWords();
			//loadTWords();
			//loadUWords();
			//loadVWords();
			//loadWWords();
			//loadXWords();
			//loadYWords();
			//loadZWords();	
		}

		private void initialiseStructure() {
			theWords = new TreeMap <String, ArrayList<String>> ();
		}
		
		public boolean containsWord(String word) {
			return theWords.keySet().contains(word);		
		}
		
		public String getRandomWord() {
			Random randomGenerator = new Random();
			int numWords;
			numWords = theWords.keySet().size();
			int randomWordNum = randomGenerator.nextInt(numWords);
			
			return (String) theWords.keySet().toArray()[randomWordNum];		
			
		}
		
		public String getADefinition(String word) {
			
			ArrayList <String> meanings = theWords.get(word);
			
			if(meanings.size() > 1) {
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(meanings.size());
				return meanings.get(randomInt);

			} else {
				return meanings.get(0);
			}
		}
		
		public Set<String> getAllEntries() {
			return theWords.keySet();
		}
		
		public void printAll() {
			String output = "";
			ArrayList <String> meanings;
		
				for(Object tempWord : theWords.keySet()) {
					output = output + tempWord +"\n";
					meanings = (ArrayList<String>) theWords.get(tempWord);
					for(String meaning : meanings) {
						output = output + meaning +"\n";
					}
					output = output + "\n";
				}
			
		
			System.out.println(output);
		
		}
		
		public String toString() {
			String output = "";
			ArrayList <String> meanings;
		
				for(Object tempWord : theWords.keySet()) {
					output = output + tempWord +"\n";
					meanings = (ArrayList<String>) theWords.get(tempWord);
					for(String meaning : meanings) {
						output = output + meaning +"\n";
					}
					output = output + "\n";
				}
			
		
			return output;
		
		}
		
		public ArrayList<String> getAllDefinitions(String word) {
			
			ArrayList <String> meanings = (ArrayList<String>) theWords.get(word);
			
			return meanings;
		}
		
		public int size() {
			return theWords.keySet().size();
		}

		public void loadDictionaryFromFile() {
			
			file = new File("dictionary.txt");
			FileInputStream fis = null;
			BufferedReader br = null;
		    BufferedInputStream bis = null;
		    
		    String keyWord, meaning;
		    ArrayList <String> meanings;
			
		    try {
		    	fis = new FileInputStream(file);
		    	// Here BufferedInputStream is added for fast reading.
		        bis = new BufferedInputStream(fis);
		        br = new BufferedReader(new InputStreamReader(bis));
		        
		         while (br.ready()) {
		        	keyWord = br.readLine();
		        	System.out.println("Keyword is " +keyWord);
		        	meanings = new ArrayList <String>();
		        	do {
		        		meaning = br.readLine().trim();
		        		System.out.println("Found " +meaning);
		        		if(!meaning.isEmpty()) {
		        			meanings.add(meaning);
			        		System.out.println("For " +keyWord +" addding " +meaning);
		        		}
		        	} while(!meaning.isEmpty());
		        	theWords.put(keyWord, meanings);
		         }//while loop

		         // dispose all the resources after using them.
		         fis.close();
		         bis.close();
		         br.close();

		    } catch (FileNotFoundException e) {
		      	e.printStackTrace();
		    } catch (IOException e) {
		       	e.printStackTrace();
		    }
		}

		public TreeMap<String, ArrayList<String>> loadAWords() {
			TreeMap <String, ArrayList<String>> theWords= new TreeMap<>();
			String key;
			ArrayList <String> meanings;
			
			// load a's
			key = "a";
			meanings = new ArrayList <String>();
			meanings.add("a");
			meanings.add("article");
			meanings.add("first letter");
			meanings.add("one");
			theWords.put(key, meanings);

			key = "abates";
			meanings = new ArrayList <String>();
			meanings.add("lets up");
			theWords.put(key, meanings);

			key = "abdomen";
			meanings = new ArrayList <String>();
			meanings.add("tummy");
			theWords.put(key, meanings);

			key = "abel";
			meanings = new ArrayList <String>();
			meanings.add("murder victim");
			theWords.put(key, meanings);

			key = "abet";
			meanings = new ArrayList <String>();
			meanings.add("help a villan");
			theWords.put(key, meanings);
			
			key = "abhors";
			meanings = new ArrayList <String>();
			meanings.add("loathes");
			theWords.put(key, meanings);

			key = "ability";
			meanings = new ArrayList <String>();
			meanings.add("skill");
			meanings.add("strength");
			meanings.add("talent");
			theWords.put(key, meanings);

			key = "able";
			meanings = new ArrayList <String>();
			meanings.add("clever");
			meanings.add("competent");
			meanings.add("having talent");
			meanings.add("skillful");
			theWords.put(key, meanings);

			key = "abler";
			meanings = new ArrayList <String>();
			meanings.add("more adept");
			theWords.put(key, meanings);

			key = "abode";
			meanings = new ArrayList <String>();
			meanings.add("home");
			theWords.put(key, meanings);

			key = "abound";
			meanings = new ArrayList <String>();
			meanings.add("flourish");
			theWords.put(key, meanings);

			key = "about";
			meanings = new ArrayList <String>();
			meanings.add("in the vicinity");
			meanings.add("more or less");
			theWords.put(key, meanings);

			key = "aboveall";  //above all
			meanings = new ArrayList <String>();
			meanings.add("primarily");
			theWords.put(key, meanings);

			key = "abreast";
			meanings = new ArrayList <String>();
			meanings.add("side by side");
			theWords.put(key, meanings);

			key = "abs";
			meanings = new ArrayList <String>();
			meanings.add("abdominal muscles");
			theWords.put(key, meanings);

			key = "absorb";
			meanings = new ArrayList <String>();
			meanings.add("soak up");
			meanings.add("take in");
			theWords.put(key, meanings);

			key = "accent";
			meanings = new ArrayList <String>();
			meanings.add("stress");
			theWords.put(key, meanings);

			key = "accept";
			meanings = new ArrayList <String>();
			meanings.add("willingly receive");
			theWords.put(key, meanings);

			key = "accost";
			meanings = new ArrayList <String>();
			meanings.add("challenge");
			theWords.put(key, meanings);

			key = "account";
			meanings = new ArrayList <String>();
			meanings.add("reckoning");
			meanings.add("story");
			theWords.put(key, meanings);

			key = "accurate";
			meanings = new ArrayList <String>();
			meanings.add("precise");
			theWords.put(key, meanings);

			key = "accursed";
			meanings = new ArrayList <String>();
			meanings.add("damned");
			theWords.put(key, meanings);

			key = "accused";
			meanings = new ArrayList <String>();
			meanings.add("one on trial");
			theWords.put(key, meanings);

			key = "ace";
			meanings = new ArrayList <String>();
			meanings.add("expert");
			theWords.put(key, meanings);

			key = "aces";
			meanings = new ArrayList <String>();
			meanings.add("experts");
			theWords.put(key, meanings);

			key = "acer";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			theWords.put(key, meanings);

			key = "aces";
			meanings = new ArrayList <String>();
			meanings.add("cards");
			meanings.add("experts");
			meanings.add("high cards");
			theWords.put(key, meanings);

			key = "ache";
			meanings = new ArrayList <String>();
			meanings.add("pain");
			theWords.put(key, meanings);

			key = "aches";
			meanings = new ArrayList <String>();
			meanings.add("pains");
			theWords.put(key, meanings);

			key = "achilles";
			meanings = new ArrayList <String>();
			meanings.add("Greek hero");
			theWords.put(key, meanings);

			key = "acid";
			meanings = new ArrayList <String>();
			meanings.add("sharp");
			theWords.put(key, meanings);

			key = "acing";
			meanings = new ArrayList <String>();
			meanings.add("serving well");
			theWords.put(key, meanings);

			key = "acne";
			meanings = new ArrayList <String>();
			meanings.add("spots");
			theWords.put(key, meanings);

			key = "acre";
			meanings = new ArrayList <String>();
			meanings.add("amount of land");
			theWords.put(key, meanings);

			key = "acreage";
			meanings = new ArrayList <String>();
			meanings.add("extent of land");
			theWords.put(key, meanings);

			key = "acrid";
			meanings = new ArrayList <String>();
			meanings.add("pungent");
			meanings.add("tart");
			theWords.put(key, meanings);

			key = "act";
			meanings = new ArrayList <String>();
			meanings.add("deed");
			meanings.add("play");
			theWords.put(key, meanings);

			key = "acted";
			meanings = new ArrayList <String>();
			meanings.add("played");
			theWords.put(key, meanings);

			key = "acting";
			meanings = new ArrayList <String>();
			meanings.add("pretending");
			theWords.put(key, meanings);

			key = "active";
			meanings = new ArrayList <String>();
			meanings.add("animated");
			theWords.put(key, meanings);

			key = "acton";//Acton and act on
			meanings = new ArrayList <String>();
			meanings.add("keep playing");
			meanings.add("part of London");
			theWords.put(key, meanings);

			key = "actor";
			meanings = new ArrayList <String>();
			meanings.add("film star");
			theWords.put(key, meanings);

			key = "actors";
			meanings = new ArrayList <String>();
			meanings.add("film stars");
			theWords.put(key, meanings);

			key = "acts";
			meanings = new ArrayList <String>();
			meanings.add("does something");
			meanings.add("legislation");
			theWords.put(key, meanings);

			key = "ada";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);

			key = "adam";
			meanings = new ArrayList <String>();
			meanings.add("first man");
			theWords.put(key, meanings);

			key = "adder";
			meanings = new ArrayList <String>();
			meanings.add("snake");
			theWords.put(key, meanings);

			key = "addled";
			meanings = new ArrayList <String>();
			meanings.add("off");
			theWords.put(key, meanings);

			key = "add";
			meanings = new ArrayList <String>();
			meanings.add("do arithmetic");
			theWords.put(key, meanings);

			key = "adds";
			meanings = new ArrayList <String>();
			meanings.add("appends");
			theWords.put(key, meanings);

			key = "adept";
			meanings = new ArrayList <String>();
			meanings.add("expert");
			meanings.add("proficient");
			theWords.put(key, meanings);

			key = "adhere";
			meanings = new ArrayList <String>();
			meanings.add("stick");
			theWords.put(key, meanings);

			key = "adhered";
			meanings = new ArrayList <String>();
			meanings.add("stuck");
			theWords.put(key, meanings);

			key = "adherent";
			meanings = new ArrayList <String>();
			meanings.add("disciple");
			theWords.put(key, meanings);

			key = "adhesive";
			meanings = new ArrayList <String>();
			meanings.add("glue");
			theWords.put(key, meanings);

			key = "adios";
			meanings = new ArrayList <String>();
			meanings.add("farewell");
			theWords.put(key, meanings);

			key = "admirals";
			meanings = new ArrayList <String>();
			meanings.add("naval officers");
			theWords.put(key, meanings);

			key = "admire";
			meanings = new ArrayList <String>();
			meanings.add("applaud");
			theWords.put(key, meanings);

			key = "admit";
			meanings = new ArrayList <String>();
			meanings.add("confess");
			meanings.add("let in");
			theWords.put(key, meanings);

			key = "admittance";
			meanings = new ArrayList <String>();
			meanings.add("entry");
			theWords.put(key, meanings);

			key = "ado";
			meanings = new ArrayList <String>();
			meanings.add("bother");
			theWords.put(key, meanings);

			key = "adoration";
			meanings = new ArrayList <String>();
			meanings.add("reverence");
			theWords.put(key, meanings);

			key = "adore";
			meanings = new ArrayList <String>();
			meanings.add("love");
			theWords.put(key, meanings);

			key = "adoring";
			meanings = new ArrayList <String>();
			meanings.add("worshipping");
			theWords.put(key, meanings);

			key = "adverse";
			meanings = new ArrayList <String>();
			meanings.add("contrary");
			theWords.put(key, meanings);

			key = "advertisements";
			meanings = new ArrayList <String>();
			meanings.add("notices");
			theWords.put(key, meanings);

			key = "advertises";
			meanings = new ArrayList <String>();
			meanings.add("makes known");
			theWords.put(key, meanings);

			key = "adverts";
			meanings = new ArrayList <String>();
			meanings.add("publicity");
			theWords.put(key, meanings);

			key = "aerials";
			meanings = new ArrayList <String>();
			meanings.add("receivers");
			theWords.put(key, meanings);

			key = "aesop";
			meanings = new ArrayList <String>();
			meanings.add("Greek storyteller");
			meanings.add("storyteller");
			theWords.put(key, meanings);

			key = "affidavit";
			meanings = new ArrayList <String>();
			meanings.add("written statement confirmed by oath");
			theWords.put(key, meanings);

			key = "afraid";
			meanings = new ArrayList <String>();
			meanings.add("fearful");
			theWords.put(key, meanings);

			key = "african";//only used for anagrams
			meanings = new ArrayList <String>();
			meanings.add("from Africa");
			theWords.put(key, meanings);

			key = "aft";
			meanings = new ArrayList <String>();
			meanings.add("behind");
			theWords.put(key, meanings);

			key = "afters";
			meanings = new ArrayList <String>();
			meanings.add("pudding");
			theWords.put(key, meanings);

			key = "aga";
			meanings = new ArrayList <String>();
			meanings.add("cooking stove");
			theWords.put(key, meanings);

			key = "again";
			meanings = new ArrayList <String>();
			meanings.add("once more");
			meanings.add("period");
			theWords.put(key, meanings);

			key = "agate";
			meanings = new ArrayList <String>();
			meanings.add("stone");
			theWords.put(key, meanings);

			key = "agave";
			meanings = new ArrayList <String>();
			meanings.add("tropical plant");
			theWords.put(key, meanings);

			key = "age";
			meanings = new ArrayList <String>();
			meanings.add("mature");
			meanings.add("time");
			theWords.put(key, meanings);

			key = "ageless";
			meanings = new ArrayList <String>();
			meanings.add("not appearing to get older");
			theWords.put(key, meanings);

			key = "agenda";
			meanings = new ArrayList <String>();
			meanings.add("plan");
			meanings.add("schedule");
			theWords.put(key, meanings);

			key = "agent";
			meanings = new ArrayList <String>();
			meanings.add("rep");
			meanings.add("spy");
			theWords.put(key, meanings);

			key = "ages";
			meanings = new ArrayList <String>();
			meanings.add("a long time");
			meanings.add("very long time");
			theWords.put(key, meanings);

			key = "aging";
			meanings = new ArrayList <String>();
			meanings.add("getting on");
			theWords.put(key, meanings);

			key = "agitate";
			meanings = new ArrayList <String>();
			meanings.add("disturb");
			theWords.put(key, meanings);

			key = "agree";
			meanings = new ArrayList <String>();
			meanings.add("concur");
			theWords.put(key, meanings);

			key = "agrees";
			meanings = new ArrayList <String>();
			meanings.add("concurs");
			theWords.put(key, meanings);

			key = "ahead";
			meanings = new ArrayList <String>();
			meanings.add("in front");
			theWords.put(key, meanings);

			key = "aid";
			meanings = new ArrayList <String>();
			meanings.add("help");
			theWords.put(key, meanings);

			key = "aida";
			meanings = new ArrayList <String>();
			meanings.add("Verdi opera");
			theWords.put(key, meanings);

			key = "aides";
			meanings = new ArrayList <String>();
			meanings.add("they assist");
			theWords.put(key, meanings);

			key = "ail";
			meanings = new ArrayList <String>();
			meanings.add("suffer");
			theWords.put(key, meanings);

			key = "ailed";
			meanings = new ArrayList <String>();
			meanings.add("was sick");
			theWords.put(key, meanings);

			key = "ailing";
			meanings = new ArrayList <String>();
			meanings.add("getting sick");
			meanings.add("suffering");
			theWords.put(key, meanings);

			key = "aintree";
			meanings = new ArrayList <String>();
			meanings.add("racecourse");
			theWords.put(key, meanings);

			key = "air";
			meanings = new ArrayList <String>();
			meanings.add("demeanour");
			theWords.put(key, meanings);

			key = "aircrew";
			meanings = new ArrayList <String>();
			meanings.add("jet set");
			theWords.put(key, meanings);

			key = "airman";
			meanings = new ArrayList <String>();
			meanings.add("flier");
			theWords.put(key, meanings);
			
			key = "airmen";
			meanings = new ArrayList <String>();
			meanings.add("fliers");
			theWords.put(key, meanings);

			key = "airs";
			meanings = new ArrayList <String>();
			meanings.add("expresses opinion");
			meanings.add("affected manner");
			theWords.put(key, meanings);

			key = "alarm";
			meanings = new ArrayList <String>();
			meanings.add("panic");
			theWords.put(key, meanings);

			key = "alas";
			meanings = new ArrayList <String>();
			meanings.add("expression of regret");
			meanings.add("sadly");
			theWords.put(key, meanings);

			key = "alcove";
			meanings = new ArrayList <String>();
			meanings.add("recess");
			theWords.put(key, meanings);

			key = "ale";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			meanings.add("porter");
			theWords.put(key, meanings);

			key = "alec";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);

			key = "alert";
			meanings = new ArrayList <String>();
			meanings.add("notify");
			meanings.add("vigilant");
			meanings.add("warn");
			meanings.add("watchful");
			theWords.put(key, meanings);

			key = "alerting";
			meanings = new ArrayList <String>();
			meanings.add("warning");
			theWords.put(key, meanings);
			
			key = "ales";
			meanings = new ArrayList <String>();
			meanings.add("drinks");
			theWords.put(key, meanings);

			key = "alfresco";
			meanings = new ArrayList <String>();
			meanings.add("outdoors");
			theWords.put(key, meanings);

			key = "algorithm";
			meanings = new ArrayList <String>();
			meanings.add("process");
			theWords.put(key, meanings);

			key = "alien";
			meanings = new ArrayList <String>();
			meanings.add("foreign");
			theWords.put(key, meanings);

			key = "all";
			meanings = new ArrayList <String>();
			meanings.add("each and every");
			meanings.add("everyone");
			meanings.add("everything");
			theWords.put(key, meanings);

			key = "allergy";
			meanings = new ArrayList <String>();
			meanings.add("bad reaction");
			theWords.put(key, meanings);

			key = "allies";
			meanings = new ArrayList <String>();
			meanings.add("confederates");
			theWords.put(key, meanings);

			key = "allots";
			meanings = new ArrayList <String>();
			meanings.add("shares out");
			theWords.put(key, meanings);

			key = "allow";
			meanings = new ArrayList <String>();
			meanings.add("let");
			meanings.add("permit");
			theWords.put(key, meanings);

			key = "allowed";
			meanings = new ArrayList <String>();
			meanings.add("let");
			meanings.add("permitted");
			theWords.put(key, meanings);

			key = "alloy";
			meanings = new ArrayList <String>();
			meanings.add("blend");
			theWords.put(key, meanings);

			key = "allure";
			meanings = new ArrayList <String>();
			meanings.add("attraction");
			theWords.put(key, meanings);

			key = "ally";
			meanings = new ArrayList <String>();
			meanings.add("friend");
			theWords.put(key, meanings);

			key = "alma";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);

			key = "almanac";
			meanings = new ArrayList <String>();
			meanings.add("calendar");
			theWords.put(key, meanings);

			key = "almond";
			meanings = new ArrayList <String>();
			meanings.add("nut");
			theWords.put(key, meanings);

			key = "alms";
			meanings = new ArrayList <String>();
			meanings.add("charitable gifts");
			meanings.add("charity");
			meanings.add("charity donation");
			theWords.put(key, meanings);

			key = "aloft";
			meanings = new ArrayList <String>();
			meanings.add("up in the air");
			theWords.put(key, meanings);

			key = "along";
			meanings = new ArrayList <String>();
			meanings.add("by the side of");
			theWords.put(key, meanings);

			key = "alp";
			meanings = new ArrayList <String>();
			meanings.add("mountain");
			theWords.put(key, meanings);

			key = "alpanist";
			meanings = new ArrayList <String>();
			meanings.add("mountain climber");
			theWords.put(key, meanings);

			key = "alps";
			meanings = new ArrayList <String>();
			meanings.add("range");
			theWords.put(key, meanings);

			key = "also";
			meanings = new ArrayList <String>();
			meanings.add("as well");
			meanings.add("too");
			theWords.put(key, meanings);

			key = "altar";
			meanings = new ArrayList <String>();
			meanings.add("religious table");
			theWords.put(key, meanings);

			key = "alter";
			meanings = new ArrayList <String>();
			meanings.add("change");
			theWords.put(key, meanings);
			
			key = "altered";
			meanings = new ArrayList <String>();
			meanings.add("changed");
			theWords.put(key, meanings);

			key = "alternative";
			meanings = new ArrayList <String>();
			meanings.add("option");
			theWords.put(key, meanings);

			key = "altruism";
			meanings = new ArrayList <String>();
			meanings.add("unselfishness");
			theWords.put(key, meanings);

			key = "amass";
			meanings = new ArrayList <String>();
			meanings.add("gather");
			theWords.put(key, meanings);

			key = "amateur";
			meanings = new ArrayList <String>();
			meanings.add("non professional");
			theWords.put(key, meanings);

			key = "amaze";
			meanings = new ArrayList <String>();
			meanings.add("stagger");
			theWords.put(key, meanings);
			
			key = "amazing";
			meanings = new ArrayList <String>();
			meanings.add("incredible");
			theWords.put(key, meanings);

			key = "amble";
			meanings = new ArrayList <String>();
			meanings.add("slow walk");
			theWords.put(key, meanings);

			key = "ambler";
			meanings = new ArrayList <String>();
			meanings.add("walker");
			theWords.put(key, meanings);

			key = "ambles";
			meanings = new ArrayList <String>();
			meanings.add("walks");
			theWords.put(key, meanings);

			key = "ambush";
			meanings = new ArrayList <String>();
			meanings.add("sudden attack");
			theWords.put(key, meanings);

			key = "American";
			meanings = new ArrayList <String>();
			meanings.add("yank");
			theWords.put(key, meanings);

			key = "amen";
			meanings = new ArrayList <String>();
			meanings.add("last word");
			meanings.add("so be it");
			theWords.put(key, meanings);
			
			key = "amends";
			meanings = new ArrayList <String>();
			meanings.add("changes");
			theWords.put(key, meanings);

			key = "amethyst";
			meanings = new ArrayList <String>();
			meanings.add("stone");
			theWords.put(key, meanings);

			key = "amiable";
			meanings = new ArrayList <String>();
			meanings.add("pleasant in manner");
			theWords.put(key, meanings);

			key = "amiss";
			meanings = new ArrayList <String>();
			meanings.add("wrong");
			theWords.put(key, meanings);

			key = "ammo";
			meanings = new ArrayList <String>();
			meanings.add("bullets");
			theWords.put(key, meanings);

			key = "amnesty";
			meanings = new ArrayList <String>();
			meanings.add("pardon");
			theWords.put(key, meanings);

			key = "amount";
			meanings = new ArrayList <String>();
			meanings.add("measure");
			theWords.put(key, meanings);

			key = "amp";
			meanings = new ArrayList <String>();
			meanings.add("power unit");
			theWords.put(key, meanings);

			key = "ample";
			meanings = new ArrayList <String>();
			meanings.add("more than enough");
			theWords.put(key, meanings);

			key = "amps";
			meanings = new ArrayList <String>();
			meanings.add("current units");
			theWords.put(key, meanings);

			key = "amuse";
			meanings = new ArrayList <String>();
			meanings.add("divert");
			theWords.put(key, meanings);

			key = "amy";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			meanings.add("woman");
			theWords.put(key, meanings);

			key = "an";
			meanings = new ArrayList <String>();
			meanings.add("article");
			theWords.put(key, meanings);

			key = "anagram";
			meanings = new ArrayList <String>();
			meanings.add("wordplay");
			theWords.put(key, meanings);

			key = "anarchy";
			meanings = new ArrayList <String>();
			meanings.add("lawless state");
			theWords.put(key, meanings);

			key = "anchor";
			meanings = new ArrayList <String>();
			meanings.add("secure a vessel");
			theWords.put(key, meanings);

			key = "ancient";
			meanings = new ArrayList <String>();
			meanings.add("very old");
			theWords.put(key, meanings);

			key = "and";
			meanings = new ArrayList <String>();
			meanings.add("conjunction");
			theWords.put(key, meanings);

			key = "andes";
			meanings = new ArrayList <String>();
			meanings.add("mountain range");
			meanings.add("mountains");
			theWords.put(key, meanings);

			key = "andrew";
			meanings = new ArrayList <String>();
			meanings.add("prince");
			theWords.put(key, meanings);

			key = "anecdote";
			meanings = new ArrayList <String>();
			meanings.add("funny story");
			theWords.put(key, meanings);

			key = "angel";
			meanings = new ArrayList <String>();
			meanings.add("spirit");
			theWords.put(key, meanings);

			key = "anger";
			meanings = new ArrayList <String>();
			meanings.add("infuriate");
			theWords.put(key, meanings);

			key = "angers";
			meanings = new ArrayList <String>();
			meanings.add("infuriates");
			theWords.put(key, meanings);

			key = "angle";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);

			key = "ankle";
			meanings = new ArrayList <String>();
			meanings.add("joint");
			theWords.put(key, meanings);

			key = "anglesey";
			meanings = new ArrayList <String>();
			meanings.add("Welsh island");
			theWords.put(key, meanings);

			key = "angora";
			meanings = new ArrayList <String>();
			meanings.add("fine wool");
			theWords.put(key, meanings);

			key = "animal";
			meanings = new ArrayList <String>();
			meanings.add("neither vegetable nor mineral");
			theWords.put(key, meanings);

			key = "ann";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);

			key = "anna";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);

			key = "anne";
			meanings = new ArrayList <String>();
			meanings.add("queen");
			theWords.put(key, meanings);

			key = "annie";
			meanings = new ArrayList <String>();
			meanings.add("musical");
			theWords.put(key, meanings);

			key = "annual";
			meanings = new ArrayList <String>();
			meanings.add("book");
			theWords.put(key, meanings);

			key = "annul";
			meanings = new ArrayList <String>();
			meanings.add("cancel");
			theWords.put(key, meanings);

			key = "anon";
			meanings = new ArrayList <String>();
			meanings.add("unknown author");
			theWords.put(key, meanings);

			key = "another";
			meanings = new ArrayList <String>();
			meanings.add("extra");
			theWords.put(key, meanings);

			key = "answer";
			meanings = new ArrayList <String>();
			meanings.add("response");
			theWords.put(key, meanings);

			key = "ant";
			meanings = new ArrayList <String>();
			meanings.add("colony dweller");
			meanings.add("small insect");
			meanings.add("social worker");
			meanings.add("worker");
			theWords.put(key, meanings);

			key = "antenna";
			meanings = new ArrayList <String>();
			meanings.add("aerial");
			theWords.put(key, meanings);

			key = "anterior";
			meanings = new ArrayList <String>();
			meanings.add("situated at the front");
			meanings.add("preceding");
			theWords.put(key, meanings);

			key = "anthem";
			meanings = new ArrayList <String>();
			meanings.add("national song");
			meanings.add("song");
			theWords.put(key, meanings);

			key = "anti";
			meanings = new ArrayList <String>();
			meanings.add("opposed to");
			theWords.put(key, meanings);

			key = "antic";
			meanings = new ArrayList <String>();
			meanings.add("caper");
			theWords.put(key, meanings);

			key = "anvil";
			meanings = new ArrayList <String>();
			meanings.add("block");
			theWords.put(key, meanings);

			key = "ants";
			meanings = new ArrayList <String>();
			meanings.add("social workers");
			meanings.add("workers");
			theWords.put(key, meanings);

			key = "antwerp";
			meanings = new ArrayList <String>();
			meanings.add("somewhere in Belgium");
			theWords.put(key, meanings);

			key = "any";
			meanings = new ArrayList <String>();
			meanings.add("whichever");
			theWords.put(key, meanings);

			key = "apart";
			meanings = new ArrayList <String>();
			meanings.add("seperate");
			theWords.put(key, meanings);

			key = "ape";
			meanings = new ArrayList <String>();
			meanings.add("big monkey");
			meanings.add("mimic");
			theWords.put(key, meanings);

			key = "apes";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			meanings.add("big monkeys");
			meanings.add("mimics");
			theWords.put(key, meanings);

			key = "apostle";
			meanings = new ArrayList <String>();
			meanings.add("missionary");
			theWords.put(key, meanings);

			key = "app";
			meanings = new ArrayList <String>();
			meanings.add("program");
			theWords.put(key, meanings);
			
			key = "apparent";
			meanings = new ArrayList <String>();
			meanings.add("obvious");
			theWords.put(key, meanings);

			key = "apparently";
			meanings = new ArrayList <String>();
			meanings.add("evidently");
			theWords.put(key, meanings);

			key = "appeal";
			meanings = new ArrayList <String>();
			meanings.add("charm");
			theWords.put(key, meanings);

			key = "appetite";
			meanings = new ArrayList <String>();
			meanings.add("desire");
			meanings.add("hunger");
			theWords.put(key, meanings);

			key = "apple";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "applied";
			meanings = new ArrayList <String>();
			meanings.add("put into practice");
			theWords.put(key, meanings);

			key = "apprise";
			meanings = new ArrayList <String>();
			meanings.add("inform");
			theWords.put(key, meanings);

			key = "apron";
			meanings = new ArrayList <String>();
			meanings.add("pinny");
			theWords.put(key, meanings);

			key = "apse";
			meanings = new ArrayList <String>();
			meanings.add("part of church");
			theWords.put(key, meanings);

			key = "apero";
			meanings = new ArrayList <String>();
			meanings.add("pre-dinner drink");
			theWords.put(key, meanings);

			key = "aperient";
			meanings = new ArrayList <String>();
			meanings.add("mild laxetive");
			theWords.put(key, meanings);

			key = "aplomb";
			meanings = new ArrayList <String>();
			meanings.add("self-assurance");
			theWords.put(key, meanings);

			key = "appear";
			meanings = new ArrayList <String>();
			meanings.add("become visible");
			meanings.add("be published");
			meanings.add("come into sight");
			meanings.add("feature");
			meanings.add("materialise");
			meanings.add("show");
			meanings.add("turn up in court");
			theWords.put(key, meanings);

			key = "appetiser";
			meanings = new ArrayList <String>();
			meanings.add("starter");
			theWords.put(key, meanings);

			key = "apposite";
			meanings = new ArrayList <String>();
			meanings.add("relevant");
			theWords.put(key, meanings);

			key = "apple";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			meanings.add("one of your five a day");
			meanings.add("type of tree");
			theWords.put(key, meanings);	

			key = "apples";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);	

			key = "apprenticeship";
			meanings = new ArrayList <String>();
			meanings.add("training period");
			theWords.put(key, meanings);

			key = "apricot";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);

			key = "apt";
			meanings = new ArrayList <String>();
			meanings.add("appropriate");
			theWords.put(key, meanings);

			key = "arabic";
			meanings = new ArrayList <String>();
			meanings.add("language");
			theWords.put(key, meanings);

			key = "arch";
			meanings = new ArrayList <String>();
			meanings.add("curve");
			meanings.add("shape");
			theWords.put(key, meanings);

			key = "are";
			meanings = new ArrayList <String>();
			meanings.add("amount to");
			theWords.put(key, meanings);

			key = "area";
			meanings = new ArrayList <String>();
			meanings.add("region");
			theWords.put(key, meanings);

			key = "arena";
			meanings = new ArrayList <String>();
			meanings.add("battle ground");
			meanings.add("venue");
			theWords.put(key, meanings);

			key = "arenas";
			meanings = new ArrayList <String>();
			meanings.add("venues");
			theWords.put(key, meanings);

			key = "aria";
			meanings = new ArrayList <String>();
			meanings.add("operatic song");
			meanings.add("song");
			theWords.put(key, meanings);

			key = "aristotle";
			meanings = new ArrayList <String>();
			meanings.add("ancient Greek");
			theWords.put(key, meanings);

			key = "argentine";
			meanings = new ArrayList <String>();
			meanings.add("south american");
			theWords.put(key, meanings);

			key = "ark";
			meanings = new ArrayList <String>();
			meanings.add("old boat");
			meanings.add("vessel");
			theWords.put(key, meanings);

			key = "arm";
			meanings = new ArrayList <String>();
			meanings.add("limb");
			meanings.add("provide weapons");
			meanings.add("weapon");
			theWords.put(key, meanings);

			key = "armed";
			meanings = new ArrayList <String>();
			meanings.add("carrying a gun");
			meanings.add("having weapons");
			theWords.put(key, meanings);

			key = "armless";
			meanings = new ArrayList <String>();
			meanings.add("like the Venus De Milo");
			theWords.put(key, meanings);

			key = "arno";
			meanings = new ArrayList <String>();
			meanings.add("river in Italy");
			theWords.put(key, meanings);

			key = "aroma";
			meanings = new ArrayList <String>();
			meanings.add("pungent smell");
			theWords.put(key, meanings);

			key = "arrived";
			meanings = new ArrayList <String>();
			meanings.add("gained recognition");
			theWords.put(key, meanings);

			key = "arrow";
			meanings = new ArrayList <String>();
			meanings.add("indicator");
			meanings.add("missile");
			theWords.put(key, meanings);

			key = "arsenic";
			meanings = new ArrayList <String>();
			meanings.add("poison");
			theWords.put(key, meanings);

			key = "art";
			meanings = new ArrayList <String>();
			meanings.add("creative work");
			theWords.put(key, meanings);

			key = "artichoke";
			meanings = new ArrayList <String>();
			meanings.add("something to eat");
			theWords.put(key, meanings);

			key = "article";
			meanings = new ArrayList <String>();
			meanings.add("thing");
			theWords.put(key, meanings);

			key = "artisan";
			meanings = new ArrayList <String>();
			meanings.add("made in a traditional way");
			theWords.put(key, meanings);

			key = "artist";
			meanings = new ArrayList <String>();
			meanings.add("Constable, perhaps");
			theWords.put(key, meanings);

			key = "artists";
			meanings = new ArrayList <String>();
			meanings.add("performers");
			theWords.put(key, meanings);

			key = "artiste";
			meanings = new ArrayList <String>();
			meanings.add("performer");
			theWords.put(key, meanings);

			key = "artless";
			meanings = new ArrayList <String>();
			meanings.add("lacking guile");
			theWords.put(key, meanings);

			key = "as";
			meanings = new ArrayList <String>();
			meanings.add("during the time of");
			meanings.add("like");
			theWords.put(key, meanings);

			key = "ascend";
			meanings = new ArrayList <String>();
			meanings.add("come up");
			theWords.put(key, meanings);

			key = "ascot";
			meanings = new ArrayList <String>();
			meanings.add("racecourse");
			theWords.put(key, meanings);

			key = "ash";
			meanings = new ArrayList <String>();
			meanings.add("fire residue");
			meanings.add("tree");
			meanings.add("wood");
			theWords.put(key, meanings);

			key = "ashes";
			meanings = new ArrayList <String>();
			meanings.add("trees");
			meanings.add("what's left after burning");
			theWords.put(key, meanings);

			key = "ashtray";
			meanings = new ArrayList <String>();
			meanings.add("butt container");
			theWords.put(key, meanings);

			key = "aside";
			meanings = new ArrayList <String>();
			meanings.add("apart");
			theWords.put(key, meanings);

			key = "ask";
			meanings = new ArrayList <String>();
			meanings.add("request");
			theWords.put(key, meanings);

			key = "asp";
			meanings = new ArrayList <String>();
			meanings.add("snake");
			theWords.put(key, meanings);

			key = "asps";
			meanings = new ArrayList <String>();
			meanings.add("snakes");
			theWords.put(key, meanings);

			key = "aspic";
			meanings = new ArrayList <String>();
			meanings.add("jelly");
			theWords.put(key, meanings);

			key = "aspire";
			meanings = new ArrayList <String>();
			meanings.add("have an ambition");
			meanings.add("hope");
			theWords.put(key, meanings);

			key = "aspirin";
			meanings = new ArrayList <String>();
			meanings.add("drug");
			theWords.put(key, meanings);

			key = "asps";
			meanings = new ArrayList <String>();
			meanings.add("snakes");
			theWords.put(key, meanings);

			key = "ass";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("backside");
			theWords.put(key, meanings);

			key = "assailed";
			meanings = new ArrayList <String>();
			meanings.add("attacked");
			theWords.put(key, meanings);

			key = "assam";
			meanings = new ArrayList <String>();
			meanings.add("part of Inida");
			theWords.put(key, meanings);

			key = "assemble";
			meanings = new ArrayList <String>();
			meanings.add("gather");
			theWords.put(key, meanings);

			key = "asset";
			meanings = new ArrayList <String>();
			meanings.add("benefit");
			theWords.put(key, meanings);

			key = "assign";
			meanings = new ArrayList <String>();
			meanings.add("delegate");
			theWords.put(key, meanings);

			key = "assumed";
			meanings = new ArrayList <String>();
			meanings.add("as expected");
			meanings.add("put on");
			theWords.put(key, meanings);

			key = "aster";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			theWords.put(key, meanings);

			key = "astringency";
			meanings = new ArrayList <String>();
			meanings.add("tart quality");
			theWords.put(key, meanings);

			key = "astringent";
			meanings = new ArrayList <String>();
			meanings.add("severe");
			theWords.put(key, meanings);

			key = "at";
			meanings = new ArrayList <String>();
			meanings.add("from");
			theWords.put(key, meanings);

			key = "atari";
			meanings = new ArrayList <String>();
			meanings.add("old video game maker");
			theWords.put(key, meanings);

			key = "ate";
			meanings = new ArrayList <String>();
			meanings.add("consumed");
			meanings.add("devoured");
			theWords.put(key, meanings);

			key = "atease";//at ease
			meanings = new ArrayList <String>();
			meanings.add("relaxed");
			theWords.put(key, meanings);

			key = "athens";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			theWords.put(key, meanings);

			key = "athlete";
			meanings = new ArrayList <String>();
			meanings.add("runner");
			meanings.add("sportsman");
			theWords.put(key, meanings);

			key = "athos";
			meanings = new ArrayList <String>();
			meanings.add("musketeer");
			theWords.put(key, meanings);

			key = "atissue";
			meanings = new ArrayList <String>();
			meanings.add("under discussion");
			theWords.put(key, meanings);

			key = "atlas";
			meanings = new ArrayList <String>();
			meanings.add("book of maps");
			theWords.put(key, meanings);

			key = "atlast"; //at last
			meanings = new ArrayList <String>();
			meanings.add("finally");
			theWords.put(key, meanings);

			key = "atoll";
			meanings = new ArrayList <String>();
			meanings.add("coral island");
			theWords.put(key, meanings);

			key = "atom";
			meanings = new ArrayList <String>();
			meanings.add("basic thing");
			theWords.put(key, meanings);

			key = "atonce";
			meanings = new ArrayList <String>();
			meanings.add("without delay");
			meanings.add("without hesitation");
			theWords.put(key, meanings);

			key = "attest";
			meanings = new ArrayList <String>();
			meanings.add("bear witness");
			theWords.put(key, meanings);

			key = "attics";
			meanings = new ArrayList <String>();
			meanings.add("lofts");
			theWords.put(key, meanings);

			key = "audi";
			meanings = new ArrayList <String>();
			meanings.add("foreign car");
			theWords.put(key, meanings);

			key = "audition";
			meanings = new ArrayList <String>();
			meanings.add("test for actors");
			theWords.put(key, meanings);

			key = "augment";
			meanings = new ArrayList <String>();
			meanings.add("add to");
			theWords.put(key, meanings);

			key = "aunt";
			meanings = new ArrayList <String>();
			meanings.add("relative");
			meanings.add("female relative");
			theWords.put(key, meanings);

			key = "austere";
			meanings = new ArrayList <String>();
			meanings.add("stark");
			theWords.put(key, meanings);

			key = "author";
			meanings = new ArrayList <String>();
			meanings.add("writer");
			theWords.put(key, meanings);

			key = "authority";
			meanings = new ArrayList <String>();
			meanings.add("charge");
			theWords.put(key, meanings);

			key = "ava";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);

			key = "avarice";
			meanings = new ArrayList <String>();
			meanings.add("deadly sin");
			theWords.put(key, meanings);

			key = "avenue";
			meanings = new ArrayList <String>();
			meanings.add("road");
			theWords.put(key, meanings);

			key = "aver";
			meanings = new ArrayList <String>();
			meanings.add("declare");
			theWords.put(key, meanings);

			key = "averse";
			meanings = new ArrayList <String>();
			meanings.add("reluctant");
			theWords.put(key, meanings);

			key = "avon";
			meanings = new ArrayList <String>();
			meanings.add("river");
			meanings.add("waterway");
			theWords.put(key, meanings);

			key = "awash";
			meanings = new ArrayList <String>();
			meanings.add("flooded");
			theWords.put(key, meanings);

			key = "away";
			meanings = new ArrayList <String>();
			meanings.add("not at home");
			meanings.add("opponents' ground");
			theWords.put(key, meanings);

			key = "awe";
			meanings = new ArrayList <String>();
			meanings.add("wonder");
			theWords.put(key, meanings);

			key = "awl";
			meanings = new ArrayList <String>();
			meanings.add("tool");
			theWords.put(key, meanings);

			key = "axiom";
			meanings = new ArrayList <String>();
			meanings.add("taken for granted");
			theWords.put(key, meanings);

			key = "axis";
			meanings = new ArrayList <String>();
			meanings.add("centre of revolution");
			theWords.put(key, meanings);
			
			return theWords;
		}//end loadAWords
		
		public TreeMap<String, ArrayList<String>> loadBWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			// load b's
					key = "baboon";
					meanings = new ArrayList <String>();
					meanings.add("monkey");
					theWords.put(key, meanings);
					
					key = "baby";
					meanings = new ArrayList <String>();
					meanings.add("infant");
					theWords.put(key, meanings);
					
					key = "bacillus";
					meanings = new ArrayList <String>();
					meanings.add("germ");
					theWords.put(key, meanings);
					
					key = "bacardi";
					meanings = new ArrayList <String>();
					meanings.add("rum");
					theWords.put(key, meanings);
					
					key = "bach";
					meanings = new ArrayList <String>();
					meanings.add("composer");
					theWords.put(key, meanings);
					
					key = "bachelor";
					meanings = new ArrayList <String>();
					meanings.add("single man");
					theWords.put(key, meanings);
					
					key = "back";
					meanings = new ArrayList <String>();
					meanings.add("second");
					meanings.add("support");
					theWords.put(key, meanings);
					
					key = "bacon";
					meanings = new ArrayList <String>();
					meanings.add("meat");
					theWords.put(key, meanings);
					
					key = "backlog";
					meanings = new ArrayList <String>();
					meanings.add("arrears of work");
					meanings.add("work yet to be done");
					theWords.put(key, meanings);
					
					key = "backseat";
					meanings = new ArrayList <String>();
					meanings.add("type of driver");
					theWords.put(key, meanings);
					
					key = "bad";
					meanings = new ArrayList <String>();
					meanings.add("immoral");
					theWords.put(key, meanings);
					
					key = "bade";
					meanings = new ArrayList <String>();
					meanings.add("ordered");
					theWords.put(key, meanings);
					
					key = "bag";
					meanings = new ArrayList <String>();
					meanings.add("get your hands on");
					theWords.put(key, meanings);
					
					key = "baglady";
					meanings = new ArrayList <String>();
					meanings.add("homeless person");
					theWords.put(key, meanings);
					
					key = "bags";
					meanings = new ArrayList <String>();
					meanings.add("plenty of");
					meanings.add("luggage");
					theWords.put(key, meanings);
					
					key = "bagel";
					meanings = new ArrayList <String>();
					meanings.add("roll");
					theWords.put(key, meanings);
					
					key = "bail";
					meanings = new ArrayList <String>();
					meanings.add("release");
					theWords.put(key, meanings);
					
					key = "bairns";
					meanings = new ArrayList <String>();
					meanings.add("Scottish children");
					theWords.put(key, meanings);
					
					key = "balaclava";
					meanings = new ArrayList <String>();
					meanings.add("battle");
					meanings.add("wooly hood");
					theWords.put(key, meanings);
					
					key = "bald";
					meanings = new ArrayList <String>();
					meanings.add("hairless");
					theWords.put(key, meanings);
					
					key = "balderdash";
					meanings = new ArrayList <String>();
					meanings.add("nonesense");
					theWords.put(key, meanings);
					
					key = "bale";
					meanings = new ArrayList <String>();
					meanings.add("bundle");
					theWords.put(key, meanings);
					
					key = "ball";
					meanings = new ArrayList <String>();
					meanings.add("dance");
					theWords.put(key, meanings);
					
					key = "ballad";
					meanings = new ArrayList <String>();
					meanings.add("song");
					theWords.put(key, meanings);
					
					key = "ballet";
					meanings = new ArrayList <String>();
					meanings.add("dance");
					theWords.put(key, meanings);
					
					key = "ballot";
					meanings = new ArrayList <String>();
					meanings.add("vote");
					theWords.put(key, meanings);
					
					key = "ballots";
					meanings = new ArrayList <String>();
					meanings.add("votes");
					theWords.put(key, meanings);
					
					key = "ballpoints";
					meanings = new ArrayList <String>();
					meanings.add("pens");
					theWords.put(key, meanings);
					
					key = "ballroom";
					meanings = new ArrayList <String>();
					meanings.add("dance venue");
					theWords.put(key, meanings);
					
					key = "balti";
					meanings = new ArrayList <String>();
					meanings.add("Indian food");
					theWords.put(key, meanings);
							
					key = "baltic";
					meanings = new ArrayList <String>();
					meanings.add("sea");
					theWords.put(key, meanings);
					
					key = "ban";
					meanings = new ArrayList <String>();
					meanings.add("embargo");
					meanings.add("exclude");
					meanings.add("outlaw");
					meanings.add("prohibit");
					//meanings.add("bar");
					theWords.put(key, meanings);
					
					key = "bananas";
					meanings = new ArrayList <String>();
					meanings.add("crazy");
					theWords.put(key, meanings);
					
					key = "bananaskin";//banana skin
					meanings = new ArrayList <String>();
					meanings.add("might be responsible for a slip");
					theWords.put(key, meanings);
					
					key = "bands";
					meanings = new ArrayList <String>();
					meanings.add("gangs");
					theWords.put(key, meanings);
					
					key = "bang";
					meanings = new ArrayList <String>();
					meanings.add("gun sound");
					theWords.put(key, meanings);
					
					key = "bangor";
					meanings = new ArrayList <String>();
					meanings.add("city");
					theWords.put(key, meanings);
					
					key = "bankers";
					meanings = new ArrayList <String>();
					meanings.add("certain bets");
					theWords.put(key, meanings);
					
					key = "banner";
					meanings = new ArrayList <String>();
					meanings.add("flag");
					meanings.add("prohibitionist");
					theWords.put(key, meanings);
					
					key = "banners";
					meanings = new ArrayList <String>();
					meanings.add("flags");
					meanings.add("prohibitionists");
					theWords.put(key, meanings);

					key = "bans";
					meanings = new ArrayList <String>();
					meanings.add("prohibits");
					theWords.put(key, meanings);
					
					key = "bantam";
					meanings = new ArrayList <String>();
					meanings.add("chicken");
					theWords.put(key, meanings);

					key = "banyam";
					meanings = new ArrayList <String>();
					meanings.add("tree");
					theWords.put(key, meanings);
					
					key = "bar";
					meanings = new ArrayList <String>();
					meanings.add("block");
					meanings.add("forbid");
					meanings.add("prohibit");
					meanings.add("pub counter");
					meanings.add("saloon");
					theWords.put(key, meanings);
					
					key = "bards";
					meanings = new ArrayList <String>();
					meanings.add("poets");
					theWords.put(key, meanings);
					
					key = "bars";
					meanings = new ArrayList <String>();
					meanings.add("pubs");
					theWords.put(key, meanings);
							
					key = "bare";
					meanings = new ArrayList <String>();
					meanings.add("nude");
					theWords.put(key, meanings);
							
					key = "barn";
					meanings = new ArrayList <String>();
					meanings.add("granary");
					theWords.put(key, meanings);
					
					key = "barns";
					meanings = new ArrayList <String>();
					meanings.add("food stores");
					theWords.put(key, meanings);
					
					key = "barnacle";
					meanings = new ArrayList <String>();
					meanings.add("clinging shellfish");
					meanings.add("marine crustacean");
					theWords.put(key, meanings);
					
					key = "baron";
					meanings = new ArrayList <String>();
					meanings.add("nobleman");
					theWords.put(key, meanings);
					
					key = "barometer";
					meanings = new ArrayList <String>();
					meanings.add("weather forecasting device");
					theWords.put(key, meanings);
					
					key = "baroness";
					meanings = new ArrayList <String>();
					meanings.add("lady");
					theWords.put(key, meanings);
					
					key = "barrage";
					meanings = new ArrayList <String>();
					meanings.add("artillery fire");
					meanings.add("onslaught");
					theWords.put(key, meanings);
					
					key = "barrier";
					meanings = new ArrayList <String>();
					meanings.add("blockage");
					meanings.add("obstacle");
					theWords.put(key, meanings);
					
					key = "barrister";
					meanings = new ArrayList <String>();
					meanings.add("lawyer");
					theWords.put(key, meanings);
					
					key = "bartender";
					meanings = new ArrayList <String>();
					meanings.add("pub worker");
					theWords.put(key, meanings);
					
					key = "basic";
					meanings = new ArrayList <String>();
					meanings.add("primary");
					meanings.add("simple");
					theWords.put(key, meanings);
					
					key = "basil";
					meanings = new ArrayList <String>();
					meanings.add("herb");
					theWords.put(key, meanings);
					
					key = "basket";
					meanings = new ArrayList <String>();
					meanings.add("container");
					theWords.put(key, meanings);
					
					key = "bat";
					meanings = new ArrayList <String>();
					meanings.add("club");
					meanings.add("flier");
					meanings.add("flying mammal");
					theWords.put(key, meanings);
					
					key = "bates";
					meanings = new ArrayList <String>();
					meanings.add("psychotic hotel owner");
					theWords.put(key, meanings);
					
					key = "bath";
					meanings = new ArrayList <String>();
					meanings.add("southern city");
					meanings.add("UK city");
					theWords.put(key, meanings);
					
					key = "bathe";
					meanings = new ArrayList <String>();
					meanings.add("wash");
					theWords.put(key, meanings);
					
					key = "bathtub";
					meanings = new ArrayList <String>();
					meanings.add("washing vessel");
					theWords.put(key, meanings);
					
					key = "batter";
					meanings = new ArrayList <String>();
					meanings.add("assault");
					meanings.add("baseball player");
					meanings.add("beat");
					meanings.add("pancake mix");
					theWords.put(key, meanings);
					
					key = "battle";
					meanings = new ArrayList <String>();
					meanings.add("fight");
					meanings.add("struggle");
					theWords.put(key, meanings);
					
					key = "bawl";
					meanings = new ArrayList <String>();
					meanings.add("blubber");
					meanings.add("cry");
					theWords.put(key, meanings);
					
					key = "bay";
					meanings = new ArrayList <String>();
					meanings.add("recess");
					theWords.put(key, meanings);
					
					key = "be";
					meanings = new ArrayList <String>();
					meanings.add("exist");
					theWords.put(key, meanings);
					
					key = "beagle";
					meanings = new ArrayList <String>();
					meanings.add("dog");
					theWords.put(key, meanings);
					
					key = "beam";
					meanings = new ArrayList <String>();
					meanings.add("smile at");
					meanings.add("timber support");
					theWords.put(key, meanings);

					key = "beano";
					meanings = new ArrayList <String>();
					meanings.add("party");
					theWords.put(key, meanings);
					
					key = "bear";
					meanings = new ArrayList <String>();
					meanings.add("animal");
					meanings.add("carry");
					meanings.add("endure");
					theWords.put(key, meanings);
					
					key = "bears";
					meanings = new ArrayList <String>();
					meanings.add("carries");
					meanings.add("endures");
					theWords.put(key, meanings);
					
					key = "bearskin";
					meanings = new ArrayList <String>();
					meanings.add("hat");
					theWords.put(key, meanings);
					
					key = "beastly";
					meanings = new ArrayList <String>();
					meanings.add("unkind");
					theWords.put(key, meanings);
					
					key = "beat";
					meanings = new ArrayList <String>();
					meanings.add("strike");
					theWords.put(key, meanings);
					
					key = "bed";
					meanings = new ArrayList <String>();
					meanings.add("berth");
					theWords.put(key, meanings);
					
					key = "bedlam";
					meanings = new ArrayList <String>();
					meanings.add("state of uproar");
					theWords.put(key, meanings);
					
					key = "bedroom";
					meanings = new ArrayList <String>();
					meanings.add("chamber");
					theWords.put(key, meanings);
					
					key = "bee";
					meanings = new ArrayList <String>();
					meanings.add("insect");
					meanings.add("worker");
					theWords.put(key, meanings);
					
					key = "beech";
					meanings = new ArrayList <String>();
					meanings.add("wood");
					theWords.put(key, meanings);
					
					key = "beef";
					meanings = new ArrayList <String>();
					meanings.add("meat");
					theWords.put(key, meanings);
					
					key = "beetle";
					meanings = new ArrayList <String>();
					meanings.add("small creature");
					theWords.put(key, meanings);
					
					key = "befog";
					meanings = new ArrayList <String>();
					meanings.add("cause confusion");
					theWords.put(key, meanings);
					
					key = "beg";
					meanings = new ArrayList <String>();
					meanings.add("petition");
					theWords.put(key, meanings);
					
					key = "belgians";
					meanings = new ArrayList <String>();
					meanings.add("Europeans");
					theWords.put(key, meanings);
					
					key = "bell";
					meanings = new ArrayList <String>();
					meanings.add("phone pioneer");
					theWords.put(key, meanings);
					
					key = "belle";
					meanings = new ArrayList <String>();
					meanings.add("beautiful woman");
					theWords.put(key, meanings);
					
					key = "below";
					meanings = new ArrayList <String>();
					meanings.add("underneath");
					theWords.put(key, meanings);
					
					key = "belt";
					meanings = new ArrayList <String>();
					meanings.add("beat");
					theWords.put(key, meanings);
					
					key = "bemused";
					meanings = new ArrayList <String>();
					meanings.add("puzzled");
					theWords.put(key, meanings);
					
					key = "benny";
					meanings = new ArrayList <String>();
					meanings.add("little Benjamin");
					theWords.put(key, meanings);
					
					key = "berg";
					meanings = new ArrayList <String>();
					meanings.add("composer");
					theWords.put(key, meanings);
					
					key = "bergamot";
					meanings = new ArrayList <String>();
					meanings.add("pear");
					theWords.put(key, meanings);
					
					key = "berlin";
					meanings = new ArrayList <String>();
					meanings.add("German city");
					theWords.put(key, meanings);
					
					key = "bermuda";
					meanings = new ArrayList <String>();
					meanings.add("country");
					theWords.put(key, meanings);
					
					key = "bert";
					meanings = new ArrayList <String>();
					meanings.add("man");
					theWords.put(key, meanings);
					
					key = "berth";
					meanings = new ArrayList <String>();
					meanings.add("place for a boat");
					theWords.put(key, meanings);
					
					key = "bertha";
					meanings = new ArrayList <String>();
					meanings.add("woman");
					theWords.put(key, meanings);
					
					key = "bestend"; // best end
					meanings = new ArrayList <String>();
					meanings.add("cut");
					theWords.put(key, meanings);
							
					key = "bet";
					meanings = new ArrayList <String>();
					meanings.add("gamble");
					meanings.add("punt");
					meanings.add("put ones money on");
					meanings.add("speculation");
					theWords.put(key, meanings);
					
					key = "beta";
					meanings = new ArrayList <String>();
					meanings.add("Greek character");
					theWords.put(key, meanings);
					
					key = "betrayed";
					meanings = new ArrayList <String>();
					meanings.add("shopped");
					theWords.put(key, meanings);
					
					key = "betwixt";
					meanings = new ArrayList <String>();
					meanings.add("in the middle of");
					theWords.put(key, meanings);
					
					key = "bewitch";
					meanings = new ArrayList <String>();
					meanings.add("charm");
					theWords.put(key, meanings);
					
					key = "beyond";
					meanings = new ArrayList <String>();
					meanings.add("on the other side");
					theWords.put(key, meanings);
					
					key = "bhutan";
					meanings = new ArrayList <String>();
					meanings.add("mountain kingdom");
					theWords.put(key, meanings);
					
					key = "bible";
					meanings = new ArrayList <String>();
					meanings.add("holy book");
					theWords.put(key, meanings);
					
					key = "bid";
					meanings = new ArrayList <String>();
					meanings.add("proposal");
					theWords.put(key, meanings);
					
					key = "big";
					meanings = new ArrayList <String>();
					meanings.add("important");
					meanings.add("large");
					theWords.put(key, meanings);
					
					key = "bigamy";
					meanings = new ArrayList <String>();
					meanings.add("marital crime");
					theWords.put(key, meanings);
					
					key = "bigger";
					meanings = new ArrayList <String>();
					meanings.add("more important");
					meanings.add("larger");
					theWords.put(key, meanings);
					
					key = "bigot";
					meanings = new ArrayList <String>();
					meanings.add("racist");
					theWords.put(key, meanings);
							
					key = "bikers";
					meanings = new ArrayList <String>();
					meanings.add("motorcyclists");
					theWords.put(key, meanings);
									
					key = "bill";
					meanings = new ArrayList <String>();
					meanings.add("invoice");
					theWords.put(key, meanings);
					
					key = "bin";
					meanings = new ArrayList <String>();
					meanings.add("container");
					meanings.add("get rid of");
					theWords.put(key, meanings);
					
					key = "bird";
					meanings = new ArrayList <String>();
					meanings.add("animal");
					theWords.put(key, meanings);
					
					key = "bistro";
					meanings = new ArrayList <String>();
					meanings.add("restaurant");
					theWords.put(key, meanings);
					
					key = "bit";
					meanings = new ArrayList <String>();
					meanings.add("got teeth into");
					meanings.add("part");
					meanings.add("piece");
					meanings.add("portion");
					theWords.put(key, meanings);
					
					key = "bitch";
					meanings = new ArrayList <String>();
					meanings.add("dog");
					theWords.put(key, meanings);
					
					key = "bitter";
					meanings = new ArrayList <String>();
					meanings.add("very cold");
					theWords.put(key, meanings);
					
					key = "bittern";
					meanings = new ArrayList <String>();
					meanings.add("bird");
					theWords.put(key, meanings);
					
					key = "blamed";
					meanings = new ArrayList <String>();
					meanings.add("held responsible for");
					theWords.put(key, meanings);
					
					key = "blend";
					meanings = new ArrayList <String>();
					meanings.add("mix");
					theWords.put(key, meanings);
					
					key = "blenheim";
					meanings = new ArrayList <String>();
					meanings.add("palace");
					theWords.put(key, meanings);
					
					key = "blenny";
					meanings = new ArrayList <String>();
					meanings.add("fish");
					theWords.put(key, meanings);
					
					key = "blessed";
					meanings = new ArrayList <String>();
					meanings.add("consecrated");
					theWords.put(key, meanings);
					
					key = "blinder";
					meanings = new ArrayList <String>();
					meanings.add("impressive performance");
					meanings.add("seeing less");
					theWords.put(key, meanings);
									
					key = "blithe";
					meanings = new ArrayList <String>();
					meanings.add("jolly");
					theWords.put(key, meanings);
					
					key = "bloater";
					meanings = new ArrayList <String>();
					meanings.add("fish");
					theWords.put(key, meanings);
					
					key = "bloc";
					meanings = new ArrayList <String>();
					meanings.add("allied countries");
					theWords.put(key, meanings);
					
					key = "block";
					meanings = new ArrayList <String>();
					meanings.add("stop");
					theWords.put(key, meanings);
					
					key = "blonde";
					meanings = new ArrayList <String>();
					meanings.add("fair haired person");
					theWords.put(key, meanings);
							
					key = "blot";
					meanings = new ArrayList <String>();
					meanings.add("smudge");
					theWords.put(key, meanings);
					
					key = "blots";
					meanings = new ArrayList <String>();
					meanings.add("smudges");
					theWords.put(key, meanings);
					
					key = "blouse";
					meanings = new ArrayList <String>();
					meanings.add("garment");
					theWords.put(key, meanings);

					key = "blubber";
					meanings = new ArrayList <String>();
					meanings.add("cry");
					theWords.put(key, meanings);
					
					key = "blue";
					meanings = new ArrayList <String>();
					meanings.add("down");
					theWords.put(key, meanings);
					
					key = "bluer";
					meanings = new ArrayList <String>();
					meanings.add("sadder");
					theWords.put(key, meanings);
					
					key = "bluebottle";
					meanings = new ArrayList <String>();
					meanings.add("fly");
					theWords.put(key, meanings);
					
					key = "boa";
					meanings = new ArrayList <String>();
					meanings.add("snake");
					theWords.put(key, meanings);
					
					key = "boar";
					meanings = new ArrayList <String>();
					meanings.add("pig");
					theWords.put(key, meanings);
					
					key = "boards";
					meanings = new ArrayList <String>();
					meanings.add("gets on a bus");
					theWords.put(key, meanings);
					
					key = "boat";
					meanings = new ArrayList <String>();
					meanings.add("vessel");
					theWords.put(key, meanings);
					
					key = "boater";
					meanings = new ArrayList <String>();
					meanings.add("hat");
					theWords.put(key, meanings);
					
					key = "boats";
					meanings = new ArrayList <String>();
					meanings.add("containers of sauce");
					meanings.add("vessels");
					theWords.put(key, meanings);
					
					key = "body";
					meanings = new ArrayList <String>();
					meanings.add("stiff");
					theWords.put(key, meanings);
					
					key = "bogus";
					meanings = new ArrayList <String>();
					meanings.add("false");
					theWords.put(key, meanings);
					
					key = "boiled";
					meanings = new ArrayList <String>();
					meanings.add("cooked");
					theWords.put(key, meanings);
					
					key = "bollards";
					meanings = new ArrayList <String>();
					meanings.add("traffic posts");
					theWords.put(key, meanings);
					
					key = "bomb";
					meanings = new ArrayList <String>();
					meanings.add("explosive");
					theWords.put(key, meanings);
					
					key = "bombay";
					meanings = new ArrayList <String>();
					meanings.add("former Indian city");
					theWords.put(key, meanings);
					
					key = "bone";
					meanings = new ArrayList <String>();
					meanings.add("study intensively");
					theWords.put(key, meanings);
					
					key = "boo";
					meanings = new ArrayList <String>();
					meanings.add("cry of contempt");
					meanings.add("shout displeasure");
					theWords.put(key, meanings);
					
					key = "boom";
					meanings = new ArrayList <String>();
					meanings.add("good times");
					theWords.put(key, meanings);
							
					key = "boost";
					meanings = new ArrayList <String>();
					meanings.add("raise");
					theWords.put(key, meanings);
					
					key = "boot";
					meanings = new ArrayList <String>();
					meanings.add("kick");
					meanings.add("luggage compartment");
					meanings.add("start computer");
					theWords.put(key, meanings);
					
					key = "boredom";
					meanings = new ArrayList <String>();
					meanings.add("tedium");
					theWords.put(key, meanings);
					
					key = "boring";
					meanings = new ArrayList <String>();
					meanings.add("drilling");
					meanings.add("uninteresting");
					theWords.put(key, meanings);
					
					key = "botanist";
					meanings = new ArrayList <String>();
					meanings.add("biologist");
					meanings.add("plant biologist");
					theWords.put(key, meanings);
					
					key = "bottle";
					meanings = new ArrayList <String>();
					meanings.add("vessel");
					theWords.put(key, meanings);
					
					key = "bough";
					meanings = new ArrayList <String>();
					meanings.add("branch");
					theWords.put(key, meanings);
					
					key = "bought";
					meanings = new ArrayList <String>();
					meanings.add("purchased");
					theWords.put(key, meanings);
					
					key = "bound";
					meanings = new ArrayList <String>();
					meanings.add("spring");
					theWords.put(key, meanings);
					
					key = "bow";
					meanings = new ArrayList <String>();
					meanings.add("part of London");
					theWords.put(key, meanings);
					
					key = "bowmore";
					meanings = new ArrayList <String>();
					meanings.add("whisky");
					theWords.put(key, meanings);
					
					key = "bowl";
					meanings = new ArrayList <String>();
					meanings.add("make deliveries");
					meanings.add("US stadium");
					theWords.put(key, meanings);
					
					key = "bowler";
					meanings = new ArrayList <String>();
					meanings.add("cricketer");
					meanings.add("hat");
					theWords.put(key, meanings);
					
					key = "bowls";
					meanings = new ArrayList <String>();
					meanings.add("game on the green");
					theWords.put(key, meanings);
					
					key = "boy";
					meanings = new ArrayList <String>();
					meanings.add("young man");
					theWords.put(key, meanings);
					
					key = "boys";
					meanings = new ArrayList <String>();
					meanings.add("children");
					theWords.put(key, meanings);
					
					key = "brag";
					meanings = new ArrayList <String>();
					meanings.add("boast");
					meanings.add("show off");
					theWords.put(key, meanings);
					
					key = "brain";
					meanings = new ArrayList <String>();
					meanings.add("intellect");
					theWords.put(key, meanings);
					
					key = "brake";
					meanings = new ArrayList <String>();
					meanings.add("stop quickly");
					theWords.put(key, meanings);
					
					key = "bran";
					meanings = new ArrayList <String>();
					meanings.add("cereal");
					theWords.put(key, meanings);
					
					key = "branch";
					meanings = new ArrayList <String>();
					meanings.add("part of tree");
					theWords.put(key, meanings);
					
					key = "brandish";
					meanings = new ArrayList <String>();
					meanings.add("flourish");
					theWords.put(key, meanings);
					
					key = "brandy";
					meanings = new ArrayList <String>();
					meanings.add("drink");
					theWords.put(key, meanings);
					
					key = "brassica";
					meanings = new ArrayList <String>();
					meanings.add("a green");
					theWords.put(key, meanings);
					
					key = "bravado";
					meanings = new ArrayList <String>();
					meanings.add("false confidence");
					theWords.put(key, meanings);
					
					key = "bravo";
					meanings = new ArrayList <String>();
					meanings.add("congratulations");
					theWords.put(key, meanings);
					
					key = "breach";
					meanings = new ArrayList <String>();
					meanings.add("gap");
					meanings.add("gap in defence");
					theWords.put(key, meanings);
					
					key = "bread";
					meanings = new ArrayList <String>();
					meanings.add("loaf");
					meanings.add("money");
					theWords.put(key, meanings);
					
					key = "breadline";
					meanings = new ArrayList <String>();
					meanings.add("food queue");
					theWords.put(key, meanings);

					key = "break";
					meanings = new ArrayList <String>();
					meanings.add("opportunity");
					meanings.add("split");
					theWords.put(key, meanings);
					
					key = "breakin";//break in
					meanings = new ArrayList <String>();
					meanings.add("unauthorised entry");
					theWords.put(key, meanings);
					
					key = "breast";
					meanings = new ArrayList <String>();
					meanings.add("part of a chimney");
					theWords.put(key, meanings);
					
					key = "brew";
					meanings = new ArrayList <String>();
					meanings.add("drink");
					meanings.add("make drink");
					meanings.add("make tea");
					theWords.put(key, meanings);
					
					key = "bride";
					meanings = new ArrayList <String>();
					meanings.add("newly-wed");
					theWords.put(key, meanings);
					
					key = "bridge";
					meanings = new ArrayList <String>();
					meanings.add("game");
					theWords.put(key, meanings);
					
					key = "bridget";
					meanings = new ArrayList <String>();
					meanings.add("girl");
					theWords.put(key, meanings);
					
					key = "brie";
					meanings = new ArrayList <String>();
					meanings.add("cheese");
					meanings.add("French cheese");
					theWords.put(key, meanings);
					
					key = "brief";
					meanings = new ArrayList <String>();
					meanings.add("short");
					theWords.put(key, meanings);
					
					key = "brigands";
					meanings = new ArrayList <String>();
					meanings.add("outlaws");
					theWords.put(key, meanings);
					
					key = "bright";
					meanings = new ArrayList <String>();
					meanings.add("smart");
					theWords.put(key, meanings);
					
					key = "brighton";
					meanings = new ArrayList <String>();
					meanings.add("seaside resort");
					theWords.put(key, meanings);
					
					key = "brill";
					meanings = new ArrayList <String>();
					meanings.add("excellent");
					meanings.add("swimmer");
					theWords.put(key, meanings);

					key = "bring";
					meanings = new ArrayList <String>();
					meanings.add("transport");
					theWords.put(key, meanings);
					
					key = "britain";
					meanings = new ArrayList <String>();
					meanings.add("island");
					theWords.put(key, meanings);
									
					key = "brogue";
					meanings = new ArrayList <String>();
					meanings.add("shoe");
					theWords.put(key, meanings);
					
					key = "broke";
					meanings = new ArrayList <String>();
					meanings.add("insolvent");
					theWords.put(key, meanings);
					
					key = "broker";
					meanings = new ArrayList <String>();
					meanings.add("middleman");
					theWords.put(key, meanings);
					
					key = "broom";
					meanings = new ArrayList <String>();
					meanings.add("cleaner");
					theWords.put(key, meanings);
					
					key = "bros";
					meanings = new ArrayList <String>();
					meanings.add("brothers");
					theWords.put(key, meanings);
					
					key = "bruisers";
					meanings = new ArrayList <String>();
					meanings.add("tough guys");
					theWords.put(key, meanings);
					
					key = "brush";
					meanings = new ArrayList <String>();
					meanings.add("sweep");
					theWords.put(key, meanings);
					
					key = "bubble";
					meanings = new ArrayList <String>();
					meanings.add("illusion");
					theWords.put(key, meanings);
					
					key = "buff";
					meanings = new ArrayList <String>();
					meanings.add("enthusiast");
					theWords.put(key, meanings);
					
					key = "buffoon";
					meanings = new ArrayList <String>();
					meanings.add("clown");
					theWords.put(key, meanings);
					
					key = "bull";
					meanings = new ArrayList <String>();
					meanings.add("animal");
					theWords.put(key, meanings);
					
					key = "bulldoze";
					meanings = new ArrayList <String>();
					meanings.add("knock down");
					theWords.put(key, meanings);
					
					key = "bun";
					meanings = new ArrayList <String>();
					meanings.add("roll");
					theWords.put(key, meanings);
					
					key = "bursary";
					meanings = new ArrayList <String>();
					meanings.add("student grant");
					theWords.put(key, meanings);
					
					key = "bus";
					meanings = new ArrayList <String>();
					meanings.add("public transport");
					meanings.add("public vehicle");
					meanings.add("transport");
					meanings.add("vehicle");
					theWords.put(key, meanings);
					
					key = "bush";
					meanings = new ArrayList <String>();
					meanings.add("US president");
					theWords.put(key, meanings);
					
					key = "bust";
					meanings = new ArrayList <String>();
					meanings.add("broke");
					meanings.add("chest");
					theWords.put(key, meanings);
					
					key = "but";
					meanings = new ArrayList <String>();
					meanings.add("however");
					meanings.add("objection");
					theWords.put(key, meanings);
					
					key = "butch";
					meanings = new ArrayList <String>();
					meanings.add("well built");
					theWords.put(key, meanings);
					
					key = "butt";
					meanings = new ArrayList <String>();
					meanings.add("barrel");
					theWords.put(key, meanings);
					
					key = "butter";
					meanings = new ArrayList <String>();
					meanings.add("dairy product");
					meanings.add("fat");
					theWords.put(key, meanings);
					
					key = "butterfly";
					meanings = new ArrayList <String>();
					meanings.add("insect");
					theWords.put(key, meanings);
					
					key = "by";
					meanings = new ArrayList <String>();
					meanings.add("near");
					theWords.put(key, meanings);
				return theWords;
		}//end loadB
		
		public TreeMap<String, ArrayList<String>> loadCWords() {
			TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;

			// load c's
			key = "cab";
			meanings = new ArrayList <String>();
			meanings.add("horse-drawn vehicle");
			meanings.add("taxi");
			theWords.put(key, meanings);

			key = "cabs";
			meanings = new ArrayList <String>();
			meanings.add("horse-drawn vehicles");
			meanings.add("taxis");
			theWords.put(key, meanings);

			key = "cabaret";
			meanings = new ArrayList <String>();
			meanings.add("entertainment");
			theWords.put(key, meanings);

			key = "cable";
			meanings = new ArrayList <String>();
			meanings.add("wire");
			theWords.put(key, meanings);

			key = "cad";
			meanings = new ArrayList <String>();
			meanings.add("rotter");
			theWords.put(key, meanings);

			key = "cadet";
			meanings = new ArrayList <String>();
			meanings.add("trainee soldier");
			theWords.put(key, meanings);

			key = "cadets";
			meanings = new ArrayList <String>();
			meanings.add("trainee soldiers");
			theWords.put(key, meanings);

			key = "cafe";
			meanings = new ArrayList <String>();
			meanings.add("snack bar");
			theWords.put(key, meanings);

			key = "caff";
			meanings = new ArrayList <String>();
			meanings.add("eatery");
			theWords.put(key, meanings);

			key = "cafeteria";
			meanings = new ArrayList <String>();
			meanings.add("self-service restaurant");
			theWords.put(key, meanings);

			key = "cages";
			meanings = new ArrayList <String>();
			meanings.add("pens");
			theWords.put(key, meanings);

			key = "cain";
			meanings = new ArrayList <String>();
			meanings.add("old murderer");
			theWords.put(key, meanings);

			key = "cake";
			meanings = new ArrayList <String>();
			meanings.add("coat");
			meanings.add("cover");
			theWords.put(key, meanings);

			key = "calais";
			meanings = new ArrayList <String>();
			meanings.add("port");
			theWords.put(key, meanings);

			key = "calf";
			meanings = new ArrayList <String>();
			meanings.add("part of leg");
			theWords.put(key, meanings);

			key = "california";
			meanings = new ArrayList <String>();
			meanings.add("American state");
			meanings.add("state");
			theWords.put(key, meanings);

			key = "callow";
			meanings = new ArrayList <String>();
			meanings.add("immature");
			theWords.put(key, meanings);

			key = "calm";
			meanings = new ArrayList <String>();
			meanings.add("serene");
			theWords.put(key, meanings);

			key = "calms";
			meanings = new ArrayList <String>();
			meanings.add("quietens");
			theWords.put(key, meanings);

			key = "cam";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);

			key = "came";
			meanings = new ArrayList <String>();
			meanings.add("arrived");
			meanings.add("turned up");
			theWords.put(key, meanings);

			key = "camel";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);

			key = "camelot";
			meanings = new ArrayList <String>();
			meanings.add("legendary city");
			theWords.put(key, meanings);

			key = "cameo";
			meanings = new ArrayList <String>();
			meanings.add("brooch");
			theWords.put(key, meanings);

			key = "campsite";
			meanings = new ArrayList <String>();
			meanings.add("holiday area");
			theWords.put(key, meanings);

			key = "can";
			meanings = new ArrayList <String>();
			meanings.add("are able to");
			meanings.add("container");
			meanings.add("is able to");
			meanings.add("preserve");
			meanings.add("prison");
			meanings.add("tin");
			theWords.put(key, meanings);

			key = "canary";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);

			key = "canberra";
			meanings = new ArrayList <String>();
			meanings.add("city down under");
			theWords.put(key, meanings);

			key = "cane";
			meanings = new ArrayList <String>();
			meanings.add("stick");
			theWords.put(key, meanings);

			key = "canes";
			meanings = new ArrayList <String>();
			meanings.add("sticks");
			theWords.put(key, meanings);

			key = "cannot";
			meanings = new ArrayList <String>();
			meanings.add("not able to");
			theWords.put(key, meanings);

			key = "canoe";
			meanings = new ArrayList <String>();
			meanings.add("boat");
			theWords.put(key, meanings);

			key = "canoes";
			meanings = new ArrayList <String>();
			meanings.add("boats");
			theWords.put(key, meanings);

			key = "canon";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);

			key = "cans";
			meanings = new ArrayList <String>();
			meanings.add("containers");
			meanings.add("preserves");
			meanings.add("tins");
			theWords.put(key, meanings);

			key = "cap";
			meanings = new ArrayList <String>();
			meanings.add("cover");
			meanings.add("hat");
			meanings.add("limit");
			meanings.add("top");
			theWords.put(key, meanings);

			key = "capes";
			meanings = new ArrayList <String>();
			meanings.add("garments");
			theWords.put(key, meanings);

			key = "captain";
			meanings = new ArrayList <String>();
			meanings.add("officer");
			theWords.put(key, meanings);

			key = "captive";
			meanings = new ArrayList <String>();
			meanings.add("prisoner");
			theWords.put(key, meanings);

			key = "car";
			meanings = new ArrayList <String>();
			meanings.add("vehicle");
			theWords.put(key, meanings);

			key = "caramel";
			meanings = new ArrayList <String>();
			meanings.add("chewy sweet");
			theWords.put(key, meanings);

			key = "cardigan";
			meanings = new ArrayList <String>();
			meanings.add("knitted jacket");
			theWords.put(key, meanings);

			key = "care";
			meanings = new ArrayList <String>();
			meanings.add("look after");
			theWords.put(key, meanings);

			key = "cared";
			meanings = new ArrayList <String>();
			meanings.add("looked after");
			theWords.put(key, meanings);

			key = "carefree";
			meanings = new ArrayList <String>();
			meanings.add("without worries");
			theWords.put(key, meanings);

			key = "carer";
			meanings = new ArrayList <String>();
			meanings.add("one who looks after things");
			theWords.put(key, meanings);

			key = "cares";
			meanings = new ArrayList <String>();
			meanings.add("is worried");
			theWords.put(key, meanings);

			key = "caress";
			meanings = new ArrayList <String>();
			meanings.add("gentle touch");
			meanings.add("stroke");
			theWords.put(key, meanings);

			key = "careworn";
			meanings = new ArrayList <String>();
			meanings.add("showing signs of stress");
			theWords.put(key, meanings);

			key = "carmel";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);

			key = "carnivore";
			meanings = new ArrayList <String>();
			meanings.add("meat eater");
			theWords.put(key, meanings);
			
			key = "carol";
			meanings = new ArrayList <String>();
			meanings.add("Christmas song");
			meanings.add("girl");
			theWords.put(key, meanings);

			key = "carousel";
			meanings = new ArrayList <String>();
			meanings.add("roundabout");
			theWords.put(key, meanings);

			key = "carp";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);

			key = "carpenter";
			meanings = new ArrayList <String>();
			meanings.add("chippy");
			theWords.put(key, meanings);

			key = "carpet";
			meanings = new ArrayList <String>();
			meanings.add("floor covering");
			theWords.put(key, meanings);

			key = "carpets";
			meanings = new ArrayList <String>();
			meanings.add("floor coverings");
			theWords.put(key, meanings);

			key = "carrie";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "carried";
			meanings = new ArrayList <String>();
			meanings.add("transported");
			theWords.put(key, meanings);

			key = "cars";
			meanings = new ArrayList <String>();
			meanings.add("vehicles");
			theWords.put(key, meanings);

			key = "cart";
			meanings = new ArrayList <String>();
			meanings.add("wagon");
			theWords.put(key, meanings);

			key = "cartel";
			meanings = new ArrayList <String>();
			meanings.add("business association");
			theWords.put(key, meanings);

			key = "carve";
			meanings = new ArrayList <String>();
			meanings.add("cut");
			theWords.put(key, meanings);

			key = "case";
			meanings = new ArrayList <String>();
			meanings.add("legal action");
			theWords.put(key, meanings);

			key = "cash";
			meanings = new ArrayList <String>();
			meanings.add("money");
			theWords.put(key, meanings);

			key = "cashews";
			meanings = new ArrayList <String>();
			meanings.add("nuts");
			theWords.put(key, meanings);

			key = "cashmere";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);

			key = "casing";
			meanings = new ArrayList <String>();
			meanings.add("cover");
			theWords.put(key, meanings);

			key = "cassoulet";
			meanings = new ArrayList <String>();
			meanings.add("French stew");
			theWords.put(key, meanings);

			key = "cast";
			meanings = new ArrayList <String>();
			meanings.add("actors");
			meanings.add("players");
			theWords.put(key, meanings);

			key = "castaway";
			meanings = new ArrayList <String>();
			meanings.add("stranded person");
			theWords.put(key, meanings);

			key = "castoff"; //cast off
			meanings = new ArrayList <String>();
			meanings.add("begin a voyage");
			theWords.put(key, meanings);

			key = "castro";
			meanings = new ArrayList <String>();
			meanings.add("former Cuban leader");
			theWords.put(key, meanings);

			key = "casual";
			meanings = new ArrayList <String>();
			meanings.add("nochalant");
			meanings.add("type of labour");
			theWords.put(key, meanings);

			key = "cat";
			meanings = new ArrayList <String>();
			meanings.add("beast");
			meanings.add("pet");
			meanings.add("tiger");
			theWords.put(key, meanings);

			key = "cathedral";
			meanings = new ArrayList <String>();
			meanings.add("principal church of a diocese");
			theWords.put(key, meanings);

			key = "cats";
			meanings = new ArrayList <String>();
			meanings.add("felines");
			meanings.add("pets");
			theWords.put(key, meanings);

			key = "cater";
			meanings = new ArrayList <String>();
			meanings.add("provide food");
			theWords.put(key, meanings);
			
			key = "catwalk";
			meanings = new ArrayList <String>();
			meanings.add("narrow walkway");
			meanings.add("American runway");
			theWords.put(key, meanings);

			key = "cave";
			meanings = new ArrayList <String>();
			meanings.add("grotto");
			theWords.put(key, meanings);

			key = "caw";
			meanings = new ArrayList <String>();
			meanings.add("bird cry");
			meanings.add("cry");
			theWords.put(key, meanings);

			key = "ceasing";
			meanings = new ArrayList <String>();
			meanings.add("stopping");
			theWords.put(key, meanings);

			key = "ceaser";
			meanings = new ArrayList <String>();
			meanings.add("conqueror of Gaul");
			theWords.put(key, meanings);

			key = "cedar";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			theWords.put(key, meanings);

			key = "celeriac";
			meanings = new ArrayList <String>();
			meanings.add("vegetable");
			theWords.put(key, meanings);

			key = "cellist";
			meanings = new ArrayList <String>();
			meanings.add("musician");
			theWords.put(key, meanings);

			key = "census";
			meanings = new ArrayList <String>();
			meanings.add("official survey");
			theWords.put(key, meanings);

			key = "cent";
			meanings = new ArrayList <String>();
			meanings.add("currency");
			meanings.add("money");
			theWords.put(key, meanings);

			key = "certain";
			meanings = new ArrayList <String>();
			meanings.add("sure");
			meanings.add("without doubt");
			theWords.put(key, meanings);

			key = "cha";
			meanings = new ArrayList <String>();
			meanings.add("tea");
			theWords.put(key, meanings);

			key = "chaff";
			meanings = new ArrayList <String>();
			meanings.add("rubbish");
			theWords.put(key, meanings);

			key = "chain";
			meanings = new ArrayList <String>();
			meanings.add("a series of related events");
			meanings.add("string of islands");
			meanings.add("type of stitch");
			theWords.put(key, meanings);

			key = "chained";
			meanings = new ArrayList <String>();
			meanings.add("shackled");
			theWords.put(key, meanings);

			key = "chair";
			meanings = new ArrayList <String>();
			meanings.add("presdie over");
			meanings.add("seat");
			theWords.put(key, meanings);

			key = "chairman";
			meanings = new ArrayList <String>();
			meanings.add("presiding officer");
			theWords.put(key, meanings);

			key = "chalet";
			meanings = new ArrayList <String>();
			meanings.add("holiday home");
			meanings.add("wooden house");
			theWords.put(key, meanings);

			key = "chameleon";
			meanings = new ArrayList <String>();
			meanings.add("lizard");
			theWords.put(key, meanings);

			key = "chance";
			meanings = new ArrayList <String>();
			meanings.add("likelihood");
			theWords.put(key, meanings);

			key = "chancel";
			meanings = new ArrayList <String>();
			meanings.add("part of church");
			theWords.put(key, meanings);

			key = "chant";
			meanings = new ArrayList <String>();
			meanings.add("sing");
			theWords.put(key, meanings);

			key = "chap";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);

			key = "char";
			meanings = new ArrayList <String>();
			meanings.add("cleaning lady");
			meanings.add("scorch");
			theWords.put(key, meanings);

			key = "charles";
			meanings = new ArrayList <String>();
			meanings.add("prince");
			theWords.put(key, meanings);

			key = "charleston";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);

			key = "charm";
			meanings = new ArrayList <String>();
			meanings.add("appeal");
			meanings.add("spell");
			theWords.put(key, meanings);

			key = "charming";
			meanings = new ArrayList <String>();
			meanings.add("delightful");
			meanings.add("prince");
			theWords.put(key, meanings);

			key = "chart";
			meanings = new ArrayList <String>();
			meanings.add("map");
			theWords.put(key, meanings);

			key = "charts";
			meanings = new ArrayList <String>();
			meanings.add("maps");
			meanings.add("plans");
			theWords.put(key, meanings);

			key = "charlotte";
			meanings = new ArrayList <String>();
			meanings.add("pudding");
			theWords.put(key, meanings);

			key = "charm";
			meanings = new ArrayList <String>();
			meanings.add("attraction");
			theWords.put(key, meanings);

			key = "chase";
			meanings = new ArrayList <String>();
			meanings.add("pursuit");
			theWords.put(key, meanings);

			key = "chat";
			meanings = new ArrayList <String>();
			meanings.add("talk");
			theWords.put(key, meanings);

			key = "cheap";
			meanings = new ArrayList <String>();
			meanings.add("vulgar");
			theWords.put(key, meanings);

			key = "chef";
			meanings = new ArrayList <String>();
			meanings.add("cook");
			theWords.put(key, meanings);

			key = "chelsea";
			meanings = new ArrayList <String>();
			meanings.add("part of London");
			theWords.put(key, meanings);

			key = "chess";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);

			key = "chest";
			meanings = new ArrayList <String>();
			meanings.add("box");
			theWords.put(key, meanings);

			key = "chesty";
			meanings = new ArrayList <String>();
			meanings.add("coughhing a lot");
			theWords.put(key, meanings);

			key = "chestnut";
			meanings = new ArrayList <String>();
			meanings.add("old joke");
			theWords.put(key, meanings);

			key = "cher";
			meanings = new ArrayList <String>();
			meanings.add("US singer");
			theWords.put(key, meanings);

			key = "cheroots";
			meanings = new ArrayList <String>();
			meanings.add("cigar");
			theWords.put(key, meanings);

			key = "cherry";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);

			key = "chew";
			meanings = new ArrayList <String>();
			meanings.add("munch");
			theWords.put(key, meanings);

			key = "chi";
			meanings = new ArrayList <String>();
			meanings.add("Greek character");
			theWords.put(key, meanings);

			key = "chianti";
			meanings = new ArrayList <String>();
			meanings.add("Italian wine");
			theWords.put(key, meanings);

			key = "chic";
			meanings = new ArrayList <String>();
			meanings.add("stylish");
			theWords.put(key, meanings);

			key = "chick";
			meanings = new ArrayList <String>();
			meanings.add("little bird");
			theWords.put(key, meanings);

			key = "chief";
			meanings = new ArrayList <String>();
			meanings.add("leader");
			meanings.add("uppermost");
			theWords.put(key, meanings);
			
			key = "chihuahua";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);

			key = "chin";
			meanings = new ArrayList <String>();
			meanings.add("feature");
			meanings.add("prominent feature");
			theWords.put(key, meanings);

			key = "china";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);

			key = "choir";
			meanings = new ArrayList <String>();
			meanings.add("group of singers");
			theWords.put(key, meanings);

			key = "choked";
			meanings = new ArrayList <String>();
			meanings.add("throttled");
			theWords.put(key, meanings);

			key = "chop";
			meanings = new ArrayList <String>();
			meanings.add("piece of meat");
			theWords.put(key, meanings);

			key = "chopin";
			meanings = new ArrayList <String>();
			meanings.add("composer");
			theWords.put(key, meanings);
			
			key = "chopping";
			meanings = new ArrayList <String>();
			meanings.add("cutting");
			theWords.put(key, meanings);

			key = "choral";
			meanings = new ArrayList <String>();
			meanings.add("for a choir");
			theWords.put(key, meanings);

			key = "chore";
			meanings = new ArrayList <String>();
			meanings.add("task");
			theWords.put(key, meanings);

			key = "chosen";
			meanings = new ArrayList <String>();
			meanings.add("selected");
			theWords.put(key, meanings);

			key = "chronic";
			meanings = new ArrayList <String>();
			meanings.add("very bad");
			theWords.put(key, meanings);

			key = "chronicle";
			meanings = new ArrayList <String>();
			meanings.add("record");
			theWords.put(key, meanings);

			key = "chum";
			meanings = new ArrayList <String>();
			meanings.add("friend");
			theWords.put(key, meanings);

			key = "chump";
			meanings = new ArrayList <String>();
			meanings.add("fool");
			theWords.put(key, meanings);

			key = "church";
			meanings = new ArrayList <String>();
			meanings.add("place of worship");
			theWords.put(key, meanings);

			key = "cid";
			meanings = new ArrayList <String>();
			meanings.add("detectives");
			theWords.put(key, meanings);

			key = "cider";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);

			key = "cigar";
			meanings = new ArrayList <String>();
			meanings.add("cylindrical roll of cured tobacco leaves");
			theWords.put(key, meanings);

			key = "cilla";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);

			key = "cinema";
			meanings = new ArrayList <String>();
			meanings.add("flicks");
			theWords.put(key, meanings);

			key = "circle";
			meanings = new ArrayList <String>();
			meanings.add("group of friends");
			meanings.add("shape");
			theWords.put(key, meanings);

			key = "circular";
			meanings = new ArrayList <String>();
			meanings.add("round");
			theWords.put(key, meanings);

			key = "citadel";
			meanings = new ArrayList <String>();
			meanings.add("fortress");
			theWords.put(key, meanings);

			key = "cite";
			meanings = new ArrayList <String>();
			meanings.add("quote");
			theWords.put(key, meanings);

			key = "city";
			meanings = new ArrayList <String>();
			meanings.add("big town");
			theWords.put(key, meanings);

			key = "clad";
			meanings = new ArrayList <String>();
			meanings.add("clothed");
			theWords.put(key, meanings);

			key = "claim";
			meanings = new ArrayList <String>();
			meanings.add("demand");
			theWords.put(key, meanings);

			key = "clan";
			meanings = new ArrayList <String>();
			meanings.add("family");
			meanings.add("family group");
			meanings.add("group");
			meanings.add("tribe");
			theWords.put(key, meanings);

			key = "clang";
			meanings = new ArrayList <String>();
			meanings.add("sound");
			theWords.put(key, meanings);

			key = "clare";
			meanings = new ArrayList <String>();
			meanings.add("Irish county");
			meanings.add("woman");
			theWords.put(key, meanings);

			key = "claret";
			meanings = new ArrayList <String>();
			meanings.add("wine");
			theWords.put(key, meanings);

			key = "clashes";
			meanings = new ArrayList <String>();
			meanings.add("conflicts");
			theWords.put(key, meanings);

			key = "class";
			meanings = new ArrayList <String>();
			meanings.add("form");
			meanings.add("group of pupils");
			theWords.put(key, meanings);

			key = "classical";
			meanings = new ArrayList <String>();
			meanings.add("traditional");
			theWords.put(key, meanings);

			key = "clay";
			meanings = new ArrayList <String>();
			meanings.add("soil");
			theWords.put(key, meanings);

			key = "clearing";
			meanings = new ArrayList <String>();
			meanings.add("glade");
			theWords.put(key, meanings);

			key = "clean";
			meanings = new ArrayList <String>();
			meanings.add("pure");
			theWords.put(key, meanings);

			key = "cleanse";
			meanings = new ArrayList <String>();
			meanings.add("free from impurities");
			theWords.put(key, meanings);

			key = "cleft";
			meanings = new ArrayList <String>();
			meanings.add("split");
			theWords.put(key, meanings);
			
			key = "clematis";
			meanings = new ArrayList <String>();
			meanings.add("climbing plant");
			theWords.put(key, meanings);

			key = "clemency";
			meanings = new ArrayList <String>();
			meanings.add("mercy");
			theWords.put(key, meanings);

			key = "cleric";
			meanings = new ArrayList <String>();
			meanings.add("religious leader");
			theWords.put(key, meanings);

			key = "clever";
			meanings = new ArrayList <String>();
			meanings.add("bright");
			theWords.put(key, meanings);

			key = "cleverly";
			meanings = new ArrayList <String>();
			meanings.add("smartly");
			theWords.put(key, meanings);

			key = "climate";
			meanings = new ArrayList <String>();
			meanings.add("conditions");
			theWords.put(key, meanings);

			key = "climates";
			meanings = new ArrayList <String>();
			meanings.add("conditions");
			theWords.put(key, meanings);

			key = "climb";
			meanings = new ArrayList <String>();
			meanings.add("ascent");
			theWords.put(key, meanings);

			key = "climbs";
			meanings = new ArrayList <String>();
			meanings.add("uphill struggles");
			theWords.put(key, meanings);

			key = "cling";
			meanings = new ArrayList <String>();
			meanings.add("hold on");
			theWords.put(key, meanings);

			key = "cloak";
			meanings = new ArrayList <String>();
			meanings.add("mask");
			theWords.put(key, meanings);

			key = "clodhoppers";
			meanings = new ArrayList <String>();
			meanings.add("fools");
			theWords.put(key, meanings);

			key = "cloister";
			meanings = new ArrayList <String>();
			meanings.add("shelter for brothers");
			theWords.put(key, meanings);

			key = "clone";
			meanings = new ArrayList <String>();
			meanings.add("replica");
			theWords.put(key, meanings);

			key = "close";
			meanings = new ArrayList <String>();
			meanings.add("shut");
			theWords.put(key, meanings);

			key = "closed";
			meanings = new ArrayList <String>();
			meanings.add("shut");
			theWords.put(key, meanings);

			key = "closet";
			meanings = new ArrayList <String>();
			meanings.add("cupboard");
			theWords.put(key, meanings);

			key = "clot";
			meanings = new ArrayList <String>();
			meanings.add("fool");
			theWords.put(key, meanings);

			key = "clothe";
			meanings = new ArrayList <String>();
			meanings.add("dress");
			theWords.put(key, meanings);

			key = "clouts";
			meanings = new ArrayList <String>();
			meanings.add("hits");
			theWords.put(key, meanings);

			key = "clover";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);

			key = "cloves";
			meanings = new ArrayList <String>();
			meanings.add("flowers");
			theWords.put(key, meanings);

			key = "clue";
			meanings = new ArrayList <String>();
			meanings.add("hint");
			meanings.add("lead");
			theWords.put(key, meanings);

			key = "cluster";
			meanings = new ArrayList <String>();
			meanings.add("group");
			theWords.put(key, meanings);

			key = "coarsest";
			meanings = new ArrayList <String>();
			meanings.add("roughest");
			theWords.put(key, meanings);

			key = "coat";
			meanings = new ArrayList <String>();
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "cobbler";
			meanings = new ArrayList <String>();
			meanings.add("shoe mender");
			theWords.put(key, meanings);

			key = "coco";
			meanings = new ArrayList <String>();
			meanings.add("clown");
			theWords.put(key, meanings);

			key = "cocoa";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);

			key = "cod";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			meanings.add("swimmer");
			theWords.put(key, meanings);

			key = "code";
			meanings = new ArrayList <String>();
			meanings.add("cryptic signal");
			meanings.add("morse, perhaps");
			theWords.put(key, meanings);

			key = "coe";
			meanings = new ArrayList <String>();
			meanings.add("games organiser");
			meanings.add("Lord");
			theWords.put(key, meanings);

			key = "coffee";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);

			key = "coffer";
			meanings = new ArrayList <String>();
			meanings.add("chest");
			theWords.put(key, meanings);

			key = "cog";
			meanings = new ArrayList <String>();
			meanings.add("gearwheel");
			theWords.put(key, meanings);

			key = "coins";
			meanings = new ArrayList <String>();
			meanings.add("change");
			theWords.put(key, meanings);

			key = "cola";
			meanings = new ArrayList <String>();
			meanings.add("soft drink");
			theWords.put(key, meanings);

			key = "collapse";
			meanings = new ArrayList <String>();
			meanings.add("fail");
			meanings.add("sudden failure");
			theWords.put(key, meanings);

			key = "collie";
			meanings = new ArrayList <String>();
			meanings.add("sheepdog");
			theWords.put(key, meanings);
			
			key = "collier";
			meanings = new ArrayList <String>();
			meanings.add("mine worker");
			theWords.put(key, meanings);
			
			key = "colt";
			meanings = new ArrayList <String>();
			meanings.add("gun");
			theWords.put(key, meanings);

			key = "combat";
			meanings = new ArrayList <String>();
			meanings.add("battle");
			theWords.put(key, meanings);

			key = "combine";
			meanings = new ArrayList <String>();
			meanings.add("join together");
			theWords.put(key, meanings);

			key = "come";
			meanings = new ArrayList <String>();
			meanings.add("arrive");
			theWords.put(key, meanings);

			key = "comets";
			meanings = new ArrayList <String>();
			meanings.add("bright visitors");
			theWords.put(key, meanings);

			key = "comic";
			meanings = new ArrayList <String>();
			meanings.add("kind of strip");
			theWords.put(key, meanings);

			key = "commute";
			meanings = new ArrayList <String>();
			meanings.add("journey to work");
			theWords.put(key, meanings);
			
			key = "como";
			meanings = new ArrayList <String>();
			meanings.add("Italian lake");
			theWords.put(key, meanings);

			key = "compact";
			meanings = new ArrayList <String>();
			meanings.add("concise");
			meanings.add("cosmetic case");
			theWords.put(key, meanings);

			key = "computers";
			meanings = new ArrayList <String>();
			meanings.add("calculators");
			theWords.put(key, meanings);

			key = "con";
			meanings = new ArrayList <String>();
			meanings.add("prisoner");
			meanings.add("study");
			theWords.put(key, meanings);

			key = "cone";
			meanings = new ArrayList <String>();
			meanings.add("shape");
			theWords.put(key, meanings);

			key = "confined";
			meanings = new ArrayList <String>();
			meanings.add("restricted");
			theWords.put(key, meanings);

			key = "considerable";
			meanings = new ArrayList <String>();
			meanings.add("sizeable");
			theWords.put(key, meanings);

			key = "container";
			meanings = new ArrayList <String>();
			meanings.add("receptacle");
			theWords.put(key, meanings);

			key = "concern";
			meanings = new ArrayList <String>();
			meanings.add("business");
			meanings.add("trouble");
			theWords.put(key, meanings);

			key = "concur";
			meanings = new ArrayList <String>();
			meanings.add("see eye-to-eye");
			theWords.put(key, meanings);

			key = "content";
			meanings = new ArrayList <String>();
			meanings.add("satisfied");
			meanings.add("what's inside");
			theWords.put(key, meanings);

			key = "contest";
			meanings = new ArrayList <String>();
			meanings.add("competition");
			theWords.put(key, meanings);

			key = "controversial";
			meanings = new ArrayList <String>();
			meanings.add("disputed");
			theWords.put(key, meanings);

			key = "cook";
			meanings = new ArrayList <String>();
			meanings.add("stew");
			theWords.put(key, meanings);

			key = "cooker";
			meanings = new ArrayList <String>();
			meanings.add("kitchen appliance");
			theWords.put(key, meanings);

			key = "cool";
			meanings = new ArrayList <String>();
			meanings.add("unenthusiastic");
			theWords.put(key, meanings);

			key = "cooler";
			meanings = new ArrayList <String>();
			meanings.add("not as hot");
			theWords.put(key, meanings);

			key = "coot";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);

			key = "cop";
			meanings = new ArrayList <String>();
			meanings.add("police officer");
			theWords.put(key, meanings);

			key = "cope";
			meanings = new ArrayList <String>();
			meanings.add("manage");
			theWords.put(key, meanings);

			key = "coping";
			meanings = new ArrayList <String>();
			meanings.add("managing");
			theWords.put(key, meanings);

			key = "copper";
			meanings = new ArrayList <String>();
			meanings.add("metal");
			meanings.add("policeman");
			theWords.put(key, meanings);

			key = "coppers";
			meanings = new ArrayList <String>();
			meanings.add("police");
			theWords.put(key, meanings);

			key = "copse";
			meanings = new ArrayList <String>();
			meanings.add("wood");
			theWords.put(key, meanings);

			key = "copy";
			meanings = new ArrayList <String>();
			meanings.add("imitate");
			theWords.put(key, meanings);

			key = "core";
			meanings = new ArrayList <String>();
			meanings.add("heart");
			theWords.put(key, meanings);

			key = "cores";
			meanings = new ArrayList <String>();
			meanings.add("kernels");
			theWords.put(key, meanings);

			key = "coriander";
			meanings = new ArrayList <String>();
			meanings.add("herb");
			theWords.put(key, meanings);

			key = "correct";
			meanings = new ArrayList <String>();
			meanings.add("right");
			theWords.put(key, meanings);

			key = "cosmic";
			meanings = new ArrayList <String>();
			meanings.add("universal");
			theWords.put(key, meanings);

			key = "cost";
			meanings = new ArrayList <String>();
			meanings.add("price");
			theWords.put(key, meanings);

			key = "costlier";
			meanings = new ArrayList <String>();
			meanings.add("more expensive");
			theWords.put(key, meanings);

			key = "costs";
			meanings = new ArrayList <String>();
			meanings.add("prices");
			theWords.put(key, meanings);

			key = "costume";
			meanings = new ArrayList <String>();
			meanings.add("set of clothes");
			theWords.put(key, meanings);

			key = "cot";
			meanings = new ArrayList <String>();
			meanings.add("bed");
			meanings.add("small bed");
			theWords.put(key, meanings);

			key = "cotter";
			meanings = new ArrayList <String>();
			meanings.add("Highland farmer");
			meanings.add("type of pin");
			theWords.put(key, meanings);

			key = "count";
			meanings = new ArrayList <String>();
			meanings.add("continental nobleman");
			meanings.add("sum up");
			theWords.put(key, meanings);

			key = "counts";
			meanings = new ArrayList <String>();
			meanings.add("matters");
			meanings.add("nobleman");
			theWords.put(key, meanings);

			key = "coventry";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);

			key = "cover";
			meanings = new ArrayList <String>();
			meanings.add("shade");
			theWords.put(key, meanings);

			key = "cow";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("beast");
			theWords.put(key, meanings);

			key = "cowed";
			meanings = new ArrayList <String>();
			meanings.add("intimidated");
			theWords.put(key, meanings);

			key = "cowl";
			meanings = new ArrayList <String>();
			meanings.add("hood");
			meanings.add("head covering");
			theWords.put(key, meanings);

			key = "coy";
			meanings = new ArrayList <String>();
			meanings.add("shy");
			theWords.put(key, meanings);

			key = "coyote";
			meanings = new ArrayList <String>();
			meanings.add("wild dog");
			theWords.put(key, meanings);

			key = "crab";
			meanings = new ArrayList <String>();
			meanings.add("move sideways");
			theWords.put(key, meanings);

			key = "crabby";
			meanings = new ArrayList <String>();
			meanings.add("irrascible");
			meanings.add("like a crustacean");
			theWords.put(key, meanings);

			key = "crane";
			meanings = new ArrayList <String>();
			meanings.add("lifting machine");
			theWords.put(key, meanings);

			key = "cranks";
			meanings = new ArrayList <String>();
			meanings.add("eccentrics");
			theWords.put(key, meanings);

			key = "crate";
			meanings = new ArrayList <String>();
			meanings.add("slatted wooden case");
			meanings.add("pack");
			theWords.put(key, meanings);

			key = "crack";
			meanings = new ArrayList <String>();
			meanings.add("break");
			theWords.put(key, meanings);

			key = "crackers";
			meanings = new ArrayList <String>();
			meanings.add("dry biscuits");
			meanings.add("nuts");
			theWords.put(key, meanings);

			key = "crackpot";
			meanings = new ArrayList <String>();
			meanings.add("eccentric person");
			theWords.put(key, meanings);

			key = "crayon";
			meanings = new ArrayList <String>();
			meanings.add("coloured pencil");
			meanings.add("pencil");
			theWords.put(key, meanings);

			key = "cream";
			meanings = new ArrayList <String>();
			meanings.add("elite");
			theWords.put(key, meanings);

			key = "crease";
			meanings = new ArrayList <String>();
			meanings.add("fold");
			theWords.put(key, meanings);

			key = "create";
			meanings = new ArrayList <String>();
			meanings.add("make");
			theWords.put(key, meanings);

			key = "creek";
			meanings = new ArrayList <String>();
			meanings.add("inlet");
			theWords.put(key, meanings);

			key = "crept";
			meanings = new ArrayList <String>();
			meanings.add("moved stealthily");
			theWords.put(key, meanings);

			key = "cretans";
			meanings = new ArrayList <String>();
			meanings.add("islanders");
			theWords.put(key, meanings);
			
			key = "crete";
			meanings = new ArrayList <String>();
			meanings.add("Greek island");
			theWords.put(key, meanings);

			key = "crib";
			meanings = new ArrayList <String>();
			meanings.add("baby's bed");
			meanings.add("cheat");
			meanings.add("copy");
			theWords.put(key, meanings);

			key = "crime";
			meanings = new ArrayList <String>();
			meanings.add("illegal goings on");
			theWords.put(key, meanings);

			key = "crimea";
			meanings = new ArrayList <String>();
			meanings.add("peninsula");
			theWords.put(key, meanings);

			key = "crimson";
			meanings = new ArrayList <String>();
			meanings.add("deep red");
			theWords.put(key, meanings);

			key = "cringe";
			meanings = new ArrayList <String>();
			meanings.add("cower");
			theWords.put(key, meanings);

			key = "crop";
			meanings = new ArrayList <String>();
			meanings.add("cut short");
			meanings.add("rider's whip");
			theWords.put(key, meanings);

			key = "cross";
			meanings = new ArrayList <String>();
			meanings.add("annoyed");
			meanings.add("traverse");
			theWords.put(key, meanings);

			key = "crossbow";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);

			key = "crow";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);

			key = "crumb";
			meanings = new ArrayList <String>();
			meanings.add("small piece");
			theWords.put(key, meanings);

			key = "crude";
			meanings = new ArrayList <String>();
			meanings.add("unrefined");
			theWords.put(key, meanings);

			key = "cub";
			meanings = new ArrayList <String>();
			meanings.add("young animal");
			theWords.put(key, meanings);

			key = "cuba";
			meanings = new ArrayList <String>();
			meanings.add("island");
			theWords.put(key, meanings);

			key = "cuban";
			meanings = new ArrayList <String>();
			meanings.add("islander?");
			theWords.put(key, meanings);

			key = "cubans";
			meanings = new ArrayList <String>();
			meanings.add("islanders");
			theWords.put(key, meanings);

			key = "cubit";
			meanings = new ArrayList <String>();
			meanings.add("measure");
			theWords.put(key, meanings);

			key = "cue";
			meanings = new ArrayList <String>();
			meanings.add("prompt");
			meanings.add("stick");
			theWords.put(key, meanings);

			key = "cumbria";
			meanings = new ArrayList <String>();
			meanings.add("county");
			theWords.put(key, meanings);

			key = "cup";
			meanings = new ArrayList <String>();
			meanings.add("competition");
			meanings.add("vessel");
			theWords.put(key, meanings);

			key = "cupid";
			meanings = new ArrayList <String>();
			meanings.add("deity");
			theWords.put(key, meanings);

			key = "cupola";
			meanings = new ArrayList <String>();
			meanings.add("high ceiling");
			theWords.put(key, meanings);

			key = "cur";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			meanings.add("mongrel");
			theWords.put(key, meanings);

			key = "curate";
			meanings = new ArrayList <String>();
			meanings.add("priest");
			theWords.put(key, meanings);

			key = "cure";
			meanings = new ArrayList <String>();
			meanings.add("restore good health");
			meanings.add("a solution");
			meanings.add("preserve");
			meanings.add("remedy");
			theWords.put(key, meanings);

			key = "cured";
			meanings = new ArrayList <String>();
			meanings.add("made better");
			theWords.put(key, meanings);

			key = "curing";
			meanings = new ArrayList <String>();
			meanings.add("healing");
			theWords.put(key, meanings);

			key = "curl";
			meanings = new ArrayList <String>();
			meanings.add("piece of hair");
			meanings.add("weightlifting manoeuvre");
			meanings.add("bend");
			theWords.put(key, meanings);

			key = "curs";
			meanings = new ArrayList <String>();
			meanings.add("dogs");
			meanings.add("wretches");
			theWords.put(key, meanings);

			key = "curse";
			meanings = new ArrayList <String>();
			meanings.add("use bad language");
			theWords.put(key, meanings);

			key = "curt";
			meanings = new ArrayList <String>();
			meanings.add("terse");
			theWords.put(key, meanings);

			key = "custer";
			meanings = new ArrayList <String>();
			meanings.add("famous general");
			meanings.add("US general");
			theWords.put(key, meanings);

			key = "custom";
			meanings = new ArrayList <String>();
			meanings.add("convention");
			theWords.put(key, meanings);

			key = "customer";
			meanings = new ArrayList <String>();
			meanings.add("one who'se always right");
			theWords.put(key, meanings);

			key = "customers";
			meanings = new ArrayList <String>();
			meanings.add("shoppers");
			theWords.put(key, meanings);

			key = "cut";
			meanings = new ArrayList <String>();
			meanings.add("injured");
			meanings.add("reduced");
			meanings.add("removed");
			theWords.put(key, meanings);

			key = "cute";
			meanings = new ArrayList <String>();
			meanings.add("charming");
			theWords.put(key, meanings);

			key = "cutlass";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);

			key = "cutlet";
			meanings = new ArrayList <String>();
			meanings.add("portion of meat");
			theWords.put(key, meanings);

			key = "cuts";
			meanings = new ArrayList <String>();
			meanings.add("reductions");
			theWords.put(key, meanings);

			key = "cyan";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			theWords.put(key, meanings);

			key = "cycle";
			meanings = new ArrayList <String>();
			meanings.add("mode of transport");
			theWords.put(key, meanings);

			key = "cycles";
			meanings = new ArrayList <String>();
			meanings.add("goes by bike");
			theWords.put(key, meanings);

			key = "cyclones";
			meanings = new ArrayList <String>();
			meanings.add("strong winds");
			theWords.put(key, meanings);
			
			return theWords;

		}//end loadC
		
		public TreeMap<String, ArrayList<String>> loadDWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load d's
			key = "dad";
			meanings = new ArrayList <String>();
			meanings.add("father");
			meanings.add("parent");
			theWords.put(key, meanings);
			
			key = "dairy";
			meanings = new ArrayList <String>();
			meanings.add("milk factory");
			theWords.put(key, meanings);
			
			key = "daisy";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			theWords.put(key, meanings);
			
			key = "dale";
			meanings = new ArrayList <String>();
			meanings.add("valley");
			theWords.put(key, meanings);
			
			key = "dam";
			meanings = new ArrayList <String>();
			meanings.add("block");
			meanings.add("river barrier");
			theWords.put(key, meanings);
			
			key = "damask";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "dame";
			meanings = new ArrayList <String>();
			meanings.add("panto character");
			theWords.put(key, meanings);
			
			key = "damn";
			meanings = new ArrayList <String>();
			meanings.add("condemn");
			theWords.put(key, meanings);
			
			key = "damsel";
			meanings = new ArrayList <String>();
			meanings.add("young unmarried woman");
			theWords.put(key, meanings);
			
			key = "damson";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
					
			key = "dan";
			meanings = new ArrayList <String>();
			meanings.add("desperate man");
			theWords.put(key, meanings);
			
			key = "dance";
			meanings = new ArrayList <String>();
			meanings.add("bop");
			theWords.put(key, meanings);
			
			key = "dances";
			meanings = new ArrayList <String>();
			meanings.add("bops");
			theWords.put(key, meanings);
			
			key = "danes";
			meanings = new ArrayList <String>();
			meanings.add("Europeans");
			theWords.put(key, meanings);
			
			key = "danger";
			meanings = new ArrayList <String>();
			meanings.add("peril");
			theWords.put(key, meanings);
			
			key = "danish";
			meanings = new ArrayList <String>();
			meanings.add("european");
			theWords.put(key, meanings);
					
			key = "dare";
			meanings = new ArrayList <String>();
			meanings.add("challenge");
			theWords.put(key, meanings);
			
			key = "daring";
			meanings = new ArrayList <String>();
			meanings.add("adventurous");
			meanings.add("risky");
			theWords.put(key, meanings);
			
			key = "darken";
			meanings = new ArrayList <String>();
			meanings.add("cloud over");
			theWords.put(key, meanings);
					
			key = "dart";
			meanings = new ArrayList <String>();
			meanings.add("dash");
			theWords.put(key, meanings);
			
			key = "darts";
			meanings = new ArrayList <String>();
			meanings.add("game");
			meanings.add("races");
			theWords.put(key, meanings);

			key = "dashboard";
			meanings = new ArrayList <String>();
			meanings.add("part of car");
			theWords.put(key, meanings);
			
			key = "data";
			meanings = new ArrayList <String>();
			meanings.add("information");
			theWords.put(key, meanings);
			
			key = "date";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			meanings.add("time");
			theWords.put(key, meanings);
			
			key = "dates";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "day";
			meanings = new ArrayList <String>();
			meanings.add("24 hours");
			theWords.put(key, meanings);
			
			key = "deacons";
			meanings = new ArrayList <String>();
			meanings.add("clergymen");
			theWords.put(key, meanings);
			
			key = "dead";
			meanings = new ArrayList <String>();
			meanings.add("expired");
			theWords.put(key, meanings);
			
			key = "deadpan";
			meanings = new ArrayList <String>();
			meanings.add("without expression");
			theWords.put(key, meanings);
			
			key = "deaf";
			meanings = new ArrayList <String>();
			meanings.add("unable to hear");
			theWords.put(key, meanings);
			
			key = "deal";
			meanings = new ArrayList <String>();
			meanings.add("trade");
			meanings.add("transaction");
			theWords.put(key, meanings);
			
			key = "dealer";
			meanings = new ArrayList <String>();
			meanings.add("trader");
			theWords.put(key, meanings);
					
			key = "dear";
			meanings = new ArrayList <String>();
			meanings.add("regarded with deep affection");
			meanings.add("expensive");
			meanings.add("friendly form of address");
			theWords.put(key, meanings);
			
			key = "dears";
			meanings = new ArrayList <String>();
			meanings.add("darlings");
			theWords.put(key, meanings);
			
			key = "dearer";
			meanings = new ArrayList <String>();
			meanings.add("more expensive");
			meanings.add("pricier");
			theWords.put(key, meanings);
			
			key = "death";
			meanings = new ArrayList <String>();
			meanings.add("the end");
			theWords.put(key, meanings);
			
			key = "debate";
			meanings = new ArrayList <String>();
			meanings.add("discussion");
			theWords.put(key, meanings);
			
			key = "debt";
			meanings = new ArrayList <String>();
			meanings.add("arrears");
			theWords.put(key, meanings);
			
			key = "debut";
			meanings = new ArrayList <String>();
			meanings.add("first performance");
			theWords.put(key, meanings);
			
			key = "decamp";
			meanings = new ArrayList <String>();
			meanings.add("make off");
			theWords.put(key, meanings);
			
			key = "decanter";
			meanings = new ArrayList <String>();
			meanings.add("glass container");
			theWords.put(key, meanings);
			
			key = "december";
			meanings = new ArrayList <String>();
			meanings.add("last month");
			meanings.add("month");
			theWords.put(key, meanings);
			
			key = "decide";
			meanings = new ArrayList <String>();
			meanings.add("choose");
			theWords.put(key, meanings);
			
			key = "decided";
			meanings = new ArrayList <String>();
			meanings.add("resolute");
			theWords.put(key, meanings);
			
			key = "declare";
			meanings = new ArrayList <String>();
			meanings.add("state");
			theWords.put(key, meanings);
			
			key = "decline";
			meanings = new ArrayList <String>();
			meanings.add("drop off");
			meanings.add("refuse");
			meanings.add("say no to");
			theWords.put(key, meanings);
			
			key = "decode";
			meanings = new ArrayList <String>();
			meanings.add("crack the secret message");
			theWords.put(key, meanings);
			
			key = "decor";
			meanings = new ArrayList <String>();
			meanings.add("house style");
			theWords.put(key, meanings);
			
			key = "decorum";
			meanings = new ArrayList <String>();
			meanings.add("etiquette");
			theWords.put(key, meanings);
			
			key = "dee";
			meanings = new ArrayList <String>();
			meanings.add("river");
			meanings.add("scottish river");
			theWords.put(key, meanings);
			
			key = "deed";
			meanings = new ArrayList <String>();
			meanings.add("action");
			meanings.add("document");
			meanings.add("heroic act");
			meanings.add("legal document");
			theWords.put(key, meanings);
			
			key = "deep";
			meanings = new ArrayList <String>();
			meanings.add("profound");
			theWords.put(key, meanings);
			
			key = "deepens";
			meanings = new ArrayList <String>();
			meanings.add("becomes less shallow");
			theWords.put(key, meanings);
			
			key = "deeper";
			meanings = new ArrayList <String>();
			meanings.add("more profound");
			theWords.put(key, meanings);
			
			key = "defiance";
			meanings = new ArrayList <String>();
			meanings.add("bold disobediance");
			theWords.put(key, meanings);
			
			key = "defoe";
			meanings = new ArrayList <String>();
			meanings.add("writer");
			theWords.put(key, meanings);
			
			key = "degas";
			meanings = new ArrayList <String>();
			meanings.add("French impressionist");
			theWords.put(key, meanings);
			
			key = "dehydrate";
			meanings = new ArrayList <String>();
			meanings.add("dry out");
			theWords.put(key, meanings);
			
			key = "deli";
			meanings = new ArrayList <String>();
			meanings.add("small delicatessen");
			theWords.put(key, meanings);
			
			key = "delta";
			meanings = new ArrayList <String>();
			meanings.add("Greek letter");
			meanings.add("mouth");
			theWords.put(key, meanings);
			
			key = "demitasse";
			meanings = new ArrayList <String>();
			meanings.add("cup");
			theWords.put(key, meanings);
			
			key = "demo";
			meanings = new ArrayList <String>();
			meanings.add("protest");
			theWords.put(key, meanings);
			
			key = "demob";
			meanings = new ArrayList <String>();
			meanings.add("discharge from the army");
			theWords.put(key, meanings);
					
			key = "demolish";
			meanings = new ArrayList <String>();
			meanings.add("tear down");
			theWords.put(key, meanings);

			key = "demolished";
			meanings = new ArrayList <String>();
			meanings.add("totally ruined");
			theWords.put(key, meanings);
			
			key = "den";
			meanings = new ArrayList <String>();
			meanings.add("hideout");
			theWords.put(key, meanings);
			
			key = "denial";
			meanings = new ArrayList <String>();
			meanings.add("refusal");
			theWords.put(key, meanings);
			
			key = "denote";
			meanings = new ArrayList <String>();
			meanings.add("mark");
			theWords.put(key, meanings);
			
			key = "dent";
			meanings = new ArrayList <String>();
			meanings.add("depression");
			meanings.add("impact mark");
			theWords.put(key, meanings);
			
			key = "dentures";
			meanings = new ArrayList <String>();
			meanings.add("false teeth");
			theWords.put(key, meanings);
			
			key = "deplete";
			meanings = new ArrayList <String>();
			meanings.add("cut back");
			theWords.put(key, meanings);
			
			key = "deployed";
			meanings = new ArrayList <String>();
			meanings.add("brought into action");
			theWords.put(key, meanings);
			
			key = "deposit";
			meanings = new ArrayList <String>();
			meanings.add("money as security");
			meanings.add("put down");
			meanings.add("sediment");
			theWords.put(key, meanings);
			
			key = "depot";
			meanings = new ArrayList <String>();
			meanings.add("warehouse");
			theWords.put(key, meanings);
			
			key = "dept";
			meanings = new ArrayList <String>();
			meanings.add("small department");
			theWords.put(key, meanings);
			
			key = "deputy";
			meanings = new ArrayList <String>();
			meanings.add("second in command");
			theWords.put(key, meanings);
			
			key = "derided";
			meanings = new ArrayList <String>();
			meanings.add("mocked");
			theWords.put(key, meanings);
					
			key = "descent";
			meanings = new ArrayList <String>();
			meanings.add("downward movement");
			theWords.put(key, meanings);
			
			key = "desert";
			meanings = new ArrayList <String>();
			meanings.add("abandon");
			meanings.add("desolate area");
			meanings.add("sandy area");
			theWords.put(key, meanings);
			
			key = "deserts";
			meanings = new ArrayList <String>();
			meanings.add("abandons");
			theWords.put(key, meanings);
			
			key = "designer";
			meanings = new ArrayList <String>();
			meanings.add("architect");
			theWords.put(key, meanings);

			key = "desire";
			meanings = new ArrayList <String>();
			meanings.add("urge");
			theWords.put(key, meanings);

			key = "despair";
			meanings = new ArrayList <String>();
			meanings.add("give up hope");
			meanings.add("hopelessness");
			meanings.add("lose hope");
			theWords.put(key, meanings);
			
			key = "destroyed";
			meanings = new ArrayList <String>();
			meanings.add("demolished");
			theWords.put(key, meanings);
			
			key = "deter";
			meanings = new ArrayList <String>();
			meanings.add("discourage");
			theWords.put(key, meanings);
			
			key = "detest";
			meanings = new ArrayList <String>();
			meanings.add("dislike");
			theWords.put(key, meanings);

			key = "detrain";
			meanings = new ArrayList <String>();
			meanings.add("alight");
			theWords.put(key, meanings);
			
			key = "diagram";
			meanings = new ArrayList <String>();
			meanings.add("drawing");
			theWords.put(key, meanings);
			
			key = "diameter";
			meanings = new ArrayList <String>();
			meanings.add("width");
			theWords.put(key, meanings);
			
			key = "diamonds";
			meanings = new ArrayList <String>();
			meanings.add("suit");
			theWords.put(key, meanings);
			
			key = "diana";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "diapers";
			meanings = new ArrayList <String>();
			meanings.add("nappies");
			theWords.put(key, meanings);
			
			key = "diatribe";
			meanings = new ArrayList <String>();
			meanings.add("bitter attack");
			theWords.put(key, meanings);
			
			key = "dick";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "did";
			meanings = new ArrayList <String>();
			meanings.add("swindled");
			theWords.put(key, meanings);
			
			key = "dido";
			meanings = new ArrayList <String>();
			meanings.add("queen of Carthage");
			theWords.put(key, meanings);
			
			key = "diesel";
			meanings = new ArrayList <String>();
			meanings.add("fuel");
			theWords.put(key, meanings);
			
			key = "diet";
			meanings = new ArrayList <String>();
			meanings.add("regime");
			theWords.put(key, meanings);
			
			key = "diets";
			meanings = new ArrayList <String>();
			meanings.add("regimes");
			theWords.put(key, meanings);
					
			key = "digs";
			meanings = new ArrayList <String>();
			meanings.add("accommodation");
			theWords.put(key, meanings);
			
			key = "dignity";
			meanings = new ArrayList <String>();
			meanings.add("self respect");
			theWords.put(key, meanings);
			
			key = "dill";
			meanings = new ArrayList <String>();
			meanings.add("herb");
			theWords.put(key, meanings);
					
			key = "diluted";
			meanings = new ArrayList <String>();
			meanings.add("less concentration");
			theWords.put(key, meanings);
			
			key = "dime";
			meanings = new ArrayList <String>();
			meanings.add("foreign coin");
			theWords.put(key, meanings);
				
			key = "din";
			meanings = new ArrayList <String>();
			meanings.add("noise");
			meanings.add("racket");
			meanings.add("uproar");
			theWords.put(key, meanings);
			
			key = "dines";
			meanings = new ArrayList <String>();
			meanings.add("eats");
			theWords.put(key, meanings);
			
			key = "dinette";
			meanings = new ArrayList <String>();
			meanings.add("kitchen area");
			theWords.put(key, meanings);
					
			key = "ding";
			meanings = new ArrayList <String>();
			meanings.add("noise");
			theWords.put(key, meanings);
			
			key = "dingo";
			meanings = new ArrayList <String>();
			meanings.add("wild dog");
			theWords.put(key, meanings);
			
			key = "dings";
			meanings = new ArrayList <String>();
			meanings.add("bell sound");
			theWords.put(key, meanings);
			
			key = "direct";
			meanings = new ArrayList <String>();
			meanings.add("plain spoken");
			meanings.add("guide");
			theWords.put(key, meanings);
			
			key = "director";
			meanings = new ArrayList <String>();
			meanings.add("board member");
			theWords.put(key, meanings);
			
			key = "directory";
			meanings = new ArrayList <String>();
			meanings.add("listing");
			theWords.put(key, meanings);
			
			key = "dire";
			meanings = new ArrayList <String>();
			meanings.add("dreadful");
			theWords.put(key, meanings);
			
			key = "dirge";
			meanings = new ArrayList <String>();
			meanings.add("sad song");
			theWords.put(key, meanings);
			
			key = "disc";
			meanings = new ArrayList <String>();
			meanings.add("record");
			theWords.put(key, meanings);
			
			key = "disciple";
			meanings = new ArrayList <String>();
			meanings.add("follower");
			theWords.put(key, meanings);
			
			key = "disclaim";
			meanings = new ArrayList <String>();
			meanings.add("reject");
			theWords.put(key, meanings);
			
			key = "discontinue";
			meanings = new ArrayList <String>();
			meanings.add("stop");
			theWords.put(key, meanings);
			
			key = "disembark";
			meanings = new ArrayList <String>();
			meanings.add("get off");
			theWords.put(key, meanings);
			
			key = "dish";
			meanings = new ArrayList <String>();
			meanings.add("bowl");
			meanings.add("container");
			theWords.put(key, meanings);
			
			key = "disown";
			meanings = new ArrayList <String>();
			meanings.add("abandon");
			theWords.put(key, meanings);
			
			key = "dispatch";
			meanings = new ArrayList <String>();
			meanings.add("send off");
			theWords.put(key, meanings);
			
			key = "dissent";
			meanings = new ArrayList <String>();
			meanings.add("disagreement");
			theWords.put(key, meanings);
			
			key = "distract";
			meanings = new ArrayList <String>();
			meanings.add("divert attention");
			theWords.put(key, meanings);
			
			key = "ditch";
			meanings = new ArrayList <String>();
			meanings.add("abandon");
			meanings.add("trench");
			theWords.put(key, meanings);
			
			key = "ditherer";
			meanings = new ArrayList <String>();
			meanings.add("irresolute person");
			theWords.put(key, meanings);
			
			key = "diva";
			meanings = new ArrayList <String>();
			meanings.add("female star");
			meanings.add("prima donna");
			theWords.put(key, meanings);
					
			key = "diver";
			meanings = new ArrayList <String>();
			meanings.add("subsea worker");
			theWords.put(key, meanings);
			
			key = "diverting";
			meanings = new ArrayList <String>();
			meanings.add("rerouting");
			theWords.put(key, meanings);
			
			key = "do";
			meanings = new ArrayList <String>();
			meanings.add("party");
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "doc";
			meanings = new ArrayList <String>();
			meanings.add("doctor");
			theWords.put(key, meanings);
			
			key = "dock";
			meanings = new ArrayList <String>();
			meanings.add("harbour");
			meanings.add("moor");
			meanings.add("weed");
			theWords.put(key, meanings);

			key = "dog";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("cur");
			meanings.add("follow");
			meanings.add("trouble");
			theWords.put(key, meanings);
			
			key = "dogma";
			meanings = new ArrayList <String>();
			meanings.add("principle");
			theWords.put(key, meanings);
			
			key = "dogs";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			theWords.put(key, meanings);
					
			key = "dogtired"; //dog tired
			meanings = new ArrayList <String>();
			meanings.add("exhausted");
			theWords.put(key, meanings);
			
			key = "doing";
			meanings = new ArrayList <String>();
			meanings.add("performing");
			theWords.put(key, meanings);
			
			key = "doll";
			meanings = new ArrayList <String>();
			meanings.add("toy");
			theWords.put(key, meanings);
		
			key = "domain";
			meanings = new ArrayList <String>();
			meanings.add("realm");
			theWords.put(key, meanings);
					
			key = "dome";
			meanings = new ArrayList <String>();
			meanings.add("roof");
			theWords.put(key, meanings);
			
			key = "dominic";
			meanings = new ArrayList <String>();
			meanings.add("name");
			theWords.put(key, meanings);
			
			key = "don";
			meanings = new ArrayList <String>();
			meanings.add("fellow");
			meanings.add("lecturer");
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "done"; 
			meanings = new ArrayList <String>();
			meanings.add("completed");
			theWords.put(key, meanings);
			
			key = "donefor"; //done for
			meanings = new ArrayList <String>();
			meanings.add("ruined");
			theWords.put(key, meanings);
			
			key = "donkey";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "donor";
			meanings = new ArrayList <String>();
			meanings.add("benefactor");
			theWords.put(key, meanings);
			
			key = "dons";
			meanings = new ArrayList <String>();
			meanings.add("lecturers");
			meanings.add("wears");
			theWords.put(key, meanings);
			
			key = "dorset";
			meanings = new ArrayList <String>();
			meanings.add("county");
			theWords.put(key, meanings);
			
			key = "dove";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "dover";
			meanings = new ArrayList <String>();
			meanings.add("ferry port");
			meanings.add("port");
			theWords.put(key, meanings);
			
			key = "downturn";
			meanings = new ArrayList <String>();
			meanings.add("decline in business");
			theWords.put(key, meanings);
			
			key = "doze";
			meanings = new ArrayList <String>();
			meanings.add("sleep");
			theWords.put(key, meanings);
			
			key = "dozen";
			meanings = new ArrayList <String>();
			meanings.add("twelve");
			theWords.put(key, meanings);
			
			key = "draft";
			meanings = new ArrayList <String>();
			meanings.add("plan");
			meanings.add("preliminary version");
			theWords.put(key, meanings);
			
			key = "drag";
			meanings = new ArrayList <String>();
			meanings.add("something boring");
			theWords.put(key, meanings);
			
			key = "dragon";
			meanings = new ArrayList <String>();
			meanings.add("monster");
			theWords.put(key, meanings);
			
			key = "dramatists";
			meanings = new ArrayList <String>();
			meanings.add("writers");
			theWords.put(key, meanings);
			
			key = "draw";
			meanings = new ArrayList <String>();
			meanings.add("fail to win");
			meanings.add("tie");
			theWords.put(key, meanings);
			
			key = "drawaway";//draw away
			meanings = new ArrayList <String>();
			meanings.add("move off");
			theWords.put(key, meanings);
			
			key = "drawl";
			meanings = new ArrayList <String>();
			meanings.add("speak slowly");
			theWords.put(key, meanings);
			
			key = "dray";
			meanings = new ArrayList <String>();
			meanings.add("cart");
			theWords.put(key, meanings);
					
			key = "dread";
			meanings = new ArrayList <String>();
			meanings.add("be afraid");
			meanings.add("fear");
			theWords.put(key, meanings);
			
			key = "dreads";
			meanings = new ArrayList <String>();
			meanings.add("fears");
			theWords.put(key, meanings);
			
			key = "dream";
			meanings = new ArrayList <String>();
			meanings.add("fantasy");
			theWords.put(key, meanings);
			
			key = "dreamup";//dream up
			meanings = new ArrayList <String>();
			meanings.add("conceive");
			theWords.put(key, meanings);
			
			key = "dreamy";
			meanings = new ArrayList <String>();
			meanings.add("surreal");
			theWords.put(key, meanings);
			
			key = "dress";
			meanings = new ArrayList <String>();
			meanings.add("costume");
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "dresser";
			meanings = new ArrayList <String>();
			meanings.add("costume designer");
			meanings.add("piece of furniture");
			theWords.put(key, meanings);
			
			key = "dries";
			meanings = new ArrayList <String>();
			meanings.add("preserves");
			theWords.put(key, meanings);
			
			key = "drift";
			meanings = new ArrayList <String>();
			meanings.add("unpowered motion");
			theWords.put(key, meanings);
			
			key = "drill";
			meanings = new ArrayList <String>();
			meanings.add("exercise");
			meanings.add("practice");
			theWords.put(key, meanings);
			
			key = "drinking";
			meanings = new ArrayList <String>();
			meanings.add("boozing");
			theWords.put(key, meanings);
			
			key = "dripping";
			meanings = new ArrayList <String>();
			meanings.add("thoroughly wet");
			meanings.add("fat");
			theWords.put(key, meanings);
			
			key = "driver";
			meanings = new ArrayList <String>();
			meanings.add("motorist");
			theWords.put(key, meanings);
			
			key = "droll";
			meanings = new ArrayList <String>();
			meanings.add("amusing");
			theWords.put(key, meanings);
			
			key = "drover";
			meanings = new ArrayList <String>();
			meanings.add("herdsman");
			theWords.put(key, meanings);
			
			key = "drum";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
		
			key = "dry";
			meanings = new ArrayList <String>();
			meanings.add("not raining");
			meanings.add("uninteresting");
			theWords.put(key, meanings);
			
			key = "drydock";
			meanings = new ArrayList <String>();
			meanings.add("where ships are laid up");
			theWords.put(key, meanings);
			
			key = "dublin";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "duck";
			meanings = new ArrayList <String>();
			meanings.add("fowl");
			theWords.put(key, meanings);
			
			key = "due";
			meanings = new ArrayList <String>();
			meanings.add("expected");
			theWords.put(key, meanings);
					
			key = "duenna";
			meanings = new ArrayList <String>();
			meanings.add("chaperone");
			theWords.put(key, meanings);
			
			key = "duel";
			meanings = new ArrayList <String>();
			meanings.add("fight");
			theWords.put(key, meanings);
			
			key = "duet";
			meanings = new ArrayList <String>();
			meanings.add("twosome");
			theWords.put(key, meanings);
					
			key = "dusk";
			meanings = new ArrayList <String>();
			meanings.add("partial darkness");
			meanings.add("twilight");
			theWords.put(key, meanings);
			
			key = "dust";
			meanings = new ArrayList <String>();
			meanings.add("clean");
			theWords.put(key, meanings);
					
			key = "duty";
			meanings = new ArrayList <String>();
			meanings.add("obligation");
			theWords.put(key, meanings);
			
			key = "dweeb";
			meanings = new ArrayList <String>();
			meanings.add("socially inept person");
			theWords.put(key, meanings);
			
			key = "dwells";
			meanings = new ArrayList <String>();
			meanings.add("lives");
			theWords.put(key, meanings);
			
			key = "dyed";
			meanings = new ArrayList <String>();
			meanings.add("changed colour");
			theWords.put(key, meanings);
			
			key = "dynamo";
			meanings = new ArrayList <String>();
			meanings.add("converter");
			theWords.put(key, meanings);
			
			return theWords;
		} //end loadD

		public TreeMap<String, ArrayList<String>> loadEWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			// load e's
			key = "each";
			meanings = new ArrayList <String>();
			meanings.add("every");
			theWords.put(key, meanings);
			
			key = "eager";
			meanings = new ArrayList <String>();
			meanings.add("keen");
			theWords.put(key, meanings);
			
			key = "eagle";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "eaglet";
			meanings = new ArrayList <String>();
			meanings.add("baby bird");
			theWords.put(key, meanings);
			
			key = "ear";
			meanings = new ArrayList <String>();
			meanings.add("organ");
			meanings.add("part of the head");
			theWords.put(key, meanings);
			
			key = "earldom";
			meanings = new ArrayList <String>();
			meanings.add("noble land");
			theWords.put(key, meanings);
			
			key = "earlobe";
			meanings = new ArrayList <String>();
			meanings.add("part of lug");
			theWords.put(key, meanings);
			
			key = "earned";
			meanings = new ArrayList <String>();
			meanings.add("merited");
			theWords.put(key, meanings);
			
			key = "earner";
			meanings = new ArrayList <String>();
			meanings.add("one making money");
			theWords.put(key, meanings);
			
			key = "earth";
			meanings = new ArrayList <String>();
			meanings.add("world");
			theWords.put(key, meanings);
			
			key = "ease";
			meanings = new ArrayList <String>();
			meanings.add("relax");
			theWords.put(key, meanings);
			
			key = "eased";
			meanings = new ArrayList <String>();
			meanings.add("relieved");
			theWords.put(key, meanings);
			
			key = "easel";
			meanings = new ArrayList <String>();
			meanings.add("stand");
			theWords.put(key, meanings);
			
			key = "eases";
			meanings = new ArrayList <String>();
			meanings.add("reduces");
			theWords.put(key, meanings);
					
			key = "east";
			meanings = new ArrayList <String>();
			meanings.add("point");
			theWords.put(key, meanings);
			
			key = "eastenders";
			meanings = new ArrayList <String>();
			meanings.add("TV series");
			theWords.put(key, meanings);
			
			key = "easter";
			meanings = new ArrayList <String>();
			meanings.add("festival");
			meanings.add("holiday");
			theWords.put(key, meanings);
			
			key = "easteregg";
			meanings = new ArrayList <String>();
			meanings.add("seasonal treat");
			theWords.put(key, meanings);
			/*
			key = "easters";
			meanings = new ArrayList <String>();
			meanings.add("festivals");
			meanings.add("holidays");
			theWords.put(key, meanings);
			*/
			key = "eastern";
			meanings = new ArrayList <String>();
			meanings.add("from the orient");
			meanings.add("oriental");
			theWords.put(key, meanings);
			
			key = "eastgermany";// East Germany
			meanings = new ArrayList <String>();
			meanings.add("former state");
			theWords.put(key, meanings);
			
			key = "easy";
			meanings = new ArrayList <String>();
			meanings.add("simple");
			theWords.put(key, meanings);
			
			key = "eat";
			meanings = new ArrayList <String>();
			meanings.add("consume");
			meanings.add("have dinner");
			theWords.put(key, meanings);
			
			key = "eatable";
			meanings = new ArrayList <String>();
			meanings.add("fit to be consumed");
			theWords.put(key, meanings);
			
			key = "echidna";
			meanings = new ArrayList <String>();
			meanings.add("anteater");
			theWords.put(key, meanings);
			
			key = "echo";
			meanings = new ArrayList <String>();
			meanings.add("repeat");
			theWords.put(key, meanings);
			
			key = "eclair";
			meanings = new ArrayList <String>();
			meanings.add("pastry");
			theWords.put(key, meanings);
			
			key = "ed";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "edam";
			meanings = new ArrayList <String>();
			meanings.add("Dutch cheese");
			theWords.put(key, meanings);
			
			key = "eddy";
			meanings = new ArrayList <String>();
			meanings.add("current");
			theWords.put(key, meanings);
			
			key = "eden";
			meanings = new ArrayList <String>();
			meanings.add("Cumbrian river");
			meanings.add("garden");
			theWords.put(key, meanings);
					
			key = "edge";
			meanings = new ArrayList <String>();
			meanings.add("advantage");
			theWords.put(key, meanings);
			
			key = "edict";
			meanings = new ArrayList <String>();
			meanings.add("order");
			theWords.put(key, meanings);
			
			key = "edison";
			meanings = new ArrayList <String>();
			meanings.add("inventor");
			meanings.add("recording pioneer");
			theWords.put(key, meanings);
			
			key = "editor";
			meanings = new ArrayList <String>();
			meanings.add("journalist's boss");
			theWords.put(key, meanings);
					
			key = "edna";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "eel";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "eels";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
					
			key = "ego";
			meanings = new ArrayList <String>();
			meanings.add("oneself");
			theWords.put(key, meanings);
			
			key = "egret";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
					
			key = "elder";
			meanings = new ArrayList <String>();
			meanings.add("not so young");
			meanings.add("tree");
			theWords.put(key, meanings);
			
			key = "elf";
			meanings = new ArrayList <String>();
			meanings.add("sprite");
			theWords.put(key, meanings);
			
			key = "elfin";
			meanings = new ArrayList <String>();
			meanings.add("small and delicate");
			theWords.put(key, meanings);
			
			key = "elfish";
			meanings = new ArrayList <String>();
			meanings.add("like a fairy");
			theWords.put(key, meanings);
			
			key = "else";
			meanings = new ArrayList <String>();
			meanings.add("besdies");
			theWords.put(key, meanings);
			
			key = "elsewhere";
			meanings = new ArrayList <String>();
			meanings.add("in another place");
			theWords.put(key, meanings);
			
			key = "eli";
			meanings = new ArrayList <String>();
			meanings.add("biblical priest");
			theWords.put(key, meanings);
			
			key = "eliot";
			meanings = new ArrayList <String>();
			meanings.add("poet");
			theWords.put(key, meanings);
			
			key = "elite";
			meanings = new ArrayList <String>();
			meanings.add("best");
			meanings.add("select few");
			theWords.put(key, meanings);
			
			key = "elitist";
			meanings = new ArrayList <String>();
			meanings.add("organised for the good of a few");
			theWords.put(key, meanings);
			
			key = "epee";
			meanings = new ArrayList <String>();
			meanings.add("fencing weapon");
			theWords.put(key, meanings);
			
			key = "epsilon";
			meanings = new ArrayList <String>();
			meanings.add("letter from Greece");
			theWords.put(key, meanings);
			
			key = "eight";
			meanings = new ArrayList <String>();
			meanings.add("number");
			theWords.put(key, meanings);
			
			key = "eire";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "elaborate";
			meanings = new ArrayList <String>();
			meanings.add("convoluted");
			meanings.add("detailed");
			meanings.add("expand");
			meanings.add("flesh out");
			meanings.add("intricate");
			meanings.add("ornate");
			theWords.put(key, meanings);
			
			key = "elaborately";
			meanings = new ArrayList <String>();
			meanings.add("in minute detal");
			theWords.put(key, meanings);
			
			key = "elapse";
			meanings = new ArrayList <String>();
			meanings.add("slip away");
			theWords.put(key, meanings);
			
			key = "elapsed";
			meanings = new ArrayList <String>();
			meanings.add("passed by");
			theWords.put(key, meanings);
					
			key = "elation";
			meanings = new ArrayList <String>();
			meanings.add("high spirits");
			theWords.put(key, meanings);
			
			key = "elbe";
			meanings = new ArrayList <String>();
			meanings.add("European flower");
			theWords.put(key, meanings);
			
			key = "elbow";
			meanings = new ArrayList <String>();
			meanings.add("part of the body");
			theWords.put(key, meanings);
			
			key = "elect";
			meanings = new ArrayList <String>();
			meanings.add("choose");
			theWords.put(key, meanings);
			
			key = "electrifies";
			meanings = new ArrayList <String>();
			meanings.add("thrills");
			theWords.put(key, meanings);
			
			key = "elegantly";
			meanings = new ArrayList <String>();
			meanings.add("in a graceful manner");
			theWords.put(key, meanings);
			
			key = "elephant";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("jumbo");
			theWords.put(key, meanings);
			
			key = "elevate";
			meanings = new ArrayList <String>();
			meanings.add("uplift");
			theWords.put(key, meanings);
			
			key = "elevator";
			meanings = new ArrayList <String>();
			meanings.add("lift");
			theWords.put(key, meanings);
			
			key = "eleven";
			meanings = new ArrayList <String>();
			meanings.add("number");
			theWords.put(key, meanings);
			
			key = "elgar";
			meanings = new ArrayList <String>();
			meanings.add("composer");
			theWords.put(key, meanings);
			
			key = "elk";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("large deer");
			theWords.put(key, meanings);
			
			key = "elks";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			theWords.put(key, meanings);
			
			key = "elm";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			meanings.add("wood");
			theWords.put(key, meanings);
			
			key = "elope";
			meanings = new ArrayList <String>();
			meanings.add("run off together");
			theWords.put(key, meanings);
			
			key = "elvis";
			meanings = new ArrayList <String>();
			//meanings.add("king of rock and roll");
			meanings.add("singer");
			theWords.put(key, meanings);
			
			key = "eluding";
			meanings = new ArrayList <String>();
			meanings.add("evading");
			theWords.put(key, meanings);
			
			key = "emblem";
			meanings = new ArrayList <String>();
			meanings.add("badge");
			theWords.put(key, meanings);
			
			key = "embroider";
			meanings = new ArrayList <String>();
			meanings.add("exaggerate details");
			theWords.put(key, meanings);
			
			key = "emerald";
			meanings = new ArrayList <String>();
			meanings.add("green");
			theWords.put(key, meanings);
			
			key = "emeralds";
			meanings = new ArrayList <String>();
			meanings.add("stones");
			theWords.put(key, meanings);
			
			key = "emerges";
			meanings = new ArrayList <String>();
			meanings.add("slowly appears");
			theWords.put(key, meanings);
			
			key = "emit";
			meanings = new ArrayList <String>();
			meanings.add("give out");
			meanings.add("send");
			theWords.put(key, meanings);
			
			key = "emigrant";
			meanings = new ArrayList <String>();
			meanings.add("traveller");
			theWords.put(key, meanings);
			
			key = "emigrates";
			meanings = new ArrayList <String>();
			meanings.add("moves abroad");
			theWords.put(key, meanings);
			
			key = "eminent";
			meanings = new ArrayList <String>();
			meanings.add("renowned");
			theWords.put(key, meanings);
			
			key = "emirates";
			meanings = new ArrayList <String>();
			meanings.add("arab states");
			theWords.put(key, meanings);
			
			key = "emotion";
			meanings = new ArrayList <String>();
			meanings.add("feeling");
			theWords.put(key, meanings);
			
			key = "empathise";
			meanings = new ArrayList <String>();
			meanings.add("have feelings for");
			theWords.put(key, meanings);
			
			key = "emphasise";
			meanings = new ArrayList <String>();
			meanings.add("underline");
			theWords.put(key, meanings);
			
			key = "emperor";
			meanings = new ArrayList <String>();
			meanings.add("nero");
			theWords.put(key, meanings);
			
			key = "empty";
			meanings = new ArrayList <String>();
			meanings.add("vacant");
			theWords.put(key, meanings);
			
			key = "emu";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "emulate";
			meanings = new ArrayList <String>();
			meanings.add("strive to equal");
			theWords.put(key, meanings);
			
			key = "emus";
			meanings = new ArrayList <String>();
			meanings.add("Australian birds");
			theWords.put(key, meanings);
			
			key = "enchant";
			meanings = new ArrayList <String>();
			meanings.add("charm");
			meanings.add("dazzle");
			meanings.add("delight");
			theWords.put(key, meanings);
			
			key = "end";
			meanings = new ArrayList <String>();
			meanings.add("finish");
			meanings.add("last");
			meanings.add("stop");
			meanings.add("termination");
			theWords.put(key, meanings);
			
			key = "ended";
			meanings = new ArrayList <String>();
			meanings.add("finished");
			theWords.put(key, meanings);
			
			key = "ending";
			meanings = new ArrayList <String>();
			meanings.add("final");
			theWords.put(key, meanings);
			
			key = "endorse";
			meanings = new ArrayList <String>();
			meanings.add("back");
			meanings.add("show support for");
			theWords.put(key, meanings);
			
			key = "endow";
			meanings = new ArrayList <String>();
			meanings.add("provide for");
			theWords.put(key, meanings);
			
			key = "ends";
			meanings = new ArrayList <String>();
			meanings.add("finishes");
			theWords.put(key, meanings);
			
			key = "endure";
			meanings = new ArrayList <String>();
			meanings.add("last");
			theWords.put(key, meanings);
			
			key = "engaged";
			meanings = new ArrayList <String>();
			meanings.add("betrothed");
			meanings.add("busy");
			meanings.add("unavailable");
			theWords.put(key, meanings);
			
			key = "england";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "engulf";
			meanings = new ArrayList <String>();
			meanings.add("swamp");
			theWords.put(key, meanings);
				
			key = "enid";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "enlarge";
			meanings = new ArrayList <String>();
			meanings.add("expand");
			meanings.add("swell");
			theWords.put(key, meanings);
			
			key = "enlarges";
			meanings = new ArrayList <String>();
			meanings.add("expands");
			meanings.add("swells");
			theWords.put(key, meanings);
			
			key = "enlisted";
			meanings = new ArrayList <String>();
			meanings.add("engaged");
			theWords.put(key, meanings);
			
			key = "ennui";
			meanings = new ArrayList <String>();
			meanings.add("boredom");
			theWords.put(key, meanings);
			
			key = "enough";
			meanings = new ArrayList <String>();
			meanings.add("sufficent");
			theWords.put(key, meanings);
			
			key = "enormous";
			meanings = new ArrayList <String>();
			meanings.add("very large");
			theWords.put(key, meanings);
			
			key = "enraged";
			meanings = new ArrayList <String>();
			meanings.add("caused fury");
			theWords.put(key, meanings);
			
			key = "enrol";
			meanings = new ArrayList <String>();
			meanings.add("register");
			theWords.put(key, meanings);
			
			key = "enroute"; // en route
			meanings = new ArrayList <String>();
			meanings.add("on the way");
			theWords.put(key, meanings);
			
			key = "ensue";
			meanings = new ArrayList <String>();
			meanings.add("follow");
			theWords.put(key, meanings);
			
			key = "ensuite";
			meanings = new ArrayList <String>();
			meanings.add("with a bathroom");
			theWords.put(key, meanings);
			
			key = "ensure";
			meanings = new ArrayList <String>();
			meanings.add("make certain");
			theWords.put(key, meanings);
				
			key = "entail";
			meanings = new ArrayList <String>();
			meanings.add("involve");
			theWords.put(key, meanings);
		
			key = "enter";
			meanings = new ArrayList <String>();
			meanings.add("record");
			meanings.add("to go into");
			theWords.put(key, meanings);
			
			key = "enters";
			meanings = new ArrayList <String>();
			meanings.add("comes in");
			theWords.put(key, meanings);
			
			key = "enthral";
			meanings = new ArrayList <String>();
			meanings.add("hold spellbound");
			meanings.add("rivet");
			theWords.put(key, meanings);
			
			key = "entice";
			meanings = new ArrayList <String>();
			meanings.add("lure");
			theWords.put(key, meanings);
			
			key = "entire";
			meanings = new ArrayList <String>();
			meanings.add("complete");
			theWords.put(key, meanings);
			
			key = "entrance";
			meanings = new ArrayList <String>();
			meanings.add("place to go in");
			meanings.add("delight");
			theWords.put(key, meanings);
			
			key = "entrap";
			meanings = new ArrayList <String>();
			meanings.add("catch");
			theWords.put(key, meanings);
			
			key = "entree";
			meanings = new ArrayList <String>();
			meanings.add("starter");
			theWords.put(key, meanings);
			
			key = "enumeration";
			meanings = new ArrayList <String>();
			meanings.add("list");
			theWords.put(key, meanings);
			
			key = "environment";
			meanings = new ArrayList <String>();
			meanings.add("habitat");
			theWords.put(key, meanings);
			
			key = "envoy";
			meanings = new ArrayList <String>();
			meanings.add("diplomat");
			theWords.put(key, meanings);
			
			key = "envy";
			meanings = new ArrayList <String>();
			meanings.add("resent");
			meanings.add("resentment");
			theWords.put(key, meanings);
			
			key = "enya";
			meanings = new ArrayList <String>();
			meanings.add("singer");
			theWords.put(key, meanings);
			
			key = "epic";
			meanings = new ArrayList <String>();
			meanings.add("surpassing the usual");
			theWords.put(key, meanings);
			
			key = "epicentre";
			meanings = new ArrayList <String>();
			meanings.add("momentus");
			meanings.add("surpassing the usual");
			theWords.put(key, meanings);
			
			key = "epicures";
			meanings = new ArrayList <String>();
			meanings.add("gourmets");
			theWords.put(key, meanings);
			
			key = "equal";
			meanings = new ArrayList <String>();
			meanings.add("match");
			theWords.put(key, meanings);
			
			key = "equality";
			meanings = new ArrayList <String>();
			meanings.add("no difference");
			theWords.put(key, meanings);
			
			key = "equip";
			meanings = new ArrayList <String>();
			meanings.add("provide kit");
			theWords.put(key, meanings);
			
			key = "era";
			meanings = new ArrayList <String>();
			meanings.add("time period");
			meanings.add("age");
			meanings.add("epoch");
			meanings.add("long time");
			meanings.add("period");
			theWords.put(key, meanings);
			
			key = "erasing";
			meanings = new ArrayList <String>();
			meanings.add("rubbing out");
			theWords.put(key, meanings);
			
			key = "Erasmus";
			meanings = new ArrayList <String>();
			meanings.add("scholar");
			theWords.put(key, meanings);
			
			key = "ere";
			meanings = new ArrayList <String>();
			meanings.add("before");
			theWords.put(key, meanings);
			
			key = "ergo";
			meanings = new ArrayList <String>();
			meanings.add("therefore");
			theWords.put(key, meanings);
			
			key = "eric";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "erica";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "erne";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "erode";
			meanings = new ArrayList <String>();
			meanings.add("wear down");
			theWords.put(key, meanings);
			
			key = "eros";
			meanings = new ArrayList <String>();
			meanings.add("love god");
			theWords.put(key, meanings);
			
			key = "err";
			meanings = new ArrayList <String>();
			meanings.add("go wrong");
			meanings.add("stray");
			theWords.put(key, meanings);
			
			key = "errand";
			meanings = new ArrayList <String>();
			meanings.add("a job to do");
			theWords.put(key, meanings);
			
			key = "erratic";
			meanings = new ArrayList <String>();
			meanings.add("unpredictable");
			meanings.add("unstable");
			theWords.put(key, meanings);
			
			key = "error";
			meanings = new ArrayList <String>();
			meanings.add("mistake");
			theWords.put(key, meanings);
			
			key = "errors";
			meanings = new ArrayList <String>();
			meanings.add("mistakes");
			theWords.put(key, meanings);
			
			key = "eskimo";
			meanings = new ArrayList <String>();
			meanings.add("arctic dweller");
			theWords.put(key, meanings);
			
			key = "esoteric";
			meanings = new ArrayList <String>();
			meanings.add("difficult to understand");
			theWords.put(key, meanings);
			
			key = "essayist";
			meanings = new ArrayList <String>();
			meanings.add("writer");
			theWords.put(key, meanings);
			
			key = "essex";
			meanings = new ArrayList <String>();
			meanings.add("county");
			theWords.put(key, meanings);
			
			key = "estate";
			meanings = new ArrayList <String>();
			meanings.add("land");
			meanings.add("wealth");
			theWords.put(key, meanings);
					
			key = "ester";
			meanings = new ArrayList <String>();
			meanings.add("organic compound");
			theWords.put(key, meanings);
			
			key = "estonia";
			meanings = new ArrayList <String>();
			meanings.add("land");
			theWords.put(key, meanings);
			
			key = "etc";
			meanings = new ArrayList <String>();
			meanings.add("and so on");
			theWords.put(key, meanings);
			
			key = "etch";
			meanings = new ArrayList <String>();
			meanings.add("produce artwork");
			meanings.add("score");
			theWords.put(key, meanings);
			
			key = "eternal";
			meanings = new ArrayList <String>();
			meanings.add("everlasting");
			theWords.put(key, meanings);
			
			key = "ethos";
			meanings = new ArrayList <String>();
			meanings.add("character of a person");
			meanings.add("moral significance");
			theWords.put(key, meanings);
			
			key = "eton";
			meanings = new ArrayList <String>();
			meanings.add("public school");
			meanings.add("school");
			theWords.put(key, meanings);
			
			key = "etna";
			meanings = new ArrayList <String>();
			meanings.add("volcano");
			theWords.put(key, meanings);
			
			key = "europe";
			meanings = new ArrayList <String>();
			meanings.add("continent");
			meanings.add("group of countries");
			theWords.put(key, meanings);
			
			key = "eva";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "eve";
			meanings = new ArrayList <String>();
			meanings.add("day before");
			meanings.add("first lady");
			meanings.add("first woman");
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "even";
			meanings = new ArrayList <String>();
			meanings.add("flat");
			meanings.add("regular");
			meanings.add("uniform");
			theWords.put(key, meanings);
			
			key = "evening";
			meanings = new ArrayList <String>();
			meanings.add("end of the day");
			theWords.put(key, meanings);
			
			key = "event";
			meanings = new ArrayList <String>();
			meanings.add("occasion");
			meanings.add("something that happens");
			theWords.put(key, meanings);
			
			key = "eventide";
			meanings = new ArrayList <String>();
			meanings.add("late in the day");
			theWords.put(key, meanings);
			
			key = "ever";
			meanings = new ArrayList <String>();
			meanings.add("always");
			meanings.add("all time");
			theWords.put(key, meanings);
			
			key = "evergreen";
			meanings = new ArrayList <String>();
			meanings.add("holly perhaps");
			theWords.put(key, meanings);
			
			key = "everton";
			meanings = new ArrayList <String>();
			meanings.add("football club");
			meanings.add("football team");
			theWords.put(key, meanings);
			
			key = "everest";
			meanings = new ArrayList <String>();
			meanings.add("mountain");
			theWords.put(key, meanings);
			
			key = "evian";
			meanings = new ArrayList <String>();
			meanings.add("spring water");
			theWords.put(key, meanings);
			
			key = "evict";
			meanings = new ArrayList <String>();
			meanings.add("kick out");
			theWords.put(key, meanings);
			
			key = "evident";
			meanings = new ArrayList <String>();
			meanings.add("obvious");
			theWords.put(key, meanings);
			
			key = "evil";
			meanings = new ArrayList <String>();
			meanings.add("fiendish");
			meanings.add("wickedness");
			theWords.put(key, meanings);
			
			key = "evils";
			meanings = new ArrayList <String>();
			meanings.add("bad things");
			theWords.put(key, meanings);
			
			key = "evoke";
			meanings = new ArrayList <String>();
			meanings.add("call up");
			theWords.put(key, meanings);
			
			key = "ewe";
			meanings = new ArrayList <String>();
			meanings.add("sheep");
			theWords.put(key, meanings);
			
			key = "ewer";
			meanings = new ArrayList <String>();
			meanings.add("vessel");
			theWords.put(key, meanings);
			
			key = "ex";
			meanings = new ArrayList <String>();
			meanings.add("former partner");
			theWords.put(key, meanings);
			
			key = "examples";
			meanings = new ArrayList <String>();
			meanings.add("typical specimens");
			theWords.put(key, meanings);
			
			key = "exeter";
			meanings = new ArrayList <String>();
			meanings.add("west country");
			theWords.put(key, meanings);
			
			key = "exhibition";
			meanings = new ArrayList <String>();
			meanings.add("display");
			theWords.put(key, meanings);
			
			key = "exile";
			meanings = new ArrayList <String>();
			meanings.add("banish");
			theWords.put(key, meanings);
			
			key = "exiled";
			meanings = new ArrayList <String>();
			meanings.add("banished");
			theWords.put(key, meanings);
			
			key = "exit";
			meanings = new ArrayList <String>();
			meanings.add("departure");
			theWords.put(key, meanings);
			
			key = "expertise";
			meanings = new ArrayList <String>();
			meanings.add("special skill");
			theWords.put(key, meanings);
			
			key = "explain";
			meanings = new ArrayList <String>();
			meanings.add("clear up");
			theWords.put(key, meanings);
			
			key = "exploited";
			meanings = new ArrayList <String>();
			meanings.add("made full use of");
			theWords.put(key, meanings);
			
			key = "exporter";
			meanings = new ArrayList <String>();
			meanings.add("overseas trader");
			theWords.put(key, meanings);
					
			key = "expose";
			meanings = new ArrayList <String>();
			meanings.add("unmask");
			theWords.put(key, meanings);
			
			key = "external";
			meanings = new ArrayList <String>();
			meanings.add("outside");
			theWords.put(key, meanings);
			
			key = "extra";
			meanings = new ArrayList <String>();
			meanings.add("additional feature");
			meanings.add("casual actor");
			meanings.add("more");
			theWords.put(key, meanings);
					
			key = "exude";
			meanings = new ArrayList <String>();
			meanings.add("give off");
			theWords.put(key, meanings);

			key = "eye";
			meanings = new ArrayList <String>();
			meanings.add("look at");
			meanings.add("observe");
			meanings.add("part of a needle");
			meanings.add("see");
			meanings.add("view");
			theWords.put(key, meanings);
			
			key = "eyelet";
			meanings = new ArrayList <String>();
			meanings.add("small hole");
			meanings.add("small round hole");
			theWords.put(key, meanings);
			
			key = "eyelid";
			meanings = new ArrayList <String>();
			meanings.add("facial feature");
			theWords.put(key, meanings);
					
			key = "eyeliner";
			meanings = new ArrayList <String>();
			meanings.add("cosmetic");
			theWords.put(key, meanings);

			return theWords;
		}//end loadE
		
		public void loadFWords() {
			String key;
			ArrayList <String> meanings;
			
			// load f's
			key = "fable";
			meanings = new ArrayList <String>();
			meanings.add("legend");
			meanings.add("story");
			theWords.put(key, meanings);
			
			key = "fab";
			meanings = new ArrayList <String>();
			meanings.add("super");
			theWords.put(key, meanings);
			
			key = "fabric";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "fact";
			meanings = new ArrayList <String>();
			meanings.add("truth");
			theWords.put(key, meanings);
			
			key = "factory";
			meanings = new ArrayList <String>();
			meanings.add("production unit");
			theWords.put(key, meanings);
					
			key = "fade";
			meanings = new ArrayList <String>();
			meanings.add("grow faint");
			theWords.put(key, meanings);
			
			key = "fag";
			meanings = new ArrayList <String>();
			meanings.add("cigarette");
			theWords.put(key, meanings);
			
			key = "fail";
			meanings = new ArrayList <String>();
			meanings.add("don't pass");
			meanings.add("flop");
			theWords.put(key, meanings);
			
			key = "failing";
			meanings = new ArrayList <String>();
			meanings.add("flopping");
			meanings.add("not passing");
			meanings.add("not suceeding");
			theWords.put(key, meanings);
			
			key = "fair";
			meanings = new ArrayList <String>();
			meanings.add("just");
			theWords.put(key, meanings);
			
			key = "fan";
			meanings = new ArrayList <String>();
			meanings.add("cooler");
			meanings.add("supporter");
			theWords.put(key, meanings);
			
			key = "fanfare";
			meanings = new ArrayList <String>();
			meanings.add("flourish");
			theWords.put(key, meanings);
			
			key = "fantail";
			meanings = new ArrayList <String>();
			meanings.add("pigeon");
			theWords.put(key, meanings);
			
			key = "far";
			meanings = new ArrayList <String>();
			meanings.add("distant");
			theWords.put(key, meanings);
			
			key = "fare";
			meanings = new ArrayList <String>();
			meanings.add("food");
			theWords.put(key, meanings);
			
			key = "farm";
			meanings = new ArrayList <String>();
			meanings.add("grange");
			theWords.put(key, meanings);
			
			key = "father";
			meanings = new ArrayList <String>();
			meanings.add("parent");
			theWords.put(key, meanings);
			
			key = "fast";
			meanings = new ArrayList <String>();
			meanings.add("fix");
			meanings.add("not eating");
			meanings.add("secured");
			meanings.add("very quick");
			theWords.put(key, meanings);
			
			key = "faster";
			meanings = new ArrayList <String>();
			meanings.add("more quickly");
			theWords.put(key, meanings);
			
			key = "fat";
			meanings = new ArrayList <String>();
			meanings.add("corpulent");
			meanings.add("oily substance");
			meanings.add("plump");
			theWords.put(key, meanings);
			
			key = "fate";
			meanings = new ArrayList <String>();
			meanings.add("destiny");
			theWords.put(key, meanings);
					
			key = "fatherly";
			meanings = new ArrayList <String>();
			meanings.add("protective and affectionate");
			theWords.put(key, meanings);
			
			key = "fault";
			meanings = new ArrayList <String>();
			meanings.add("error");
			theWords.put(key, meanings);
			
			key = "favour";
			meanings = new ArrayList <String>();
			meanings.add("kind act");
			theWords.put(key, meanings);
			
			key = "feat";
			meanings = new ArrayList <String>();
			meanings.add("achievement");
			meanings.add("accomplishment");
			meanings.add("heroic deed");
			theWords.put(key, meanings);
			
			key = "fears";
			meanings = new ArrayList <String>();
			meanings.add("dreads");
			theWords.put(key, meanings);
			
			key = "feast";
			meanings = new ArrayList <String>();
			meanings.add("large meal");
			theWords.put(key, meanings);
					
			key = "fed";
			meanings = new ArrayList <String>();
			meanings.add("gave food");
			theWords.put(key, meanings);
			
			key = "fee";
			meanings = new ArrayList <String>();
			meanings.add("charge");
			theWords.put(key, meanings);
			
			key = "feeble";
			meanings = new ArrayList <String>();
			meanings.add("lacking in strength");
			theWords.put(key, meanings);
			
			key = "feel";
			meanings = new ArrayList <String>();
			meanings.add("sense");
			theWords.put(key, meanings);
			
			key = "felon";
			meanings = new ArrayList <String>();
			meanings.add("criminal");
			theWords.put(key, meanings);
			
			key = "femur";
			meanings = new ArrayList <String>();
			meanings.add("bone");
			theWords.put(key, meanings);
			
			key = "fencing";
			meanings = new ArrayList <String>();
			meanings.add("sport");
			theWords.put(key, meanings);
			
			key = "fervent";
			meanings = new ArrayList <String>();
			meanings.add("passionate");
			theWords.put(key, meanings);
			
			key = "feta";
			meanings = new ArrayList <String>();
			meanings.add("cheese");
			theWords.put(key, meanings);
			
			key = "fetch";
			meanings = new ArrayList <String>();
			meanings.add("get");
			theWords.put(key, meanings);
			
			key = "fetching";
			meanings = new ArrayList <String>();
			meanings.add("getting");
			meanings.add("attractive");
			theWords.put(key, meanings);
			
			key = "fete";
			meanings = new ArrayList <String>();
			meanings.add("gala");
			meanings.add("party");
			theWords.put(key, meanings);
			
			key = "fever";
			meanings = new ArrayList <String>();
			meanings.add("high temperature");
			meanings.add("hot feeling");
			theWords.put(key, meanings);
			
			key = "fiance";
			meanings = new ArrayList <String>();
			meanings.add("intended");
			meanings.add("gromm-to-be");
			theWords.put(key, meanings);
				
			key = "fib";
			meanings = new ArrayList <String>();
			meanings.add("lie");
			theWords.put(key, meanings);
			
			key = "fiction";
			meanings = new ArrayList <String>();
			meanings.add("literary genre");
			theWords.put(key, meanings);
			
			key = "fiddle";
			meanings = new ArrayList <String>();
			meanings.add("tinker with");
			meanings.add("instrument");
			theWords.put(key, meanings);
			
			key = "fidget";
			meanings = new ArrayList <String>();
			meanings.add("wriggle");
			theWords.put(key, meanings);

			key = "field";
			meanings = new ArrayList <String>();
			meanings.add("meadow");
			theWords.put(key, meanings);

			key = "fiend";
			meanings = new ArrayList <String>();
			meanings.add("devil");
			theWords.put(key, meanings);
			
			key = "fiesta";
			meanings = new ArrayList <String>();
			meanings.add("foreign festival");
			theWords.put(key, meanings);
			
			key = "films";
			meanings = new ArrayList <String>();
			meanings.add("pictures");
			theWords.put(key, meanings);
			
			key = "finance";
			meanings = new ArrayList <String>();
			meanings.add("money");
			theWords.put(key, meanings);
		
			key = "fin";
			meanings = new ArrayList <String>();
			meanings.add("swimming aid");
			theWords.put(key, meanings);
			
			key = "final";
			meanings = new ArrayList <String>();
			meanings.add("last");
			theWords.put(key, meanings);
			
			key = "find";
			meanings = new ArrayList <String>();
			meanings.add("come across");
			theWords.put(key, meanings);
			
			key = "fine";
			meanings = new ArrayList <String>();
			meanings.add("excellent");
			meanings.add("punishment");
			theWords.put(key, meanings);
			
			key = "fined";
			meanings = new ArrayList <String>();
			meanings.add("given penalty");
			theWords.put(key, meanings);
			
			key = "finn";
			meanings = new ArrayList <String>();
			meanings.add("european");
			theWords.put(key, meanings);
					
			key = "fir";
			meanings = new ArrayList <String>();
			meanings.add("evergreen");
			theWords.put(key, meanings);
			
			key = "fire";
			meanings = new ArrayList <String>();
			meanings.add("dismiss");
			theWords.put(key, meanings);
					
			key = "firem";
			meanings = new ArrayList <String>();
			meanings.add("business");
			theWords.put(key, meanings);
			
			key = "fireman";
			meanings = new ArrayList <String>();
			meanings.add("emergency worker");
			theWords.put(key, meanings);
			
			key = "fireside";
			meanings = new ArrayList <String>();
			meanings.add("somewhere warm");
			theWords.put(key, meanings);
			
			key = "firm";
			meanings = new ArrayList <String>();
			meanings.add("business");
			meanings.add("company");
			meanings.add("partnership");
			meanings.add("secure");
			meanings.add("settled");
			theWords.put(key, meanings);
			
			key = "first";
			meanings = new ArrayList <String>();
			meanings.add("leading");
			theWords.put(key, meanings);
			
			key = "fish";
			meanings = new ArrayList <String>();
			meanings.add("swimmer");
			theWords.put(key, meanings);
			
			key = "fishguard";
			meanings = new ArrayList <String>();
			meanings.add("port");
			theWords.put(key, meanings);
			
			key = "fit";
			meanings = new ArrayList <String>();
			meanings.add("appropriate");
			meanings.add("in good condition");
			meanings.add("install");
			meanings.add("suitable");
			theWords.put(key, meanings);
			
			key = "fitness";
			meanings = new ArrayList <String>();
			meanings.add("physical well-being");
			theWords.put(key, meanings);
			
			key = "flag";
			meanings = new ArrayList <String>();
			meanings.add("banner");
			theWords.put(key, meanings);
			
			key = "flail";
			meanings = new ArrayList <String>();
			meanings.add("wave wildly");
			theWords.put(key, meanings);
			
			key = "flair";
			meanings = new ArrayList <String>();
			meanings.add("natural ability");
			meanings.add("talent");
			theWords.put(key, meanings);
			
			key = "flaming";
			meanings = new ArrayList <String>();
			meanings.add("burning");
			theWords.put(key, meanings);
			
			key = "flamingo";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "flan";
			meanings = new ArrayList <String>();
			meanings.add("dish");
			meanings.add("sweet");
			theWords.put(key, meanings);
			
			key = "flank";
			meanings = new ArrayList <String>();
			meanings.add("side");
			theWords.put(key, meanings);
					
			key = "flask";
			meanings = new ArrayList <String>();
			meanings.add("thermos");
			theWords.put(key, meanings);
			
			key = "flatter";
			meanings = new ArrayList <String>();
			meanings.add("give insincere praise");
			meanings.add("less sparkling");
			theWords.put(key, meanings);
			
			key = "flattery";
			meanings = new ArrayList <String>();
			meanings.add("soft soap");
			theWords.put(key, meanings);
			
			key = "flavour";
			meanings = new ArrayList <String>();
			meanings.add("distinctive taste");
			theWords.put(key, meanings);
			
			key = "fleece";
			meanings = new ArrayList <String>();
			meanings.add("rip off");
			meanings.add("coat");
			theWords.put(key, meanings);
			
			key = "fleet";
			meanings = new ArrayList <String>();
			meanings.add("fast");
			meanings.add("group of trucks");
			theWords.put(key, meanings);
			
			key = "fliers";
			meanings = new ArrayList <String>();
			meanings.add("leaflets");
			theWords.put(key, meanings);
			
			key = "fling";
			meanings = new ArrayList <String>();
			meanings.add("cast");
			theWords.put(key, meanings);
			
			key = "flints";
			meanings = new ArrayList <String>();
			meanings.add("stones");
			theWords.put(key, meanings);
			
			key = "flip";
			meanings = new ArrayList <String>();
			meanings.add("hit the roof");
			theWords.put(key, meanings);
			
			key = "flippant";
			meanings = new ArrayList <String>();
			meanings.add("frivolous");
			theWords.put(key, meanings);
			
			key = "flimsy";
			meanings = new ArrayList <String>();
			meanings.add("weak");
			theWords.put(key, meanings);
			
			key = "flirt";
			meanings = new ArrayList <String>();
			meanings.add("make advances");
			theWords.put(key, meanings);
			
			key = "flit";
			meanings = new ArrayList <String>();
			meanings.add("move swiftly");
			theWords.put(key, meanings);
			
			key = "float";
			meanings = new ArrayList <String>();
			meanings.add("levitate");
			theWords.put(key, meanings);
					
			key = "flog";
			meanings = new ArrayList <String>();
			meanings.add("thrash");
			theWords.put(key, meanings);
			
			key = "flower";
			meanings = new ArrayList <String>();
			meanings.add("bloom");
			theWords.put(key, meanings);
			
			key = "flowing";
			meanings = new ArrayList <String>();
			meanings.add("uninterrupted");
			theWords.put(key, meanings);
			
			key = "flung";
			meanings = new ArrayList <String>();
			meanings.add("threw");
			theWords.put(key, meanings);
			
			key = "fluster";
			meanings = new ArrayList <String>();
			meanings.add("turmoil");
			theWords.put(key, meanings);
			
			key = "flute";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			meanings.add("tall glass");
			theWords.put(key, meanings);
			
			key = "fly";
			meanings = new ArrayList <String>();
			meanings.add("creature");
			meanings.add("cunning");
			theWords.put(key, meanings);
			
			key = "flytrap";
			meanings = new ArrayList <String>();
			meanings.add("insect catcher");
			theWords.put(key, meanings);

			key = "foe";
			meanings = new ArrayList <String>();
			meanings.add("enemy");
			theWords.put(key, meanings);
			
			key = "fog";
			meanings = new ArrayList <String>();
			meanings.add("confusion");
			theWords.put(key, meanings);
			
			key = "foil";
			meanings = new ArrayList <String>();
			meanings.add("prevent");
			meanings.add("sword");
			meanings.add("thwart");
			theWords.put(key, meanings);
			
			key = "foliage";
			meanings = new ArrayList <String>();
			meanings.add("leaves");
			theWords.put(key, meanings);
			
			key = "folio";
			meanings = new ArrayList <String>();
			meanings.add("leaf");
			meanings.add("page of a book");
			meanings.add("sheet");
			theWords.put(key, meanings);
					
			key = "food";
			meanings = new ArrayList <String>();
			meanings.add("sustenance");
			theWords.put(key, meanings);
			
			key = "fool";
			meanings = new ArrayList <String>();
			meanings.add("idiot");
			theWords.put(key, meanings);
			
			key = "for";
			meanings = new ArrayList <String>();
			meanings.add("in favour of");
			theWords.put(key, meanings);
			
			key = "forage";
			meanings = new ArrayList <String>();
			meanings.add("search for");
			theWords.put(key, meanings);
			
			key = "forbid";
			meanings = new ArrayList <String>();
			meanings.add("prohibit");
			theWords.put(key, meanings);
			
			key = "force";
			meanings = new ArrayList <String>();
			meanings.add("might");
			meanings.add("power");
			theWords.put(key, meanings);
				
			key = "forced";
			meanings = new ArrayList <String>();
			meanings.add("appear unnatural");
			theWords.put(key, meanings);
			
			key = "forces";
			meanings = new ArrayList <String>();
			meanings.add("troops");
			theWords.put(key, meanings);
					
			key = "ford";
			meanings = new ArrayList <String>();
			meanings.add("water");
			theWords.put(key, meanings);
					
			key = "foreign";
			meanings = new ArrayList <String>();
			meanings.add("from abroad");
			theWords.put(key, meanings);
			
			key = "forest";
			meanings = new ArrayList <String>();
			meanings.add("wooodland");
			theWords.put(key, meanings);
			
			key = "forum";
			meanings = new ArrayList <String>();
			meanings.add("discussion group");
			theWords.put(key, meanings);
			
			key = "for";
			meanings = new ArrayList <String>();
			meanings.add("in favour");
			meanings.add("in favour of");
			theWords.put(key, meanings);
			
			key = "foreman";
			meanings = new ArrayList <String>();
			meanings.add("supervisor");
			theWords.put(key, meanings);
			
			key = "formal";
			meanings = new ArrayList <String>();
			meanings.add("bona fide");
			theWords.put(key, meanings);
			
			key = "form";
			meanings = new ArrayList <String>();
			meanings.add("shape");
			theWords.put(key, meanings);
			
			key = "former";
			meanings = new ArrayList <String>();
			meanings.add("previous");
			theWords.put(key, meanings);
			
			key = "fortress";
			meanings = new ArrayList <String>();
			meanings.add("castle");
			theWords.put(key, meanings);
			
			key = "fortune";
			meanings = new ArrayList <String>();
			meanings.add("huge amount of money");
			meanings.add("lot of money");
			theWords.put(key, meanings);
					
			key = "forwards";
			meanings = new ArrayList <String>();
			meanings.add("ahead");
			theWords.put(key, meanings);
			
			key = "found";
			meanings = new ArrayList <String>();
			meanings.add("discovered");
			theWords.put(key, meanings);
					
			key = "four";
			meanings = new ArrayList <String>();
			meanings.add("quartet");
			theWords.put(key, meanings);
			
			key = "fourteen";
			meanings = new ArrayList <String>();
			meanings.add("figure");
			theWords.put(key, meanings);
			
			key = "foyer";
			meanings = new ArrayList <String>();
			meanings.add("entrance hall");
			theWords.put(key, meanings);
			
			key = "france";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);

			key = "francis";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "fray";
			meanings = new ArrayList <String>();
			meanings.add("disturbance");
			theWords.put(key, meanings);
			
			key = "free";
			meanings = new ArrayList <String>();
			meanings.add("for nothing");
			theWords.put(key, meanings);
			
			key = "freely";
			meanings = new ArrayList <String>();
			meanings.add("without compulsion");
			theWords.put(key, meanings);
			
			key = "fresco";
			meanings = new ArrayList <String>();
			meanings.add("painting on wall");
			theWords.put(key, meanings);
			
			key = "fresh";
			meanings = new ArrayList <String>();
			meanings.add("new");
			theWords.put(key, meanings);
			
			key = "friction";
			meanings = new ArrayList <String>();
			meanings.add("antagonism");
			theWords.put(key, meanings);
			
			key = "fridge";
			meanings = new ArrayList <String>();
			meanings.add("cooler");
			theWords.put(key, meanings);
			
			key = "freight";
			meanings = new ArrayList <String>();
			meanings.add("cargo");
			theWords.put(key, meanings);
			
			key = "friend";
			meanings = new ArrayList <String>();
			meanings.add("pal");
			theWords.put(key, meanings);
			
			key = "frigate";
			meanings = new ArrayList <String>();
			meanings.add("warship");
			theWords.put(key, meanings);
			
			key = "frog";
			meanings = new ArrayList <String>();
			meanings.add("amphibian");
			theWords.put(key, meanings);
			
			key = "fry";
			meanings = new ArrayList <String>();
			meanings.add("cook");
			theWords.put(key, meanings);
			
			key = "fulcrum";
			meanings = new ArrayList <String>();
			meanings.add("pivotal point");
			theWords.put(key, meanings);
			
			key = "full";
			meanings = new ArrayList <String>();
			meanings.add("complete");
			theWords.put(key, meanings);
			
			key = "fulmar";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "fun";
			meanings = new ArrayList <String>();
			meanings.add("amusing");
			theWords.put(key, meanings);
			
			key = "fungi";
			meanings = new ArrayList <String>();
			meanings.add("mushrooms");
			theWords.put(key, meanings);
			
			key = "funny";
			meanings = new ArrayList <String>();
			meanings.add("peculiar");
			theWords.put(key, meanings);
			
			key = "futon";
			meanings = new ArrayList <String>();
			meanings.add("bed");
			theWords.put(key, meanings);
			
			key = "fur";
			meanings = new ArrayList <String>();
			meanings.add("hairy coat");
			theWords.put(key, meanings);
			
			key = "furrows";
			meanings = new ArrayList <String>();
			meanings.add("wrinkles");
			theWords.put(key, meanings);

		}//end loadF
		
		public TreeMap<String, ArrayList<String>> loadGWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			// load g's
			key = "gable";
			meanings = new ArrayList <String>();
			meanings.add("part of roof");
			theWords.put(key, meanings);
			
			key = "gadget";
			meanings = new ArrayList <String>();
			meanings.add("thing");
			theWords.put(key, meanings);
			
			key = "gag";
			meanings = new ArrayList <String>();
			meanings.add("heave");
			meanings.add("muzzle");
			meanings.add("muffle");
			meanings.add("silence");
			meanings.add("stifle");
			theWords.put(key, meanings);
			
			key = "gal";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "gale";
			meanings = new ArrayList <String>();
			meanings.add("high wind");
			theWords.put(key, meanings);
			
			key = "gallery";
			meanings = new ArrayList <String>();
			meanings.add("exhibition room");
			theWords.put(key, meanings);
			
			key = "gallops";
			meanings = new ArrayList <String>();
			meanings.add("runs");
			theWords.put(key, meanings);
			
			key = "game";
			meanings = new ArrayList <String>();
			meanings.add("match");
			theWords.put(key, meanings);
			
			key = "gamut";
			meanings = new ArrayList <String>();
			meanings.add("full extent");
			theWords.put(key, meanings);
					
			key = "gander";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			meanings.add("quick look at");
			theWords.put(key, meanings);
			
			key = "gap";
			meanings = new ArrayList <String>();
			meanings.add("space");
			theWords.put(key, meanings);
			
			key = "gape";
			meanings = new ArrayList <String>();
			meanings.add("stare");
			theWords.put(key, meanings);
			
			key = "garage";
			meanings = new ArrayList <String>();
			meanings.add("car shop");
			theWords.put(key, meanings);
			
			key = "garb";
			meanings = new ArrayList <String>();
			meanings.add("clothes");
			meanings.add("clothing");
			theWords.put(key, meanings);
			
			key = "garbled";
			meanings = new ArrayList <String>();
			meanings.add("mixed up");
			theWords.put(key, meanings);
			
			key = "gardener";
			meanings = new ArrayList <String>();
			meanings.add("one who grows");
			theWords.put(key, meanings);
			
			key = "garnish";
			meanings = new ArrayList <String>();
			meanings.add("embellishment");
			theWords.put(key, meanings);
			
			key = "gas";
			meanings = new ArrayList <String>();
			meanings.add("in America petrol");
			meanings.add("talk on");
			theWords.put(key, meanings);
					
			key = "gash";
			meanings = new ArrayList <String>();
			meanings.add("cut");
			theWords.put(key, meanings);
			
			key = "gate";
			meanings = new ArrayList <String>();
			meanings.add("number of spectators");
			theWords.put(key, meanings);
					
			key = "gatsby";
			meanings = new ArrayList <String>();
			meanings.add("great fictional character");
			theWords.put(key, meanings);
			
			key = "gave";
			meanings = new ArrayList <String>();
			meanings.add("donated");
			theWords.put(key, meanings);
			
			key = "gear";
			meanings = new ArrayList <String>();
			meanings.add("equipment");
			meanings.add("garb");
			theWords.put(key, meanings);
			
			key = "gears";
			meanings = new ArrayList <String>();
			meanings.add("part of bike");
			theWords.put(key, meanings);
			
			key = "gem";
			meanings = new ArrayList <String>();
			meanings.add("stone");
			theWords.put(key, meanings);
			
			key = "gemini";
			meanings = new ArrayList <String>();
			meanings.add("sign");
			meanings.add("twins");
			theWords.put(key, meanings);
			
			key = "gems";
			meanings = new ArrayList <String>();
			meanings.add("diamonds");
			theWords.put(key, meanings);
			
			key = "gemstone";
			meanings = new ArrayList <String>();
			meanings.add("precious object");
			theWords.put(key, meanings);
			
			key = "gen";
			meanings = new ArrayList <String>();
			meanings.add("information");
			theWords.put(key, meanings);
			
			key = "general";
			meanings = new ArrayList <String>();
			meanings.add("officer");
			theWords.put(key, meanings);
			
			key = "generals";
			meanings = new ArrayList <String>();
			meanings.add("officers");
			theWords.put(key, meanings);
			
			key = "geneva";
			meanings = new ArrayList <String>();
			meanings.add("city");
			meanings.add("Swiss city");
			theWords.put(key, meanings);
			
			key = "genial";
			meanings = new ArrayList <String>();
			meanings.add("sociable");
			theWords.put(key, meanings);
			
			key = "genoa";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "gent";
			meanings = new ArrayList <String>();
			meanings.add("bloke");
			meanings.add("chap");
			meanings.add("man");
			meanings.add("well-mannered chap");
			theWords.put(key, meanings);
			
			key = "geoff";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "george";
			meanings = new ArrayList <String>();
			meanings.add("king");
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "geraniums";
			meanings = new ArrayList <String>();
			meanings.add("flowers");
			theWords.put(key, meanings);
			
			key = "germans";
			meanings = new ArrayList <String>();
			meanings.add("Europeans");
			theWords.put(key, meanings);
			
			key = "get";
			meanings = new ArrayList <String>();
			meanings.add("obtain");
			theWords.put(key, meanings);
			
			key = "geton";
			meanings = new ArrayList <String>();
			meanings.add("make progress");
			theWords.put(key, meanings);
			
			key = "gets";
			meanings = new ArrayList <String>();
			meanings.add("obtains");
			theWords.put(key, meanings);
					
			key = "gifted";
			meanings = new ArrayList <String>();
			meanings.add("talented");
			theWords.put(key, meanings);
			
			key = "gig";
			meanings = new ArrayList <String>();
			meanings.add("carriage");
			theWords.put(key, meanings);
			
			key = "gigantic";
			meanings = new ArrayList <String>();
			meanings.add("huge");
			theWords.put(key, meanings);
			
			key = "gill";
			meanings = new ArrayList <String>();
			meanings.add("small amount of drink");
			theWords.put(key, meanings);
			
			key = "gin";
			meanings = new ArrayList <String>();
			meanings.add("card game");
			meanings.add("drink");
			meanings.add("spirit");
			theWords.put(key, meanings);
			
			key = "ginger";
			meanings = new ArrayList <String>();
			meanings.add("light reddish-yellow");
			meanings.add("spice");
			theWords.put(key, meanings);
			
			key = "gins";
			meanings = new ArrayList <String>();
			meanings.add("drinks");
			meanings.add("spirits");
			theWords.put(key, meanings);
			
			key = "girl";
			meanings = new ArrayList <String>();
			meanings.add("young woman");
			theWords.put(key, meanings);
			
			key = "girls";
			meanings = new ArrayList <String>();
			meanings.add("young women");
			theWords.put(key, meanings);
			
			key = "gite";
			meanings = new ArrayList <String>();
			meanings.add("french cottage");
			theWords.put(key, meanings);

			key = "given";
			meanings = new ArrayList <String>();
			meanings.add("donated");
			theWords.put(key, meanings);
			
			key = "glacier";
			meanings = new ArrayList <String>();
			meanings.add("mass of ice");
			theWords.put(key, meanings);
			
			key = "glad";
			meanings = new ArrayList <String>();
			meanings.add("happy");
			meanings.add("pleased");
			theWords.put(key, meanings);
			
			key = "gladden";
			meanings = new ArrayList <String>();
			meanings.add("please");
			theWords.put(key, meanings);
			
			key = "glade";
			meanings = new ArrayList <String>();
			meanings.add("clearing");
			theWords.put(key, meanings);
					
			key = "glance";
			meanings = new ArrayList <String>();
			meanings.add("quick look");
			theWords.put(key, meanings);

			key = "gland";
			meanings = new ArrayList <String>();
			meanings.add("organ");
			theWords.put(key, meanings);
			
			key = "gleam";
			meanings = new ArrayList <String>();
			meanings.add("sparkle");
			theWords.put(key, meanings);
			
			key = "glen";
			meanings = new ArrayList <String>();
			meanings.add("narrow valley");
			meanings.add("valley");
			theWords.put(key, meanings);
			
			key = "glimpse";
			meanings = new ArrayList <String>();
			meanings.add("brief view");
			theWords.put(key, meanings);
			
			key = "glory";
			meanings = new ArrayList <String>();
			meanings.add("splendour");
			theWords.put(key, meanings);
			
			key = "gloves";
			meanings = new ArrayList <String>();
			meanings.add("catches");//cricket
			meanings.add("hand warmers");
			theWords.put(key, meanings);
			
			key = "glum";
			meanings = new ArrayList <String>();
			meanings.add("dejected");
			theWords.put(key, meanings);
			
			key = "glut";
			meanings = new ArrayList <String>();
			meanings.add("excess");
			theWords.put(key, meanings);
			
			key = "glutton";
			meanings = new ArrayList <String>();
			meanings.add("overeater");
			theWords.put(key, meanings);
			
			key = "gnu";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "go";
			meanings = new ArrayList <String>();
			meanings.add("leave");
			meanings.add("turn");
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "goal";
			meanings = new ArrayList <String>();
			meanings.add("aim");
			meanings.add("objective");
			meanings.add("plan");
			theWords.put(key, meanings);
			
			key = "goat";
			meanings = new ArrayList <String>();
			meanings.add("billy");
			theWords.put(key, meanings);
			
			key = "goalie";
			meanings = new ArrayList <String>();
			meanings.add("last line of defence");
			theWords.put(key, meanings);
			
			key = "gobi";
			meanings = new ArrayList <String>();
			meanings.add("desert");
			theWords.put(key, meanings);
			
			key = "god";
			meanings = new ArrayList <String>();
			meanings.add("deity");
			theWords.put(key, meanings);
			
			key = "godiva";
			meanings = new ArrayList <String>();
			meanings.add("Coventry lady");
			meanings.add("naked lady");
			theWords.put(key, meanings);
			
			key = "gofar"; // go far
			meanings = new ArrayList <String>();
			meanings.add("succeed");
			theWords.put(key, meanings);
			
			key = "going";
			meanings = new ArrayList <String>();
			meanings.add("leaving");
			theWords.put(key, meanings);
			
			key = "goldmedals";//gold medals
			meanings = new ArrayList <String>();
			meanings.add("first prizes");
			theWords.put(key, meanings);
			
			key = "golf";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);
			
			key = "gondola";
			meanings = new ArrayList <String>();
			meanings.add("boat");
			meanings.add("form of transport");
			theWords.put(key, meanings);
			
			key = "gondoliers";
			meanings = new ArrayList <String>();
			meanings.add("boatmen");
			theWords.put(key, meanings);
			
			key = "good";
			meanings = new ArrayList <String>();
			meanings.add("well-behaved");
			theWords.put(key, meanings);
					
			key = "gophers";
			meanings = new ArrayList <String>();
			meanings.add("burrowing rodents");
			theWords.put(key, meanings);
			
			key = "gorge";
			meanings = new ArrayList <String>();
			meanings.add("cheddar");
			meanings.add("eat too much");
			theWords.put(key, meanings);
			
			key = "gory";
			meanings = new ArrayList <String>();
			meanings.add("bloodbath");
			theWords.put(key, meanings);
			
			key = "gosling";
			meanings = new ArrayList <String>();
			meanings.add("little bird");
			theWords.put(key, meanings);
			
			key = "goslings";
			meanings = new ArrayList <String>();
			meanings.add("little birds");
			theWords.put(key, meanings);
			
			key = "gossip";
			meanings = new ArrayList <String>();
			meanings.add("tittle-tattle");
			theWords.put(key, meanings);
			
			key = "got";
			meanings = new ArrayList <String>();
			meanings.add("received");
			theWords.put(key, meanings);
			
			key = "grabbing";
			meanings = new ArrayList <String>();
			meanings.add("snatching");
			theWords.put(key, meanings);
			
			key = "grain";
			meanings = new ArrayList <String>();
			meanings.add("cereal crop");
			theWords.put(key, meanings);
			
			key = "grains";
			meanings = new ArrayList <String>();
			meanings.add("seeds");
			theWords.put(key, meanings);
			
			key = "gran";
			meanings = new ArrayList <String>();
			meanings.add("elderly relative");
			meanings.add("elderly woman");
			theWords.put(key, meanings);
			
			key = "granada";
			meanings = new ArrayList <String>();
			meanings.add("spanish city");
			theWords.put(key, meanings);
			
			key = "grapes";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "grasmere";
			meanings = new ArrayList <String>();
			meanings.add("lake");
			theWords.put(key, meanings);
			
			key = "grasp";
			meanings = new ArrayList <String>();
			meanings.add("get hold of");
			theWords.put(key, meanings);
					
			key = "grasshopper";
			meanings = new ArrayList <String>();
			meanings.add("little creature");
			theWords.put(key, meanings);

			key = "grate";
			meanings = new ArrayList <String>();
			meanings.add("irritate");
			meanings.add("shred");
			theWords.put(key, meanings);
			
			key = "grave";
			meanings = new ArrayList <String>();
			meanings.add("resting place");
			meanings.add("serious");
			theWords.put(key, meanings);
			
			key = "gravel";
			meanings = new ArrayList <String>();
			meanings.add("stones");
			theWords.put(key, meanings);
			
			key = "gravestone";
			meanings = new ArrayList <String>();
			meanings.add("memorial");
			theWords.put(key, meanings);
				
			key = "grease";
			meanings = new ArrayList <String>();
			meanings.add("lubricate");
			meanings.add("musical");
			meanings.add("oil");
			theWords.put(key, meanings);
			
			key = "great";
			meanings = new ArrayList <String>();
			meanings.add("wonderful");
			theWords.put(key, meanings);
			
			key = "green";
			meanings = new ArrayList <String>();
			meanings.add("caring for the environment");
			meanings.add("colour");
			meanings.add("lacking experience");
			theWords.put(key, meanings);
			
			key = "greenfinch";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "greenfly";
			meanings = new ArrayList <String>();
			meanings.add("garden pests");
			theWords.put(key, meanings);
			
			key = "greet";
			meanings = new ArrayList <String>();
			meanings.add("cry");
			meanings.add("welcome");
			theWords.put(key, meanings);
					
			key = "grenada";
			meanings = new ArrayList <String>();
			meanings.add("Caribbean island");
			theWords.put(key, meanings);
			
			key = "grenade";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);
			
			key = "grenadier";
			meanings = new ArrayList <String>();
			meanings.add("soldier");
			theWords.put(key, meanings);
			
			key = "greta";
			meanings = new ArrayList <String>();
			meanings.add("Garbo");
			theWords.put(key, meanings);
			
			key = "grief";
			meanings = new ArrayList <String>();
			meanings.add("sorrow");
			theWords.put(key, meanings);
			
			key = "grill";
			meanings = new ArrayList <String>();
			meanings.add("cook");
			theWords.put(key, meanings);
					
			key = "grim";
			meanings = new ArrayList <String>();
			meanings.add("miserable");
			theWords.put(key, meanings);
			
			key = "grin";
			meanings = new ArrayList <String>();
			meanings.add("smile");
			theWords.put(key, meanings);
			
			key = "grins";
			meanings = new ArrayList <String>();
			meanings.add("smiles");
			theWords.put(key, meanings);
			
			key = "grind";
			meanings = new ArrayList <String>();
			meanings.add("hard work");
			theWords.put(key, meanings);
			
			key = "grit";
			meanings = new ArrayList <String>();
			meanings.add("courage");
			theWords.put(key, meanings);
			
			key = "groan";
			meanings = new ArrayList <String>();
			meanings.add("whine");
			theWords.put(key, meanings);
			
			key = "groom";
			meanings = new ArrayList <String>();
			meanings.add("stable boy");
			theWords.put(key, meanings);
			
			key = "grooms";
			meanings = new ArrayList <String>();
			meanings.add("stable men");
			theWords.put(key, meanings);
			
			key = "grounds";
			meanings = new ArrayList <String>();
			meanings.add("justifications");
			meanings.add("reasons");
			theWords.put(key, meanings);
			
			key = "groundsel";
			meanings = new ArrayList <String>();
			meanings.add("common weed");
			theWords.put(key, meanings);
			
			key = "groundswell";
			meanings = new ArrayList <String>();
			meanings.add("increase in public opinion");
			theWords.put(key, meanings);
			
			key = "grouse";
			meanings = new ArrayList <String>();
			meanings.add("game bird");
			theWords.put(key, meanings);
			
			key = "grow";
			meanings = new ArrayList <String>();
			meanings.add("expand");
			theWords.put(key, meanings);
			
			key = "guard";
			meanings = new ArrayList <String>();
			meanings.add("look out");
			theWords.put(key, meanings);
			
			key = "guess";
			meanings = new ArrayList <String>();
			meanings.add("conjecture");
			meanings.add("estimate");
			meanings.add("predict");
			meanings.add("prediction");
			meanings.add("theory");
			theWords.put(key, meanings);
			
			key = "guide";
			meanings = new ArrayList <String>();
			meanings.add("direct");
			meanings.add("mentor");
			theWords.put(key, meanings);
			
			key = "guideline";
			meanings = new ArrayList <String>();
			meanings.add("direction");
			meanings.add("recommendation");
			theWords.put(key, meanings);
			
			key = "gum";
			meanings = new ArrayList <String>();
			meanings.add("something sticky");
			meanings.add("sticky substance");
			theWords.put(key, meanings);
			
			key = "gunboat";
			meanings = new ArrayList <String>();
			meanings.add("armed vessel");
			theWords.put(key, meanings);
			
			key = "gush";
			meanings = new ArrayList <String>();
			meanings.add("show profuse admiration");
			theWords.put(key, meanings);

			return theWords;
		}//end loadG
		
		public void loadHWords() {
			String key;
			ArrayList <String> meanings;
			
			// load h's
			key = "habitual";
			meanings = new ArrayList <String>();
			meanings.add("customary");
			theWords.put(key, meanings);
					
			key = "had";
			meanings = new ArrayList <String>();
			meanings.add("tricked");
			theWords.put(key, meanings);
			
			key = "haddock";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "hag";
			meanings = new ArrayList <String>();
			meanings.add("witch");
			theWords.put(key, meanings);
			
			key = "haggis";
			meanings = new ArrayList <String>();
			meanings.add("Scottish food");
			theWords.put(key, meanings);
			
			key = "half";
			meanings = new ArrayList <String>();
			meanings.add("fifty percent");
			theWords.put(key, meanings);
			
			key = "halibut";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "hall";
			meanings = new ArrayList <String>();
			meanings.add("room");
			theWords.put(key, meanings);
			
			key = "hallowed";
			meanings = new ArrayList <String>();
			meanings.add("consecrated");
			theWords.put(key, meanings);
			
			key = "halt";
			meanings = new ArrayList <String>();
			meanings.add("stop");
			theWords.put(key, meanings);
			
			key = "ham";
			meanings = new ArrayList <String>();
			meanings.add("bad actor");
			meanings.add("meat");
			theWords.put(key, meanings);
			
			key = "hamlet";
			meanings = new ArrayList <String>();
			meanings.add("play");
			meanings.add("shakespearean production");
			meanings.add("small village");
			theWords.put(key, meanings);
			
			key = "hamper";
			meanings = new ArrayList <String>();
			meanings.add("basket");
			meanings.add("picnic basket");
			theWords.put(key, meanings);
			
			key = "hams";
			meanings = new ArrayList <String>();
			meanings.add("one of Noah's sons");
			theWords.put(key, meanings);
			
			key = "hand";
			meanings = new ArrayList <String>();
			meanings.add("worker");
			theWords.put(key, meanings);
			
			key = "handicap";
			meanings = new ArrayList <String>();
			meanings.add("drawback");
			theWords.put(key, meanings);
			
			key = "handsome";
			meanings = new ArrayList <String>();
			meanings.add("good-looking");
			theWords.put(key, meanings);
			
			key = "hanky";
			meanings = new ArrayList <String>();
			meanings.add("handkerchief");
			theWords.put(key, meanings);
			
			key = "hanoi";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			theWords.put(key, meanings);
			
			key = "hants";
			meanings = new ArrayList <String>();
			meanings.add("Hampshire");
			theWords.put(key, meanings);
			
			key = "happy";
			meanings = new ArrayList <String>();
			meanings.add("delighted");
			theWords.put(key, meanings);
			
			key = "hard";
			meanings = new ArrayList <String>();
			meanings.add("difficult");
			theWords.put(key, meanings);

			key = "hardship";
			meanings = new ArrayList <String>();
			meanings.add("poverty");
			theWords.put(key, meanings);

			key = "hark";
			meanings = new ArrayList <String>();
			meanings.add("listen");
			theWords.put(key, meanings);
					
			key = "harm";
			meanings = new ArrayList <String>();
			meanings.add("damage");
			meanings.add("injure");
			theWords.put(key, meanings);
			
			key = "harmed";
			meanings = new ArrayList <String>();
			meanings.add("injured");
			theWords.put(key, meanings);
			
			key = "harmless";
			meanings = new ArrayList <String>();
			meanings.add("benign");
			theWords.put(key, meanings);
			
			key = "harpist";
			meanings = new ArrayList <String>();
			meanings.add("musician");
			theWords.put(key, meanings);
			
			key = "harrow";
			meanings = new ArrayList <String>();
			meanings.add("london borough");
			theWords.put(key, meanings);
			
			key = "has";
			meanings = new ArrayList <String>();
			meanings.add("possesses");
			theWords.put(key, meanings);
			
			key = "hassle";
			meanings = new ArrayList <String>();
			meanings.add("bother");
			theWords.put(key, meanings);
			
			key = "hastings";
			meanings = new ArrayList <String>();
			meanings.add("battle");
			theWords.put(key, meanings);
			
			key = "hasty";
			meanings = new ArrayList <String>();
			meanings.add("quick");
			theWords.put(key, meanings);
			
			key = "hat";
			meanings = new ArrayList <String>();
			meanings.add("headwear");
			theWords.put(key, meanings);
			
			key = "hats";
			meanings = new ArrayList <String>();
			meanings.add("headwear");
			theWords.put(key, meanings);
					
			key = "have";
			meanings = new ArrayList <String>();
			meanings.add("own");
			theWords.put(key, meanings);
			
			key = "haven";
			meanings = new ArrayList <String>();
			meanings.add("retreat");
			theWords.put(key, meanings);
			
			key = "hawthorn";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);
			
			key = "he";
			meanings = new ArrayList <String>();
			meanings.add("a man");
			meanings.add("male");
			meanings.add("the man");
			theWords.put(key, meanings);
			
			key = "head";
			meanings = new ArrayList <String>();
			meanings.add("boss");
			meanings.add("part of the body");
			meanings.add("lead");
			meanings.add("principle");
			meanings.add("source of a river");
			meanings.add("top of a beer");
			theWords.put(key, meanings);
			
			key = "headstrong";
			meanings = new ArrayList <String>();
			meanings.add("self-willed");
			theWords.put(key, meanings);
			
			key = "hear";
			meanings = new ArrayList <String>();
			meanings.add("catch");
			theWords.put(key, meanings);
			
			key = "heal";
			meanings = new ArrayList <String>();
			meanings.add("cure");
			theWords.put(key, meanings);
			
			key = "healthy";
			meanings = new ArrayList <String>();
			meanings.add("sound");
			theWords.put(key, meanings);
			
			key = "heart";
			meanings = new ArrayList <String>();
			meanings.add("centre");
			meanings.add("organ");
			theWords.put(key, meanings);
			
			key = "hearten";
			meanings = new ArrayList <String>();
			meanings.add("cheer");
			theWords.put(key, meanings);
			
			key = "heartily";
			meanings = new ArrayList <String>();
			meanings.add("thoroughly");
			theWords.put(key, meanings);
			
			key = "heartless";
			meanings = new ArrayList <String>();
			meanings.add("cruel");
			theWords.put(key, meanings);
			
			key = "heat";
			meanings = new ArrayList <String>();
			meanings.add("passion");
			meanings.add("warmth");
			theWords.put(key, meanings);
			
			key = "heated";
			meanings = new ArrayList <String>();
			meanings.add("passionate");
			meanings.add("warmed");
			theWords.put(key, meanings);
			
			key = "heathen";
			meanings = new ArrayList <String>();
			meanings.add("pagan");
			theWords.put(key, meanings);
			
			key = "heel";
			meanings = new ArrayList <String>();
			meanings.add("part of the foot");
			meanings.add("shoe part");
			theWords.put(key, meanings);
			
			key = "heels";
			meanings = new ArrayList <String>();
			meanings.add("parts of the foot");
			meanings.add("shoe parts");
			theWords.put(key, meanings);
			
			key = "held";
			meanings = new ArrayList <String>();
			meanings.add("grasped");
			theWords.put(key, meanings);
			
			key = "hello";
			meanings = new ArrayList <String>();
			meanings.add("greeting");
			theWords.put(key, meanings);
			
			key = "helm";
			meanings = new ArrayList <String>();
			meanings.add("ship's steering gear");
			theWords.put(key, meanings);
			
			key = "helmet";
			meanings = new ArrayList <String>();
			meanings.add("protective cover");
			theWords.put(key, meanings);
			
			key = "helpers";
			meanings = new ArrayList <String>();
			meanings.add("assistants");
			theWords.put(key, meanings);
			
			key = "hem";
			meanings = new ArrayList <String>();
			meanings.add("border");
			theWords.put(key, meanings);
			
			key = "hen";
			meanings = new ArrayList <String>();
			meanings.add("fowl");
			theWords.put(key, meanings);
			
			key = "hens";
			meanings = new ArrayList <String>();
			meanings.add("birds");
			theWords.put(key, meanings);
			
			key = "her";
			meanings = new ArrayList <String>();
			meanings.add("part of title");
			theWords.put(key, meanings);
			
			key = "herbal";
			meanings = new ArrayList <String>();
			meanings.add("type of tea");
			theWords.put(key, meanings);
			
			key = "here";
			meanings = new ArrayList <String>();
			meanings.add("in this place");
			theWords.put(key, meanings);
			
			key = "hereford";
			meanings = new ArrayList <String>();
			meanings.add("cathedral city");
			theWords.put(key, meanings);
			
			key = "hermes";
			meanings = new ArrayList <String>();
			meanings.add("Olympian messenger");
			theWords.put(key, meanings);
			
			key = "hermit";
			meanings = new ArrayList <String>();
			meanings.add("recluse");
			theWords.put(key, meanings);
			
			key = "hesitant";
			meanings = new ArrayList <String>();
			meanings.add("unsure");
			theWords.put(key, meanings);
			
			key = "hide";
			meanings = new ArrayList <String>();
			meanings.add("conceal");
			meanings.add("skin");
			theWords.put(key, meanings);
			
			key = "hideout";
			meanings = new ArrayList <String>();
			meanings.add("secret place");
			theWords.put(key, meanings);
			
			key = "hiding";
			meanings = new ArrayList <String>();
			meanings.add("beating");
			theWords.put(key, meanings);
					
			key = "high";
			meanings = new ArrayList <String>();
			meanings.add("lofty");
			theWords.put(key, meanings);
			
			key = "hill";
			meanings = new ArrayList <String>();
			meanings.add("high ground");
			theWords.put(key, meanings);
			
			key = "hind";
			meanings = new ArrayList <String>();
			meanings.add("back");
			theWords.put(key, meanings);
			
			key = "hindi";
			meanings = new ArrayList <String>();
			meanings.add("language");
			theWords.put(key, meanings);
			
			key = "hinge";
			meanings = new ArrayList <String>();
			meanings.add("entirely depend on");
			meanings.add("joint");
			theWords.put(key, meanings);
			
			key = "hint";
			meanings = new ArrayList <String>();
			meanings.add("clue");
			theWords.put(key, meanings);
			
			key = "hip";
			meanings = new ArrayList <String>();
			meanings.add("trendy");
			theWords.put(key, meanings);
			
			key = "hippo";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "his";
			meanings = new ArrayList <String>();
			meanings.add("belonging to him");
			theWords.put(key, meanings);
			
			key = "historical";
			meanings = new ArrayList <String>();
			meanings.add("old");
			theWords.put(key, meanings);
			
			key = "hit";
			meanings = new ArrayList <String>();
			meanings.add("beat");
			meanings.add("punch");
			meanings.add("punched");
			meanings.add("slap");
			meanings.add("slapped");
			meanings.add("thump");
			meanings.add("thumped");
			theWords.put(key, meanings);
			
			key = "hive";
			meanings = new ArrayList <String>();
			meanings.add("bee colony");
			theWords.put(key, meanings);
			
			key = "history";
			meanings = new ArrayList <String>();
			meanings.add("past events");
			theWords.put(key, meanings);
			
			key = "hobart";
			meanings = new ArrayList <String>();
			meanings.add("Tasmanian city");
			theWords.put(key, meanings);
			
			key = "hock";
			meanings = new ArrayList <String>();
			meanings.add("German wine");
			theWords.put(key, meanings);
					
			key = "hockey";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);
			
			key = "hog";
			meanings = new ArrayList <String>();
			meanings.add("swine");
			theWords.put(key, meanings);
			
			key = "hold";
			meanings = new ArrayList <String>();
			meanings.add("grasp");
			theWords.put(key, meanings);
			
			key = "holdall";
			meanings = new ArrayList <String>();
			meanings.add("bag");
			theWords.put(key, meanings);
			
			key = "hole";
			meanings = new ArrayList <String>();
			meanings.add("opening");
			theWords.put(key, meanings);
			
			key = "home";
			meanings = new ArrayList <String>();
			meanings.add("place of care");
			theWords.put(key, meanings);
			
			key = "hone";
			meanings = new ArrayList <String>();
			meanings.add("refine");
			theWords.put(key, meanings);
			
			key = "honestly";
			meanings = new ArrayList <String>();
			meanings.add("truethful way");
			theWords.put(key, meanings);
			
			key = "honey";
			meanings = new ArrayList <String>();
			meanings.add("darling");
			meanings.add("sweetheart");
			theWords.put(key, meanings);
			
			key = "honeysuckle";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);
					
			key = "honour";
			meanings = new ArrayList <String>();
			meanings.add("respect");
			theWords.put(key, meanings);
			
			key = "hoods";
			meanings = new ArrayList <String>();
			meanings.add("coverings");
			theWords.put(key, meanings);
			
			key = "hop";
			meanings = new ArrayList <String>();
			meanings.add("beer ingredient");
			theWords.put(key, meanings);
			
			key = "hope";
			meanings = new ArrayList <String>();
			meanings.add("want something to happen");
			theWords.put(key, meanings);
			
			key = "hopper";
			meanings = new ArrayList <String>();
			meanings.add("container");
			theWords.put(key, meanings);
			
			key = "hops";
			meanings = new ArrayList <String>();
			meanings.add("jumps");
			theWords.put(key, meanings);
					
			key = "hopscotch";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);
			
			key = "horn";
			meanings = new ArrayList <String>();
			meanings.add("source of blast");
			theWords.put(key, meanings);
			
			key = "hornpipe";
			meanings = new ArrayList <String>();
			meanings.add("sailor's dance");
			theWords.put(key, meanings);
			
			key = "hornsea";
			meanings = new ArrayList <String>();
			meanings.add("seaside resort");
			theWords.put(key, meanings);
			
			key = "hospital";
			meanings = new ArrayList <String>();
			meanings.add("imfirmary");
			theWords.put(key, meanings);
			
			key = "hot";
			meanings = new ArrayList <String>();
			meanings.add("stolen");
			meanings.add("very warm");
			theWords.put(key, meanings);
			
			key = "hotcakes"; //hot cakes
			meanings = new ArrayList <String>();
			meanings.add("best sellers");
			theWords.put(key, meanings);
			
			key = "hotdogs";
			meanings = new ArrayList <String>();
			meanings.add("food");
			theWords.put(key, meanings);
			
			key = "hotel";
			meanings = new ArrayList <String>();
			meanings.add("accommodation");
			theWords.put(key, meanings);
			
			key = "hottest";
			meanings = new ArrayList <String>();
			meanings.add("spiciest");
			theWords.put(key, meanings);
					
			key = "hour";
			meanings = new ArrayList <String>();
			meanings.add("time");
			theWords.put(key, meanings);
			
			key = "hovel";
			meanings = new ArrayList <String>();
			meanings.add("insanitary dwelling");
			meanings.add("squalid dwelling");
			theWords.put(key, meanings);
			
			key = "how";
			meanings = new ArrayList <String>();
			meanings.add("in what way");
			theWords.put(key, meanings);
			
			key = "hound";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			meanings.add("relentlessly pursue");
			theWords.put(key, meanings);
			
			key = "hounds";
			meanings = new ArrayList <String>();
			meanings.add("dogs");
			meanings.add("relentlessly pursues");
			theWords.put(key, meanings);
			
			key = "hudson";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "hug";
			meanings = new ArrayList <String>();
			meanings.add("embrace");
			theWords.put(key, meanings);
			
			key = "huge";
			meanings = new ArrayList <String>();
			meanings.add("giant");
			theWords.put(key, meanings);
			
			key = "hugs";
			meanings = new ArrayList <String>();
			meanings.add("embraces");
			theWords.put(key, meanings);
			
			key = "human";
			meanings = new ArrayList <String>();
			meanings.add("person");
			theWords.put(key, meanings);
			
			key = "hung";
			meanings = new ArrayList <String>();
			meanings.add("draped");
			theWords.put(key, meanings);
			
			key = "husbands";
			meanings = new ArrayList <String>();
			meanings.add("married men");
			theWords.put(key, meanings);
			
			key = "hustle";
			meanings = new ArrayList <String>();
			meanings.add("jostle");
			theWords.put(key, meanings);
			
			key = "hustlers";
			meanings = new ArrayList <String>();
			meanings.add("aggressive sellers");
			theWords.put(key, meanings);
			
			key = "hut";
			meanings = new ArrayList <String>();
			meanings.add("cabin");
			meanings.add("shak");
			meanings.add("shed");
			meanings.add("shelter");
			theWords.put(key, meanings);
			
			key = "hydro";
			meanings = new ArrayList <String>();
			meanings.add("spa hotel");
			theWords.put(key, meanings);
			
			key = "hydrogen";
			meanings = new ArrayList <String>();
			meanings.add("gas");
			theWords.put(key, meanings);

		}//end loadH
		
		public void loadIWords() {
			String key;
			ArrayList <String> meanings;
			
			// load i's
			key = "i";
			meanings = new ArrayList <String>();
			meanings.add("the ninth letter of the alphabet");
			theWords.put(key, meanings);
			
			key = "iberia";
			meanings = new ArrayList <String>();
			meanings.add("peninsula");
			theWords.put(key, meanings);
			
			key = "ice";
			meanings = new ArrayList <String>();
			meanings.add("frozen water");
			theWords.put(key, meanings);
			
			key = "icecap";
			meanings = new ArrayList <String>();
			meanings.add("covering");
			theWords.put(key, meanings);
			
			key = "iced";
			meanings = new ArrayList <String>();
			meanings.add("frozen");
			theWords.put(key, meanings);
			
			key = "iceland";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "icy";
			meanings = new ArrayList <String>();
			meanings.add("chilling");
			meanings.add("very cold");
			theWords.put(key, meanings);
			
			key = "idea";
			meanings = new ArrayList <String>();
			meanings.add("brainwave");
			meanings.add("inkling");
			meanings.add("thought");
			theWords.put(key, meanings);
			
			key = "ideal";
			meanings = new ArrayList <String>();
			meanings.add("just the job");
			meanings.add("perfect");
			theWords.put(key, meanings);
			
			key = "idealise";
			meanings = new ArrayList <String>();
			meanings.add("regard as perfect");
			theWords.put(key, meanings);
			
			key = "ideally";
			meanings = new ArrayList <String>();
			meanings.add("perfectly");
			theWords.put(key, meanings);
			
			key = "idea";
			meanings = new ArrayList <String>();
			meanings.add("brainwaves");
			meanings.add("inklings");
			meanings.add("thoughts");
			theWords.put(key, meanings);
			
			key = "idiom";
			meanings = new ArrayList <String>();
			meanings.add("regional speech");
			theWords.put(key, meanings);
			
			key = "idiot";
			meanings = new ArrayList <String>();
			meanings.add("fool");
			theWords.put(key, meanings);
			
			key = "idle";
			meanings = new ArrayList <String>();
			meanings.add("doing nothing");
			theWords.put(key, meanings);
			
			key = "idled";
			meanings = new ArrayList <String>();
			meanings.add("didn't work");
			theWords.put(key, meanings);
			
			key = "idles";
			meanings = new ArrayList <String>();
			meanings.add("does nothing");
			meanings.add("doesn't work");
			theWords.put(key, meanings);
			
			key = "idol";
			meanings = new ArrayList <String>();
			meanings.add("object of desire");
			theWords.put(key, meanings);
			
			key = "idols";
			meanings = new ArrayList <String>();
			meanings.add("images");
			meanings.add("objects of desire");
			theWords.put(key, meanings);
				
			key = "if";
			meanings = new ArrayList <String>();
			meanings.add("despite");
			theWords.put(key, meanings);
			
			key = "ignites";
			meanings = new ArrayList <String>();
			meanings.add("lights");
			theWords.put(key, meanings);
			
			key = "ignore";
			meanings = new ArrayList <String>();
			meanings.add("disregard");
			meanings.add("take no notice of");
			theWords.put(key, meanings);
			
			key = "ilk";
			meanings = new ArrayList <String>();
			meanings.add("kind");
			theWords.put(key, meanings);
			
			key = "ill";
			meanings = new ArrayList <String>();
			meanings.add("not fit");
			meanings.add("sick");
			meanings.add("unwell");
			theWords.put(key, meanings);
			
			key = "images";
			meanings = new ArrayList <String>();
			meanings.add("pictures");
			meanings.add("visions");
			theWords.put(key, meanings);
			
			key = "imagination";
			meanings = new ArrayList <String>();
			meanings.add("vision");
			theWords.put(key, meanings);
			
			key = "imagine";
			meanings = new ArrayList <String>();
			meanings.add("dream up");
			theWords.put(key, meanings);
			
			key = "immediate";
			meanings = new ArrayList <String>();
			meanings.add("without delay");
			theWords.put(key, meanings);
			
			key = "immense";
			meanings = new ArrayList <String>();
			meanings.add("huge");
			theWords.put(key, meanings);
			
			key = "immoral";
			meanings = new ArrayList <String>();
			meanings.add("corrupt");
			theWords.put(key, meanings);
			
			key = "immortal";
			meanings = new ArrayList <String>();
			meanings.add("death-defying");
			theWords.put(key, meanings);
			
			key = "imp";
			meanings = new ArrayList <String>();
			meanings.add("little devil");
			meanings.add("naughty child");
			meanings.add("rascal");
			theWords.put(key, meanings);
			
			key = "impact";
			meanings = new ArrayList <String>();
			meanings.add("have an effect");
			theWords.put(key, meanings);
			
			key = "impair";
			meanings = new ArrayList <String>();
			meanings.add("cause damage");
			theWords.put(key, meanings);
			
			key = "impala";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "impart";
			meanings = new ArrayList <String>();
			meanings.add("communicate");
			theWords.put(key, meanings);
			
			key = "impend";
			meanings = new ArrayList <String>();
			meanings.add("threaten");
			theWords.put(key, meanings);
			
			key = "impetus";
			meanings = new ArrayList <String>();
			meanings.add("drive");
			theWords.put(key, meanings);
			
			key = "impulse";
			meanings = new ArrayList <String>();
			meanings.add("sudden urge");
			theWords.put(key, meanings);
			
			key = "in";
			meanings = new ArrayList <String>();
			//meanings.add("in");
			meanings.add("at home");
			meanings.add("fashionable");
			meanings.add("popular");
			theWords.put(key, meanings);
				
			key = "inadvertent";
			meanings = new ArrayList <String>();
			meanings.add("unintentional");
			theWords.put(key, meanings);
			
			key = "inane";
			meanings = new ArrayList <String>();
			meanings.add("silly");
			theWords.put(key, meanings);
			
			key = "inca";
			meanings = new ArrayList <String>();
			meanings.add("ancient Peruvian");
			theWords.put(key, meanings);
			
			key = "inch";
			meanings = new ArrayList <String>();
			meanings.add("move along slowly");
			meanings.add("small measure");
			theWords.put(key, meanings);
			
			key = "increase";
			meanings = new ArrayList <String>();
			meanings.add("additional pay");
			meanings.add("grow bigger");
			theWords.put(key, meanings);
			
			key = "indecorous";
			meanings = new ArrayList <String>();
			meanings.add("improper");
			theWords.put(key, meanings);
			
			key = "infant";
			meanings = new ArrayList <String>();
			meanings.add("child");
			theWords.put(key, meanings);
			
			key = "infantry";
			meanings = new ArrayList <String>();
			meanings.add("troops");
			theWords.put(key, meanings);
			
			key = "india";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "indian";
			meanings = new ArrayList <String>();
			meanings.add("take-away");
			theWords.put(key, meanings);
			
			key = "indiana";
			meanings = new ArrayList <String>();
			meanings.add("US state");
			theWords.put(key, meanings);
				
			key = "indulge";
			meanings = new ArrayList <String>();
			meanings.add("give way to urges");
			theWords.put(key, meanings);
			
			key = "inept";
			meanings = new ArrayList <String>();
			meanings.add("ham fisted");
			meanings.add("useless");
			theWords.put(key, meanings);
			
			key = "inert";
			meanings = new ArrayList <String>();
			meanings.add("not reacting");
			theWords.put(key, meanings);
			
			key = "inexact";
			meanings = new ArrayList <String>();
			meanings.add("not precise");
			theWords.put(key, meanings);
			
			key = "infidel";
			meanings = new ArrayList <String>();
			meanings.add("heathen");
			theWords.put(key, meanings);
			
			key = "ingot";
			meanings = new ArrayList <String>();
			meanings.add("piece of gold");
			theWords.put(key, meanings);
			
			key = "ingots";
			meanings = new ArrayList <String>();
			meanings.add("metal blocks");
			meanings.add("pieces of gold");
			theWords.put(key, meanings);
			
			key = "ingress";
			meanings = new ArrayList <String>();
			meanings.add("entrance");
			theWords.put(key, meanings);
					
			key = "inhuman";
			meanings = new ArrayList <String>();
			meanings.add("barbaric");
			theWords.put(key, meanings);
			
			key = "inmate";
			meanings = new ArrayList <String>();
			meanings.add("prisoner");
			theWords.put(key, meanings);
			
			key = "inn";
			meanings = new ArrayList <String>();
			meanings.add("boozer");
			meanings.add("tavern");
			theWords.put(key, meanings);
				
			key = "insane";
			meanings = new ArrayList <String>();
			meanings.add("mad");
			theWords.put(key, meanings);
			
			key = "insect";
			meanings = new ArrayList <String>();
			meanings.add("creepy crawly");
			theWords.put(key, meanings);
			
			key = "inserted";
			meanings = new ArrayList <String>();
			meanings.add("put in");
			theWords.put(key, meanings);
			
			key = "intact";
			meanings = new ArrayList <String>();
			meanings.add("whole");
			theWords.put(key, meanings);
			
			key = "integral";
			meanings = new ArrayList <String>();
			meanings.add("necessary");
			theWords.put(key, meanings);
					
			key = "integrity";
			meanings = new ArrayList <String>();
			meanings.add("honesty");
			theWords.put(key, meanings);
					
			key = "intend";
			meanings = new ArrayList <String>();
			meanings.add("mean");
			theWords.put(key, meanings);
			
			key = "intended";
			meanings = new ArrayList <String>();
			meanings.add("meant to be");
			theWords.put(key, meanings);
					
			key = "inter";
			meanings = new ArrayList <String>();
			meanings.add("bury");
			theWords.put(key, meanings);
			
			key = "interval";
			meanings = new ArrayList <String>();
			meanings.add("break");
			theWords.put(key, meanings);
			
			key = "into";
			meanings = new ArrayList <String>();
			meanings.add("keen on");
			theWords.put(key, meanings);
			
			key = "intrepid";
			meanings = new ArrayList <String>();
			meanings.add("daring");
			theWords.put(key, meanings);
					
			key = "intro";
			meanings = new ArrayList <String>();
			meanings.add("preliminary section");
			theWords.put(key, meanings);
			
			key = "invader";
			meanings = new ArrayList <String>();
			meanings.add("attacker");
			theWords.put(key, meanings);
			
			key = "inverse";
			meanings = new ArrayList <String>();
			meanings.add("opposite");
			theWords.put(key, meanings);
			
			key = "iota";
			meanings = new ArrayList <String>();
			meanings.add("letter");
			theWords.put(key, meanings);
			
			key = "iran";
			meanings = new ArrayList <String>();
			meanings.add("country");
			meanings.add("Persia, some time ago");
			theWords.put(key, meanings);
			
			key = "ire";
			meanings = new ArrayList <String>();
			meanings.add("anger");
			meanings.add("wrath");
			meanings.add("fury");
			meanings.add("rage");
			theWords.put(key, meanings);
			
			key = "iron";
			meanings = new ArrayList <String>();
			meanings.add("metal");
			theWords.put(key, meanings);
			
			key = "irony";
			meanings = new ArrayList <String>();
			meanings.add("like metal");
			meanings.add("sarcastic wit");
			theWords.put(key, meanings);
			
			key = "iris";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			meanings.add("woman");
			theWords.put(key, meanings);	
			
			key = "irish";
			meanings = new ArrayList <String>();
			meanings.add("from Dublin");
			theWords.put(key, meanings);	
			
			key = "is";
			meanings = new ArrayList <String>();
			meanings.add("third person singular present of be");
			theWords.put(key, meanings);
			
			key = "isaac";
			meanings = new ArrayList <String>();
			meanings.add("son of Abraham");
			theWords.put(key, meanings);
			
			key = "islay";
			meanings = new ArrayList <String>();
			meanings.add("island");
			meanings.add("Scottish island");
			theWords.put(key, meanings);
			
			key = "it";
			meanings = new ArrayList <String>();
			meanings.add("the thing");
			meanings.add("thing");
			theWords.put(key, meanings);		
			
			key = "item";
			meanings = new ArrayList <String>();
			meanings.add("object");
			meanings.add("thing");
			theWords.put(key, meanings);
			
			key = "items";
			meanings = new ArrayList <String>();
			meanings.add("objects");
			meanings.add("things");
			theWords.put(key, meanings);

		}//end loadI
		
		public void loadJWords() {
			String key;
			ArrayList <String> meanings;
			
			// load j's
			key = "jack";
			meanings = new ArrayList <String>();
			meanings.add("knave");
			theWords.put(key, meanings);
			
			key = "jackpot";
			meanings = new ArrayList <String>();
			meanings.add("big winnings");
			theWords.put(key, meanings);
			
			key = "jacks";
			meanings = new ArrayList <String>();
			meanings.add("cards");
			meanings.add("devices for lifting");
			theWords.put(key, meanings);
			
			key = "jail";
			meanings = new ArrayList <String>();
			meanings.add("prison");
			theWords.put(key, meanings);
			
			key = "jet";
			meanings = new ArrayList <String>();
			meanings.add("black");
			meanings.add("stream of liquid");
			theWords.put(key, meanings);
			
			key = "jets";
			meanings = new ArrayList <String>();
			meanings.add("streams");
			theWords.put(key, meanings);
			
			key = "jetsam";
			meanings = new ArrayList <String>();
			meanings.add("what's thrown overboard");
			theWords.put(key, meanings);
					
			key = "jig";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "jigsaw";
			meanings = new ArrayList <String>();
			meanings.add("puzzle");
			theWords.put(key, meanings);
			
			key = "joke";
			meanings = new ArrayList <String>();
			meanings.add("gag");
			theWords.put(key, meanings);
			
			key = "joker";
			meanings = new ArrayList <String>();
			meanings.add("prankster");
			theWords.put(key, meanings);
			
			key = "joust";
			meanings = new ArrayList <String>();
			meanings.add("old contest");
			theWords.put(key, meanings);
			
			key = "joys";
			meanings = new ArrayList <String>();
			meanings.add("delights");
			theWords.put(key, meanings);
			
			key = "joystick";
			meanings = new ArrayList <String>();
			meanings.add("aircraft controller");
			theWords.put(key, meanings);
			
			key = "jumble";
			meanings = new ArrayList <String>();
			meanings.add("mix up");
			meanings.add("unwanted household goods");
			theWords.put(key, meanings);
			
			key = "just";
			meanings = new ArrayList <String>();
			meanings.add("only");
			theWords.put(key, meanings);

		}//end loadJ
		
		public void loadKWords() {
			String key;
			ArrayList <String> meanings;
			
			// load k's
			key = "kale";
			meanings = new ArrayList <String>();
			meanings.add("cabbage");
			theWords.put(key, meanings);
			
			key = "keats";
			meanings = new ArrayList <String>();
			meanings.add("poet");
			theWords.put(key, meanings);
			
			key = "kebab";
			meanings = new ArrayList <String>();
			meanings.add("something to eat");
			theWords.put(key, meanings);
			
			key = "keel";
			meanings = new ArrayList <String>();
			meanings.add("part of ship");
			theWords.put(key, meanings);
			
			key = "keep";
			meanings = new ArrayList <String>();
			meanings.add("retain");
			theWords.put(key, meanings);
			
			key = "keg";
			meanings = new ArrayList <String>();
			meanings.add("vessel");
			theWords.put(key, meanings);
			
			key = "ken";
			meanings = new ArrayList <String>();
			meanings.add("little Kenneth");
			theWords.put(key, meanings);
			
			key = "kendo";
			meanings = new ArrayList <String>();
			meanings.add("Japanese martial arts");
			theWords.put(key, meanings);
					
			key = "kenya";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "ketch";
			meanings = new ArrayList <String>();
			meanings.add("boat");
			theWords.put(key, meanings);
			
			key = "key";
			meanings = new ArrayList <String>();
			meanings.add("vitally important");
			theWords.put(key, meanings);
			
			key = "kids";
			meanings = new ArrayList <String>();
			meanings.add("children");
			theWords.put(key, meanings);
			
			key = "killed";
			meanings = new ArrayList <String>();
			meanings.add("bumped off");
			theWords.put(key, meanings);
			
			key = "kin";
			meanings = new ArrayList <String>();
			meanings.add("family");
			meanings.add("relatives");
			theWords.put(key, meanings);
			
			key = "kind";
			meanings = new ArrayList <String>();
			meanings.add("sort");
			meanings.add("variety");
			theWords.put(key, meanings);
			
			key = "kindle";
			meanings = new ArrayList <String>();
			meanings.add("arouse");
			theWords.put(key, meanings);
			
			key = "king";
			meanings = new ArrayList <String>();
			meanings.add("monarch");
			meanings.add("ruler");
			meanings.add("sovereign");
			theWords.put(key, meanings);
			
			key = "kings";
			meanings = new ArrayList <String>();
			meanings.add("rulers");
			theWords.put(key, meanings);
			
			key = "kingscross";
			meanings = new ArrayList <String>();
			meanings.add("station");
			theWords.put(key, meanings);
			
			key = "kipper";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "kit";
			meanings = new ArrayList <String>();
			meanings.add("baggage");
			meanings.add("equipment");
			theWords.put(key, meanings);
			
			key = "kitchen";
			meanings = new ArrayList <String>();
			meanings.add("scullery");
			theWords.put(key, meanings);
			
			key = "kith";
			meanings = new ArrayList <String>();
			meanings.add("friends");
			theWords.put(key, meanings);
			
			key = "kneecap";
			meanings = new ArrayList <String>();
			meanings.add("bone");
			theWords.put(key, meanings);
			
			key = "kneel";
			meanings = new ArrayList <String>();
			meanings.add("get ready to pray");
			theWords.put(key, meanings);
			
			key = "knit";
			meanings = new ArrayList <String>();
			meanings.add("bond");
			meanings.add("use needles");
			theWords.put(key, meanings);
			
			key = "knockout";
			meanings = new ArrayList <String>();
			meanings.add("sort of tournament");
			meanings.add("stunning");
			theWords.put(key, meanings);
			
			key = "know";
			meanings = new ArrayList <String>();
			meanings.add("be aware of");
			theWords.put(key, meanings);
			
			key = "knowingly";
			meanings = new ArrayList <String>();
			meanings.add("with full knowledge");
			theWords.put(key, meanings);

		}//end loadK
		
		public TreeMap<String, ArrayList<String>> loadLWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			// load l's
			key = "label";
			meanings = new ArrayList <String>();
			meanings.add("tag");
			theWords.put(key, meanings);
			
			key = "labour";
			meanings = new ArrayList <String>();
			meanings.add("party");
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "lace";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "laces";
			meanings = new ArrayList <String>();
			meanings.add("shoestrings");
			theWords.put(key, meanings);
			
			key = "lacier";
			meanings = new ArrayList <String>();
			meanings.add("more frills");
			theWords.put(key, meanings);
			
			key = "lacrosse";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);
			
			key = "lad";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			theWords.put(key, meanings);
			
			key = "lads";
			meanings = new ArrayList <String>();
			meanings.add("boys");
			theWords.put(key, meanings);
			
			key = "ladder";
			meanings = new ArrayList <String>();
			meanings.add("way up");
			theWords.put(key, meanings);
			
			key = "ladies";
			meanings = new ArrayList <String>();
			meanings.add("women");
			meanings.add("women");
			theWords.put(key, meanings);
			
			key = "lag";
			meanings = new ArrayList <String>();
			meanings.add("prisoner");
			theWords.put(key, meanings);
			
			key = "lagoon";
			meanings = new ArrayList <String>();
			meanings.add("stretch of water");
			theWords.put(key, meanings);
			
			key = "lake";
			meanings = new ArrayList <String>();
			meanings.add("body of water");
			theWords.put(key, meanings);
			
			key = "lamb";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("young sheep");
			theWords.put(key, meanings);
			
			key = "lambs";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			meanings.add("young sheep");
			theWords.put(key, meanings);
			
			key = "lambast";
			meanings = new ArrayList <String>();
			meanings.add("attack");
			theWords.put(key, meanings);
			
			key = "lambeth";
			meanings = new ArrayList <String>();
			meanings.add("London borough");
			theWords.put(key, meanings);
			
			key = "lame";
			meanings = new ArrayList <String>();
			meanings.add("not convincing");
			theWords.put(key, meanings);
			
			key = "lament";
			meanings = new ArrayList <String>();
			meanings.add("bewail");
			meanings.add("express sorrow");
			theWords.put(key, meanings);
			
			key = "lamina";
			meanings = new ArrayList <String>();
			meanings.add("thin layer");
			theWords.put(key, meanings);
			
			key = "lance";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);
			
			key = "lancet";
			meanings = new ArrayList <String>();
			meanings.add("surgical instrument");
			theWords.put(key, meanings);
			
			key = "land";
			meanings = new ArrayList <String>();
			meanings.add("come down");
			meanings.add("real estate");
			meanings.add("secure");
			theWords.put(key, meanings);
			
			key = "landlords";
			meanings = new ArrayList <String>();
			meanings.add("letters");
			theWords.put(key, meanings);
			
			key = "lane";
			meanings = new ArrayList <String>();
			meanings.add("little road");
			meanings.add("road");
			theWords.put(key, meanings);
			
			key = "lanes";
			meanings = new ArrayList <String>();
			meanings.add("country roads");
			meanings.add("roads");
			theWords.put(key, meanings);
			
			key = "language";
			meanings = new ArrayList <String>();
			meanings.add("speech");
			theWords.put(key, meanings);
			
			key = "languish";
			meanings = new ArrayList <String>();
			meanings.add("flag");
			theWords.put(key, meanings);
			
			key = "lanyard";
			meanings = new ArrayList <String>();
			meanings.add("ship's rope");
			theWords.put(key, meanings);
			
			key = "lap";
			meanings = new ArrayList <String>();
			meanings.add("circuit");
			theWords.put(key, meanings);
			
			key = "lapdog";
			meanings = new ArrayList <String>();
			meanings.add("chihuahua");
			theWords.put(key, meanings);
			
			key = "lapse";
			meanings = new ArrayList <String>();
			meanings.add("slip");
			theWords.put(key, meanings);
			
			key = "lard";
			meanings = new ArrayList <String>();
			meanings.add("animal fat");
			theWords.put(key, meanings);
			
			key = "large";
			meanings = new ArrayList <String>();
			meanings.add("very big");
			theWords.put(key, meanings);
			
			key = "largo";
			meanings = new ArrayList <String>();
			meanings.add("slow movement");
			theWords.put(key, meanings);
			
			key = "larva";
			meanings = new ArrayList <String>();
			meanings.add("grub");
			theWords.put(key, meanings);
			
			key = "late";
			meanings = new ArrayList <String>();
			meanings.add("behind");
			meanings.add("not on time");
			theWords.put(key, meanings);
			
			key = "later";
			meanings = new ArrayList <String>();
			meanings.add("afterwards");
			meanings.add("some time in the future");
			meanings.add("subsequent");
			theWords.put(key, meanings);
			
			key = "latest";
			meanings = new ArrayList <String>();
			meanings.add("most recent");
			theWords.put(key, meanings);
			
			key = "lathe";
			meanings = new ArrayList <String>();
			meanings.add("metal-working machine");
			theWords.put(key, meanings);
			
			key = "latin";
			meanings = new ArrayList <String>();
			meanings.add("ancient language");
			theWords.put(key, meanings);
			
			key = "lasagne";
			meanings = new ArrayList <String>();
			meanings.add("Italian food");
			theWords.put(key, meanings);
			
			key = "lashes";
			meanings = new ArrayList <String>();
			meanings.add("strokes");
			theWords.put(key, meanings);
			
			key = "lass";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			meanings.add("young female");
			theWords.put(key, meanings);
			
			key = "lasso";
			meanings = new ArrayList <String>();
			meanings.add("rope");
			theWords.put(key, meanings);
			
			key = "last";
			meanings = new ArrayList <String>();
			meanings.add("final");
			theWords.put(key, meanings);
			
			key = "law";
			meanings = new ArrayList <String>();
			meanings.add("system of rules");
			theWords.put(key, meanings);
			
			key = "lay";
			meanings = new ArrayList <String>();
			meanings.add("non-professional");
			meanings.add("place");
			meanings.add("position");
			meanings.add("put down");
			theWords.put(key, meanings);
			
			key = "layer";
			meanings = new ArrayList <String>();
			meanings.add("coat");
			theWords.put(key, meanings);
			
			key = "layon"; //lay on
			meanings = new ArrayList <String>();
			meanings.add("provide");
			theWords.put(key, meanings);
			
			key = "laze";
			meanings = new ArrayList <String>();
			meanings.add("do nothing");
			theWords.put(key, meanings);
			
			key = "lead";
			meanings = new ArrayList <String>();
			meanings.add("metal");
			meanings.add("promising clue");
			theWords.put(key, meanings);
			
			key = "leading";
			meanings = new ArrayList <String>();
			meanings.add("first");
			theWords.put(key, meanings);
			
			key = "leaf";
			meanings = new ArrayList <String>();
			meanings.add("bit of foliage");
			theWords.put(key, meanings);
			
			key = "leaflet";
			meanings = new ArrayList <String>();
			meanings.add("flyer");
			theWords.put(key, meanings);
			
			key = "leaps";
			meanings = new ArrayList <String>();
			meanings.add("jumps");
			theWords.put(key, meanings);
					
			key = "lean";
			meanings = new ArrayList <String>();
			meanings.add("thin");
			theWords.put(key, meanings);
			
			key = "leans";
			meanings = new ArrayList <String>();
			meanings.add("inclines");
			meanings.add("slants");
			meanings.add("slopes");
			theWords.put(key, meanings);
				
			key = "lear";
			meanings = new ArrayList <String>();
			meanings.add("king");
			theWords.put(key, meanings);
			
			key = "learn";
			meanings = new ArrayList <String>();
			meanings.add("discover");
			theWords.put(key, meanings);
			
			key = "learner";
			meanings = new ArrayList <String>();
			meanings.add("apprentice");
			theWords.put(key, meanings);
			
			key = "lease";
			meanings = new ArrayList <String>();
			meanings.add("let");
			theWords.put(key, meanings);
			
			key = "leased";
			meanings = new ArrayList <String>();
			meanings.add("let");
			theWords.put(key, meanings);
			
			key = "leases";
			meanings = new ArrayList <String>();
			meanings.add("rents");
			theWords.put(key, meanings);
			
			key = "least";
			meanings = new ArrayList <String>();
			meanings.add("smallest amount");
			theWords.put(key, meanings);
			
			key = "leave";
			meanings = new ArrayList <String>();
			meanings.add("abandon");
			meanings.add("don't take");
			meanings.add("holiday");
			meanings.add("time off");
			theWords.put(key, meanings);
			
			key = "lebanon";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "lecture";
			meanings = new ArrayList <String>();
			meanings.add("spoken lesson");
			meanings.add("exposition");
			meanings.add("what students should attend");
			theWords.put(key, meanings);
			
			key = "led";
			meanings = new ArrayList <String>();
			meanings.add("been first");
			meanings.add("came first");
			meanings.add("light");
			meanings.add("ran");
			meanings.add("was first");
			meanings.add("went first");
			theWords.put(key, meanings);
			
			key = "ledge";
			meanings = new ArrayList <String>();
			meanings.add("shelf");
			theWords.put(key, meanings);
			
			key = "lee";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("shelter");
			theWords.put(key, meanings);
			
			key = "leek";
			meanings = new ArrayList <String>();
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "leeway";
			meanings = new ArrayList <String>();
			meanings.add("slack");
			theWords.put(key, meanings);
			
			key = "left";
			meanings = new ArrayList <String>();
			meanings.add("remained");
			meanings.add("socialist");
			theWords.put(key, meanings);
			
			key = "leg";
			meanings = new ArrayList <String>();
			meanings.add("limb");
			meanings.add("member");
			meanings.add("support");
			theWords.put(key, meanings);
			
			key = "legal";
			meanings = new ArrayList <String>();
			meanings.add("lawful");
			theWords.put(key, meanings);
			
			key = "legend";
			meanings = new ArrayList <String>();
			meanings.add("old story");
			theWords.put(key, meanings);
			
			key = "legume";
			meanings = new ArrayList <String>();
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "leicester";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "leo";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("sign");
			theWords.put(key, meanings);
			
			key = "leotard";
			meanings = new ArrayList <String>();
			meanings.add("sports garment");
			theWords.put(key, meanings);
			
			key = "lent";
			meanings = new ArrayList <String>();
			meanings.add("Christian feast");
			theWords.put(key, meanings);
					
			key = "less";
			meanings = new ArrayList <String>();
			meanings.add("fewer");
			theWords.put(key, meanings);
			
			key = "let";
			meanings = new ArrayList <String>();
			meanings.add("allow");
			meanings.add("allowed");
			meanings.add("permit");
			meanings.add("permitted");
			meanings.add("don't prevent");
			theWords.put(key, meanings);
			
			key = "lethal";
			meanings = new ArrayList <String>();
			meanings.add("deadly");
			theWords.put(key, meanings);
			
			key = "lethargy";
			meanings = new ArrayList <String>();
			meanings.add("listlessness");
			meanings.add("sluggishness");
			theWords.put(key, meanings);
			
			key = "lets";
			meanings = new ArrayList <String>();
			meanings.add("allows");
			meanings.add("permits");
			theWords.put(key, meanings);
			
			key = "lettuce";
			meanings = new ArrayList <String>();
			meanings.add("salad vegetable");
			theWords.put(key, meanings);
			
			key = "lever";
			meanings = new ArrayList <String>();
			meanings.add("bar");
			theWords.put(key, meanings);
			
			key = "leveret";
			meanings = new ArrayList <String>();
			meanings.add("young animal");
			meanings.add("young hare");
			theWords.put(key, meanings);
			
			key = "leverets";
			meanings = new ArrayList <String>();
			meanings.add("young animals");
			meanings.add("young hares");
			theWords.put(key, meanings);
			
			key = "lexicon";
			meanings = new ArrayList <String>();
			meanings.add("dictionary");
			theWords.put(key, meanings);
			
			key = "leylandii";
			meanings = new ArrayList <String>();
			meanings.add("conifer");
			theWords.put(key, meanings);
			
			key = "liability";
			meanings = new ArrayList <String>();
			meanings.add("hindrance");
			theWords.put(key, meanings);
					
			key = "liable";
			meanings = new ArrayList <String>();
			meanings.add("bound");
			meanings.add("likely");
			theWords.put(key, meanings);
					
			key = "liar";
			meanings = new ArrayList <String>();
			meanings.add("fibber");
			theWords.put(key, meanings);
			
			key = "libelled";
			meanings = new ArrayList <String>();
			meanings.add("defamed");
			theWords.put(key, meanings);
			
			key = "liberal";
			meanings = new ArrayList <String>();
			meanings.add("politician");
			theWords.put(key, meanings);
			
			key = "lice";
			meanings = new ArrayList <String>();
			meanings.add("parasites");
			theWords.put(key, meanings);
			
			key = "lid";
			meanings = new ArrayList <String>();
			meanings.add("cover");
			theWords.put(key, meanings);
			
			key = "lido";
			meanings = new ArrayList <String>();
			meanings.add("bathing beach");
			meanings.add("outside pool");
			theWords.put(key, meanings);
			
			key = "lie";
			meanings = new ArrayList <String>();
			meanings.add("falsehood");
			meanings.add("story");
			theWords.put(key, meanings);
			
			key = "lied";
			meanings = new ArrayList <String>();
			meanings.add("fibbed");
			meanings.add("gave inaccurate data");
			meanings.add("told fib");
			theWords.put(key, meanings);
			
			key = "lies";
			meanings = new ArrayList <String>();
			meanings.add("falsehoods");
			theWords.put(key, meanings);
			
			key = "lifelong";
			meanings = new ArrayList <String>();
			meanings.add("forever");
			theWords.put(key, meanings);
			
			key = "light";
			meanings = new ArrayList <String>();
			meanings.add("ignite");
			meanings.add("illuminate");
			meanings.add("lamp");
			meanings.add("set fire to");
			meanings.add("sunny");
			meanings.add("torch");
			theWords.put(key, meanings);
			
			key = "lighter";
			meanings = new ArrayList <String>();
			meanings.add("having lost weight");
			meanings.add("weighing less");
			theWords.put(key, meanings);
			
			key = "lightyear";
			meanings = new ArrayList <String>();
			meanings.add("astronomical distance");
			meanings.add("long distance");
			meanings.add("long way off");
			theWords.put(key, meanings);
					
			key = "like";
			meanings = new ArrayList <String>();
			meanings.add("as");
			meanings.add("be fond of");
			meanings.add("something similar");
			theWords.put(key, meanings);
			
			key = "liked";
			meanings = new ArrayList <String>();
			meanings.add("popular");
			theWords.put(key, meanings);
			
			key = "lilac";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			meanings.add("garden shrub");
			theWords.put(key, meanings);
			
			key = "limb";
			meanings = new ArrayList <String>();
			meanings.add("member");
			theWords.put(key, meanings);
			
			key = "limbo";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "limbs";
			meanings = new ArrayList <String>();
			meanings.add("members");
			theWords.put(key, meanings);
			
			key = "limerick";
			meanings = new ArrayList <String>();
			meanings.add("rhyme");
			theWords.put(key, meanings);
			
			key = "limit";
			meanings = new ArrayList <String>();
			meanings.add("boundary");
			theWords.put(key, meanings);
			
			key = "limpet";
			meanings = new ArrayList <String>();
			meanings.add("shellfish");
			theWords.put(key, meanings);
			
			key = "line";
			meanings = new ArrayList <String>();
			meanings.add("dash");
			meanings.add("railway");
			meanings.add("rope");
			theWords.put(key, meanings);
			
			key = "lineage";
			meanings = new ArrayList <String>();
			meanings.add("descent");
			theWords.put(key, meanings);
			
			key = "liner";
			meanings = new ArrayList <String>();
			meanings.add("ship");
			theWords.put(key, meanings);
			
			key = "ling";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			meanings.add("heather");
			theWords.put(key, meanings);
			
			key = "linger";
			meanings = new ArrayList <String>();
			meanings.add("persist");
			meanings.add("stay");
			theWords.put(key, meanings);
			
			key = "lingerie";
			meanings = new ArrayList <String>();
			meanings.add("underwear");
			theWords.put(key, meanings);
					
			key = "linnet";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "lino";
			meanings = new ArrayList <String>();
			meanings.add("floor covering");
			theWords.put(key, meanings);
			
			key = "liquor";
			meanings = new ArrayList <String>();
			meanings.add("alcoholic drink");
			theWords.put(key, meanings);
			
			key = "liquorice";
			meanings = new ArrayList <String>();
			meanings.add("sweet");
			theWords.put(key, meanings);
			
			key = "list";
			meanings = new ArrayList <String>();
			meanings.add("catalogue");
			theWords.put(key, meanings);
			
			key = "listen";
			meanings = new ArrayList <String>();
			meanings.add("give one's attention to");
			meanings.add("hark");
			theWords.put(key, meanings);

			key = "lit";
			meanings = new ArrayList <String>();
			meanings.add("illuminated");
			meanings.add("set fire to");
			theWords.put(key, meanings);
			
			key = "literature";
			meanings = new ArrayList <String>();
			meanings.add("writing");
			theWords.put(key, meanings);
			
			key = "lithe";
			meanings = new ArrayList <String>();
			meanings.add("nimble");
			theWords.put(key, meanings);
			
			key = "litres";
			meanings = new ArrayList <String>();
			meanings.add("units of capacity");
			theWords.put(key, meanings);
			
			key = "litup"; //lit up
			meanings = new ArrayList <String>();
			meanings.add("illuminated");
			theWords.put(key, meanings);
			
			key = "live";
			meanings = new ArrayList <String>();
			meanings.add("exist");
			theWords.put(key, meanings);
			
			key = "lives";
			meanings = new ArrayList <String>();
			meanings.add("exists");
			theWords.put(key, meanings);
			
			key = "llama";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "loan";
			meanings = new ArrayList <String>();
			meanings.add("advance");
			meanings.add("credit");
			theWords.put(key, meanings);
			
			key = "loath";
			meanings = new ArrayList <String>();
			meanings.add("reluctant");
			theWords.put(key, meanings);
			
			key = "loaves";
			meanings = new ArrayList <String>();
			meanings.add("bread");
			theWords.put(key, meanings);
			
			key = "lob";
			meanings = new ArrayList <String>();
			meanings.add("chuck");
			theWords.put(key, meanings);
			
			key = "local";
			meanings = new ArrayList <String>();
			meanings.add("pub");
			theWords.put(key, meanings);
			
			key = "locale";
			meanings = new ArrayList <String>();
			meanings.add("setting");
			theWords.put(key, meanings);
			
			key = "location";
			meanings = new ArrayList <String>();
			meanings.add("place");
			theWords.put(key, meanings);
					
			key = "loco";
			meanings = new ArrayList <String>();
			meanings.add("crazy");
			meanings.add("railway engine");
			theWords.put(key, meanings);
			
			key = "locust";
			meanings = new ArrayList <String>();
			meanings.add("insect");
			theWords.put(key, meanings);
			
			key = "loft";
			meanings = new ArrayList <String>();
			meanings.add("attic");
			theWords.put(key, meanings);
			
			key = "loftier";
			meanings = new ArrayList <String>();
			meanings.add("taller");
			theWords.put(key, meanings);
			
			key = "log";
			meanings = new ArrayList <String>();
			meanings.add("record");
			theWords.put(key, meanings);
			
			key = "logarithm";
			meanings = new ArrayList <String>();
			//meanings.add("exponent");
			meanings.add("mathematical invention");
			theWords.put(key, meanings);
			
			key = "logic";
			meanings = new ArrayList <String>();
			meanings.add("good sense");
			theWords.put(key, meanings);
			
			key = "logical";
			meanings = new ArrayList <String>();
			meanings.add("rational");
			theWords.put(key, meanings);
			
			key = "logo";
			meanings = new ArrayList <String>();
			meanings.add("symbol");
			theWords.put(key, meanings);
			
			key = "logs";
			meanings = new ArrayList <String>();
			meanings.add("records");
			theWords.put(key, meanings);
					
			key = "loire";
			meanings = new ArrayList <String>();
			meanings.add("European river");
			theWords.put(key, meanings);
			
			key = "lois";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "lone";
			meanings = new ArrayList <String>();
			meanings.add("solitary");
			theWords.put(key, meanings);
					
			key = "loner";
			meanings = new ArrayList <String>();
			meanings.add("recluse");
			theWords.put(key, meanings);
			
			key = "loners";
			meanings = new ArrayList <String>();
			meanings.add("recluses");
			theWords.put(key, meanings);
				
			key = "londoners";
			meanings = new ArrayList <String>();
			meanings.add("capital folk");
			theWords.put(key, meanings);
			
			key = "long";
			meanings = new ArrayList <String>();
			meanings.add("pine");
			meanings.add("tall");
			meanings.add("yearn");
			theWords.put(key, meanings);
			
			key = "lookout";
			meanings = new ArrayList <String>();
			meanings.add("guard");
			meanings.add("warning cry");
			theWords.put(key, meanings);
			
			key = "lops";
			meanings = new ArrayList <String>();
			meanings.add("cuts");
			theWords.put(key, meanings);
			
			key = "lords";
			meanings = new ArrayList <String>();
			meanings.add("cricket ground");
			theWords.put(key, meanings);
			
			key = "lore";
			meanings = new ArrayList <String>();
			meanings.add("culture");
			meanings.add("mythology");
			theWords.put(key, meanings);
					
			key = "losangeles";//Los Angeles
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "losers";
			meanings = new ArrayList <String>();
			meanings.add("beaten contestants");
			theWords.put(key, meanings);
			
			key = "lost";
			meanings = new ArrayList <String>();
			meanings.add("adrift");
			meanings.add("departed");
			theWords.put(key, meanings);
			
			key = "lot";
			meanings = new ArrayList <String>();
			meanings.add("item");
			meanings.add("large quantity");
			theWords.put(key, meanings);
			
			key = "lots";
			meanings = new ArrayList <String>();
			meanings.add("items");
			meanings.add("many");
			theWords.put(key, meanings);
			
			key = "lough";
			meanings = new ArrayList <String>();
			meanings.add("Irish loch");
			theWords.put(key, meanings);
			
			key = "lounge";
			meanings = new ArrayList <String>();
			meanings.add("room");
			theWords.put(key, meanings);
			
			key = "lourdes";
			meanings = new ArrayList <String>();
			meanings.add("holy place");
			theWords.put(key, meanings);
			
			key = "louse";
			meanings = new ArrayList <String>();
			meanings.add("insect");
			theWords.put(key, meanings);
			
			key = "louvre";
			meanings = new ArrayList <String>();
			meanings.add("French gallery");
			meanings.add("museum");
			theWords.put(key, meanings);
			
			key = "louvred";
			meanings = new ArrayList <String>();
			meanings.add("with slats");
			theWords.put(key, meanings);
			
			key = "love";
			meanings = new ArrayList <String>();
			meanings.add("like very much");
			meanings.add("nothing in tennis");
			theWords.put(key, meanings);
			
			key = "loveable";
			meanings = new ArrayList <String>();
			meanings.add("adorable");
			theWords.put(key, meanings);
			
			key = "loves";
			meanings = new ArrayList <String>();
			meanings.add("adores");
			theWords.put(key, meanings);
			
			key = "lower";
			meanings = new ArrayList <String>();
			meanings.add("deeper");
			theWords.put(key, meanings);
			
			key = "loyal";
			meanings = new ArrayList <String>();
			meanings.add("faithful");
			theWords.put(key, meanings);
			
			key = "lucky";
			meanings = new ArrayList <String>();
			meanings.add("fortunate");
			theWords.put(key, meanings);
			
			key = "lucy";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "lunch";
			meanings = new ArrayList <String>();
			meanings.add("meal");
			theWords.put(key, meanings);
			
			key = "lung";
			meanings = new ArrayList <String>();
			meanings.add("organ");
			theWords.put(key, meanings);
			
			key = "lunge";
			meanings = new ArrayList <String>();
			meanings.add("dive forward");
			meanings.add("thrust");
			meanings.add("thrust forward");
			theWords.put(key, meanings);
			
			key = "lumbago";
			meanings = new ArrayList <String>();
			meanings.add("complaint");
			theWords.put(key, meanings);
			
			key = "lumpy";
			meanings = new ArrayList <String>();
			meanings.add("uneven");
			theWords.put(key, meanings);
			
			key = "lustre";
			meanings = new ArrayList <String>();
			meanings.add("radiance");
			theWords.put(key, meanings);
			
			key = "lute";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
			
			key = "luton";
			meanings = new ArrayList <String>();
			meanings.add("airport");
			theWords.put(key, meanings);
			
			key = "lying";
			meanings = new ArrayList <String>();
			meanings.add("not telling the truth");
			theWords.put(key, meanings);

			return theWords;
		}//end loadL
		
		public void loadMWords() {
			String key;
			ArrayList <String> meanings;
			
			// load m's
			key = "ma";
			meanings = new ArrayList <String>();
			meanings.add("mother");
			theWords.put(key, meanings);
			
			key = "mac";
			meanings = new ArrayList <String>();
			meanings.add("coat");
			theWords.put(key, meanings);
			
			key = "macabre";
			meanings = new ArrayList <String>();
			meanings.add("gruesome");
			theWords.put(key, meanings);
					
			key = "mach";
			meanings = new ArrayList <String>();
			meanings.add("speed of sound");
			theWords.put(key, meanings);
					
			key = "macho";
			meanings = new ArrayList <String>();
			meanings.add("masculine");
			theWords.put(key, meanings);
			
			key = "mad";
			meanings = new ArrayList <String>();
			meanings.add("crazy");
			meanings.add("nuts");
			theWords.put(key, meanings);
			
			key = "madame";
			meanings = new ArrayList <String>();
			meanings.add("French woman");
			theWords.put(key, meanings);

			key = "made";
			meanings = new ArrayList <String>();
			meanings.add("created");
			theWords.put(key, meanings);
			
			key = "madeup"; //made up
			meanings = new ArrayList <String>();
			meanings.add("invented");
			meanings.add("resolved differences");
			theWords.put(key, meanings);
			
			key = "maestro";
			meanings = new ArrayList <String>();
			meanings.add("eminent performer");
			meanings.add("great conductor");
			theWords.put(key, meanings);
			
			key = "magenta";
			meanings = new ArrayList <String>();
			meanings.add("red");
			theWords.put(key, meanings);
			
			key = "magi";
			meanings = new ArrayList <String>();
			meanings.add("Christmas visitors");
			theWords.put(key, meanings);
			
			key = "magic";
			meanings = new ArrayList <String>();
			meanings.add("sorcery");
			theWords.put(key, meanings);
			
			key = "magnetic";
			meanings = new ArrayList <String>();
			meanings.add("attractive");
			theWords.put(key, meanings);
			
			key = "maid";
			meanings = new ArrayList <String>();
			meanings.add("cleaner");
			theWords.put(key, meanings);
			
			key = "mail";
			meanings = new ArrayList <String>();
			meanings.add("letters");
			theWords.put(key, meanings);
			
			key = "main";
			meanings = new ArrayList <String>();
			meanings.add("dominant");
			meanings.add("principal");
			theWords.put(key, meanings);
			
			key = "maine";
			meanings = new ArrayList <String>();
			meanings.add("state");
			theWords.put(key, meanings);
			
			key = "mains";
			meanings = new ArrayList <String>();
			meanings.add("chief fuel supply");
			theWords.put(key, meanings);
			
			key = "major";
			meanings = new ArrayList <String>();
			meanings.add("officer");
			theWords.put(key, meanings);
			
			key = "majorca";
			meanings = new ArrayList <String>();
			meanings.add("spanish island");
			theWords.put(key, meanings);
			
			key = "make";
			meanings = new ArrayList <String>();
			meanings.add("tradename");
			theWords.put(key, meanings);
			
			key = "makes";
			meanings = new ArrayList <String>();
			meanings.add("produces");
			theWords.put(key, meanings);
			
			key = "maker";
			meanings = new ArrayList <String>();
			meanings.add("inventor");
			theWords.put(key, meanings);
			
			key = "makeup";
			meanings = new ArrayList <String>();
			meanings.add("invent");//make up
			meanings.add("cosmetics");
			theWords.put(key, meanings);
			
			key = "maladies";
			meanings = new ArrayList <String>();
			meanings.add("uneasy feeling");
			theWords.put(key, meanings);
			
			key = "malaise";
			meanings = new ArrayList <String>();
			meanings.add("complaints");
			meanings.add("uneasy feeling");
			theWords.put(key, meanings);
			
			key = "malaria";
			meanings = new ArrayList <String>();
			meanings.add("fever");
			theWords.put(key, meanings);
			
			key = "males";
			meanings = new ArrayList <String>();
			meanings.add("men");
			theWords.put(key, meanings);
			
			key = "mali";
			meanings = new ArrayList <String>();
			meanings.add("African country");
			theWords.put(key, meanings);
			
			key = "malice";
			meanings = new ArrayList <String>();
			meanings.add("ill will");
			theWords.put(key, meanings);
			
			key = "malign";
			meanings = new ArrayList <String>();
			meanings.add("speak ill of");
			theWords.put(key, meanings);
			
			key = "maligned";
			meanings = new ArrayList <String>();
			meanings.add("defamed");
			theWords.put(key, meanings);
			
			key = "mallet";
			meanings = new ArrayList <String>();
			meanings.add("sort of hammer");
			theWords.put(key, meanings);
			
			key = "malt";
			meanings = new ArrayList <String>();
			meanings.add("whisky");
			theWords.put(key, meanings);
			
			key = "malta";
			meanings = new ArrayList <String>();
			meanings.add("Mediterranean Island");
			meanings.add("island");
			theWords.put(key, meanings);
			
			key = "maltese";
			meanings = new ArrayList <String>();
			meanings.add("islanders");
			theWords.put(key, meanings);
			
			key = "mamba";
			meanings = new ArrayList <String>();
			meanings.add("snake");
			theWords.put(key, meanings);
			
			key = "mammoth";
			meanings = new ArrayList <String>();
			meanings.add("massive");
			theWords.put(key, meanings);
			
			key = "man";
			meanings = new ArrayList <String>();
			meanings.add("chap");
			meanings.add("male");
			meanings.add("person");
			theWords.put(key, meanings);
			
			key = "mandarin";
			meanings = new ArrayList <String>();
			meanings.add("Chinese");
			theWords.put(key, meanings);
			
			key = "mandrill";
			meanings = new ArrayList <String>();
			meanings.add("big baboon");
			theWords.put(key, meanings);
			
			key = "manila";
			meanings = new ArrayList <String>();
			meanings.add("Philippine city");
			theWords.put(key, meanings);
			
			key = "mankind";
			meanings = new ArrayList <String>();
			meanings.add("human race");
			theWords.put(key, meanings);
			
			key = "mansions";
			meanings = new ArrayList <String>();
			meanings.add("large houses");
			theWords.put(key, meanings);
			
			key = "mantra";
			meanings = new ArrayList <String>();
			meanings.add("chant");
			theWords.put(key, meanings);
			
			key = "mantrap";
			meanings = new ArrayList <String>();
			meanings.add("snare for trespasser's");
			theWords.put(key, meanings);
			
			key = "manual";
			meanings = new ArrayList <String>();
			meanings.add("handbook");
			theWords.put(key, meanings);
			
			key = "many";
			meanings = new ArrayList <String>();
			meanings.add("a lot");
			theWords.put(key, meanings);
			
			key = "map";
			meanings = new ArrayList <String>();
			meanings.add("chart");
			theWords.put(key, meanings);
			
			key = "mar";
			meanings = new ArrayList <String>();
			meanings.add("have a detrimental effect on");
			meanings.add("spoil");
			theWords.put(key, meanings);
			
			key = "maracas";
			meanings = new ArrayList <String>();
			meanings.add("they'll be shaken");
			theWords.put(key, meanings);
			
			key = "march";
			meanings = new ArrayList <String>();
			meanings.add("parade");
			theWords.put(key, meanings);
			
			key = "mare";
			meanings = new ArrayList <String>();
			meanings.add("horse");
			theWords.put(key, meanings);
			
			key = "mares";
			meanings = new ArrayList <String>();
			meanings.add("horses");
			theWords.put(key, meanings);
			
			key = "margin";
			meanings = new ArrayList <String>();
			meanings.add("border");
			theWords.put(key, meanings);
			
			key = "margins";
			meanings = new ArrayList <String>();
			meanings.add("borders");
			theWords.put(key, meanings);
			
			key = "maria";
			meanings = new ArrayList <String>();
			meanings.add("Callas");
			theWords.put(key, meanings);
			
			key = "marinate";
			meanings = new ArrayList <String>();
			meanings.add("soak");
			theWords.put(key, meanings);
			
			key = "marine";
			meanings = new ArrayList <String>();
			meanings.add("of the sea");
			theWords.put(key, meanings);
			
			key = "maritime";
			meanings = new ArrayList <String>();
			meanings.add("nautical");
			theWords.put(key, meanings);
					
			key = "mark";
			meanings = new ArrayList <String>();
			meanings.add("former currency");
			meanings.add("stain");
			theWords.put(key, meanings);
			
			key = "market";
			meanings = new ArrayList <String>();
			meanings.add("advertise");
			theWords.put(key, meanings);
			
			key = "marks";
			meanings = new ArrayList <String>();
			meanings.add("stains");
			theWords.put(key, meanings);
					
			key = "marlin";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "maroon";
			meanings = new ArrayList <String>();
			meanings.add("red");
			theWords.put(key, meanings);
			
			key = "marooned";
			meanings = new ArrayList <String>();
			meanings.add("left high and dry");
			theWords.put(key, meanings);
			
			key = "mars";
			meanings = new ArrayList <String>();
			meanings.add("god");
			meanings.add("Roman god");
			theWords.put(key, meanings);
			
			key = "mart";
			meanings = new ArrayList <String>();
			meanings.add("shop");
			theWords.put(key, meanings);
			
			key = "mary";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "mascot";
			meanings = new ArrayList <String>();
			meanings.add("lucky charm");
			theWords.put(key, meanings);
			
			key = "mash";
			meanings = new ArrayList <String>();
			meanings.add("reduce to a pulp");
			meanings.add("crush");
			meanings.add("smash");
			meanings.add("a brewing technique");
			theWords.put(key, meanings);
			
			key = "mask";
			meanings = new ArrayList <String>();
			meanings.add("disguise");
			theWords.put(key, meanings);
			
			key = "masks";
			meanings = new ArrayList <String>();
			meanings.add("they disguise");
			theWords.put(key, meanings);
			
			key = "masonry";
			meanings = new ArrayList <String>();
			meanings.add("brickwork");
			theWords.put(key, meanings);
			
			key = "mass";
			meanings = new ArrayList <String>();
			meanings.add("large amount");
			meanings.add("multitude");
			meanings.add("service");
			theWords.put(key, meanings);
			
			key = "masseur";
			meanings = new ArrayList <String>();
			meanings.add("manipulator");
			theWords.put(key, meanings);
			
			key = "master";
			meanings = new ArrayList <String>();
			meanings.add("get the better of");
			meanings.add("teacher");
			theWords.put(key, meanings);
			
			key = "masterly";
			meanings = new ArrayList <String>();
			meanings.add("appearing good at it");
			theWords.put(key, meanings);
			
			key = "mastery";
			meanings = new ArrayList <String>();
			meanings.add("complete control");
			theWords.put(key, meanings);
					
			key = "mastiff";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "mat";
			meanings = new ArrayList <String>();
			meanings.add("tangle");
			theWords.put(key, meanings);
			
			key = "mate";
			meanings = new ArrayList <String>();
			meanings.add("pal");
			theWords.put(key, meanings);
			
			key = "mattress";
			meanings = new ArrayList <String>();
			meanings.add("bedding");
			theWords.put(key, meanings);
			
			key = "Mauritius";
			meanings = new ArrayList <String>();
			meanings.add("island");
			theWords.put(key, meanings);
			
			key = "max";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "may";
			meanings = new ArrayList <String>();
			meanings.add("month");
			theWords.put(key, meanings);
			
			key = "mayhem";
			meanings = new ArrayList <String>();
			meanings.add("chaos");
			theWords.put(key, meanings);
			
			key = "maze";
			meanings = new ArrayList <String>();
			meanings.add("labyrinth");
			theWords.put(key, meanings);
			
			key = "me";
			meanings = new ArrayList <String>();
			meanings.add("myself");
			meanings.add("yours truly");
			theWords.put(key, meanings);
			
			key = "mead";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "meal";
			meanings = new ArrayList <String>();
			meanings.add("dinner");
			theWords.put(key, meanings);
			
			key = "mean";
			meanings = new ArrayList <String>();
			meanings.add("adept");
			meanings.add("intend");
			meanings.add("signify");
			meanings.add("tight with money");
			meanings.add("very skilful");
			theWords.put(key, meanings);
			
			key = "meat";
			meanings = new ArrayList <String>();
			meanings.add("the flesh of an animal");
			meanings.add("chief part of");
			theWords.put(key, meanings);
			
			key = "meats";
			meanings = new ArrayList <String>();
			meanings.add("food");
			theWords.put(key, meanings);
			
			key = "medals";
			meanings = new ArrayList <String>();
			meanings.add("gongs");
			theWords.put(key, meanings);
			
			key = "median";
			meanings = new ArrayList <String>();
			meanings.add("at the midpoint");
			meanings.add("in the middle");
			theWords.put(key, meanings);
			
			key = "mediate";
			meanings = new ArrayList <String>();
			meanings.add("act as a peace maker");
			meanings.add("reconcile");
			theWords.put(key, meanings);
			
			key = "medicine";
			meanings = new ArrayList <String>();
			meanings.add("treatment");
			theWords.put(key, meanings);
			
			key = "meds";
			meanings = new ArrayList <String>();
			meanings.add("prescriptions");
			theWords.put(key, meanings);
					
			key = "meek";
			meanings = new ArrayList <String>();
			meanings.add("humble");
			theWords.put(key, meanings);
			
			key = "meekly";
			meanings = new ArrayList <String>();
			meanings.add("in a humble way");
			theWords.put(key, meanings);
			
			key = "meeting";
			meanings = new ArrayList <String>();
			meanings.add("coming across");
			meanings.add("encountering");
			theWords.put(key, meanings);
			
			key = "melbourne";
			meanings = new ArrayList <String>();
			meanings.add("Australian city");
			theWords.put(key, meanings);
			
			key = "member";
			meanings = new ArrayList <String>();
			meanings.add("one who's in a club");
			theWords.put(key, meanings);
			
			key = "memo";
			meanings = new ArrayList <String>();
			meanings.add("note");
			theWords.put(key, meanings);
			
			key = "men";
			meanings = new ArrayList <String>();
			meanings.add("chaps");
			meanings.add("people");
			theWords.put(key, meanings);
			
			key = "menace";
			meanings = new ArrayList <String>();
			meanings.add("alarm");
			meanings.add("threaten");
			theWords.put(key, meanings);
			
			key = "menaces";
			meanings = new ArrayList <String>();
			meanings.add("alarms");
			theWords.put(key, meanings);
			
			key = "mend";
			meanings = new ArrayList <String>();
			meanings.add("repair");
			theWords.put(key, meanings);
			
			key = "mends";
			meanings = new ArrayList <String>();
			meanings.add("repairs");
			theWords.put(key, meanings);
			
			key = "mental";
			meanings = new ArrayList <String>();
			meanings.add("cognitive");
			theWords.put(key, meanings);
			
			key = "mention";
			meanings = new ArrayList <String>();
			meanings.add("divulge");
			theWords.put(key, meanings);
			
			key = "menu";
			meanings = new ArrayList <String>();
			meanings.add("food list");
			theWords.put(key, meanings);
			
			key = "mep";
			meanings = new ArrayList <String>();
			meanings.add("politician");
			theWords.put(key, meanings);
			
			key = "mere";
			meanings = new ArrayList <String>();
			meanings.add("lake");
			meanings.add("only");
			theWords.put(key, meanings);
			
			key = "merely";
			meanings = new ArrayList <String>();
			meanings.add("just");
			theWords.put(key, meanings);
			
			key = "merges";
			meanings = new ArrayList <String>();
			meanings.add("mixes");
			theWords.put(key, meanings);
			
			key = "merino";
			meanings = new ArrayList <String>();
			meanings.add("sheep");
			theWords.put(key, meanings);
					
			key = "mesh";
			meanings = new ArrayList <String>();
			meanings.add("network");
			theWords.put(key, meanings);
			
			key = "mess";
			meanings = new ArrayList <String>();
			meanings.add("canteen");
			meanings.add("disorder");
			meanings.add("disorderely state");
			meanings.add("where soldiers eat");
			theWords.put(key, meanings);
			
			key = "message";
			meanings = new ArrayList <String>();
			meanings.add("notification");
			meanings.add("sense");
			theWords.put(key, meanings);
			
			key = "messages";
			meanings = new ArrayList <String>();
			meanings.add("communications");
			meanings.add("notifications");
			theWords.put(key, meanings);

			key = "met";
			meanings = new ArrayList <String>();
			meanings.add("came across");
			meanings.add("encountered");
			theWords.put(key, meanings);
			
			key = "metal";
			meanings = new ArrayList <String>();
			meanings.add("hard shiny material");
			theWords.put(key, meanings);
			
			key = "meteor";
			meanings = new ArrayList <String>();
			meanings.add("shooting star");
			theWords.put(key, meanings);
			
			key = "meter";
			meanings = new ArrayList <String>();
			meanings.add("gauge");
			meanings.add("measuring device");
			theWords.put(key, meanings);
			
			key = "method";
			meanings = new ArrayList <String>();
			meanings.add("system");
			theWords.put(key, meanings);
			
			key = "methodist";
			meanings = new ArrayList <String>();
			meanings.add("believer");
			theWords.put(key, meanings);
					
			key = "mexican";
			meanings = new ArrayList <String>();
			meanings.add("");
			theWords.put(key, meanings);
			
			key = "mice";
			meanings = new ArrayList <String>();
			meanings.add("small animals");
			theWords.put(key, meanings);
			
			key = "mighty";
			meanings = new ArrayList <String>();
			meanings.add("big");
			theWords.put(key, meanings);
			
			key = "mile";
			meanings = new ArrayList <String>();
			meanings.add("distance");
			theWords.put(key, meanings);
			
			key = "milk";
			meanings = new ArrayList <String>();
			meanings.add("exploit");
			theWords.put(key, meanings);
			
			key = "mill";
			meanings = new ArrayList <String>();
			meanings.add("factory");
			theWords.put(key, meanings);
			
			key = "mine";
			meanings = new ArrayList <String>();
			meanings.add("belonging to me");
			meanings.add("colliery");
			theWords.put(key, meanings);
			
			key = "miner";
			meanings = new ArrayList <String>();
			meanings.add("colliery worker");
			meanings.add("pit worker");
			theWords.put(key, meanings);
			
			key = "mini";
			meanings = new ArrayList <String>();
			meanings.add("car");
			meanings.add("short skirt");
			theWords.put(key, meanings);
			
			key = "minion";
			meanings = new ArrayList <String>();
			meanings.add("lackey");
			theWords.put(key, meanings);
			
			key = "minor";
			meanings = new ArrayList <String>();
			meanings.add("child");
			meanings.add("insignificant");
			theWords.put(key, meanings);
			
			key = "minorca";
			meanings = new ArrayList <String>();
			meanings.add("Spanish island");
			theWords.put(key, meanings);
			
			key = "minister";
			meanings = new ArrayList <String>();
			meanings.add("clergyman");
			theWords.put(key, meanings);
			
			key = "minster";
			meanings = new ArrayList <String>();
			meanings.add("church");
			theWords.put(key, meanings);
			
			key = "mint";
			meanings = new ArrayList <String>();
			meanings.add("herb");
			meanings.add("in perfect condition");
			theWords.put(key, meanings);
			
			key = "minute";
			meanings = new ArrayList <String>();
			meanings.add("extremely small");
			meanings.add("period of time");
			theWords.put(key, meanings);
			
			key = "minx";
			meanings = new ArrayList <String>();
			meanings.add("mischief maker");
			theWords.put(key, meanings);
			
			key = "miracle";
			meanings = new ArrayList <String>();
			meanings.add("phenomenon");
			theWords.put(key, meanings);
			
			key = "mire";
			meanings = new ArrayList <String>();
			meanings.add("boggy ground");
			theWords.put(key, meanings);
			
			key = "miser";
			meanings = new ArrayList <String>();
			meanings.add("skinflint");
			theWords.put(key, meanings);
			
			key = "misery";
			meanings = new ArrayList <String>();
			meanings.add("grief");
			theWords.put(key, meanings);
			
			key = "mislay";
			meanings = new ArrayList <String>();
			meanings.add("lose");
			theWords.put(key, meanings);
			
			key = "mislayed";
			meanings = new ArrayList <String>();
			meanings.add("lost");
			theWords.put(key, meanings);
			
			key = "misleads";
			meanings = new ArrayList <String>();
			meanings.add("deceptive");
			meanings.add("sends astray");
			theWords.put(key, meanings);
			
			key = "misprint";
			meanings = new ArrayList <String>();
			meanings.add("typring error");
			theWords.put(key, meanings);
			
			key = "miss";
			meanings = new ArrayList <String>();
			meanings.add("female");
			meanings.add("off target");
			meanings.add("title");
			meanings.add("young girl");
			theWords.put(key, meanings);
			
			key = "missed";
			meanings = new ArrayList <String>();
			meanings.add("overlooked");
			theWords.put(key, meanings);
			
			key = "mistletoe";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);
			
			key = "mitre";
			meanings = new ArrayList <String>();
			meanings.add("hat");
			meanings.add("headdress"); 
			theWords.put(key, meanings);
			
			key = "mix";
			meanings = new ArrayList <String>();
			meanings.add("socialise");
			theWords.put(key, meanings);
					
			key = "moat";
			meanings = new ArrayList <String>();
			meanings.add("ditch");
			theWords.put(key, meanings);
			
			key = "mob";
			meanings = new ArrayList <String>();
			meanings.add("besiege");
			meanings.add("mafiosi");
			theWords.put(key, meanings);
			
			key = "mocha";
			meanings = new ArrayList <String>();
			meanings.add("coffee");
			theWords.put(key, meanings);
			
			key = "model";
			meanings = new ArrayList <String>();
			meanings.add("ideal");
			meanings.add("poser");
			theWords.put(key, meanings);

			key = "models";
			meanings = new ArrayList <String>();
			meanings.add("posers");
			theWords.put(key, meanings);
			
			key = "mode";
			meanings = new ArrayList <String>();
			meanings.add("fashion");
			theWords.put(key, meanings);
			
			key = "modes";
			meanings = new ArrayList <String>();
			meanings.add("fashions");
			theWords.put(key, meanings);
			
			key = "monarch";
			meanings = new ArrayList <String>();
			meanings.add("sovereign");
			theWords.put(key, meanings);
			
			key = "monastery";
			meanings = new ArrayList <String>();
			meanings.add("abbey");
			theWords.put(key, meanings);
			
			key = "months";
			meanings = new ArrayList <String>();
			meanings.add("periods of time");
			theWords.put(key, meanings);
			
			key = "moo";
			meanings = new ArrayList <String>();
			meanings.add("low");
			theWords.put(key, meanings);
			
			key = "mood";
			meanings = new ArrayList <String>();
			meanings.add("temper");
			theWords.put(key, meanings);
			
			key = "moor";
			meanings = new ArrayList <String>();
			meanings.add("tie");
			theWords.put(key, meanings);
			
			key = "more";
			meanings = new ArrayList <String>();
			meanings.add("extra");
			theWords.put(key, meanings);
			
			key = "morose";
			meanings = new ArrayList <String>();
			meanings.add("gloomy");
			theWords.put(key, meanings);
					
			key = "moses";
			meanings = new ArrayList <String>();
			meanings.add("prophet");
			theWords.put(key, meanings);
			
			key = "mosquitoes";
			meanings = new ArrayList <String>();
			meanings.add("bloodsuckers");
			theWords.put(key, meanings);
			
			key = "moss";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);
			
			key = "most";
			meanings = new ArrayList <String>();
			meanings.add("greatest amount");
			theWords.put(key, meanings);
			
			key = "mot";
			meanings = new ArrayList <String>();
			meanings.add("annual check");
			theWords.put(key, meanings);
			
			key = "moth";
			meanings = new ArrayList <String>();
			meanings.add("insect");
			theWords.put(key, meanings);
			
			key = "mother";
			meanings = new ArrayList <String>();
			meanings.add("parent");
			meanings.add("relative");
			theWords.put(key, meanings);
			
			key = "motor";
			meanings = new ArrayList <String>();
			meanings.add("car");
			theWords.put(key, meanings);
			
			key = "motto";
			meanings = new ArrayList <String>();
			meanings.add("proverb");
			theWords.put(key, meanings);
			
			key = "mount";
			meanings = new ArrayList <String>();
			meanings.add("horse");
			theWords.put(key, meanings);
			
			key = "mountain";
			meanings = new ArrayList <String>();
			meanings.add("peak");
			theWords.put(key, meanings);
			
			key = "mountaineer";
			meanings = new ArrayList <String>();
			meanings.add("climber");
			theWords.put(key, meanings);
			
			key = "mouse";
			meanings = new ArrayList <String>();
			meanings.add("rodent");
			theWords.put(key, meanings);
			
			key = "mouth";
			meanings = new ArrayList <String>();
			meanings.add("speaker");
			theWords.put(key, meanings);
			
			key = "mow";
			meanings = new ArrayList <String>();
			meanings.add("cut");
			theWords.put(key, meanings);
			
			key = "much";
			meanings = new ArrayList <String>();
			meanings.add("considerably");
			theWords.put(key, meanings);
			
			key = "mud";
			meanings = new ArrayList <String>();
			meanings.add("sludge");
			meanings.add("wet earth");
			theWords.put(key, meanings);
			
			key = "mug";
			meanings = new ArrayList <String>();
			meanings.add("tankard");
			theWords.put(key, meanings);
			
			key = "mull";
			meanings = new ArrayList <String>();
			meanings.add("warm");
			meanings.add("Scottish isle");
			theWords.put(key, meanings);
			
			key = "mum";
			meanings = new ArrayList <String>();
			meanings.add("mother");
			theWords.put(key, meanings);

			key = "mumps";
			meanings = new ArrayList <String>();
			meanings.add("disease");
			theWords.put(key, meanings);
			
			key = "mums";
			meanings = new ArrayList <String>();
			meanings.add("mothers");
			theWords.put(key, meanings);
			
			key = "murderous";
			meanings = new ArrayList <String>();
			meanings.add("bloodthirsty");
			theWords.put(key, meanings);
			
			key = "muse";
			meanings = new ArrayList <String>();
			meanings.add("source of inspirtion");
			theWords.put(key, meanings);
			
			key = "mushroom";
			meanings = new ArrayList <String>();
			meanings.add("expand suddenly");
			meanings.add("fungal growth");
			theWords.put(key, meanings);
			
			key = "music";
			meanings = new ArrayList <String>();
			meanings.add("entertainment");
			theWords.put(key, meanings);
			
			key = "musing";
			meanings = new ArrayList <String>();
			meanings.add("thinking");
			theWords.put(key, meanings);
			
			key = "must";
			meanings = new ArrayList <String>();
			meanings.add("be obliged to");
			theWords.put(key, meanings);
			theWords.put(key, meanings);
			
			key = "mute";
			meanings = new ArrayList <String>();
			meanings.add("silent");
			theWords.put(key, meanings);
			
			key = "my";
			meanings = new ArrayList <String>();
			meanings.add("expression of surprise");
			theWords.put(key, meanings);
			
			key = "mysterious";
			meanings = new ArrayList <String>();
			meanings.add("puzzling");
			theWords.put(key, meanings);

		}//end loadM
		
		public void loadNWords() {
			String key;
			ArrayList <String> meanings;
			
			//load n's
			key = "nacho";
			meanings = new ArrayList <String>();
			meanings.add("Mexican snack");
			theWords.put(key, meanings);
			
			key = "nae";
			meanings = new ArrayList <String>();
			meanings.add("no Scots");
			meanings.add("Scots no");
			theWords.put(key, meanings);
			
			key = "nag";
			meanings = new ArrayList <String>();
			meanings.add("bother persistently");
			meanings.add("old horse");
			meanings.add("pester");
			meanings.add("scold");
			theWords.put(key, meanings);
			
			key = "nags";
			meanings = new ArrayList <String>();
			meanings.add("bothers persistently");
			meanings.add("old horses");
			meanings.add("pesters");
			meanings.add("scolds");
			theWords.put(key, meanings);
			
			key = "nail";
			meanings = new ArrayList <String>();
			meanings.add("fastener");
			theWords.put(key, meanings);
			
			key = "nailed";
			meanings = new ArrayList <String>();
			meanings.add("fixed");
			theWords.put(key, meanings);
			
			key = "naive";
			meanings = new ArrayList <String>();
			meanings.add("green");
			theWords.put(key, meanings);
			
			key = "name";
			meanings = new ArrayList <String>();
			meanings.add("reputation");// seen in i
			meanings.add("title");
			theWords.put(key, meanings);
			
			key = "narcotics";
			meanings = new ArrayList <String>();
			meanings.add("drugs");
			theWords.put(key, meanings);
			
			key = "narnia";
			meanings = new ArrayList <String>();
			meanings.add("magical land");
			theWords.put(key, meanings);
			
			key = "narrate";
			meanings = new ArrayList <String>();
			meanings.add("tell tales");
			theWords.put(key, meanings);
			
			key = "narrowest";
			meanings = new ArrayList <String>();
			meanings.add("least broad");
			theWords.put(key, meanings);
			
			key = "nastier";
			meanings = new ArrayList <String>();
			meanings.add("more unkind");
			theWords.put(key, meanings);
			
			key = "nasty";
			meanings = new ArrayList <String>();
			meanings.add("unkind");
			theWords.put(key, meanings);
			
			key = "natal";
			meanings = new ArrayList <String>();
			meanings.add("part of South Africa");
			theWords.put(key, meanings);
					
			key = "nations";
			meanings = new ArrayList <String>();
			meanings.add("countries");
			theWords.put(key, meanings);
				
			key = "native";
			meanings = new ArrayList <String>();
			meanings.add("someone who lives in a place");
			theWords.put(key, meanings);
			
			key = "natter";
			meanings = new ArrayList <String>();
			meanings.add("chinwag");
			theWords.put(key, meanings);
			
			key = "nattier";
			meanings = new ArrayList <String>();
			meanings.add("being more stylish");
			theWords.put(key, meanings);
			
			key = "navy";
			meanings = new ArrayList <String>();
			meanings.add("many sailors");
			theWords.put(key, meanings);
			
			key = "nay";
			meanings = new ArrayList <String>();
			meanings.add("no");
			theWords.put(key, meanings);
			
			key = "nazareth";
			meanings = new ArrayList <String>();
			meanings.add("biblical city");
			theWords.put(key, meanings);
			
			key = "near";
			meanings = new ArrayList <String>();
			meanings.add("close");
			theWords.put(key, meanings);
			
			key = "neat";
			meanings = new ArrayList <String>();
			meanings.add("tidy");
			meanings.add("without water");
			theWords.put(key, meanings);
			
			key = "nearest";
			meanings = new ArrayList <String>();
			meanings.add("least distant");
			theWords.put(key, meanings);
			
			key = "nebraska";
			meanings = new ArrayList <String>();
			meanings.add("state");
			theWords.put(key, meanings);
					
			key = "needles";
			meanings = new ArrayList <String>();
			meanings.add("pointers");
			theWords.put(key, meanings);
			
			key = "needless";
			meanings = new ArrayList <String>();
			meanings.add("unnecessary");
			theWords.put(key, meanings);
					
			key = "negative";
			meanings = new ArrayList <String>();
			meanings.add("no");
			theWords.put(key, meanings);
			
			key = "nemo";
			meanings = new ArrayList <String>();
			meanings.add("captain");
			theWords.put(key, meanings);
			
			key = "nero";
			meanings = new ArrayList <String>();
			meanings.add("fiddler");
			theWords.put(key, meanings);
			
			key = "nerve";
			meanings = new ArrayList <String>();
			meanings.add("courage");
			theWords.put(key, meanings);
			
			key = "nervous";
			meanings = new ArrayList <String>();
			meanings.add("on edge");
			theWords.put(key, meanings);
			
			key = "ness";
			meanings = new ArrayList <String>();
			meanings.add("loch");
			theWords.put(key, meanings);
			
			key = "nest";
			meanings = new ArrayList <String>();
			meanings.add("home");
			theWords.put(key, meanings);
			
			key = "net";
			meanings = new ArrayList <String>();
			meanings.add("fishing aid");
			meanings.add("trap");
			theWords.put(key, meanings);
			
			key = "nett";
			meanings = new ArrayList <String>();
			meanings.add("after deductions");
			theWords.put(key, meanings);
			
			key = "netting";
			meanings = new ArrayList <String>();
			meanings.add("acquiring money");
			meanings.add("part of the goalpost");
			theWords.put(key, meanings);
					
			key = "never";
			meanings = new ArrayList <String>();
			meanings.add("at no time");
			theWords.put(key, meanings);
			
			key = "neuralgic";
			meanings = new ArrayList <String>();
			meanings.add("nervous pain");
			theWords.put(key, meanings);
			
			key = "neurotic";
			meanings = new ArrayList <String>();
			meanings.add("disturbed person");
			meanings.add("unstable");
			theWords.put(key, meanings);
			
			key = "new";
			meanings = new ArrayList <String>();
			meanings.add("novel");
			theWords.put(key, meanings);
			
			key = "newdelhi"; //New Delhi
			meanings = new ArrayList <String>();
			meanings.add("capital city");
			theWords.put(key, meanings);
			
			key = "neworleans"; //New Orleans
			meanings = new ArrayList <String>();
			meanings.add("Louisiana city");
			theWords.put(key, meanings);
			
			key = "news";
			meanings = new ArrayList <String>();
			meanings.add("information not previously known");
			theWords.put(key, meanings);
			
			key = "newspaper";
			meanings = new ArrayList <String>();
			meanings.add("rag");
			theWords.put(key, meanings);
			
			key = "newton";
			meanings = new ArrayList <String>();
			meanings.add("famous scientist");
			theWords.put(key, meanings);
			
			key = "nib";
			meanings = new ArrayList <String>();
			meanings.add("pen component");
			theWords.put(key, meanings);
			
			key = "nice";
			meanings = new ArrayList <String>();
			meanings.add("French resort");
			meanings.add("pleasant");
			meanings.add("resort");
			theWords.put(key, meanings);
			
			key = "nicer";
			meanings = new ArrayList <String>();
			meanings.add("more enjoyable");
			meanings.add("more pleasant");
			theWords.put(key, meanings);
					
			key = "nicest";
			meanings = new ArrayList <String>();
			meanings.add("most pleasing");
			theWords.put(key, meanings);
			
			key = "nick";
			meanings = new ArrayList <String>();
			meanings.add("pinch");
			meanings.add("steal");
			theWords.put(key, meanings);
			
			key = "nickel";
			meanings = new ArrayList <String>();
			meanings.add("coin");
			meanings.add("metal");
			theWords.put(key, meanings);
			
			key = "niece";
			meanings = new ArrayList <String>();
			meanings.add("relation");
			theWords.put(key, meanings);
			
			key = "niche";
			meanings = new ArrayList <String>();
			meanings.add("corner");
			theWords.put(key, meanings);
			
			key = "nigh";
			meanings = new ArrayList <String>();
			meanings.add("almost");
			theWords.put(key, meanings);
			
			key = "night";
			meanings = new ArrayList <String>();
			meanings.add("darkness");
			meanings.add("time for bed?");
			theWords.put(key, meanings);
			
			key = "nightly";
			meanings = new ArrayList <String>();
			meanings.add("nocturnal");
			theWords.put(key, meanings);
			
			key = "nightowl"; //night owl
			meanings = new ArrayList <String>();
			meanings.add("one's late to bed");
			theWords.put(key, meanings);
			
			key = "nil";
			meanings = new ArrayList <String>();
			meanings.add("nothing");
			theWords.put(key, meanings);
					
			key = "nile";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "nine";
			meanings = new ArrayList <String>();
			meanings.add("number");
			theWords.put(key, meanings);
			
			key = "nips";
			meanings = new ArrayList <String>();
			meanings.add("drinks");
			theWords.put(key, meanings);
			
			key = "nirvana";
			meanings = new ArrayList <String>();
			meanings.add("bliss");
			theWords.put(key, meanings);
			
			key = "nit";
			meanings = new ArrayList <String>();
			meanings.add("fool");
			meanings.add("young louse");
			theWords.put(key, meanings);
			
			key = "nitrate";
			meanings = new ArrayList <String>();
			meanings.add("salt");
			theWords.put(key, meanings);
			
			//this word was only added for test purposes
			//testing augmented anagram + 3 letters
			key = "nitratine";
			meanings = new ArrayList <String>();
			meanings.add("mineral");
			theWords.put(key, meanings);
			
			key = "nirvana";
			meanings = new ArrayList <String>();
			meanings.add("bliss");
			theWords.put(key, meanings);
			
			key = "no";
			meanings = new ArrayList <String>();
			meanings.add("not any");
			meanings.add("vote against");
			theWords.put(key, meanings);
			
			key = "noble";
			meanings = new ArrayList <String>();
			meanings.add("aristocrat");
			theWords.put(key, meanings);
			
			key = "nod";
			meanings = new ArrayList <String>();
			meanings.add("move head");
			meanings.add("sign of agreement");
			theWords.put(key, meanings);
			
			key = "nodice";// no dice
			meanings = new ArrayList <String>();
			meanings.add("negative answer");
			theWords.put(key, meanings);
			
			key = "noel";
			meanings = new ArrayList <String>();
			meanings.add("christmas");
			meanings.add("christmas season");
			theWords.put(key, meanings);
				
			key = "noise";
			meanings = new ArrayList <String>();
			meanings.add("racket");
			theWords.put(key, meanings);
			
			key = "nomad";
			meanings = new ArrayList <String>();
			meanings.add("wanderer");
			theWords.put(key, meanings);

			key = "nonchalant";
			meanings = new ArrayList <String>();
			meanings.add("cool");
			theWords.put(key, meanings);
			
			key = "none";
			meanings = new ArrayList <String>();
			meanings.add("not any");
			theWords.put(key, meanings);
			
			key = "nonplus";
			meanings = new ArrayList <String>();
			meanings.add("perplex");
			theWords.put(key, meanings);
					
			key = "noodles";
			meanings = new ArrayList <String>();
			meanings.add("part of a Chinese meal, perhaps");
			theWords.put(key, meanings);
			
			key = "nook";
			meanings = new ArrayList <String>();
			meanings.add("corner");
			meanings.add("recess");
			theWords.put(key, meanings);
			
			key = "noon";
			meanings = new ArrayList <String>();
			meanings.add("midday");
			theWords.put(key, meanings);
			
			key = "nora";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "norm";
			meanings = new ArrayList <String>();
			meanings.add("standard");
			theWords.put(key, meanings);
			
			key = "norma";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "norman";
			meanings = new ArrayList <String>();
			meanings.add("frenchman");
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "north";
			meanings = new ArrayList <String>();
			meanings.add("direction");
			theWords.put(key, meanings);
			
			key = "northern";
			meanings = new ArrayList <String>();
			meanings.add("from Newcastle, for example");
			theWords.put(key, meanings);
			
			key = "nose";
			meanings = new ArrayList <String>();
			meanings.add("snout");
			theWords.put(key, meanings);
			
			key = "nosebleed";
			meanings = new ArrayList <String>();
			meanings.add("losing blood");
			theWords.put(key, meanings);
			
			key = "nosh";
			meanings = new ArrayList <String>();
			meanings.add("food");
			theWords.put(key, meanings);
			
			key = "nostalgia";
			meanings = new ArrayList <String>();
			meanings.add("remebrance");
			meanings.add("remebrance of things past");
			theWords.put(key, meanings);
			
			key = "not";
			meanings = new ArrayList <String>();
			meanings.add("Boolean operator");
			theWords.put(key, meanings);
			
			key = "note";
			meanings = new ArrayList <String>();
			meanings.add("observe");
			meanings.add("paper money");
			meanings.add("short letter");
			theWords.put(key, meanings);
			
			key = "noted";
			meanings = new ArrayList <String>();
			meanings.add("famous");
			theWords.put(key, meanings);
			
			key = "notelet";
			meanings = new ArrayList <String>();
			meanings.add("short letter");
			theWords.put(key, meanings);
					
			key = "notes";
			meanings = new ArrayList <String>();
			meanings.add("musical sounds");
			meanings.add("records");
			theWords.put(key, meanings);
			
			key = "nothing";
			meanings = new ArrayList <String>();
			meanings.add("nil");
			theWords.put(key, meanings);
			
			key = "noticed";
			meanings = new ArrayList <String>();
			meanings.add("seen");
			theWords.put(key, meanings);
			
			key = "nought";
			meanings = new ArrayList <String>();
			meanings.add("nil");
			theWords.put(key, meanings);
			
			key = "nova";
			meanings = new ArrayList <String>();
			meanings.add("star");
			theWords.put(key, meanings);
			
			key = "novel";
			meanings = new ArrayList <String>();
			meanings.add("book");
			theWords.put(key, meanings);
			
			key = "now";
			meanings = new ArrayList <String>();
			meanings.add("immediately");
			meanings.add("today");
			theWords.put(key, meanings);
			
			key = "noxious";
			meanings = new ArrayList <String>();
			meanings.add("poisonous");
			theWords.put(key, meanings);
			
			key = "nude";
			meanings = new ArrayList <String>();
			meanings.add("naked");
			theWords.put(key, meanings);
			
			key = "nuisances";
			meanings = new ArrayList <String>();
			meanings.add("pests");
			theWords.put(key, meanings);
			
			key = "numb";
			meanings = new ArrayList <String>();
			meanings.add("unfeeling");
			theWords.put(key, meanings);
			
			key = "number";
			meanings = new ArrayList <String>();
			meanings.add("amount");
			theWords.put(key, meanings);
			
			key = "nuncio";
			meanings = new ArrayList <String>();
			meanings.add("papal ambassador");
			theWords.put(key, meanings);
			
			key = "nurse";
			meanings = new ArrayList <String>();
			meanings.add("tend");
			theWords.put(key, meanings);
			
			key = "nursing";
			meanings = new ArrayList <String>();
			meanings.add("looking after");
			meanings.add("profession");
			meanings.add("tending");
			theWords.put(key, meanings);
			
			key = "nut";
			meanings = new ArrayList <String>();
			meanings.add("maniac");
			theWords.put(key, meanings);
			
			key = "nylon";
			meanings = new ArrayList <String>();
			meanings.add("stocking material");
			theWords.put(key, meanings);

		}//end loadN
		
		public void loadOWords() {
			String key;
			ArrayList <String> meanings;
			
			//load o's
			key = "oak";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			theWords.put(key, meanings);
			
			key = "oat";
			meanings = new ArrayList <String>();
			meanings.add("cereal");
			theWords.put(key, meanings);
			
			key = "oatcake";
			meanings = new ArrayList <String>();
			meanings.add("Scottish biscuit");
			theWords.put(key, meanings);
			
			key = "oath";
			meanings = new ArrayList <String>();
			meanings.add("promise");
			theWords.put(key, meanings);
			
			key = "oatmeal";
			meanings = new ArrayList <String>();
			meanings.add("food");
			theWords.put(key, meanings);
			
			key = "oats";
			meanings = new ArrayList <String>();
			meanings.add("cereal");
			theWords.put(key, meanings);
			
			key = "obey";
			meanings = new ArrayList <String>();
			meanings.add("take orders");
			theWords.put(key, meanings);
			
			key = "oblong";
			meanings = new ArrayList <String>();
			meanings.add("shape");
			theWords.put(key, meanings);
			
			key = "oboes";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
			
			key = "obnoxious";
			meanings = new ArrayList <String>();
			meanings.add("offensive");
			theWords.put(key, meanings);
			
			key = "obscene";
			meanings = new ArrayList <String>();
			meanings.add("disgusting");
			theWords.put(key, meanings);
			
			key = "obscure";
			meanings = new ArrayList <String>();
			meanings.add("not easily understood");
			theWords.put(key, meanings);
			
			key = "obscurity";
			meanings = new ArrayList <String>();
			meanings.add("unimportance");
			theWords.put(key, meanings);
			
			key = "observe";
			meanings = new ArrayList <String>();
			meanings.add("watch");
			theWords.put(key, meanings);
			
			key = "obsolete";
			meanings = new ArrayList <String>();
			meanings.add("out of date");
			theWords.put(key, meanings);
			
			key = "obstinate";
			meanings = new ArrayList <String>();
			meanings.add("contrary");
			meanings.add("stubborn");
			theWords.put(key, meanings);
					
			key = "obtain";
			meanings = new ArrayList <String>();
			meanings.add("get");
			theWords.put(key, meanings);
					
			key = "ocean";
			meanings = new ArrayList <String>();
			meanings.add("sea");
			theWords.put(key, meanings);
			
			key = "ocelots";
			meanings = new ArrayList <String>();
			meanings.add("cats");
			theWords.put(key, meanings);
			
			key = "octet";
			meanings = new ArrayList <String>();
			meanings.add("group of eight");
			theWords.put(key, meanings);
			
			key = "octopus";
			meanings = new ArrayList <String>();
			meanings.add("denizen of the deep");
			theWords.put(key, meanings);
			
			key = "odd";
			meanings = new ArrayList <String>();
			meanings.add("rum");
			meanings.add("strange");
			theWords.put(key, meanings);
			
			key = "oddest";
			meanings = new ArrayList <String>();
			meanings.add("most peculiar");
			theWords.put(key, meanings);
			
			key = "oddity";
			meanings = new ArrayList <String>();
			meanings.add("peculiar thing");
			theWords.put(key, meanings);
			
			key = "oddson"; //odds on
			meanings = new ArrayList <String>();
			meanings.add("better than even chance");
			meanings.add("very likely to happen");
			theWords.put(key, meanings);
			
			key = "ode";
			meanings = new ArrayList <String>();
			meanings.add("poem");
			theWords.put(key, meanings);
			
			key = "odes";
			meanings = new ArrayList <String>();
			meanings.add("poems");
			theWords.put(key, meanings);
			
			key = "odessa";
			meanings = new ArrayList <String>();
			meanings.add("Black Sea port");
			theWords.put(key, meanings);
			
			key = "odin";
			meanings = new ArrayList <String>();
			meanings.add("Norse god");
			theWords.put(key, meanings);
			
			key = "odourless";
			meanings = new ArrayList <String>();
			meanings.add("lacking scent");
			theWords.put(key, meanings);
			
			key = "of";
			meanings = new ArrayList <String>();
			meanings.add("from");
			theWords.put(key, meanings);
			
			key = "off";
			meanings = new ArrayList <String>();
			meanings.add("absent");
			meanings.add("not on");
			meanings.add("on holiday");
			meanings.add("rancid");
			meanings.add("start of race");
			theWords.put(key, meanings);
			
			key = "offal";
			meanings = new ArrayList <String>();
			meanings.add("waste meat");
			theWords.put(key, meanings);
			
			key = "offbeat";
			meanings = new ArrayList <String>();
			meanings.add("eccentric");
			theWords.put(key, meanings);
			
			key = "offer";
			meanings = new ArrayList <String>();
			meanings.add("tender");
			theWords.put(key, meanings);
			
			key = "offhand";
			meanings = new ArrayList <String>();
			meanings.add("casual");
			theWords.put(key, meanings);
			
			key = "official";
			meanings = new ArrayList <String>();
			meanings.add("formal");
			theWords.put(key, meanings);
			
			key = "oft";
			meanings = new ArrayList <String>();
			meanings.add("many a time");
			theWords.put(key, meanings);
			
			key = "often";
			meanings = new ArrayList <String>();
			meanings.add("frequently");
			theWords.put(key, meanings);
			
			key = "ogle";
			meanings = new ArrayList <String>();
			meanings.add("leer");
			theWords.put(key, meanings);
			
			key = "ogling";
			meanings = new ArrayList <String>();
			meanings.add("leering");
			theWords.put(key, meanings);
			
			key = "ok";
			meanings = new ArrayList <String>();
			meanings.add("acceptable");
			meanings.add("all right");
			meanings.add("approval");
			meanings.add("go ahead");
			theWords.put(key, meanings);
			
			key = "oil";
			meanings = new ArrayList <String>();
			meanings.add("lubricate");
			meanings.add("petroleum");
			theWords.put(key, meanings);
			
			key = "oils";
			meanings = new ArrayList <String>();
			meanings.add("lubricates");
			meanings.add("puts grease on");
			theWords.put(key, meanings);
			
			key = "oilskin";
			meanings = new ArrayList <String>();
			meanings.add("protective coat");
			theWords.put(key, meanings);
			
			key = "oiled";
			meanings = new ArrayList <String>();
			meanings.add("drunk");
			theWords.put(key, meanings);
			
			key = "ointment";
			meanings = new ArrayList <String>();
			meanings.add("medicinal cream");
			theWords.put(key, meanings);
					
			key = "okra";
			meanings = new ArrayList <String>();
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "old";
			meanings = new ArrayList <String>();
			meanings.add("ancient");
			meanings.add("not new");
			theWords.put(key, meanings);
			
			key = "olden";
			meanings = new ArrayList <String>();
			meanings.add("of former times");
			theWords.put(key, meanings);
			
			key = "ole";
			meanings = new ArrayList <String>();
			meanings.add("Spanish cry");
			theWords.put(key, meanings);
			
			key = "olympus";
			meanings = new ArrayList <String>();
			meanings.add("Greek mountain");
			theWords.put(key, meanings);
			
			key = "omen";
			meanings = new ArrayList <String>();
			meanings.add("sign");
			theWords.put(key, meanings);
					
			key = "omit";
			meanings = new ArrayList <String>();
			meanings.add("leave out");
			theWords.put(key, meanings);
			
			key = "omitted";
			meanings = new ArrayList <String>();
			meanings.add("left out");
			theWords.put(key, meanings);
			
			key = "on";
			meanings = new ArrayList <String>();
			meanings.add("appearing");
			meanings.add("performing");
			meanings.add("supported by");
			meanings.add("working");
			theWords.put(key, meanings);
					
			key = "once";
			meanings = new ArrayList <String>();
			meanings.add("at some time");
			meanings.add("formerely");
			theWords.put(key, meanings);
			
			key = "one";
			meanings = new ArrayList <String>();
			meanings.add("number");
			meanings.add("unit");
			theWords.put(key, meanings);
			
			key = "onerous";
			meanings = new ArrayList <String>();
			meanings.add("weighty");
			theWords.put(key, meanings);
			
			key = "onus";
			meanings = new ArrayList <String>();
			meanings.add("responsibility");
			theWords.put(key, meanings);
			
			key = "oodles";
			meanings = new ArrayList <String>();
			meanings.add("lots");
			theWords.put(key, meanings);
			
			key = "opal";
			meanings = new ArrayList <String>();
			meanings.add("jewel");
			theWords.put(key, meanings);
			
			key = "open";
			meanings = new ArrayList <String>();
			meanings.add("golf tournament");
			meanings.add("sporting competition");
			meanings.add("unlocked");
			meanings.add("unrestricted");
			theWords.put(key, meanings);
			
			key = "openair"; //open air
			meanings = new ArrayList <String>();
			meanings.add("out of doors");
			theWords.put(key, meanings);
			
			key = "openly";
			meanings = new ArrayList <String>();
			meanings.add("freely");
			theWords.put(key, meanings);
			
			key = "opera";
			meanings = new ArrayList <String>();
			meanings.add("several works");
			meanings.add("musical drama");
			meanings.add("musical entertainment");
			theWords.put(key, meanings);
			
			key = "operate";
			meanings = new ArrayList <String>();
			meanings.add("handle");
			meanings.add("manage");
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "operation";
			meanings = new ArrayList <String>();
			meanings.add("surgery");
			theWords.put(key, meanings);
			
			key = "operetta";
			meanings = new ArrayList <String>();
			meanings.add("show");
			theWords.put(key, meanings);
			
			key = "opinion";
			meanings = new ArrayList <String>();
			meanings.add("personal belief");
			meanings.add("view");
			theWords.put(key, meanings);
			
			key = "oppress";
			meanings = new ArrayList <String>();
			meanings.add("persecute");
			theWords.put(key, meanings);
					
			key = "opus";
			meanings = new ArrayList <String>();
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "or";
			meanings = new ArrayList <String>();
			meanings.add("either");
			theWords.put(key, meanings);
			
			key = "orange";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "oranges";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "orate";
			meanings = new ArrayList <String>();
			meanings.add("give a speech");
			meanings.add("speak publicly");
			meanings.add("speak pompously");
			theWords.put(key, meanings);
			
			key = "orated";
			meanings = new ArrayList <String>();
			meanings.add("provided a speech");
			theWords.put(key, meanings);
					
			key = "oration";
			meanings = new ArrayList <String>();
			meanings.add("lecture");
			meanings.add("speech");
			theWords.put(key, meanings);
			
			key = "orb";
			meanings = new ArrayList <String>();
			meanings.add("globe");
			theWords.put(key, meanings);
			
			key = "orchestra";
			meanings = new ArrayList <String>();
			meanings.add("musicians");
			theWords.put(key, meanings);
			
			key = "ordain";
			meanings = new ArrayList <String>();
			meanings.add("decree");
			theWords.put(key, meanings);
			
			key = "ordeal";
			meanings = new ArrayList <String>();
			meanings.add("trial");
			theWords.put(key, meanings);
			
			key = "ordinarily";
			meanings = new ArrayList <String>();
			meanings.add("normally");
			theWords.put(key, meanings);
					
			key = "ordnance";
			meanings = new ArrayList <String>();
			meanings.add("artillery");
			theWords.put(key, meanings);
					
			key = "ore";
			meanings = new ArrayList <String>();
			meanings.add("output of mine");
			meanings.add("swedish money");
			theWords.put(key, meanings);
			
			key = "organ";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
			
			key = "organism";
			meanings = new ArrayList <String>();
			meanings.add("living thing");
			theWords.put(key, meanings);
			
			key = "organist";
			meanings = new ArrayList <String>();
			meanings.add("musician");
			theWords.put(key, meanings);
			
			key = "ornate";
			meanings = new ArrayList <String>();
			meanings.add("elaborate");
			meanings.add("elaborately decorated");
			meanings.add("fancy");
			theWords.put(key, meanings);
			
			key = "ornately";
			meanings = new ArrayList <String>();
			meanings.add("flamboyantly");
			theWords.put(key, meanings);
			
			key = "oscar";
			meanings = new ArrayList <String>();
			meanings.add("film award");
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "ostler";
			meanings = new ArrayList <String>();
			meanings.add("stable boy");
			theWords.put(key, meanings);
			
			key = "othello";
			meanings = new ArrayList <String>();
			meanings.add("Shakespearean character");
			theWords.put(key, meanings);
			
			key = "other";
			meanings = new ArrayList <String>();
			meanings.add("alternative");
			theWords.put(key, meanings);
			
			key = "otis";
			meanings = new ArrayList <String>();
			meanings.add("manf");
			theWords.put(key, meanings);
			
			key = "otter";
			meanings = new ArrayList <String>();
			meanings.add("aquatic creature");
			theWords.put(key, meanings);
			
			key = "otters";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			theWords.put(key, meanings);
			
			key = "ought";
			meanings = new ArrayList <String>();
			meanings.add("should be");
			theWords.put(key, meanings);
			
			key = "ounce";
			meanings = new ArrayList <String>();
			meanings.add("weight");
			theWords.put(key, meanings);
			
			key = "our";
			meanings = new ArrayList <String>();
			meanings.add("belonging to");
			theWords.put(key, meanings);
			
			key = "ours";
			meanings = new ArrayList <String>();
			meanings.add("belonging to us");
			theWords.put(key, meanings);
			
			key = "out";
			meanings = new ArrayList <String>();
			meanings.add("not at home");
			theWords.put(key, meanings);
			
			key = "outcast";
			meanings = new ArrayList <String>();
			meanings.add("pariah");
			theWords.put(key, meanings);
			
			key = "outer";
			meanings = new ArrayList <String>();
			meanings.add("exterior");
			theWords.put(key, meanings);
			
			key = "outfit";
			meanings = new ArrayList <String>();
			meanings.add("clothes");
			meanings.add("company");
			theWords.put(key, meanings);
			
			key = "outlaw";
			meanings = new ArrayList <String>();
			meanings.add("ban");
			meanings.add("bandit");
			theWords.put(key, meanings);
			
			key = "outpace";
			meanings = new ArrayList <String>();
			meanings.add("exceed");
			meanings.add("surpass");
			theWords.put(key, meanings);
			
			key = "outrage";
			meanings = new ArrayList <String>();
			meanings.add("anger");
			meanings.add("fury");
			meanings.add("indignation");
			theWords.put(key, meanings);
			
			key = "outsider";
			meanings = new ArrayList <String>();
			meanings.add("stranger");
			theWords.put(key, meanings);
			
			key = "oval";
			meanings = new ArrayList <String>();
			meanings.add("shape");
			theWords.put(key, meanings);
			
			key = "ovaries";
			meanings = new ArrayList <String>();
			meanings.add("organs");
			theWords.put(key, meanings);
			
			key = "ovation";
			meanings = new ArrayList <String>();
			meanings.add("applause");
			theWords.put(key, meanings);
			
			key = "over";
			meanings = new ArrayList <String>();
			meanings.add("cricket period");
			meanings.add("finished");
			meanings.add("six deliveries");
			theWords.put(key, meanings);
			
			key = "overlook";
			meanings = new ArrayList <String>();
			meanings.add("ignore");
			meanings.add("survey");
			theWords.put(key, meanings);
			
			key = "overt";
			meanings = new ArrayList <String>();
			meanings.add("frank");
			meanings.add("unconcealed");
			theWords.put(key, meanings);
			
			key = "ovid";
			meanings = new ArrayList <String>();
			meanings.add("Roman poet");
			theWords.put(key, meanings);
			
			key = "owing";
			meanings = new ArrayList <String>();
			meanings.add("in debt");
			theWords.put(key, meanings);
			
			key = "owl";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "owlet";
			meanings = new ArrayList <String>();
			meanings.add("little bird");
			theWords.put(key, meanings);
			
			key = "owls";
			meanings = new ArrayList <String>();
			meanings.add("birds");
			meanings.add("hooters");
			theWords.put(key, meanings);
			
			key = "ox";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "oxford";
			meanings = new ArrayList <String>();
			meanings.add("university city");
			theWords.put(key, meanings);
			
			key = "oyster";
			meanings = new ArrayList <String>();
			meanings.add("marine creature");
			theWords.put(key, meanings);
			
			key = "ozone";
			meanings = new ArrayList <String>();
			meanings.add("atmosphere layer");
			theWords.put(key, meanings);

		}//end loadOWords
		
		public TreeMap<String, ArrayList<String>> loadPWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load p's
			key = "pace";
			meanings = new ArrayList <String>();
			meanings.add("speed");
			meanings.add("step");
			meanings.add("rate");
			theWords.put(key, meanings);
			
			key = "paces";
			meanings = new ArrayList <String>();
			meanings.add("steps");
			theWords.put(key, meanings);
			
			key = "pacing";
			meanings = new ArrayList <String>();
			meanings.add("regulating speed");
			meanings.add("speed");
			meanings.add("striding");
			theWords.put(key, meanings);
			
			key = "pact";
			meanings = new ArrayList <String>();
			meanings.add("agreement");
			theWords.put(key, meanings);
			
			key = "pacy";
			meanings = new ArrayList <String>();
			meanings.add("fast moving");
			theWords.put(key, meanings);
			
			key = "page";
			meanings = new ArrayList <String>();
			meanings.add("attendant");
			meanings.add("summon");
			theWords.put(key, meanings);
			
			key = "pageant";
			meanings = new ArrayList <String>();
			meanings.add("procession");
			theWords.put(key, meanings);
			
			key = "pail";
			meanings = new ArrayList <String>();
			meanings.add("bucket");
			theWords.put(key, meanings);
			
			key = "pain";
			meanings = new ArrayList <String>();
			meanings.add("ache");
			meanings.add("nuisance");
			theWords.put(key, meanings);
			
			key = "painless";
			meanings = new ArrayList <String>();
			meanings.add("uncomplicated");
			theWords.put(key, meanings);
			
			key = "painter";
			meanings = new ArrayList <String>();
			meanings.add("decorator");
			meanings.add("artist");
			theWords.put(key, meanings);
			
			key = "paint";
			meanings = new ArrayList <String>();
			meanings.add("portray");
			theWords.put(key, meanings);
			
			key = "paints";
			meanings = new ArrayList <String>();
			meanings.add("depicts");
			theWords.put(key, meanings);
			
			key = "pair";
			meanings = new ArrayList <String>();
			meanings.add("couple");
			meanings.add("two");
			theWords.put(key, meanings);
			
			key = "pairs";
			meanings = new ArrayList <String>();
			meanings.add("couples");
			theWords.put(key, meanings);
			
			key = "pal";
			meanings = new ArrayList <String>();
			meanings.add("friend");
			theWords.put(key, meanings);
			
			key = "palace";
			meanings = new ArrayList <String>();
			meanings.add("ruler's official residence");
			theWords.put(key, meanings);
			
			key = "palaver";
			meanings = new ArrayList <String>();
			meanings.add("rigmarole");
			theWords.put(key, meanings);
			
			key = "pale";
			meanings = new ArrayList <String>();
			meanings.add("ashen");
			theWords.put(key, meanings);
			
			key = "paler";
			meanings = new ArrayList <String>();
			meanings.add("lighter");
			theWords.put(key, meanings);
			
			key = "palette";
			meanings = new ArrayList <String>();
			meanings.add("mixing board");
			theWords.put(key, meanings);
			
			key = "paltry";
			meanings = new ArrayList <String>();
			meanings.add("insignificant");
			theWords.put(key, meanings);
			
			key = "pan";
			meanings = new ArrayList <String>();
			meanings.add("criticise");
			meanings.add("god");
			meanings.add("kitchen utensil");
			theWords.put(key, meanings);
			
			key = "pangs";
			meanings = new ArrayList <String>();
			meanings.add("twinges of conscience");
			theWords.put(key, meanings);
			
			key = "panama";
			meanings = new ArrayList <String>();
			meanings.add("canal");
			meanings.add("country");
			meanings.add("South American canal");
			theWords.put(key, meanings);
			
			key = "panic";
			meanings = new ArrayList <String>();
			meanings.add("alarm");
			theWords.put(key, meanings);
			
			key = "panics";
			meanings = new ArrayList <String>();
			meanings.add("alarms");
			theWords.put(key, meanings);
			
			key = "panorama";
			meanings = new ArrayList <String>();
			meanings.add("extensive view");
			meanings.add("view");
			theWords.put(key, meanings);
			
			key = "pans";
			meanings = new ArrayList <String>();
			meanings.add("pots");
			theWords.put(key, meanings);
			
			key = "pansy";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			theWords.put(key, meanings);
			
			key = "pant";
			meanings = new ArrayList <String>();
			meanings.add("breathe heavily");
			meanings.add("gasp");
			meanings.add("wheeze");
			theWords.put(key, meanings);
			
			key = "panthers";
			meanings = new ArrayList <String>();
			meanings.add("wild cats");
			theWords.put(key, meanings);
			
			key = "panto";
			meanings = new ArrayList <String>();
			meanings.add("seasonal entertainment");
			theWords.put(key, meanings);
			
			key = "pants";
			meanings = new ArrayList <String>();
			meanings.add("clothing");
			meanings.add("garments");
			theWords.put(key, meanings);
			
			key = "paper";
			meanings = new ArrayList <String>();
			meanings.add("material made from wood");
			meanings.add("decorate");
			theWords.put(key, meanings);
			
			key = "paperbacks";
			meanings = new ArrayList <String>();
			meanings.add("books");
			theWords.put(key, meanings);
			
			key = "papers";
			meanings = new ArrayList <String>();
			meanings.add("documents");
			theWords.put(key, meanings);
			
			key = "par";
			meanings = new ArrayList <String>();
			meanings.add("average");
			theWords.put(key, meanings);
			
			key = "parade";
			meanings = new ArrayList <String>();
			meanings.add("air");
			meanings.add("display");
			theWords.put(key, meanings);
			
			key = "paradise";
			meanings = new ArrayList <String>();
			meanings.add("heaven");
			theWords.put(key, meanings);
			
			key = "parent";
			meanings = new ArrayList <String>();
			meanings.add("guardian");
			theWords.put(key, meanings);
			
			key = "paris";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "parish";
			meanings = new ArrayList <String>();
			meanings.add("churchgoers");
			theWords.put(key, meanings);
			
			key = "park";
			meanings = new ArrayList <String>();
			meanings.add("leave car");
			meanings.add("recreation area");
			theWords.put(key, meanings);
			
			key = "parka";
			meanings = new ArrayList <String>();
			meanings.add("coat");
			theWords.put(key, meanings);
			
			key = "parley";
			meanings = new ArrayList <String>();
			meanings.add("conference");
			theWords.put(key, meanings);
			
			key = "parmesan";
			meanings = new ArrayList <String>();
			meanings.add("cheese");
			meanings.add("hard cheese");
			theWords.put(key, meanings);
			
			key = "part";
			meanings = new ArrayList <String>();
			meanings.add("fraction");
			meanings.add("role");
			theWords.put(key, meanings);
			
			key = "particulars";
			meanings = new ArrayList <String>();
			meanings.add("details");
			theWords.put(key, meanings);
			
			key = "partly";
			meanings = new ArrayList <String>();
			meanings.add("somewhat");
			theWords.put(key, meanings);
			
			key = "parse";
			meanings = new ArrayList <String>();
			meanings.add("analyse");
			meanings.add("split into pieces");
			theWords.put(key, meanings);
			
			key = "parsley";
			meanings = new ArrayList <String>();
			meanings.add("herb");
			theWords.put(key, meanings);
			
			key = "parsnips";
			meanings = new ArrayList <String>();
			meanings.add("vegetables");
			theWords.put(key, meanings);
			
			key = "part";
			meanings = new ArrayList <String>();
			meanings.add("role");
			theWords.put(key, meanings);
			
			key = "party";
			meanings = new ArrayList <String>();
			meanings.add("political group");
			theWords.put(key, meanings);
			
			key = "pass";
			meanings = new ArrayList <String>();
			meanings.add("entry document");
			meanings.add("don't ask me");
			theWords.put(key, meanings);
			
			key = "passed";
			meanings = new ArrayList <String>();
			meanings.add("didn't fail");
			theWords.put(key, meanings);
			
			key = "past";
			meanings = new ArrayList <String>();
			meanings.add("finished");
			theWords.put(key, meanings);
			
			key = "pasta";
			meanings = new ArrayList <String>();
			meanings.add("dish from Italy");
			theWords.put(key, meanings);
			
			key = "pat";
			meanings = new ArrayList <String>();
			meanings.add("postman");
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "patch";
			meanings = new ArrayList <String>();
			meanings.add("eye protector");
			theWords.put(key, meanings);
			
			key = "patriot";
			meanings = new ArrayList <String>();
			meanings.add("nationalist");
			theWords.put(key, meanings);
			
			key = "patriotic";
			meanings = new ArrayList <String>();
			meanings.add("nationalistic");
			theWords.put(key, meanings);
			
			key = "patella";
			meanings = new ArrayList <String>();
			meanings.add("kneecap");
			theWords.put(key, meanings);
			
			key = "paul";
			meanings = new ArrayList <String>();
			meanings.add("man");
			meanings.add("saint");
			theWords.put(key, meanings);
			
			key = "paw";
			meanings = new ArrayList <String>();
			meanings.add("animal's foot");
			theWords.put(key, meanings);
			
			key = "pay";
			meanings = new ArrayList <String>();
			meanings.add("income");
			theWords.put(key, meanings);
			
			key = "payphone";
			meanings = new ArrayList <String>();
			meanings.add("communications device");
			theWords.put(key, meanings);
			
			key = "pea";
			meanings = new ArrayList <String>();
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "peace";
			meanings = new ArrayList <String>();
			meanings.add("serenity");
			meanings.add("tranquility");
			theWords.put(key, meanings);
					
			key = "peach";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "peak";
			meanings = new ArrayList <String>();
			meanings.add("highest position");
			theWords.put(key, meanings);

			key = "peal";
			meanings = new ArrayList <String>();
			meanings.add("chime");
			theWords.put(key, meanings);
			
			key = "peanut";
			meanings = new ArrayList <String>();
			meanings.add("snack");
			meanings.add("inadequate sum of money");
			meanings.add("very little money");
			theWords.put(key, meanings);
					
			key = "peanuts";
			meanings = new ArrayList <String>();
			meanings.add("inadequate sum of money");
			meanings.add("cartoon strip");
			theWords.put(key, meanings);
			
			key = "pear";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "pearl";
			meanings = new ArrayList <String>();
			meanings.add("contents of oyster");
			theWords.put(key, meanings);
			
			key = "pears";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "peas";
			meanings = new ArrayList <String>();
			meanings.add("vegetables");
			theWords.put(key, meanings);
					
			key = "peasant";
			meanings = new ArrayList <String>();
			meanings.add("countryman");
			theWords.put(key, meanings);
			
			key = "pedant";
			meanings = new ArrayList <String>();
			meanings.add("stickler");
			theWords.put(key, meanings);
			
			key = "pedometer";
			meanings = new ArrayList <String>();
			meanings.add("it measures the steps taken");
			theWords.put(key, meanings);
			
			key = "peerage";
			meanings = new ArrayList <String>();
			meanings.add("aristocracy");
			theWords.put(key, meanings);
			
			key = "peered";
			meanings = new ArrayList <String>();
			meanings.add("looked");
			theWords.put(key, meanings);
			
			key = "pele";
			meanings = new ArrayList <String>();
			meanings.add("footballer");
			theWords.put(key, meanings);
			
			key = "pellet";
			meanings = new ArrayList <String>();
			meanings.add("little ball");
			theWords.put(key, meanings);
			
			key = "pelmet";
			meanings = new ArrayList <String>();
			meanings.add("ornamental drapery");
			theWords.put(key, meanings);
			
			key = "pelvis";
			meanings = new ArrayList <String>();
			meanings.add("bony structure");
			theWords.put(key, meanings);
			
			key = "pen";
			meanings = new ArrayList <String>();
			meanings.add("female swan");
			meanings.add("writer");
			theWords.put(key, meanings);
			
			key = "pens";
			meanings = new ArrayList <String>();
			meanings.add("female swans");
			meanings.add("writers");
			theWords.put(key, meanings);
			
			key = "penchant";
			meanings = new ArrayList <String>();
			meanings.add("fondness");
			theWords.put(key, meanings);
			
			key = "pent";
			meanings = new ArrayList <String>();
			meanings.add("cooped up");
			theWords.put(key, meanings);
			
			key = "pentangle";
			meanings = new ArrayList <String>();
			meanings.add("magical shape");
			theWords.put(key, meanings);
			
			key = "people";
			meanings = new ArrayList <String>();
			meanings.add("nation");
			theWords.put(key, meanings);
			
			key = "per";
			meanings = new ArrayList <String>();
			meanings.add("for each");
			theWords.put(key, meanings);
			
			key = "period";
			meanings = new ArrayList <String>();
			meanings.add("full stop");
			meanings.add("time");
			theWords.put(key, meanings);
			
			key = "persia";
			meanings = new ArrayList <String>();
			meanings.add("old country");
			theWords.put(key, meanings);
			
			key = "persist";
			meanings = new ArrayList <String>();
			meanings.add("carry on");
			theWords.put(key, meanings);
			
			key = "person";
			meanings = new ArrayList <String>();
			meanings.add("human being");
			theWords.put(key, meanings);
			
			key = "personal";
			meanings = new ArrayList <String>();
			meanings.add("private");
			theWords.put(key, meanings);
			
			key = "pest";
			meanings = new ArrayList <String>();
			meanings.add("nuisance");
			theWords.put(key, meanings);
			
			key = "pestle";
			meanings = new ArrayList <String>();
			meanings.add("pounding tool");
			theWords.put(key, meanings);
			
			key = "pet";
			meanings = new ArrayList <String>();
			meanings.add("domesticated animal");
			meanings.add("favourite");
			theWords.put(key, meanings);
			
			key = "peter";
			meanings = new ArrayList <String>();
			meanings.add("saint");
			theWords.put(key, meanings);
			
			key = "petite";
			meanings = new ArrayList <String>();
			meanings.add("little");
			meanings.add("small");
			theWords.put(key, meanings);
			
			key = "petitioner";
			meanings = new ArrayList <String>();
			meanings.add("one wit a suit");
			theWords.put(key, meanings);
			
			key = "petunia";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			theWords.put(key, meanings);
			
			key = "pew";
			meanings = new ArrayList <String>();
			meanings.add("seat");
			theWords.put(key, meanings);
			
			key = "phantom";
			meanings = new ArrayList <String>();
			meanings.add("spirit");
			theWords.put(key, meanings);
			
			key = "pheasant";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "photo";
			meanings = new ArrayList <String>();
			meanings.add("snap");
			theWords.put(key, meanings);
			
			key = "photos";
			meanings = new ArrayList <String>();
			meanings.add("pics");
			theWords.put(key, meanings);
			
			key = "piano";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
				
			key = "pic";
			meanings = new ArrayList <String>();
			meanings.add("card with a face on it");//??
			meanings.add("little picture");
			theWords.put(key, meanings);
			
			key = "picas";
			meanings = new ArrayList <String>();
			meanings.add("units of measurement");
			theWords.put(key, meanings);
			
			key = "picasso";
			meanings = new ArrayList <String>();
			meanings.add("painter");
			theWords.put(key, meanings);
			
			key = "pickle";
			meanings = new ArrayList <String>();
			meanings.add("difficult situation");
			meanings.add("relish");
			theWords.put(key, meanings);

			key = "pie";
			meanings = new ArrayList <String>();
			meanings.add("food");
			meanings.add("something to eat");
			theWords.put(key, meanings);
			
			key = "pier";
			meanings = new ArrayList <String>();
			meanings.add("jetty");
			meanings.add("seaside attraction");
			theWords.put(key, meanings);
			
			key = "pierce";
			meanings = new ArrayList <String>();
			meanings.add("make hole in");
			meanings.add("skewer");
			theWords.put(key, meanings);
			
			key = "pig";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("porker");
			theWords.put(key, meanings);
			
			key = "pigs";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			meanings.add("porkers");
			theWords.put(key, meanings);
			
			key = "piglet";
			meanings = new ArrayList <String>();
			meanings.add("small animal");
			theWords.put(key, meanings);
			
			key = "pigs";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			meanings.add("porkers");
			theWords.put(key, meanings);
			
			key = "pile";
			meanings = new ArrayList <String>();
			meanings.add("heap");
			theWords.put(key, meanings);
			
			key = "pilot";
			meanings = new ArrayList <String>();
			meanings.add("aviator");
			theWords.put(key, meanings);
			
			key = "pin";
			meanings = new ArrayList <String>();
			meanings.add("fastener");
			theWords.put(key, meanings);
			
			key = "pine";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			theWords.put(key, meanings);
			
			key = "pineapple";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "ping";
			meanings = new ArrayList <String>();
			meanings.add("noise");
			theWords.put(key, meanings);
			
			key = "pings";
			meanings = new ArrayList <String>();
			meanings.add("high-pitched sounds");
			theWords.put(key, meanings);
			
			key = "pinion";
			meanings = new ArrayList <String>();
			meanings.add("wing");
			theWords.put(key, meanings);
			
			key = "pint";
			meanings = new ArrayList <String>();
			meanings.add("unit of volume");
			meanings.add("beer");
			theWords.put(key, meanings);
			
			key = "pious";
			meanings = new ArrayList <String>();
			meanings.add("devout");
			theWords.put(key, meanings);
			
			key = "pirate";
			meanings = new ArrayList <String>();
			meanings.add("villan at sea");
			meanings.add("illegaly copy");
			theWords.put(key, meanings);
			
			key = "piste";
			meanings = new ArrayList <String>();
			meanings.add("ski slope");
			theWords.put(key, meanings);
					
			key = "pit";
			meanings = new ArrayList <String>();
			meanings.add("mine");
			theWords.put(key, meanings);
			
			key = "pitchers";
			meanings = new ArrayList <String>();
			meanings.add("baseball players");
			meanings.add("vessels");
			theWords.put(key, meanings);
			
			key = "pithy";
			meanings = new ArrayList <String>();
			meanings.add("laconic");
			theWords.put(key, meanings);
			
			key = "pitta";
			meanings = new ArrayList <String>();
			meanings.add("Greek bread");
			theWords.put(key, meanings);
			
			key = "pity";
			meanings = new ArrayList <String>();
			meanings.add("shame");
			theWords.put(key, meanings);
			
			key = "pius";
			meanings = new ArrayList <String>();
			meanings.add("pope");
			theWords.put(key, meanings);
			
			key = "place";
			meanings = new ArrayList <String>();
			meanings.add("a certain spot");
			theWords.put(key, meanings);
			
			key = "placenta";
			meanings = new ArrayList <String>();
			meanings.add("organ");
			theWords.put(key, meanings);
			
			key = "places";
			meanings = new ArrayList <String>();
			meanings.add("certain spots");
			meanings.add("puts");
			theWords.put(key, meanings);
			
			key = "plaice";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "plain";
			meanings = new ArrayList <String>();
			meanings.add("flat");
			meanings.add("simple");
			theWords.put(key, meanings);
			
			key = "plan";
			meanings = new ArrayList <String>();
			meanings.add("have in mind");
			meanings.add("intend");
			meanings.add("scale drawing");
			theWords.put(key, meanings);
			
			key = "plane";
			meanings = new ArrayList <String>();
			meanings.add("completely level");
			theWords.put(key, meanings);
			
			key = "planes";
			meanings = new ArrayList <String>();
			meanings.add("aircraft");
			meanings.add("trees");
			theWords.put(key, meanings);
			
			key = "plank";
			meanings = new ArrayList <String>();
			meanings.add("strip of wood");
			theWords.put(key, meanings);
			
			key = "plankton";
			meanings = new ArrayList <String>();
			meanings.add("little creatures");
			theWords.put(key, meanings);
			
			key = "plate";
			meanings = new ArrayList <String>();
			meanings.add("dish");
			theWords.put(key, meanings);
			
			key = "plates";
			meanings = new ArrayList <String>();
			meanings.add("dishes");
			theWords.put(key, meanings);
			
			key = "plateau";
			meanings = new ArrayList <String>();
			meanings.add("level surface");
			theWords.put(key, meanings);
			
			key = "platter";
			meanings = new ArrayList <String>();
			meanings.add("serving dish");
			theWords.put(key, meanings);
			
			key = "player";
			meanings = new ArrayList <String>();
			meanings.add("sportsman");
			theWords.put(key, meanings);
			
			key = "players";
			meanings = new ArrayList <String>();
			meanings.add("sportsmen");
			theWords.put(key, meanings);
					
			key = "pleas";
			meanings = new ArrayList <String>();
			meanings.add("entreaties");
			theWords.put(key, meanings);
			
			key = "pleasant";
			meanings = new ArrayList <String>();
			meanings.add("nice");
			theWords.put(key, meanings);
			
			key = "please";
			meanings = new ArrayList <String>();
			meanings.add("delight");
			theWords.put(key, meanings);
			
			key = "pleasure";
			meanings = new ArrayList <String>();
			meanings.add("joy");
			theWords.put(key, meanings);
					
			key = "pliable";
			meanings = new ArrayList <String>();
			meanings.add("flexible");
			theWords.put(key, meanings);
			
			key = "plonk";
			meanings = new ArrayList <String>();
			meanings.add("cheap wine");
			meanings.add("put down noisily");
			theWords.put(key, meanings);
			
			key = "plot";
			meanings = new ArrayList <String>();
			meanings.add("conspiracy");
			theWords.put(key, meanings);
			
			key = "plough";
			meanings = new ArrayList <String>();
			meanings.add("farm implement");
			theWords.put(key, meanings);
			
			key = "ploy";
			meanings = new ArrayList <String>();
			meanings.add("scheme");
			theWords.put(key, meanings);
			
			key = "plug";
			meanings = new ArrayList <String>();
			meanings.add("stopper");
			theWords.put(key, meanings);
			
			key = "plumbago";
			meanings = new ArrayList <String>();
			meanings.add("graphite");
			theWords.put(key, meanings);
			
			key = "plunge";
			meanings = new ArrayList <String>();
			meanings.add("dive");
			theWords.put(key, meanings);
			
			key = "plus";
			meanings = new ArrayList <String>();
			meanings.add("also");
			theWords.put(key, meanings);
			
			key = "plush";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "pluto";
			meanings = new ArrayList <String>();
			meanings.add("Disney character");
			theWords.put(key, meanings);
			
			key = "poetry";
			meanings = new ArrayList <String>();
			meanings.add("verse");
			theWords.put(key, meanings);
			
			key = "poison";
			meanings = new ArrayList <String>();
			meanings.add("toxic substance");
			theWords.put(key, meanings);
			
			key = "poker";
			meanings = new ArrayList <String>();
			meanings.add("card game");
			theWords.put(key, meanings);
			
			key = "pole";
			meanings = new ArrayList <String>();
			meanings.add("stick");
			theWords.put(key, meanings);
			
			key = "poles";
			meanings = new ArrayList <String>();
			meanings.add("sticks");
			theWords.put(key, meanings);
			
			key = "polecat";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "policy";
			meanings = new ArrayList <String>();
			meanings.add("course");
			theWords.put(key, meanings);
			
			key = "polish";
			meanings = new ArrayList <String>();
			meanings.add("buff");
			meanings.add("central European");
			meanings.add("from warsaw");
			theWords.put(key, meanings);
			
			key = "polished";
			meanings = new ArrayList <String>();
			meanings.add("elegant");
			theWords.put(key, meanings);
			
			key = "poly";
			meanings = new ArrayList <String>();
			meanings.add("college");
			theWords.put(key, meanings);
			
			key = "pond";
			meanings = new ArrayList <String>();
			meanings.add("water feature");
			theWords.put(key, meanings);
			
			key = "ponder";
			meanings = new ArrayList <String>();
			meanings.add("contemplate");
			theWords.put(key, meanings);
			
			key = "poodle";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "poodles";
			meanings = new ArrayList <String>();
			meanings.add("dogs");
			theWords.put(key, meanings);
			
			key = "poole";
			meanings = new ArrayList <String>();
			meanings.add("Dorset resort");
			theWords.put(key, meanings);
			
			key = "pools";
			meanings = new ArrayList <String>();
			meanings.add("puddles");
			theWords.put(key, meanings);
			
			key = "pop";
			meanings = new ArrayList <String>();
			meanings.add("father");
			theWords.put(key, meanings);
			
			key = "pope";
			meanings = new ArrayList <String>();
			meanings.add("Bishop of Rome");
			theWords.put(key, meanings);
			
			key = "poplin";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
					
			key = "popular";
			meanings = new ArrayList <String>();
			meanings.add("admired by many");
			meanings.add("liked");
			theWords.put(key, meanings);
					
			key = "porker";
			meanings = new ArrayList <String>();
			meanings.add("pig");
			theWords.put(key, meanings);
			
			key = "porridge";
			meanings = new ArrayList <String>();
			meanings.add("breakfast food");
			meanings.add("prison");
			theWords.put(key, meanings);
			
			key = "port";
			meanings = new ArrayList <String>();
			meanings.add("left at sea");
			meanings.add("wine");
			theWords.put(key, meanings);
			
			key = "portents";
			meanings = new ArrayList <String>();
			meanings.add("omens");
			theWords.put(key, meanings);
			
			key = "porter";
			meanings = new ArrayList <String>();
			meanings.add("hotel worker");
			theWords.put(key, meanings);
			
			key = "pose";
			meanings = new ArrayList <String>();
			meanings.add("what models do");
			theWords.put(key, meanings);
			
			key = "poser";
			meanings = new ArrayList <String>();
			meanings.add("riddle");
			meanings.add("show off");
			theWords.put(key, meanings);
			
			key = "posted";
			meanings = new ArrayList <String>();
			meanings.add("sent off");
			theWords.put(key, meanings);
			
			key = "pot";
			meanings = new ArrayList <String>();
			meanings.add("container");
			meanings.add("kitty");
			meanings.add("trophy");
			meanings.add("vessel");
			theWords.put(key, meanings);
			
			key = "pots";
			meanings = new ArrayList <String>();
			meanings.add("lots of money");
			theWords.put(key, meanings);
			
			key = "potent";
			meanings = new ArrayList <String>();
			meanings.add("powerful");
			theWords.put(key, meanings);
			
			key = "pound";
			meanings = new ArrayList <String>();
			meanings.add("weight");
			theWords.put(key, meanings);
			
			key = "powder";
			meanings = new ArrayList <String>();
			meanings.add("apply cosmetic");
			theWords.put(key, meanings);
			
			key = "poetic";
			meanings = new ArrayList <String>();
			meanings.add("expressed in verse");
			theWords.put(key, meanings);
			
			key = "pomp";
			meanings = new ArrayList <String>();
			meanings.add("ceremony");
			theWords.put(key, meanings);
			
			key = "port";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "portuguese";
			meanings = new ArrayList <String>();
			meanings.add("european");
			theWords.put(key, meanings);
			
			key = "poser";
			meanings = new ArrayList <String>();
			meanings.add("difficult problem");
			theWords.put(key, meanings);
			
			key = "pot";
			meanings = new ArrayList <String>();
			meanings.add("container");
			theWords.put(key, meanings);
			
			key = "potter";
			meanings = new ArrayList <String>();
			meanings.add("amble");
			meanings.add("ceramic maker");
			theWords.put(key, meanings);
			
			key = "potters";
			meanings = new ArrayList <String>();
			meanings.add("ambles");
			meanings.add("ceramic makers");
			theWords.put(key, meanings);
			
			key = "praise";
			meanings = new ArrayList <String>();
			meanings.add("approval");
			meanings.add("commend");
			theWords.put(key, meanings);
			
			key = "pram";
			meanings = new ArrayList <String>();
			meanings.add("pushchair");
			theWords.put(key, meanings);
			
			key = "pray";
			meanings = new ArrayList <String>();
			meanings.add("ask desperately");
			theWords.put(key, meanings);
			
			key = "preach";
			meanings = new ArrayList <String>();
			meanings.add("evangelise");
			theWords.put(key, meanings);
			
			key = "precede";
			meanings = new ArrayList <String>();
			meanings.add("go before");
			theWords.put(key, meanings);
			
			key = "precis";
			meanings = new ArrayList <String>();
			meanings.add("summary");
			theWords.put(key, meanings);
			
			key = "precise";
			meanings = new ArrayList <String>();
			meanings.add("exact");
			meanings.add("specific");
			theWords.put(key, meanings);
			
			key = "predict";
			meanings = new ArrayList <String>();
			meanings.add("forecast");
			theWords.put(key, meanings);
			
			key = "prefer";
			meanings = new ArrayList <String>();
			meanings.add("favour");
			theWords.put(key, meanings);
			
			key = "present";
			meanings = new ArrayList <String>();
			meanings.add("gift");
			theWords.put(key, meanings);
			
			key = "presents";
			meanings = new ArrayList <String>();
			meanings.add("gifts");
			theWords.put(key, meanings);
			
			key = "preserve";
			meanings = new ArrayList <String>();
			meanings.add("keep");
			theWords.put(key, meanings);
			
			key = "press";
			meanings = new ArrayList <String>();
			meanings.add("journalists");
			meanings.add("reporters");
			meanings.add("urge");
			meanings.add("use an iron");
			theWords.put(key, meanings);
			
			key = "president";
			meanings = new ArrayList <String>();
			meanings.add("such as bush");
			theWords.put(key, meanings);
			
			key = "presidents";
			meanings = new ArrayList <String>();
			meanings.add("heads");
			theWords.put(key, meanings);
			
			key = "prevail";
			meanings = new ArrayList <String>();
			meanings.add("come out on top");
			theWords.put(key, meanings);
			
			key = "pride";
			meanings = new ArrayList <String>();
			meanings.add("arrogance");
			theWords.put(key, meanings);
			
			key = "priests";
			meanings = new ArrayList <String>();
			meanings.add("clergymen");
			meanings.add("men with collars");
			theWords.put(key, meanings);
			
			key = "printed";
			meanings = new ArrayList <String>();
			meanings.add("on paper");
			theWords.put(key, meanings);
			
			key = "printer";
			meanings = new ArrayList <String>();
			meanings.add("computer accessory");
			theWords.put(key, meanings);
			
			key = "prised";
			meanings = new ArrayList <String>();
			meanings.add("forced");
			theWords.put(key, meanings);
			
			key = "prison";
			meanings = new ArrayList <String>();
			meanings.add("jail");
			theWords.put(key, meanings);
			
			key = "prize";
			meanings = new ArrayList <String>();
			meanings.add("award");
			theWords.put(key, meanings);
			
			key = "pro";
			meanings = new ArrayList <String>();
			meanings.add("for");
			meanings.add("in favour of");
			meanings.add("professional");
			theWords.put(key, meanings);
			
			key = "probe";
			meanings = new ArrayList <String>();
			meanings.add("close examination");
			theWords.put(key, meanings);
			
			key = "proceeded";
			meanings = new ArrayList <String>();
			meanings.add("went ahead with");
			theWords.put(key, meanings);
			
			key = "profit";
			meanings = new ArrayList <String>();
			meanings.add("gain");
			theWords.put(key, meanings);
					
			key = "profound";
			meanings = new ArrayList <String>();
			meanings.add("deep");
			theWords.put(key, meanings);
			
			key = "project";
			meanings = new ArrayList <String>();
			meanings.add("collaborative enterprise");
			meanings.add("estimate");
			meanings.add("forecast");
			meanings.add("protrude");
			theWords.put(key, meanings);
			
			key = "pronoun";
			meanings = new ArrayList <String>();
			meanings.add("part of grammar");
			theWords.put(key, meanings);
			
			key = "prop";
			meanings = new ArrayList <String>();
			meanings.add("support");
			theWords.put(key, meanings);
					
			key = "proper";
			meanings = new ArrayList <String>();
			meanings.add("right");
			theWords.put(key, meanings);
			
			key = "pros";
			meanings = new ArrayList <String>();
			meanings.add("experts");
			theWords.put(key, meanings);
			
			key = "prosaic";
			meanings = new ArrayList <String>();
			meanings.add("dull");
			theWords.put(key, meanings);
			
			key = "prospector";
			meanings = new ArrayList <String>();
			meanings.add("dull");
			theWords.put(key, meanings);
			
			key = "prosper";
			meanings = new ArrayList <String>();
			meanings.add("do well");
			theWords.put(key, meanings);
					
			key = "prospero";
			meanings = new ArrayList <String>();
			meanings.add("shakespear character");
			theWords.put(key, meanings);
			
			key = "protect";
			meanings = new ArrayList <String>();
			meanings.add("cushion");
			meanings.add("defend");
			meanings.add("guard");
			meanings.add("safeguard");
			meanings.add("shelter");
			theWords.put(key, meanings);
			
			key = "protest";
			meanings = new ArrayList <String>();
			meanings.add("demonstrate");
			meanings.add("demonstration");
			theWords.put(key, meanings);
			
			key = "protractor";
			meanings = new ArrayList <String>();
			meanings.add("used by geometry students");
			theWords.put(key, meanings);
			
			key = "protruded";
			meanings = new ArrayList <String>();
			meanings.add("stuck out");
			theWords.put(key, meanings);
			
			key = "proves";
			meanings = new ArrayList <String>();
			meanings.add("demonstrates");
			theWords.put(key, meanings);
			
			key = "provided";
			meanings = new ArrayList <String>();
			meanings.add("supplied");
			theWords.put(key, meanings);
			
			key = "publisher";
			meanings = new ArrayList <String>();
			meanings.add("supplier of literature");
			theWords.put(key, meanings);
			
			key = "pud";
			meanings = new ArrayList <String>();
			meanings.add("sweet");
			theWords.put(key, meanings);
			
			key = "pug";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "pulling";
			meanings = new ArrayList <String>();
			meanings.add("tugging");
			theWords.put(key, meanings);
			
			key = "pulse";
			meanings = new ArrayList <String>();
			meanings.add("beat");
			theWords.put(key, meanings);
			
			key = "pumice";
			meanings = new ArrayList <String>();
			meanings.add("volcanic rock");
			theWords.put(key, meanings);
			
			key = "pump";
			meanings = new ArrayList <String>();
			meanings.add("ply");
			theWords.put(key, meanings);
			
			key = "pumpkin";
			meanings = new ArrayList <String>();
			meanings.add("feature of Halloween");
			theWords.put(key, meanings);
			
			key = "pun";
			meanings = new ArrayList <String>();
			meanings.add("joke");
			theWords.put(key, meanings);
			
			key = "pungent";
			meanings = new ArrayList <String>();
			meanings.add("pervasive");
			meanings.add("powerful");
			theWords.put(key, meanings);
			
			key = "puritans";
			meanings = new ArrayList <String>();
			meanings.add("church reformers");
			theWords.put(key, meanings);
			
			key = "pursue";
			meanings = new ArrayList <String>();
			meanings.add("chase");
			theWords.put(key, meanings);
			
			key = "push";
			meanings = new ArrayList <String>();
			meanings.add("advance");
			theWords.put(key, meanings);
			
			key = "put";
			meanings = new ArrayList <String>();
			meanings.add("placed");
			theWords.put(key, meanings);
			
			key = "putdown"; //put down
			meanings = new ArrayList <String>();
			meanings.add("recorded");
			meanings.add("snub");
			theWords.put(key, meanings);
			
			key = "putter";
			meanings = new ArrayList <String>();
			meanings.add("golf club");
			theWords.put(key, meanings);

			
			return theWords;
		}//end loadPWords
		
		public void loadQWords() {
			String key;
			ArrayList <String> meanings;
			
			//load q's
			key = "qualifying";
			meanings = new ArrayList <String>();
			meanings.add("getting through");
			theWords.put(key, meanings);
			
			key = "quality";
			meanings = new ArrayList <String>();
			meanings.add("attribute");
			theWords.put(key, meanings);
			
			key = "quarters";
			meanings = new ArrayList <String>();
			meanings.add("accommodation");
			meanings.add("certain parts");
			theWords.put(key, meanings);
			
			key = "quartets";
			meanings = new ArrayList <String>();
			meanings.add("chamber music");
			theWords.put(key, meanings);
			
			key = "quip";
			meanings = new ArrayList <String>();
			meanings.add("witticism");
			theWords.put(key, meanings);
			
			key = "quire";
			meanings = new ArrayList <String>();
			meanings.add("25 sheets of paper");
			theWords.put(key, meanings);
			
			key = "quito";
			meanings = new ArrayList <String>();
			meanings.add("South American city");
			theWords.put(key, meanings);
			
			key = "quiver";
			meanings = new ArrayList <String>();
			meanings.add("container for arrows");
			meanings.add("shake");
			theWords.put(key, meanings);

		}//end loadQWords
		
		public TreeMap<String, ArrayList<String>> loadRWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load r's
			key = "raasay";
			meanings = new ArrayList <String>();
			meanings.add("Scottish island");
			theWords.put(key, meanings);
			
			key = "rabbi";
			meanings = new ArrayList <String>();
			meanings.add("religious leader");
			theWords.put(key, meanings);
			
			key = "rabbit";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("chatter");
			theWords.put(key, meanings);
			
			key = "rabid";
			meanings = new ArrayList <String>();
			meanings.add("like a mad dog");
			theWords.put(key, meanings);
					
			key = "rabies";
			meanings = new ArrayList <String>();
			meanings.add("disease");
			theWords.put(key, meanings);
			
			key = "race";
			meanings = new ArrayList <String>();
			meanings.add("contest");
			meanings.add("people");
			meanings.add("sporting event");
			theWords.put(key, meanings);
			
			key = "raced";
			meanings = new ArrayList <String>();
			meanings.add("competed");
			theWords.put(key, meanings);
			
			key = "races";
			meanings = new ArrayList <String>();
			meanings.add("sporting events");
			theWords.put(key, meanings);
			
			key = "racism";
			meanings = new ArrayList <String>();
			meanings.add("bigotry");
			theWords.put(key, meanings);
			
			key = "racist";
			meanings = new ArrayList <String>();
			meanings.add("bigot");
			theWords.put(key, meanings);
			
			key = "racy";
			meanings = new ArrayList <String>();
			meanings.add("lively");
			theWords.put(key, meanings);
			
			key = "radiant";
			meanings = new ArrayList <String>();
			meanings.add("beaming");
			theWords.put(key, meanings);
			
			key = "radio";
			meanings = new ArrayList <String>();
			meanings.add("means of receiving");
			meanings.add("send a message");
			theWords.put(key, meanings);
			
			key = "rag";
			meanings = new ArrayList <String>();
			meanings.add("paper");
			meanings.add("scrap of cloth");
			theWords.put(key, meanings);
			
			key = "rags";
			meanings = new ArrayList <String>();
			meanings.add("papers");
			meanings.add("scraps of cloth");
			theWords.put(key, meanings);
			
			key = "rage";
			meanings = new ArrayList <String>();
			meanings.add("anger");
			theWords.put(key, meanings);
			
			key = "rages";
			meanings = new ArrayList <String>();
			meanings.add("storms");
			theWords.put(key, meanings);
			
			key = "raid";
			meanings = new ArrayList <String>();
			meanings.add("attack");
			meanings.add("foray");
			meanings.add("plunder");
			meanings.add("enter by force");
			meanings.add("short sudden attack");
			theWords.put(key, meanings);
			
			key = "raiding";
			meanings = new ArrayList <String>();
			meanings.add("attacking");
			theWords.put(key, meanings);
			
			key = "rain";
			meanings = new ArrayList <String>();
			meanings.add("bad weather");
			meanings.add("downpour");
			meanings.add("shower");
			meanings.add("stops play at the oval");
			meanings.add("wet weather");
			theWords.put(key, meanings);
			
			key = "raise";
			meanings = new ArrayList <String>();
			meanings.add("lift");
			theWords.put(key, meanings);
			
			key = "raisin";
			meanings = new ArrayList <String>();
			meanings.add("dried black grape");
			theWords.put(key, meanings);
			
			key = "rake";
			meanings = new ArrayList <String>();
			meanings.add("garden tool");
			theWords.put(key, meanings);
			
			key = "rally";
			meanings = new ArrayList <String>();
			meanings.add("convention");
			meanings.add("regroup");
			theWords.put(key, meanings);
			
			key = "ramble";
			meanings = new ArrayList <String>();
			meanings.add("leisurely walk");
			theWords.put(key, meanings);
					
			key = "rambler";
			meanings = new ArrayList <String>();
			meanings.add("hiker");
			theWords.put(key, meanings);
			
			key = "ramekin";
			meanings = new ArrayList <String>();
			meanings.add("dish for one");
			theWords.put(key, meanings);
			
			key = "ram";
			meanings = new ArrayList <String>();
			meanings.add("sheep");
			theWords.put(key, meanings);
			
			key = "ramp";
			meanings = new ArrayList <String>();
			meanings.add("slope");
			theWords.put(key, meanings);
			
			key = "rampage";
			meanings = new ArrayList <String>();
			meanings.add("rush around");
			theWords.put(key, meanings);
			
			
			key = "ran";
			meanings = new ArrayList <String>();
			meanings.add("competed");
			meanings.add("governed");
			meanings.add("managed");
			meanings.add("operated");
			meanings.add("organised");
			theWords.put(key, meanings);
			
			key = "ranch";
			meanings = new ArrayList <String>();
			meanings.add("farm");
			meanings.add("Wetsern farm");
			theWords.put(key, meanings);
			
			key = "rand";
			meanings = new ArrayList <String>();
			meanings.add("foreign money");
			theWords.put(key, meanings);
			
			key = "random";
			meanings = new ArrayList <String>();
			meanings.add("haphazard");
			meanings.add("unsystematic");
			theWords.put(key, meanings);
			
			key = "randy";
			meanings = new ArrayList <String>();
			meanings.add("lascivious");
			theWords.put(key, meanings);
			
			key = "rang";
			meanings = new ArrayList <String>();
			meanings.add("phoned");
			theWords.put(key, meanings);
			
			key = "range";
			meanings = new ArrayList <String>();
			meanings.add("mountains");
			meanings.add("stove");
			meanings.add("scope");
			theWords.put(key, meanings);
			
			key = "ranges";
			meanings = new ArrayList <String>();
			meanings.add("mountains");
			theWords.put(key, meanings);
			
			key = "ranger";
			meanings = new ArrayList <String>();
			meanings.add("forest keeper");
			meanings.add("guide");
			theWords.put(key, meanings);
			
			key = "rangers";
			meanings = new ArrayList <String>();
			meanings.add("wardens");
			theWords.put(key, meanings);
			
			key = "rangoon";
			meanings = new ArrayList <String>();
			meanings.add("Burmese city");
			theWords.put(key, meanings);
			
			key = "rank";
			meanings = new ArrayList <String>();
			meanings.add("row");
			theWords.put(key, meanings);

			key = "ranks";
			meanings = new ArrayList <String>();
			meanings.add("rows");
			theWords.put(key, meanings);
			
			key = "ransack";
			meanings = new ArrayList <String>();
			meanings.add("lay waste");
			meanings.add("plunder");
			theWords.put(key, meanings);
			
			key = "ransacks";
			meanings = new ArrayList <String>();
			meanings.add("plunders");
			theWords.put(key, meanings);
			
			key = "ransom";
			meanings = new ArrayList <String>();
			meanings.add("hostage payment");
			theWords.put(key, meanings);
			
			key = "rant";
			meanings = new ArrayList <String>();
			meanings.add("sound off");
			meanings.add("tirade");
			theWords.put(key, meanings);
			
			key = "rants";
			meanings = new ArrayList <String>();
			meanings.add("sounds off");
			meanings.add("tirades");
			theWords.put(key, meanings);
				
			key = "rapid";
			meanings = new ArrayList <String>();
			meanings.add("quick");
			theWords.put(key, meanings);
			
			key = "rapier";
			meanings = new ArrayList <String>();
			meanings.add("sword");
			theWords.put(key, meanings);
			
			key = "rapping";
			meanings = new ArrayList <String>();
			meanings.add("striking hard");
			theWords.put(key, meanings);
			
			key = "raps";
			meanings = new ArrayList <String>();
			meanings.add("strikes hard");
			theWords.put(key, meanings);
			
			key = "rare";
			meanings = new ArrayList <String>();
			meanings.add("unusual");
			theWords.put(key, meanings);
			
			key = "rarebit";
			meanings = new ArrayList <String>();
			meanings.add("welsh dish");
			theWords.put(key, meanings);
			
			key = "rasp";
			meanings = new ArrayList <String>();
			meanings.add("tool");
			theWords.put(key, meanings);
			
			key = "rasputin";
			meanings = new ArrayList <String>();
			meanings.add("sinister monk");
			theWords.put(key, meanings);
			
			key = "rat";
			meanings = new ArrayList <String>();
			meanings.add("deceitful person");
			meanings.add("rodent");
			meanings.add("vermin");
			theWords.put(key, meanings);
			
			key = "rats";
			meanings = new ArrayList <String>();
			meanings.add("deceitful people");
			meanings.add("rodents");
			meanings.add("vermin");
			theWords.put(key, meanings);
			
			key = "rate";
			meanings = new ArrayList <String>();
			meanings.add("assign a value to");
			meanings.add("frequency");
			meanings.add("measure");
			meanings.add("quantity");
			meanings.add("score");
			meanings.add("speed");
			meanings.add("value");
			theWords.put(key, meanings);	
			
			key = "rates";
			meanings = new ArrayList <String>();
			meanings.add("measures");
			meanings.add("rates");
			meanings.add("scores");
			theWords.put(key, meanings);
			
			key = "rated";
			meanings = new ArrayList <String>();
			meanings.add("measured");
			meanings.add("ranked");
			meanings.add("scored");
			meanings.add("assigned a value to");
			theWords.put(key, meanings);
			
			key = "rating";
			meanings = new ArrayList <String>();
			meanings.add("rank");
			theWords.put(key, meanings);
			
			key = "ratings";
			meanings = new ArrayList <String>();
			meanings.add("grades");
			theWords.put(key, meanings);
			
			key = "ratio";
			meanings = new ArrayList <String>();
			meanings.add("aportion");
			theWords.put(key, meanings);
			
			key = "ration";
			meanings = new ArrayList <String>();
			meanings.add("helping");
			theWords.put(key, meanings);
			
			key = "rationally";
			meanings = new ArrayList <String>();
			meanings.add("logically");
			theWords.put(key, meanings);
			
			key = "rats";
			meanings = new ArrayList <String>();
			meanings.add("vermin");
			theWords.put(key, meanings);
			
			key = "rave";
			meanings = new ArrayList <String>();
			meanings.add("dance party");
			theWords.put(key, meanings);
			
			key = "ravel";
			meanings = new ArrayList <String>();
			meanings.add("composer");
			meanings.add("French composer");
			meanings.add("musician");
			theWords.put(key, meanings);
			
			key = "ravine";
			meanings = new ArrayList <String>();
			meanings.add("narrow gorge");
			theWords.put(key, meanings);
			
			key = "raw";
			meanings = new ArrayList <String>();
			meanings.add("uncooked");
			theWords.put(key, meanings);
			
			key = "ray";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "rayon";
			meanings = new ArrayList <String>();
			meanings.add("artificial silk");
			meanings.add("fabric");
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "re";
			meanings = new ArrayList <String>();
			meanings.add("about");
			meanings.add("concerning");
			//theWords.put(key, meanings);
			
			key = "reach";
			meanings = new ArrayList <String>();
			meanings.add("get to");
			meanings.add("open stretch of water");
			theWords.put(key, meanings);
			
			key = "read";
			meanings = new ArrayList <String>();
			meanings.add("look at and comprehend");
			meanings.add("discover");
			meanings.add("inspect");
			meanings.add("study");
			meanings.add("hear and understand");
			theWords.put(key, meanings);
			
			key = "reader";
			meanings = new ArrayList <String>();
			meanings.add("university lecturer perhaps");
			meanings.add("the meter man?");
			theWords.put(key, meanings);
			
			key = "readiest";
			meanings = new ArrayList <String>();
			meanings.add("most willing");
			theWords.put(key, meanings);
			
			key = "ready";
			meanings = new ArrayList <String>();
			meanings.add("prepared");
			theWords.put(key, meanings);
			
			key = "real";
			meanings = new ArrayList <String>();
			meanings.add("existing");
			meanings.add("true");
			theWords.put(key, meanings);
			
			key = "reality";
			meanings = new ArrayList <String>();
			meanings.add("real life");
			theWords.put(key, meanings);
			
			key = "really";
			meanings = new ArrayList <String>();
			meanings.add("actually");
			theWords.put(key, meanings);
			
			key = "realm";
			meanings = new ArrayList <String>();
			meanings.add("kingdom");
			meanings.add("province");
			theWords.put(key, meanings);
			
			key = "realms";
			meanings = new ArrayList <String>();
			meanings.add("kingdoms");
			meanings.add("provinces");
			theWords.put(key, meanings);
			
			key = "reap";
			meanings = new ArrayList <String>();
			meanings.add("harvest");
			theWords.put(key, meanings);
			
			key = "reaped";
			meanings = new ArrayList <String>();
			meanings.add("gathered");
			theWords.put(key, meanings);
			
			key = "reaps";
			meanings = new ArrayList <String>();
			meanings.add("scythes");
			meanings.add("gathers");
			meanings.add("obtains");
			meanings.add("receives");
			theWords.put(key, meanings);
					
			key = "rear";
			meanings = new ArrayList <String>();
			meanings.add("behind");
			theWords.put(key, meanings);
			
			key = "reared";
			meanings = new ArrayList <String>();
			meanings.add("brought up");
			meanings.add("bred");
			meanings.add("raised");
			meanings.add("stood on back legs");
			theWords.put(key, meanings);
			
			key = "rearm";
			meanings = new ArrayList <String>();
			meanings.add("take up weapons again");
			theWords.put(key, meanings);
			
			key = "reason";
			meanings = new ArrayList <String>();
			meanings.add("motive");
			theWords.put(key, meanings);
			
			key = "reassert";
			meanings = new ArrayList <String>();
			meanings.add("claim again");
			theWords.put(key, meanings);
			
			key = "rebel";
			meanings = new ArrayList <String>();
			meanings.add("rise up");
			theWords.put(key, meanings);
			
			key = "rebelled";
			meanings = new ArrayList <String>();
			meanings.add("rose");
			meanings.add("rose up");
			theWords.put(key, meanings);
			
			key = "rebus";
			meanings = new ArrayList <String>();
			meanings.add("puzzle");
			theWords.put(key, meanings);
			
			key = "recede";
			meanings = new ArrayList <String>();
			meanings.add("move back");
			theWords.put(key, meanings);
			
			key = "recipe";
			meanings = new ArrayList <String>();
			meanings.add("formula");
			theWords.put(key, meanings);
			
			key = "recipes";
			meanings = new ArrayList <String>();
			meanings.add("formulas");
			theWords.put(key, meanings);
			
			key = "recital";
			meanings = new ArrayList <String>();
			meanings.add("reading");
			theWords.put(key, meanings);
			
			key = "recto";
			meanings = new ArrayList <String>();
			meanings.add("right hand page");
			theWords.put(key, meanings);
			
			key = "rector";
			meanings = new ArrayList <String>();
			meanings.add("clergyman");
			theWords.put(key, meanings);
			
			key = "red";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			meanings.add("crimson");
			meanings.add("embarrassed");
			theWords.put(key, meanings);
			
			key = "redadmirals"; // red admirals
			meanings = new ArrayList <String>();
			meanings.add("butterflies");
			theWords.put(key, meanings);
			
			key = "redcoat";
			meanings = new ArrayList <String>();
			meanings.add("old soldier");
			theWords.put(key, meanings);
			
			key = "redcoats";
			meanings = new ArrayList <String>();
			meanings.add("soldiers");
			theWords.put(key, meanings);
			
			key = "redhead";
			meanings = new ArrayList <String>();
			meanings.add("ginger");
			theWords.put(key, meanings);
			
			key = "redrag";
			meanings = new ArrayList <String>();
			meanings.add("something infuriating");
			theWords.put(key, meanings);
			
			key = "redress";
			meanings = new ArrayList <String>();
			meanings.add("put right");
			theWords.put(key, meanings);
			
			key = "reds";
			meanings = new ArrayList <String>();
			meanings.add("Liverpool");
			theWords.put(key, meanings);
			
			key = "recent";
			meanings = new ArrayList <String>();
			meanings.add("contemporary");
			theWords.put(key, meanings);
			
			key = "recession";
			meanings = new ArrayList <String>();
			meanings.add("slump");
			theWords.put(key, meanings);

			key = "recover";
			meanings = new ArrayList <String>();
			meanings.add("get better");
			meanings.add("work as an upholsterer");
			theWords.put(key, meanings);
			
			key = "recur";
			meanings = new ArrayList <String>();
			meanings.add("come back");
			theWords.put(key, meanings);
			
			key = "red";
			meanings = new ArrayList <String>();
			meanings.add("blushing");
			theWords.put(key, meanings);
			
			key = "reed";
			meanings = new ArrayList <String>();
			meanings.add("grass");
			theWords.put(key, meanings);
			
			key = "reef";
			meanings = new ArrayList <String>();
			meanings.add("chain of rocks");
			theWords.put(key, meanings);
			
			key = "reek";
			meanings = new ArrayList <String>();
			meanings.add("smell");
			theWords.put(key, meanings);
			
			key = "reel";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "ref";
			meanings = new ArrayList <String>();
			meanings.add("umpire");
			meanings.add("whistle blower");
			theWords.put(key, meanings);
			
			key = "refer";
			meanings = new ArrayList <String>();
			meanings.add("allude");
			meanings.add("mention");
			meanings.add("send");
			theWords.put(key, meanings);
			
			key = "referee";
			meanings = new ArrayList <String>();
			meanings.add("adjudicator");
			meanings.add("judge");
			meanings.add("mediatior");
			meanings.add("umpire");
			theWords.put(key, meanings);
			
			key = "refits";
			meanings = new ArrayList <String>();
			meanings.add("restorations");
			theWords.put(key, meanings);
			
			key = "refuse";
			meanings = new ArrayList <String>();
			meanings.add("litter");
			meanings.add("say no");
			theWords.put(key, meanings);
			
			key = "refused";
			meanings = new ArrayList <String>();
			meanings.add("said no to");
			theWords.put(key, meanings);
			
			key = "reg";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "regal";
			meanings = new ArrayList <String>();
			meanings.add("splendid");
			theWords.put(key, meanings);
			
			key = "regiment";
			meanings = new ArrayList <String>();
			meanings.add("group of soldiers");
			theWords.put(key, meanings);
			
			key = "region";
			meanings = new ArrayList <String>();
			meanings.add("area");
			theWords.put(key, meanings);
			
			key = "register";
			meanings = new ArrayList <String>();
			meanings.add("official list");
			meanings.add("record");
			theWords.put(key, meanings);
			
			key = "reheat";
			meanings = new ArrayList <String>();
			meanings.add("warm up again");
			theWords.put(key, meanings);
			
			key = "reign";
			meanings = new ArrayList <String>();
			meanings.add("rule by monarch");
			theWords.put(key, meanings);
			
			key = "reigns";
			meanings = new ArrayList <String>();
			meanings.add("rules");
			theWords.put(key, meanings);
			
			key = "related";
			meanings = new ArrayList <String>();
			meanings.add("connected");
			theWords.put(key, meanings);
			
			key = "relatives";
			meanings = new ArrayList <String>();
			meanings.add("members of the family");
			theWords.put(key, meanings);
			
			key = "relay";
			meanings = new ArrayList <String>();
			meanings.add("broadcast");
			theWords.put(key, meanings);
			
			key = "relent";
			meanings = new ArrayList <String>();
			meanings.add("relax");
			theWords.put(key, meanings);
			
			key = "relentless";
			meanings = new ArrayList <String>();
			meanings.add("inexorable");
			theWords.put(key, meanings);		
			
			key = "relish";
			meanings = new ArrayList <String>();
			meanings.add("dressing");
			meanings.add("enjoy");
			theWords.put(key, meanings);
			
			key = "relishes";
			meanings = new ArrayList <String>();
			meanings.add("chutneys");
			meanings.add("likes the taste of");
			theWords.put(key, meanings);
			
			key = "relishing";
			meanings = new ArrayList <String>();
			meanings.add("really enjoying");
			theWords.put(key, meanings);
			
			key = "rely";
			meanings = new ArrayList <String>();
			meanings.add("depend on");
			theWords.put(key, meanings);
			
			key = "regimen";
			meanings = new ArrayList <String>();
			meanings.add("diet");
			theWords.put(key, meanings);
			
			key = "regiment";
			meanings = new ArrayList <String>();
			meanings.add("military unit");
			theWords.put(key, meanings);
			
			key = "regret";
			meanings = new ArrayList <String>();
			meanings.add("feel sorry about");
			theWords.put(key, meanings);
			
			key = "regrets";
			meanings = new ArrayList <String>();
			meanings.add("feels sorry about");
			meanings.add("rues");
			theWords.put(key, meanings);
			
			key = "remain";
			meanings = new ArrayList <String>();
			meanings.add("stay");
			theWords.put(key, meanings);
			
			key = "remains";
			meanings = new ArrayList <String>();
			meanings.add("corpse");
			theWords.put(key, meanings);
			
			key = "remand";
			meanings = new ArrayList <String>();
			meanings.add("send back");
			theWords.put(key, meanings);
			
			key = "remark";
			meanings = new ArrayList <String>();
			meanings.add("observation");
			meanings.add("something said");
			theWords.put(key, meanings);
			
			key = "remarks";
			meanings = new ArrayList <String>();
			meanings.add("comments");
			theWords.put(key, meanings);
			
			key = "remember";
			meanings = new ArrayList <String>();
			meanings.add("don't forget");
			theWords.put(key, meanings);
					
			key = "remiss";
			meanings = new ArrayList <String>();
			meanings.add("negligent");
			theWords.put(key, meanings);
			
			key = "remit";
			meanings = new ArrayList <String>();
			meanings.add("send");
			theWords.put(key, meanings);
			
			key = "remnant";
			meanings = new ArrayList <String>();
			meanings.add("scrap");
			theWords.put(key, meanings);
			
			key = "remote";
			meanings = new ArrayList <String>();
			meanings.add("faraway");
			meanings.add("far off");
			theWords.put(key, meanings);
			
			key = "removed";
			meanings = new ArrayList <String>();
			meanings.add("took off");
			theWords.put(key, meanings);
			
			key = "rend";
			meanings = new ArrayList <String>();
			meanings.add("split");
			theWords.put(key, meanings);
			
			key = "rene";
			meanings = new ArrayList <String>();
			meanings.add("frenchman");
			theWords.put(key, meanings);
			
			key = "renewals";
			meanings = new ArrayList <String>();
			meanings.add("continuation");
			theWords.put(key, meanings);
			
			key = "rent";
			meanings = new ArrayList <String>();
			meanings.add("split");
			theWords.put(key, meanings);
			
			key = "rental";
			meanings = new ArrayList <String>();
			meanings.add("income from property");
			theWords.put(key, meanings);
			
			key = "rep";
			meanings = new ArrayList <String>();
			meanings.add("salesman");
			theWords.put(key, meanings);
			
			key = "repaint";
			meanings = new ArrayList <String>();
			meanings.add("decorate again");
			meanings.add("render again");
			theWords.put(key, meanings);
					
			key = "repair";
			meanings = new ArrayList <String>();
			meanings.add("fix");
			theWords.put(key, meanings);
			
			key = "repartee";
			meanings = new ArrayList <String>();
			meanings.add("banter");
			theWords.put(key, meanings);
			
			key = "repeat";
			meanings = new ArrayList <String>();
			meanings.add("do again");
			theWords.put(key, meanings);
			
			key = "repent";
			meanings = new ArrayList <String>();
			meanings.add("be sorry for");
			meanings.add("rue");
			theWords.put(key, meanings);
			
			//this word was only added for test purposes
			//testing augmented anagram + 3 letters
			key = "repertain";
			meanings = new ArrayList <String>();
			meanings.add("pertain again");
			theWords.put(key, meanings);
			
			key = "replenish";
			meanings = new ArrayList <String>();
			meanings.add("top up");
			theWords.put(key, meanings);
			
			key = "replicate";
			meanings = new ArrayList <String>();
			meanings.add("make copy of");
			theWords.put(key, meanings);
			
			key = "reporters";
			meanings = new ArrayList <String>();
			meanings.add("journalists");
			theWords.put(key, meanings);
			
			key = "reproach";
			meanings = new ArrayList <String>();
			meanings.add("rebuke");
			theWords.put(key, meanings);
			
			key = "reptile";
			meanings = new ArrayList <String>();
			meanings.add("cold-blooded creature");
			theWords.put(key, meanings);
			
			key = "required";
			meanings = new ArrayList <String>();
			meanings.add("needed");
			theWords.put(key, meanings);
			
			key = "rescue";
			meanings = new ArrayList <String>();
			meanings.add("free");
			theWords.put(key, meanings);
			
			key = "resents";
			meanings = new ArrayList <String>();
			meanings.add("dislikes");
			theWords.put(key, meanings);
			
			key = "reserve";
			meanings = new ArrayList <String>();
			meanings.add("book");
			theWords.put(key, meanings);
			
			key = "reserved";
			meanings = new ArrayList <String>();
			meanings.add("kept");
			meanings.add("being shy");
			theWords.put(key, meanings);
			
			key = "reside";
			meanings = new ArrayList <String>();
			meanings.add("live");
			theWords.put(key, meanings);
			
			key = "resident";
			meanings = new ArrayList <String>();
			meanings.add("living in a place");
			theWords.put(key, meanings);
			
			key = "residential";
			meanings = new ArrayList <String>();
			meanings.add("people to live in");
			theWords.put(key, meanings);
			
			key = "resigned";
			meanings = new ArrayList <String>();
			meanings.add("gave up");
			theWords.put(key, meanings);
			
			key = "resist";
			meanings = new ArrayList <String>();
			meanings.add("counter");
			meanings.add("put up a fight");
			theWords.put(key, meanings);
			
			key = "resit";
			meanings = new ArrayList <String>();
			meanings.add("further examination");
			theWords.put(key, meanings);
			
			key = "resolved";
			meanings = new ArrayList <String>();
			meanings.add("cracked again");
			meanings.add("sorted out");
			theWords.put(key, meanings);
			
			key = "respite";
			meanings = new ArrayList <String>();
			meanings.add("welcome break");
			theWords.put(key, meanings);
			
			key = "rest";
			meanings = new ArrayList <String>();
			meanings.add("others");
			meanings.add("support");
			meanings.add("take it easy");
			theWords.put(key, meanings);
			
			key = "restful";
			meanings = new ArrayList <String>();
			meanings.add("still");
			theWords.put(key, meanings);
			
			key = "restored";
			meanings = new ArrayList <String>();
			meanings.add("made good");
			theWords.put(key, meanings);
					
			key = "restrain";
			meanings = new ArrayList <String>();
			meanings.add("hold back");
			theWords.put(key, meanings);
			
			key = "restricted";
			meanings = new ArrayList <String>();
			meanings.add("limited");
			theWords.put(key, meanings);
			
			key = "result";
			meanings = new ArrayList <String>();
			meanings.add("outcome");
			theWords.put(key, meanings);
			
			key = "retain";
			meanings = new ArrayList <String>();
			meanings.add("absorb and hold");
			meanings.add("continue to have");
			meanings.add("keep");
			meanings.add("keep in employment");
			theWords.put(key, meanings);
			
			key = "retainer";
			meanings = new ArrayList <String>();
			meanings.add("deposit");
			theWords.put(key, meanings);
			
			key = "retains";
			meanings = new ArrayList <String>();
			meanings.add("keeps");
			theWords.put(key, meanings);
			
			key = "retch";
			meanings = new ArrayList <String>();
			meanings.add("be sick");
			theWords.put(key, meanings);
			
			key = "retina";
			meanings = new ArrayList <String>();
			meanings.add("part of the eye");
			meanings.add("where an image is formed");
			theWords.put(key, meanings);
			
			key = "retire";
			meanings = new ArrayList <String>();
			meanings.add("finish work");
			meanings.add("go to bed");
			meanings.add("retreat");
			theWords.put(key, meanings);
			
			key = "retired";
			meanings = new ArrayList <String>();
			meanings.add("finished work");
			meanings.add("went to bed");
			theWords.put(key, meanings);
			
			key = "retirement";
			meanings = new ArrayList <String>();
			meanings.add("when work is over");
			theWords.put(key, meanings);
			
			key = "retiring";
			meanings = new ArrayList <String>();
			meanings.add("finishing work");
			meanings.add("going to bed");
			theWords.put(key, meanings);
					
			key = "reunion";
			meanings = new ArrayList <String>();
			meanings.add("nostalgic meeting");
			theWords.put(key, meanings);
			
			key = "rev";
			meanings = new ArrayList <String>();
			meanings.add("priest");
			theWords.put(key, meanings);
			
			key = "reveal";
			meanings = new ArrayList <String>();
			meanings.add("make known");
			theWords.put(key, meanings);
			
			key = "revealed";
			meanings = new ArrayList <String>();
			meanings.add("no longer hidden");
			theWords.put(key, meanings);
			
			key = "revel";
			meanings = new ArrayList <String>();
			meanings.add("make merry");
			theWords.put(key, meanings);
			
			key = "reversal";
			meanings = new ArrayList <String>();
			meanings.add("U-turn");
			theWords.put(key, meanings);
			
			key = "reversed";
			meanings = new ArrayList <String>();
			meanings.add("vice-versa");
			theWords.put(key, meanings);
			
			key = "rewarded";
			meanings = new ArrayList <String>();
			meanings.add("recognised");
			theWords.put(key, meanings);
			
			key = "rhyme";
			meanings = new ArrayList <String>();
			meanings.add("verse");
			theWords.put(key, meanings);
			
			key = "rialto";
			meanings = new ArrayList <String>();
			meanings.add("Italian bridge");
			theWords.put(key, meanings);
			
			key = "rib";
			meanings = new ArrayList <String>();
			meanings.add("bone");
			meanings.add("make fun of");
			theWords.put(key, meanings);
			
			key = "ribs";
			meanings = new ArrayList <String>();
			meanings.add("bones");
			meanings.add("makes fun of");
			theWords.put(key, meanings);
			
			key = "rice";
			meanings = new ArrayList <String>();
			meanings.add("staple food");
			theWords.put(key, meanings);
			
			key = "rich";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("well off");
			theWords.put(key, meanings);
			
			key = "rid";
			meanings = new ArrayList <String>();
			meanings.add("free");
			theWords.put(key, meanings);
			
			key = "ride";
			meanings = new ArrayList <String>();
			meanings.add("trip");
			theWords.put(key, meanings);
			
			key = "rides";
			meanings = new ArrayList <String>();
			meanings.add("amusement park attraction");
			theWords.put(key, meanings);
			
			key = "rider";
			meanings = new ArrayList <String>();
			meanings.add("cyclist");
			theWords.put(key, meanings);
			
			key = "ridge";
			meanings = new ArrayList <String>();
			meanings.add("hilltop");
			theWords.put(key, meanings);
			
			key = "rifles";
			meanings = new ArrayList <String>();
			meanings.add("arms");
			theWords.put(key, meanings);
			
			key = "rift";
			meanings = new ArrayList <String>();
			meanings.add("opening");
			theWords.put(key, meanings);
			
			key = "rifts";
			meanings = new ArrayList <String>();
			meanings.add("disagreements");
			theWords.put(key, meanings);
			
			key = "rig";
			meanings = new ArrayList <String>();
			meanings.add("equipment");
			theWords.put(key, meanings);
			
			key = "right";
			meanings = new ArrayList <String>();
			meanings.add("correct");
			theWords.put(key, meanings);
			
			key = "rim";
			meanings = new ArrayList <String>();
			meanings.add("border");
			meanings.add("edge");
			meanings.add("flange");
			meanings.add("part of wheel");
			theWords.put(key, meanings);
			
			key = "rims";
			meanings = new ArrayList <String>();
			meanings.add("borders");
			theWords.put(key, meanings);

			key = "ring";
			meanings = new ArrayList <String>();
			meanings.add("band");
			meanings.add("circle");
			theWords.put(key, meanings);
			
			key = "rio";
			meanings = new ArrayList <String>();
			meanings.add("Brazilian city");
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "riot";
			meanings = new ArrayList <String>();
			meanings.add("disturbance");
			theWords.put(key, meanings);
			
			key = "rioted";
			meanings = new ArrayList <String>();
			meanings.add("ran amok");
			theWords.put(key, meanings);
			
			key = "rip";
			meanings = new ArrayList <String>();
			meanings.add("tear");
			theWords.put(key, meanings);
			
			key = "ripe";
			meanings = new ArrayList <String>();
			meanings.add("ready for eating");
			meanings.add("ready to be picked");
			theWords.put(key, meanings);

			key = "rise";
			meanings = new ArrayList <String>();
			meanings.add("get up");
			meanings.add("increase");
			theWords.put(key, meanings);
			
			key = "rises";
			meanings = new ArrayList <String>();
			meanings.add("increases");
			theWords.put(key, meanings);
			
			key = "risk";
			meanings = new ArrayList <String>();
			meanings.add("chance");
			theWords.put(key, meanings);
			
			key = "risking";
			meanings = new ArrayList <String>();
			meanings.add("chancing");
			theWords.put(key, meanings);
			
			key = "rising";
			meanings = new ArrayList <String>();
			meanings.add("on the up");
			meanings.add("rebellion");
			theWords.put(key, meanings);
			
			key = "rita";
			meanings = new ArrayList <String>();
			meanings.add("female");
			theWords.put(key, meanings);
			
			key = "rite";
			meanings = new ArrayList <String>();
			meanings.add("ceremony");
			theWords.put(key, meanings);
			
			key = "river";
			meanings = new ArrayList <String>();
			meanings.add("flower");
			theWords.put(key, meanings);
			
			key = "riviera";
			meanings = new ArrayList <String>();
			meanings.add("part of Mediterranean");
			theWords.put(key, meanings);
			
			key = "roach";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "road";
			meanings = new ArrayList <String>();
			meanings.add("thoroughfare");
			theWords.put(key, meanings);
			
			key = "roast";
			meanings = new ArrayList <String>();
			meanings.add("cook");
			meanings.add("severely criticise");
			theWords.put(key, meanings);
			
			key = "roasting";
			meanings = new ArrayList <String>();
			meanings.add("cooking");
			meanings.add("severe criticism");
			theWords.put(key, meanings);
			
			key = "rove";
			meanings = new ArrayList <String>();
			meanings.add("wander");
			theWords.put(key, meanings);
			
			key = "rob";
			meanings = new ArrayList <String>();
			meanings.add("steal");
			theWords.put(key, meanings);
			
			key = "robe";
			meanings = new ArrayList <String>();
			meanings.add("clothing");
			meanings.add("garment");
			meanings.add("gown");
			theWords.put(key, meanings);
					
			key = "robot";
			meanings = new ArrayList <String>();
			meanings.add("android");
			theWords.put(key, meanings);
			
			key = "robust";
			meanings = new ArrayList <String>();
			meanings.add("strong");
			theWords.put(key, meanings);
			
			key = "roc";
			meanings = new ArrayList <String>();
			meanings.add("old bird");
			theWords.put(key, meanings);
			
			key = "rod";
			meanings = new ArrayList <String>();
			meanings.add("pole");
			theWords.put(key, meanings);
					
			key = "rode";
			meanings = new ArrayList <String>();
			meanings.add("travelled in a vehicle");
			meanings.add("went on a bike");
			theWords.put(key, meanings);
			
			key = "rodent";
			meanings = new ArrayList <String>();
			meanings.add("gnawing mammal");
			theWords.put(key, meanings);
			
			key = "rodeo";
			meanings = new ArrayList <String>();
			meanings.add("western show");
			theWords.put(key, meanings);
				
			key = "rodney";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "rogue";
			meanings = new ArrayList <String>();
			meanings.add("scoundrel");
			theWords.put(key, meanings);
			
			key = "rogues";
			meanings = new ArrayList <String>();
			meanings.add("scoundrels");
			theWords.put(key, meanings);
			
			key = "role";
			meanings = new ArrayList <String>();
			meanings.add("part");
			theWords.put(key, meanings);
			
			key = "roll";
			meanings = new ArrayList <String>();
			meanings.add("go round");
			theWords.put(key, meanings);
			
			key = "roller";
			meanings = new ArrayList <String>();
			meanings.add("fancy car");
			theWords.put(key, meanings);
			
			//key = "roma";
			//meanings = new ArrayList <String>();
			//meanings.add("foreign port");
			//theWords.put(key, meanings);
			
			key = "roman";
			meanings = new ArrayList <String>();
			meanings.add("italian");
			theWords.put(key, meanings);
			
			key = "romanians";
			meanings = new ArrayList <String>();
			meanings.add("europeans");
			theWords.put(key, meanings);
			
			key = "romance";
			meanings = new ArrayList <String>();
			meanings.add("love story");
			theWords.put(key, meanings);
					
			key = "rome";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "romeo";
			meanings = new ArrayList <String>();
			meanings.add("ladies' man");
			theWords.put(key, meanings);
			
			key = "room";
			meanings = new ArrayList <String>();
			meanings.add("accommodation");
			meanings.add("space");
			theWords.put(key, meanings);
			
			key = "rooms";
			meanings = new ArrayList <String>();
			meanings.add("accommodation");
			theWords.put(key, meanings);
			
			key = "root";
			meanings = new ArrayList <String>();
			meanings.add("origin");
			theWords.put(key, meanings);
			
			key = "rope";
			meanings = new ArrayList <String>();
			meanings.add("catche");
			theWords.put(key, meanings);
			
			key = "ropes";
			meanings = new ArrayList <String>();
			meanings.add("catches");
			theWords.put(key, meanings);
				
			key = "rose";
			meanings = new ArrayList <String>();
			meanings.add("got to his feet");
			theWords.put(key, meanings);
			
			key = "roses";
			meanings = new ArrayList <String>();
			meanings.add("flowers");
			theWords.put(key, meanings);
			
			key = "rosette";
			meanings = new ArrayList <String>();
			meanings.add("like a rose");
			theWords.put(key, meanings);
			
			key = "rosehip";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "rot";
			meanings = new ArrayList <String>();
			meanings.add("decay");
			theWords.put(key, meanings);
			
			key = "rotters";
			meanings = new ArrayList <String>();
			meanings.add("nasty people");
			meanings.add("unkind people");
			theWords.put(key, meanings);
			
			key = "round";
			meanings = new ArrayList <String>();
			meanings.add("circular");
			theWords.put(key, meanings);
			
			key = "rouse";
			meanings = new ArrayList <String>();
			meanings.add("stir");
			theWords.put(key, meanings);
			
			key = "route";
			meanings = new ArrayList <String>();
			meanings.add("path");
			meanings.add("way");
			theWords.put(key, meanings);
			
			key = "row";
			meanings = new ArrayList <String>();
			meanings.add("argue");
			meanings.add("argument");
			meanings.add("dispute");
			meanings.add("line");
			theWords.put(key, meanings);
			
			key = "rowan";
			meanings = new ArrayList <String>();
			meanings.add("tree");
			theWords.put(key, meanings);
			
			key = "rows";
			meanings = new ArrayList <String>();
			meanings.add("lines");
			theWords.put(key, meanings);
			
			key = "royal";
			meanings = new ArrayList <String>();
			meanings.add("princely");
			theWords.put(key, meanings);
			
			key = "rub";
			meanings = new ArrayList <String>();
			meanings.add("massage");
			theWords.put(key, meanings);
			
			key = "rubber";
			meanings = new ArrayList <String>();
			meanings.add("eraser");
			meanings.add("massuer");
			theWords.put(key, meanings);
			
			key = "rubs";
			meanings = new ArrayList <String>();
			meanings.add("massages");
			theWords.put(key, meanings);
			
			key = "ruder";
			meanings = new ArrayList <String>();
			meanings.add("less polite");
			theWords.put(key, meanings);
			
			key = "rudder";
			meanings = new ArrayList <String>();
			meanings.add("boating device");
			theWords.put(key, meanings);
			
			key = "rue";
			meanings = new ArrayList <String>();
			meanings.add("regret");
			theWords.put(key, meanings);
			
			key = "ruer";
			meanings = new ArrayList <String>();
			meanings.add("one who regrets");
			theWords.put(key, meanings);
			
			key = "rugby";
			meanings = new ArrayList <String>();
			meanings.add("game");
			theWords.put(key, meanings);
			
			key = "ruin";
			meanings = new ArrayList <String>();
			meanings.add("wreck");
			theWords.put(key, meanings);
			
			key = "ruins";
			meanings = new ArrayList <String>();
			meanings.add("wrecks");
			theWords.put(key, meanings);
			
			key = "ruler";
			meanings = new ArrayList <String>();
			meanings.add("sovereign");
			theWords.put(key, meanings);
			
			key = "rum";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			meanings.add("eccentric");
			meanings.add("funny");
			meanings.add("odd");
			meanings.add("peculiar");
			meanings.add("strange");
			theWords.put(key, meanings);
			
			key = "rumba";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "rumoured";
			meanings = new ArrayList <String>();
			meanings.add("unverified");
			theWords.put(key, meanings);
			
			key = "run";
			meanings = new ArrayList <String>();
			meanings.add("flee");
			meanings.add("ladder");
			meanings.add("manage");
			meanings.add("race");
			meanings.add("sprint");
			theWords.put(key, meanings);
					
			key = "runaway";
			meanings = new ArrayList <String>();
			meanings.add("fugitive");
			theWords.put(key, meanings);
			
			key = "rung";
			meanings = new ArrayList <String>();
			meanings.add("step");
			theWords.put(key, meanings);
					
			key = "running";
			meanings = new ArrayList <String>();
			meanings.add("working");
			theWords.put(key, meanings);
			
			key = "runt";
			meanings = new ArrayList <String>();
			meanings.add("littlest piggy");
			theWords.put(key, meanings);
			
			key = "runs";
			meanings = new ArrayList <String>();
			meanings.add("races");
			theWords.put(key, meanings);
			
			key = "runway";
			meanings = new ArrayList <String>();
			meanings.add("airstrip");
			theWords.put(key, meanings);
			
			key = "rupert";
			meanings = new ArrayList <String>();
			meanings.add("bear");
			theWords.put(key, meanings);
			
			key = "rural";
			meanings = new ArrayList <String>();
			meanings.add("rustic");
			theWords.put(key, meanings);
			
			key = "rurally";
			meanings = new ArrayList <String>();
			meanings.add("in the country");
			theWords.put(key, meanings);
			
			key = "rush";
			meanings = new ArrayList <String>();
			meanings.add("charge");
			theWords.put(key, meanings);
			
			key = "rustic";
			meanings = new ArrayList <String>();
			meanings.add("from the country");
			theWords.put(key, meanings);
			
			key = "rut";
			meanings = new ArrayList <String>();
			meanings.add("dreary routine");
			theWords.put(key, meanings);
			
			key = "ruth";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "ruthless";
			meanings = new ArrayList <String>();
			meanings.add("without pity");
			theWords.put(key, meanings);

			return theWords;
		}//end loadRWords
		
		public TreeMap<String, ArrayList<String>> loadSWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load s's
			key = "sabbath";
			meanings = new ArrayList <String>();
			meanings.add("rest day");
			theWords.put(key, meanings);
			
			key = "sabot";
			meanings = new ArrayList <String>();
			meanings.add("French clog");
			theWords.put(key, meanings);
			
			key = "sabotages";
			meanings = new ArrayList <String>();
			meanings.add("deliberately wrecks");
			theWords.put(key, meanings);
			
			key = "sabre";
			meanings = new ArrayList <String>();
			meanings.add("weapon");
			theWords.put(key, meanings);
			
			key = "sack";
			meanings = new ArrayList <String>();
			meanings.add("fire");
			meanings.add("container");
			meanings.add("large bag");
			meanings.add("mailbag");
			theWords.put(key, meanings);
			
			key = "sackrace";//sack race
			meanings = new ArrayList <String>();
			meanings.add("competition");
			theWords.put(key, meanings);
			
			key = "sacks";
			meanings = new ArrayList <String>();
			meanings.add("bags");
			meanings.add("mailbags");
			theWords.put(key, meanings);
			
			key = "sadder";
			meanings = new ArrayList <String>();
			meanings.add("more unhappy");
			theWords.put(key, meanings);
			
			key = "saddle";
			meanings = new ArrayList <String>();
			meanings.add("seat");
			theWords.put(key, meanings);
			
			key = "saddler";
			meanings = new ArrayList <String>();
			meanings.add("leather worker");
			theWords.put(key, meanings);
			
			key = "safe";
			meanings = new ArrayList <String>();
			meanings.add("secure");
			theWords.put(key, meanings);
			
			key = "sag";
			meanings = new ArrayList <String>();
			meanings.add("droop");
			meanings.add("slump");
			meanings.add("wilt");
			theWords.put(key, meanings);
			
			key = "saga";
			meanings = new ArrayList <String>();
			meanings.add("long story");
			theWords.put(key, meanings);	
					
			key = "sage";
			meanings = new ArrayList <String>();
			meanings.add("herb");
			theWords.put(key, meanings);
			
			key = "sail";
			meanings = new ArrayList <String>();
			meanings.add("travel by boat");
			theWords.put(key, meanings);
			
			key = "saint";
			meanings = new ArrayList <String>();
			meanings.add("patient person");
			theWords.put(key, meanings);
			
			key = "sallow";
			meanings = new ArrayList <String>();
			meanings.add("pale");
			theWords.put(key, meanings);
			
			key = "sam";
			meanings = new ArrayList <String>();
			meanings.add("uncle");
			meanings.add("US uncle");
			theWords.put(key, meanings);

			key = "samba";
			meanings = new ArrayList <String>();
			meanings.add("ballroom dance");
			meanings.add("card game");
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "same";
			meanings = new ArrayList <String>();
			meanings.add("no different");
			meanings.add("similar");
			theWords.put(key, meanings);
			
			key = "sample";
			meanings = new ArrayList <String>();
			meanings.add("specimen");
			theWords.put(key, meanings);
			
			key = "sandpipers";
			meanings = new ArrayList <String>();
			meanings.add("birds");
			theWords.put(key, meanings);
			
			key = "sandwich";
			meanings = new ArrayList <String>();
			meanings.add("golf course");
			meanings.add("snack");
			theWords.put(key, meanings);
					
			key = "sanmarino";
			meanings = new ArrayList <String>();
			meanings.add("independent republic");
			theWords.put(key, meanings);
			
			key = "santa";
			meanings = new ArrayList <String>();
			meanings.add("Father Christmas");
			theWords.put(key, meanings);
			
			key = "sap";
			meanings = new ArrayList <String>();
			meanings.add("juice of plants");
			meanings.add("lie");
			theWords.put(key, meanings);
			
			key = "saps";
			meanings = new ArrayList <String>();
			meanings.add("fools");
			theWords.put(key, meanings);
			
			key = "sardine";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "sari";
			meanings = new ArrayList <String>();
			meanings.add("Eastern garment");
			theWords.put(key, meanings);
			
			key = "sash";
			meanings = new ArrayList <String>();
			meanings.add("band");
			theWords.put(key, meanings);
			
			key = "sated";
			meanings = new ArrayList <String>();
			meanings.add("fed up");
			theWords.put(key, meanings);
			
			key = "satin";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "saturn";
			meanings = new ArrayList <String>();
			meanings.add("Roman god");
			theWords.put(key, meanings);
			
			key = "satyr";
			meanings = new ArrayList <String>();
			meanings.add("deity");
			theWords.put(key, meanings);
			
			key = "sauce";
			meanings = new ArrayList <String>();
			meanings.add("cheek");
			theWords.put(key, meanings);
			
			key = "saucepan";
			meanings = new ArrayList <String>();
			meanings.add("kitchen equipment");
			theWords.put(key, meanings);
			
			key = "sauna";
			meanings = new ArrayList <String>();
			meanings.add("steam bath");
			theWords.put(key, meanings);
			
			key = "saw";
			meanings = new ArrayList <String>();
			meanings.add("noticed");
			meanings.add("witnessed");
			theWords.put(key, meanings);
			
			key = "say";
			meanings = new ArrayList <String>();
			meanings.add("state");
			theWords.put(key, meanings);
			
			key = "says";
			meanings = new ArrayList <String>();
			meanings.add("states");
			theWords.put(key, meanings);
			
			key = "scaffold";
			meanings = new ArrayList <String>();
			meanings.add("raised platform");
			theWords.put(key, meanings);
			
			key = "scalpel";
			meanings = new ArrayList <String>();
			meanings.add("one useful in theatres");
			theWords.put(key, meanings);
			
			key = "scam";
			meanings = new ArrayList <String>();
			meanings.add("con");
			meanings.add("fraud");
			theWords.put(key, meanings);
			
			key = "scamp";
			meanings = new ArrayList <String>();
			meanings.add("mischief maker");
			meanings.add("rascal");
			theWords.put(key, meanings);
			
			key = "scampi";
			meanings = new ArrayList <String>();
			meanings.add("prawns");
			theWords.put(key, meanings);
			
			key = "scan";
			meanings = new ArrayList <String>();
			meanings.add("cast an eye over");
			meanings.add("digitise a picture");
			meanings.add("read");
			theWords.put(key, meanings);
					
			key = "scar";
			meanings = new ArrayList <String>();
			meanings.add("mark");
			theWords.put(key, meanings);
					
			key = "scarf";
			meanings = new ArrayList <String>();
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "scare";
			meanings = new ArrayList <String>();
			meanings.add("frighten");
			theWords.put(key, meanings);
			
			key = "scares";
			meanings = new ArrayList <String>();
			meanings.add("frightens");
			theWords.put(key, meanings);
			
			key = "scarlet";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			meanings.add("bright red");
			theWords.put(key, meanings);
			
			key = "scarring";
			meanings = new ArrayList <String>();
			meanings.add("marks");
			theWords.put(key, meanings);
			
			key = "scatter";
			meanings = new ArrayList <String>();
			meanings.add("disperse");
			theWords.put(key, meanings);
			
			key = "scene";
			meanings = new ArrayList <String>();
			meanings.add("part in play");
			theWords.put(key, meanings);
			
			key = "scenic";
			meanings = new ArrayList <String>();
			meanings.add("picturesque");
			theWords.put(key, meanings);
					
			key = "scone";
			meanings = new ArrayList <String>();
			meanings.add("cake");
			theWords.put(key, meanings);
			
			key = "scoot";
			meanings = new ArrayList <String>();
			meanings.add("dash");
			theWords.put(key, meanings);

			key = "scope";
			meanings = new ArrayList <String>();
			meanings.add("range");
			theWords.put(key, meanings);
			
			key = "scores";
			meanings = new ArrayList <String>();
			meanings.add("many");
			theWords.put(key, meanings);
			
			key = "scorn";
			meanings = new ArrayList <String>();
			meanings.add("contempt");
			theWords.put(key, meanings);
			
			key = "scorpion";
			meanings = new ArrayList <String>();
			meanings.add("stinging creature");
			theWords.put(key, meanings);
			
			key = "scot";
			meanings = new ArrayList <String>();
			meanings.add("Highlander");
			theWords.put(key, meanings);
			
			key = "scotch";
			meanings = new ArrayList <String>();
			meanings.add("whisky");
			theWords.put(key, meanings);
			
			key = "scotland";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
					
			key = "scottish";
			meanings = new ArrayList <String>();
			meanings.add("from Scotland");
			theWords.put(key, meanings);
			
			key = "scout";
			meanings = new ArrayList <String>();
			meanings.add("search for");
			theWords.put(key, meanings);
			
			key = "scowl";
			meanings = new ArrayList <String>();
			meanings.add("sullen look");
			theWords.put(key, meanings);
			
			key = "scowling";
			meanings = new ArrayList <String>();
			meanings.add("looking displeased");
			theWords.put(key, meanings);
			
			key = "scythe";
			meanings = new ArrayList <String>();
			meanings.add("cutter");
			theWords.put(key, meanings);
			
			key = "scrap";
			meanings = new ArrayList <String>();
			meanings.add("small piece of food");
			meanings.add("fight");
			theWords.put(key, meanings);
			
			key = "scrape";
			meanings = new ArrayList <String>();
			meanings.add("pickle");
			meanings.add("superficial wound");
			theWords.put(key, meanings);
			
			key = "scrawny";
			meanings = new ArrayList <String>();
			meanings.add("thin and boney");
			meanings.add("unpleasently thin");
			theWords.put(key, meanings);
			
			key = "scream";
			meanings = new ArrayList <String>();
			meanings.add("shout loudly");
			theWords.put(key, meanings);
			
			key = "scree";
			meanings = new ArrayList <String>();
			meanings.add("fallen rocks");
			meanings.add("stones");
			theWords.put(key, meanings);
			
			key = "screech";
			meanings = new ArrayList <String>();
			meanings.add("strident noise");
			theWords.put(key, meanings);
			
			key = "screen";
			meanings = new ArrayList <String>();
			meanings.add("put on television");
			theWords.put(key, meanings);
			
			key = "script";
			meanings = new ArrayList <String>();
			meanings.add("writing");
			theWords.put(key, meanings);
			
			key = "scuba";
			meanings = new ArrayList <String>();
			meanings.add("breathing apparatus");
			theWords.put(key, meanings);
			
			key = "scuff";
			meanings = new ArrayList <String>();
			meanings.add("scrape");
			theWords.put(key, meanings);
			
			key = "scuffle";
			meanings = new ArrayList <String>();
			meanings.add("fight");
			theWords.put(key, meanings);
			
			key = "scuppered";
			meanings = new ArrayList <String>();
			meanings.add("runied");
			theWords.put(key, meanings);
			
			key = "sea";
			meanings = new ArrayList <String>();
			meanings.add("body of water");
			theWords.put(key, meanings);
			
			key = "seafarer";
			meanings = new ArrayList <String>();
			meanings.add("sailor");
			theWords.put(key, meanings);
			
			key = "seance";
			meanings = new ArrayList <String>();
			meanings.add("spirited meeting");
			theWords.put(key, meanings);
			
			key = "searing";
			meanings = new ArrayList <String>();
			meanings.add("cooking technique");
			theWords.put(key, meanings);
			
			key = "seat";
			meanings = new ArrayList <String>();
			meanings.add("behind");
			meanings.add("rear");
			meanings.add("arrange");
			theWords.put(key, meanings);
					
			key = "sect";
			meanings = new ArrayList <String>();
			meanings.add("cult");
			theWords.put(key, meanings);
			
			key = "secure";
			meanings = new ArrayList <String>();
			meanings.add("fasten");
			theWords.put(key, meanings);
		
			key = "sediment";
			meanings = new ArrayList <String>();
			meanings.add("deposit");
			theWords.put(key, meanings);
			
			key = "seduction";
			meanings = new ArrayList <String>();
			meanings.add("lure");
			theWords.put(key, meanings);

			key = "see";
			meanings = new ArrayList <String>();
			meanings.add("look at");
			meanings.add("observe");
			theWords.put(key, meanings);
			
			key = "seed";
			meanings = new ArrayList <String>();
			meanings.add("pip");
			meanings.add("sow");
			theWords.put(key, meanings);
					
			key = "seep";
			meanings = new ArrayList <String>();
			meanings.add("ooze");
			theWords.put(key, meanings);
					
			key = "seer";
			meanings = new ArrayList <String>();
			meanings.add("guy predicting");
			meanings.add("viewer");
			theWords.put(key, meanings);
			
			key = "seethes";
			meanings = new ArrayList <String>();
			meanings.add("boils");
			theWords.put(key, meanings);
			
			key = "segregate";
			meanings = new ArrayList <String>();
			meanings.add("seperate");
			theWords.put(key, meanings);
			
			key = "seldom";
			meanings = new ArrayList <String>();
			meanings.add("not very often");
			theWords.put(key, meanings);
			
			key = "select";
			meanings = new ArrayList <String>();
			meanings.add("choose");
			theWords.put(key, meanings);
			
			key = "selfish";
			meanings = new ArrayList <String>();
			meanings.add("ungenerous");
			theWords.put(key, meanings);
			
			key = "selkirk";
			meanings = new ArrayList <String>();
			meanings.add("Scottish town");
			theWords.put(key, meanings);
			
			key = "seller";
			meanings = new ArrayList <String>();
			meanings.add("vendor");
			theWords.put(key, meanings);
			
			key = "sells";
			meanings = new ArrayList <String>();
			meanings.add("vends");
			theWords.put(key, meanings);
			
			key = "semi";
			meanings = new ArrayList <String>();
			meanings.add("half");
			theWords.put(key, meanings);
			
			key = "sepia";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			theWords.put(key, meanings);
			
			key = "serbia";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "sergeant";
			meanings = new ArrayList <String>();
			meanings.add("rank");
			theWords.put(key, meanings);
			
			key = "serial";
			meanings = new ArrayList <String>();
			meanings.add("repeatedly");
			theWords.put(key, meanings);
			
			key = "serpent";
			meanings = new ArrayList <String>();
			meanings.add("snake");
			theWords.put(key, meanings);
			
			key = "serve";
			meanings = new ArrayList <String>();
			meanings.add("attend to customers");
			theWords.put(key, meanings);
			
			key = "sesame";
			meanings = new ArrayList <String>();
			meanings.add("sort of seed");
			theWords.put(key, meanings);
			
			key = "set";
			meanings = new ArrayList <String>();
			meanings.add("assign");
			meanings.add("determined");
			meanings.add("group");
			meanings.add("hardened");
			meanings.add("lay");
			meanings.add("placed");
			theWords.put(key, meanings);
			
			key = "setoff";//set off
			meanings = new ArrayList <String>();
			meanings.add("show to advantage");
			meanings.add("start");
			theWords.put(key, meanings);
			
			key = "sets";
			meanings = new ArrayList <String>();
			meanings.add("assigns");
			meanings.add("hardens");
			meanings.add("lays");
			theWords.put(key, meanings);

			key = "settees";
			meanings = new ArrayList <String>();
			meanings.add("furniture");
			theWords.put(key, meanings);
			
			key = "setter";
			meanings = new ArrayList <String>();
			meanings.add("fixing agent");
			theWords.put(key, meanings);
			
			key = "settle";
			meanings = new ArrayList <String>();
			meanings.add("resolve");
			theWords.put(key, meanings);
			
			key = "settler";
			meanings = new ArrayList <String>();
			meanings.add("dweller");
			theWords.put(key, meanings);
			
			key = "seattle";
			meanings = new ArrayList <String>();
			meanings.add("city in America");
			theWords.put(key, meanings);
			
			key = "seaworthy";
			meanings = new ArrayList <String>();
			meanings.add("fit to sail");
			theWords.put(key, meanings);
			
			key = "seen";
			meanings = new ArrayList <String>();
			meanings.add("spotted");
			theWords.put(key, meanings);
			
			key = "sees";
			meanings = new ArrayList <String>();
			meanings.add("spots");
			theWords.put(key, meanings);
			
			key = "senator";
			meanings = new ArrayList <String>();
			meanings.add("US politician");
			theWords.put(key, meanings);
			
			key = "sender";
			meanings = new ArrayList <String>();
			meanings.add("poster");
			theWords.put(key, meanings);
			
			key = "sends";
			meanings = new ArrayList <String>();
			meanings.add("dispatches");
			theWords.put(key, meanings);
			
			key = "seniors";
			meanings = new ArrayList <String>();
			meanings.add("elders");
			theWords.put(key, meanings);
			
			key = "sent";
			meanings = new ArrayList <String>();
			meanings.add("dispatched");
			theWords.put(key, meanings);
			
			key = "sentimental";
			meanings = new ArrayList <String>();
			meanings.add("emotional");
			theWords.put(key, meanings);
			
			key = "sentry";
			meanings = new ArrayList <String>();
			meanings.add("guard");
			theWords.put(key, meanings);
			
			key = "serene";
			meanings = new ArrayList <String>();
			meanings.add("calm");
			theWords.put(key, meanings);
			
			key = "serengeti";
			meanings = new ArrayList <String>();
			meanings.add("game reserve");
			theWords.put(key, meanings);
			
			key = "serf";
			meanings = new ArrayList <String>();
			meanings.add("slave");
			theWords.put(key, meanings);
			
			key = "servant";
			meanings = new ArrayList <String>();
			meanings.add("domestic worker");
			theWords.put(key, meanings);
			
			key = "seventh";
			meanings = new ArrayList <String>();
			meanings.add("in the top ten, for example");
			theWords.put(key, meanings);
			
			key = "sever";
			meanings = new ArrayList <String>();
			meanings.add("cut off");
			theWords.put(key, meanings);
			
			key = "sewing";
			meanings = new ArrayList <String>();
			meanings.add("needlework");
			theWords.put(key, meanings);
			
			key = "sewn";
			meanings = new ArrayList <String>();
			meanings.add("stitched together");
			theWords.put(key, meanings);
			
			key = "shabby";
			meanings = new ArrayList <String>();
			meanings.add("run-down");
			theWords.put(key, meanings);
			
			key = "shaking";
			meanings = new ArrayList <String>();
			meanings.add("trembling");
			theWords.put(key, meanings);
			
			key = "shallots";
			meanings = new ArrayList <String>();
			meanings.add("vegetables");
			theWords.put(key, meanings);
			
			key = "shallow";
			meanings = new ArrayList <String>();
			meanings.add("superficial");
			theWords.put(key, meanings);
					
			key = "sham";
			meanings = new ArrayList <String>();
			meanings.add("not real");
			meanings.add("lie");
			theWords.put(key, meanings);
			
			key = "shambles";
			meanings = new ArrayList <String>();
			meanings.add("chaos");
			meanings.add("mess");
			theWords.put(key, meanings);
			
			key = "shame";
			meanings = new ArrayList <String>();
			meanings.add("disgrace");
			theWords.put(key, meanings);
			
			key = "shape";
			meanings = new ArrayList <String>();
			meanings.add("form");
			theWords.put(key, meanings);
			
			key = "shaped";
			meanings = new ArrayList <String>();
			meanings.add("moulded");
			meanings.add("influenced");
			theWords.put(key, meanings);
			
			key = "shark";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
					
			key = "shaw";
			meanings = new ArrayList <String>();
			meanings.add("playright");
			theWords.put(key, meanings);
			
			key = "shawl";
			meanings = new ArrayList <String>();
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "shay";
			meanings = new ArrayList <String>();
			meanings.add("carriage");
			theWords.put(key, meanings);
			
			key = "she";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "shed";
			meanings = new ArrayList <String>();
			meanings.add("throw off");
			meanings.add("garden building");
			theWords.put(key, meanings);
			
			key = "sheep";
			meanings = new ArrayList <String>();
			meanings.add("merino");
			theWords.put(key, meanings);
			
			key = "sherpas";
			meanings = new ArrayList <String>();
			meanings.add("people in the Hymalayas");
			theWords.put(key, meanings);
			
			key = "sherry";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "shield";
			meanings = new ArrayList <String>();
			meanings.add("visor");
			theWords.put(key, meanings);
			
			key = "ship";
			meanings = new ArrayList <String>();
			meanings.add("boat");
			theWords.put(key, meanings);
					
			key = "shivering";
			meanings = new ArrayList <String>();
			meanings.add("trembling");
			theWords.put(key, meanings);
			
			key = "shogun";
			meanings = new ArrayList <String>();
			meanings.add("emperor");
			theWords.put(key, meanings);
			
			key = "shoo";
			meanings = new ArrayList <String>();
			meanings.add("go away");
			theWords.put(key, meanings);
			
			key = "shoot";
			meanings = new ArrayList <String>();
			meanings.add("fire gun");
			theWords.put(key, meanings);
			
			key = "shop";
			meanings = new ArrayList <String>();
			meanings.add("tell on");
			theWords.put(key, meanings);
			
			key = "shopper";
			meanings = new ArrayList <String>();
			meanings.add("one making purchases");
			meanings.add("retailer");
			theWords.put(key, meanings);
			
			key = "shot";
			meanings = new ArrayList <String>();
			meanings.add("attempt");
			meanings.add("fired");
			theWords.put(key, meanings);
					
			key = "shotput";
			meanings = new ArrayList <String>();
			meanings.add("field event");
			theWords.put(key, meanings);
			
			key = "shovel";
			meanings = new ArrayList <String>();
			meanings.add("gardening tool");
			meanings.add("tool");
			theWords.put(key, meanings);
			
			key = "show";
			meanings = new ArrayList <String>();
			meanings.add("display");
			meanings.add("exhibit");
			theWords.put(key, meanings);
			
			key = "shrieked";
			meanings = new ArrayList <String>();
			meanings.add("made a lot of noise");
			theWords.put(key, meanings);
			
			key = "shrive";
			meanings = new ArrayList <String>();
			meanings.add("hear the confession of");
			theWords.put(key, meanings);
			
			key = "shrivel";
			meanings = new ArrayList <String>();
			meanings.add("dry up");
			theWords.put(key, meanings);
			
			key = "shrub";
			meanings = new ArrayList <String>();
			meanings.add("bush");
			meanings.add("woody plant");
			theWords.put(key, meanings);
			
			key = "shrug";
			meanings = new ArrayList <String>();
			meanings.add("express a lack of interest");
			theWords.put(key, meanings);
			
			key = "shut";
			meanings = new ArrayList <String>();
			meanings.add("closed");
			theWords.put(key, meanings);
			
			key = "shutup";
			meanings = new ArrayList <String>();
			meanings.add("confined");
			meanings.add("keep mum");
			theWords.put(key, meanings);
					
			key = "shy";
			meanings = new ArrayList <String>();
			meanings.add("bashful");
			meanings.add("quick throw");
			meanings.add("reserved");
			meanings.add("reticant");
			meanings.add("short");
			meanings.add("throw quickly");
			meanings.add("timid");
			theWords.put(key, meanings);
			
			key = "side";
			meanings = new ArrayList <String>();
			meanings.add("players");
			meanings.add("team");
			theWords.put(key, meanings);
			
			key = "sidle";
			meanings = new ArrayList <String>();
			meanings.add("move cautiously");
			theWords.put(key, meanings);
					
			key = "sieve";
			meanings = new ArrayList <String>();
			meanings.add("strainer");
			theWords.put(key, meanings);
			
			key = "sighted";
			meanings = new ArrayList <String>();
			meanings.add("seen");
			theWords.put(key, meanings);
			
			key = "sigma";
			meanings = new ArrayList <String>();
			meanings.add("Greek character");
			theWords.put(key, meanings);
			
			key = "sign";
			meanings = new ArrayList <String>();
			meanings.add("banner");
			meanings.add("indication");
			meanings.add("nonverbal action");
			meanings.add("notice");
			meanings.add("part of zodiac");
			theWords.put(key, meanings);
			
			key = "signal";
			meanings = new ArrayList <String>();
			meanings.add("sign");
			theWords.put(key, meanings);
			
			key = "signing";
			meanings = new ArrayList <String>();
			meanings.add("communicating without speaking");
			theWords.put(key, meanings);
			
			key = "signore";
			meanings = new ArrayList <String>();
			meanings.add("italian woman");
			theWords.put(key, meanings);
			
			key = "silent";
			meanings = new ArrayList <String>();
			meanings.add("not speaking");
			theWords.put(key, meanings);
			
			key = "silk";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "silo";
			meanings = new ArrayList <String>();
			meanings.add("storage");
			theWords.put(key, meanings);
			
			key = "silver";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			meanings.add("precious metal");
			theWords.put(key, meanings);
			
			key = "simmer";
			meanings = new ArrayList <String>();
			meanings.add("cook");
			theWords.put(key, meanings);
			
			key = "simple";
			meanings = new ArrayList <String>();
			meanings.add("easy");
			theWords.put(key, meanings);
			
			key = "sin";
			meanings = new ArrayList <String>();
			meanings.add("evil");
			theWords.put(key, meanings);
			
			key = "since";
			meanings = new ArrayList <String>();
			meanings.add("because");
			theWords.put(key, meanings);	
			
			key = "sincere";
			meanings = new ArrayList <String>();
			meanings.add("genuine");
			theWords.put(key, meanings);
			
			key = "sinew";
			meanings = new ArrayList <String>();
			meanings.add("tendon");
			theWords.put(key, meanings);
			
			key = "sing";
			meanings = new ArrayList <String>();
			meanings.add("make musical sounds");
			theWords.put(key, meanings);
			
			key = "singe";
			meanings = new ArrayList <String>();
			meanings.add("superficial burn");
			theWords.put(key, meanings);
			
			key = "singer";
			meanings = new ArrayList <String>();
			meanings.add("vocalist");
			theWords.put(key, meanings);
			
			key = "singers";
			meanings = new ArrayList <String>();
			meanings.add("entertainers");
			meanings.add("vocalists");
			theWords.put(key, meanings);
			
			key = "singlet";
			meanings = new ArrayList <String>();
			meanings.add("vest");
			theWords.put(key, meanings);
					
			key = "sinister";
			meanings = new ArrayList <String>();
			meanings.add("left");
			meanings.add("threatening");
			theWords.put(key, meanings);
			
			key = "sink";
			meanings = new ArrayList <String>();
			meanings.add("diminish");
			meanings.add("drink alcohol");
			meanings.add("go down");
			theWords.put(key, meanings);
			
			key = "siphon";
			meanings = new ArrayList <String>();
			meanings.add("draw off");
			theWords.put(key, meanings);
			
			key = "sir";
			meanings = new ArrayList <String>();
			meanings.add("knight");
			theWords.put(key, meanings);
			
			key = "sister";
			meanings = new ArrayList <String>();
			meanings.add("one of the family");
			meanings.add("relative");
			meanings.add("sibling");
			theWords.put(key, meanings);
			
			key = "site";
			meanings = new ArrayList <String>();
			meanings.add("location");
			theWords.put(key, meanings);
			
			key = "sits";
			meanings = new ArrayList <String>();
			meanings.add("rests");
			theWords.put(key, meanings);
			
			key = "six";
			meanings = new ArrayList <String>();
			meanings.add("high boundary");
			theWords.put(key, meanings);
			
			key = "sixth";
			meanings = new ArrayList <String>();
			meanings.add("roughly 17%");
			theWords.put(key, meanings);
						
			key = "sketch";
			meanings = new ArrayList <String>();
			meanings.add("draw");
			theWords.put(key, meanings);
			
			key = "skew";
			meanings = new ArrayList <String>();
			meanings.add("crooked");
			theWords.put(key, meanings);
			
			key = "skewbald";
			meanings = new ArrayList <String>();
			meanings.add("mottled horse");
			theWords.put(key, meanings);
			
			key = "ski";
			meanings = new ArrayList <String>();
			meanings.add("snow shoe");
			theWords.put(key, meanings);
			
			key = "skilled";
			meanings = new ArrayList <String>();
			meanings.add("expert");
			theWords.put(key, meanings);
			
			key = "skimp";
			meanings = new ArrayList <String>();
			meanings.add("be sparing");
			theWords.put(key, meanings);
			
			key = "skin";
			meanings = new ArrayList <String>();
			meanings.add("hide");
			theWords.put(key, meanings);
			
			key = "skindeep";//skin deep
			meanings = new ArrayList <String>();
			meanings.add("superficial");
			theWords.put(key, meanings);
			
			key = "skinflints";
			meanings = new ArrayList <String>();
			meanings.add("mean people");
			theWords.put(key, meanings);
			
			key = "skip";
			meanings = new ArrayList <String>();
			meanings.add("rubbish container");
			theWords.put(key, meanings);
			
		
			key = "skin";
			meanings = new ArrayList <String>();
			meanings.add("outer layer");
			meanings.add("peel");
			theWords.put(key, meanings);
			
			key = "skipper";
			meanings = new ArrayList <String>();
			meanings.add("captain");
			theWords.put(key, meanings);
			
			key = "slacken";
			meanings = new ArrayList <String>();
			meanings.add("become loose");
			theWords.put(key, meanings);
			
			key = "slang";
			meanings = new ArrayList <String>();
			meanings.add("jargon");
			theWords.put(key, meanings);
			
			key = "slat";
			meanings = new ArrayList <String>();
			meanings.add("piece of wood");
			theWords.put(key, meanings);
			
			key = "slate";
			meanings = new ArrayList <String>();
			meanings.add("roofing material");
			meanings.add("lambaste");
			meanings.add("savage");
			meanings.add("severely criticise");
			theWords.put(key, meanings);
			
			key = "slay";
			meanings = new ArrayList <String>();
			meanings.add("bump off");
			meanings.add("kill");
			meanings.add("massacre");
			meanings.add("murder");
			theWords.put(key, meanings);
			
			key = "slaying";
			meanings = new ArrayList <String>();
			meanings.add("murder");
			theWords.put(key, meanings);
			
			key = "sledge";
			meanings = new ArrayList <String>();
			meanings.add("vehicle mounted on runners");
			theWords.put(key, meanings);
			
			key = "sleep";
			meanings = new ArrayList <String>();
			meanings.add("nap");
			theWords.put(key, meanings);
			
			key = "sleepy";
			meanings = new ArrayList <String>();
			meanings.add("ready for bed");
			theWords.put(key, meanings);
			
			key = "sleek";
			meanings = new ArrayList <String>();
			meanings.add("smooth and shiny");
			theWords.put(key, meanings);
			
			key = "slender";
			meanings = new ArrayList <String>();
			meanings.add("narrow");
			theWords.put(key, meanings);
			
			key = "sleuth";
			meanings = new ArrayList <String>();
			meanings.add("detective");
			meanings.add("private investigator");
			theWords.put(key, meanings);
			
			key = "slide";
			meanings = new ArrayList <String>();
			meanings.add("playgraound feature");
			theWords.put(key, meanings);
			
			key = "sligo";
			meanings = new ArrayList <String>();
			meanings.add("town in Ireland");
			theWords.put(key, meanings);
			
			key = "slimmer";
			meanings = new ArrayList <String>();
			meanings.add("not so fat");
			theWords.put(key, meanings);
			
			key = "sling";
			meanings = new ArrayList <String>();
			meanings.add("chuck");
			meanings.add("support");
			theWords.put(key, meanings);
			
			key = "slings";
			meanings = new ArrayList <String>();
			meanings.add("supports");
			theWords.put(key, meanings);
			
			key = "sloop";
			meanings = new ArrayList <String>();
			meanings.add("sailing boat");
			theWords.put(key, meanings);
			
			key = "slope";
			meanings = new ArrayList <String>();
			meanings.add("part of a mountain");
			meanings.add("lie at an angle");
			theWords.put(key, meanings);
			
			key = "slot";
			meanings = new ArrayList <String>();
			meanings.add("opening");
			theWords.put(key, meanings);
			
			key = "sloth";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			theWords.put(key, meanings);
			
			key = "slow";
			meanings = new ArrayList <String>();
			meanings.add("unhurried");
			meanings.add("lagging behind");
			theWords.put(key, meanings);
			
			key = "smash";
			meanings = new ArrayList <String>();
			meanings.add("big hit");
			theWords.put(key, meanings);
			
			key = "smoke";
			meanings = new ArrayList <String>();
			meanings.add("vapour");
			theWords.put(key, meanings);
			
			key = "smother";
			meanings = new ArrayList <String>();
			meanings.add("stifle");
			theWords.put(key, meanings);
			
			key = "smug";
			meanings = new ArrayList <String>();
			meanings.add("overly confident");
			theWords.put(key, meanings);
			
			key = "smut";
			meanings = new ArrayList <String>();
			meanings.add("obscene stuff");
			theWords.put(key, meanings);
			
			key = "snag";
			meanings = new ArrayList <String>();
			meanings.add("catch");
			meanings.add("problem");
			meanings.add("sharp protuberance");
			meanings.add("unforseen obstacle");
			theWords.put(key, meanings);
			
			key = "snail";
			meanings = new ArrayList <String>();
			meanings.add("mollusc");
			theWords.put(key, meanings);
			
			key = "snared";
			meanings = new ArrayList <String>();
			meanings.add("trapped");
			theWords.put(key, meanings);
			
			key = "sneer";
			meanings = new ArrayList <String>();
			meanings.add("mock");
			theWords.put(key, meanings);
			
			key = "snide";
			meanings = new ArrayList <String>();
			meanings.add("disparaging");
			theWords.put(key, meanings);
			
			key = "snip";
			meanings = new ArrayList <String>();
			meanings.add("bargain");
			theWords.put(key, meanings);
			
			key = "sniper";
			meanings = new ArrayList <String>();
			meanings.add("marksman");
			theWords.put(key, meanings);
			
			key = "snips";
			meanings = new ArrayList <String>();
			meanings.add("cuts");
			theWords.put(key, meanings);
			
			key = "snoop";
			meanings = new ArrayList <String>();
			meanings.add("investigate");
			theWords.put(key, meanings);
			
			key = "snoops";
			meanings = new ArrayList <String>();
			meanings.add("spies");
			theWords.put(key, meanings);
			
			key = "snoopy";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "so";
			meanings = new ArrayList <String>();
			meanings.add("as such");
			meanings.add("thus");
			theWords.put(key, meanings);
			
			key = "soaking";
			meanings = new ArrayList <String>();
			meanings.add("drenched");
			meanings.add("waterlogged");
			theWords.put(key, meanings);
			
			key = "soap";
			meanings = new ArrayList <String>();
			meanings.add("TV programme");
			theWords.put(key, meanings);
			
			key = "sob";
			meanings = new ArrayList <String>();
			meanings.add("cry");
			theWords.put(key, meanings);
			
			key = "sock";
			meanings = new ArrayList <String>();
			meanings.add("hard blow");
			theWords.put(key, meanings);
			
			key = "socrates";
			meanings = new ArrayList <String>();
			meanings.add("philosopher");
			theWords.put(key, meanings);
			
			key = "sod";
			meanings = new ArrayList <String>();
			meanings.add("turf");
			theWords.put(key, meanings);
			
			key = "soda";
			meanings = new ArrayList <String>();
			meanings.add("mixer");
			theWords.put(key, meanings);
			
			key = "sofa";
			meanings = new ArrayList <String>();
			meanings.add("setee");
			theWords.put(key, meanings);
			
			key = "sofia";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			theWords.put(key, meanings);
			
			key = "soho";
			meanings = new ArrayList <String>();
			meanings.add("London district");
			theWords.put(key, meanings);
			
			key = "soil";
			meanings = new ArrayList <String>();
			meanings.add("earth");
			theWords.put(key, meanings);
			
			key = "sold";
			meanings = new ArrayList <String>();
			meanings.add("auctioned off");
			theWords.put(key, meanings);
			
			key = "sole";
			meanings = new ArrayList <String>();
			meanings.add("only");
			meanings.add("part of a shoe");
			theWords.put(key, meanings);
			
			key = "solid";
			meanings = new ArrayList <String>();
			meanings.add("firm");
			theWords.put(key, meanings);
			
			key = "solution";
			meanings = new ArrayList <String>();
			meanings.add("answer");
			theWords.put(key, meanings);
					
			key = "solve";		
			meanings = new ArrayList <String>();
			meanings.add("crack");
			theWords.put(key, meanings);
			
			key = "somali";
			meanings = new ArrayList <String>();
			meanings.add("african");
			theWords.put(key, meanings);
			
			key = "sombre";
			meanings = new ArrayList <String>();
			meanings.add("solemn");
			theWords.put(key, meanings);
			
			key = "some";
			meanings = new ArrayList <String>();
			meanings.add("a few");
			meanings.add("part");
			theWords.put(key, meanings);
			
			key = "somerset";
			meanings = new ArrayList <String>();
			meanings.add("county");
			theWords.put(key, meanings);
			
			key = "somewhere";
			meanings = new ArrayList <String>();
			meanings.add("unspecified place");
			theWords.put(key, meanings);
			
			key = "son";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("child");
			meanings.add("family member");
			theWords.put(key, meanings);
				
			key = "sonata";
			meanings = new ArrayList <String>();
			meanings.add("musical work");
			theWords.put(key, meanings);
					
			key = "song";
			meanings = new ArrayList <String>();
			meanings.add("vocal");
			theWords.put(key, meanings);
			
			key = "songstress";
			meanings = new ArrayList <String>();
			meanings.add("female singer");
			theWords.put(key, meanings);
			
			key = "soppy";
			meanings = new ArrayList <String>();
			meanings.add("sentimental");
			theWords.put(key, meanings);
			
			key = "sorbet";
			meanings = new ArrayList <String>();
			meanings.add("water ice");
			theWords.put(key, meanings);
			
			key = "sore";
			meanings = new ArrayList <String>();
			meanings.add("tender");
			theWords.put(key, meanings);
			
			key = "sort";
			meanings = new ArrayList <String>();
			meanings.add("type");
			theWords.put(key, meanings);
			
			key = "sot";
			meanings = new ArrayList <String>();
			meanings.add("drunkard");
			theWords.put(key, meanings);
			
			key = "sots";
			meanings = new ArrayList <String>();
			meanings.add("drunkards");
			theWords.put(key, meanings);
			
			key = "sound";
			meanings = new ArrayList <String>();
			meanings.add("healthy");
			meanings.add("noise");
			theWords.put(key, meanings);
			
			key = "sow";
			meanings = new ArrayList <String>();
			meanings.add("pig");
			theWords.put(key, meanings);
					
			key = "soy";
			meanings = new ArrayList <String>();
			meanings.add("sauce");
			theWords.put(key, meanings);
			
			key = "spa";
			meanings = new ArrayList <String>();
			meanings.add("health resort");
			theWords.put(key, meanings);
			
			key = "spades";
			meanings = new ArrayList <String>();
			meanings.add("shovels");
			meanings.add("suit");
			theWords.put(key, meanings);
			
			key = "spas";
			meanings = new ArrayList <String>();
			meanings.add("health resorts");
			theWords.put(key, meanings);
			
			key = "space";
			meanings = new ArrayList <String>();
			meanings.add("room");
			theWords.put(key, meanings);
			
			key = "spacing";
			meanings = new ArrayList <String>();
			meanings.add("distance apart");
			meanings.add("gaps");
			meanings.add("the distance between any two objects");
			theWords.put(key, meanings);
			
			key = "spacious";
			meanings = new ArrayList <String>();
			meanings.add("large");
			theWords.put(key, meanings);
			
			key = "spaniard";
			meanings = new ArrayList <String>();
			meanings.add("European");
			theWords.put(key, meanings);
			
			key = "spaniel";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "spaniels";
			meanings = new ArrayList <String>();
			meanings.add("dogs");
			theWords.put(key, meanings);
			
			key = "spanish";
			meanings = new ArrayList <String>();
			meanings.add("European");
			theWords.put(key, meanings);

			key = "spar";
			meanings = new ArrayList <String>();
			meanings.add("pole");
			theWords.put(key, meanings);
			
			key = "spare";
			meanings = new ArrayList <String>();
			meanings.add("free");
			meanings.add("held in reserve");
			meanings.add("left over");
			meanings.add("superfluous");
			theWords.put(key, meanings);
			
			key = "sparing";
			meanings = new ArrayList <String>();
			meanings.add("frugal");
			meanings.add("parsimonious");
			theWords.put(key, meanings);
			
			key = "spark";
			meanings = new ArrayList <String>();
			meanings.add("small amount");
			theWords.put(key, meanings);
			
			key = "sparrow";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "spartan";
			meanings = new ArrayList <String>();
			meanings.add("old Greek");
			theWords.put(key, meanings);
			
			key = "spatula";
			meanings = new ArrayList <String>();
			meanings.add("kitchen equipment");
			theWords.put(key, meanings);
			
			key = "speak";
			meanings = new ArrayList <String>();
			meanings.add("say");
			theWords.put(key, meanings);
			
			key = "spear";
			meanings = new ArrayList <String>();
			meanings.add("long stick with a sharp tip");
			meanings.add("long thin strip");
			meanings.add("sharp tool");
			theWords.put(key, meanings);

			key = "spearhead";
			meanings = new ArrayList <String>();
			meanings.add("lead an attack");
			meanings.add("sharp end of tool");
			theWords.put(key, meanings);
			
			key = "specimen";
			meanings = new ArrayList <String>();
			meanings.add("example");
			theWords.put(key, meanings);
			
			key = "spectacles";
			meanings = new ArrayList <String>();
			meanings.add("glasses");
			theWords.put(key, meanings);
			
			key = "spectra";
			meanings = new ArrayList <String>();
			meanings.add("colour ranges");
			theWords.put(key, meanings);
			
			key = "speed";
			meanings = new ArrayList <String>();
			meanings.add("pace");
			theWords.put(key, meanings);
			
			key = "spend";
			meanings = new ArrayList <String>();
			meanings.add("occupy");
			theWords.put(key, meanings);
			
			key = "spent";
			meanings = new ArrayList <String>();
			meanings.add("exhausted");
			theWords.put(key, meanings);
			
			key = "spider";
			meanings = new ArrayList <String>();
			meanings.add("little crawler");
			theWords.put(key, meanings);
			
			key = "spigot";
			meanings = new ArrayList <String>();
			meanings.add("cask peg");
			theWords.put(key, meanings);
			
			key = "spin";
			meanings = new ArrayList <String>();
			meanings.add("rotate");
			meanings.add("turn");
			theWords.put(key, meanings);
					
			key = "spinach";
			meanings = new ArrayList <String>();
			meanings.add("green");
			theWords.put(key, meanings);
			
			key = "spire";
			meanings = new ArrayList <String>();
			meanings.add("part of church");
			meanings.add("steeple");
			theWords.put(key, meanings);
			
			key = "spite";
			meanings = new ArrayList <String>();
			meanings.add("hurt");
			meanings.add("malice");
			theWords.put(key, meanings);
			
			key = "splatter";
			meanings = new ArrayList <String>();
			meanings.add("messily daub");
			theWords.put(key, meanings);
			
			key = "split";
			meanings = new ArrayList <String>();
			meanings.add("Adriatic port");
			meanings.add("leave");
			theWords.put(key, meanings);
			
			key = "spoon";
			meanings = new ArrayList <String>();
			meanings.add("utensil");
			theWords.put(key, meanings);
			
			key = "spoons";
			meanings = new ArrayList <String>();
			meanings.add("items in canteen");
			meanings.add("utensils");
			theWords.put(key, meanings);
			
			key = "spot";
			meanings = new ArrayList <String>();
			meanings.add("notice");
			theWords.put(key, meanings);
			
			key = "spots";
			meanings = new ArrayList <String>();
			meanings.add("defects");
			meanings.add("notices");
			theWords.put(key, meanings);
			
			key = "sportive";
			meanings = new ArrayList <String>();
			meanings.add("playful");
			theWords.put(key, meanings);
					
			key = "spray";
			meanings = new ArrayList <String>();
			meanings.add("jet");
			meanings.add("shower");
			theWords.put(key, meanings);
			
			key = "spread";
			meanings = new ArrayList <String>();
			meanings.add("reach");
			theWords.put(key, meanings);
			
			key = "spree";
			meanings = new ArrayList <String>();
			meanings.add("shopping trip");
			theWords.put(key, meanings);
			
			key = "spring";
			meanings = new ArrayList <String>();
			meanings.add("before summer");
			meanings.add("source of water");
			theWords.put(key, meanings);
					
			key = "springy";
			meanings = new ArrayList <String>();
			meanings.add("elastic");
			theWords.put(key, meanings);
			
			key = "sprint";
			meanings = new ArrayList <String>();
			meanings.add("run");
			theWords.put(key, meanings);
			
			key = "sprite";
			meanings = new ArrayList <String>();
			meanings.add("elf");
			meanings.add("fairy");
			meanings.add("hobgoblin");
			theWords.put(key, meanings);
			
			key = "sprites";
			meanings = new ArrayList <String>();
			meanings.add("spirits");
			meanings.add("elves");
			meanings.add("hobgoblins");
			meanings.add("computer graphics maybe?");
			theWords.put(key, meanings);
			
			key = "sprout";
			meanings = new ArrayList <String>();
			meanings.add("produce new leaves");
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "spud";
			meanings = new ArrayList <String>();
			meanings.add("potato");
			theWords.put(key, meanings);
			
			key = "spy";
			meanings = new ArrayList <String>();
			meanings.add("agent");
			meanings.add("see");
			theWords.put(key, meanings);
			
			key = "squatter";
			meanings = new ArrayList <String>();
			meanings.add("unlawful occupant");
			theWords.put(key, meanings);
			
			key = "stab";
			meanings = new ArrayList <String>();
			meanings.add("attempt");
			theWords.put(key, meanings);
			
			key = "stabiliser";
			meanings = new ArrayList <String>();
			meanings.add("food additive");
			theWords.put(key, meanings);
			
			key = "stable";
			meanings = new ArrayList <String>();
			meanings.add("farm building");
			meanings.add("place for horses");
			meanings.add("steady");
			meanings.add("with no wobble");
			theWords.put(key, meanings);
			
			key = "stabling";
			meanings = new ArrayList <String>();
			meanings.add("accommodation for horses");
			theWords.put(key, meanings);
			
			key = "stack";
			meanings = new ArrayList <String>();
			meanings.add("tall chimney");
			theWords.put(key, meanings);
			
			key = "stacks";
			meanings = new ArrayList <String>();
			meanings.add("heaps");
			theWords.put(key, meanings);
					
			key = "staff";
			meanings = new ArrayList <String>();
			meanings.add("employees");
			theWords.put(key, meanings);
			
			key = "staffa";
			meanings = new ArrayList <String>();
			meanings.add("Scottish island");
			theWords.put(key, meanings);
					
			key = "stag";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("deer");
			theWords.put(key, meanings);
			
			key = "stage";
			meanings = new ArrayList <String>();
			meanings.add("leg");
			theWords.put(key, meanings);
			
			key = "stains";
			meanings = new ArrayList <String>();
			meanings.add("spots");
			theWords.put(key, meanings);
			
			key = "stairwell";
			meanings = new ArrayList <String>();
			meanings.add("vertical space for building");
			theWords.put(key, meanings);
			
			key = "stale";
			meanings = new ArrayList <String>();
			meanings.add("hackneyed");
			meanings.add("jaded");
			meanings.add("old");
			theWords.put(key, meanings);
			
			key = "stalemate";
			meanings = new ArrayList <String>();
			meanings.add("draw");
			theWords.put(key, meanings);
			
			key = "stamen";
			meanings = new ArrayList <String>();
			meanings.add("part of a flower");
			theWords.put(key, meanings);
			
			key = "stamped";
			meanings = new ArrayList <String>();
			meanings.add("trod on");
			theWords.put(key, meanings);
			
			key = "stampede";
			meanings = new ArrayList <String>();
			meanings.add("mad rush");
			theWords.put(key, meanings);
			
			key = "stan";
			meanings = new ArrayList <String>();
			meanings.add("Ollie's pal");
			theWords.put(key, meanings);
			
			key = "stand";
			meanings = new ArrayList <String>();
			meanings.add("bear");
			meanings.add("leave your seat");
			theWords.put(key, meanings);
			
			key = "stank";
			meanings = new ArrayList <String>();
			meanings.add("drain");
			theWords.put(key, meanings);
			
			key = "star";
			meanings = new ArrayList <String>();
			meanings.add("celebrity");
			meanings.add("sun");
			theWords.put(key, meanings);
			
			key = "starch";
			meanings = new ArrayList <String>();
			meanings.add("stiffener");
			theWords.put(key, meanings);
			
			key = "stare";
			meanings = new ArrayList <String>();
			meanings.add("ogle");
			theWords.put(key, meanings);
			
			key = "starers";
			meanings = new ArrayList <String>();
			meanings.add("gazers");
			theWords.put(key, meanings);
			
			key = "staring";
			meanings = new ArrayList <String>();
			meanings.add("gaping");
			meanings.add("gazing");
			meanings.add("ogling");
			theWords.put(key, meanings);
			
			key = "starkers";
			meanings = new ArrayList <String>();
			meanings.add("naked");
			theWords.put(key, meanings);
			
			key = "starling";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "start";
			meanings = new ArrayList <String>();
			meanings.add("begin");
			meanings.add("beginning");
			meanings.add("commence");
			theWords.put(key, meanings);
			
			key = "startling";
			meanings = new ArrayList <String>();
			meanings.add("surprising");
			theWords.put(key, meanings);
			
			key = "starved";
			meanings = new ArrayList <String>();
			meanings.add("went hungry");
			theWords.put(key, meanings);
			
			key = "state";
			meanings = new ArrayList <String>();
			meanings.add("say");
			theWords.put(key, meanings);
			
			key = "static";
			meanings = new ArrayList <String>();
			meanings.add("still");
			theWords.put(key, meanings);
			
			key = "station";
			meanings = new ArrayList <String>();
			meanings.add("position");
			theWords.put(key, meanings);
			
			key = "stay";
			meanings = new ArrayList <String>();
			meanings.add("remain");
			meanings.add("support");
			theWords.put(key, meanings);
			
			key = "steadier";
			meanings = new ArrayList <String>();
			meanings.add("more secure");
			theWords.put(key, meanings);
			
			key = "steak";
			meanings = new ArrayList <String>();
			meanings.add("cut of beef");
			meanings.add("piece of meat");
			theWords.put(key, meanings);
			
			key = "steal";
			meanings = new ArrayList <String>();
			meanings.add("nick");
			theWords.put(key, meanings);
			
			key = "stealing";
			meanings = new ArrayList <String>();
			meanings.add("illegally taking");
			meanings.add("nicking");
			theWords.put(key, meanings);
			
			key = "steam";
			meanings = new ArrayList <String>();
			meanings.add("old engine driver");
			meanings.add("one way to cook");
			meanings.add("vapour");
			theWords.put(key, meanings);
			
			key = "steaming";
			meanings = new ArrayList <String>();
			meanings.add("cooking");
			theWords.put(key, meanings);
			
			key = "steed";
			meanings = new ArrayList <String>();
			meanings.add("horse");
			theWords.put(key, meanings);
			
			key = "steel";
			meanings = new ArrayList <String>();
			meanings.add("metal");
			theWords.put(key, meanings);
			
			key = "steely";
			meanings = new ArrayList <String>();
			meanings.add("tough");
			theWords.put(key, meanings);
			
			key = "step";
			meanings = new ArrayList <String>();
			meanings.add("pace");
			theWords.put(key, meanings);
			
			key = "steerage";
			meanings = new ArrayList <String>();
			meanings.add("accommodation aboard ship");
			theWords.put(key, meanings);
			
			key = "sterile";
			meanings = new ArrayList <String>();
			meanings.add("lacking vitality");
			theWords.put(key, meanings);
			
			key = "sterling";
			meanings = new ArrayList <String>();
			meanings.add("currency");
			theWords.put(key, meanings);
			
			key = "stern";
			meanings = new ArrayList <String>();
			meanings.add("rear of ship");
			meanings.add("rigid");
			meanings.add("serious");
			meanings.add("violinist");//Isaac Stern, Soviet-born violinist
			theWords.put(key, meanings);
			
			key = "sternum";
			meanings = new ArrayList <String>();
			meanings.add("bone");
			meanings.add("part of a skeleton");
			theWords.put(key, meanings);
			
			key = "stereo";
			meanings = new ArrayList <String>();
			meanings.add("music system");
			theWords.put(key, meanings);
			
			key = "stetson";
			meanings = new ArrayList <String>();
			meanings.add("cowboy hat");
			theWords.put(key, meanings);
			
			key = "stew";
			meanings = new ArrayList <String>();
			meanings.add("casserole");
			theWords.put(key, meanings);
			
			key = "stewards";
			meanings = new ArrayList <String>();
			meanings.add("race officials");
			theWords.put(key, meanings);
					
			key = "stiff";
			meanings = new ArrayList <String>();
			meanings.add("rigid");
			theWords.put(key, meanings);
			
			key = "stigma";
			meanings = new ArrayList <String>();
			meanings.add("shame");
			theWords.put(key, meanings);
			
			key = "still";
			meanings = new ArrayList <String>();
			meanings.add("unmoving");
			theWords.put(key, meanings);
			
			key = "stilton";
			meanings = new ArrayList <String>();
			meanings.add("cheese");
			theWords.put(key, meanings);
			
			key = "stilts";
			meanings = new ArrayList <String>();
			meanings.add("circus props");
			theWords.put(key, meanings);
			
			key = "stinker";
			meanings = new ArrayList <String>();
			meanings.add("smelly person");
			theWords.put(key, meanings);
			
			key = "stipend";
			meanings = new ArrayList <String>();
			meanings.add("salary");
			theWords.put(key, meanings);
			
			key = "stipple";
			meanings = new ArrayList <String>();
			meanings.add("cover with dots");
			theWords.put(key, meanings);
			
			key = "stir";
			meanings = new ArrayList <String>();
			meanings.add("commotion");
			meanings.add("prison");
			theWords.put(key, meanings);
			
			key = "stirring";
			meanings = new ArrayList <String>();
			meanings.add("causing upset");
			theWords.put(key, meanings);
			
			key = "stockings";
			meanings = new ArrayList <String>();
			meanings.add("hose");
			theWords.put(key, meanings);
			
			key = "stole";
			meanings = new ArrayList <String>();
			meanings.add("thieved");
			theWords.put(key, meanings);
			
			key = "stop";
			meanings = new ArrayList <String>();
			meanings.add("end");
			theWords.put(key, meanings);
			
			key = "stops";
			meanings = new ArrayList <String>();
			meanings.add("prevents");
			theWords.put(key, meanings);
			
			key = "stories";
			meanings = new ArrayList <String>();
			meanings.add("accounts");
			theWords.put(key, meanings);
			
			key = "story";
			meanings = new ArrayList <String>();
			meanings.add("fable");
			meanings.add("tale");
			theWords.put(key, meanings);
			
			key = "strain";
			meanings = new ArrayList <String>();
			meanings.add("force");
			meanings.add("remove solids");
			theWords.put(key, meanings);
					
			key = "straitlaced"; //strait laced
			meanings = new ArrayList <String>();
			meanings.add("prim");
			theWords.put(key, meanings);
			
			key = "strange";
			meanings = new ArrayList <String>();
			meanings.add("alien");
			meanings.add("odd");
			meanings.add("unusual");
			theWords.put(key, meanings);
			
			key = "stranger";
			meanings = new ArrayList <String>();
			meanings.add("one unfamiliar with the area?");
			meanings.add("unknown person");
			theWords.put(key, meanings);
			
			key = "strangle";
			meanings = new ArrayList <String>();
			meanings.add("throttle");
			theWords.put(key, meanings);
			
			key = "strangler";
			meanings = new ArrayList <String>();
			meanings.add("killer");
			theWords.put(key, meanings);
			
			key = "straw";
			meanings = new ArrayList <String>();
			meanings.add("dried corn stalks");
			theWords.put(key, meanings);
			
			key = "stream";
			meanings = new ArrayList <String>();
			meanings.add("brook");
			theWords.put(key, meanings);
			
			key = "street";
			meanings = new ArrayList <String>();
			meanings.add("way");
			theWords.put(key, meanings);
			
			key = "stress";
			meanings = new ArrayList <String>();
			meanings.add("strain");
			theWords.put(key, meanings);
			
			key = "stretches";
			meanings = new ArrayList <String>();
			meanings.add("extends");
			meanings.add("prison sentences");
			theWords.put(key, meanings);
					
			key = "stretchy";
			meanings = new ArrayList <String>();
			meanings.add("rubbery");
			theWords.put(key, meanings);
			
			key = "strict";
			meanings = new ArrayList <String>();
			meanings.add("stern");
			theWords.put(key, meanings);
			
			key = "strife";
			meanings = new ArrayList <String>();
			meanings.add("conflict");
			theWords.put(key, meanings);
			
			key = "strip";
			meanings = new ArrayList <String>();
			meanings.add("take off");
			meanings.add("teams clothing");
			theWords.put(key, meanings);
			
			key = "stripe";
			meanings = new ArrayList <String>();
			meanings.add("band");
			theWords.put(key, meanings);
			
			key = "stripes";
			meanings = new ArrayList <String>();
			meanings.add("patterns");
			meanings.add("military badges");
			theWords.put(key, meanings);
			
			key = "strobe";
			meanings = new ArrayList <String>();
			meanings.add("bright light");
			theWords.put(key, meanings);
			
			key = "strode";
			meanings = new ArrayList <String>();
			meanings.add("took large step");
			theWords.put(key, meanings);
			
			key = "stroll";
			meanings = new ArrayList <String>();
			meanings.add("gentle walk");
			meanings.add("saunter");
			theWords.put(key, meanings);
			
			key = "strong";
			meanings = new ArrayList <String>();
			meanings.add("powerfull");
			theWords.put(key, meanings);
			
			key = "stud";
			meanings = new ArrayList <String>();
			meanings.add("breeding farm");
			meanings.add("hunk");
			theWords.put(key, meanings);
			
			key = "studious";
			meanings = new ArrayList <String>();
			meanings.add("bookish");
			theWords.put(key, meanings);
			
			key = "study";
			meanings = new ArrayList <String>();
			meanings.add("room");
			theWords.put(key, meanings);
			
			key = "sturdy";
			meanings = new ArrayList <String>();
			meanings.add("robust");
			theWords.put(key, meanings);
			
			key = "sty";
			meanings = new ArrayList <String>();
			meanings.add("enclosure");
			meanings.add("farmyard feature");
			meanings.add("pen");
			theWords.put(key, meanings);
			
			key = "stye";
			meanings = new ArrayList <String>();
			meanings.add("eye disorder");
			meanings.add("eyesore");
			meanings.add("infection");
			theWords.put(key, meanings);
			
			key = "styx";
			meanings = new ArrayList <String>();
			meanings.add("river in Hades");
			theWords.put(key, meanings);
			
			key = "suckle";
			meanings = new ArrayList <String>();
			meanings.add("feed");
			theWords.put(key, meanings);
			
			key = "sudanese";
			meanings = new ArrayList <String>();
			meanings.add("Africans");
			theWords.put(key, meanings);
			
			key = "sue";
			meanings = new ArrayList <String>();
			meanings.add("take legal action");
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "sues";
			meanings = new ArrayList <String>();
			meanings.add("takes legal action");
			theWords.put(key, meanings);
			
			key = "suet";
			meanings = new ArrayList <String>();
			meanings.add("fat");
			theWords.put(key, meanings);
			
			key = "suez";
			meanings = new ArrayList <String>();
			meanings.add("canal");
			theWords.put(key, meanings);
			
			key = "sum";
			meanings = new ArrayList <String>();
			meanings.add("amount");
			meanings.add("problem");
			meanings.add("total");
			theWords.put(key, meanings);
			
			key = "sumo";
			meanings = new ArrayList <String>();
			meanings.add("Japanese wrestling");
			theWords.put(key, meanings);
			
			key = "sun";
			meanings = new ArrayList <String>();
			meanings.add("star");
			theWords.put(key, meanings);
			
			key = "sunrise";
			meanings = new ArrayList <String>();
			meanings.add("break of day");
			theWords.put(key, meanings);
			
			key = "sup";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "super";
			meanings = new ArrayList <String>();
			meanings.add("brilliant");
			meanings.add("fantastic");
			meanings.add("great");
			theWords.put(key, meanings);
			
			key = "superb";
			meanings = new ArrayList <String>();
			meanings.add("fantastic");
			theWords.put(key, meanings);
			
			key = "supermarket";
			meanings = new ArrayList <String>();
			meanings.add("store");
			theWords.put(key, meanings);
			
			key = "supervisor";
			meanings = new ArrayList <String>();
			meanings.add("controller");
			theWords.put(key, meanings);
			
			key = "supper";
			meanings = new ArrayList <String>();
			meanings.add("meal");
			theWords.put(key, meanings);
			
			key = "support";
			meanings = new ArrayList <String>();
			meanings.add("encourage");
			theWords.put(key, meanings);
			
			key = "support";
			meanings = new ArrayList <String>();
			meanings.add("encourage");
			theWords.put(key, meanings);
			
			key = "sure";
			meanings = new ArrayList <String>();
			meanings.add("certain");
			theWords.put(key, meanings);
			
			key = "surer";
			meanings = new ArrayList <String>();
			meanings.add("more confident");
			theWords.put(key, meanings);
			
			key = "sushi";
			meanings = new ArrayList <String>();
			meanings.add("Japanese dish");
			theWords.put(key, meanings);
			
			key = "sustains";
			meanings = new ArrayList <String>();
			meanings.add("bears");
			theWords.put(key, meanings);
			
			key = "swaddle";
			meanings = new ArrayList <String>();
			meanings.add("wrap up");
			theWords.put(key, meanings);
			
			key = "swagger";
			meanings = new ArrayList <String>();
			meanings.add("walk in a cocky manner");
			theWords.put(key, meanings);
			
			key = "swallow";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			meanings.add("consume");
			theWords.put(key, meanings);
			
			key = "swam";
			meanings = new ArrayList <String>();
			meanings.add("moved through water");
			theWords.put(key, meanings);
			
			key = "swamp";
			meanings = new ArrayList <String>();
			meanings.add("marsh");
			theWords.put(key, meanings);
			
			key = "swede";
			meanings = new ArrayList <String>();
			meanings.add("european");
			meanings.add("vegetable");
			theWords.put(key, meanings);
			
			key = "sweetheart";
			meanings = new ArrayList <String>();
			meanings.add("loved one");
			theWords.put(key, meanings);
					
			key = "sweetmeat";
			meanings = new ArrayList <String>();
			meanings.add("sugar coated goody");
			theWords.put(key, meanings);
			
			key = "swell";
			meanings = new ArrayList <String>();
			meanings.add("expand");
			meanings.add("fine");
			theWords.put(key, meanings);
					
			key = "swine";
			meanings = new ArrayList <String>();
			meanings.add("rotter");
			theWords.put(key, meanings);
			
			key = "swing";
			meanings = new ArrayList <String>();
			meanings.add("move from side to side");
			theWords.put(key, meanings);
			
			key = "switch";
			meanings = new ArrayList <String>();
			meanings.add("change");
			theWords.put(key, meanings);

			return theWords;
		}//end loadSWords
		
		public TreeMap<String, ArrayList<String>> loadTWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load t's
			
			key = "ta";
			meanings = new ArrayList <String>();
			meanings.add("brief thanks");
			meanings.add("thanks");
			meanings.add("thank you");
			theWords.put(key, meanings);
			
			key = "table";
			meanings = new ArrayList <String>();
			meanings.add("present formally");
			theWords.put(key, meanings);
			
			key = "tables";
			meanings = new ArrayList <String>();
			meanings.add("presents formally");
			theWords.put(key, meanings);
			
			key = "tablet";
			meanings = new ArrayList <String>();
			meanings.add("small computer");
			meanings.add("pill");
			theWords.put(key, meanings);
			
			key = "taboo";
			meanings = new ArrayList <String>();
			meanings.add("forbidden");
			theWords.put(key, meanings);
					
			key = "tack";
			meanings = new ArrayList <String>();
			meanings.add("nail");
			theWords.put(key, meanings);
			
			key = "tackle";
			meanings = new ArrayList <String>();
			meanings.add("equipment");
			meanings.add("get to grips with");
			theWords.put(key, meanings);
			
			key = "tackled";
			meanings = new ArrayList <String>();
			meanings.add("had a go at");
			theWords.put(key, meanings);
			
			key = "taffeta";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "tagged";
			meanings = new ArrayList <String>();
			meanings.add("added on");
			meanings.add("labelled");
			theWords.put(key, meanings);
			
			key = "tail";
			meanings = new ArrayList <String>();
			meanings.add("follow");
			theWords.put(key, meanings);
							
			key = "tailor";
			meanings = new ArrayList <String>();
			meanings.add("outfitter");
			meanings.add("customise");
			theWords.put(key, meanings);
			
			key = "tailspin";
			meanings = new ArrayList <String>();
			meanings.add("out of control");
			theWords.put(key, meanings);
			
			key = "tain";
			meanings = new ArrayList <String>();
			meanings.add("tinfoil");
			theWords.put(key, meanings);
			
			key = "take";
			meanings = new ArrayList <String>();
			meanings.add("confiscate");
			theWords.put(key, meanings);
			
			key = "talc";
			meanings = new ArrayList <String>();
			meanings.add("perfumed powder");
			meanings.add("powder");
			theWords.put(key, meanings);
			
			key = "tale";
			meanings = new ArrayList <String>();
			meanings.add("story");
			theWords.put(key, meanings);
			
			key = "talents";
			meanings = new ArrayList <String>();
			meanings.add("aptitudes");
			meanings.add("gifts");
			theWords.put(key, meanings);
			
			key = "tales";
			meanings = new ArrayList <String>();
			meanings.add("stories");
			theWords.put(key, meanings);
			
			key = "talks";
			meanings = new ArrayList <String>();
			meanings.add("chats");
			theWords.put(key, meanings);
			
			key = "tame";
			meanings = new ArrayList <String>();
			meanings.add("boring");
			meanings.add("domesticated");
			theWords.put(key, meanings);
			
			key = "tan";
			meanings = new ArrayList <String>();
			meanings.add("bronze");
			meanings.add("tawny");
			meanings.add("turn brown");
			meanings.add("yellowish-brown colour");
			theWords.put(key, meanings);
			
			key = "tans";
			meanings = new ArrayList <String>();
			meanings.add("browns");
			theWords.put(key, meanings);
			
			key = "tank";
			meanings = new ArrayList <String>();
			meanings.add("container");
			meanings.add("large receptacle");
			meanings.add("armoured vehicle");
			theWords.put(key, meanings);
			
			key = "tang";
			meanings = new ArrayList <String>();
			meanings.add("strong tast");
			theWords.put(key, meanings);
			
			key = "tangerine";
			meanings = new ArrayList <String>();
			meanings.add("fruit");
			theWords.put(key, meanings);
			
			key = "tangible";
			meanings = new ArrayList <String>();
			meanings.add("can be touched");
			theWords.put(key, meanings);
			
			key = "tangle";
			meanings = new ArrayList <String>();
			meanings.add("become involved with");
			meanings.add("confusion");
			theWords.put(key, meanings);
			
			key = "tap";
			meanings = new ArrayList <String>();
			meanings.add("bug");
			theWords.put(key, meanings);
			
			key = "tape";
			meanings = new ArrayList <String>();
			meanings.add("record");
			theWords.put(key, meanings);
			
			key = "taper";
			meanings = new ArrayList <String>();
			meanings.add("gradually narrow");
			meanings.add("gradually lessen");
			meanings.add("slender lighter");
			theWords.put(key, meanings);
			
			key = "tapes";
			meanings = new ArrayList <String>();
			meanings.add("records");
			theWords.put(key, meanings);
			
			key = "tapestry";
			meanings = new ArrayList <String>();
			meanings.add("hanging");
			theWords.put(key, meanings);
			
			key = "taproom";
			meanings = new ArrayList <String>();
			meanings.add("bar");
			theWords.put(key, meanings);
			
			key = "tar";
			meanings = new ArrayList <String>();
			meanings.add("dark, thick flammable liquid");
			meanings.add("sailor");
			theWords.put(key, meanings);
			
			key = "tarn";
			meanings = new ArrayList <String>();
			meanings.add("small mountain lake");
			theWords.put(key, meanings);
			
			key = "tarns";
			meanings = new ArrayList <String>();
			meanings.add("small mountain lakes");
			theWords.put(key, meanings);
			
			key = "tarpaulin";
			meanings = new ArrayList <String>();
			meanings.add("cover");
			theWords.put(key, meanings);
			
			key = "tart";
			meanings = new ArrayList <String>();
			meanings.add("pastry");
			theWords.put(key, meanings);
			
			key = "tartar";
			meanings = new ArrayList <String>();
			meanings.add("sauce");
			theWords.put(key, meanings);
			
			key = "tarzan";
			meanings = new ArrayList <String>();
			meanings.add("swinger");
			theWords.put(key, meanings);
			
			key = "taskmaster";
			meanings = new ArrayList <String>();
			meanings.add("boss");
			theWords.put(key, meanings);
			
			key = "taste";
			meanings = new ArrayList <String>();
			meanings.add("sense");
			theWords.put(key, meanings);
			
			key = "tasty";
			meanings = new ArrayList <String>();
			meanings.add("delicious");
			theWords.put(key, meanings);
			
			key = "tat";
			meanings = new ArrayList <String>();
			meanings.add("rubbish");
			meanings.add("shoddy goods");
			theWords.put(key, meanings);
			
			key = "tate";
			meanings = new ArrayList <String>();
			meanings.add("gallery");
			theWords.put(key, meanings);
			
			key = "tattle";
			meanings = new ArrayList <String>();
			meanings.add("mere gossip");
			theWords.put(key, meanings);
			
			key = "taunt";
			meanings = new ArrayList <String>();
			meanings.add("tease");
			theWords.put(key, meanings);
			
			key = "taverns";
			meanings = new ArrayList <String>();
			meanings.add("inns");
			theWords.put(key, meanings);
			
			key = "tax";
			meanings = new ArrayList <String>();
			meanings.add("charge");
			meanings.add("levy");
			theWords.put(key, meanings);
			
			key = "taxi";
			meanings = new ArrayList <String>();
			meanings.add("cab");
			meanings.add("hired vehicle");
			meanings.add("transport");
			theWords.put(key, meanings);
			
			key = "tay";
			meanings = new ArrayList <String>();
			meanings.add("Scottish river");
			theWords.put(key, meanings);
			
			key = "tea";
			meanings = new ArrayList <String>();
			meanings.add("beverage");
			meanings.add("drink");
			meanings.add("early meal");
			meanings.add("hot drink");
			meanings.add("meal");
			theWords.put(key, meanings);
			
			key = "teacher";
			meanings = new ArrayList <String>();
			meanings.add("tutor");
			theWords.put(key, meanings);
			
			key = "teachers";
			meanings = new ArrayList <String>();
			meanings.add("tutors");
			theWords.put(key, meanings);
			
			key = "teak";
			meanings = new ArrayList <String>();
			meanings.add("wood");
			theWords.put(key, meanings);
			
			key = "teal";
			meanings = new ArrayList <String>();
			meanings.add("duck");
			theWords.put(key, meanings);
			
			key = "teapot";
			meanings = new ArrayList <String>();
			meanings.add("vessel");
			theWords.put(key, meanings);
			
			key = "teas";
			meanings = new ArrayList <String>();
			meanings.add("drinks");
			theWords.put(key, meanings);
			
			key = "tease";
			meanings = new ArrayList <String>();
			meanings.add("kid");
			meanings.add("make fun of");
			theWords.put(key, meanings);
			
			key = "teaser";
			meanings = new ArrayList <String>();
			meanings.add("puzzle");
			theWords.put(key, meanings);
					
			key = "team";
			meanings = new ArrayList <String>();
			meanings.add("crew");
			meanings.add("group of players");
			meanings.add("side");
			meanings.add("two or more people working together");
			theWords.put(key, meanings);
			
			key = "tear";
			meanings = new ArrayList <String>();
			meanings.add("pull apart");
			meanings.add("pull to pieces");
			meanings.add("rip");
			meanings.add("make a hole in");
			meanings.add("come apart");
			meanings.add("damage");
			theWords.put(key, meanings);
			
			key = "tearinto"; //tear into
			meanings = new ArrayList <String>();
			meanings.add("attack vigorously");
			theWords.put(key, meanings);
			
			key = "ted"; 
			meanings = new ArrayList <String>();
			meanings.add("Edward");
			theWords.put(key, meanings);
			
			key = "tee";
			meanings = new ArrayList <String>();
			meanings.add("where golf starts");
			meanings.add("warm weather top");
			theWords.put(key, meanings);
					
			key = "teem";
			meanings = new ArrayList <String>();
			meanings.add("abound");
			theWords.put(key, meanings);
			
			key = "teeth";
			meanings = new ArrayList <String>();
			meanings.add("gnashers");
			theWords.put(key, meanings);
			
			key = "tehran";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			theWords.put(key, meanings);
			
			key = "telegram";
			meanings = new ArrayList <String>();
			meanings.add("wire");
			theWords.put(key, meanings);
			
			key = "tell";
			meanings = new ArrayList <String>();
			meanings.add("famous archer");
			meanings.add("narrate");
			meanings.add("report");
			theWords.put(key, meanings);
					
			key = "temp";
			meanings = new ArrayList <String>();
			meanings.add("part-timer");
			theWords.put(key, meanings);
			
			key = "temple";
			meanings = new ArrayList <String>();
			meanings.add("place of worship");
			theWords.put(key, meanings);
			
			key = "tempo";
			meanings = new ArrayList <String>();
			meanings.add("speed");
			theWords.put(key, meanings);
			
			key = "teenager";
			meanings = new ArrayList <String>();
			meanings.add("young person");
			theWords.put(key, meanings);
			
			key = "teens";
			meanings = new ArrayList <String>();
			meanings.add("young people");
			theWords.put(key, meanings);
			
			key = "tees";
			meanings = new ArrayList <String>();
			meanings.add("northern river");
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "ten";
			meanings = new ArrayList <String>();
			meanings.add("number");
			theWords.put(key, meanings);
			
			key = "tench";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "tend";
			meanings = new ArrayList <String>();
			meanings.add("lean");
			meanings.add("nurse");
			theWords.put(key, meanings);
			
			key = "tended";
			meanings = new ArrayList <String>();
			meanings.add("looked after");
			meanings.add("nursed");
			theWords.put(key, meanings);
			
			key = "tender";
			meanings = new ArrayList <String>();
			meanings.add("offer");
			theWords.put(key, meanings);
			
			key = "tendon";
			meanings = new ArrayList <String>();
			meanings.add("sinew");
			theWords.put(key, meanings);
			
			key = "tenor";
			meanings = new ArrayList <String>();
			meanings.add("singer");
			theWords.put(key, meanings);
			
			key = "tenors";
			meanings = new ArrayList <String>();
			meanings.add("singers");
			theWords.put(key, meanings);
			
			key = "tent";
			meanings = new ArrayList <String>();
			meanings.add("portable shelter");
			meanings.add("shelter");
			meanings.add("temporary accommodation");
			theWords.put(key, meanings);
					
			key = "terrain";
			meanings = new ArrayList <String>();
			meanings.add("earth");
			meanings.add("stretch of land");
			theWords.put(key, meanings);
			
			key = "terrapin";
			meanings = new ArrayList <String>();
			meanings.add("reptile");
			meanings.add("turtle");
			theWords.put(key, meanings);
			
			key = "terrier";
			meanings = new ArrayList <String>();
			meanings.add("dog");
			theWords.put(key, meanings);
			
			key = "terrified";
			meanings = new ArrayList <String>();
			meanings.add("very scared");
			theWords.put(key, meanings);

			key = "term";
			meanings = new ArrayList <String>();
			meanings.add("period of time");
			theWords.put(key, meanings);
			
			key = "terminal";
			meanings = new ArrayList <String>();
			meanings.add("end");
			theWords.put(key, meanings);
			
			key = "tern";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			theWords.put(key, meanings);
			
			key = "terror";
			meanings = new ArrayList <String>();
			meanings.add("dread");
			theWords.put(key, meanings);
			
			key = "tess";
			meanings = new ArrayList <String>();
			meanings.add("Hardy heroin");
			theWords.put(key, meanings);
			
			key = "test";
			meanings = new ArrayList <String>();
			meanings.add("cricket match");
			meanings.add("exam");
			meanings.add("examination");
			meanings.add("trial");
			theWords.put(key, meanings);
			
			key = "testament";
			meanings = new ArrayList <String>();
			meanings.add("will");
			meanings.add("dividion of the bible");
			theWords.put(key, meanings);
			
			key = "tester";
			meanings = new ArrayList <String>();
			meanings.add("examiner");
			meanings.add("sample");
			theWords.put(key, meanings);
			
			key = "text";
			meanings = new ArrayList <String>();
			meanings.add("words");
			theWords.put(key, meanings);
			
			key = "thames";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "than";
			meanings = new ArrayList <String>();
			meanings.add("preposition, say");
			theWords.put(key, meanings);
			
			key = "thank";
			meanings = new ArrayList <String>();
			meanings.add("express gratitude");
			theWords.put(key, meanings);
			
			key = "thankyou"; //thank you
			meanings = new ArrayList <String>();
			meanings.add("gratitude");
			theWords.put(key, meanings);
					
			key = "thaw";
			meanings = new ArrayList <String>();
			meanings.add("melt");
			theWords.put(key, meanings);
			
			key = "the";
			meanings = new ArrayList <String>();
			meanings.add("article");
			theWords.put(key, meanings);
			
			key = "theatre";
			meanings = new ArrayList <String>();
			meanings.add("auditorium");
			meanings.add("playhouse");
			theWords.put(key, meanings);
			
			key = "theft";
			meanings = new ArrayList <String>();
			meanings.add("robbery");
			theWords.put(key, meanings);
			
			key = "their";
			meanings = new ArrayList <String>();
			meanings.add("belonging to");
			theWords.put(key, meanings);
			
			key = "theme";
			meanings = new ArrayList <String>();
			meanings.add("subject");
			theWords.put(key, meanings);
			
			key = "there";
			meanings = new ArrayList <String>();
			meanings.add("that place");
			theWords.put(key, meanings);
			
			key = "theresa";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "thermostat";
			meanings = new ArrayList <String>();
			meanings.add("temperature regulator");
			theWords.put(key, meanings);
			
			key = "thesaurus";
			meanings = new ArrayList <String>();
			meanings.add("a type of dictionary");
			theWords.put(key, meanings);
			
			key = "thesis";
			meanings = new ArrayList <String>();
			meanings.add("dissertation");
			theWords.put(key, meanings);
			
			key = "thespian";
			meanings = new ArrayList <String>();
			meanings.add("actor");
			theWords.put(key, meanings);
			
			key = "thief";
			meanings = new ArrayList <String>();
			meanings.add("burglar");
			meanings.add("criminal");
			meanings.add("plagarist");
			meanings.add("robber");
			theWords.put(key, meanings);
			
			key = "thigh";
			meanings = new ArrayList <String>();
			meanings.add("part of leg");
			theWords.put(key, meanings);
			
			key = "thin";
			meanings = new ArrayList <String>();
			meanings.add("like a rake");
			meanings.add("slender");
			theWords.put(key, meanings);
			
			key = "thing";
			meanings = new ArrayList <String>();
			meanings.add("item");
			theWords.put(key, meanings);
					
			key = "think";
			meanings = new ArrayList <String>();
			meanings.add("consider");
			theWords.put(key, meanings);
			
			key = "this";
			meanings = new ArrayList <String>();
			meanings.add("identifier");
			theWords.put(key, meanings);
			
			key = "thistle";
			meanings = new ArrayList <String>();
			meanings.add("Scotland's emblem");
			theWords.put(key, meanings);
					
			key = "thong";
			meanings = new ArrayList <String>();
			meanings.add("leather strap");
			theWords.put(key, meanings);
			
			key = "those";
			meanings = new ArrayList <String>();
			meanings.add("them things");
			theWords.put(key, meanings);
			
			key = "thor";
			meanings = new ArrayList <String>();
			meanings.add("god");
			meanings.add("Norse god");
			theWords.put(key, meanings);
			
			key = "thorny";
			meanings = new ArrayList <String>();
			meanings.add("awkward");
			theWords.put(key, meanings);
			
			key = "though";
			meanings = new ArrayList <String>();
			meanings.add("even");
			meanings.add("nevertheless");
			theWords.put(key, meanings);
			
			key = "thought";
			meanings = new ArrayList <String>();
			meanings.add("deliberation");
			meanings.add("idea");
			theWords.put(key, meanings);
			
			key = "threat";
			meanings = new ArrayList <String>();
			meanings.add("ultimatum");
			theWords.put(key, meanings);
			
			key = "thrill";
			meanings = new ArrayList <String>();
			meanings.add("kick");
			theWords.put(key, meanings);
			
			key = "thrive";
			meanings = new ArrayList <String>();
			meanings.add("do well");
			theWords.put(key, meanings);
			
			key = "throne";
			meanings = new ArrayList <String>();
			meanings.add("ceremonial chair");
			theWords.put(key, meanings);
			
			key = "throng";
			meanings = new ArrayList <String>();
			meanings.add("crowd");
			theWords.put(key, meanings);
			
			key = "throw";
			meanings = new ArrayList <String>();
			meanings.add("cast");
			theWords.put(key, meanings);
			
			key = "thrust";
			meanings = new ArrayList <String>();
			meanings.add("push");
			theWords.put(key, meanings);
					
			key = "thug";
			meanings = new ArrayList <String>();
			meanings.add("bully");
			theWords.put(key, meanings);
			
			key = "thus";
			meanings = new ArrayList <String>();
			meanings.add("like this");
			theWords.put(key, meanings);
					
			key = "thy";
			meanings = new ArrayList <String>();
			meanings.add("your old");
			theWords.put(key, meanings);
			
			key = "tibet";
			meanings = new ArrayList <String>();
			meanings.add("country");
			meanings.add("himalayan ridge");
			theWords.put(key, meanings);
			
			key = "tick";
			meanings = new ArrayList <String>();
			meanings.add("parasite");
			theWords.put(key, meanings);
			
			key = "tickled";
			meanings = new ArrayList <String>();
			meanings.add("amused");
			theWords.put(key, meanings);
			
			key = "tide";
			meanings = new ArrayList <String>();
			meanings.add("sea movement");
			theWords.put(key, meanings);
			
			key = "tidings";
			meanings = new ArrayList <String>();
			meanings.add("news");
			theWords.put(key, meanings);
			
			key = "tidying";
			meanings = new ArrayList <String>();
			meanings.add("cleaning up");
			theWords.put(key, meanings);
			
			key = "tier";
			meanings = new ArrayList <String>();
			meanings.add("part of wedding cake");
			meanings.add("row");
			theWords.put(key, meanings);
			
			key = "tiger";
			meanings = new ArrayList <String>();
			meanings.add("animal");
			meanings.add("big cat");
			theWords.put(key, meanings);
			
			key = "tigers";
			meanings = new ArrayList <String>();
			meanings.add("animals");
			meanings.add("big cats");
			theWords.put(key, meanings);
			
			key = "tight";
			meanings = new ArrayList <String>();
			meanings.add("mean");
			theWords.put(key, meanings);
			
			key = "tighten";
			meanings = new ArrayList <String>();
			meanings.add("narrow");
			meanings.add("secure");
			theWords.put(key, meanings);
			
			key = "tile";
			meanings = new ArrayList <String>();
			meanings.add("roofing item");
			theWords.put(key, meanings);
			
			key = "tilt";
			meanings = new ArrayList <String>();
			meanings.add("lean");
			theWords.put(key, meanings);
			
			key = "tilts";
			meanings = new ArrayList <String>();
			meanings.add("leanings");
			theWords.put(key, meanings);
			
			key = "tiber";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "timber";
			meanings = new ArrayList <String>();
			meanings.add("wood");
			theWords.put(key, meanings);
			
			key = "time";
			meanings = new ArrayList <String>();
			meanings.add("alloted period");
			meanings.add("occasion");
			meanings.add("record");
			meanings.add("interval between two events");
			meanings.add("what landlords call");
			theWords.put(key, meanings);
			
			key = "timer";
			meanings = new ArrayList <String>();
			meanings.add("clock");
			theWords.put(key, meanings);
			
			key = "times";
			meanings = new ArrayList <String>();
			meanings.add("multiply");
			theWords.put(key, meanings);
			
			key = "tin";
			meanings = new ArrayList <String>();
			meanings.add("can");
			meanings.add("metal");
			theWords.put(key, meanings);
			
			key = "tinker";
			meanings = new ArrayList <String>();
			meanings.add("mess about");
			theWords.put(key, meanings);
			
			key = "tinsel";
			meanings = new ArrayList <String>();
			meanings.add("christmas decoration");
			theWords.put(key, meanings);
			
			key = "tiny";
			meanings = new ArrayList <String>();
			meanings.add("very small");
			theWords.put(key, meanings);
			
			key = "tipple";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "tirade";
			meanings = new ArrayList <String>();
			meanings.add("long angry speech");
			theWords.put(key, meanings);

			key = "tire";
			meanings = new ArrayList <String>();
			meanings.add("become weary");
			theWords.put(key, meanings);
			
			key = "tired";
			meanings = new ArrayList <String>();
			meanings.add("worn out");
			theWords.put(key, meanings);
			
			key = "tissue";
			meanings = new ArrayList <String>();
			meanings.add("dsiposable item");
			theWords.put(key, meanings);
			
			key = "tit";
			meanings = new ArrayList <String>();
			meanings.add("bird");
			meanings.add("little bird");
			meanings.add("small bird");
			theWords.put(key, meanings);
			
			key = "titan";
			meanings = new ArrayList <String>();
			meanings.add("enormous man");
			theWords.put(key, meanings);
			
			key = "titbit";
			meanings = new ArrayList <String>();
			meanings.add("morsel");
			theWords.put(key, meanings);
			
			key = "title";
			meanings = new ArrayList <String>();
			meanings.add("name");
			theWords.put(key, meanings);
			
			key = "to";
			meanings = new ArrayList <String>();
			meanings.add("in a direction");
			meanings.add("until");
			theWords.put(key, meanings);
			
			key = "toast";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "tobago";
			meanings = new ArrayList <String>();
			meanings.add("island");
			theWords.put(key, meanings);
			
			key = "toby";
			meanings = new ArrayList <String>();
			meanings.add("man");
			theWords.put(key, meanings);
			
			key = "toe";
			meanings = new ArrayList <String>();
			meanings.add("front of a shoe");
			theWords.put(key, meanings);
			
			key = "toes";
			meanings = new ArrayList <String>();
			meanings.add("digits");
			theWords.put(key, meanings);
			
			key = "toecap";
			meanings = new ArrayList <String>();
			meanings.add("boot protector");
			theWords.put(key, meanings);
			
			key = "toga";
			meanings = new ArrayList <String>();
			meanings.add("Roman costume");
			theWords.put(key, meanings);
			
			key = "toil";
			meanings = new ArrayList <String>();
			meanings.add("work");
			theWords.put(key, meanings);
			
			key = "toiletroll";
			meanings = new ArrayList <String>();
			meanings.add("extensive quantity of paper");
			theWords.put(key, meanings);
			
			key = "tolerance";
			meanings = new ArrayList <String>();
			meanings.add("ability to endure");
			theWords.put(key, meanings);
			
			key = "tolerate";
			meanings = new ArrayList <String>();
			meanings.add("bear");
			theWords.put(key, meanings);
			
			key = "toll";
			meanings = new ArrayList <String>();
			meanings.add("charge");
			meanings.add("payment");
			theWords.put(key, meanings);
			
			key = "tom";
			meanings = new ArrayList <String>();
			meanings.add("boy");
			meanings.add("cat");
			theWords.put(key, meanings);
			
			key = "ton";
			meanings = new ArrayList <String>();
			meanings.add("heavyweight");
			meanings.add("weight");
			theWords.put(key, meanings);
			
			key = "tonga";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "tonight";
			meanings = new ArrayList <String>();
			meanings.add("this evening");
			theWords.put(key, meanings);
			
			key = "too";
			meanings = new ArrayList <String>();
			meanings.add("overly");
			theWords.put(key, meanings);
					
			key = "toomuch"; // too much
			meanings = new ArrayList <String>();
			meanings.add("over the top");
			theWords.put(key, meanings);
			
			key = "top";
			meanings = new ArrayList <String>();
			meanings.add("summit");
			theWords.put(key, meanings);
			
			key = "topside";
			meanings = new ArrayList <String>();
			meanings.add("cut of beef");
			theWords.put(key, meanings);
			
			key = "tor";
			meanings = new ArrayList <String>();
			meanings.add("hill");
			meanings.add("mountain");
			theWords.put(key, meanings);
			
			key = "torch";
			meanings = new ArrayList <String>();
			meanings.add("light");
			theWords.put(key, meanings);
			
			key = "tore";
			meanings = new ArrayList <String>();
			meanings.add("ripped");
			theWords.put(key, meanings);
			
			key = "tories";
			meanings = new ArrayList <String>();
			meanings.add("politicians");
			theWords.put(key, meanings);
			
			
			key = "tornado";
			meanings = new ArrayList <String>();
			meanings.add("storm");
			theWords.put(key, meanings);
			
			key = "torrent";
			meanings = new ArrayList <String>();
			meanings.add("rushing stream");
			theWords.put(key, meanings);
			
			key = "tortilla";
			meanings = new ArrayList <String>();
			meanings.add("Mexican dish");
			theWords.put(key, meanings);
			
			key = "torso";
			meanings = new ArrayList <String>();
			meanings.add("trunk");
			theWords.put(key, meanings);
			
			key = "tory";
			meanings = new ArrayList <String>();
			meanings.add("conservative");
			meanings.add("politician");
			theWords.put(key, meanings);
			
			key = "tosca";
			meanings = new ArrayList <String>();
			meanings.add("one of Puccini's operas");
			theWords.put(key, meanings);
			
			key = "toss";
			meanings = new ArrayList <String>();
			meanings.add("flip a coin");
			theWords.put(key, meanings);
			
			key = "tot";
			meanings = new ArrayList <String>();
			meanings.add("child");
			meanings.add("drink");
			meanings.add("little drink");
			meanings.add("small child");
			meanings.add("small drink");
			theWords.put(key, meanings);
			
			key = "total";
			meanings = new ArrayList <String>();
			meanings.add("whole");
			theWords.put(key, meanings);
			
			key = "totally";
			meanings = new ArrayList <String>();
			meanings.add("without reservation");
			theWords.put(key, meanings);
			
			key = "toted";
			meanings = new ArrayList <String>();
			meanings.add("carried");
			theWords.put(key, meanings);
			
			key = "totter";
			meanings = new ArrayList <String>();
			meanings.add("rock");
			theWords.put(key, meanings);
			
			key = "touch";
			meanings = new ArrayList <String>();
			meanings.add("adjoin");
			meanings.add("nudge");
			meanings.add("poke");
			meanings.add("press");
			meanings.add("prod");
			meanings.add("tap");
			theWords.put(key, meanings);
			
			key = "tour";
			meanings = new ArrayList <String>();
			meanings.add("bike race");
			meanings.add("excursion");
			meanings.add("trip");
			theWords.put(key, meanings);
			
			key = "tourism";
			meanings = new ArrayList <String>();
			meanings.add("traveling for recreation");
			theWords.put(key, meanings);
			
			key = "tournament";
			meanings = new ArrayList <String>();
			meanings.add("competition");
			theWords.put(key, meanings);
			
			key = "tower";
			meanings = new ArrayList <String>();
			meanings.add("tall building");
			theWords.put(key, meanings);
			
			key = "toy";
			meanings = new ArrayList <String>();
			meanings.add("plaything");
			theWords.put(key, meanings);
			
			key = "trace";
			meanings = new ArrayList <String>();
			meanings.add("find");
			theWords.put(key, meanings);
			
			key = "traceable";
			meanings = new ArrayList <String>();
			meanings.add("can be found");
			theWords.put(key, meanings);
			
			key = "tract";
			meanings = new ArrayList <String>();
			meanings.add("pamphlet");
			theWords.put(key, meanings);
			
			key = "tractor";
			meanings = new ArrayList <String>();
			meanings.add("farm vehicle");
			theWords.put(key, meanings);
			
			
			key = "trade";
			meanings = new ArrayList <String>();
			meanings.add("deal");
			theWords.put(key, meanings);
			
			key = "trader";
			meanings = new ArrayList <String>();
			meanings.add("vendor");
			theWords.put(key, meanings);
			
			key = "traders";
			meanings = new ArrayList <String>();
			meanings.add("vendors");
			theWords.put(key, meanings);
			
			key = "trail";
			meanings = new ArrayList <String>();
			meanings.add("sequence");
			theWords.put(key, meanings);
					
			key = "train";
			meanings = new ArrayList <String>();
			meanings.add("means of transport");
			meanings.add("part of a dress");
			meanings.add("an orderly succession of related events");
			meanings.add("coach");
			meanings.add("prepare physically");
			meanings.add("focus");
			meanings.add("aim");
			theWords.put(key, meanings);
					
			key = "trainee";
			meanings = new ArrayList <String>();
			meanings.add("apprentice");
			meanings.add("new recruit");
			theWords.put(key, meanings);
			
			key = "trainees";
			meanings = new ArrayList <String>();
			meanings.add("new recruits");
			theWords.put(key, meanings);
			
			key = "trains";
			meanings = new ArrayList <String>();
			meanings.add("coaches");
			meanings.add("prepares physically");
			meanings.add("aims");
			theWords.put(key, meanings);
			
			key = "trained";
			meanings = new ArrayList <String>();
			meanings.add("prepared for physically");
			theWords.put(key, meanings);
			
			key = "trainer";
			meanings = new ArrayList <String>();
			meanings.add("coach");
			meanings.add("sports shoe");
			theWords.put(key, meanings);
			
			key = "tram";
			meanings = new ArrayList <String>();
			meanings.add("form of transport");
			meanings.add("transport");
			meanings.add("vehicle");
			theWords.put(key, meanings);
			
			key = "tramline";
			meanings = new ArrayList <String>();
			meanings.add("inflexible principle");
			theWords.put(key, meanings);
			
			key = "tramp";
			meanings = new ArrayList <String>();
			meanings.add("hobo");
			meanings.add("long walk");
			meanings.add("vagrant");
			meanings.add("walk heavily");
			theWords.put(key, meanings);
			
			key = "trance";
			meanings = new ArrayList <String>();
			meanings.add("dream");
			theWords.put(key, meanings);
			
			key = "transitory";
			meanings = new ArrayList <String>();
			meanings.add("passing");
			theWords.put(key, meanings);
			
			key = "translate";
			meanings = new ArrayList <String>();
			meanings.add("change position of");
			meanings.add("convert");
			meanings.add("decipher");
			meanings.add("interpret");
			//meanings.add("render");
			theWords.put(key, meanings);
			
			key = "traps";
			meanings = new ArrayList <String>();
			meanings.add("catches");
			theWords.put(key, meanings);
			
			key = "trashy";
			meanings = new ArrayList <String>();
			meanings.add("poor quality");
			meanings.add("worthless");
			theWords.put(key, meanings);
			
			key = "travel";
			meanings = new ArrayList <String>();
			meanings.add("journey");
			meanings.add("make a journey");
			theWords.put(key, meanings);
			
			key = "trawler";
			meanings = new ArrayList <String>();
			meanings.add("fishing boat");
			theWords.put(key, meanings);
			
			key = "tray";
			meanings = new ArrayList <String>();
			meanings.add("carrier");
			theWords.put(key, meanings);
					
			key = "tread";
			meanings = new ArrayList <String>();
			meanings.add("plod");
			theWords.put(key, meanings);
			
			key = "treadle";
			meanings = new ArrayList <String>();
			meanings.add("peddle");
			theWords.put(key, meanings);
			
			key = "treadmill";
			meanings = new ArrayList <String>();
			meanings.add("dreary routine");
			theWords.put(key, meanings);
			
			key = "treason";
			meanings = new ArrayList <String>();
			meanings.add("crime");
			meanings.add("disloyalty");
			theWords.put(key, meanings);
			
			key = "treasured";
			meanings = new ArrayList <String>();
			meanings.add("cherished");
			theWords.put(key, meanings);
			
			key = "treatment";
			meanings = new ArrayList <String>();
			meanings.add("handling");
			meanings.add("medicine");
			theWords.put(key, meanings);
			
			key = "tree";
			meanings = new ArrayList <String>();
			meanings.add("palm");
			meanings.add("plant");
			theWords.put(key, meanings);
			
			key = "trees";
			meanings = new ArrayList <String>();
			meanings.add("plants");
			theWords.put(key, meanings);
			
			key = "trefoil";
			meanings = new ArrayList <String>();
			meanings.add("plant");
			theWords.put(key, meanings);
			
			key = "tremble";
			meanings = new ArrayList <String>();
			meanings.add("quiver");
			theWords.put(key, meanings);
			
			key = "trench";
			meanings = new ArrayList <String>();
			meanings.add("ditch");
			theWords.put(key, meanings);
			
			key = "trend";
			meanings = new ArrayList <String>();
			meanings.add("fashion");
			theWords.put(key, meanings);
			
			key = "trent";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "tress";
			meanings = new ArrayList <String>();
			meanings.add("lock");
			meanings.add("hair");
			theWords.put(key, meanings);
			
			key = "trestle";
			meanings = new ArrayList <String>();
			meanings.add("table support");
			theWords.put(key, meanings);
			
			key = "trevi";
			meanings = new ArrayList <String>();
			meanings.add("fountain");
			theWords.put(key, meanings);
			
			key = "triangle";
			meanings = new ArrayList <String>();
			meanings.add("shape");
			theWords.put(key, meanings);
			
			key = "trial";
			meanings = new ArrayList <String>();
			meanings.add("court case");
			theWords.put(key, meanings);
			
			key = "tribal";
			meanings = new ArrayList <String>();
			meanings.add("clannish");
			theWords.put(key, meanings);
			
			key = "tribe";
			meanings = new ArrayList <String>();
			meanings.add("clan");
			theWords.put(key, meanings);
			
			key = "tribunal";
			meanings = new ArrayList <String>();
			meanings.add("court");
			theWords.put(key, meanings);
			
			key = "tried";
			meanings = new ArrayList <String>();
			meanings.add("attempted");
			theWords.put(key, meanings);
			
			key = "tries";
			meanings = new ArrayList <String>();
			meanings.add("attempts");
			theWords.put(key, meanings);
					
			key = "trilby";
			meanings = new ArrayList <String>();
			meanings.add("hat");
			theWords.put(key, meanings);
			
			key = "trill";
			meanings = new ArrayList <String>();
			meanings.add("birdsong");
			theWords.put(key, meanings);
			
			key = "trim";
			meanings = new ArrayList <String>();
			meanings.add("clip");
			meanings.add("cut");
			meanings.add("shorten");
			theWords.put(key, meanings);
			
			key = "trimester";
			meanings = new ArrayList <String>();
			meanings.add("part of academic year");
			meanings.add("period of study");
			meanings.add("period of time");
			meanings.add("three months");
			theWords.put(key, meanings);
			
			key = "trio";
			meanings = new ArrayList <String>();
			meanings.add("small group");
			meanings.add("threesome");
			theWords.put(key, meanings);
			
			key = "trios";
			meanings = new ArrayList <String>();
			meanings.add("musicians");
			meanings.add("threesomes");
			theWords.put(key, meanings);
			
			key = "trip";
			meanings = new ArrayList <String>();
			meanings.add("fall over");
			meanings.add("journey");
			meanings.add("voyage");
			theWords.put(key, meanings);
			
			key = "tripe";
			meanings = new ArrayList <String>();
			meanings.add("food");
			meanings.add("rubbish");
			theWords.put(key, meanings);
			
			key = "triplet";
			meanings = new ArrayList <String>();
			meanings.add("one of three");
			theWords.put(key, meanings);
			
			key = "tripoli";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			theWords.put(key, meanings);
			
			key = "troopers";
			meanings = new ArrayList <String>();
			meanings.add("cavalrymen");
			theWords.put(key, meanings);
			
			key = "troll";
			meanings = new ArrayList <String>();
			meanings.add("abusive surfer");
			meanings.add("internet commenter");
			theWords.put(key, meanings);
			
			key = "trove";
			meanings = new ArrayList <String>();
			meanings.add("collection of objects");
			theWords.put(key, meanings);
			
			key = "troy";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "true";
			meanings = new ArrayList <String>();
			meanings.add("faithful");
			theWords.put(key, meanings);
		
			key = "trust";
			meanings = new ArrayList <String>();
			meanings.add("charitable organisation");
			theWords.put(key, meanings);
			
			key = "try";
			meanings = new ArrayList <String>();
			meanings.add("attempt");
			meanings.add("make an effort");
			meanings.add("vex");
			theWords.put(key, meanings);
			
			key = "tryolean";
			meanings = new ArrayList <String>();
			meanings.add("austrian");
			theWords.put(key, meanings);
			
			key = "tryst";
			meanings = new ArrayList <String>();
			meanings.add("meeting");
			theWords.put(key, meanings);
			
			key = "tsarina";
			meanings = new ArrayList <String>();
			meanings.add("russian princess");
			theWords.put(key, meanings);
			
			key = "tub";
			meanings = new ArrayList <String>();
			meanings.add("large plant container");
			theWords.put(key, meanings);
			
			key = "tug";
			meanings = new ArrayList <String>();
			meanings.add("pull");
			theWords.put(key, meanings);
			
			key = "tulip";
			meanings = new ArrayList <String>();
			meanings.add("bulb");
			theWords.put(key, meanings);
			
			key = "tum";
			meanings = new ArrayList <String>();
			meanings.add("stomach");
			theWords.put(key, meanings);
			
			key = "tun";
			meanings = new ArrayList <String>();
			meanings.add("cask");
			meanings.add("large cask");
			theWords.put(key, meanings);
					
			key = "tuna";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "tune";
			meanings = new ArrayList <String>();
			meanings.add("melody");
			meanings.add("piece of music");
			theWords.put(key, meanings);
			
			key = "tunic";
			meanings = new ArrayList <String>();
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "turn";
			meanings = new ArrayList <String>();
			meanings.add("go");
			theWords.put(key, meanings);
			
			key = "tuscan";
			meanings = new ArrayList <String>();
			meanings.add("Italian");
			theWords.put(key, meanings);
			
			key = "tuscany";
			meanings = new ArrayList <String>();
			meanings.add("Italian region");
			theWords.put(key, meanings);
			
			key = "tweak";
			meanings = new ArrayList <String>();
			meanings.add("pinch");
			theWords.put(key, meanings);
			
			key = "twaddle";
			meanings = new ArrayList <String>();
			meanings.add("rubbish");
			theWords.put(key, meanings);
			
			key = "twee";
			meanings = new ArrayList <String>();
			meanings.add("cute");
			theWords.put(key, meanings);
			
			key = "tweed";
			meanings = new ArrayList <String>();
			meanings.add("fabric");
			theWords.put(key, meanings);
			
			key = "twix";
			meanings = new ArrayList <String>();
			meanings.add("chocolate bar");
			theWords.put(key, meanings);
			
			key = "type";
			meanings = new ArrayList <String>();
			meanings.add("sort");
			meanings.add("use a keyboard");
			theWords.put(key, meanings);
			
			key = "tyre";
			meanings = new ArrayList <String>();
			meanings.add("cover");
			theWords.put(key, meanings);

			return theWords;
		}//end loadTWords
		
		public void loadUWords() {
			String key;
			ArrayList <String> meanings;
			
			//load u's
			key = "um";
			meanings = new ArrayList <String>();
			meanings.add("hesitation");
			theWords.put(key, meanings);
			
			key = "umbria";
			meanings = new ArrayList <String>();
			meanings.add("somewhere in Italy");
			theWords.put(key, meanings);
			
			key = "una";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			theWords.put(key, meanings);
			
			key = "unclassified";
			meanings = new ArrayList <String>();
			meanings.add("in no particular order");
			theWords.put(key, meanings);
			
			key = "uncle";
			meanings = new ArrayList <String>();
			meanings.add("family member");
			meanings.add("relative");
			theWords.put(key, meanings);

			key = "unclean";
			meanings = new ArrayList <String>();
			meanings.add("impure");
			theWords.put(key, meanings);
			
			key = "unclear";
			meanings = new ArrayList <String>();
			meanings.add("ambiguous");
			theWords.put(key, meanings);
			
			key = "undid";
			meanings = new ArrayList <String>();
			meanings.add("reversed");
			theWords.put(key, meanings);
			
			key = "undoubted";
			meanings = new ArrayList <String>();
			meanings.add("certain");
			theWords.put(key, meanings);
			
			key = "unfed";
			meanings = new ArrayList <String>();
			meanings.add("nothing to eat");
			theWords.put(key, meanings);
			
			key = "unfortunate";
			meanings = new ArrayList <String>();
			meanings.add("luckless");
			theWords.put(key, meanings);
			
			key = "unicorn";
			meanings = new ArrayList <String>();
			meanings.add("fabulous creature");
			theWords.put(key, meanings);
			
			key = "unicycle";
			meanings = new ArrayList <String>();
			meanings.add("form of transport");
			theWords.put(key, meanings);
			
			key = "unified";
			meanings = new ArrayList <String>();
			meanings.add("together");
			theWords.put(key, meanings);
			
			key = "union";
			meanings = new ArrayList <String>();
			meanings.add("association");
			theWords.put(key, meanings);
			
			key = "unit";
			meanings = new ArrayList <String>();
			meanings.add("kitchen fitment");
			theWords.put(key, meanings);
			
			key = "unite";
			meanings = new ArrayList <String>();
			meanings.add("join");
			theWords.put(key, meanings);
			
			key = "united";
			meanings = new ArrayList <String>();
			meanings.add("joined");
			theWords.put(key, meanings);
			
			key = "universe";
			meanings = new ArrayList <String>();
			meanings.add("everything");
			theWords.put(key, meanings);
			
			key = "unlatch";
			meanings = new ArrayList <String>();
			meanings.add("open gate");
			theWords.put(key, meanings);
			
			key = "untied";
			meanings = new ArrayList <String>();
			meanings.add("freed from");
			theWords.put(key, meanings);
			
			key = "unveiled";
			meanings = new ArrayList <String>();
			meanings.add("exposed to public view");
			theWords.put(key, meanings);
			
			key = "unwell";
			meanings = new ArrayList <String>();
			meanings.add("sick");
			theWords.put(key, meanings);
			
			key = "up";
			meanings = new ArrayList <String>();
			meanings.add("out of bed");
			meanings.add("promoted");
			theWords.put(key, meanings);
			
			key = "upheaval";
			meanings = new ArrayList <String>();
			meanings.add("disturbance");
			theWords.put(key, meanings);
			
			key = "uplighter";
			meanings = new ArrayList <String>();
			meanings.add("lamp");
			theWords.put(key, meanings);
			
			key = "upper";
			meanings = new ArrayList <String>();
			meanings.add("part of shoe");
			theWords.put(key, meanings);
			
			key = "uppercut";
			meanings = new ArrayList <String>();
			meanings.add("punch");
			theWords.put(key, meanings);
			
			key = "uppermost";
			meanings = new ArrayList <String>();
			meanings.add("top");
			theWords.put(key, meanings);
			
			key = "upon";
			meanings = new ArrayList <String>();
			meanings.add("very soon after");
			theWords.put(key, meanings);
			
			key = "urals";
			meanings = new ArrayList <String>();
			meanings.add("mountain range");
			theWords.put(key, meanings);
			
			key = "ur";
			meanings = new ArrayList <String>();
			meanings.add("old city");
			theWords.put(key, meanings);
			
			key = "ure";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "urgent";
			meanings = new ArrayList <String>();
			meanings.add("requires immediate attention");
			theWords.put(key, meanings);
			
			key = "us";
			meanings = new ArrayList <String>();
			meanings.add("me and you");
			theWords.put(key, meanings);
			
			key = "used";
			meanings = new ArrayList <String>();
			meanings.add("employed");
			meanings.add("being exploited");
			theWords.put(key, meanings);
			
			key = "user";
			meanings = new ArrayList <String>();
			meanings.add("employer");
			theWords.put(key, meanings);
			
			key = "uses";
			meanings = new ArrayList <String>();
			meanings.add("employs");
			theWords.put(key, meanings);
			
			key = "using";
			meanings = new ArrayList <String>();
			meanings.add("being exploitative");
			theWords.put(key, meanings);
			
			key = "usk";
			meanings = new ArrayList <String>();
			meanings.add("river");
			theWords.put(key, meanings);
			
			key = "usurer";
			meanings = new ArrayList <String>();
			meanings.add("loan shark");
			theWords.put(key, meanings);
					
			key = "utilised";
			meanings = new ArrayList <String>();
			meanings.add("used");
			theWords.put(key, meanings);
			
			key = "utter";
			meanings = new ArrayList <String>();
			meanings.add("speak");
			theWords.put(key, meanings);
			
			key = "utterly";
			meanings = new ArrayList <String>();
			meanings.add("completely");
			theWords.put(key, meanings);

		}// end loadUWords
		
		public void loadVWords() {
			String key;
			ArrayList <String> meanings;
			
			//load v's
			key = "vain";
			meanings = new ArrayList <String>();
			meanings.add("conceited");
			theWords.put(key, meanings);
			
			key = "val";
			meanings = new ArrayList <String>();
			meanings.add("girl");
			meanings.add("little girl");
			theWords.put(key, meanings);
			
			key = "vale";
			meanings = new ArrayList <String>();
			meanings.add("glen");
			theWords.put(key, meanings);
			
			key = "valerie";
			meanings = new ArrayList <String>();
			meanings.add("girl's name");
			theWords.put(key, meanings);
			
			key = "valise";
			meanings = new ArrayList <String>();
			meanings.add("travelling bag");
			theWords.put(key, meanings);
			
			key = "van";
			meanings = new ArrayList <String>();
			meanings.add("vehicle");
			theWords.put(key, meanings);
			
			key = "varied";
			meanings = new ArrayList <String>();
			meanings.add("not the same");
			theWords.put(key, meanings);
			
			key = "varies";
			meanings = new ArrayList <String>();
			meanings.add("changes");
			theWords.put(key, meanings);
			
			key = "vase";
			meanings = new ArrayList <String>();
			meanings.add("container");
			theWords.put(key, meanings);
			
			key = "vassal";
			meanings = new ArrayList <String>();
			meanings.add("subordinate");
			theWords.put(key, meanings);
			
			key = "veal";
			meanings = new ArrayList <String>();
			meanings.add("meat");
			theWords.put(key, meanings);
			
			key = "veils";
			meanings = new ArrayList <String>();
			meanings.add("conceals");
			theWords.put(key, meanings);
			
			key = "veleta";
			meanings = new ArrayList <String>();
			meanings.add("dance");
			theWords.put(key, meanings);
			
			key = "ventilation";
			meanings = new ArrayList <String>();
			meanings.add("air circulating");
			theWords.put(key, meanings);
			
			key = "venue";
			meanings = new ArrayList <String>();
			meanings.add("meeting place");
			theWords.put(key, meanings);
			
			key = "vera";
			meanings = new ArrayList <String>();
			meanings.add("woman");
			theWords.put(key, meanings);
			
			key = "veracity";
			meanings = new ArrayList <String>();
			meanings.add("truth");
			theWords.put(key, meanings);
			
			key = "verbose";
			meanings = new ArrayList <String>();
			meanings.add("wordy");
			theWords.put(key, meanings);
			
			key = "verdi";
			meanings = new ArrayList <String>();
			meanings.add("composer");
			theWords.put(key, meanings);
			
			key = "vermouth";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "versatile";
			meanings = new ArrayList <String>();
			meanings.add("adaptable");
			theWords.put(key, meanings);
			
			key = "verse";
			meanings = new ArrayList <String>();
			meanings.add("piece of poetry");
			meanings.add("poetry");
			theWords.put(key, meanings);
			
			key = "versions";
			meanings = new ArrayList <String>();
			meanings.add("sorts");
			theWords.put(key, meanings);
			
			key = "vert";
			meanings = new ArrayList <String>();
			meanings.add("French green");
			theWords.put(key, meanings);
			
			key = "very";
			meanings = new ArrayList <String>();
			meanings.add("extremely");
			theWords.put(key, meanings);
			
			key = "vest";
			meanings = new ArrayList <String>();
			meanings.add("garment");
			theWords.put(key, meanings);
			
			key = "vestry";
			meanings = new ArrayList <String>();
			meanings.add("changing room");
			theWords.put(key, meanings);
			
			key = "vet";
			meanings = new ArrayList <String>();
			meanings.add("animal doctor");
			theWords.put(key, meanings);
			
			key = "veto";
			meanings = new ArrayList <String>();
			meanings.add("ban");
			meanings.add("don't allow");
			meanings.add("refuse");
			theWords.put(key, meanings);
			
			key = "vets";
			meanings = new ArrayList <String>();
			meanings.add("assesses");
			theWords.put(key, meanings);
			
			key = "vex";
			meanings = new ArrayList <String>();
			meanings.add("annoy");
			theWords.put(key, meanings);
			
			key = "via";
			meanings = new ArrayList <String>();
			meanings.add("by way of");
			theWords.put(key, meanings);
			
			key = "viable";
			meanings = new ArrayList <String>();
			meanings.add("feasible");
			theWords.put(key, meanings);
			
			key = "vice";
			meanings = new ArrayList <String>();
			meanings.add("bad habit");
			theWords.put(key, meanings);
			
			key = "victoria";
			meanings = new ArrayList <String>();
			meanings.add("queen");
			theWords.put(key, meanings);
			
			key = "vie";
			meanings = new ArrayList <String>();
			meanings.add("compete eagerly");
			theWords.put(key, meanings);
			
			key = "vienna";
			meanings = new ArrayList <String>();
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "vietnam";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "villa";
			meanings = new ArrayList <String>();
			meanings.add("house");
			theWords.put(key, meanings);
			
			key = "village";
			meanings = new ArrayList <String>();
			meanings.add("small town");
			theWords.put(key, meanings);
			
			key = "villain";
			meanings = new ArrayList <String>();
			meanings.add("rogue");
			theWords.put(key, meanings);
			
			key = "villainy";
			meanings = new ArrayList <String>();
			meanings.add("evil goings on");
			theWords.put(key, meanings);

			key = "vin";
			meanings = new ArrayList <String>();
			meanings.add("French wine");
			theWords.put(key, meanings);
			
			key = "vinegar";
			meanings = new ArrayList <String>();
			meanings.add("it's sour");
			theWords.put(key, meanings);
			
			key = "violin";
			meanings = new ArrayList <String>();
			meanings.add("instrument");
			theWords.put(key, meanings);
			
			key = "visa";
			meanings = new ArrayList <String>();
			meanings.add("permit");
			theWords.put(key, meanings);
			
			key = "visor";
			meanings = new ArrayList <String>();
			meanings.add("shield");
			theWords.put(key, meanings);
			
			key = "vital";
			meanings = new ArrayList <String>();
			meanings.add("essential");
			theWords.put(key, meanings);
					
			key = "void";
			meanings = new ArrayList <String>();
			meanings.add("not valid");
			theWords.put(key, meanings);
			
			key = "vote";
			meanings = new ArrayList <String>();
			meanings.add("elect");
			theWords.put(key, meanings);
			
			key = "voter";
			meanings = new ArrayList <String>();
			meanings.add("elector");
			theWords.put(key, meanings);

		}// end loadVWords
		
		public void loadWWords() {
			String key;
			ArrayList <String> meanings;
			
			//load w's
			key = "wacko";
			meanings = new ArrayList <String>();
			meanings.add("crazy person");
			meanings.add("insane");
			meanings.add("mad");
			theWords.put(key, meanings);
			
			key = "waddle";
			meanings = new ArrayList <String>();
			meanings.add("walk unsteadily");
			theWords.put(key, meanings);
			
			key = "wag";
			meanings = new ArrayList <String>();
			meanings.add("joker");
			meanings.add("play truant");
			meanings.add("shake");
			theWords.put(key, meanings);
			
			key = "wage";
			meanings = new ArrayList <String>();
			meanings.add("money earned");
			theWords.put(key, meanings);
			
			key = "wager";
			meanings = new ArrayList <String>();
			meanings.add("bet");
			theWords.put(key, meanings);
			
			key = "wagger";
			meanings = new ArrayList <String>();
			meanings.add("dog's tail");
			theWords.put(key, meanings);
					
			key = "wagner";
			meanings = new ArrayList <String>();
			meanings.add("composer");
			theWords.put(key, meanings);
			
			key = "wales";
			meanings = new ArrayList <String>();
			meanings.add("country");
			theWords.put(key, meanings);
			
			key = "walk";
			meanings = new ArrayList <String>();
			meanings.add("march");
			theWords.put(key, meanings);
			
			key = "walking";
			meanings = new ArrayList <String>();
			meanings.add("on foot");
			theWords.put(key, meanings);
			
			key = "wall";
			meanings = new ArrayList <String>();
			meanings.add("barrier");
			theWords.put(key, meanings);
			
			key = "wallet";
			meanings = new ArrayList <String>();
			meanings.add("purse");
			theWords.put(key, meanings);
			
			key = "walnut";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			theWords.put(key, meanings);
			
			key = "walrus";
			meanings = new ArrayList <String>();
			meanings.add("creature");
			theWords.put(key, meanings);
			
			key = "wand";
			meanings = new ArrayList <String>();
			meanings.add("stick");
			theWords.put(key, meanings);
			
			key = "want";
			meanings = new ArrayList <String>();
			meanings.add("desire");
			theWords.put(key, meanings);
			
			key = "wants";
			meanings = new ArrayList <String>();
			meanings.add("desires");
			theWords.put(key, meanings);
			
			key = "war";
			meanings = new ArrayList <String>();
			meanings.add("conflict");
			theWords.put(key, meanings);
			
			key = "wards";
			meanings = new ArrayList <String>();
			meanings.add("hospital units");
			theWords.put(key, meanings);
			
			key = "warranty";
			meanings = new ArrayList <String>();
			meanings.add("car guarantee");
			theWords.put(key, meanings);
			
			key = "warsaw";
			meanings = new ArrayList <String>();
			meanings.add("capital");
			meanings.add("city");
			theWords.put(key, meanings);
			
			key = "warty";
			meanings = new ArrayList <String>();
			meanings.add("like a toad");
			theWords.put(key, meanings);
			
			key = "was";
			meanings = new ArrayList <String>();
			meanings.add("used to be");
			theWords.put(key, meanings);
			
			key = "wash";
			meanings = new ArrayList <String>();
			meanings.add("have a bath");
			meanings.add("laundry");
			theWords.put(key, meanings);
			
			key = "wasps";
			meanings = new ArrayList <String>();
			meanings.add("insects");
			theWords.put(key, meanings);
					
			key = "wash";
			meanings = new ArrayList <String>();
			meanings.add("laundry");
			theWords.put(key, meanings);
			
			key = "wash";
			meanings = new ArrayList <String>();
			meanings.add("laundry");
			theWords.put(key, meanings);
			
			key = "wastes";
			meanings = new ArrayList <String>();
			meanings.add("squanders");
			theWords.put(key, meanings);
					
			key = "watch";
			meanings = new ArrayList <String>();
			meanings.add("keep an eye on");
			meanings.add("observe");
			meanings.add("timekeeper");
			theWords.put(key, meanings);
			
			key = "watchdog";
			meanings = new ArrayList <String>();
			meanings.add("monitoring organisation");
			theWords.put(key, meanings);
			
			key = "way";
			meanings = new ArrayList <String>();
			meanings.add("route");
			meanings.add("method");
			meanings.add("mode");
			meanings.add("habitual manner");
			theWords.put(key, meanings);
			
			key = "wayout"; //way out
			meanings = new ArrayList <String>();
			meanings.add("exit");
			meanings.add("extremelly unconventional");
			meanings.add("far from correct");
			theWords.put(key, meanings);
			
			key = "ways";
			meanings = new ArrayList <String>();
			meanings.add("routes");
			meanings.add("methods");
			meanings.add("modes");
			meanings.add("habitual manners");
			theWords.put(key, meanings);
			
			key = "we";
			meanings = new ArrayList <String>();
			meanings.add("us");
			meanings.add("you and I");
			theWords.put(key, meanings);
			
			key = "weak";
			meanings = new ArrayList <String>();
			meanings.add("frail");
			theWords.put(key, meanings);
			
			key = "weapon";
			meanings = new ArrayList <String>();
			meanings.add("harmful device");
			meanings.add("gun");
			theWords.put(key, meanings);
			
			key = "wear";
			meanings = new ArrayList <String>();
			meanings.add("sport");
			theWords.put(key, meanings);
			
			key = "weaver";
			meanings = new ArrayList <String>();
			meanings.add("craftsman");
			theWords.put(key, meanings);
			
			key = "web";
			meanings = new ArrayList <String>();
			meanings.add("network");
			theWords.put(key, meanings);
			
			key = "wed";
			meanings = new ArrayList <String>();
			meanings.add("married");
			theWords.put(key, meanings);
			
			key = "wee";
			meanings = new ArrayList <String>();
			meanings.add("little");
			meanings.add("small");
			meanings.add("very small");
			theWords.put(key, meanings);
			
			key = "weed";
			meanings = new ArrayList <String>();
			meanings.add("wimp");
			theWords.put(key, meanings);
			
			key = "weeping";
			meanings = new ArrayList <String>();
			meanings.add("crying");
			theWords.put(key, meanings);
			
			key = "weevil";
			meanings = new ArrayList <String>();
			meanings.add("beetle");
			theWords.put(key, meanings);
			
			key = "well";
			meanings = new ArrayList <String>();
			meanings.add("healthy");
			meanings.add("source of water");
			theWords.put(key, meanings);
			
			key = "wells";
			meanings = new ArrayList <String>();
			meanings.add("science fiction writer");
			theWords.put(key, meanings);
			
			key = "welsh";
			meanings = new ArrayList <String>();
			meanings.add("from part of Britain");
			theWords.put(key, meanings);
			
			key = "were";
			meanings = new ArrayList <String>();
			meanings.add("used to be");
			theWords.put(key, meanings);
			
			key = "wheel";
			meanings = new ArrayList <String>();
			meanings.add("very early invention");
			theWords.put(key, meanings);
			
			key = "white";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			theWords.put(key, meanings);
			
			key = "whiting";
			meanings = new ArrayList <String>();
			meanings.add("fish");
			theWords.put(key, meanings);
			
			key = "whole";
			meanings = new ArrayList <String>();
			meanings.add("complete");
			theWords.put(key, meanings);
			
			key = "winning";
			meanings = new ArrayList <String>();
			meanings.add("successful");
			meanings.add("triumphant");
			meanings.add("victorious");
			theWords.put(key, meanings);
			
			key = "wired";
			meanings = new ArrayList <String>();
			meanings.add("edgy");
			theWords.put(key, meanings);
			
			key = "wish";
			meanings = new ArrayList <String>();
			meanings.add("desire");
			theWords.put(key, meanings);
			
			key = "with";
			meanings = new ArrayList <String>();
			meanings.add("accompanying");
			theWords.put(key, meanings);
			
			key = "wild";
			meanings = new ArrayList <String>();
			meanings.add("not domesticated");
			meanings.add("raving");
			theWords.put(key, meanings);
			
			key = "wilde";
			meanings = new ArrayList <String>();
			meanings.add("playwright");
			theWords.put(key, meanings);
			
			key = "wilderness";
			meanings = new ArrayList <String>();
			meanings.add("badlands");
			theWords.put(key, meanings);
			
			key = "will";
			meanings = new ArrayList <String>();
			meanings.add("resolve");
			theWords.put(key, meanings);
			
			key = "win";
			meanings = new ArrayList <String>();
			meanings.add("success");
			meanings.add("victory");
			theWords.put(key, meanings);
			
			key = "windfall";
			meanings = new ArrayList <String>();
			meanings.add("a bit of good fortune");
			theWords.put(key, meanings);
			
			key = "wine";
			meanings = new ArrayList <String>();
			meanings.add("drink");
			theWords.put(key, meanings);
			
			key = "wing";
			meanings = new ArrayList <String>();
			meanings.add("limb");
			theWords.put(key, meanings);
			
			key = "winter";
			meanings = new ArrayList <String>();
			meanings.add("season");
			theWords.put(key, meanings);
			
			key = "wintry";
			meanings = new ArrayList <String>();
			meanings.add("cold and frosty");
			theWords.put(key, meanings);
			
			key = "witch";
			meanings = new ArrayList <String>();
			meanings.add("sorceress");
			theWords.put(key, meanings);
			
			key = "women";
			meanings = new ArrayList <String>();
			meanings.add("females");
			meanings.add("ladies");
			theWords.put(key, meanings);
			
			key = "won";
			meanings = new ArrayList <String>();
			meanings.add("having been victorious");
			theWords.put(key, meanings);
			
			key = "wonderful";
			meanings = new ArrayList <String>();
			meanings.add("marvellous");
			theWords.put(key, meanings);
			
			key = "wool";
			meanings = new ArrayList <String>();
			meanings.add("material");
			theWords.put(key, meanings);
			
			key = "woollies";
			meanings = new ArrayList <String>();
			meanings.add("warm clothes");
			theWords.put(key, meanings);
			
			key = "worth";
			meanings = new ArrayList <String>();
			meanings.add("value");
			theWords.put(key, meanings);
			
			key = "writ";
			meanings = new ArrayList <String>();
			meanings.add("court order");
			meanings.add("legal document");
			theWords.put(key, meanings);
				
			key = "write";
			meanings = new ArrayList <String>();
			meanings.add("correspond");
			theWords.put(key, meanings);
			
			key = "writhe";
			meanings = new ArrayList <String>();
			meanings.add("squirm");
			theWords.put(key, meanings);
			
			key = "written";
			meanings = new ArrayList <String>();
			meanings.add("composed");
			theWords.put(key, meanings);
			
			key = "wrote";
			meanings = new ArrayList <String>();
			meanings.add("scribed");
			theWords.put(key, meanings);

		}// end loadWWords
		
		public void loadXWords() {
			String key;
			ArrayList <String> meanings;
			
			
		}
		
		public TreeMap<String, ArrayList<String>> loadYWords() {TreeMap <String, ArrayList<String>> theWords = new TreeMap<String, ArrayList<String>>();
			String key;
			ArrayList <String> meanings;
			
			//load y's
			key = "yard";
			meanings = new ArrayList <String>();
			meanings.add("garden");
			meanings.add("three feet");
			theWords.put(key, meanings);
					
			key = "ye";
			meanings = new ArrayList <String>();
			meanings.add("you");
			theWords.put(key, meanings);
			
			key = "year";
			meanings = new ArrayList <String>();
			meanings.add("period");
			meanings.add("time");
			theWords.put(key, meanings);
			
			key = "yearn";
			meanings = new ArrayList <String>();
			meanings.add("long");
			theWords.put(key, meanings);
			
			key = "yearned";
			meanings = new ArrayList <String>();
			meanings.add("longed");
			theWords.put(key, meanings);
			
			key = "yearns";
			meanings = new ArrayList <String>();
			meanings.add("longs for");
			theWords.put(key, meanings);
			
			key = "yeast";
			meanings = new ArrayList <String>();
			meanings.add("raising agent");
			theWords.put(key, meanings);
			
			key = "yellow";
			meanings = new ArrayList <String>();
			meanings.add("colour");
			theWords.put(key, meanings);
			
			key = "yes";
			meanings = new ArrayList <String>();
			meanings.add("ok");
			theWords.put(key, meanings);
			
			key = "yet";
			meanings = new ArrayList <String>();
			meanings.add("nevertheless");
			meanings.add("thus far");
			theWords.put(key, meanings);
			
			key = "yeti";
			meanings = new ArrayList <String>();
			meanings.add("bigfoot");
			theWords.put(key, meanings);
			
			key = "yield";
			meanings = new ArrayList <String>();
			meanings.add("harvest");
			theWords.put(key, meanings);
			
			key = "yokel";
			meanings = new ArrayList <String>();
			meanings.add("bumpkin");
			theWords.put(key, meanings);
			
			key = "yon";
			meanings = new ArrayList <String>();
			meanings.add("over there");
			theWords.put(key, meanings);
			
			key = "yonder";
			meanings = new ArrayList <String>();
			meanings.add("over there");
			theWords.put(key, meanings);
			
			key = "yorkshire";
			meanings = new ArrayList <String>();
			meanings.add("county");
			theWords.put(key, meanings);
			
			key = "you";
			meanings = new ArrayList <String>();
			meanings.add("thee");
			theWords.put(key, meanings);
			
			key = "youth";
			meanings = new ArrayList <String>();
			meanings.add("young");
			theWords.put(key, meanings);
			
			System.out.println("thewords size: "+theWords.keySet().size());
			
			return theWords;
		}// end loadYWords
		
		public void loadZWords() {
			String key;
			ArrayList <String> meanings;
			
			//load z's
			key = "zealot";
			meanings = new ArrayList <String>();
			meanings.add("fanatic");
			theWords.put(key, meanings);
			
			key = "zen";
			meanings = new ArrayList <String>();
			meanings.add("Buddhist faith");
			theWords.put(key, meanings);
			
			key = "zero";
			meanings = new ArrayList <String>();
			meanings.add("nothing");
			theWords.put(key, meanings);
			
			key = "zest";
			meanings = new ArrayList <String>();
			meanings.add("enthusiasm");
			theWords.put(key, meanings);
			
			key = "zeus";
			meanings = new ArrayList <String>();
			meanings.add("Greek god");
			theWords.put(key, meanings);
			
			key = "zing";
			meanings = new ArrayList <String>();
			meanings.add("zest");
			theWords.put(key, meanings);
			
			
		}
		
	}//end class



