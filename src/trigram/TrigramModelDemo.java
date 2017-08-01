package trigram;

import bigram.BigramModel;

public class TrigramModelDemo {
	public static void main(String[] args) {
		TrigramModel trm = new TrigramModel();
				
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
		
		//trm.perplexityOf("I am sam");
		//trm.perplexityOf("like green eggs");
		//trm.perplexityOf("like red eggs");
		
		//trm.perplexityOf("Jeremy Corbyn");
		//trm.perplexityOf("Jeremy Corbin");
		trm.perplexityOf("Jeremy Corbyn is the new Labour party leader");
		trm.perplexityOf("Jeremy Corbyn decided to immigrate to the USA");
		trm.perplexityOf("bananas cream bananas cream");
		System.out.println(trm.numberOfWords + " total number of words");
		
		
		trm.perplexityOf("Start campbell wood for money");
		trm.perplexityOf("Start cashpoint wood for money");
		trm.perplexityOf("Start cos wood for money");
		trm.perplexityOf("Start clintons wood for money");
		trm.perplexityOf("Start cant wood for money");
		trm.perplexityOf("Start cut wood for money");
		trm.perplexityOf("Start clare wood for money");
		trm.perplexityOf("Start confession wood for money");
		trm.perplexityOf("Start community wood for money");
		trm.perplexityOf("Start come wood for money");
		trm.perplexityOf("Start chopping wood for money");
		trm.perplexityOf("Start coming wood for money");
		trm.perplexityOf("Start costing wood for money");
		System.out.println("\n\n --------------\n\n");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		trm.perplexityOf("Start wood for money");
		
		/*trm.perplexityOf("Row about head of got cat");
		trm.perplexityOf("Row about head of go cat");
		trm.perplexityOf("Row about head of girlfriend cat");
		trm.perplexityOf("Row about head of gonna cat");
		trm.perplexityOf("Row about head of goes cat");
		trm.perplexityOf("Row about head of greenwood cat");
		trm.perplexityOf("Row about head of guilty cat");
		trm.perplexityOf("Row about head of giant cat");
		trm.perplexityOf("Row about head of gift cat");
		trm.perplexityOf("Row about head of ghostly cat");
		trm.perplexityOf("Row about head of ginger cat");
		trm.perplexityOf("Row about head of garden cat");
		trm.perplexityOf("Row about head of great cat");*/
		

	}

}
